package de.ksbrwsk.qrcode.utils

import org.springframework.validation.BindingResult
import org.springframework.validation.DataBinder
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.validation.support.BindingAwareModelMap

class TestUtils {

    companion object {
        fun createLocalValidatorFactoryBean(): LocalValidatorFactoryBean {
            val localValidatorFactoryBean = LocalValidatorFactoryBean()
            localValidatorFactoryBean.afterPropertiesSet()
            return localValidatorFactoryBean
        }
        fun createBindingResult(qrCodeModel: Any?): BindingResult {
            val dataBinder = DataBinder(qrCodeModel)
            dataBinder.validator = createLocalValidatorFactoryBean()
            dataBinder.validate()
            return dataBinder.bindingResult
        }

        fun createModel(): BindingAwareModelMap {
            return BindingAwareModelMap()
        }
    }
}