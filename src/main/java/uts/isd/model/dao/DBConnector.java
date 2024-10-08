package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector extends DB {

    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(driver);

        Properties dbProperties = new Properties();
        dbProperties.put("user", dbuser);
        dbProperties.put("password", dbpass);
        dbProperties.put("allowPublicKeyRetrieval", "true");
        dbProperties.put("useSSL", "false");

        try {
            conn = DriverManager.getConnection(URL + db, dbProperties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL + db, dbuser, dbpass);
    }

    public void closeConnection() throws SQLException {
        this.conn.close();
    }
}
