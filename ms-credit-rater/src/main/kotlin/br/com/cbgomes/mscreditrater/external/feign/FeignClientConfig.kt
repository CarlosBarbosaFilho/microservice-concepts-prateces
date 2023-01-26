package br.com.cbgomes.mscreditrater.external.feign

import feign.okhttp.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignClientConfig {

    @Bean
    fun client(): OkHttpClient? {
        return OkHttpClient()
    }
}