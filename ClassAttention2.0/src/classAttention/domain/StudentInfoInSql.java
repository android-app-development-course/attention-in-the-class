package classAttention.domain;

public class StudentInfoInSql {
     int sid;
     String uid;
     int classId;
     String trueName;
     String schoolId;
     String appInfoList;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getAppInfoList() {
        return appInfoList;
    }

    public void setAppInfoList(String appInfoList) {
        this.appInfoList = appInfoList;
    }

    @Override
    public String toString() {
        return "StudentInfoInSql{" +
                "sid=" + sid +
                ", uid='" + uid +
                ", classId=" + classId +
                ", trueName='" + trueName +
                ", schoolId='" + schoolId +
                '}';
    }
}
