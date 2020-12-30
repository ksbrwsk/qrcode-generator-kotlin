package de.ksbrwsk.qrcode.model

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotEmpty

@Validated
data class QrCodeVCard(@field:NotEmpty val name: String, @field:NotEmpty val lastname: String) {
    var organisation: String? = ""
    var title: String? = ""
    var phone1: String? = ""
    var phone1Type: QrCodeEnumType? = QrCodeEnumType.WORK
    var adress1Street: String? = ""
    var adress1Locality: String? = ""
    var adress1Region: String? = ""
    var adress1PostalCode: String? = ""
    var adress1Country: String? = ""
    var adress1Type: QrCodeEnumType? = QrCodeEnumType.WORK
    var email1: String? = ""
    var email2: String? = ""
}