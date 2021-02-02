package com.chen.api.plugin;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(
        prefix = "chen",
        ignoreUnknownFields = true
)
@PropertySource("classpath:chen.properties")
public class ChenApiProperties {
   private String name;

   private ChenApiProperties.TestChenApi testChenApi;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public TestChenApi getTestChenApi() {
      return testChenApi;
   }

   public void setTestChenApi(TestChenApi testChenApi) {
      this.testChenApi = testChenApi;
   }

   static class TestChenApi{
      private Boolean enable = false;

      private String url;

      private String password;

      private String username;

      public TestChenApi(){}


      public Boolean getEnable() {
         return enable;
      }

      public void setEnable(Boolean enable) {
         this.enable = enable;
      }

      public String getUrl() {
         return url;
      }

      public void setUrl(String url) {
         this.url = url;
      }

      public String getPassword() {
         return password;
      }

      public void setPassword(String password) {
         this.password = password;
      }

      public String getUsername() {
         return username;
      }

      public void setUsername(String username) {
         this.username = username;
      }

      @Override
      public String toString() {
         return "TestChenApi{" +
                 "enable=" + enable +
                 ", url='" + url + '\'' +
                 ", password='" + password + '\'' +
                 ", username='" + username + '\'' +
                 '}';
      }
   }

}
