(function($) {
    "use strict";

    // jQuery for page scrolling feature - requires jQuery Easing plugin
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: ($($anchor.attr('href')).offset().top - 50)
        }, 1250, 'easeInOutExpo');
        event.preventDefault();
    });

    // Highlight the top nav as scrolling occurs
    $('body').scrollspy({
        target: '.navbar-fixed-top',
        offset: 51
    });

    // Offset for Main Navigation
    $('#mainNav').affix({
        offset: {
            top: 100
        }
    });

    // Initialize WOW.js Scrolling Animations
    new WOW().init();

//	$.ajaxSetup({
//		beforeSend: function(xhr, settings) {
//			if (settings.type == 'POST' || settings.type == 'PUT' || settings.type == 'DELETE') {
//				if (!(/^http:.*/.test(settings.url) || /^https:.*/.test(settings.url))) {
//					// Only send the token to relative URLs i.e. locally.
//					xhr.setRequestHeader("X-XSRF-TOKEN", Cookies.get('XSRF-TOKEN'));
//				}
//			}
//		}
//	});

    var predictionMode = window.location.href.indexOf('/predict') > -1 ? true : false;
    var predictionApiPrefix = predictionMode ? 'predictions/' : '';
    var matchesMode = window.location.href.indexOf('/matches') > -1 ? true : false;

    $.get('/user', function(data) {
        $('.navbar .btn-login').hide();
        $('.navbar .btn-predict').show();
        $('.navbar .btn-user').show();
        $('.navbar .btn-user').append($([
            '<a>',
                '<img class="user-avatar" src="' + data.photo + '" style="width: 25px;">',
                '<span>', data.fullName, '</span>',
            '</a>'
        ].join('')));
        $('.navbar .btn-logout').show();

        if ( !matchesMode ) {
            populateContent();
        }
    }).fail(function() {
        $('.navbar .btn-login').show();
        $('.navbar .btn-predict').hide();
        $('.navbar .btn-user').hide();
        $('.navbar .btn-user').empty();
        $('.navbar .btn-logout').hide();

        if ( !matchesMode ) {
            populateContent();
        }
    });

    $('.btn-logout').click(function(e) {
        e.preventDefault();
        $.post('/logout', function(data) {
            window.location.href = "/";
        });
    });

    var populateTab = function(key, value) {
        var active = key == 0 ? ' active' : '';

        // group tabs
        $('.group-tabs').append($([
            '<li class="nav-item' + active + '">',
                '<a class="nav-link' + active + '" data-toggle="tab" href="#' + value.uuid + '" role="tab">Group ' + value.name + '</a>',
            '</li>'
        ].join('')));
    };

    var populateTabContent = function(key, value) {
        var active = key == 0 ? ' in active' : '';

        // group tab's content
        $('.group-tabs-content').append($([
            '<div class="tab-pane fade' + active + '" id="' + value.uuid + '" role="tabpanel">',
                '<br>',
                '<div class="row">',
                    '<div class="col-xs-12 col-md-6 group-matches">',
                        '<table class="table">',
                            '<thead>',
                                '<tr>',
                                    '<th class="match-time">&nbsp;</th>',
                                    '<th class="match-home">&nbsp;</th>',
                                    '<th class="match-result">&nbsp;</th>',
                                    '<th class="match-away">&nbsp;</th>',
                                '</tr>',
                            '</thead>',
                            '<tbody></tbody>',
                        '</table>',
                    '</div>',
                    '<div class="col-xs-12 col-md-6 group-standing">',
                        '<table class="table">',
                            '<thead>',
                                '<tr>',
                                    '<th class="narrow-column">#</th>',
                                    '<th>Team</th>',
                                    '<th class="narrow-column" title="Games">G</th>',
                                    '<th class="narrow-column" title="Wins">W</th>',
                                    '<th class="narrow-column" title="Draws">D</th>',
                                    '<th class="narrow-column" title="Loses">L</th>',
                                    '<th class="narrow-column" title="Goals For">GF</th>',
                                    '<th class="narrow-column" title="Goals Against">GA</th>',
                                    '<th class="narrow-column" title="Goals Difference">GD</th>',
                                    '<th class="narrow-column" title="Points">P</th>',
                                '</tr>',
                            '</thead>',
                            '<tbody></tbody>',
                        '</table>',
                    '</div>',
                '</div>',
            '</div>'
        ].join('')));
    };

    var populateStandings = function(key, value) {
        // group standing table
        $.each(value.standing, function(k, v) {
            $('.tab-pane#' + value.uuid + ' .group-standing .table tbody').append($([
                '<tr>',
                    '<th class="text-center" scope="row">' + (k+1) + '</th>',
                    '<td>', 
                        '<img src="' + v.team.country.flag + '" style="width: 20px; margin-right: 5px;" />', 
                        '<span>' + v.team.country.name + '</span>', 
                    '</td>',
                    '<td class="text-center">' + v.games + '</td>',
                    '<td class="text-center">' + v.wins + '</td>',
                    '<td class="text-center">' + v.draws + '</td>',
                    '<td class="text-center">' + v.loses + '</td>',
                    '<td class="text-center">' + v.goalsFor + '</td>',
                    '<td class="text-center">' + v.goalsAgainst + '</td>',
                    '<td class="text-center">' + v.goalsDiff + '</td>',
                    '<td class="text-center">' + v.points + '</td>',
                '</tr>'
            ].join('')));
        });
    };

    var populateGroupMatches = function(key, value) {
        $.get('/api/' + predictionApiPrefix + 'groups/' + value.uuid + '/matches', function(data) {
            // group standing table
            $.each(data, function(k, v) {
                $('.tab-pane#' + value.uuid + ' .group-matches .table tbody').append($([
                    '<tr>',
                        '<td class="match-time text-left">',
                            new Date(v.matchDate).toDateString(),
                            ' - ',
                            new Date(v.matchDate).toLocaleTimeString().replace(/:00 /, ' '),
                        '</td>',
                        '<td class="match-home text-right">', 
                            v.team1Goals != null && v.team2Goals != null && v.team1Goals > v.team2Goals ? '<b>' : '', 
                            '<span>' + v.team1.country.name + '</span>', 
                            '<img src="' + v.team1.country.flag + '" style="width: 20px; margin-left: 5px;" />', 
                            v.team1Goals != null && v.team2Goals != null && v.team1Goals > v.team2Goals ? '</b>' : '', 
                        '</td>',
                        '<td class="match-result text-center">',
                            predictionMode ? 
                            [
                                '<input class="team-goal-input team-goal-input-team1-goals prediction-match-' + v.number + '" data-match-team="team1-goals" data-match-number="' + v.number + '" type="text" />',
                                '-',
                                '<input class="team-goal-input team-goal-input-team2-goals prediction-match-' + v.number + '" data-match-team="team2-goals" data-match-number="' + v.number + '" type="text" />'
                            ].join('') :
                            v.team1Goals == null || v.team2Goals == null ? '-' : v.team1Goals + '-' + v.team2Goals,
                        '</td>',
                        '<td class="match-away text-left">', 
                            v.team1Goals != null && v.team2Goals != null && v.team2Goals > v.team1Goals ? '<b>' : '', 
                            '<img src="' + v.team2.country.flag + '" style="width: 20px; margin-right: 5px;" />', 
                            '<span>' + v.team2.country.name + '</span>', 
                            v.team1Goals != null && v.team2Goals != null && v.team2Goals > v.team1Goals ? '</b>' : '', 
                        '</td>',
                    '</tr>'
                ].join('')));
            });
        });
    };

    var populateContent = function() {
	    // populate groups
	    $.get('/api/' + predictionApiPrefix + 'groups', function(data) {
	        $.each(data, function(key, value) {
	            populateTab(key, value);
	            populateTabContent(key, value);
	            populateStandings(key, value);
	            populateGroupMatches(key, value);
	        });
	    }).then(function() {
	        var stages = [{
	            name: 'ROUND_SIXTEEN', 
	            cls: 'ko-sixteen'
	        }, {
	            name: 'QUARTER_FINALS', 
	            cls: 'ko-quarters'
	        }, {
	            name: 'SEMI_FINALS', 
	            cls: 'ko-semis'
	        }, {
	            name: 'PLAYOFF', 
	            cls: 'ko-playoff'
	        }, {
	            name: 'FINAL', 
	            cls: 'ko-final'
	        }];

	        $.each(stages, function(key, value) {
	            // populate KO stages
	            $.get('/api/' + predictionApiPrefix + 'matches?stage=' + value.name, function(data) {
	                $.each(data, function(k, v) {
	                    var team1Winner = false;
	                    var team2Winner = false;

	                    if ( v.team1Goals != null && v.team2Goals != null ) {
	                        if ( v.team1Goals == v.team2Goals ) {
	                            team1Winner = v.team1PenaltyGoals > v.team2PenaltyGoals;
	                            team2Winner = v.team2PenaltyGoals > v.team1PenaltyGoals;
	                        } else {
	                            team1Winner = v.team1Goals > v.team2Goals;
	                            team2Winner = v.team2Goals > v.team1Goals;
	                        }
	                    }

	                    var disabled = v.team1 == null || v.team2 == null ? ' disabled="disabled"' : '';

	                    $('.' + value.cls + ' .matches').append($([
	                        '<div>',
	                            '<div>',
	                                new Date(v.matchDate).toDateString(),
	                                ' - ',
	                                new Date(v.matchDate).toLocaleTimeString().replace(/:00 /, ' '),
	                            '</div>',
	                            '<div class="ko-match">',
	                                '<div class="match-number">' + v.number + '</div>', 
	                                '<div class="match-content">',
	                                    '<div class="match-content-team">',
	                                        v.team1 != null ?
	                                            [
	                                                team1Winner ? '<b>' : '', 
	                                                '<img src="' + v.team1.country.flag + '" style="width: 20px; margin-right: 5px;" />',
	                                                '<span>' + v.team1.country.name + '</span>',
	                                                team1Winner ? '</b>' : ''
	                                            ].join('')
	                                        : v.team1Indicator,
	                                    '</div>',
	                                    '<div class="match-content-team">',
	                                        v.team2 != null ?
	                                            [
	                                                team2Winner ? '<b>' : '', 
	                                                '<img src="' + v.team2.country.flag + '" style="width: 20px; margin-right: 5px;" />',
	                                                '<span>' + v.team2.country.name + '</span>',
	                                                team2Winner ? '</b>' : '', 
	                                            ].join('')
	                                        : v.team2Indicator,
	                                    '</div>',
	                                '</div>', 
	                                '<div class="match-result">',
	                                    '<div class="match-result-score">',
	                                        predictionMode ? 
	                                        [
	                                            '<input class="team-goal-input team-goal-input-team1-goals prediction-match-' + v.number + '" data-match-team="team1-goals" data-match-number="' + v.number + '" type="text"' + disabled + ' />'
	                                        ].join('') :
	                                        v.team1Goals == null ? '&nbsp;' :
	                                        [
	                                            team1Winner ? '<b>' : '',
	                                            v.team1Goals, 
	                                            team1Winner ? '</b>' : ''
	                                        ].join(''), 
	                                    '</div>',
	                                    '<div class="match-result-score">',
	                                        predictionMode ? 
	                                        [
	                                            '<input class="team-goal-input team-goal-input-team2-goals prediction-match-' + v.number + '" data-match-team="team2-goals" data-match-number="' + v.number + '" type="text"' + disabled + ' />'
	                                        ].join('') :
	                                        v.team2Goals == null ? '&nbsp;' :
	                                        [
	                                            team2Winner ? '<b>' : '',
	                                            v.team2Goals, 
	                                            team2Winner ? '</b>' : ''
	                                        ].join(''), 
	                                    '</div>',
	                                '</div>', 
	                                '<div class="match-result">',
	                                    '<div class="match-result-score">',
	                                        predictionMode ? 
	                                        [
	                                            '<input class="team-goal-input team-goal-input-team1-penalty-goals prediction-match-' + v.number + '" data-match-team="team1-penalty-goals" data-match-number="' + v.number + '" type="text"' + disabled + ' />'
	                                        ].join('') :
	                                        v.team1PenaltyGoals == null ? '&nbsp;' :
	                                        [
	                                            team1Winner ? '<b>' : '',
	                                            v.team1PenaltyGoals, 
	                                            team1Winner ? '</b>' : ''
	                                        ].join(''), 
	                                    '</div>',
	                                    '<div class="match-result-score">',
	                                        predictionMode ? 
	                                        [
	                                            '<input class="team-goal-input team-goal-input-team2-penalty-goals prediction-match-' + v.number + '" data-match-team="team2-penalty-goals" data-match-number="' + v.number + '" type="text"' + disabled + ' />'
	                                        ].join('') :
	                                        v.team2PenaltyGoals == null ? '&nbsp;' :
	                                        [
	                                            team2Winner ? '<b>' : '',
	                                            v.team2PenaltyGoals, 
	                                            team2Winner ? '</b>' : ''
	                                        ].join(''), 
	                                    '</div>',
	                                '</div>', 
	                            '</div>',
	                        '</div>'
	                    ].join('')));
	                });
	            });
	        });
	    }).then(function() {
	        if ( predictionMode ) {
	            $.get('/api/predictions', function(data) {
	                $.each(data, function(key, value) {
	                    $('.team-goal-input.team-goal-input-team1-goals.prediction-match-' + value.number).val(value.team1Goals != null ? value.team1Goals : '');
	                    $('.team-goal-input.team-goal-input-team2-goals.prediction-match-' + value.number).val(value.team2Goals != null ? value.team2Goals : '');
	                    $('.team-goal-input.team-goal-input-team1-penalty-goals.prediction-match-' + value.number).val(value.team1PenaltyGoals != null ? value.team1PenaltyGoals : '');
	                    $('.team-goal-input.team-goal-input-team2-penalty-goals.prediction-match-' + value.number).val(value.team2PenaltyGoals != null ? value.team2PenaltyGoals : '');
	                });
	            });
	        }
	    });
	};

    if ( predictionMode ) {
        $('.save-match-predictions').click(function(el) {
            el.preventDefault();
            el.stopPropagation();

            $(el.target).text('Saving Prediction...');
            $(el.target).addClass('disabled');

            var predictions = [];

            $('.team-goal-input').each(function(k, e) {
                var $e = $(e);
                var type = $e.data('match-team');
                var number = $e.data('match-number');
                var value = $e.val();

                if ( typeof $e.attr('disabled') === 'undefined' ) {
	                predictions.push({
	                    "number": number, 
	                    "team1Goals": type === 'team1-goals' ? value : null,
	                    "team1PenaltyGoals": type === 'team1-penalty-goals' ? value : null,
	                    "team2Goals": type === 'team2-goals' ? value : null,
	                    "team2PenaltyGoals": type === 'team2-penalty-goals' ? value : null
	                });
                }
            });

            $.ajax({
                url: '/api/predictions',
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(predictions),
                contentType: 'application/json',
                success: function() {
                    location.reload();
                }
            });
        });
    }

    if ( !predictionMode && !matchesMode ) {
        // populate KO stages
        $.get('/api/leaderboard', function(data) {
            $.each(data, function(key, value) {
            	$('.leaderboards tbody').append($([
                    '<tr>',
                        '<th class="text-center" scope="row">' + (key+1) + '</th>',
                        '<td>',
                            '<img class="user-avatar" src="' + value.photo + '" title="' + value.fullName + '" />',
                            value.fullName,
                        '</td>',
                        '<td>', value.points, '</td>',
                    '</tr>'
                ].join('')));
            });
        });
    }

    if ( matchesMode ) {
        // populate KO stages
        $.get('/api/matches?sort=date', function(data) {
            $.each(data, function(key, value) {
                var team1Winner = false;
                var team2Winner = false;

                if ( value.team1Goals != null && value.team2Goals != null ) {
                    if ( value.stage !== 'Group Phase' && value.team1Goals == value.team2Goals ) {
                        team1Winner = value.team1PenaltyGoals > value.team2PenaltyGoals;
                        team2Winner = value.team2PenaltyGoals > value.team1PenaltyGoals;
                    } else {
                        team1Winner = value.team1Goals > value.team2Goals;
                        team2Winner = value.team2Goals > value.team1Goals;
                    }
                }

                $('.matches tbody').append($([
                    '<tr>',
                        '<th class="text-center" scope="row">' + (key+1) + '</th>',
                        '<td class="match-time text-left">',
                            new Date(value.matchDate).toDateString(),
                            ' - ',
                            new Date(value.matchDate).toLocaleTimeString().replace(/:00 /, ' '),
                        '</td>',
                        '<td>',
                            value.stage,
                        '</td>',
                        '<td class="match-home text-right">', 
                            value.team1 == null ?
                            [
                                value.team1Indicator
                            ] :
                            [
                                team1Winner ? '<b>' : '', 
                                '<span>' + value.team1.country.name + '</span>', 
                                '<img src="' + value.team1.country.flag + '" style="width: 20px; margin-left: 5px;" />', 
                                team1Winner ? '</b>' : ''
                            ].join(''),
                        '</td>',
                        '<td class="match-result text-center">',
                            value.team1Goals == null || value.team2Goals == null ? '-' : value.team1Goals + '-' + value.team2Goals,
                            value.stage === 'Group Phase' ? '' :
                            [
                                ( value.team1Goals != null && value.team2Goals != null ) && ( value.team1Goals == value.team2Goals ) ?
                                [
                                    '<br />',
                                    value.team1PenaltyGoals == null || value.team2PenaltyGoals == null ? '-' : value.team1PenaltyGoals + '-' + value.team2PenaltyGoals
                                ].join('') : ''
                            ],
                        '</td>',
                        '<td class="match-away text-left">', 
                            value.team1 == null ?
                            [
                                value.team1Indicator
                            ] :
                            [
                                team2Winner ? '<b>' : '', 
                                '<img src="' + value.team2.country.flag + '" style="width: 20px; margin-right: 5px;" />', 
                                '<span>' + value.team2.country.name + '</span>', 
                                team2Winner ? '</b>' : ''
                            ].join(''),
                        '</td>',
                    '</tr>'
                ].join('')));
            });
        });
    }
})(jQuery);
