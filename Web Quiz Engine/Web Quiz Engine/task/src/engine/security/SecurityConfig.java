package engine.security;

import engine.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = false) //You should remove "debug=true" before putting the application in production.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //we have extended WebSecurityConfigurerAdapter to override spring features with our custom requirements.

    @Autowired
    MyUserDetailsService myUserDetailsService;

    //Этот простой бин сообщает Spring, что PasswordEncoder, который мы хотим использовать, — это Spring Boot BCryptPasswordEncoder() для кодирования и сравнения хешей паролей.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();  //Cross-Site Request Forgery [Подделка межсайтового запроса]
//        http.headers().frameOptions().disable();    //Since the H2 database console runs inside a frame, you need to enable this in in Spring Security.

        http.authorizeRequests()    //First, make a call to authorizeRequests(), as we need access to a “registry” object, which stores the web routes that are allowed for each role. Then “antMatchers” are used to identify the mapping.
                .antMatchers(HttpMethod.POST, "/actuator/shutdown").permitAll()
                .antMatchers("/api/register").permitAll()
//                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/api/quizzes", "/api/quizzes/**").authenticated()
                .and()
                .httpBasic();
    }

    @Override
    //the AuthenticationManagerBuilder is a class which creates an advanced configuration for authentication
    //Этот метод просто переопределяет конфигурацию по умолчанию AuthenticationManagerBuilder, заменяя вместо этого нашу собственную службу автоматической передачи пользовательских данных.
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}

/*
https://grobmeier.solutions/spring-security-5-intro-form-login.html
Principal: refers to the authenticated user object provided by Spring Security
Authentication: refers to successfully logging in with a username and password
Authorization: refers to being allowed to access certain parts of your application
Role: refers to a handle to which authorization rules can be assigned
 */