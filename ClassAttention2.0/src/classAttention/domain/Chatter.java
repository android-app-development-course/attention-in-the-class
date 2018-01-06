package classAttention.domain;

public class Chatter {
    private Boolean isStudent;//区分学生和创建者(false为创建者，true为学生)
    private String userName;
    private String schoolId;//加入时含有schoolid 在聊天时schoolid=null
    private String message;//聊天信息
    private int classId; // If isStudent is true,show the classId it belongs, is false show its classId


    public Boolean getStudent() {
        return isStudent;
    }

    public void setStudent(Boolean student) {
        isStudent = student;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Boolean getIsStudent(){
        return isStudent;
    }
    public void setIsStudent(Boolean isStudent){
        this.isStudent = isStudent;
    }

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
