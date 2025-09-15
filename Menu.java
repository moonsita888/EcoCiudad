package Bicicleta;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    private ArrayList<Bicicleta> bicicletas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n=== Sistema de Gestión de Bicicletas - EcoCiudad ===");
            System.out.println("1. Registrar bicicleta");
            System.out.println("2. Consultar estado actual");
            System.out.println("3. Calcular autonomía (solo eléctricas)");
            System.out.println("4. Descripción técnica (solo mecánicas)");
            System.out.println("5. Registrar mantenimiento");
            System.out.println("6. Mostrar estados de todas las bicicletas (polimorfismo)");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarBicicleta();
                    break;
                case 2:
                    consultarEstado();
                    break;
                case 3:
                    calcularAutonomia();
                    break;
                case 4:
                    descripcionTecnica();
                    break;
                case 5:
                    registrarMantenimiento();
                    break;
                case 6:
                    mostrarEstadosPolimorfismo();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void registrarBicicleta() {
        System.out.println("\nTipo de bicicleta (1: Eléctrica, 2: Mecánica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Peso (kg): ");
        float pesoKg = scanner.nextFloat();
        System.out.print("Tipo de cuadro: ");
        scanner.nextLine(); // Limpiar buffer
        String tipoCuadro = scanner.nextLine();
        System.out.print("Tamaño de rueda (pulgadas): ");
        float tamañoRueda = scanner.nextFloat();
        System.out.print("Número de serie: ");
        scanner.nextLine(); // Limpiar buffer
        String numeroSerie = scanner.nextLine();
        System.out.print("ID interno: ");
        int idInterno = scanner.nextInt();

        if (tipo == 1) {
            System.out.print("Capacidad de batería (Wh): ");
            float capacidadBateria = scanner.nextFloat();
            System.out.print("Potencia del motor (W): ");
            int potenciaMotor = scanner.nextInt();
            System.out.print("Velocidad máxima (km/h): ");
            float velocidadMaxima = scanner.nextFloat();
            Bicicleta electrica = new BicicletaElectrica(marca, modelo, pesoKg, tipoCuadro,
                    tamañoRueda, numeroSerie, idInterno,
                    capacidadBateria, potenciaMotor, velocidadMaxima);
            bicicletas.add(electrica);
            System.out.println("Bicicleta eléctrica registrada con éxito.");
        } else if (tipo == 2) {
            System.out.print("Número de velocidades: ");
            int numeroVelocidades = scanner.nextInt();
            System.out.print("Tipo de frenos: ");
            scanner.nextLine(); // Limpiar buffer
            String tipoFrenos = scanner.nextLine();
            Bicicleta mecanica = new BicicletaMecanica(marca, modelo, pesoKg, tipoCuadro,
                    tamañoRueda, numeroSerie, idInterno,
                    numeroVelocidades, tipoFrenos);
            bicicletas.add(mecanica);
            System.out.println("Bicicleta mecánica registrada con éxito.");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private void consultarEstado() {
        System.out.print("\nIngrese el número de serie de la bicicleta: ");
        String numeroSerie = scanner.nextLine();
        for (Bicicleta bici : bicicletas) {
            if (bici.getNumeroSerie().equals(numeroSerie)) {
                bici.mostrarEstado();
                return;
            }
        }
        System.out.println("Bicicleta no encontrada.");
    }

    private void calcularAutonomia() {
        System.out.print("\nIngrese el número de serie de la bicicleta eléctrica: ");
        String numeroSerie = scanner.nextLine();
        for (Bicicleta bici : bicicletas) {
            if (bici.getNumeroSerie().equals(numeroSerie) && bici instanceof BicicletaElectrica) {
                BicicletaElectrica electrica = (BicicletaElectrica) bici;
                System.out.println("Autonomía restante: " + electrica.calcularAutonomiaRestanteKm() + " km");
                return;
            }
        }
        System.out.println("Bicicleta eléctrica no encontrada.");
    }

    private void descripcionTecnica() {
        System.out.print("\nIngrese el número de serie de la bicicleta mecánica: ");
        String numeroSerie = scanner.nextLine();
        for (Bicicleta bici : bicicletas) {
            if (bici.getNumeroSerie().equals(numeroSerie) && bici instanceof BicicletaMecanica) {
                BicicletaMecanica mecanica = (BicicletaMecanica) bici;
                System.out.println(mecanica.descripcionTecnica());
                return;
            }
        }
        System.out.println("Bicicleta mecánica no encontrada.");
    }

    private void registrarMantenimiento() {
        System.out.print("\nIngrese el número de serie de la bicicleta: ");
        String numeroSerie = scanner.nextLine();
        for (Bicicleta bici : bicicletas) {
            if (bici.getNumeroSerie().equals(numeroSerie)) {
                bici.registrarMantenimiento();
                bici.mostrarEstado();
                return;
            }
        }
        System.out.println("Bicicleta no encontrada.");
    }

    private void mostrarEstadosPolimorfismo() {
        System.out.println("\nEstados de todas las bicicletas:");
        for (Bicicleta bici : bicicletas) {
            bici.mostrarEstado();
            if (bici instanceof BicicletaElectrica) {
                System.out.println("Autonomía: " + ((BicicletaElectrica) bici).calcularAutonomiaRestanteKm() + " km");
            } else if (bici instanceof BicicletaMecanica) {
                System.out.println(((BicicletaMecanica) bici).descripcionTecnica());
            }
        }
    }
}