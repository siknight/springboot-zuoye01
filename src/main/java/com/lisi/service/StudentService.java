package com.lisi.service;


import com.github.pagehelper.PageHelper;
import com.lisi.bean.Student;
import com.lisi.dao.StudentDao;
import com.lisi.util.Result;
import com.lisi.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentDao studentDao;

    /**
     *
     * @param pageNum
     * @return
     */
    public Result findAllStudentByPage(Integer pageNum){


        Result result = new Result();

        if (StringUtils.isEmpty(pageNum)) {
            result.setCode(ResultMsg.PAGE_SIZE_IS_NULL);
            result.setMsg(ResultMsg.PAGE_SIZE_IS_NULLMSG);
            return result;
        }
        int studentNum=studentDao.studentNum();
        //一页显示一个
        PageHelper.startPage(pageNum, 3);
        List<Student> students = studentDao.findAllStudent();

        HashMap<String, Object> map = new HashMap<>();
        map.put("studentNum",studentNum);
        map.put("data",students);
        result.setCode(ResultMsg.OK);
        result.setMsg(ResultMsg.Nav_SELECT_SUCCESS);
        result.setData(map);
        return result;
    }

    /**
     * 添加student
     *
     * @return
     */
    public Result addStudentById( String studentName,String age,String sex,  String adress){

        Result result = new Result();

        if (StringUtils.isEmpty(studentName)||StringUtils.isEmpty(age)) {
            result.setCode(ResultMsg.ARGS_IS_NULL);
            result.setMsg(ResultMsg.ARGS_IS_NULLMSG);
            return result;
        }
        studentDao.addStudent(studentName,age,sex,adress);
        result.setCode(ResultMsg.OK);
        result.setMsg(ResultMsg.SUCCESSS_MSG);
//        result.setData(nav);
        return result;
    }

    /**
     * 修改nav通过id

     * @return
     */

    public Result updateStudentById( String studentName,String age,String sex,  String adress,Integer id){

        Result result = new Result();

        if (StringUtils.isEmpty(studentName)||StringUtils.isEmpty(age)||StringUtils.isEmpty(sex)) {
            result.setCode(ResultMsg.ARGS_IS_NULL);
            result.setMsg(ResultMsg.ARGS_IS_NULLMSG);
            return result;
        }
        studentDao.updateStudentById(studentName,age,sex,adress,id);
        result.setCode(ResultMsg.OK);
        result.setMsg(ResultMsg.SUCCESSS_MSG);
//        result.setData(nav);
        return result;
    }


    /**
     * 删除nav通过id  完成
     * @param id
     * @return
     */
    public Result deleteStudentById(Integer id){

        Result result = new Result();

        if (StringUtils.isEmpty(id)) {
            result.setCode(ResultMsg.ARGS_IS_NULL);
            result.setMsg(ResultMsg.ARGS_IS_NULLMSG);
            return result;
        }
        studentDao.deleteStudentById(id);
        result.setCode(ResultMsg.OK);
        result.setMsg(ResultMsg.SUCCESSS_MSG);

        return result;
    }
}
