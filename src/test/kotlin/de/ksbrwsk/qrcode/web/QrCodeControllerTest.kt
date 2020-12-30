package de.ksbrwsk.qrcode.web

import de.ksbrwsk.qrcode.model.QrCodeEmail
import de.ksbrwsk.qrcode.model.QrCodePhone
import de.ksbrwsk.qrcode.model.QrCodeUrl
import de.ksbrwsk.qrcode.model.QrCodeVCard
import de.ksbrwsk.qrcode.utils.TestUtils
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.validation.BindingResult
import org.springframework.validation.support.BindingAwareModelMap

@SpringBootTest
internal class QrCodeControllerTest(@Autowired val qrCodeController: QrCodeController) {

    @Test
    fun thatIndexPasses() {
        val expected = "index"
        val actual: String? = qrCodeController.index(TestUtils.createModel())
        assertNotNull(actual)
        assertEquals(expected, actual)
    }

    @Test
    fun thatQrCodeUrlPasses() {
        val expected = "qr-code-url"
        val model: BindingAwareModelMap = TestUtils.createModel()
        val actual: String? = qrCodeController.qrCodeUrl(model)
        assertNotNull(actual)
        assertEquals(expected, actual)
        assertNotNull(model["qrCodeUrl"])
    }

    @Test
    fun thatProcessQrCodeUrlPasses() {
        val expected = "result"
        val qrCodeUrl = QrCodeUrl("http://www.google.com")
        val model: BindingAwareModelMap = TestUtils.createModel()
        val bindingResult: BindingResult = TestUtils.createBindingResult(qrCodeUrl)
        val actual: String? = qrCodeController.processUrl(model, qrCodeUrl, bindingResult)
        assertNotNull(actual)
        assertEquals(expected, actual)
        assertNotNull(model["image"])
        assertNull(model["qrCodeUrl"])
    }

    @Test
    fun thatProcessQrCodePhonePasses() {
        val expected = "result"
        val qrCodePhone = QrCodePhone("+15551234567")
        val model: BindingAwareModelMap = TestUtils.createModel()
        val bindingResult: BindingResult = TestUtils.createBindingResult(qrCodePhone)
        val actual: String? = qrCodeController.processPhone(model, qrCodePhone, bindingResult)
        assertNotNull(actual)
        assertEquals(expected, actual)
        assertNotNull(model["image"])
        assertNull(model["qrCodePhone"])
    }

    @Test
    fun thatQrCodePhonePasses() {
        val expected = "qr-code-phone"
        val model: BindingAwareModelMap = TestUtils.createModel()
        val actual: String? = qrCodeController.qrCodePhone(model)
        assertNotNull(actual)
        assertEquals(expected, actual)
        assertNotNull(model["qrCodePhone"])
    }

    @Test
    fun thatProcessQrCodeEmailPasses() {
        val expected = "result"
        val qrCodeEmail = QrCodeEmail("email@email.com")
        val model: BindingAwareModelMap = TestUtils.createModel()
        val bindingResult: BindingResult = TestUtils.createBindingResult(qrCodeEmail)
        val actual: String? = qrCodeController.processEmail(model, qrCodeEmail, bindingResult)
        assertNotNull(actual)
        assertEquals(expected, actual)
        assertNotNull(model["image"])
        assertNull(model["qrCodeEmail"])
    }

    @Test
    fun thatQrCodeEmailPasses() {
        val expected = "qr-code-email"
        val model: BindingAwareModelMap = TestUtils.createModel()
        val actual: String? = qrCodeController.qrCodeEmail(model)
        assertNotNull(actual)
        assertEquals(expected, actual)
        assertNotNull(model["qrCodeEmail"])
    }

    @Test
    fun thatProcessQrCodeVCardPasses() {
        val expected = "result"
        val qrCodeVCard = QrCodeVCard("Name", "Lastname")
        val model: BindingAwareModelMap = TestUtils.createModel()
        val bindingResult: BindingResult = TestUtils.createBindingResult(qrCodeVCard)
        val actual: String? = qrCodeController.processVCard(model, qrCodeVCard, bindingResult)
        assertNotNull(actual)
        assertEquals(expected, actual)
        assertNotNull(model["image"])
        assertNull(model["qrCodeVCard"])
    }

    @Test
    fun thatQrCodeVCardPasses() {
        val expected = "qr-code-vcard"
        val model: BindingAwareModelMap = TestUtils.createModel()
        val actual: String? = qrCodeController.qrCodeVCard(model)
        assertNotNull(actual)
        assertEquals(expected, actual)
        assertNotNull(model["qrCodeVCard"])
    }
}