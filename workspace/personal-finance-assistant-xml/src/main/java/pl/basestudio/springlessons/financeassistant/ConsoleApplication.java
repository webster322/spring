package pl.basestudio.springlessons.financeassistant;

import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.basestudio.springlessons.financeassistant.services.RateConversionService;

public class ConsoleApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/pl/basestudio/springlessons/financeassistant/appconfig.xml");
		RateConversionService service = context.getBean(RateConversionService.class);
		service.convertAmount(BigDecimal.valueOf(123.00), "EUR");

	}

}
