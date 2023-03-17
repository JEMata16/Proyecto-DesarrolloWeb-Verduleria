/*
 * https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
 */
package com.Verduleria.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebConfiguration {
    
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((auth)-> auth
                    .requestMatchers("/","/register","/register/save","/empleado/guardar").permitAll()
                    .requestMatchers("/empleado/empleados/**","/empleado/editar/**").authenticated()
                )
                .formLogin((form)->form
                    .loginPage("/")
                        .defaultSuccessUrl("/empleado/empleados")
                        .loginProcessingUrl("/")
                        .failureUrl("/?error=true")
                    .permitAll()
                )
                .logout((logout)->logout
                .permitAll());
        
        return http.build();
            
    }
    
    @Bean
    public WebSecurityCustomizer customizer () {
        return (web) -> web.debug(false)
                .ignoring()
                .requestMatchers("/css/**","/img/**","/layout/**","/webjars/**");
    }
    
    //Esta es la autentificacion de los usuarios por medio de la memoria
  
    @Bean
    public PasswordEncoder pEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin = User.withUsername("elmio")
                .password(encoder.encode("2412"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }
}
