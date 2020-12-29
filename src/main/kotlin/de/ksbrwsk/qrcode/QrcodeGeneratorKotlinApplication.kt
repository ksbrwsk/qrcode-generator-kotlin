package de.ksbrwsk.qrcode

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QrcodeGeneratorKotlinApplication

fun main(args: Array<String>) {
	runApplication<QrcodeGeneratorKotlinApplication>(*args)
}
