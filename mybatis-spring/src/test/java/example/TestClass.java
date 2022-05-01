package example;

import example.dao.impl.PetDaoImpl;
import example.pojo.Pet;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestClass {
    @Test
    public void test() {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});
        PetDaoImpl petDAOImpl = (PetDaoImpl) appContext.getBean("petDAOImpl");

        List<Pet> pets = petDAOImpl.getAllPets();
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}
