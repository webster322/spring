package pl.basestudio.springlessons.financeassistant.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class RateConversionService {

	private CurrencyRateProvider rateProvider;
	
	@Autowired
	public void setRateProvider(CurrencyRateProvider rateProvider){
		this.rateProvider = rateProvider;
	}
	
	@Autowired(required = false)
	@Qualifier("anotherPrecisionProvider")
	private Map<String, RoundPrecisionProvider> precisionProviders;
	
	@Autowired
	private MessageSource msgSource;
	
	public BigDecimal convertAmount(BigDecimal amount, String currency) throws ParseException {
		Date date = (new SimpleDateFormat("yyyy-mm-dd")).parse("2016-01-24");
		System.out.println(msgSource.getMessage("greetings", null, null));
		BigDecimal rate = rateProvider.getRate(currency, new Date());
		System.out.println("RateConversionService: Obliczam kwote");
		int precision = 2;
		System.out.println("Ilos� dostawc�w: " + precisionProviders.size());
		for(String providerName : precisionProviders.keySet()){
			RoundPrecisionProvider provider = precisionProviders.get(providerName);
			System.out.println("Bean: "+providerName);
			if(provider.isSupported("PLN")){
				precision = provider.getRoundPrecision("PLN");
			}
		}
		BigDecimal result = amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
		return result;
	}

}
