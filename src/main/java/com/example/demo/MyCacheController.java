package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class MyCacheController {

    @Autowired
    private MyCacheService myCacheService;

    @PostMapping("/person")
    public String savePerson(@RequestBody PersonDTO person) {
        myCacheService.savePerson(person);
        return "Saved in cache named: " + person.getName();
    }

    @GetMapping("/person/{name}")
    public PersonDTO getPerson(@PathVariable String name) {
        PersonDTO person = myCacheService.getPerson(name);
        return person != null ? person : new PersonDTO("Not Found", "Not Found");
    }
}
