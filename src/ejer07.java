public class ejer07 {
    public static void main(String[] args) {
        /*Un almacén de escritorios hace los siguientes descuentos: si el cliente compra menos de 5 unidades
        se le da un descuento del 10% sobre la compra; si el número de unidades es mayor o igual a cinco
        pero menos de 10 se le otorga un 20% y, si son 10 o más se le da un 40%.*/

        int unidades;
        double precioUnitario, precioTotal, descuento;
        java.util.Scanner teclado = new java.util.Scanner(System.in);
        System.out.println("Ingrese el número de unidades: ");
        unidades = teclado.nextInt();
        System.out.println("Ingrese el precio unitario: ");
        precioUnitario = teclado.nextDouble();
        precioTotal = unidades * precioUnitario;
        if(unidades < 5){
            descuento = precioTotal * 0.10;
        }else if(unidades < 10){
            descuento = precioTotal * 0.20;
        }else{
            descuento = precioTotal * 0.40;
        }
        System.out.println("Precio total: " + precioTotal + "\nDescuento: " + descuento);
        System.out.println("Precio a pagar: " + (precioTotal - descuento));

    }
}
