package com.redis.yoon.service

import mu.KotlinLogging
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class SearchHouseService(
    val redisTemplate: RedisTemplate<String, String>,
) {
    val log = KotlinLogging.logger {}

    fun create(value: String){
        redisTemplate.opsForValue()
            .set("publicHouse",value)
    }

    fun search(): String {
        val result = redisTemplate.opsForValue()
            .get("publicHouse")?:""

        log.info { "get Redis value \n\n ${result}"}
        return result
    }
}