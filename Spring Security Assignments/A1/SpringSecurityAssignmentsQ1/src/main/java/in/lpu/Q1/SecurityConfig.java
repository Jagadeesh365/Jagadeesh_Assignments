package in.lpu.Q1;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{


	//authenticatio
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("sam").password("{noop}sam").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("syed").password("{noop}syed").authorities("EMPLOYEE");	
		auth.inMemoryAuthentication().withUser("jai").password("{noop}jai").authorities("STUDENT");
	}


	//authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//URL-AccessTypes
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/std").hasAuthority("STUDENT")
		.anyRequest().hasAuthority("AMIN")

		//Login  Form Details
		.and()
		.formLogin()
		.defaultSuccessUrl("/welcome",true)

		//Logout Details
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))


		//Exception Details
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied");

		;


	}


}