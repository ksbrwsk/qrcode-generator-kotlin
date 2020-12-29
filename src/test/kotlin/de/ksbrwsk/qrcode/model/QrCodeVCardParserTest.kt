package de.ksbrwsk.qrcode.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class QrCodeVCardParserTest {
    @Test
    fun thatParseVCardCanPasses() {
        val expected = """
            BEGIN:VCARD
            VERSION:4.0
            N:Norris;Chuck;;;
            FN:Chuck Norris
            TITLE:Mr. Roundhousekick
            END:VCARD
            """.trimIndent()
        val qrCodeVCard = QrCodeVCard(name = "Chuck", lastname = "Norris")
        qrCodeVCard.title = "Mr. Roundhousekick"
        val actual = QrCodeVCardParser(qrCodeVCard).parse()
        assertEquals(expected, actual)
    }
}