package com.ufc.br.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		
		.antMatchers("/pessoa/formulario").permitAll()
		.antMatchers("/pessoa/listar").permitAll()
		.antMatchers("/pessoa/salvar").permitAll()
		
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/pessoa/logar").permitAll()
		
		.and()
		.logout()
		.logoutSuccessUrl("/pessoa/logar?logout")
		.permitAll();
		
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}

	
	
	
	
}
