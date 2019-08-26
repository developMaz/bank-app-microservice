package com.bank.credit.numberGenerator;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Generator {

	Random random = new Random();

	public int generateCreditNumber() {
		int creditNumber = random.nextInt(8999) + 1000;
		return creditNumber;
	}

// TODO deal with it
//	Random random = new Random();
//
//	@Autowired
//	DatabaseController databaseController;
//
//	@Autowired
//	public int creditNumberGenerator(String individualNumber) {
//		int creditNumber = generateNumber(individualNumber);
//
//		if (
//
//
//	 //check if exist
//	 boolean isCreditNumberExist = true;
//	 if (!isCreditNumberExist)
//		String substringPesel = individualNumber.substring(6);
//		String controlNumber = String.valueOf(random.nextInt(99) + 100));
//		String creditNumber = substringPesel + controlNumber;
//
//		int parsedCreditNumber = Integer.parseUnsignedInt(creditNumber);
//
//		return parsedCreditNumber;
//	}
//
//	public int generateNumber(String individualNumber) {
//		String substringPesel = individualNumber.substring(6);
//		String controlNumber = String.valueOf(random.nextInt(99) + 100));
//		String creditNumber = substringPesel + controlNumber;
//
//		int parsedCreditNumber = Integer.parseUnsignedInt(creditNumber);
//
//		return parsedCreditNumber;
//	}

}
