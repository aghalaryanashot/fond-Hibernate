package com.example.fond;

import com.example.fond.domain.Company;
import com.example.fond.domain.JobInfo;
import com.example.fond.domain.Person;
import com.example.fond.service.CompanyRepo;
import com.example.fond.service.JobInfoRepo;
import com.example.fond.service.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class AllController {
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private JobInfoRepo jobInfoRepo;

    @GetMapping(value = "/persons")
    public String listPersons(
            Map<String, Object>model
    ){
        model.put("persons",personRepo.findAll());
        model.put("company",companyRepo.findAll());
        model.put("jobInfo",jobInfoRepo.findAll());
        return "listPersons";
    }

    @PostMapping(value = "/persons")
    public String add(
            @RequestParam(name = "firstName") String frstName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(required = false, name = "patronymic") String patronymic,
            @RequestParam(name = "inn") long inn,
            @RequestParam(name = "snils") long snils,
            @RequestParam(name = "dateOfBirth") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfBirth,
            @RequestParam(name="name") String name,
            @RequestParam(name = "base_rate") int base_rate,
            @RequestParam(required = false, name = "date_arrival") @DateTimeFormat(pattern="yyyy-MM-dd") Date date_arrival,
            @RequestParam(required = false, name = "date_exit") @DateTimeFormat(pattern="yyyy-MM-dd") Date date_exit,
            Map<String, Object> model
    ){
        Person person = new Person(frstName,lastName,patronymic,inn,snils,dateOfBirth);
        personRepo.save(person);
        model.put("persons",personRepo.findAll());
        Company company = new Company(name);
        companyRepo.save(company);
        model.put("company",companyRepo.findAll());
        JobInfo jobInfo = new JobInfo(person,company,base_rate,date_arrival,date_exit);
        jobInfoRepo.save(jobInfo);
        model.put("jobInfo",jobInfoRepo.findAll());
        return "listPersons";
    }



    @PostMapping(value = "filter")
    public String filter(
            @RequestParam(required = false, name = "firstName") String firstname,
            @RequestParam(required = false, name = "lastName") String lastname,
            @RequestParam(required = false, name = "START")@DateTimeFormat(pattern="yyyy-MM-dd") Date start,
            @RequestParam(required = false, name = "BETWEEN")@DateTimeFormat(pattern="yyyy-MM-dd") Date between,
            Map<String, Object>model
    ){
         List<Person> person = personRepo.findByLastNameOrFirstName(lastname,firstname);
         model.put("persons",person);
         List<Person> persondata = personRepo.findBydateOfBirthBetween(start,between);
         model.put("persons",persondata);
         return "listPersons";
    }

    @ResponseBody
    @GetMapping(value = "/persons1")
    public List<Person> getAll() {
        return (List <Person>) personRepo.findAll();
    }


}
