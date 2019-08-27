package com.bank.credit.domain;

public class Credit {

	private int creditID;
	private String creditName;

	public Credit(int creditID, String creditName) {
		this.creditID = creditID;
		this.creditName = creditName;
	}

	public Credit(String creditName) {
		this.creditName = creditName;
	}

	public Credit() {

	}

	public int getCreditID() {
		return creditID;
	}


	public String getCreditName() {
		return creditName;
	}

	public void setCreditID(int creditID) {
		this.creditID = creditID;
	}

	public void setCreditName(String creditName) {
		this.creditName = creditName;
	}

	@Override
	public String toString() {
		return "CreditDTO{" +
				"creditName='" + creditName + '\'' +
				'}';
	}
}
