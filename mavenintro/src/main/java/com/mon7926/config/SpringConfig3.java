package com.mon7926.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.annotation.Configuration;
@Configuration
@PropertySources({
    @PropertySource({
        "classpath:AddressData.properties", "classpath:StudentData.properties"
    })
})
public class SpringConfig3 {

    @Bean 
    public PropertySourcesPlaceholderConfigurer propertySourcePlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
