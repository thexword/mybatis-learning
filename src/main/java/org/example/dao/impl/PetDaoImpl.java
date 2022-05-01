package org.example.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.PetDao;
import org.example.pojo.Pet;
import org.example.utils.MyBatisUtils;

import java.util.List;

public class PetDaoImpl implements PetDao {
    @Override
    public List<Pet> getAllPets() {
        SqlSession sqlSession;

        sqlSession = MyBatisUtils.getSqlSession();

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
    public void createPet(Pet pet) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        if (sqlSession == null) {
            return;
        }

        sqlSession.insert("createPet", pet);
        sqlSession.close();
    }
}
