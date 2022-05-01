package example.dao.impl;


import example.dao.PetDao;
import example.pojo.Pet;
import example.utils.MyBatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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
}
