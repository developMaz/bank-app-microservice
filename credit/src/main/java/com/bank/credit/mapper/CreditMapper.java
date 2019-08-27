package com.bank.credit.mapper;


import com.bank.credit.domain.Credit;
import com.bank.credit.domain.CreditDB;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditMapper {

	public CreditDB mapToCreditDB(final Credit credit) {
		return new CreditDB(
				credit.getCreditID(),
				credit.getCreditName());
	}

	public Credit mapToCredit(final CreditDB creditDB) {
		return new Credit(
				creditDB.getId(),
				creditDB.getCreditName());
	}

	public CreditDB mapCreditDTOToCredit(final Credit credit) {
		return new CreditDB(
				credit.getCreditID(),
				credit.getCreditName());
	}

	public List<Credit> mapToCreditDTOList(final List<CreditDB> creditDBList) {
		return creditDBList.stream()
				.map(c -> new Credit(c.getId(), c.getCreditName()))
				.collect(Collectors.toList());
	}
}
