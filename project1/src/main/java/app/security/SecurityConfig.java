package app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/home").access("hasRole('USER')")

            .and()
            .formLogin()

            .and()
            .logout()


            .and()
            .httpBasic()

            // Make H2-Console non-secured; for debug purposes
            .and()
            .csrf()
            .disable()
            // Allow pages to be loaded in frames from the same origin; needed for H2-Console

            .headers()
            .frameOptions()
            .sameOrigin()
    ;
  }
  @Override
  protected void configure(AuthenticationManagerBuilder auth)
          throws Exception {

    auth
            .inMemoryAuthentication()
            .withUser("buzz")
            .password("infinity")
            .authorities("ROLE_USER")
            .and()
            .withUser("woody")
            .password("bullseye")
            .authorities("ROLE_USER");

  }

}
