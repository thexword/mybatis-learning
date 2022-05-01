package example.dao.impl;

import example.dao.PetDao;
import example.pojo.Pet;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;


public class PetDaoImpl implements PetDao {
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<Pet> getAllPetsData() {
        return sqlSessionTemplate.selectList("getAllPets");
    }

    public List<Pet> getAllPets(){
        return null;
    }

    public Pet getPet(@Param("name") String name) {
        return null;
    }

    public List<String> getAllSpecies() {
        return null;
    }

    public List<Pet> selectPets(String sex) {
        return null;
    }

    public void createPet(Pet pet) {

    }

    public void updatePet(Pet pet) {

    }

    public void deletePet(String name) {

    }
}
