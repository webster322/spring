package pl.basestudio.springlessons.financeassistant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import pl.basestudio.springlessons.financeassistant.services.CurrencyRateProvider;
import pl.basestudio.springlessons.financeassistant.services.FileCurrencyRateProvider;

@Configuration
@Import(AppConfigCommon.class)
@Profile({"dev", "!prod"})
@PropertySource(ignoreResourceNotFound=true, value={"classpath:app.properties", "file:/$(configLoc)app2.properties"})
public class AppConfig {
	
	@Bean
	public CurrencyRateProvider fileCurrencyRateProvider() {
		return new FileCurrencyRateProvider();
	}
	
}
