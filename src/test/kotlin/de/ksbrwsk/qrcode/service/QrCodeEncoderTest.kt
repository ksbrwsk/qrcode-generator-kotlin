package de.ksbrwsk.qrcode.service

import de.ksbrwsk.qrcode.model.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class QrCodeEncoderTest(@Autowired val qrCodeEncoder: QrCodeEncoder) {

    @Test
    fun generateQrCodeUrl() {
        val qrCodeUrl = QrCodeUrl("http://www.google.com")
        val result = qrCodeEncoder.generateQrCodeUrl(qrCodeUrl)
        assertNotNull(result)
        assertTrue(result!!.isSuccessfull())
        assertNotNull(result.image)
        assertNotNull(result.encodedText)
        assertFalse(result.hasError())
    }

    @Test
    fun generateQrCodeEmail() {
        val qrCodeEmail = QrCodeEmail("email@email.com")
        val result = qrCodeEncoder.generateQrCodeEmail(qrCodeEmail)
        assertNotNull(result)
        assertTrue(result!!.isSuccessfull())
        assertNotNull(result.image)
        assertNotNull(result.encodedText)
        assertFalse(result.hasError())
    }

    @Test
    fun generateQrCodeEmailAndSubject() {
        val qrCodeEmail = QrCodeEmail("email@email.com", "just a test")
        val result = qrCodeEncoder.generateQrCodeEmail(qrCodeEmail)
        assertTrue(result!!.isSuccessfull())
        assertNotNull(result.image)
        assertNotNull(result.encodedText)
        assertFalse(result.hasError())
    }

    @Test
    fun generateQrCodeSms() {
        val qrCodeSms = QrCodeSms("+491234567890")
        val result = qrCodeEncoder.generateQrCodeSms(qrCodeSms)
        assertNotNull(result)
        assertTrue(result!!.isSuccessfull())
        assertNotNull(result.image)
        assertNotNull(result.encodedText)
        assertFalse(result.hasError())
    }

    @Test
    fun generateQrCodeSmsAndMessage() {
        val qrCodeSms = QrCodeSms("+49123456789", "just a test")
        val result = qrCodeEncoder.generateQrCodeSms(qrCodeSms)
        assertTrue(result!!.isSuccessfull())
        assertNotNull(result.image)
        assertNotNull(result.encodedText)
        assertFalse(result.hasError())
    }

    @Test
    fun generateQrCodePhone() {
        val qrCodePhone = QrCodePhone("+15551234567")
        val result = qrCodeEncoder.generateQrCodePhone(qrCodePhone)
        assertTrue(result!!.isSuccessfull())
        assertNotNull(result.image)
        assertNotNull(result.encodedText)
        assertFalse(result.hasError())
    }

    @Test
    fun generateQrCodeVCard() {
        val qrCodeVCard = QrCodeVCard(name = "Chuck", lastname = "Norris")
        qrCodeVCard.organisation = "My Organisation"
        qrCodeVCard.title = "Mr. Roundhousekick"
        val result = qrCodeEncoder.generateQrCodeVCard(qrCodeVCard)
        assertTrue(result!!.isSuccessfull())
        assertNotNull(result.image)
        assertNotNull(result.encodedText)
        assertFalse(result.hasError())
    }

    @Test
    fun generateQrCodeVCardComplete() {
        val qrCodeVCard = QrCodeVCard("Chuck", "Norris")
        qrCodeVCard.title = "Mr. Roundhousekick"
        qrCodeVCard.organisation = "My Organisation"
        qrCodeVCard.email1 = "chuck@norris.com"
        qrCodeVCard.email2 = "chuck@gmail.com"
        qrCodeVCard.adress1Street = "42 Plantation St."
        qrCodeVCard.adress1Locality = "Baytown"
        qrCodeVCard.adress1Region = "LA"
        qrCodeVCard.adress1PostalCode = "30314"
        qrCodeVCard.adress1Country = "USA"
        qrCodeVCard.adress1Type = QrCodeEnumType.HOME
        qrCodeVCard.phone1 = "+15551234567"
        qrCodeVCard.phone1Type = QrCodeEnumType.WORK
        val result = qrCodeEncoder.generateQrCodeVCard(qrCodeVCard)
        assertTrue(result!!.isSuccessfull())
        assertNotNull(result.successMessage)
        assertNotNull(result.image)
        assertNotNull(result.encodedText)
        assertFalse(result.hasError())
    }
}