package com.redis.yoon.api

import com.redis.yoon.service.SearchHouseService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class SearchHouseApiTests @Autowired constructor(
    val mockMvc: MockMvc,
//    val searchHouseApi: SearchHouseApi

){
   // @MockBean
   // private lateinit var searchHouseApi: SearchHouseApi

    @DisplayName("Notice를 생성할 수 있다.")
    @Test
    fun canCreateNotice(){
        //given
        val url = "/notice"

        //when
        mockMvc.perform(post(url)
            .content("value test"))
            .andExpect(status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }

    @DisplayName("Notice를 조회할 수 있다.")
    @Test
    fun canSearchNotice(){
        //given
        val url = "/notice"

        //when
        mockMvc.perform(get(url))
            .andExpect(status().isAccepted)
            .andDo(MockMvcResultHandlers.print())
    }


}