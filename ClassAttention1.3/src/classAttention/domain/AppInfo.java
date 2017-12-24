package classAttention.domain;

import java.io.Serializable;

public class AppInfo {
    private String appLabel;
    private String appLTS;

    public AppInfo(String appLabel,String appLTS){
        this.appLabel = appLabel;
        this.appLTS = appLTS;
    }

    public String getAppLabel(){
        return appLabel;
    }
    public void setAppLabel(String appLabel){
        this.appLabel = appLabel;
    }


    public String getAppLTS(){
        return appLTS;
    }
    public void setAppLTS(String appLTS){
        this.appLTS = appLTS;
    }
}
