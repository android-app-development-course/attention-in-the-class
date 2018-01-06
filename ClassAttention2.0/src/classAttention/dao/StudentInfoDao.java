package classAttention.dao;

import classAttention.domain.StudentInfo;
import classAttention.domain.StudentInfoInSql;
import com.google.gson.Gson;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import yong.tool.jdbc.TxQueryRunner;

import java.sql.SQLException;
import java.util.List;

public class StudentInfoDao {
    private QueryRunner qr = new TxQueryRunner();


    public StudentInfo getByUidAndClassId(String uid,int classId){
        try{
            String sql="select * from studentinfo where uid=? and classId =?";
            return qr.query(sql, new BeanHandler<>(StudentInfo.class), uid, classId);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<StudentInfoInSql> getByClassId(int classId){
        try{
            String sql="select * from studentinfo where classId = ?";
            return  qr.query(sql, new BeanListHandler<>(StudentInfoInSql.class),classId);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public String getBySid(int sid){
        try{
            String sql="select appInfoList from studentinfo where sid =?";
            return qr.query(sql, new BeanHandler<>(String.class),sid);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void add(StudentInfo studentInfo){
        try{
            String sql = "insert into studentinfo(uid,classId,trueName,schoolId,appInfoList) value(?,?,?,?,?)";
            Object[] params = {studentInfo.getUid(),studentInfo.getClassId(),studentInfo.getTrueName(),studentInfo.getSchoolId(),new Gson().toJson(studentInfo.getAppInfoList())};
            //Object[] params = {"1C8E9110F62E4D45B8A9A4C5CAE37BEE",113,"zzzz在","21523","aaa"};
            qr.update(sql,params);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



}
