package br.com.pedroppaf.onvagas.modules.candidate.controllers;

import br.com.pedroppaf.onvagas.modules.candidate.CandidateEntity;
import br.com.pedroppaf.onvagas.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidate){
        return this.candidateRepository.save(candidate);
    }
}
