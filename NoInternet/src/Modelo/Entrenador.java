package Modelo;

public class Entrenador extends Persona {

    private String estrategia;
    private int experienciaAnios;
    private double sueldo;

    public Entrenador() {
        super();
        this.estrategia = "";
        this.experienciaAnios = 0;
        this.sueldo = 0.0;
    }

    public Entrenador(int id, String nombre, double edad, int cantidad, String nacionalidad,
                       String estrategia, int experienciaAnios, double sueldo) {
        super(id, nombre, edad, cantidad, nacionalidad);
        this.estrategia = estrategia;
        this.experienciaAnios = experienciaAnios;
        this.sueldo = sueldo;
    }

    public String getEstrategia() { return estrategia; }
    public void setEstrategia(String estrategia) { this.estrategia = estrategia; }

    public int getExperienciaAnios() { return experienciaAnios; }
    public void setExperienciaAnios(int experienciaAnios) { this.experienciaAnios = experienciaAnios; }

    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    @Override
    public String mostrarDetalle() {
        return super.mostrarDetalle() + String.format(
            " | Estrategia: %s | Experiencia: %d años | Sueldo: %.1f",
            estrategia, experienciaAnios, sueldo);
    }

    @Override
    public String toString() { return "[ENTRENADOR] " + mostrarDetalle(); }
}