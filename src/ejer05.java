import java.util.Scanner;

public class ejer05 {
    public static void main(String[] args) {
      /*Construir un programa que pida un año y luego determine si el año es bisiesto o no.
      Tenga en cuenta que los años bisiestos son los números múltiplos de 4,
      pero que no son múltiplos de 100 y si son múltiplos de 100 y múltiplos de 400 sí son bisiestos.*/

        Scanner teclado = new Scanner(System.in);
        int anio;
        System.out.println("Ingrese un año: ");
        anio = teclado.nextInt();
        if(anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0){
            System.out.println("El año " + anio + " es bisiesto");
        }else{
            System.out.println(anio + " no es bisiesto");
        }

    }
}
