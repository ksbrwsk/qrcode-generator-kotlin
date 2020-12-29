package de.ksbrwsk.qrcode.model

import org.springframework.validation.annotation.Validated

@Validated
data class QrCodeVCard(val name: String, val lastname: String) {
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