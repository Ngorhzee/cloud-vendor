package com.newjavaproject.cloudvendor.service;

import java.util.List;

import com.newjavaproject.cloudvendor.models.CloudVendor;

public interface CloudVendorService {
    
    public CloudVendor getVendor(String id);
    public CloudVendor updateVendor(CloudVendor vendor,String id);
    public String createVendor(CloudVendor vendor);
    public String deleteVendor(String id);
    public List<CloudVendor> getAllVendor();
}
