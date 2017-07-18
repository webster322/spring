package pl.basestudio.springlessons.financeassistant;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.basestudio.springlessons.financeassistant.dao.CurrencyRateDao;
import pl.basestudio.springlessons.financeassistant.dao.JdbcCurrencyRateDao;

@Configuration
public class DatabaseConfig {
	
	@Bean
	public DataSource dataSource(){
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName("org.h2.Driver");
		source.setUrl("jdbc:h2:~/springtutorial;INIT=runscript from 'classpath:/create.sql'");
		source.setUsername("SA");
		return source;
	}
	
	@Bean
	public CurrencyRateDao currencyRateDao(){
		return new JdbcCurrencyRateDao();
	}
}
