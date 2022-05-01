package example.dao;

import example.pojo.Pet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PetDao {
    List<Pet> getAllPets();

    Pet getPet(@Param("name") String name);

    List<String> getAllSpecies();

    List<Pet> selectPets(String sex);

    void createPet(Pet pet);

    void updatePet(Pet pet);

    void deletePet(String name);
}
