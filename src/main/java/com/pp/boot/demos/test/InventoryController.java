package com.pp.boot.demos.test;

import com.pp.boot.common.base.Result;
import com.pp.boot.model.entity.InventoryApplication;
import com.pp.boot.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author supanpan
 * @date 2024/07/02
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    //    @PostMapping("/apply")
//
//    public Result applyForInventory(@RequestBody InventoryApplication application) {
//        inventoryService.createApplication(application);
//        return Result.ok("申请单提交成功");
//    }
    @PostMapping("/apply")
    public Result applyInventoryApplications(
            @RequestParam(name = "deviceName", defaultValue = "1", required = false) String deviceName,
            @RequestParam(name = "deviceDetails", defaultValue = "1", required = false) String deviceDetails,
            @RequestParam(name = "approved", defaultValue = "1", required = false) String approved) {
        InventoryApplication application = new InventoryApplication();
        application.setDeviceName(deviceName);
        application.setDeviceDetails(deviceDetails);
        application.setApproved(Boolean.valueOf(approved));
        inventoryService.createApplication(application);
        return Result.ok("申请单提交成功");
    }

    @PostMapping("/review/{id}")
    public Result reviewApplication(@PathVariable("id") Long id, @RequestParam boolean approved) {
        inventoryService.reviewApplication(id, approved);
        return Result.ok("审核完成");
    }

//    @PostMapping("/review")
//    public Result reviewApplication(@RequestParam Long id, @RequestParam boolean approved) {
//        inventoryService.reviewApplication(id, approved);
//        return Result.ok("审核完成");
//    }
    @GetMapping("/details/{id}")
    public Result getInventoryDetails(@PathVariable Long id) {
        InventoryApplication application = inventoryService.getApplicationDetails(id);
        if (application != null) {
            return Result.ok(application);
        } else {
            return Result.fail("设备信息不存在");
        }
    }
}

