package Bicicleta;
import java.util.Date;

public abstract class Bicicleta {
    private String marca;
    private String modelo;
    private float pesoKg;
    private String tipoCuadro;
    private float tamañoRuedaPulgadas;
    private float kilometrajeTotalKm;
    private Date fechaUltimoMantenimiento;
    private boolean necesitaServicio;
    private EstadoBicicleta estadoActual;
    private String numeroSerie;
    private int idInternoSistema;
    private Date fechaRegistro;

    // Constructor
    public Bicicleta(String marca, String modelo, float pesoKg, String tipoCuadro,
                     float tamañoRuedaPulgadas, String numeroSerie, int idInternoSistema) {
        this.marca = marca;
        this.modelo = modelo;
        this.pesoKg = pesoKg;
        this.tipoCuadro = tipoCuadro;
        this.tamañoRuedaPulgadas = tamañoRuedaPulgadas;
        this.numeroSerie = numeroSerie;
        this.idInternoSistema = idInternoSistema;
        this.fechaRegistro = new Date();
        this.estadoActual = EstadoBicicleta.DISPONIBLE;
        this.necesitaServicio = false;
        this.kilometrajeTotalKm = 0;
        this.fechaUltimoMantenimiento = null;
    }

    // Métodos
    public void mostrarEstado() {
        System.out.println("Estado de la bicicleta // Marca: " + marca + ", Modelo: " + modelo +
                ", Estado: " + estadoActual);
    }

    public void registrarMantenimiento() {
        this.fechaUltimoMantenimiento = new Date();
        this.estadoActual = EstadoBicicleta.DISPONIBLE;
        this.necesitaServicio = false;
        System.out.println("Mantenimiento registrado el " + fechaUltimoMantenimiento +
                " para la bicicleta " + numeroSerie);
    }

    // Getters y Setters (simplificados, puedes agregar más según necesites)
    public EstadoBicicleta getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(EstadoBicicleta estadoActual) {
        this.estadoActual = estadoActual;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public Date getFechaUltimoMantenimiento() {
        return fechaUltimoMantenimiento;
    }

    public void setNecesitaServicio(boolean necesitaServicio) {
        this.necesitaServicio = necesitaServicio;
    }
}

