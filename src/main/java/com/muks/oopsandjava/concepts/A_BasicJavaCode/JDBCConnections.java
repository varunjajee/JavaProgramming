package com.muks.oopsandjava.concepts.A_BasicJavaCode;

import java.sql.*;

/**
 * Connection to DB and fetch the columns
 */
public class JDBCConnections {
    public static void main(String[] args) {
        String host = "jdbc:mysql://localhost/";
        String db = "db_test";
        String user = "root";
        String password = "bitnami";
        String sqlQuery = "Select * from tbl_one";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(host+db,user,password);

            ResultSet rs = conn.createStatement().executeQuery(sqlQuery);

            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            System.out.printf("The query fetched %d columns\n",cols);
            System.out.println("These columns are: ");
            for (int i=1;i<=cols;i++) {
                String colName = rsmd.getColumnName(i);
                String colType = rsmd.getColumnTypeName(i);
                System.out.println(colName+" of type "+colType);

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
