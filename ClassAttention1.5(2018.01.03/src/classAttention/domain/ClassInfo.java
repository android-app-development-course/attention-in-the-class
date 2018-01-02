package classAttention.domain;
import java.sql.Timestamp;

public class ClassInfo {
    private int classId;
    private String uid;
    private Timestamp startClassTime;
    private int classOrder;


    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Timestamp getStartClassTime() {
        return startClassTime;
    }

    public void setStartClassTime(Timestamp startClassTime) {
        this.startClassTime = startClassTime;
    }

    public int getClassOrder() {
        return classOrder;
    }

    public void setClassOrder(int classOrder) {
        this.classOrder = classOrder;
    }


    @Override
    public String toString() {
        return "ClassInfo{" +
                "classId=" + classId +
                ", uid='" + uid + '\'' +
                ", startClassTime=" + startClassTime +
                ", classOrder=" + classOrder +
                '}';
    }


}
