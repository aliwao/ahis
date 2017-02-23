package cn.com.liandisys.ahis.webapp.config;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import cn.com.liandisys.ahis.webapp.auth.AhisAuthenticationSuccessHandler;
import cn.com.liandisys.ahis.webapp.auth.AhisCustomLogoutSuccessHandler;
import cn.com.liandisys.ahis.webapp.auth.AhisLoginUrlAuthenticationEntryPoint;
import cn.com.liandisys.ahis.webapp.entity.UserLoginEntity;
import cn.com.liandisys.ahis.webapp.service.UserLoginService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private AhisAuthenticationSuccessHandler ahisAuthenticationSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.authorizeRequests()
				.antMatchers(
						"/hello",
						"/",
                        "/favicon.ico",
						"/css/*.css",
						"/css/*.map",
						"/js/*.js",
						"/images/*",
						"/images/*/*",
						"/fonts/*",
						"/test/*",
						"/rest/*",
						"/rest/*/*",
						"/g/*",
						"/g/*/*")
				.permitAll().anyRequest().authenticated()
				.and().formLogin()
				.loginPage("/login").loginProcessingUrl("/loginValid")
				.successHandler(ahisAuthenticationSuccessHandler)
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				//.logoutUrl("/logout")
				.logoutSuccessHandler(new AhisCustomLogoutSuccessHandler())
				.logoutSuccessUrl("/g/mpmp001/index")
				.invalidateHttpSession(true)
				//.deleteCookies("")
				.permitAll()
				.and().exceptionHandling()
				.authenticationEntryPoint(new AhisLoginUrlAuthenticationEntryPoint("/login"))
				;
		// 解决CsrfFilter与Rest服务Post方式的矛盾
		http.csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
			private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

			@Override
			public boolean matches(HttpServletRequest request) {
				String servletPath = request.getServletPath();

				if (servletPath.contains("/rest/") || servletPath.contains("/m/mfis008/index") || servletPath.contains("/m/mfop001/init")) {
					return false;
				}
				return !allowedMethods.matcher(request.getMethod()).matches();
			}
		});
		// TODO 防止CSRF攻击，需要在页面添加CSRF Token
		// 参考http://blog.csdn.net/sinat_28454173/article/details/52251004
//		http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(buildUserDetailsService());
	}
	
	@Bean
	UserDetailsService buildUserDetailsService() {
		return username -> {
			UserLoginEntity account = userLoginService.getByMobileNo(username);
			User user = new User(account.getMobileNo(), account.getPassword(), true, true, true, true,
					AuthorityUtils.createAuthorityList("USER", "write"));
			return user;
		};
	}

}
