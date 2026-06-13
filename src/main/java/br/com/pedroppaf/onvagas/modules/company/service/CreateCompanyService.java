package br.com.pedroppaf.onvagas.modules.company.service;

import br.com.pedroppaf.onvagas.exceptions.UserFoundException;
import br.com.pedroppaf.onvagas.modules.company.entity.CompanyEntity;
import br.com.pedroppaf.onvagas.modules.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute (CompanyEntity companyEntity) {
        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.companyRepository.save(companyEntity);
    }

}
