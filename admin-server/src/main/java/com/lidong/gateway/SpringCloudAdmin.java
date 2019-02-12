package com.lidong.gateway;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 开启服务发现
 */


@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class SpringCloudAdmin {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAdmin.class, args);
    }

//    @Configuration
//    public static class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
//        private final String adminContextPath;
//
//        public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
//            this.adminContextPath = adminServerProperties.getContextPath();
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
//            successHandler.setTargetUrlParameter("redirectTo");
//            successHandler.setDefaultTargetUrl(adminContextPath + "/");
//
//            http.authorizeRequests()
//                    .antMatchers(adminContextPath + "/assets/**").permitAll()
//                    .antMatchers(adminContextPath + "/login").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler).and()
//                    .logout().logoutUrl(adminContextPath + "/logout").and()
//                    .httpBasic().and()
//                    .csrf()
//                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                    .ignoringAntMatchers(
//                            adminContextPath + "/instances",
//                            adminContextPath + "/actuator/**"
//                    );
//        }
//    }
}

