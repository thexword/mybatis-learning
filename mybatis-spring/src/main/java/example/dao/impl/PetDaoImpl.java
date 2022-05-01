package example.dao.impl;

import example.dao.PetDao;
import example.pojo.Pet;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;


public class PetDaoImpl implements PetDao {
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Pet> getAllPets() {
        return sqlSessionTemplate.selectList("getAllPets");
    }


    @Override
    public Pet getPet(String petName) {
        return sqlSessionTemplate.selectOne("getPet", petName);
    }

    @Override
    public List<String> getAllSpecies() {
        return sqlSessionTemplate.selectList("getAllSpecies");
    }

    @Override
    public List<Pet> selectPets(String sex) {
        return sqlSessionTemplate.selectList("selectPets", sex);
    }

    @Override
    public void createPet(Pet pet) {
        sqlSessionTemplate.insert("createPet", pet);
    }

    @Override
    public void updatePet(Pet pet) {
        sqlSessionTemplate.update("updatePet", pet);
    }

    @Override
    public void deletePet(String name) {
        sqlSessionTemplate.delete("deletePet", name);
    }
}
