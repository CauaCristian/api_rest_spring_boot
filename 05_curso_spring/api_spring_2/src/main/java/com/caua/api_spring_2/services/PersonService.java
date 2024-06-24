package com.caua.api_spring_2.services;
import com.caua.api_spring_2.exceptions.ResourceNotFoundException;
import com.caua.api_spring_2.models.Person;
import com.caua.api_spring_2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {


    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll(){
        logger.info("Find all Peaple!");
        return personRepository.findAll();
    }

    public Person findById(Long id){
        logger.info("Find Person by id: " + id);
        return personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person){
        logger.info("Create Person: " + person);
        return personRepository.save(person);
    }

    public Person update(Person person){
        logger.info("Create Person: " + person);
        Person entity = personRepository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        entity.setName(person.getName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(person);
    }

    public void delete(Long id){
        logger.info("delete Person: " + id);
        Person entity = personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(entity);
    }

}
