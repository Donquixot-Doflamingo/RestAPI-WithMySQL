package com.SpringApp.RestCRUDApp.controller;

import com.SpringApp.RestCRUDApp.model.CloudVendor;
import com.SpringApp.RestCRUDApp.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    // Read Specific Cloud Vendor Details in DB
    @GetMapping("{vendorID}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorID") String vendorID){
        return cloudVendorService.getCloudVendor(vendorID);
    }

    // Read All Cloud Vendor Details in DB
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor Created Successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor Updated Successfully";
    }

    @DeleteMapping("{vendorID}")
    public String deleteCloudVendorDetails(@PathVariable("vendorID") String vendorID){
        cloudVendorService.deleteCloudVendor(vendorID);
        return "Cloud Vendor Deleted Successfully";
    }
}
