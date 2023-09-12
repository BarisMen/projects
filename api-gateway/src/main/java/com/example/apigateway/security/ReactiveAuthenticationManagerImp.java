package com.example.apigateway.security;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReactiveAuthenticationManagerImp implements ReactiveAuthenticationManager {
    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        List<GrantedAuthority> authorities = new ArrayList<>(authentication.getAuthorities());

        switch (authentication.getPrincipal().toString()) {
            case "actors":
                authorities.add(new SimpleGrantedAuthority("ACTOR_OPERATION_ROLE"));
                break;
            case "companies":
                authorities.add(new SimpleGrantedAuthority("MOVIE_OPERATION_ROLE"));
                break;
            case "users":
                authorities.add(new SimpleGrantedAuthority("MOVIE_ACTOR_QUERY_ROLE"));
                break;
        }

        Authentication authenticated2 = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authorities);
        return Mono.just(authenticated2);

    }
}
