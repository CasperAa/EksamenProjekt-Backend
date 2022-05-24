package com.example.eksamensopgave.api;

import com.example.eksamensopgave.repository.CandidateRepository;
import com.example.eksamensopgave.repository.PartyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class CandidateControllerTest {

    /*
    @Autowired
    MockMvc mockMvc;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    ObjectMapper objectMapper;


    @BeforeEach
    void setUp() {
    }

     */
}