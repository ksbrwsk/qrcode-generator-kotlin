package de.ksbrwsk.qrcode.model

import org.springframework.validation.annotation.Validated
import jakarta.validation.constraints.NotEmpty

@Validated
data class QrCodeSms(
    @field:NotEmpty val phoneToBeEncoded: String,
    var messageToBeEncoded: String? = ""
)