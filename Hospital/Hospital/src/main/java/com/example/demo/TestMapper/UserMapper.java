package com.example.demo.TestMapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();
    /*，@Result中的property属性对应User对象中的成员名，column对应SELECT出的字段名。
    在该配置中故意没有查出id属性，只对User对应中的name和age对象做了映射配置，
    这样可以通过下面的单元测试来验证查出的id为null，而其他属性不为null：*/




    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);//@Param中定义的name对应了SQL中的#{name}，age对应了SQL中的#{age}。

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insertByUser(User user);//这样语句中的#{name}、#{age}就分别对应了User对象中的name和age属性。

    @Insert("INSERT INTO user(name, age) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    /*对于Insert语句中需要的参数，我们只需要在map中填入同名的内容即可，具体如下面代码所示：
    Map<String, Object> map = new HashMap<>();
    map.put("name", "CCC");
    map.put("age", 40);
    userMapper.insertByMap(map); */

}