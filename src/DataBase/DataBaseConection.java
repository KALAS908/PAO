package DataBase;

public class DataBaseConection {

    private String  url = "jdbc:mysql://localhost:3306/pao252";
    private String user = "root";
    private String password = "";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

}
