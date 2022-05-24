package com.example.eksamensopgave.repository;

import com.example.eksamensopgave.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,Integer> {

    List<Candidate> findCandidateByParty_PartyLetter(String letter);
}
