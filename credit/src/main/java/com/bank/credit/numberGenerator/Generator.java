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
}
