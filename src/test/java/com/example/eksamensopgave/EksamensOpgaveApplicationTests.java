package com.example.eksamensopgave;

import com.example.eksamensopgave.entity.Candidate;
import com.example.eksamensopgave.entity.Party;
import com.example.eksamensopgave.repository.CandidateRepository;
import com.example.eksamensopgave.repository.PartyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest //Important
class EksamensOpgaveApplicationTests {

    @Autowired
    PartyRepository partyRepository;
    @Autowired
    CandidateRepository candidateRepository;

    @BeforeEach
    void setUp() {
        partyRepository.deleteAll();
        candidateRepository.deleteAll();
        Party party1 = new Party("Socialdemokratiet", "A");
        Candidate candidate1 = new Candidate("Marcel Meijer");
        Candidate candidate2 = new Candidate("Michael Kristensen");

        party1.addCandidate(candidate1);
        party1.addCandidate(candidate2);
        partyRepository.save(party1);
    }

    @Test
    public void getCandidates(){
        List<Candidate> candidates = candidateRepository.findAll();
        assertEquals(2,candidates.size());
    }
    @Test
    public void getCandidatesFromPartOK(){
        List<Candidate> candidates = candidateRepository.findCandidateByParty_PartyLetter("A");
        assertEquals(2,candidates.size());
    }
    @Test
    public void getCandidatesFromPartNotOK(){
        List<Candidate> candidates = candidateRepository.findCandidateByParty_PartyLetter("B");
        assertEquals(0,candidates.size());
    }
}
