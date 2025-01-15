import java.util.Scanner;

public class ejer04 {
    public static void main(String[] args) {
        //construir un programa que pida dos numeros y ver si el segundo numero es multiplo del primero
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        int num1 = teclado.nextInt();
        System.out.println("Introduce el segundo numero: ");
        int num2 = teclado.nextInt();
        if(num1%num2==0){
            System.out.println(num2 + " es multiplo de  " + num1);
        }else{
            System.out.println(num2 + " no es multiplo de  " + num1);
        }

    }
}
