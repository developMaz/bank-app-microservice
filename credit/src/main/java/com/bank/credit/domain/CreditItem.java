package com.bank.credit.domain;

public class CreditItem {

	private int creditNumber;
	private CreditInfo creditInfo;

	public CreditItem(int creditNumber, CreditInfo creditInfo) {
		this.creditNumber = creditNumber;
		this.creditInfo = creditInfo;
	}

	public CreditItem (CreditInfo creditInfo) {
		this.creditInfo = creditInfo;
		this.creditNumber = creditInfo.getCredit().getCreditID();
	}


	public int getCreditNumber() {
		return creditNumber;
	}

	public CreditInfo getCreditInfo() {
		return creditInfo;
	}

	@Override
	public String toString() {
		return "CreditItem{" +
				"creditNumber=" + creditNumber +
				'}';
	}
}
