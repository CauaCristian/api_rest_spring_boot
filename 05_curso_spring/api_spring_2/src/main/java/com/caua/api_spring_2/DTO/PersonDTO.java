package com.caua.api_spring_2.DTO;
import java.util.Objects;

public class PersonDTO {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nameFull;
    private String address;
    private String gender;
    public PersonDTO() {}

    public PersonDTO(long id , String nameFull, String address, String gender) {
        this.id = id;
        this.nameFull = nameFull;
        this.address = address;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getFirstName(){
        return nameFull.split(" ")[0];
    }
    public void setFirstName(String firstName){
        this.nameFull = firstName;
    }
    public String getLastName(){
        return nameFull.split(" ")[1];
    }
    public void setLastName(String lastName){
        this.nameFull = lastName;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) && Objects.equals(nameFull, personDTO.nameFull) && Objects.equals(gender, personDTO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameFull, gender);
    }
}
