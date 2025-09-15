package Bicicleta;

public class BicicletaElectrica extends Bicicleta {
    private float capacidadBateria;
    private float nivelCargaActualPorcentaje;
    private int potenciaMotorWatts;
    private boolean asistenciaPedaleo;
    private float velocidadMaximaKmH;
    private boolean gpsIntegrado;
    private boolean bluetoothDisponible;

    // Constructor
    public BicicletaElectrica(String marca, String modelo, float pesoKg, String tipoCuadro,
                              float tamañoRuedaPulgadas, String numeroSerie, int idInternoSistema,
                              float capacidadBateria, int potenciaMotorWatts, float velocidadMaximaKmH) {
        super(marca, modelo, pesoKg, tipoCuadro, tamañoRuedaPulgadas, numeroSerie, idInternoSistema);
        this.capacidadBateria = capacidadBateria;
        this.nivelCargaActualPorcentaje = 100; // Inicialmente al 100%
        this.potenciaMotorWatts = potenciaMotorWatts;
        this.velocidadMaximaKmH = velocidadMaximaKmH;
        this.asistenciaPedaleo = true;
        this.gpsIntegrado = false;
        this.bluetoothDisponible = false;
    }

    // Método
    public float calcularAutonomiaRestanteKm() {
        // Cálculo simplificado: autonomía = capacidad * nivel de carga * un factor de eficiencia (0.9)
        float autonomia = (capacidadBateria * nivelCargaActualPorcentaje / 100) * 0.9f;
        return autonomia;
    }

    // Getters y Setters (simplificados)
    public float getNivelCargaActualPorcentaje() {
        return nivelCargaActualPorcentaje;
    }

    public void setNivelCargaActualPorcentaje(float nivelCargaActualPorcentaje) {
        if (nivelCargaActualPorcentaje >= 0 && nivelCargaActualPorcentaje <= 100) {
            this.nivelCargaActualPorcentaje = nivelCargaActualPorcentaje;
        }
    }
}

