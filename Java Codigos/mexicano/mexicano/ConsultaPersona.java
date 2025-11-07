package mexicano;

public class ConsultaPersona {
   
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    // Formato: AAAAMMDD
    private String fechaNacimiento; 
    // H para Hombre, M para Mujer
    private String sexo; 
    // Nombre completo del estado de nacimiento
    private String estado; 

    // Constructor
    public ConsultaPersona(String nombre, String primerApellido,
            String segundoApellido, String fechaNacimiento, String sexo, String estado) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estado = estado;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEstado() {
        return estado;
    }

}
