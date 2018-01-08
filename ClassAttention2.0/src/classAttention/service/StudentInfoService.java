package classAttention.service;

import classAttention.dao.StudentInfoDao;
import classAttention.domain.StudentInfo;
import classAttention.domain.StudentInfoInSql;

import java.util.List;

public class StudentInfoService {

    StudentInfoDao studentInfoDao = new StudentInfoDao();

    public void add(StudentInfo studentInfo){
        studentInfoDao.add(studentInfo);
    }


    public List<StudentInfoInSql> getStudentInfoByClassId(int classId){
        return studentInfoDao.getByClassId(classId);
    }

    public String getStudentInfoBySid(int sid){
        return studentInfoDao.getBySid(sid);
    }

}