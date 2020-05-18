package ninja.wordy.blog.web.config;

import ninja.wordy.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    static PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(
                            "/",
                            "/index",
                            "/css/**",
                            "/js/**",
                            "/signup",
                            "/search",
                            "/results").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();

        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }


    static {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("{MD5}", passwordEncoder);
    }
}



//        PasswordEncoder defaultEncoder = new PasswordEncoderFactories();
//        String defaultIdForEncode = "noop";
//
//        Map<String, PasswordEncoder> encoders = new HashMap<>();
//        encoders.put(defaultIdForEncode, defaultEncoder);
//        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(defaultIdForEncode, encoders);
//        passwordEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);


//    public PasswordEncoder passwordEncoder() {
//      return new MD5Encoder();
//    }