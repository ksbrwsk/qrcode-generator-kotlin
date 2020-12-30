package de.ksbrwsk.qrcode.model

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotEmpty

@Validated
class QrCodePhone(@field:NotEmpty val phoneToBeEncoded: String)