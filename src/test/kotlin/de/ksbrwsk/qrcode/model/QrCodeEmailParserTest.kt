package de.ksbrwsk.qrcode.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class QrCodeEmailParserTest {
    @Test
    internal fun shouldParseEmailNoSubject() {
        val expected = "mailto:email@email.com"
        val qrCodeEmail = QrCodeEmail("email@email.com")
        assertEquals(QrCodeEmailParser(qrCodeEmail).parse(), expected)
    }

    @Test
    internal fun shouldParseEmailAndSubject() {
        val expected = "mailto:email@email.com?subject=Subject"
        val qrCodeEmail = QrCodeEmail("email@email.com", "Subject")
        assertEquals(QrCodeEmailParser(qrCodeEmail).parse(), expected)
    }

    @Test
    internal fun shouldParseEmailAndSubjectWithBlanks() {
        val expected = "mailto:email@email.com?subject=My%20Subject"
        val qrCodeEmail = QrCodeEmail("email@email.com", "My Subject")
        assertEquals(QrCodeEmailParser(qrCodeEmail).parse(), expected)
    }

}