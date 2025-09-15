package Bicicleta;

public class BicicletaMecanica extends Bicicleta {
    private int numeroVelocidades;
    private String tipoFrenos;
    private boolean tienePortaequipaje;

    // Constructor
    public BicicletaMecanica(String marca, String modelo, float pesoKg, String tipoCuadro,
                             float tamañoRuedaPulgadas, String numeroSerie, int idInternoSistema,
                             int numeroVelocidades, String tipoFrenos) {
        super(marca, modelo, pesoKg, tipoCuadro, tamañoRuedaPulgadas, numeroSerie, idInternoSistema);
        this.numeroVelocidades = numeroVelocidades;
        this.tipoFrenos = tipoFrenos;
        this.tienePortaequipaje = false;
    }

    // Método
    public String descripcionTecnica() {
        return "Bicicleta Mecánica // Velocidades: " + numeroVelocidades +
                ", Frenos: " + tipoFrenos + ", Portaequipaje: " + (tienePortaequipaje ? "Sí" : "No");
    }

    // Getters y Setters (simplificados)
    public int getNumeroVelocidades() {
        return numeroVelocidades;
    }

    public void setTienePortaequipaje(boolean tienePortaequipaje) {
        this.tienePortaequipaje = tienePortaequipaje;
    }
}
