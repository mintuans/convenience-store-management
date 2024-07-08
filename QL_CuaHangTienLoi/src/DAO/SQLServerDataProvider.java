    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package DAO;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.logging.Level;
    import java.util.logging.Logger;

    /**
     *
     * @author Admin
     */
    public class SQLServerDataProvider {
        private Connection connection;
        private Statement statement;
        
        
        public Connection getConn() {
            return connection;
        }
        public void Open()
        {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://DESKTOP-BPO2HU3\\MINHTUAN:1433;encrypt=true;trustServerCertificate=true;databaseName=QL_CuaHangTienLoi";
                String user ="sa";
                String pass = "MinhTuan23Q";
                try {
                    connection = DriverManager.getConnection(url, user, pass);
                } catch (SQLException ex) {
                    Logger.getLogger(SQLServerDataProvider.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(connection != null) {
                    System.out.println("Kết nối thành công");
                } else {
                    System.out.println("Kết nối thất bại");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SQLServerDataProvider.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        public void Close()
        {
            try
            {
                this.connection.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        public ResultSet excuteQuery(String sql)
        {
            ResultSet resultSet = null;
            try
            {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
            return resultSet;
        }
        public  int excuteUpdate(String sql)
        {
            int n = -1;
            try
            {
                statement = connection.createStatement();
                n = statement.executeUpdate(sql);
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
            return n;
        }
    }
