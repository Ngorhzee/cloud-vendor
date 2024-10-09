package com.newjavaproject.cloudvendor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
     return cloudVendorRepository.findById(id).get();
    }

    @Override
    public CloudVendor updateVendor(CloudVendor vendor,String id) {
     Optional<CloudVendor> vendorToUpdate = cloudVendorRepository.findById(id);
     if(vendorToUpdate!=null){
        if(vendor.getName()!=null) {
            vendorToUpdate.get().setName(vendor.getName());;
        }
        if(vendor.getPhoneNumber()!=null) {
            vendorToUpdate.get().setPhoneNumber(vendor.getPhoneNumber());
        }
        if(vendor.getAddress()!=null) {
            vendorToUpdate.get().setAddress(vendor.getAddress());
        }
     }
   
       cloudVendorRepository.save(vendorToUpdate.get());
       return vendorToUpdate.get();
    }

    @Override
    public String createVendor(CloudVendor vendor) {
       cloudVendorRepository.save(vendor);
       return "Cloud Vendor Created Succesfully";
    }

    @Override
    public String deleteVendor(String id) {
       cloudVendorRepository.deleteById(id);
       return "Vendor deleted succesfully";
    }

    @Override
    public List<CloudVendor> getAllVendor() {
       return cloudVendorRepository.findAll();
    }
    
}
