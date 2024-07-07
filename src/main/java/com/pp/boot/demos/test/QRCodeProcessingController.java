package com.pp.boot.demos.test;

import com.google.zxing.WriterException;
import com.pp.boot.services.demo.QRCodeGenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author supanpan
 * @date 2024/07/02
 */
@RequestMapping("/qrcode")
@RestController
@RequiredArgsConstructor
public class QRCodeProcessingController {
    final QRCodeGenerationService qrCodeGenerationService;

    @PostMapping("/generateQRCode")
    public ResponseEntity<String> generateQRCode(@RequestParam String content) {
        try {
            String qrCodeUrl = qrCodeGenerationService.saveQRCodeImageToTempFile(content);
            return new ResponseEntity<>(qrCodeUrl, HttpStatus.OK);
        } catch (IOException | WriterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
