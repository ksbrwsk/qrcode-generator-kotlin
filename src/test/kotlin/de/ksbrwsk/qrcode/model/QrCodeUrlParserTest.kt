package de.ksbrwsk.qrcode.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class QrCodeUrlParserTest {

    @Test
    fun shouldParseUrl() {
        val expected = "http://www.google.de"
        val qrCodeUrl = QrCodeUrl("http://www.google.de")
        assertEquals(expected, QrCodeUrlParser(qrCodeUrl).parse())
    }

    @Test
    fun shouldParseUrlWithBlank() {
        val expected = "http://www.google.de?value=My%20Site"
        val qrCodeUrl = QrCodeUrl("http://www.google.de?value=My%20Site")
        assertEquals(expected, QrCodeUrlParser(qrCodeUrl).parse())
    }
}