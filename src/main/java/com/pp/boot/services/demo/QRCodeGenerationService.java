package com.pp.boot.services.demo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.pp.boot.model.entity.demo.InventoryApplication;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * 二维码服务
 *
 * @author supanpan
 * @date 2024/07/02
 */
@Service
public class QRCodeGenerationService {

    private static final String CHARSET = "UTF-8";
    private static final int QR_CODE_WIDTH = 300;
    private static final int QR_CODE_HEIGHT = 300;
    private static final String TEMP_DIR = System.getProperty("java.io.tmpdir");


    /**
     * 生成二维码
     * 包含设备信息
     * @param application
     * @return
     */
    public String generateQRCode(InventoryApplication application) {
        String qrCodeText = "设备名称: " + application.getDeviceName() + ", 设备详情: " + application.getDeviceDetails()+ ", 设备ID: " + application.getId();;
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Map<EncodeHintType, Object> hintMap = new HashMap<>();
            hintMap.put(EncodeHintType.CHARACTER_SET, CHARSET);
            BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, QR_CODE_WIDTH, QR_CODE_HEIGHT, hintMap);
            Path tempFilePath = Files.createTempFile(Paths.get(TEMP_DIR), "qr_", ".png");
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", tempFilePath);
            return tempFilePath.toString();
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] generateQRCodeImage(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.CHARACTER_SET, CHARSET);
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, QR_CODE_WIDTH, QR_CODE_HEIGHT, hintMap);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        return outputStream.toByteArray();
    }

    public String saveQRCodeImageToTempFile(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.CHARACTER_SET, CHARSET);
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, QR_CODE_WIDTH, QR_CODE_HEIGHT, hintMap);
        Path tempFilePath = Files.createTempFile(Paths.get(TEMP_DIR), "qr_", ".png");
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", tempFilePath);
        return tempFilePath.toString();
    }

}
