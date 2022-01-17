package mx.uv.Resourses.bd;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.PreparableStatement;

import org.eclipse.jetty.util.security.Password;

public class UsuarioDAO {
    public Usuario vUsuario(String email, String pass){
        Usuario usuario=null;
        PreparableStatement statement = null;
        ResultSet rSet=null;
        Connection conn= null;
        conn= Conexion.getConnection();
        try{
            String sql = "SELECt * FROM usuario WHERE Correo=? ? and Password =?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, correo);
            statement.setString(2, password);
            rSet = statement.executeQuery();
            if (rSet .next()!=false){
                String Nombre = rSet.getString("Nombre");
                String Apellido = rSet.getString("Apellido");
                String Correo = rSet.getString("Correo");
                String Password = rSet.getString("Contraseña");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }

}
