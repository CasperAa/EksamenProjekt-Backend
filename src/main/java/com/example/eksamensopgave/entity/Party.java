package com.example.eksamensopgave.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String partyLetter;

    @OneToMany(mappedBy = "party", cascade ={ CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Candidate> candidates = new HashSet<>();

    public Party(String name, String partyLetter) {
        this.name = name;
        this.partyLetter = partyLetter;
    }

    public void addCandidate(Candidate candidate) {
        this.candidates.add(candidate);
        candidate.setParty(this);
    }

    public void addCandidates(Set<Candidate> candidates) {
        this.candidates.addAll(candidates);
        for (Candidate candidate : candidates) {
            candidate.setParty(this);
        }
    }
}




