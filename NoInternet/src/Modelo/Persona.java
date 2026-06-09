package Modelo;

public class Persona {

    protected int id;
    protected String nombre;
    protected double edad;
    protected int cantidad;
    protected String nacionalidad;

    public Persona() {
        this.id = 0;
        this.nombre = "";
        this.edad = 0.0;
        this.cantidad = 0;
        this.nacionalidad = "Sin nacionalidad";
    }

    public Persona(int id, String nombre, double edad, int cantidad, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.cantidad = cantidad;
        this.nacionalidad = nacionalidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return edad;
    }

    public void setPrecio(double edad) {
        if (edad >= 0) this.edad = edad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) this.cantidad = cantidad;
    }

    public String getCategoria() {
        return nacionalidad;
    }

    public void setCategoria(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String mostrarDetalle() {
        return String.format("ID: %d | Nombre: %s | Edad: %.0f | Cantidad: %d | Nacionalidad: %s", 
                                id, nombre, edad, cantidad, nacionalidad);
    }

    public double calcularValorInventario() {
        return edad * cantidad;
    }

    public double calcularValorInventario(double porcentajeDescuento) {
        return (edad - edad * (porcentajeDescuento / 100) * cantidad);
    }

    @Override
    public String toString() {
        return mostrarDetalle();
    }
}