package de.ksbrwsk.qrcode.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class QrCodePhoneParserTest {
    @Test
    internal fun shouldParsePhoneNumber() {
        val expected = "tel:+495551234567"
        val qrCodePhone = QrCodePhone("+495551234567")
        assertEquals(expected, QrCodePhoneParser(qrCodePhone).parse())
    }
}