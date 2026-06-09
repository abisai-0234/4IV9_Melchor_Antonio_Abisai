package Modelo;

public class Jugador extends Persona {

    private String posicion;

    public Jugador() {
        super();
        this.posicion = "";
    }

    public Jugador(int id, String nombre, double edad, int cantidad, String nacionalidad, String posicion) {
        super(id, nombre, edad, cantidad, nacionalidad);
        this.posicion = posicion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String mostrarDetalle() {
        return super.mostrarDetalle() + " | Posición: " + posicion;
    }

    @Override
    public String toString() {
        return "[JUGADOR] " + mostrarDetalle();
    }
}