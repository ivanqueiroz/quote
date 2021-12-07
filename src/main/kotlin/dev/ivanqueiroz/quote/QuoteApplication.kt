package dev.ivanqueiroz.quote

import dev.ivanqueiroz.quote.model.Quote
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate


@SpringBootApplication
class QuoteApplication{

    companion object{
        private val log: Logger = LoggerFactory.getLogger(QuoteApplication::class.java)
    }

    @Bean
    fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate? {
        return restTemplateBuilder.build()
    }

    @Bean
    fun run(restTemplate: RestTemplate): CommandLineRunner? {
        return CommandLineRunner {
            val quote = restTemplate.getForObject(
                "https://quoters.apps.pcfone.io/api/random", Quote::class.java
            )
            log.info(quote.toString())
        }
    }
}

fun main(args: Array<String>) {
    runApplication<QuoteApplication>(*args)
}
