package com.yyn.sharing.knowledge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration(proxyBeanMethods = false)
public class SwaggerConfig {
	@Bean
	public ApiModelEnumPropertyBuilder apiModelEnumPropertyBuilder(){
		return new ApiModelEnumPropertyBuilder();
	}
}
