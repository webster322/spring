package pl.basestudio.springlessons.financeassistant.services;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class FileCurrencyRateProvider implements CurrencyRateProvider {
	
	@Value("$(filename)")
	private String fileName;
	
	public BigDecimal getRate(String currency, Date rateDate) {
		System.out.println("FileCurrencyRateProvider: Wczytano kursy z pliku lokalnego "+fileName);
		return BigDecimal.valueOf(4.25);
	}

}
