package com.bank.credit.service;

import com.bank.credit.domain.CreditDB;
import com.bank.credit.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditService {

	@Autowired
	CreditRepository creditRepository;

	public List<CreditDB> getAllCredits(){
		return creditRepository.findAll();
	}

	public CreditDB saveCredit(final CreditDB creditDB){
		return creditRepository.save(creditDB);
	}

	public Optional<CreditDB> getCreditById(int id){
		return creditRepository.getCreditById(id);
	}

	public void deleteCredit(CreditDB creditDB){
		creditRepository.delete(creditDB);
	}

}

// TODO checking if save ok
//	private boolean isAllCreditInfoSave = false;
//
//	public boolean checkCredit(int creditID){
//
//		return  isAllCreditInfoSave;
//	}

