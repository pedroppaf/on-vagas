package br.com.pedroppaf.onvagas.modules.company.controller;

import br.com.pedroppaf.onvagas.modules.company.entity.CompanyEntity;
import br.com.pedroppaf.onvagas.modules.company.service.CreateCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CreateCompanyService companyService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CompanyEntity companyEntity){
        try {
            var result = this.companyService.execute(companyEntity);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
