package com.bcb.sms.simulator.rest;

import com.bcb.sms.simulator.model.Message;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(SMSController.class)
public class SMSControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenRequestBodyIsFullShouldReturnSuccess() throws Exception{

        Gson gson = new Gson();
        String jsonRequestBody = gson.toJson(new Message("999", "888", "some text"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/sms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestBody))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void whenSenderPhoneIsMissingShouldReturnBadRequest() throws Exception{

        Gson gson = new Gson();
        String jsonRequestBody = gson.toJson(new Message(null, "888", "some text"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/sms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void whenRecipientPhoneIsMissingShouldReturnBadRequest() throws Exception{

        Gson gson = new Gson();
        String jsonRequestBody = gson.toJson(new Message("999", null, "some text"));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/sms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void whenMessageTextIsMissingShouldReturnBadRequest() throws Exception{

        Gson gson = new Gson();
        String jsonRequestBody = gson.toJson(new Message("999", "888", null));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/sms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
