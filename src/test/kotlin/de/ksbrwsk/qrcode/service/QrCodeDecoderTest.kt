package de.ksbrwsk.qrcode.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.ClassPathResource

@SpringBootTest
internal class QrCodeDecoderTest(@Autowired val qrCodeDecoder: QrCodeDecoder) {

    @Test
    @Throws(Exception::class)
    fun thatDecodingQrCodeEmailPasses() {
        val expected = "mailto:email@email.com?subject=just%20a%20test"
        val resource = ClassPathResource("decodeQrCodeEmailAndSubject.png")
        val qrCodeFile = resource.file
        val actual: String = qrCodeDecoder.decodeQrCodeFile(qrCodeFile)
        assertNotNull(actual)
        assertEquals(expected, actual)
    }

    @Test
    @Throws(Exception::class)
    fun thatDecodingQrCodePhonePasses() {
        val expected = "tel:+15551234567"
        val resource = ClassPathResource("decodeQrCodePhone.png")
        val qrCodeFile = resource.file
        val actual: String = qrCodeDecoder.decodeQrCodeFile(qrCodeFile)
        assertNotNull(actual)
        assertEquals(expected, actual)
    }

    @Test
    @Throws(Exception::class)
    fun thatDecodingQrCodeUrlPasses() {
        val expected = "http://www.google.com"
        val resource = ClassPathResource("decodeQrCodeUrl.png")
        val qrCodeFile = resource.file
        val actual: String = qrCodeDecoder.decodeQrCodeFile(qrCodeFile)
        assertNotNull(actual)
        assertEquals(expected, actual)
    }

    @Test
    @Throws(Exception::class)
    fun thatDecodingQrCodeVCardPasses() {
        val expected = """
            BEGIN:VCARD
            VERSION:4.0
            N:Norris;Chuck;;;
            FN:Chuck Norris
            TITLE:Mr. Roundhousekick
            ORG:My Organisation
            END:VCARD
            """.trimIndent()
        val resource = ClassPathResource("decodeQrCodeVCard.png")
        val qrCodeFile = resource.file
        val actual: String = qrCodeDecoder.decodeQrCodeFile(qrCodeFile)
        assertNotNull(actual)
        assertEquals(expected, actual)
    }

    @Test
    @Throws(Exception::class)
    fun thatDecodingQrCodeVCardCompletePasses() {
        val expected = """
            BEGIN:VCARD
            VERSION:4.0
            N:Norris;Chuck;;;
            FN:Chuck Norris
            TITLE:Mr. Roundhousekick
            ORG:My Organisation
            EMAIL:chuck@norris.com
            EMAIL:chuck@gmail.com
            TEL;TYPE=WORK:+15551234567
            ADR;TYPE=HOME:;;42 Plantation St.;Baytown;LA;30314;USA
            LABEL;TYPE=HOME:42 Plantation St.
            Baytown,LA 30314
            USA
            END:VCARD
            """.trimIndent()
        val resource = ClassPathResource("decodeQrCodeVCardComplete.png")
        val qrCodeFile = resource.file
        val actual: String = qrCodeDecoder.decodeQrCodeFile(qrCodeFile)
        assertNotNull(actual)
        assertEquals(expected, actual)
    }
}