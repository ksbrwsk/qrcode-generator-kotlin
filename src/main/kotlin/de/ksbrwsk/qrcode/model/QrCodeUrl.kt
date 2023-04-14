package de.ksbrwsk.qrcode.model

import org.springframework.validation.annotation.Validated
import jakarta.validation.constraints.NotEmpty

@Validated
class QrCodeUrl(@field:NotEmpty val urlToBeEncoded: String)