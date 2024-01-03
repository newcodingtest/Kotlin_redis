package com.redis.yoon.api

import com.redis.yoon.service.SearchHouseService
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@Controller
class SearchHouseApi(
    val searchHouseService: SearchHouseService
) {
    val log = KotlinLogging.logger {}

    @PostMapping("/notice")
    fun createTodayNotice(@RequestBody value: String): ResponseEntity<String>{
        log.info { value }
        searchHouseService.create(value)

        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/notice")
    fun searchTodayNotice(): ResponseEntity<*>{
        val notice: String? = searchHouseService.search()

        log.info { notice }
        return ResponseEntity(notice, HttpStatus.ACCEPTED)
    }
}