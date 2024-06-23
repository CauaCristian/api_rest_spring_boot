package com.caua.api_spring_2.services;
import com.caua.api_spring_2.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public List<Person> findAll(){
        logger.info("Find all Peaple!");
        List<Person> persons = new ArrayList<Person>();
        for(int i = 0; i<10; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id){
        logger.info("Find Person by id: " + id);
        return mockPerson(Integer.parseInt(id));
    }

    public Person create(Person person){
        logger.info("Create Person: " + person);
        return person;
    }
    public Person update(Person person){
        logger.info("update Person: " + person);
        return person;
    }
    public void delete(String id){
        logger.info("delete Person: " + id);
    }

    private Person mockPerson(int i){
        return new Person(counter.incrementAndGet(),"name " +i,"lastName "+i,"address "+i,"gender "+i);
    }

}
