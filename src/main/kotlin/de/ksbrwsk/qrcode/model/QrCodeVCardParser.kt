package de.ksbrwsk.qrcode.model

import org.apache.commons.lang3.StringUtils

class QrCodeVCardParser(val qrCodeVCard: QrCodeVCard) : AbstractQrCodeParser() {

    override fun parse(): String {
        val builder: StringBuilder = StringBuilder("BEGIN:VCARD\n")
            .append("VERSION:4.0\n")
            .append("N:")
            .append(this.qrCodeVCard.lastname)
            .append(";")
            .append(this.qrCodeVCard.name)
            .append(";;;\n")
            .append("FN:")
            .append(this.qrCodeVCard.name)
            .append(" ")
            .append(this.qrCodeVCard.lastname)
            .append("\n")

        if (StringUtils.isNotEmpty(this.qrCodeVCard.title)) {
            builder.append("TITLE:")
            builder.append(this.qrCodeVCard.title)
            builder.append("\n")
        }
        if (StringUtils.isNotEmpty(this.qrCodeVCard.organisation)) {
            builder.append("ORG:")
            builder.append(this.qrCodeVCard.organisation)
            builder.append("\n")
        }
        if (StringUtils.isNotEmpty(this.qrCodeVCard.email1)) {
            builder.append("EMAIL:")
                .append(this.qrCodeVCard.email1)
                .append("\n")
        }
        if (StringUtils.isNotEmpty(this.qrCodeVCard.email2)) {
            builder.append("EMAIL:")
                .append(this.qrCodeVCard.email2)
                .append("\n")
        }
        if (StringUtils.isNotEmpty(this.qrCodeVCard.phone1)) {
            builder.append("TEL;TYPE=")
                .append(this.qrCodeVCard.phone1Type)
                .append(":")
                .append(this.qrCodeVCard.phone1)
                .append("\n")
        }
        if (StringUtils.isNotEmpty(this.qrCodeVCard.adress1Street)) {
            builder.append("ADR;TYPE=")
                .append(this.qrCodeVCard.adress1Type)
                .append(":;;")
                .append(this.qrCodeVCard.adress1Street)
                .append(";")
                .append(this.qrCodeVCard.adress1Locality)
                .append(";")
                .append(this.qrCodeVCard.adress1Region)
                .append(";")
                .append(this.qrCodeVCard.adress1PostalCode)
                .append(";")
                .append(this.qrCodeVCard.adress1Country)
                .append("\n")
                .append("LABEL;TYPE=")
                .append(this.qrCodeVCard.adress1Type)
                .append(":")
                .append(this.qrCodeVCard.adress1Street)
                .append("\n")
                .append(this.qrCodeVCard.adress1Locality)
                .append(",")
                .append(this.qrCodeVCard.adress1Region)
                .append(" ")
                .append(this.qrCodeVCard.adress1PostalCode)
                .append("\n")
                .append(this.qrCodeVCard.adress1Country)
                .append("\n")
        }
        builder.append("END:VCARD")
        return builder.toString()
    }
}