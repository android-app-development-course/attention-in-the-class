package classAttention.domain;

public class Research {
    private String uid;
    private int classId;
    private String informationJson;

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

    public String getInformationJson() {
        return informationJson;
    }

    public void setInformationJson(String informationJson) {
        this.informationJson = informationJson;
    }
}
