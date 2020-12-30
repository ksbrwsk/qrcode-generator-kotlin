package de.ksbrwsk.qrcode.model

class QrCodeProcessingResult {
    var image: String? = null
    var encodedText: String? = null
    var successMessage: String? = ""
    var errorMessage: String? = ""

    fun isSuccessfull(): Boolean = !successMessage.isNullOrEmpty()
    fun hasError(): Boolean = !errorMessage.isNullOrEmpty()

}