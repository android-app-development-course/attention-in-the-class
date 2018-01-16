package classAttention.dao;

import classAttention.domain.ClassInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import yong.tool.jdbc.TxQueryRunner;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;


public class ClassDao {
    private QueryRunner qr = new TxQueryRunner();
    UserDao userDao = new UserDao();


    public String getUid(String username) {
        return userDao.getUid(username);
    }

    public ClassInfo getByUidAndTime(String uid,Timestamp timestamp){
        try{
            String sql="select * from classinfo where uid=? and startClassTime =?";
            return qr.query(sql, new BeanHandler<>(ClassInfo.class), uid, timestamp);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<ClassInfo> getByUid(String uid){
        try{
            String sql="select * from classinfo where uid=?";
            return qr.query(sql, new BeanListHandler<>(ClassInfo.class), uid);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void add(ClassInfo classInfo){
        try{
            String sql = "insert into classinfo(uid,startClassTime,classOrder) value(?,?,?)";
            Object[] params = {classInfo.getUid(),classInfo.getStartClassTime(),classInfo.getClassOrder()};
            qr.update(sql,params);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int createClassOrder(String uid){
        try{
            String sql = "select count(*) from classinfo where uid=?";
            return (int)(long)qr.query(sql,new ScalarHandler(),uid)+1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
