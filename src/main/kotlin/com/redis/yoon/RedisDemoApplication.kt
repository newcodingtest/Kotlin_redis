package com.redis.yoon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableCaching
@SpringBootApplication(exclude =[ DataSourceAutoConfiguration::class,
                                  DataSourceTransactionManagerAutoConfiguration::class,
                                  HibernateJpaAutoConfiguration::class]
                        )
class RedisDemoApplication

fun main(args: Array<String>) {
    runApplication<RedisDemoApplication>(*args)
}

