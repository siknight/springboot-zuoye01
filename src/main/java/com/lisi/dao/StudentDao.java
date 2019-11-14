package com.lisi.dao;


import com.lisi.bean.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {

    @Select("select * from student")
    public List<Student> findAllStudent();

    @Select("select count(*) from student")
    public int studentNum();

    @Insert("insert into student(studentName,age,sex,adress) values(#{studentName},#{age},#{sex},#{adress})")
    public int addStudent(@Param("studentName") String studentName, @Param("age") String age, @Param("sex") String sex, @Param("adress") String adress);

    @Delete("delete from student where studentId=#{id}")
    public int deleteStudentById(@Param("id") Integer id);

    @Update("update student set studentName=#{studentName},age=#{age},sex=#{sex},adress=#{adress} where studentId=#{id}")
    public int updateStudentById(@Param("studentName") String studentName, @Param("age") String age,@Param("sex") String sex, @Param("adress") String adress,  @Param("id") Integer id);

}
