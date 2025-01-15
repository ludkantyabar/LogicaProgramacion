import java.util.Scanner;

public class ejer03 {
    public static void main(String[] args) {
       /*Construir un programa que pida por pantalla 3 números y luego diga cuál es el mayor,
       el del medio y el menor de los números ingresados
        */
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        int num1 = teclado.nextInt();
        System.out.println("Introduce el segundo numero: ");
        int num2 = teclado.nextInt();
        System.out.println("Introduce el tercer numero: ");
        int num3 = teclado.nextInt();
        if (num1 > num2 && num1 > num3) {
            System.out.println(num1 + " es el numero mayor");
            if (num2 > num3) {
                System.out.println(num2 + " es el numero del medio");
                System.out.println(num3 + " es el numero menor");
            } else {
                System.out.println(num3 + " es el numero del medio");
                System.out.println(num2 + " es el numero menor");
            }
        }
        if (num2 > num1 && num2 > num3) {
            System.out.println(num2 + " es el numero mayor");
            if (num1 > num3) {
                System.out.println(num1 + " es el numero del medio");
                System.out.println(num3 + " es el numero menor");
            } else {
                System.out.println(num3 + " es el numero del medio");
                System.out.println(num1 + " es el numero menor");
            }
        }
        if (num3 > num1 && num3 > num2) {
            System.out.println(num3 + " es el numero mayor");
            if (num1 > num2) {
                System.out.println(num1 + " es el numero del medio");
                System.out.println(num2 + " es el numero menor");
            } else {
                System.out.println(num2 + " es el numero del medio");
                System.out.println(num1 + " es el numero menor ");
            }
        }
    }
}
