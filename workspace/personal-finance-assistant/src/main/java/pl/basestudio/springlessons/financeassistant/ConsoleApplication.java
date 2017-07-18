package pl.basestudio.springlessons.financeassistant;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.basestudio.springlessons.financeassistant.dto.CurrencyRate;
import pl.basestudio.springlessons.financeassistant.services.RateConversionService;
import pl.basestudio.springlessons.financeassistant.services.RateUpdateService;

public class ConsoleApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, AppConfigProd.class);
		RateConversionService service = context.getBean(RateConversionService.class);
		service.convertAmount(BigDecimal.valueOf(123.00), "EUR");
		
		RateUpdateService rateUpdateService = context.getBean(RateUpdateService.class);
		rateUpdateService.storeRate(new CurrencyRate("USD", new Date(), BigDecimal.valueOf(4.1567)));
		
		List<CurrencyRate> currencyRates = new ArrayList<CurrencyRate>();
		
		for(int i=0; i<100; i++){
			currencyRates.add(new CurrencyRate("USD", new Date(), BigDecimal.valueOf(4.1567)));
		}
		rateUpdateService.storeManyRates(currencyRates );
	}

}
