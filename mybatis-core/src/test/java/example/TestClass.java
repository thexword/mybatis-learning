package example;

import example.dao.impl.PetDaoImpl;
import example.pojo.Pet;
import example.pojo.Student;
import example.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TestClass {
    @Test
    public void testJDBC() {
        ResourceBundle resource = ResourceBundle.getBundle("jdbc");
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = resource.getString("user");
        String password = resource.getString("password");

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = JDBCUtils.getConnection(url, user, password);
            String sql = "select * from t_student";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String age = rs.getString(3);

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testGetAllPets() {
        List<Pet> allPets = new PetDaoImpl().getAllPets();
        for (Pet allPet : allPets) {
            System.out.println(allPet);
        }
    }

    @Test
    public void testGetPet() {
        String petName  = "Tony";
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
    public void testSelectPets() {
        List<Pet> petList = new PetDaoImpl().selectPets("w");
        for (Pet pet : petList) {
            System.out.println(pet);
        }
    }

    @Test
    public void testCreatePet() {
        Pet pet = new Pet();
        pet.setName("hkkj");
//        pet.setOwner("Kate");
        pet.setSpecies("dog");
//        pet.setSex("m");
        pet.setBirth(new Date());

        new PetDaoImpl().createPet(pet);
    }

    @Test
    public void testUpdatePet() {
        Pet pet = new Pet();
        pet.setName("Slim");
        pet.setOwner("Suk");
        pet.setSpecies("cat");
        pet.setSex("w");
        pet.setBirth(new Date());

        new PetDaoImpl().updatePet(pet);
    }

    @Test
    public void testDeletePet() {
        new PetDaoImpl().deletePet("Slimy");
    }


    @Test
    public void testFindAllDogs() {
        Pet pet = new Pet();
        pet.setSpecies("dog");
//        pet.setSex("m");
//        pet.setOwner("Kate");
        List<Pet> allDogs = new PetDaoImpl().findAllDogs(pet);
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
        List<Pet> allDogs = new PetDaoImpl().findDogPets(pet);
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

        System.out.println(new PetDaoImpl().selectPetsIn(map));
    }

    @Test
    public void testUpdatePetDynamically() {
        Pet pet = new Pet();
        pet.setName("coco");
        pet.setBirth(new Date());
        pet.setSex("w");
        new PetDaoImpl().updatePetDynamically(pet);
    }
}
