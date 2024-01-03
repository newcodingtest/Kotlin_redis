package com.redis.yoon.test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate

@SpringBootTest
class RedisCrudTests (
    @Autowired
    private val redisTemplate: RedisTemplate<String, String>,
) {

    @DisplayName("redisTemplate으로 Key와 Value를 생성할 수 있다.")
    @Test
    fun stringRedisObjectTest() {
        redisTemplate.opsForValue()
            .set("test", "1")

        println(redisTemplate.opsForValue()
            .get("test"))

        redisTemplate.opsForValue()
            .set("test", "2")

        println(redisTemplate.opsForValue()
            .get("test"))
    }

    @DisplayName("Key 값으로 value를 조회할 수 있다.")
    @Test
    fun canSearchValueFromKey() {
        val key = "publichouse"
        println(redisTemplate.opsForValue()
            .get(key))
    }
}