package Modelo;

public class Partido extends Persona {

    private String estadio;
    private String resultado;
    private String torneo;

    public Partido() {
        super();
        this.estadio = "";
        this.resultado = "";
        this.torneo = "";
    }

    public Partido(int id, String nombre, double edad, int cantidad, String nacionalidad,
                   String estadio, String resultado, String torneo) {
        super(id, nombre, edad, cantidad, nacionalidad);
        this.estadio = estadio;
        this.resultado = resultado;
        this.torneo = torneo;
    }

    public String getTalla() { return estadio; }
    public void setTalla(String estadio) { this.estadio = estadio; }

    public String getColor() { return resultado; }
    public void setColor(String resultado) { this.resultado = resultado; }

    public String getMaterial() { return torneo; }
    public void setMaterial(String torneo) { this.torneo = torneo; }

    @Override
    public String mostrarDetalle() {
        return super.mostrarDetalle() + String.format(
            " | Estadio: %s | Resultado: %s | Torneo: %s",
            estadio, resultado, torneo);
    }

    @Override
    public String toString() { return "[PARTIDO] " + mostrarDetalle(); }
}