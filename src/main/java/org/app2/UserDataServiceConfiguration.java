package org.app2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDataServiceConfiguration {

    @Bean
    public UserDataService getUserDataService() { return new UserDataService();}
}
