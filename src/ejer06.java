public class ejer06 {
    public static void main(String[] args) {
        /*Elaborar un programa que entre el nombre de un empleado, su salario básico por hora y el número
        de horas trabajadas en el mes; escriba su nombre y salario mensual si éste es mayor del salario
        mínimo, de lo contrario escriba sólo el nombre.*/

        String nombre;
        double salarioBasico, horasTrabajadas, salarioMensual, salarioMinimo = 877803;
        java.util.Scanner teclado = new java.util.Scanner(System.in);
        System.out.println("Ingrese el nombre del empleado: ");
        nombre = teclado.nextLine();
        System.out.println("Ingrese el salario básico por hora: ");
        salarioBasico = teclado.nextDouble();
        System.out.println("Ingrese el número de horas trabajadas en el mes: ");
        horasTrabajadas = teclado.nextDouble();
        System.out.println("Ingrese el salario mínimo: ");
        salarioMinimo = teclado.nextDouble();
        salarioMensual = salarioBasico * horasTrabajadas;
        if(salarioMensual > salarioMinimo){
            System.out.println("Nombre: " + nombre + "\nSalario mensual: " + salarioMensual);
        }else{
            System.out.println("Nombre: " + nombre);
        }
    }
}
