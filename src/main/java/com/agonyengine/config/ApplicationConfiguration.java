package com.agonyengine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;

@EnableScheduling
@Configuration
public class ApplicationConfiguration {
    private Date bootDate = new Date();

    @Bean(name = "applicationVersion")
    public String applicationVersion() {
        return ApplicationConfiguration.class.getPackage().getImplementationVersion();
    }

    @Bean(name = "applicationBootDate")
    public Date applicationBootDate() {
        return bootDate;
    }
}
