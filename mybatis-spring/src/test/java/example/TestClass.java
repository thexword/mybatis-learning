package example;

import example.dao.PetDao;
import example.dao.impl.PetDaoImpl;
import example.pojo.Pet;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TestClass {
    private static final PetDao petDao;

    static {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});
        petDao = (PetDaoImpl) appContext.getBean("petDAOImpl");
    }

    @Test
    public void testGetAllPets() {
        List<Pet> pets = petDao.getAllPets();
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }


    @Test
    public void testGetPet() {
        String petName  = "Tony";
        Pet pet = petDao.getPet(petName);
        System.out.println(pet);
    }

    @Test
    public void testGetAllSpecies() {
        List<String> allSpecies = petDao.getAllSpecies();
        for (String species : allSpecies) {
            System.out.println(species);
        }
    }

    @Test
    public void testSelectPets() {
        List<Pet> petList = petDao.selectPets("w");
        for (Pet pet : petList) {
            System.out.println(pet);
        }
    }

    @Test
    public void testCreatePet() {
        Pet pet = new Pet();
        pet.setName("Kaka");
        pet.setOwner("Alex");
        pet.setSpecies("dog");
        pet.setSex("m");
        pet.setBirth(new Date());

        petDao.createPet(pet);
    }

    @Test
    public void testUpdatePet() {
        Pet pet = new Pet();
        pet.setName("Tony");
        pet.setOwner("Suk");
        pet.setSpecies("");
        pet.setSex("w");
        pet.setBirth(new Date());

        petDao.updatePet(pet);
    }

    @Test
    public void testDeletePet() {
        petDao.deletePet("Tony");
    }

    @Test
    public void testFindAllDogs() {
        Pet pet = new Pet();
        pet.setSpecies("dog");
//        pet.setSex("m");
//        pet.setOwner("Kate");
        List<Pet> allDogs = petDao.findAllDogs(pet);
        for (Pet dog : allDogs) {
            System.out.println(dog);
        }
    }

    @Test
    public void testFindDogPets() {
        Pet pet = new Pet();
        pet.setName("kk");
//        pet.setSex("w");
//        pet.setOwner("Kate");
        pet.setSpecies("dog");
        List<Pet> allDogs = petDao.findDogPets(pet);
        for (Pet dog : allDogs) {
            System.out.println(dog);
        }
    }

    @Test
    public void testSelectPetsIn() {
        HashMap<String, Object> map = new HashMap<>();
        List<String > speciesList = new ArrayList<>();
        speciesList.add("bird");
        speciesList.add("cat");
        map.put("speciesList", speciesList);

        System.out.println(petDao.selectPetsIn(map));
    }

    @Test
    public void testUpdatePetDynamically() {
        Pet pet = new Pet();
//        pet.setBirth(new Date());
        pet.setName("hkkj");
        pet.setSex("m");
        petDao.updatePetDynamically(pet);
    }
}
