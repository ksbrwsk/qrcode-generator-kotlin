package de.ksbrwsk.qrcode.model

class QrCodeVCardParser(val qrCodeVCard: QrCodeVCard) : AbstractQrCodeParser() {

    override fun parse(): String {
        var vcard = """
            BEGIN:VCARD
            VERSION:4.0
            N:${qrCodeVCard.lastname};${qrCodeVCard.name};;;
            FN:${qrCodeVCard.name} ${qrCodeVCard.lastname}${'\n'}
        """.trimIndent()
        if (!qrCodeVCard.title.isNullOrEmpty()) {
            vcard = vcard.plus(
                """
                TITLE:${qrCodeVCard.title}${'\n'}
            """.trimIndent()
            )
        }
        if (!qrCodeVCard.organisation.isNullOrEmpty()) {
            vcard = vcard.plus(
                """
                ORG:${qrCodeVCard.organisation}${'\n'}
            """.trimIndent()
            )
        }
        if (!qrCodeVCard.email1.isNullOrEmpty()) {
            vcard = vcard.plus(
                """
                EMAIL:${qrCodeVCard.email1}${'\n'}
            """.trimIndent()
            )
        }
        if (!qrCodeVCard.email2.isNullOrEmpty()) {
            vcard = vcard.plus(
                """
                EMAIL:${qrCodeVCard.email2}${'\n'}
            """.trimIndent()
            )
        }
        if (!qrCodeVCard.phone1.isNullOrEmpty()) {
            vcard = vcard.plus(
                """
                TEL;TYPE=:${qrCodeVCard.phone1Type}:${qrCodeVCard.phone1}${'\n'}
            """.trimIndent()
            )
        }
        if (!qrCodeVCard.adress1Street.isNullOrEmpty()) {
            vcard = vcard.plus(
                """
                ADR;TYPE=${qrCodeVCard.adress1Type}:;;${qrCodeVCard.adress1Street};${qrCodeVCard.adress1Locality};${qrCodeVCard.adress1Region};${qrCodeVCard.adress1PostalCode};${qrCodeVCard.adress1Country}${'\n'}
                LABEL;TYPE=${qrCodeVCard.adress1Type}:${qrCodeVCard.adress1Street}${'\n'}
                ${qrCodeVCard.adress1Locality},${qrCodeVCard.adress1Region}${'\n'}
                ${qrCodeVCard.adress1PostalCode}${'\n'}
                ${qrCodeVCard.adress1Country}
            """.trimIndent()
            )
        }
        vcard = vcard.plus("END:VCARD")
        return vcard
    }
}
