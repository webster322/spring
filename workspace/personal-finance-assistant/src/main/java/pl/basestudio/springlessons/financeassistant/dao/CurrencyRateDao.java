package pl.basestudio.springlessons.financeassistant.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import pl.basestudio.springlessons.financeassistant.dto.CurrencyRate;

public interface CurrencyRateDao {
	BigDecimal getRate(String currency, Date rateDate);
	CurrencyRate getRateInfo(String currency, Date rateDate);
	void addRate(CurrencyRate currencyRate);
	void addManyRates(List<CurrencyRate> currencyRates);
}
