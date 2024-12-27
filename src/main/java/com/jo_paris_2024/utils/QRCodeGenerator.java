package com.jo_paris_2024.utils;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class QRCodeGenerator {

    public static byte[] generateQRCodeAsBytes(String content, int width, int height) throws WriterException, IOException {
        // Créer un QR code writer
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        // Générer le BitMatrix(class Java) pour le QR code
        BitMatrix matrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);

        // Spécifier la configuration pourle rendu d'image
        MatrixToImageConfig config = new MatrixToImageConfig(0xFF000000, 0xFFFFFFFF);

        // Convertir BitMatrix en BufferedImage
        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(matrix, config);

        // Ecrire le BufferedImage dans un array de type byte
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(qrImage, "PNG", baos);
            return baos.toByteArray();
        }
    }
}
