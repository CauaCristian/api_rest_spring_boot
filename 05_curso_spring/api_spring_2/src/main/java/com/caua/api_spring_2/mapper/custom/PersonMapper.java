package com.caua.api_spring_2.mapper.custom;
import com.caua.api_spring_2.DTO.v2.PersonDTOV2;
import com.caua.api_spring_2.models.PersonModel;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class PersonMapper {
    public PersonDTOV2 convertEntityToDTO(PersonModel personModel) {
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(personModel.getId());
        dto.setFirstName(personModel.getFirstName());
        dto.setLastName(personModel.getLastName());
        dto.setAddress(personModel.getAddress());
        dto.setGender(personModel.getGender());
        dto.setBirthDay(new Date());
        return dto;
    }
    public PersonModel convertDTOToEntity(PersonDTOV2 personDTOV2) {
        PersonModel entity = new PersonModel();
        entity.setFirstName(personDTOV2.getFirstName());
        entity.setLastName(personDTOV2.getLastName());
        entity.setAddress(personDTOV2.getAddress());
        entity.setGender(personDTOV2.getGender());
        return entity;
    }
}
