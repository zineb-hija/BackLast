package com.example.m6.security.config;

import com.example.m6.security.jwt.JwtAuthenticationFilter;
import com.example.m6.security.jwt.JwtAutorisationFilter;
import com.example.m6.security.service.admin.facade.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers("/api/v1/services/**").permitAll()
                .antMatchers("/api/v1/prestation/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/admin/sign-in").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/admin/").permitAll()
                .antMatchers("/api/v1/patient/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/responsable/sign-in").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/v1/services/").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/responsable/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/admin/role/{role}").hasAuthority("ROLE_ADMIN")
                .antMatchers("/api/v1/departement/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/api/v1/departement/**").hasAuthority("ROLE_ADMIN")


                .anyRequest().authenticated();

        http.addFilter(new JwtAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(jwtAutorisationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AdminService userService;
    @Autowired
    private JwtAutorisationFilter jwtAutorisationFilter;
}
