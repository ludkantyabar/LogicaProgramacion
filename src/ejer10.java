import java.sql.SQLOutput;
import java.util.Scanner;

public class ejer10 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //ingresar datos
        System.out.println("Costo de Compra: ");
        double cc = teclado.nextDouble();
        System.out.println("Tipo de producto [P]erecedero o [N]o Perecedero: ");
        char tp = teclado.next().charAt(0);
        System.out.println("Tipo de Conservacion [F]rio o [A]mbiente: ");
        char tc = teclado.next().charAt(0);
        System.out.println("Periodo de Conservacion (Dias): ");
        int pc = teclado.nextInt();
        System.out.println("Periodo de Almacenamiento (Dias): ");
        int pa = teclado.nextInt();
        System.out.println("Volumen del Producto (litros): ");
        double vol = teclado.nextDouble();
        System.out.println("Medio de Almacenamiento [N]evera, [C]ongelador, [E]stanteria, [G]uacal: ");
        char ma = teclado.next().charAt(0);

        //calculos
        int ca = calcularCostoAlmacenamiento(cc, tp, tc, pc, pa, vol, ma);
        double pdp = calcularPorcentajeDepreciacion(pa);
        int ce = calcularCostoDeExhibicion(tp + "", tc + "", ma + "", ca);
        /*El valor del producto VR_P, se calcula de la suma del Costo de compra CC,
        costo de almacenamiento CA y costo de exhibición CE, multiplicados por el porcentaje de depreciación del producto PDP.*/
        double vr_p = (cc + ca + ce) * pdp;
        /*
        El valor de venta VR_V es igual a:
        El 20% más del valor del producto VR_P, cuando el tipo de producto TP corresponde a un artículo no perecedero, o El
        40% más del valor del producto VR_P, cuando el tipo de producto TP corresponde a un artículo perecedero.
         */
        double vr_v = 0;
        if (tp == 'N') {
            vr_v = vr_p * 1.20;
        } else if (tp == 'P') {
            vr_v = vr_p * 1.40;
        }

        //mostrar resultados
        System.out.println("*****CALCULOS*****");
        System.out.println("Costo de Almacenamiento: " + ca);
        System.out.println("Porcentaje de Depreciacion: " + pdp);
        System.out.println("Costo de Exhibicion: " + ce);
        System.out.println("Valor del Producto: " + vr_p);
        System.out.println("Valor de Venta: " + vr_v);


    }
    //calcular costo de almacenamiento
    /*Para los productos perecederos:
    Costo de almacenamiento CA es igual al 5% del costo de compra CC cuando se trata de un producto de tipo de
    conservación TC en frio y con un período de conservación PC inferior a 10 días.
    Costo de almacenamiento CA es igual al 10% del costo de compra CC cuando se trata de un producto de tipo de
    conservación TC en frio y con un período de conservación PC superior o igual 10 días.
    Costo de almacenamiento CA es igual al 3% del costo de compra CC cuando se trata de un producto de tipo de
    conservación TC en ambiente y con un período de almacenamiento PA en inferior a 20 días.
    Costo de almacenamiento CA es igual al 10% del costo de compra CC cuando se trata de un producto de tipo de
    conservación TC en ambiente y con un período de almacenamiento PA superior a 20 días.
    Costo de almacenamiento CA es igual al 5% del costo de compra CC cuando se trata de un producto de tipo de
    conservación TC en ambiente y con un período de almacenamiento PA exacto a 20 días.
    Para los productos no perecederos
    El costo de almacenamiento CA se calcula a través de su volumen en litros VOL así:
    Costo de almacenamiento CA es igual al 10% del costo de compra CC cuando el volumen VOL es mayor o igual a los
    50 litros,
    Costo de almacenamiento CA es igual al 20% del costo de compra CC cuando el volumen VOL es menor a los 50
    litros.*/
    public static int calcularCostoAlmacenamiento(double cc, char tp, char tc, int pc, int pa, double vol, char ma) {
        double ca = 0;
        if (tp == 'P') {
            if (tc == 'F' && pc < 10) {
                ca = cc * 0.05;
            } else if (tc == 'F' && pc >= 10) {
                ca = cc * 0.10;
            } else if (tc == 'A' && pa < 20) {
                ca = cc * 0.03;
            } else if (tc == 'A' && pa > 20) {
                ca = cc * 0.10;
            } else if (tc == 'A' && pa == 20) {
                ca = cc * 0.05;
            }
        } else if (tp == 'N') {
            if (vol >= 50) {
                ca = cc * 0.10;
            } else {
                ca = cc * 0.20;
            }
        }
        return (int) ca;
    }

    /*Función Porcentaje Depreciación del Producto. En este se debe calcular el porcentaje de depreciación del producto
    PDP, para ser devueltos al programa principal.
    El porcentaje de depreciación del producto PDP es igual al 0.95 cuando el período de almacenamiento PA es inferior a
    30 días, o
    El porcentaje de depreciación del producto PDP es igual al 0.85 cuando el período de almacenamiento PA es superior o
    igual a 30 días*/
    public static double calcularPorcentajeDepreciacion(int pa) {
        double pdp = 0;
        if (pa < 30) {
            pdp = 0.95;
        } else {
            pdp = 0.85;
        }
        return pdp;
    }
    /*
    Función Costo de exhibición: El costo de exhibición CE también se diferencia entre artículos perecederos y no perecederos,
calculándose así:
Para los productos perecederos:
Aquellos artículos perecederos cuyo tipo de conservación TC es frio, y el medio de almacenamiento MA es nevera, el
costo de exhibición CE corresponde al doble del costo de almacenamiento CA.
Aquellos artículos perecederos cuyo tipo de conservación TC es frio, y el medio de almacenamiento MA es
congelador, el costo de exhibición CE corresponde al del costo de almacenamiento CA.
Para los productos no perecederos:
El costo de exhibición CE corresponde al 5% del costo de almacenamiento CA, para los productos cuyo medio de
almacenamiento MA es en estantería
El costo de exhibición CE corresponde al 7% del costo de almacenamiento CA, para los productos cuyo medio de
almacenamiento MA es en guacal
     */
    public static int calcularCostoDeExhibicion (String tp, String tc, String ma, double ca){
        double ce = 0;
        if (tp.equals("P")) {
            if (tc.equals("F") && ma.equals("N")) {
                ce = ca * 2;
            } else if (tc.equals("F") && ma.equals("C")) {
                ce = ca;
            }
        } else if (tp.equals("N")) {
            if (ma.equals("E")) {
                ce = ca * 0.05;
            } else if (ma.equals("G")) {
                ce = ca * 0.07;
            }
        }
        return (int) ce;
    }

}
