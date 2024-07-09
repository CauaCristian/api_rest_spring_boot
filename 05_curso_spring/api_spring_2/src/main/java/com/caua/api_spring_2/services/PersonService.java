package com.caua.api_spring_2.services;
import com.caua.api_spring_2.DTO.PersonDTO;
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

    public List<PersonDTO> findAll(){
        logger.info("Find all Peaple!");
        return personRepository.findAll();
    }

    public PersonDTO findById(Long id){
        logger.info("Find Person by id: " + id);
        return personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
    }

    public PersonDTO create(PersonDTO dto){
        logger.info("Create Person: " + dto);
        return personRepository.save(dto);
    }

    public PersonDTO update(PersonDTO dto){
        logger.info("Create Person: " + dto);
        Person entity = personRepository.findById(dto.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());
        return personRepository.save(dto);
    }

    public void delete(Long id){
        logger.info("delete Person: " + id);
        Person entity = personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(entity);
    }

}
