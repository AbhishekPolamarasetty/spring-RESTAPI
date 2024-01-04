package com.restwithmysql.Service;

import java.util.List;

import com.restwithmysql.Entity.CloudVendor;

public interface CloudVendorService {
	public String createCloudVendor(CloudVendor cloudVendor);
	public String updateCloudVendor(CloudVendor cloudVendor);
	public String deleteCloudVendor(String cloudVendorId);
	public CloudVendor getCloudVendor(String cloudVendorId);
	public List <CloudVendor> getAllCloudVendors();
}
