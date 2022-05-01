package example.dao.impl;


import example.dao.PetDao;
import example.pojo.Pet;
import example.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class PetDaoImpl implements PetDao {
    @Override
    public List<Pet> getAllPets() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        if (sqlSession == null) {
            return null;
        }

        List<Pet> petList = sqlSession.selectList("getAllPets");

        sqlSession.close();

        return petList;
    }

    @Override
    public Pet getPet(String petName) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        if (sqlSession == null) {
            return null;
        }

        Pet pet = sqlSession.selectOne("getPet", petName);
        sqlSession.close();
        return pet;
    }

    @Override
    public List<String> getAllSpecies() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        if (sqlSession == null) {
            return null;
        }

        List<String> allSpecies = sqlSession.selectList("getAllSpecies");
        sqlSession.close();
        return allSpecies;
    }

    @Override
    public List<Pet> selectPets(String sex) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        if (sqlSession == null) {
            return null;
        }

        List<Pet> selectPets = sqlSession.selectList("selectPets", sex);
        sqlSession.close();
        return selectPets;
    }

    @Override
    public void createPet(Pet pet) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        if (sqlSession == null) {
            return;
        }

        sqlSession.insert("createPet", pet);
        sqlSession.close();
    }

    @Override
    public void updatePet(Pet pet) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        if (sqlSession == null) {
            return;
        }

        sqlSession.update("updatePet", pet);
        sqlSession.close();
    }

    @Override
    public void deletePet(String name) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        if (sqlSession == null) {
            return;
        }

        sqlSession.delete("deletePet", name);
        sqlSession.close();
    }

    @Override
    public List<Pet> findAllDogs(Pet pet) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        if (sqlSession == null) {
            return null;
        }
        List<Pet> findAllDogs = sqlSession.selectList("findAllDogs", pet);
        sqlSession.close();
        return findAllDogs;
    }

    @Override
    public List<Pet> findDogPets(Pet pet) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        if (sqlSession == null) {
            return null;
        }
        List<Pet> findAllDogs = sqlSession.selectList("findDogPets", pet);
        sqlSession.close();
        return findAllDogs;
    }

    @Override
    public List<Pet> selectPetsIn(Map<String, Object> map) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        if (sqlSession == null) {
            return null;
        }

        List<Pet> findAllDogs = sqlSession.selectList("selectPetsIn", map);
        sqlSession.close();
        return findAllDogs;
    }

    @Override
    public void updatePetDynamically(Pet pet) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        if (sqlSession == null) {
            return;
        }

        sqlSession.selectList("updatePetDynamically", pet);
        sqlSession.close();
    }
}
