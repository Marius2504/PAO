package client;

public class help {
    private String message;
    private String title;
    private register acc;
    public help(){
        this.message = "";
        this.title = "";
        this.acc = null;
    }
    public help(String message, String title, register acc) {
        this.message = message;
        this.title = title;
        this.acc = acc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public register getAcc() {
        return acc;
    }

    public void setAcc(register acc) {
        this.acc = acc;
    }
}
