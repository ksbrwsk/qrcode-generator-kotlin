package de.ksbrwsk.qrcode.service

import com.google.zxing.BinaryBitmap
import com.google.zxing.DecodeHintType
import com.google.zxing.LuminanceSource
import com.google.zxing.client.j2se.BufferedImageLuminanceSource
import com.google.zxing.common.HybridBinarizer
import com.google.zxing.qrcode.QRCodeReader
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.awt.image.BufferedImage
import java.io.File
import java.util.*
import javax.imageio.ImageIO

@Component
class QrCodeDecoder {

    val log = LoggerFactory.getLogger(QrCodeDecoder::class.java)

    fun decodeQrCodeFile(qrCodeFile: File): String {
        log.info("Deocding file {}", qrCodeFile.name)
        val bufferedImage: BufferedImage = ImageIO.read(qrCodeFile)
        val luminanceSource: LuminanceSource = BufferedImageLuminanceSource(bufferedImage)
        val binaryBitmap = BinaryBitmap(HybridBinarizer(luminanceSource))
        val hintMap: MutableMap<DecodeHintType, Any?> = EnumMap(
            DecodeHintType::class.java
        )
        hintMap[DecodeHintType.CHARACTER_SET] = "UTF-8"
        hintMap[DecodeHintType.PURE_BARCODE] = Void::class.java
        val result = QRCodeReader().decode(binaryBitmap, hintMap)
        log.info("file {} successfully decoded", qrCodeFile.name)
        return result.text
    }
}