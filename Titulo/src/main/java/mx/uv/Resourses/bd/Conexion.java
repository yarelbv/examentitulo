package mx.uv.Resourses.bd;

import java.sql.*;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;

public class Conexion {
    private String url = "";
    private String username = "yarel_bvb";
    private String password = "com.mysql.cj.jdbc.Driver";
    private Connection conn= null;

    public Connection = getConnection(){
        try{
            Class.forname(driverName);
            conn=DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

}
