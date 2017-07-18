package pl.basestudio.springlessons.financeassistant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import pl.basestudio.springlessons.financeassistant.services.CurrencyRateProvider;
import pl.basestudio.springlessons.financeassistant.services.DatabaseCurrencyRateProvider;

@Configuration
@Import(AppConfigCommon.class)
@Profile({"prod"})
public class AppConfigProd {
	
	@Bean
	public CurrencyRateProvider databaseCurrencyRateProvider() {
		return new DatabaseCurrencyRateProvider();
	}
	
}
