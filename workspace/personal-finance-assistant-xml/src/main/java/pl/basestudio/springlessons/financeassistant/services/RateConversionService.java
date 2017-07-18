package pl.basestudio.springlessons.financeassistant.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Set;


public class RateConversionService {

	private CurrencyRateProvider rateProvider;
	
	private Set<String> supportedCurr;
	
	
	
	public void setSupportedCurr(Set<String> supportedCurr) {
		this.supportedCurr = supportedCurr;
	}


	public void setRateProvider(CurrencyRateProvider rateProvider){
		this.rateProvider = rateProvider;
	}
	
	
	public BigDecimal convertAmount(BigDecimal amount, String currency) {
		BigDecimal rate = rateProvider.getRate(currency, new Date());
		if(supportedCurr.contains(currency)){
			System.out.println("Waluta w zbiorze walut " + currency);
		}
		System.out.println("RateConversionService: Obliczam kwote");
		BigDecimal result = amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
		return result;
	}

}
