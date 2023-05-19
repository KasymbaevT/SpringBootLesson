package peaksoft.springbootlesson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.springbootlesson.dto.CompanyRequest;
import peaksoft.springbootlesson.dto.CompanyResponse;
import peaksoft.springbootlesson.service.CompanyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;
    @GetMapping
    public List<CompanyResponse> getAll(){
        System.out.println("hello world");
        return companyService.getAllCompanies();
    }
    @GetMapping("{id}")
    public CompanyResponse getCompany(@PathVariable("id")Long id){
        return companyService.getCompanyById(id);
    }
    @PostMapping
    public CompanyResponse save(@RequestBody CompanyRequest companyRequest){
        return companyService.saveCompany(companyRequest);
    }
    @PutMapping("{id}")
    public CompanyResponse update(@PathVariable("id")Long id,@RequestBody CompanyRequest request){
        return companyService.updateCompany(id,request);
    }
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id")Long id){
        companyService.deleteCompany(id);
        return "Successfully deleted Company with id: "+id;
    }
}
