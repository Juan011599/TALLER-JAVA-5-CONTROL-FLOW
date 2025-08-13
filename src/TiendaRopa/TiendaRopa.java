package TiendaRopa;

import java.util.Scanner;

public class TiendaRopa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int PRECIO_CAMISA = 40000;
        final int PRECIO_PANTALON = 80000;
        final int PRECIO_CHAQUETA = 120000;

        System.out.print("Tipo de prenda (camisa, pantalon, chaqueta): ");
        String prenda = sc.nextLine().trim().toLowerCase();
        // trim() → quita espacios antes/después
        // toLowerCase() → convierte a minúsculas para comparar más fácil.

        System.out.print("Cantidad de prendas: ");
        int cantidad = Integer.parseInt(sc.nextLine().trim());

        int precioUnitario;
        switch (prenda) {
            case "camisa":
                precioUnitario = PRECIO_CAMISA;
                break;
            case "pantalon":
                precioUnitario = PRECIO_PANTALON;
                break;
            case "chaqueta":
                precioUnitario = PRECIO_CHAQUETA;
                break;
            default:
                System.out.println("Tipo de prenda no válido.");
                sc.close();
                return;
        }

        double subtotal = precioUnitario * (double) cantidad;

        double descuento = 0.0;
        if (cantidad > 5) {
            // Si compra más de 5 unidades, 15% de descuento.
            descuento = subtotal * 0.15;
        }

        double total = subtotal - descuento;

        System.out.println("RESUMEN COMPRA ROPA");
        System.out.println("Prenda: " + prenda);
        System.out.println("Cantidad: " + cantidad);
        System.out.printf("Precio unitario: $%,.2f%n", (double) precioUnitario);
        System.out.printf("Subtotal: $%,.2f%n", subtotal);
        System.out.printf("Descuento: $%,.2f%n", descuento);
        System.out.printf("TOTAL a pagar: $%,.2f%n", total);

        sc.close();
    }
}
