package org.itstep.msk.app.Configuration;

import org.itstep.msk.app.service.CustomDetailsClass;
import org.itstep.msk.app.service.CustomerDetailServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurConfigurationForApp extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserDetailsService userDetailsService;


    @Bean
    public PasswordEncoder bcryptEncoder(){
        return new BCryptPasswordEncoder();


    }

    @Autowired
    @Value("${spring.datasource.url}")
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

     //  String passQuery="SELECT password, 1 as active FROM customer WHERE password=?";
    //   String authoriQuery = "SELECT n.name, r.roles "
      //         + "FROM customer c "
       //        + "INNER JOIN  custom_roles cr ON cd customer_id = c.id "
        //       + "INNER JOIN  roles r ON r.id = cd.roles_id "
        //        + "WHERE n.name = ?";

     //   auth.jdbcAuthentication()
          //      .usersByUsernameQuery("select name,password,enabled from customer where username = ?")
            //    .groupAuthoritiesByUsername(authoriQuery)
            //    .passwordEncoder(bcryptEncoder());
        auth.userDetailsService(userDetailsService).passwordEncoder(bcryptEncoder());

    }

    @Override
    public void configure(WebSecurity web)  {
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/images/**")
                .antMatchers("/templates/**")
                .antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()

                .antMatchers("/","/**").permitAll()
                .antMatchers("/register**").permitAll()
                .and()
                .formLogin()
                    .loginPage("/login")
                        .defaultSuccessUrl("/registersuccess")
                .failureUrl("/login")
                .and()
                .csrf()
                .disable()
                .httpBasic();












    }
}
