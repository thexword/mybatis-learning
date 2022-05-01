package example.dao;

import example.pojo.Pet;

import java.util.List;

public interface PetDao {
    List<Pet> getAllPets();

    Pet getPet(String name);

    List<String> getAllSpecies();

    List<Pet> selectPets(String sex);

    void createPet(Pet pet);

    void updatePet(Pet pet);

    void deletePet(String name);
}
