package in.lpu.Q5;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication()
		.dataSource(dataSource);


	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		////URL-AccessTypes
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/std").hasAuthority("STUDENT")
		.anyRequest().hasAuthority("ADMIN")
		.and()
		//Login  Form Details
		.formLogin()
		.loginPage("/login")
		.failureUrl("/login?error=1").loginProcessingUrl("/login")
		.failureForwardUrl("/failure")
		.defaultSuccessUrl("/welcome",true)
		.permitAll()
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))





		//Exception Details

		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")
		.and()
		.rememberMe()
		.key("abcdEFGHijklmnOpqrstUVWXyz012345")
		.tokenValiditySeconds(24*60*60);

		;
	}
	@Bean
	public BCryptPasswordEncoder pwdEncoder() {
		return  new  BCryptPasswordEncoder();
	}
}
