package connectionProvider;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.PooledConnection;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

/**
 *
 * @author Administrator
 */
public class ConnectionManager {

    public ConnectionManager() {
    }
    private static OracleConnectionPoolDataSource ods;//static object for connection pool datasource.
    private static PooledConnection pc_1;//static object for pooled connection
    boolean pcFlag = false;


    static {
        try {
            ods = new OracleConnectionPoolDataSource();
            java.util.Properties prop = new java.util.Properties();
            prop.setProperty("MinLimit", "5"); // the cache size is 5 at least
            prop.setProperty("MaxLimit", "500");
            prop.setProperty("InitialLimit", "3"); // create 3 connections at startup
            prop.setProperty("InactivityTimeout", "1800"); // seconds
            prop.setProperty("AbandonedConnectionTimeout", "900"); // seconds
            prop.setProperty("MaxStatementsLimit", "10000");
            prop.setProperty("PropertyCheckInterval", "60"); // seconds
            ods.setConnectionCacheProperties(prop);
              // ods.setURL("jdbc:oracle:thin:@localhost:1521:BIBHRMS");//url for the oracle sid where it found.  @AA   BIB LOCALPC
             ods.setURL("jdbc:oracle:thin:@10.1.11.9:1521:BIB");//url for the oracle sid where it found.  @AA   BIB server room computer
              //  ods.setURL("jdbc:oracle:thin:@192.168.10.197:1521:orcl");//url for the oracle from vercual machine
            ods.setUser("hrms");//user of the oracle
          //  ods.setUser("hrms");//user of the oracle
           //ods.setPassword("HRMS");
           // ods.setPassword("hrm$pa$$");//password of the oracle login
            ods.setPassword("Pa55w0rd@BIB");//password of the oracle login
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getConnctionPooll() {
        try {
            pc_1 = ods.getPooledConnection();
            pcFlag = true;
        } catch (Exception ex) {
            pcFlag = false;
        }

    }

    public Connection getConnection() throws SQLException {
        try {
            if (!pcFlag) {
                getConnctionPooll();
            }
            return pc_1.getConnection();
        } catch (SQLException x) {
            return null;
        }

    }

    public void closePooledConnections(Connection con) throws SQLException {
        if (con != null) {
            try {
                con.close();
            } catch (Exception ex) {
                ErrorLogWriter.writeError(ex);
            }
        }
    }

    public static void main(String arg[]) {
        try {
            ConnectionManager connectionManager = new ConnectionManager();
            connectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

