package com.pp.boot.services;

import com.pp.boot.domain.wms.InventoryApplication;
import com.pp.boot.mapper.InventoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author supanpan
 * @date 2024/07/02
 */
@Service
public class InventoryService {
    @Autowired
    private  InventoryMapper inventoryMapper;
    @Autowired
    private QRCodeGenerationService qrCodeGenerationService;


    public void createApplication(InventoryApplication application) {
        application.setCreatedAt(new java.util.Date());
        application.setUpdatedAt(new java.util.Date());
        inventoryMapper.insertApplication(application);
    }

    public void reviewApplication(Long id, boolean approved) {
        InventoryApplication application = inventoryMapper.selectApplicationById(id);
        if (application == null) {
            throw new RuntimeException("申请单不存在");
        }
        application.setApproved(approved);

        if (approved) {
            String qrCodeUrl = qrCodeGenerationService.generateQRCode(application);
            application.setQrCodeUrl(qrCodeUrl);
        }

        inventoryMapper.updateApplication(application);
    }

    public InventoryApplication getApplicationDetails(Long id) {
        return inventoryMapper.selectApplicationById(id);
    }
}
