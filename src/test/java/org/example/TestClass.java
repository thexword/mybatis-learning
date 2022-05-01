package org.example;

import org.example.dao.impl.PetDaoImpl;
import org.example.pojo.Pet;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestClass {
    @Test
    public void testGetAllPets() {
        List<Pet> allPets = new PetDaoImpl().getAllPets();
        for (Pet allPet : allPets) {
            System.out.println(allPet);
        }
    }

    @Test
    public void testGetPet() {
        String petName  = "Slimmmy";
        Pet pet = new PetDaoImpl().getPet(petName);
        System.out.println(pet);
    }

    @Test
    public void testGetAllSpecies() {
        List<String> allSpecies = new PetDaoImpl().getAllSpecies();
        for (String species : allSpecies) {
            System.out.println(species);
        }
    }

    @Test
    public void testCreatePet() {
        Pet pet = new Pet();
        pet.setName("Slimmmy");
        pet.setOwner("Suk");
        pet.setSpecies("dog");
        pet.setSex("m");
        pet.setBirth(new Date());

        new PetDaoImpl().createPet(pet);
    }
}
