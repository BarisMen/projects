import com.example.apigateway.security.ReactiveAuthenticationManagerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

import reactor.core.publisher.Mono;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
@ComponentScan("com.example")
public class CustomWebSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    ReactiveAuthenticationManagerImp reactiveAuthenticationManagerImp;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http.csrf(x->x.disable())
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(HttpMethod.GET, "/movies/**").hasRole("MOVIE_OPERATION_ROLE")
                        .pathMatchers(HttpMethod.GET, "/actors/**").hasRole("ACTOR_OPERATION_ROLE")
                        .pathMatchers(HttpMethod.GET, "/composit/**").hasRole("MOVIE_ACTOR_QUERY_ROLE")
                        .anyExchange().authenticated()
                )
                .httpBasic(withDefaults())
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
                .addFilterAt(authenticationWebFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ServerAuthenticationConverter authenticationConverter() {
        return exchange -> {
            // Implement your authentication logic here and return an Authentication object
            // You can use the exchange object to retrieve headers, query parameters, etc.
            return Mono.empty(); // Replace with the appropriate authentication logic
        };
    }

    @Bean
    public AuthenticationWebFilter authenticationWebFilter() {
        AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(reactiveAuthenticationManagerImp);
        authenticationWebFilter.setServerAuthenticationConverter(authenticationConverter());
        return authenticationWebFilter;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails users = User.builder().username("user").password(passwordEncoder().encode("user")).roles("MOVIE_ACTOR_QUERY_ROLE").build();
        UserDetails companies = User.builder().username("companies").password(passwordEncoder().encode("companies")).roles("MOVIE_OPERATION_ROLE").build();
        UserDetails actors = User.builder().username("actors").password(passwordEncoder().encode("actors")).roles("ACTOR_OPERATION_ROLE").build();
        UserDetails[] userDetails = new UserDetails[3];
        userDetails[0] = users;
        userDetails[1] = companies;
        userDetails[2] = actors;
        return new InMemoryUserDetailsManager(userDetails);
    }
}
