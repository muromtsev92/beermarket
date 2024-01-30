package com.example.beermarket.configuration;

import com.example.beermarket.services.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailsService userDetailsService;

}
