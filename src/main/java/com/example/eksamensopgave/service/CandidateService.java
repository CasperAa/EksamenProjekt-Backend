package com.example.eksamensopgave.service;

import com.example.eksamensopgave.dto.CandidateResponse;
import com.example.eksamensopgave.entity.Candidate;
import com.example.eksamensopgave.repository.CandidateRepository;
import com.example.eksamensopgave.repository.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {
    CandidateRepository candidateRepository;
    PartyRepository partyRepository;


    public CandidateService(CandidateRepository candidateRepository, PartyRepository partyRepository) {
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
    }

    public List<CandidateResponse> getAllCandidates(String letter){
        List <Candidate> candidates;
        if(letter != null){
            candidates = candidateRepository.findCandidateByParty_PartyLetter(letter);
        } else {
            candidates = candidateRepository.findAll();
        }
        //return candidates.stream().map(CandidateResponse::new).collect(Collectors.toList());
        return candidates.stream().map((candidate) -> new CandidateResponse(candidate)).collect(Collectors.toList());
    }


}
