package io.khosrow.fifawc;

import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import io.khosrow.fifawc.common.util.UserLoginType;
import io.khosrow.fifawc.domain.User;
import io.khosrow.fifawc.repo.UserRepository;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/**").authorizeRequests()
            .antMatchers("/", "/index.html", "/assets/**", "/login**").permitAll()
            .antMatchers("/api/countries/**", "/api/groups/**", "/api/matches/**", "/api/teams/**", "/api/leaderboard**").permitAll()
            .anyRequest().fullyAuthenticated()

        .and()
            .logout()
            .logoutSuccessUrl("/")
            .permitAll()

        .and()
            .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserRepository userRepository) {
        return map -> {
            String principalId = (String)map.get("id");
            User user = userRepository.findByPrincipalId(principalId);

            if (user == null) {
                user = new User();

                user.setPrincipalId(principalId);
                user.setCreated(LocalDateTime.now());
                user.setEmail((String)map.get("email"));
                user.setFullName((String)map.get("name"));
                user.setPhoto((String)map.get("picture"));
                user.setLoginType(UserLoginType.GOOGLE);
                user.setLastLogin(LocalDateTime.now());
                user.setPoints(0);
            } else {
                user.setLastLogin(LocalDateTime.now());
            }

            return userRepository.save(user);
        };
    }
}
