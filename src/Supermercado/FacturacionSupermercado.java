package Supermercado;
import java.util.Scanner;

public class FacturacionSupermercado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa el total de la compra (ej: 150000.50): ");
        double totalCompra = Double.parseDouble(sc.nextLine().trim());

        System.out.print("¿Cuántos productos compraste?: ");
        int cantidadProductos = Integer.parseInt(sc.nextLine().trim());

        System.out.print("¿Tienes membresía? (s/n): ");
        String respuestaMembresia = sc.nextLine().trim();
        boolean tieneMembresia = respuestaMembresia.equalsIgnoreCase("s");

        double totalFinal = totalCompra; // esto guarda el total que se va actualizando
        double descuentoAcumulado = 0.0; // esto me sirve para mostrar cuánto se descontó en total

        //  Si tiene membresía, aplico 10%.
        if (tieneMembresia) {
            double d = totalFinal * 0.10;
            totalFinal -= d;
            descuentoAcumulado += d; // acumulo el descuento aplicado
        }

        //  Si compró más de 10 productos, aplico 5% extra (sobre el total actual).
        if (cantidadProductos > 10) {
            double d = totalFinal * 0.05;
            totalFinal -= d;
            descuentoAcumulado += d;
        }

        System.out.println(" RESUMEN COMPRA ");
        System.out.printf("Total antes de descuentos: $%,.2f%n", totalCompra);
        System.out.println("Tiene membresía: " + (tieneMembresia ? "Sí (10%)" : "No"));
        System.out.println("Cantidad de productos: " + cantidadProductos + (cantidadProductos > 10 ? "  (5% extra)" : ""));
        System.out.printf("Descuento total aplicado: $%,.2f%n", descuentoAcumulado);
        System.out.printf("Total a pagar: $%,.2f%n", totalFinal);

        sc.close();
    }
}
