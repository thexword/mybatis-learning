package example.dao.impl;

import example.dao.PetDao;
import example.pojo.Pet;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public class PetDaoImpl implements PetDao {
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Pet> getAllPets() {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        return mapper.getAllPets();
//        return sqlSessionTemplate.selectList("getAllPets");
    }


    @Override
    public Pet getPet(String petName) {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        return mapper.getPet(petName);
//        return sqlSessionTemplate.selectOne("getPet", petName);
    }

    @Override
    public List<String> getAllSpecies() {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        return mapper.getAllSpecies();
//        return sqlSessionTemplate.selectList("getAllSpecies");
    }

    @Override
    public List<Pet> selectPets(String sex) {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        return mapper.selectPets(sex);
//        return sqlSessionTemplate.selectList("selectPets", sex);
    }

    @Override
    public void createPet(Pet pet) {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        mapper.createPet(pet);
//        sqlSessionTemplate.insert("createPet", pet);
    }

    @Override
    public void updatePet(Pet pet) {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        mapper.updatePet(pet);
//        sqlSessionTemplate.update("updatePet", pet);
    }

    @Override
    public void deletePet(String name) {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        mapper.deletePet(name);
//        sqlSessionTemplate.delete("deletePet", name);
    }

    @Override
    public List<Pet> findAllDogs(Pet pet) {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        return mapper.findAllDogs(pet);
//        return sqlSessionTemplate.selectList("findAllDogs", pet);
    }

    @Override
    public List<Pet> findDogPets(Pet pet) {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        return mapper.findDogPets(pet);
//        return sqlSessionTemplate.selectList("findDogPets", pet);
    }

    @Override
    public List<Pet> selectPetsIn(Map<String, Object> map) {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        return mapper.selectPetsIn(map);
//        return sqlSessionTemplate.selectList("selectPetsIn", map);
    }

    @Override
    public void updatePetDynamically(Pet pet) {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        mapper.updatePetDynamically(pet);
//        sqlSessionTemplate.update("updatePetDynamically", pet);
    }

    @Override
    public void callReadPet(Map<String, String> map) {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        mapper.callReadPet(map);
//        sqlSessionTemplate.selectOne("callReadPet", map);
    }

    @Override
    public List<Pet> callReadAllPets() {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        return mapper.callReadAllPets();
//        return sqlSessionTemplate.selectList("callReadAllPets");
    }

    @Override
    public String getPetOwner(String name) {
        PetDao mapper = sqlSessionTemplate.getMapper(PetDao.class);
        return mapper.getPetOwner(name);
//        return sqlSessionTemplate.selectOne("getPetOwner", name);
    }

    @Override
    @Transactional(rollbackFor = java.lang.Exception.class)
    public void doCreateAndUpdatePetInTx(Pet createPet, Pet updatePet) throws Exception {
        createPet(createPet);
        int i = 100 / 0;
        updatePet(updatePet);

//        try {
//            createPet(createPet);
//            int i = 100 / 0;
//            updatePet(updatePet);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
//            status.setRollbackOnly();
//        }
    }
}
