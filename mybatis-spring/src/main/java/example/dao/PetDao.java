package example.dao;

import example.pojo.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface PetDao {
    @Select("select * from pet")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "owner", column = "owner"),
            @Result(property = "species", column = "species"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "birth", column = "birth"),
            @Result(property = "death", column = "death")
    })
    List<Pet> getAllPets();

    @Select("select * from pet where name=#{name}")
    Pet getPet(String name);

    @Select("select species from pet")
    List<String> getAllSpecies();

    @Select("select * from pet where sex=#{sex}")
    List<Pet> selectPets(@Param("sex") String sex);

    @Insert("insert into pet(name, owner, species, sex, birth, death) " +
            "values(#{name}, #{owner}, #{species}, #{sex}, #{birth}, #{death})")
    @SelectKey(statement = "select last_insert_id()",
            keyProperty = "id",
            before = false,
            resultType = Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "id")
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
