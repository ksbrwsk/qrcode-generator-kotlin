package de.ksbrwsk.qrcode.web

import de.ksbrwsk.qrcode.config.ApplicationProperties
import de.ksbrwsk.qrcode.model.*
import de.ksbrwsk.qrcode.service.QrCodeEncoder
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import jakarta.validation.Valid

@Controller
class QrCodeController(
    val applicationProperties: ApplicationProperties,
    val qrCodeEncoder: QrCodeEncoder
) {
    val pageIndex = "index"
    val pageResult = "result"
    val pageQrCodeUrl = "qr-code-url"
    val pageQrCodePhone = "qr-code-phone"
    val pageQrCodeVCard = "qr-code-vcard"
    val pageQrCodeEmail = "qr-code-email"
    val pageQrCodeSms = "qr-code-sms"
    val qrCodeImage = "image"
    val textToBeEncoded = "text"
    val successMessage = "successMessage"
    val errorMessage = "errorMessage"

    val log = LoggerFactory.getLogger(QrCodeController::class.java)

    @GetMapping(value = ["/", "/index"])
    fun index(model: Model): String? {
        addCommonModelAttributes(model)
        return pageIndex
    }

    @GetMapping("/qr-code-url")
    fun qrCodeUrl(model: Model): String? {
        addCommonModelAttributes(model)
        model.addAttribute("qrCodeUrl", QrCodeUrl(""))
        return pageQrCodeUrl
    }

    @PostMapping("/process/url")
    fun processUrl(
        model: Model,
        @ModelAttribute("qrCodeUrl") @Valid qrCodeUrl: QrCodeUrl?,
        bindingResult: BindingResult
    ): String? {
        addCommonModelAttributes(model)
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Url {}", qrCodeUrl!!.urlToBeEncoded)
            val result = qrCodeEncoder.generateQrCodeUrl(qrCodeUrl)
            addResultModelAttributes(model, result!!)
            return pageResult
        }
        return pageQrCodeUrl
    }

    @GetMapping("/qr-code-phone")
    fun qrCodePhone(model: Model): String? {
        addCommonModelAttributes(model)
        model.addAttribute("qrCodePhone", QrCodePhone(""))
        return pageQrCodePhone
    }

    @PostMapping("/process/phone")
    fun processPhone(
        model: Model,
        @ModelAttribute("qrCodePhone") @Valid qrCodePhone: QrCodePhone?,
        bindingResult: BindingResult
    ): String? {
        addCommonModelAttributes(model)
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Phone number {}", qrCodePhone!!.phoneToBeEncoded)
            val result = qrCodeEncoder.generateQrCodePhone(qrCodePhone)
            addResultModelAttributes(model, result!!)
            return pageResult
        }
        return pageQrCodePhone
    }

    @GetMapping("/qr-code-email")
    fun qrCodeEmail(model: Model): String? {
        addCommonModelAttributes(model)
        model.addAttribute("qrCodeEmail", QrCodeEmail(""))
        return pageQrCodeEmail
    }

    @PostMapping("/process/email")
    fun processEmail(
        model: Model,
        @ModelAttribute("qrCodeEmail") @Valid qrCodeEmail: QrCodeEmail?,
        bindingResult: BindingResult
    ): String? {
        addCommonModelAttributes(model)
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Email {}", qrCodeEmail!!.emailToBeEncoded)
            val result = qrCodeEncoder.generateQrCodeEmail(qrCodeEmail)
            addResultModelAttributes(model, result!!)
            return pageResult
        }
        return pageQrCodeEmail
    }

    @GetMapping("/qr-code-sms")
    fun qrCodeSms(model: Model): String? {
        addCommonModelAttributes(model)
        model.addAttribute("qrCodeSms", QrCodeSms(""))
        return pageQrCodeSms
    }

    @PostMapping("/process/sms")
    fun processSms(
        model: Model,
        @ModelAttribute("qrCodeSms") @Valid qrCodeSms: QrCodeSms?,
        bindingResult: BindingResult
    ): String? {
        addCommonModelAttributes(model)
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for SMS {}", qrCodeSms!!.phoneToBeEncoded)
            val result = qrCodeEncoder.generateQrCodeSms(qrCodeSms)
            addResultModelAttributes(model, result!!)
            return pageResult
        }
        return pageQrCodeSms
    }

    @GetMapping("/qr-code-vcard")
    fun qrCodeVCard(model: Model): String? {
        addCommonModelAttributes(model)
        model.addAttribute("qrCodeVCard", QrCodeVCard("", ""))
        return pageQrCodeVCard
    }

    @PostMapping("/process/vcard")
    fun processVCard(
        model: Model,
        @ModelAttribute("qrCodeVCard") @Valid qrCodeVCard: QrCodeVCard?,
        bindingResult: BindingResult
    ): String? {
        addCommonModelAttributes(model)
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for VCard {}", qrCodeVCard!!.name)
            val result = qrCodeEncoder.generateQrCodeVCard(qrCodeVCard)
            addResultModelAttributes(model, result!!)
            return pageResult
        }
        return pageQrCodeVCard
    }

    private fun addCommonModelAttributes(model: Model) {
        model.addAttribute("titleMessage", applicationProperties.title)
        model.addAttribute("appInfo", applicationProperties.appInfo)
    }

    private fun addResultModelAttributes(model: Model, result: QrCodeProcessingResult) {
        model.addAttribute(qrCodeImage, result.image)
        model.addAttribute(textToBeEncoded, result.encodedText)
        if (result.isSuccessfull()) {
            model.addAttribute(successMessage, result.successMessage)
        } else {
            model.addAttribute(errorMessage, result.errorMessage)
        }
    }
}