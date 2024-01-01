package com.abhi.vendor.restdemo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CloudVendor {
	private String vendorId;
	private String vendorName;
	private String vendorAddress;
	private String vendorPhoneNumber;
	
	public CloudVendor() {
		
	}
	
	public CloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorPhoneNumber) {
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorPhoneNumber = vendorPhoneNumber;
	}
	
}
