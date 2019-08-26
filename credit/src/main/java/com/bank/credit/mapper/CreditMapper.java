package com.bank.credit.mapper;


import com.bank.credit.domain.CreditDB;
import com.bank.credit.domain.CreditDTO;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditMapper {

	public CreditDB mapToCreditDB(final CreditDTO creditDTO) {
		return new CreditDB(
				creditDTO.getCreditID(),
				creditDTO.getCreditName());
	}

	public CreditDTO mapToCreditDTO(final CreditDB creditDB) {
		return new CreditDTO(
				creditDB.getId(),
				creditDB.getCreditName());
	}

	public List<CreditDTO> mapToCreditDTOList(final List<CreditDB> creditDBList) {
		return creditDBList.stream()
				.map(c -> new CreditDTO(c.getId(), c.getCreditName()))
				.collect(Collectors.toList());
	}
}
