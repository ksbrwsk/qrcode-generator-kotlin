package de.ksbrwsk.qrcode.model

class QrCodePhoneParser(val qrCodePhone: QrCodePhone) : AbstractQrCodeParser() {

    override fun parse(): String {
        return "tel:${qrCodePhone.phoneToBeEncoded}"
    }
}