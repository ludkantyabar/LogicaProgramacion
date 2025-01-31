import java.util.Scanner;

public class ejer11 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        // ingresando datos
        System.out.println("******DATOS DE ENTRADA*******");
        System.out.println("Ruta [1] [2] [3] [4]: ");
        int ruta = teclado.nextInt();
        System.out.println("Numero de Viajes: ");
        int viajes = teclado.nextInt();
        System.out.println("Numero de Pasajeros: ");
        int pasajeros = teclado.nextInt();
        System.out.println("Numero de Paquetes de menos de 10Kg: ");
        double paquetesMenos10 = teclado.nextDouble();
        System.out.println("Numero de Paquetes entre 10Kg y menos de 20Kg: ");
        double paquetesEntre10y20 = teclado.nextDouble();
        System.out.println("Numero de Paquetes de 20Kg o mas: ");
        double paquetesMas20 = teclado.nextDouble();

        // calculos
        double comision = calcularComisiones(ruta, pasajeros);
        double totalPaquetes = calcularPaquetes(ruta, paquetesMenos10, paquetesEntre10y20, paquetesMas20);
        double ingresosConductor = comision + totalPaquetes;
        double[] pagos = calcularPagos(ingresosConductor);
        double consumoGasolina = calcularConsumoGasolina(ruta, pasajeros, paquetesMenos10, paquetesEntre10y20, paquetesMas20);
        double subsidioCombustible = calcularSubsidioCombustible(consumoGasolina);

        // mostrar resultados
        System.out.println("******RESULTADOS*******");
        System.out.println("Ingresos por pasajeros: " + comision);
        System.out.println("Ingresos por paquetes: " + totalPaquetes);
        System.out.println("Ingresos totales: " + ingresosConductor);
        System.out.println("Pago ayudante: " + pagos[0]);
        System.out.println("Pago seguro: " + pagos[1]);
        System.out.println("Consumo de gasolina: " + consumoGasolina + " galones");
        System.out.println("Subsidio de combustible: $" + subsidioCombustible);
        System.out.println("Total deducciones: " + (pagos[0] + pagos[1] + subsidioCombustible));
        System.out.println("Total a liquidar: " + (ingresosConductor - pagos[0] - pagos[1] - subsidioCombustible));
    }

    public static double calcularComisiones(int ruta, int pasajeros) {
        double baseComision = switch (ruta) {
            case 1 -> 500000;
            case 2 -> 600000;
            case 3 -> 800000;
            case 4 -> 1000000;
            default -> 0;
        };

        if (pasajeros < 50) return 0;
        if (pasajeros <= 100) return baseComision * switch (ruta) {
            case 1 -> 0.05;
            case 2 -> 0.07;
            case 3 -> 0.10;
            case 4 -> 0.125;
            default -> 0;
        };
        if (pasajeros <= 150) return baseComision * switch (ruta) {
            case 1 -> 0.06;
            case 2 -> 0.08;
            case 3 -> 0.13;
            case 4 -> 0.15;
            default -> 0;
        };
        if (pasajeros <= 200) return baseComision * switch (ruta) {
            case 1 -> 0.07;
            case 2 -> 0.09;
            case 3 -> 0.15;
            case 4 -> 0.17;
            default -> 0;
        };

        int extraPasajeros = pasajeros - 200;
        return baseComision * switch (ruta) {
            case 1 -> 0.07;
            case 2 -> 0.09;
            case 3 -> 0.15;
            case 4 -> 0.17;
            default -> 0;
        } + extraPasajeros * switch (ruta) {
            case 1 -> 50;
            case 2 -> 60;
            case 3 -> 100;
            case 4 -> 150;
            default -> 0;
        };
    }

    public static double calcularPaquetes(int ruta, double paquetesMenos10, double paquetesEntre10y20, double paquetesMas20) {
        double totalPaquetes = 0;
        double[] tarifasMenos10 = {100, 120, 150, 160};
        double[] tarifasEntre10y20 = {120, 140, 160, 180};
        double[] tarifasMas20 = {170, 210, 250, 300};

        if (ruta == 1 || ruta == 2) {
            totalPaquetes += calcularTarifa(paquetesMenos10, tarifasMenos10);
            totalPaquetes += calcularTarifa(paquetesEntre10y20 + paquetesMas20, tarifasEntre10y20);
        } else {
            totalPaquetes += calcularTarifa(paquetesMenos10, tarifasMenos10);
            totalPaquetes += calcularTarifa(paquetesEntre10y20, tarifasEntre10y20);
            totalPaquetes += calcularTarifa(paquetesMas20, tarifasMas20);
        }
        return totalPaquetes;
    }

    private static double calcularTarifa(double cantidad, double[] tarifas) {
        if (cantidad < 50) return tarifas[0] * cantidad;
        if (cantidad <= 100) return tarifas[1] * cantidad;
        if (cantidad <= 130) return tarifas[2] * cantidad;
        return tarifas[3] * cantidad;
    }

    public static double[] calcularPagos(double ingresosConductor) {
        double pagoAyudante, pagoSeguro;

        if (ingresosConductor < 1000000) {
            pagoAyudante = ingresosConductor * 0.05;
            pagoSeguro = ingresosConductor * 0.03;
        } else if (ingresosConductor < 2000000) {
            pagoAyudante = ingresosConductor * 0.08;
            pagoSeguro = ingresosConductor * 0.04;
        } else if (ingresosConductor < 4000000) {
            pagoAyudante = ingresosConductor * 0.10;
            pagoSeguro = ingresosConductor * 0.06;
        } else {
            pagoAyudante = ingresosConductor * 0.13;
            pagoSeguro = ingresosConductor * 0.09;
        }

        return new double[]{pagoAyudante, pagoSeguro};
    }

    public static double calcularConsumoGasolina(int ruta, int pasajeros, double paquetesMenos10, double paquetesEntre10y20, double paquetesMas20) {
        double[] kilometrosRuta = {150, 167, 184, 203};
        double kmPorGalon = 39;
        double pesoPasajeros = pasajeros * 60;
        double pesoPaquetes = (paquetesMenos10 * 10) + (paquetesEntre10y20 * 15) + (paquetesMas20 * 20);
        double pesoTotal = pesoPasajeros + pesoPaquetes;
        double recargoPeso = 0;

        if (pesoTotal > 5000 && pesoTotal <= 10000) {
            recargoPeso = 0.10;
        } else if (pesoTotal > 10000) {
            recargoPeso = 0.25;
        }

        double kmTotales = kilometrosRuta[ruta - 1] * (1 + recargoPeso);
        return kmTotales / kmPorGalon;
    }

    public static double calcularSubsidioCombustible(double consumoGasolina) {
        double valorGalon = 8860;
        double costoCombustible = consumoGasolina * valorGalon;
        return costoCombustible * 0.25;
    }
}