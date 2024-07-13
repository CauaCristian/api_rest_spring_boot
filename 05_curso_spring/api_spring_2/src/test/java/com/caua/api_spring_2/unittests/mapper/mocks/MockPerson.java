package com.caua.api_spring_2.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;
import com.caua.api_spring_2.DTO.v1.PersonDTO;
import com.caua.api_spring_2.models.PersonModel;

public class MockPerson {

    public PersonModel mockEntity() {
        return mockEntity(0);
    }
    
    public PersonDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<PersonModel> mockEntityList() {
        List<PersonModel> persons = new ArrayList<PersonModel>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDTO> mockVOList() {
        List<PersonDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }
    
    public PersonModel mockEntity(Integer number) {
        PersonModel person = new PersonModel();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number.toString());
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonDTO mockDTO(Integer number) {
        PersonDTO person = new PersonDTO();
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

}
