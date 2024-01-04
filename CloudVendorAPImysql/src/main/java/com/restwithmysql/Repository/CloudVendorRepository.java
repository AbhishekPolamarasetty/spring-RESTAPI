package com.restwithmysql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restwithmysql.Entity.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String>{
}
