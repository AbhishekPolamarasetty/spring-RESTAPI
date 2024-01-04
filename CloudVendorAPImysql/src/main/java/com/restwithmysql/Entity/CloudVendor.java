package com.restwithmysql.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("vendor_Id")
	private String vendorId;
	@JsonProperty("vendor_name")
	private String vendorName;
	@JsonProperty("vendor_address")
	private String vendorAddress;
	@JsonProperty("vendor_phone")
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
