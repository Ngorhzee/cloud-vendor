package com.newjavaproject.cloudvendor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.newjavaproject.cloudvendor.exceptions.CloudVendorNotFound;
import com.newjavaproject.cloudvendor.models.CloudVendor;
import com.newjavaproject.cloudvendor.repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudVendorService{
CloudVendorRepository cloudVendorRepository;


    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
    this.cloudVendorRepository = cloudVendorRepository;
}

    @Override
    public CloudVendor getVendor(String id) {
        if(cloudVendorRepository.findById(id).isEmpty()){
            throw new CloudVendorNotFound("Cloud Vendor does not exist");
        }
     return cloudVendorRepository.findById(id).get();
    }

    @Override
    public CloudVendor updateVendor(CloudVendor vendor,String id) {
        if(cloudVendorRepository.findById(id).isEmpty()){
            throw new CloudVendorNotFound("Cloud Vendor does not exist");
        }
     CloudVendor vendorToUpdate = cloudVendorRepository.findById(id).get();
     if(vendorToUpdate!=null){
        if(vendor.getName()!=null) {
            vendorToUpdate.setName(vendor.getName());;
        }
        if(vendor.getPhoneNumber()!=null) {
            vendorToUpdate.setPhoneNumber(vendor.getPhoneNumber());
        }
        if(vendor.getAddress()!=null) {
            vendorToUpdate.setAddress(vendor.getAddress());
        }
     }
   
       cloudVendorRepository.save(vendorToUpdate);
       return vendorToUpdate;
    }

    @Override
    public String createVendor(CloudVendor vendor) {
       cloudVendorRepository.save(vendor);
       return "Cloud Vendor Created Succesfully";
    }

    @Override
    public String deleteVendor(String id) {
        if(cloudVendorRepository.findById(id).isEmpty()){
            throw new CloudVendorNotFound("Cloud Vendor does not exist");
        }
       cloudVendorRepository.deleteById(id);
       return "Vendor deleted succesfully";
    }

    @Override
    public List<CloudVendor> getAllVendor() {
       return cloudVendorRepository.findAll();
    }
    
}
