package com.vn.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
//@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	private String name;
	private String createdDate;
}