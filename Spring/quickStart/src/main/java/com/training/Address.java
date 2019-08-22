package com.training;

public class Address {
	
	public Address(String addrLine1, String city, long pinCode) {
		super();
		this.addrLine1 = addrLine1;
		this.city = city;
		this.pinCode = pinCode;
	}
	private String addrLine1;
	private String city;
	private long pinCode;
	public String getAddrLine1() {
		return addrLine1;
	}
	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPinCode() {
		return pinCode;
	}
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Address [addrLine1=" + addrLine1 + ", city=" + city + ", pinCode=" + pinCode + "]";
	}

}
