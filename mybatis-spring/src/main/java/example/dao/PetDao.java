package example.dao;

import example.pojo.Pet;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface PetDao {
    @Select("select * from pet")
    List<Pet> getAllPets();

    @Select("select * from pet where name=#{name}")
    Pet getPet(String name);

    @Select("select species from pet")
    List<String> getAllSpecies();

    @Select("select * from pet where sex=#{sex}")
    List<Pet> selectPets(String sex);

    @Insert("insert into pet(name, owner, species, sex, birth, death) " +
            "values(#{name}, #{owner}, #{species}, #{sex}, #{birth}, #{death})")
    void createPet(Pet pet);

    @Update("update pet set name=#{name}, owner=#{owner}, species=#{species}, sex=#{sex}, birth=#{birth}, death=#{death} " +
            "where name=#{name}")
    void updatePet(Pet pet);

    @Delete("delete from pet where name=#{name}")
    void deletePet(String name);

    @Select("<script>" +
            "select * from pet where species=#{species}" +
            "<if test='sex != null'> and sex=#{sex} </if> " +
            "<if test='owner != null'> and owner= #{owner} </if>" +
            "</script>")
    List<Pet> findAllDogs(Pet pet);

    @Select("<script>" +
            "select * from pet where species=#{species}" +
            "<choose>" +
            "<when test='sex != null'>anditem sex=#{sex}</when>" +
            "<when test='owner != null'>and owner=#{owner}</when>" +
            "<otherwise>and name like 'Ka%'</otherwise>" +
            "</choose>" +
            "</script>")
    List<Pet> findDogPets(Pet pet);

    @Select("<script>" +
            "select * from pet where species in " +
            "<foreach item='item' index='index' collection='speciesList' open='(' separator=',' close=')'>" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    List<Pet> selectPetsIn(Map<String, Object> map);

    @Update("<script>" +
            "update pet" +
            "<set>" +
            "<if test='birth != null'> birth=#{birth},</if>" +
            "<if test='death != null'> death=#{death},</if>" +
            "<if test='sex != null'> sex=#{sex}</if>" +
            "</set>" +
            "where name=#{name}" +
            "</script>")
    void updatePetDynamically(Pet pet);
}
