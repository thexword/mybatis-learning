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
}
