package de.ksbrwsk.qrcode.model

import javax.validation.constraints.NotEmpty

class QrCodePhone(@field:NotEmpty val phoneToBeEncoded: String)