public class ejer12 {
    public static void main(String[] args) {
        java.util.Scanner teclado = new java.util.Scanner(System.in);
        System.out.println("Ingrese el valor de N: ");
        int N = teclado.nextInt();
        int sumatoria = 0;
        int columnas = 10; // Número de columnas

        for (int i = 1; i <= N; i++) {
            System.out.print(i + "\t");
            sumatoria += i;
            if (i % columnas == 0) {
                System.out.println(); // Salto de línea después de cada 10 números
            }
        }
        System.out.println("\nLa sumatoria es: " + sumatoria);
        System.out.println("El promedio es: " + (double) sumatoria / N);
    }
}