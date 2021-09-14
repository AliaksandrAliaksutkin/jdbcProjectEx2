public enum Config {
    HOST ("localhost"),
    PORT("5432"),
    DBNAME("postgres"),
    USERNAME("postgres"),
    PASSWORD("821252");


    private String configDB;

    Config(String configDB) {
        this.configDB = configDB;
    }

    public String getConfigDB(){
        return configDB;
    }

    @Override
    public String toString() {
        return "Config{" +
                "configDB='" + configDB + '\'' +
                '}';
    }
}
