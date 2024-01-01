package com.restwithmysql.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restwithmysql.Entity.CloudVendor;
import com.restwithmysql.Exception.CloudVendorNotFoundException;
import com.restwithmysql.Repository.CloudVendorRepository;
//import com.restwithmysql.Service.CloudVendorService;

@Service
public class CloudVendorServiceImplement implements CloudVendorService {
	
	CloudVendorRepository cloudVendorRepository;
	
	public CloudVendorServiceImplement(CloudVendorRepository cloudVendorRepository) {
		this.cloudVendorRepository = cloudVendorRepository;
	}
	
	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "Success";
	}
	
	@Override
	public List<CloudVendor> getAllCloudVendors() {
		return cloudVendorRepository.findAll();
	}
	
	@Override
	public CloudVendor getCloudVendor(String cloudVendorId) {
		if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
			throw new CloudVendorNotFoundException("Requested cloud vendor does not exist");
		return cloudVendorRepository.findById(cloudVendorId).get();
	}
	
	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "updated";
	}
	
	@Override
	public String deleteCloudVendor(String cloudVendorId) {
		// TODO Auto-generated method stub
		cloudVendorRepository.deleteById(cloudVendorId);
		return null;
	}
}
