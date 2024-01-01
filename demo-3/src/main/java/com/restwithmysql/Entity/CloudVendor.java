package com.restwithmysql.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cloud_vendor_info")
@Getter
@Setter
public class CloudVendor {
	@Id
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
