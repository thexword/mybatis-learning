package example.dao;

import example.pojo.Pet;

import java.util.List;
import java.util.Map;

public interface PetDao {
    List<Pet> getAllPets();

    Pet getPet(String name);

    List<String> getAllSpecies();

    List<Pet> selectPets(String sex);

    void createPet(Pet pet);

    void updatePet(Pet pet);

    void deletePet(String name);

    List<Pet> findAllDogs(Pet pet);

    List<Pet> findDogPets(Pet pet);

    List<Pet> selectPetsIn(Map<String, Object> map);
}
