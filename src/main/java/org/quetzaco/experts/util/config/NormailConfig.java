package org.quetzaco.experts.util.config;

import org.quetzaco.experts.util.encoder.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description Created by dong on 2017/7/16.
 */
@Configuration
@ConditionalOnClass({ExpertsProperties.class})
@EnableScheduling
public class NormailConfig {

  @Autowired
  ExpertsProperties archiveProperties;

  @Bean
  PasswordEncoder passwordEncoder() {
      return new PasswordEncoder("ARCHIVE", "MD5");
  }

}
