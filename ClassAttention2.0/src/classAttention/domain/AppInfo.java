package classAttention.domain;

public class AppInfo {
    private String appIcon;
    private String appLabel;
    private String appUsedTime;

    public AppInfo() {

    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppLabel() {
        return appLabel;
    }

    public void setAppLabel(String appLabel) {
        this.appLabel = appLabel;
    }

    public String getAppUsedTime() {
        return appUsedTime;
    }

    public void setAppUsedTime(String appUsedTime) {
        this.appUsedTime = appUsedTime;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "appIcon='" + appIcon + '\'' +
                ", appLabel='" + appLabel + '\'' +
                ", appUsedTime='" + appUsedTime + '\'' +
                '}';
    }
}
