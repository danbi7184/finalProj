package com.fin.proj.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fin.proj.common.interceptor.CheckAdminInterceptor;
import com.fin.proj.common.interceptor.CheckLoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CheckLoginInterceptor())
				.addPathPatterns("/*.su")
				.excludePathPatterns("/supportMain.su");
		
		registry.addInterceptor(new CheckAdminInterceptor())
				.addPathPatterns("/supportListAdmin.su",
								 "/supportApplyListAdmin.su",
								 "/applyDevision.su",
								 "/supportDetailAdmin.su",
								 "/updateApplyStatus.su",
								 "/supportEndListAdmin.su",
								 "/searchSupportListAdmin.su",
								 "/supporterListEach.su",
								 "/supporterListAdmin.su",
								 "/searchEndList.su");
	}
}
