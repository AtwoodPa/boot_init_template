package com.pp.boot.domain.wms;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 库存应用
 * @author supanpan
 * @date 2024/07/02
 */
@Data
@AllArgsConstructor
public class InventoryApplication {
    private Long id;
    private String deviceName;
    private String deviceDetails;
    private Boolean approved;
    private String qrCodeUrl;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date updatedAt;

    public InventoryApplication() {
    }
}
