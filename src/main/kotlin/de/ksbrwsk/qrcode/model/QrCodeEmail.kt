package de.ksbrwsk.qrcode.model

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotEmpty

@Validated
data class QrCodeEmail(
    @NotEmpty val emailToBeEncoded: String,
    var subjectToBeEncoded: String? = "") {
}