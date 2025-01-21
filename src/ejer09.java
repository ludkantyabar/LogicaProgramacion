import java.util.Scanner;

public class ejer09 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //ingresando datos
        System.out.println("Peso de la Mercaderia: ");
        double peso = teclado.nextDouble();

        double tarifa = calcularTarifa(peso);
        System.out.println("La tarifa a pagar es: " + tarifa);

        double descuento = calcularDescuento(tarifa);
        System.out.println("El descuento es: " + descuento);

        double promocion = calcularPromocion(tarifa, "lunes", "tarjeta");
        System.out.println("El valor a pagar es: " + (tarifa - descuento - promocion));
    }

    /*tarifas:
    Si el peso de la mercancía es inferior a 100 kg, la tarifa para el envío de ésta es de 20.000 pesos.
    Si el peso de la mercancía está entre 100 y 150 kg, la tarifa para el envío de ésta es de 25.000 pesos.
    Si el peso de la mercancía es superior a 150 kg y menor o igual a 200 kg, la tarifa para el envío de ésta es de 30.000 pesos.
    Si el peso de la mercancía es superior a 200 kg, la tarifa es de 35.000 pesos y además por cada 10 kg adicionales se paga 2.000 pesos.
     */
    public static double calcularTarifa(double peso) {
        double tarifa = 0;
        if (peso < 100) {
            tarifa = 20000;
        } else if (peso >= 100 && peso <= 150) {
            tarifa = 25000;
        } else if (peso > 150 && peso <= 200) {
            tarifa = 30000;
        } else {
            tarifa = 35000;
            tarifa += (peso - 200) / 10 * 2000;
        }
        return tarifa;
    }

    /* Descuentos:
     Si el valor de la mercancía está entre 300.000 y 600.000 pesos se hace un descuento del 10% sobre el valor del envío.
     Si el valor de la mercancía es superior a 600.000 pero menor o igual a 1.000.000 de pesos se hace un descuento del 20% sobre el valor del envío.
     Si el valor de la mercancía es superior a 1.000.000 se hace un descuento del 30% sobre el valor del envío.
     */
    public static double calcularDescuento(double valor) {
        double descuento = 0;
        if (valor >= 300000 && valor <= 600000) {
            descuento = valor * 0.10;
        } else if (valor > 600000 && valor <= 1000000) {
            descuento = valor * 0.20;
        } else if (valor > 1000000) {
            descuento = valor * 0.30;
        }
        return descuento;
    }

    /*Promociones:
    Si es día de promoción (lunes) y paga con tarjeta propia del almacén, sólo paga el 50% del costo de envío.
    Si paga en efectivo y el valor de la mercancía es superior a 1.000.000, sólo paga el 60% del costo de envío.
     */
    public static double calcularPromocion(double valor, String dia, String formaPago) {
        double promocion = 0;
        if (dia.equals("lunes") && formaPago.equals("tarjeta")) {
            promocion = valor * 0.50;
        } else if (formaPago.equals("efectivo") && valor > 1000000) {
            promocion = valor * 0.60;
        }
        return promocion;


    }
}