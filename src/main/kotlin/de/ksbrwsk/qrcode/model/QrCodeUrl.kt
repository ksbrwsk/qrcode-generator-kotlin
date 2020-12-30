package de.ksbrwsk.qrcode.model

import javax.validation.constraints.NotEmpty

class QrCodeUrl(
    @field:NotEmpty val urlToBeEncoded: String
)