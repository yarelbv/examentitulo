package mx.uv.Resourses.bd;

public class Usuario {
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Password;

    public Usuario(String nombre, String apellido, String correo, String password){
        setCorreo(correo);
        setApellido(apellido);
        setNombre(nombre);
        setPassword(password);
    }

    public String getNombre() {
        return Nombre;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        this.Password = password;
    }
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        this.Correo = correo;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String toString(){
        return "usuario[Nombre "+ Nombre +"Apellido "+ Apellido +"Correo "+ "Password " + Password +"]";
    }

}
