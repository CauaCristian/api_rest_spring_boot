package com.caua.api_spring_2.controllers;
import com.caua.api_spring_2.models.Person;
import com.caua.api_spring_2.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;
    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public Person findById(@PathVariable String id) {
        return personService.findById(id);
    }
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return personService.findAll();
    }
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.PUT)
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        personService.delete(id);
    }
}
