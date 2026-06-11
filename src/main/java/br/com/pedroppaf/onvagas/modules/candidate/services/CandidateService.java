package br.com.pedroppaf.onvagas.modules.candidate.services;

import br.com.pedroppaf.onvagas.exceptions.UserFoundException;
import br.com.pedroppaf.onvagas.modules.candidate.CandidateEntity;
import br.com.pedroppaf.onvagas.modules.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidate){
        this.candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidate);

    }
}
