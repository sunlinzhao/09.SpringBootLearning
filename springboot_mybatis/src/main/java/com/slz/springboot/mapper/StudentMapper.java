package com.slz.springboot.mapper;

import com.slz.springboot.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : SunLZ
 * @project : SpringBootLearning
 * @date : 2024/10/9
 */
//@Mapper
@Repository
public interface StudentMapper {
    @Select("select * from student")
    List<Student> selectAll();
    @Insert("insert into student(name,age,gender) values(#{name},#{age},#{gender})")
    int insert(Student student);
}
