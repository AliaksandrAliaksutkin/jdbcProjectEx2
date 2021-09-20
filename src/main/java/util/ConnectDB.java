package util;

public enum ConnectDB {
    USERNAME ("postgres"),
    PASSWORD ("821252"),
    URL ("jdbc:postgresql://localhost:5432/postgres"),
    PORT ("5432"),
    DBNAME ("postgres"),
    HOST ("localhost");

    private String str;

    ConnectDB(String str) {
        this.str = str;
    }
    public String getConnectDB() {
        return str;
    }

}
