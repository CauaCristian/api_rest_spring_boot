package com.caua.api_spring_2.services;
import com.caua.api_spring_2.DTO.PersonDTO;
import com.caua.api_spring_2.exceptions.ResourceNotFoundException;
import com.caua.api_spring_2.mapper.Mapper;
import com.caua.api_spring_2.models.PersonModel;
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
        return Mapper.parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id){
        logger.info("Find Person by id: " + id);
        return Mapper.parseObject(personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID")), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO dto){
        logger.info("Create Person: " + dto);
        PersonModel personModel = Mapper.parseObject(dto, PersonModel.class);
        PersonDTO personDTO = Mapper.parseObject(personRepository.save(personModel), PersonDTO.class);
        return personDTO;
    }

    public PersonDTO update(PersonDTO dto){
        logger.info("Create Person: " + dto);
        PersonModel entity = personRepository.findById(dto.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());
        PersonDTO personDTO = Mapper.parseObject(personRepository.save(entity), PersonDTO.class);
        return personDTO;
    }

    public void delete(Long id){
        logger.info("delete Person: " + id);
        PersonModel entity = personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        personRepository.delete(entity);
    }

}
