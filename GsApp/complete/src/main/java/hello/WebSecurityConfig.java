package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


/**
 * Created by aloha on 28-May-16.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGOUT_URL = "/signout";
    private static final String SESSION_COOKIE = "JSESSIONID";

    @Override
    public void configure(HttpSecurity http) throws Exception {

/*        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
               // .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();*/


        http.formLogin().disable();
        http.httpBasic().disable();
        //http.logout().logoutUrl(LOGOUT_URL).deleteCookies(SESSION_COOKIE);
        http.rememberMe();
        http.csrf().disable();



       /* dr.
        http.formLogin().disable();
        http.httpBasic().disable();
        http.logout().logoutUrl(LOGOUT_URL).deleteCookies(SESSION_COOKIE);
        http.rememberMe();
        http.csrf().disable();
        */

    }

 /*   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }*/


}
