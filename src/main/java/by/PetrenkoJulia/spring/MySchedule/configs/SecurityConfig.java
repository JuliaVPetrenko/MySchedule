package by.PetrenkoJulia.spring.MySchedule.configs;

import by.PetrenkoJulia.spring.MySchedule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/tasks/**").hasAnyAuthority("USER1", "USER2", "USER3", "USER5")
//                hasAuthority("USER1")
//                 .antMatchers("/Liz/**").hasAuthority("USER1")
//                .antMatchers("/Nick/**").hasAuthority("USER2")
//                .antMatchers("/Anny/**").hasAuthority("USER3")
                .and()
                .formLogin() /* !!!! но, если логинимся через postman нужно добавить formLogin().disable():*/
//                .formLogin().disable()
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .csrf().disable()
                .httpBasic()/* сообщает Spring, чтобы он ожидал базовую HTTP аутентификацию */
                .and().sessionManagement().disable() /* сообщает Spring, что не следует хранить информацию о сеансе для пользователей, поскольку это не нужно для API */
                ;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }


}
