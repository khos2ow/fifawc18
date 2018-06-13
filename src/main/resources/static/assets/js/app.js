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
                                    '<th style="width: 250px;">&nbsp;</th>',
                                    '<th>&nbsp;</th>',
                                    '<th style="width: 50px;">&nbsp;</th>',
                                    '<th>&nbsp;</th>',
                                '</tr>',
                            '</thead>',
                            '<tbody></tbody>',
                        '</table>',
                    '</div>',
                    '<div class="col-xs-12 col-md-6 group-standing">',
                        '<table class="table">',
                            '<thead>',
                                '<tr>',
                                    '<th>#</th>',
                                    '<th>Team</th>',
                                    '<th title="Games">G</th>',
                                    '<th title="Wins">W</th>',
                                    '<th title="Draws">D</th>',
                                    '<th title="Loses">L</th>',
                                    '<th title="Goals For">GF</th>',
                                    '<th title="Goals Against">GA</th>',
                                    '<th title="Goals Difference">GD</th>',
                                    '<th title="Points">P</th>',
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
                    '<th scope="row">' + (k+1) + '</th>',
                    '<td>', 
                        '<img src="' + v.team.country.flag + '" style="width: 20px; margin-right: 5px;" />', 
                        '<span>' + v.team.country.name + '</span>', 
                    '</td>',
                    '<td>' + v.games + '</td>',
                    '<td>' + v.wins + '</td>',
                    '<td>' + v.draws + '</td>',
                    '<td>' + v.loses + '</td>',
                    '<td>' + v.goalsFor + '</td>',
                    '<td>' + v.goalsAgainst + '</td>',
                    '<td>' + v.goalsDiff + '</td>',
                    '<td>' + v.points + '</td>',
                '</tr>'
            ].join('')));
        });
    };

    var populateGroupMatches = function(key, value) {
        $.get('/api/groups/' + value.uuid + '/matches', function(data) {
            // group standing table
            $.each(data, function(k, v) {
                $('.tab-pane#' + value.uuid + ' .group-matches .table tbody').append($([
                    '<tr>',
                        '<td class="text-left">',
                            new Date(v.matchDate).toDateString(),
                            ' - ',
                            new Date(v.matchDate).toLocaleTimeString().replace(/:00 /, ' '),
                        '</td>',
                        '<td class="text-right">', 
                            v.team1Goals != null && v.team2Goals != null && v.team1Goals > v.team2Goals ? '<b>' : '', 
                            '<span>' + v.team1.country.name + '</span>', 
                            '<img src="' + v.team1.country.flag + '" style="width: 20px; margin-left: 5px;" />', 
                            v.team1Goals != null && v.team2Goals != null && v.team1Goals > v.team2Goals ? '</b>' : '', 
                        '</td>',
                        '<td class="text-center">', 
                            v.team1Goals == null || v.team2Goals == null ? '-' : v.team1Goals + '-' + v.team2Goals, 
                        '</td>',
                        '<td class="text-left">', 
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

    // populate groups
    $.get('/api/groups', function(data) {
        $.each(data, function(key, value) {
            populateTab(key, value);
            populateTabContent(key, value);
            populateStandings(key, value);
            populateGroupMatches(key, value);
        });
    });

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
        $.get('/api/matches?stage=' + value.name, function(data) {
            $.each(data, function(k, v) {
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
                                            v.team1Goals != null && v.team2Goals != null && v.team1Goals > v.team2Goals ? '<b>' : '', 
                                            '<img src="' + v.team1.country.flag + '" style="width: 20px; margin-right: 5px;" />',
                                            '<span>' + v.team1.country.name + '</span>',
                                            v.team1Goals != null && v.team2Goals != null && v.team1Goals > v.team2Goals ? '</b>' : ''
                                        ].join('')
                                    : v.team1Indicator,
                                '</div>',
                                '<div class="match-content-team">',
                                    v.team2 != null ?
                                        [
                                            v.team1Goals != null && v.team2Goals != null && v.team2Goals > v.team1Goals ? '<b>' : '', 
                                            '<img src="' + v.team2.country.flag + '" style="width: 20px; margin-right: 5px;" />',
                                            '<span>' + v.team2.country.name + '</span>',
                                            v.team1Goals != null && v.team2Goals != null && v.team2Goals > v.team1Goals ? '</b>' : '', 
                                        ].join('')
                                    : v.team2Indicator,
                                '</div>',
                            '</div>', 
                            '<div class="match-result">',
                                '<div class="match-result-score">',
                                    v.team1Goals == null ? '&nbsp;' :
                                    [
                                        v.team1Goals != null && v.team2Goals != null && v.team1Goals > v.team2Goals ? '<b>' : '',
                                        v.team1Goals, 
                                        v.team1Goals != null && v.team2Goals != null && v.team1Goals > v.team2Goals ? '</b>' : ''
                                    ].join(''), 
                                '</div>',
                                '<div class="match-result-score">',
                                    v.team2Goals == null ? '&nbsp;' :
                                    [
                                        v.team1Goals != null && v.team2Goals != null && v.team2Goals > v.team1Goals ? '<b>' : '',
                                        v.team2Goals, 
                                        v.team1Goals != null && v.team2Goals != null && v.team2Goals > v.team1Goals ? '</b>' : ''
                                    ].join(''), 
                                '</div>',
                            '</div>', 
                        '</div>',
                    '</div>'
                ].join('')));
            });
        });
    });
        
})(jQuery);