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

@Testcontainers
@Transactional
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = PublicInfoApplication.class)
@AutoConfigureMockMvc
public class CertificateControllerTest extends TestDataBaseContainerConfiguration {

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private ControllerSupplier supplier;

    @Test
    @DisplayName("create")
    void createTest() throws Exception {
        MockHttpServletResponse responsePost = mockMvc
                .perform(
                        post("/certificate/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(supplier.createCertificate()))
                .andReturn()
                .getResponse();

        assertEquals(200, responsePost.getStatus());
    }

    @Test
    @DisplayName("read by id")
    public void readByIdTest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/certificate/{id}", 2))
                .andReturn()
                .getResponse();

        assertAll(
                () -> {
                    assertEquals(200, response.getStatus());
                    assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON.toString());
                    assertThat(response.getContentAsString()).contains(supplier.readCertificateById());
                }
        );
    }

    @Test
    @DisplayName("read all by id")
    public void readAllByIdTest() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/certificate/read/all?ids=2,3"))
                .andReturn()
                .getResponse();

        assertAll(
                () -> {
                    assertEquals(200, response.getStatus());
                    assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON.toString());
                    assertThat(response.getContentAsString()).contains(supplier.readAllCertificatesById());
                }
        );
    }

    @Test
    @DisplayName("update test")
    public void updateTest() throws Exception {
        MockHttpServletResponse responsePost = mockMvc
                .perform(
                        put("/certificate/update/2")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(supplier.updateCertificate())
                )
                .andReturn()
                .getResponse();

        assertEquals(200, responsePost.getStatus());

        MockHttpServletResponse response = mockMvc.perform(get("/certificate/{id}", 2))
                .andReturn()
                .getResponse();

        assertAll(
                () -> {
                    assertEquals(200, response.getStatus());
                    assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON.toString());
                    assertThat(response.getContentAsString()).contains(supplier.updatedCertificate());
                }
        );
    }

    @Test
    @DisplayName("incorrect url in reading")
    public void incorrectUrlInReading() throws Exception {
        mockMvc.perform(get("/certificate/{}", "test"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("incorrect url in updating")
    public void incorrectUrlInUpdating() throws Exception {
        mockMvc.perform(get("/certificate/update/testUrl"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("incorrect url")
    public void incorrectUrlTest() throws Exception {
        mockMvc.perform(get("/certificate/hello"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("incorrect path variable in reading all by id")
    public void incorrectPathVariableInReadingAllByIdTest() throws Exception {
        mockMvc.perform(get("/certificate/read/all?ids=test"))
                .andExpect(status().is4xxClientError());
    }
}
