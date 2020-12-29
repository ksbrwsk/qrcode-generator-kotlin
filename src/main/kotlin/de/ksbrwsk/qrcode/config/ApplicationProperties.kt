package de.ksbrwsk.qrcode.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
@Component
data class ApplicationProperties (
    var title: String = "",
    var appInfo: String = ""
)