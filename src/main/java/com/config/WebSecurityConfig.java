package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .antMatcher("/api/**")
        .authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/api/login")
        .permitAll()
        .successHandler(((request, response, authentication) -> HttpStatus.OK.value()))
        .failureHandler((request, response, exception) -> response.setStatus(HttpStatus.UNAUTHORIZED.value()))
        .and()
        .logout()
        .permitAll()
        .logoutSuccessHandler(((request, response, authentication) -> HttpStatus.OK.value()));


  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    LdapContextSource source = new LdapContextSource();
    source.setUrl("ldaps://testdevad.testdev.ukr:636");
    source.setBase("CN=Users,DC=testdev,DC=ukr");
    source.setUserDn("CN=Administrator,CN=Users,DC=testdev,DC=ukr");
    source.setPassword("P@ssw0rd");
    source.setPooled(true);
    source.setReferral("follow");
    source.afterPropertiesSet();

    auth
        .ldapAuthentication()
        .userSearchFilter("(&(&(objectCategory=person)(objectClass=user))(sAMAccountName={0}))")
        .groupSearchFilter("(&(objectCategory=group)(member={0}))")
        .contextSource(source);
  }

//  @Bean
//  CorsConfigurationSource corsConfigurationSource() {
//    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//    return source;
//  }

//  @Bean
//  public CorsConfigurationSource corsConfigurationSource() {
//    CorsConfiguration configuration = new CorsConfiguration();
//    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//    configuration.setAllowCredentials(true);
//    configuration.setAllowedOrigins(Collections.singletonList("*"));
//    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
////    configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
//
//    source.registerCorsConfiguration("/**", configuration);
//
//    return source;
//  }

}

//class OnSuccessAuthorize
//    extends SimpleUrlAuthenticationSuccessHandler {
//
//  private RequestCache requestCache = new HttpSessionRequestCache();
//
//  @Override
//  public void onAuthenticationSuccess(
//      HttpServletRequest request,
//      HttpServletResponse response,
//      Authentication authentication)
//      throws ServletException, IOException {
//
//    SavedRequest savedRequest
//        = requestCache.getRequest(request, response);
//
//    if (savedRequest == null) {
//      clearAuthenticationAttributes(request);
//      return;
//    }
//    String targetUrlParam = getTargetUrlParameter();
//    if (isAlwaysUseDefaultTargetUrl()
//        || (targetUrlParam != null
//        && StringUtils.hasText(request.getParameter(targetUrlParam)))) {
//      requestCache.removeRequest(request, response);
//      clearAuthenticationAttributes(request);
//      return;
//    }
//
//    clearAuthenticationAttributes(request);
//  }
//
//  public void setRequestCache(RequestCache requestCache) {
//    this.requestCache = requestCache;
//  }
//}
