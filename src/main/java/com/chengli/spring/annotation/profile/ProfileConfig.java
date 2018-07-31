package com.chengli.spring.annotation.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author: chengli
 * @Date: 2018/7/29 22:52
 */
@Configuration
public class ProfileConfig {

    @Profile("default")
    @Bean(name = "default_profiledata")
    public ProfileData createProfileData() {
        ProfileData profileData = new ProfileData("default");
        return profileData;
    }

    @Profile("dev")
    @Bean(name = "dev_profiledata")
    public ProfileData createProfileData1() {
        ProfileData profileData = new ProfileData("dev_profile");
        return profileData;
    }

    @Profile("test")
    @Bean(name = "test_profiledata")
    public ProfileData createProfileData2() {
        ProfileData profileData = new ProfileData("test_default");
        return profileData;
    }
}
