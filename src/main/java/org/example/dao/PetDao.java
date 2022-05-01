package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Pet;

import java.util.List;

public interface PetDao {
    List<Pet> getAllPets();

    Pet getPet(@Param("petName") String petName);

    List<String> getAllSpecies();

    void createPet(Pet pet);
}
