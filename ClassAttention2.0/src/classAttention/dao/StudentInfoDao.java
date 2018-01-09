package classAttention.dao;

import classAttention.domain.AppInfo;
import classAttention.domain.StudentInfo;
import classAttention.domain.StudentInfoInSql;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import yong.tool.jdbc.TxQueryRunner;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentInfoDao {
    private QueryRunner qr = new TxQueryRunner();
    private static class StudentInfoToWeb {
        private String trueName;
        private String schoolId;
        private List<AppInfo> appInfoList;

        public StudentInfoToWeb() {
        }

        public StudentInfoToWeb(String trueName, String schoolId, List<AppInfo> appInfoList) {
            this.trueName = trueName;
            this.schoolId = schoolId;
            this.appInfoList = appInfoList;
        }
    }

    public StudentInfo getByUidAndClassId(String uid, int classId) {
        try {
            String sql = "select * from studentinfo where uid=? and classId =?";
            return qr.query(sql, new BeanHandler<>(StudentInfo.class), uid, classId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getJsonByClassId(int classId) {
        try {
            String sql = "select * from studentinfo where classId = ?";
            List<StudentInfoInSql> studentInfoInSqlList = qr.query(sql, new BeanListHandler<>(StudentInfoInSql.class), classId);
            List<StudentInfoToWeb> studentInfoToWebList = new ArrayList<>();
            for (int i = 0; i < studentInfoInSqlList.size(); i++) {
                String trueName = studentInfoInSqlList.get(i).getTrueName();
                String schoolId = studentInfoInSqlList.get(i).getSchoolId();
                List<AppInfo> appInfoList = new Gson().fromJson(studentInfoInSqlList.get(i).getAppInfoList(), new TypeToken<List<AppInfo>>() {}.getType());
                studentInfoToWebList.add(new StudentInfoToWeb(trueName, schoolId, appInfoList));
            }
            return new Gson().toJson(studentInfoToWebList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBySid(int sid) {
        try {
            String sql = "select appInfoList from studentinfo where sid =?";
            return qr.query(sql, new BeanHandler<>(String.class), sid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(StudentInfo studentInfo) {
        try {
            String sql = "insert into studentinfo(uid,classId,trueName,schoolId,appInfoList) value(?,?,?,?,?)";
            Object[] params = {studentInfo.getUid(), studentInfo.getClassId(), studentInfo.getTrueName(), studentInfo.getSchoolId(), new Gson().toJson(studentInfo.getAppInfoList())};
            //Object[] params = {"1C8E9110F62E4D45B8A9A4C5CAE37BEE",113,"zzzz在","21523","aaa"};
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
