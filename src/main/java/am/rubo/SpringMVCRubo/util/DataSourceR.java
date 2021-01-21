package am.rubo.SpringMVCRubo.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataSourceR {

    Connection connection;

        private  String url;
        private  String username ;
        private  String password;
        private  String driverClassName;

        public  Connection getConnection() {


            try {
                if (connection == null||connection.isClosed()) {
                    Class.forName(driverClassName);
                    connection = DriverManager.getConnection(url, username, password);
                }
                return connection;
            }catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
