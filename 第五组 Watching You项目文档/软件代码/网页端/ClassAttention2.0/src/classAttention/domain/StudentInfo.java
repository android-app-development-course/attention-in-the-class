package classAttention.domain;

import java.util.List;

public class StudentInfo {
    private String uid;
    private int classId;
    private String trueName;
    private String schoolId;

    private List<AppInfo> appInfoList;
    private static class AppInfo
    {
        private String appIcon;
        private String appLabel;
        private String appUsedTime;
    }

    public String getUid() {
        return uid;
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

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public List<AppInfo> getAppInfoList() {
        return appInfoList;
    }

    public void setAppInfoList(List<AppInfo> appInfoList) {
        this.appInfoList = appInfoList;
    }
}
