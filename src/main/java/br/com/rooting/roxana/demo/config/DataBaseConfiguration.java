package br.com.rooting.roxana.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = DataBaseConfiguration.BASE_BUSINESS_PACKAGE)
public class DataBaseConfiguration {

	static final String BASE_BUSINESS_PACKAGE = "br.com.rooting.roxana.demo.domain.business";
	
}