package com.HM;

import com.HM.jwt.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class HmApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmApplication.class, args);

		System.out.println("Pagina Web W&M, ejecutando con exito!! ");


	}

/*
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> registrationBean =
				new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/wm/customer/");
		return registrationBean;
	}

*/

}