package classAttention.domain;

import java.util.Map;

public class ReturnInfoToAndroid {

    private Map<String, String> errors;
    private User form;

    public ReturnInfoToAndroid(Map<String, String> errors, User form) {
        this.errors = errors;
        this.form = form;
    }


    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public User getForm() {
        return form;
    }

    public void setForm(User form) {
        this.form = form;
    }
}
