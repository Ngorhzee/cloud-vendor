package com.newjavaproject.cloudvendor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newjavaproject.cloudvendor.models.CloudVendor;
import com.newjavaproject.cloudvendor.service.CloudVendorService;

@RestController
@RequestMapping("/cloud-vendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("{id}")
    public CloudVendor getVendor(@PathVariable("id")String id) {
        return cloudVendorService.getVendor(id);
    }

    @GetMapping
    public List<CloudVendor> getAllVendors() {
        return cloudVendorService.getAllVendor();
    }

    @PostMapping
    public String createVendor(@RequestBody CloudVendor vendor) {

            return cloudVendorService.createVendor(vendor);
    }

    @PutMapping("{id}")
    public CloudVendor updateVendor(@PathVariable("id")String id, @RequestBody CloudVendor vendor) {
     

        return cloudVendorService.updateVendor(vendor, id);

    }

    @DeleteMapping("{id}")
    public String deleteVendor(@PathVariable("id")String id) {
       return cloudVendorService.deleteVendor(id);
    }
}
