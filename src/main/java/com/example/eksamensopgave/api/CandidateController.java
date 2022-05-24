package com.example.eksamensopgave.api;

import com.example.eksamensopgave.dto.CandidateResponse;
import com.example.eksamensopgave.repository.CandidateRepository;
import com.example.eksamensopgave.service.CandidateService;
import net.bytebuddy.build.RepeatedAnnotationPlugin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/candidates")
public class CandidateController {

    CandidateService candidateService;

    public CandidateController (CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @GetMapping
    public List<CandidateResponse> getAllCandidates(@RequestParam(value = "party", required = false) String party){
        return candidateService.getAllCandidates(party);
    }
}
