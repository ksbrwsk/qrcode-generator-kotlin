package de.ksbrwsk.qrcode.model

class QrCodeSmsParser(private val qrCodeSms: QrCodeSms) : AbstractQrCodeParser() {

    override fun parse(): String {
        var toEncode = "sms:${qrCodeSms.phoneToBeEncoded}"
        if (!qrCodeSms.messageToBeEncoded.isNullOrEmpty()) toEncode += "?sms_body=${qrCodeSms.messageToBeEncoded}"
        return toEncode.replace(" ", "%20")
    }
}