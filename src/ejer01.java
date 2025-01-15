import java.util.Scanner;

public class ejer01 {
    public static void main(String[] args) {
        //Construir un programa que pida un numero y luego diga si este numero es par o impar
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int num = teclado.nextInt();
        if(num%2==0){
            System.out.println(num + " es numero par");
        }else{
            System.out.println(num + " es numero impar");
        }
    }
}
