package mx.uv;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.mysql.cj.protocol.x.Ok;

import org.apache.commons.lang.Validate;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.io.RetainableByteBuffer;
import org.omg.CORBA.Context;

import mx.uv.Resourses.bd.Usuario;
import mx.uv.Resourses.bd.UsuarioDAO;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
/**
 * Hello world!
 *
 */
public class App{

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        staticFiles.location("/");
        options("/",(request,response)->{
            String accessControlRequestHeader = request.headers("Access-Control-Request-Header");
            if(accessControlRequestHeader != null){
                response.header("Access-Control-Request-Header", accessControlRequestHeader);
            }

            String accessControlRequest = request.headers("Access-Control-Request");
            if(accessControlRequestHeader != null){
                response.header("Access-Control-Request", accessControlRequest);
            }
            return "ok";

            get("/",(req, res)->{
                Map<String, Object> model = new HashMap<>();
                return new VelocityTemplateEngine().render(new) ModelAndView(model, "inicio.html");

            });
        });
        post("/IngresarUsuario", (rq, rs)-> {
            String Correo = rq.queryParams("correo");
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if(usuarioDAO.vUsuario(email)){
                Map<String, Object> variables = new HashMap<>();
                variables.put("Usuario ya registrado", "Intanta con uno nuevo ");
                IContext context = new Context(rq.raw().getLocale(),variables);
                String out = Thymeleafutil.getTemplateEngine).process(".../inicio.html", context);
            }
            String Pass= rq.queryParams("pass");
            String Nombre= rq.queryParams("Nombre");
            String Apellido= rq.queryParams("Apellido");
            usuarioDAO.registrado(new Usuario(nombre, apellido, correo, password));
        });

        post("/Validar", (rq, rs))->{
            Usuario usuario;
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuario = usuarioDAO.vUsuario(rq.queryParams("email"),rq.queryParams("pass"));
            if(usuario!=null){
                String respuesta=vUsuario(rq, usuario.getCorreo(), usuario.getPassword()), usuario.getApellido(), usuario.getNombre());
                return respuesta;
            }else{
                Map<String, Object> variables = new HashMap<>();
                variables.put("Usuario no existente", "Ya estas registrado");
                IContext context = new Context(rq.raw().getLocale(),variables);
                return new VelocityTemplateEngine().render(new modelAndView(context, "inicio.html"));
            }
        });
    }
}
