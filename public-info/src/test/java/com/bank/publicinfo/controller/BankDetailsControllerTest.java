package com.bank.publicinfo.controller;

import com.bank.publicinfo.PublicInfoApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;
import com.bank.publicinfo.supplier.ControllerSupplier;

import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@Testcontainers
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = PublicInfoApplication.class)
public class BankDetailsControllerTest extends TestDataBaseContainerConfiguration {

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private ControllerSupplier supplier;

    @Test
    @DisplayName("create")
    void createTest() throws Exception {
        MockHttpServletResponse responsePost = mockMvc
                .perform(
                        post("/bank/details/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(supplier.createBankDetails())
                )
                .andReturn()
                .getResponse();

        assertEquals(200, responsePost.getStatus());
    }

    @Test
    @DisplayName("read by id")
    public void readByIdTest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/bank/details/{id}", 2))
                .andReturn()
                .getResponse();

        assertAll(
                () -> {
                    assertEquals(200, response.getStatus());
                    assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON.toString());
                    assertThat(response.getContentAsString()).contains(supplier.readBankDetailsById());
                }
        );
    }

    @Test
    @DisplayName("read all by id")
    public void readAllByIdTest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/bank/details/read/all?ids=3,4"))
                .andReturn()
                .getResponse();
        assertAll(
                () -> {
                    assertEquals(200, response.getStatus());
                    assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON.toString());
                    assertThat(response.getContentAsString()).contains(supplier.readAllBankDetailsById());
                }
        );
    }

    @Test
    @DisplayName("update")
    public void updateTest() throws Exception {
        MockHttpServletResponse responsePost = mockMvc
                .perform(
                        put("/bank/details/update/5")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(supplier.updateBankDetails())
                )
                .andReturn()
                .getResponse();

        assertThat(responsePost.getStatus()).isEqualTo(200);

        MockHttpServletResponse response = mockMvc.perform(get("/bank/details/{id}", 5))
                .andReturn()
                .getResponse();

        assertAll(
                () -> {
                    assertEquals(200, response.getStatus());
                    assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON.toString());
                    assertThat(response.getContentAsString()).contains(supplier.updatedBankDetails());
                }
        );
    }

    @Test
    @DisplayName("incorrect url in reading")
    public void incorrectUrlInReading() throws Exception {
        mockMvc.perform(get("/bank/details/{}", "test"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("incorrect url in updating")
    public void incorrectUrlInUpdating() throws Exception {
        mockMvc.perform(get("/bank/details/update/testUrl"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("incorrect url")
    public void incorrectUrlTest() throws Exception {
        mockMvc.perform(get("/bank/details/hello"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("incorrect path variable in reading all by id")
    public void incorrectPathVariableInReadingAllByIdTest() throws Exception {
        mockMvc.perform(get("/bank/details/read/all?ids=test"))
                .andExpect(status().is4xxClientError());
    }
}
