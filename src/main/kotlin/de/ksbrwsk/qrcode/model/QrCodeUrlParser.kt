package de.ksbrwsk.qrcode.model

class QrCodeUrlParser(val qrCodeUrl: QrCodeUrl) : AbstractQrCodeParser() {
    override fun parse(): String {
        return qrCodeUrl.urlToBeEncoded.replace(" ", "%20")
    }
}