package com.chengli.spring.annotation.profile;

/**
 * @Author: chengli
 * @Date: 2018/7/29 22:54
 */
public class ProfileData {
    private String content;

    public ProfileData(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ProfileData{" +
                "content='" + content + '\'' +
                '}';
    }
}
