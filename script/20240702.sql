-- 设备表
CREATE TABLE inventory_application
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键，自增',
    device_name    VARCHAR(255) NOT NULL COMMENT '设备名称',
    device_details TEXT COMMENT '设备详细信息',
    approved       BOOLEAN   DEFAULT FALSE COMMENT '审核状态，默认未审核',
    qr_code_url    VARCHAR(255) COMMENT '二维码图片的URL',
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间'
) COMMENT '设备入库申请表';
