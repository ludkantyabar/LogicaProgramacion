import java.util.Scanner;

public class ejer08 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // pidiendo datos de entrada
        System.out.println("Numero de Creditos: ");
        int creditos = teclado.nextInt();
        System.out.println("Ingrese el valor del credito: ");
        int valorCredito = teclado.nextInt();
        System.out.println("Estrato del Estudiante:");
        int estrato = teclado.nextInt();

        int matricula = calculoMatricula(creditos, valorCredito, estrato);
        System.out.println("El valor a pagar es: " + matricula);

        int subsidio = calculoSubsidio(estrato);
        System.out.println("El subsidio es: " + subsidio);
    }

    // Calculando el valor a pagar
    public static int calculoMatricula(int creditos, int valorCredito, int estrato) {
        int valorMatricula = creditos * valorCredito;
        if (estrato == 1) {
            valorMatricula = (int) (valorMatricula * 0.80);
        } else if (estrato == 2) {
            valorMatricula = (int) (valorMatricula * 0.50);
        } else if (estrato == 3) {
            valorMatricula = (int) (valorMatricula * 0.30);
        }
        return valorMatricula;
    }
    //Además los estratos 1 y 2 reciben subsidio de alimentación y transporte de la siguiente manera
    //Para el estrato 1, el subsidio de alimentación y transporte es igual a $200.000.
    //Para el estrato 2, el subsidio de alimentación y transporte es igual a $100.000.
    //Para el estrato 3, no hay subsidio de alimentación y transporte.

    public static int calculoSubsidio(int estrato) {
        int subsidio = 0;
        if (estrato == 1) {
            subsidio = 200000;
        } else if (estrato == 2) {
            subsidio = 100000;
        }
        return subsidio;
    }
}


