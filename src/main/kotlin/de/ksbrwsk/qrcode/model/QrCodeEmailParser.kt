package de.ksbrwsk.qrcode.model

class QrCodeEmailParser(private val qrCodeEmail: QrCodeEmail) : AbstractQrCodeParser() {

    override fun parse(): String {
        var toEncode = "mailto:${qrCodeEmail.emailToBeEncoded}"
        if(!qrCodeEmail.subjectToBeEncoded.isNullOrEmpty()) toEncode += "?subject=${qrCodeEmail.subjectToBeEncoded}"
        return toEncode.replace(" ", "%20")
    }
}