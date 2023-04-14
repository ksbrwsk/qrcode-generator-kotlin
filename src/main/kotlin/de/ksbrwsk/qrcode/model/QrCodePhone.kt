package de.ksbrwsk.qrcode.model

import org.springframework.validation.annotation.Validated
import jakarta.validation.constraints.NotEmpty

@Validated
class QrCodePhone(@field:NotEmpty val phoneToBeEncoded: String)