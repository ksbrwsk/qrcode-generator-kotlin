package de.ksbrwsk.qrcode.model

import javax.validation.constraints.NotEmpty

data class QrCodeEmail(
    @field:NotEmpty val emailToBeEncoded: String,
    var subjectToBeEncoded: String? = ""
)