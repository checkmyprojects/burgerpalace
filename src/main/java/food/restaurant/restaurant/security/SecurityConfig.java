package food.restaurant.restaurant.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http
                .csrf()
                .ignoringAntMatchers("/food/edit/add**", "/user/**")
                .and()
                .authorizeRequests()
                .antMatchers("/", "/food/**", "/food/edit/add**", "/user/**").permitAll()
                .antMatchers("/user/edit/", "/food/edit/").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/user/private/").authenticated()
                .and()
                .formLogin().loginPage("/user/add").defaultSuccessUrl("/user/private/", true).failureUrl("/user/add?error=true")
                .loginProcessingUrl("/user/add-post").permitAll()
                .and()
                .logout().logoutUrl("/user/logout").logoutSuccessUrl("/user/logout");
    }


}
