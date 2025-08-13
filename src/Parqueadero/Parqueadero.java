package Parqueadero;

import java.util.Scanner;

public class Parqueadero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int TARIFA_AUTO = 15000;
        final int TARIFA_MOTO = 13000;
        final int TARIFA_BICI = 11000;

        System.out.print("Tipo de vehículo (auto, moto, bicicleta): ");
        String tipo = sc.nextLine().trim().toLowerCase();

        System.out.print("Hora de llegada (0 a 23): ");
        int hora = Integer.parseInt(sc.nextLine().trim());

        // Validación  de hora (si está mal, salgo).
        if (hora < 0 || hora > 23) {
            System.out.println("Hora inválida. Debe estar entre 0 y 23.");
            sc.close();
            return;
        }

        double total = 0;
        switch (tipo) {
            case "auto":
                total = TARIFA_AUTO;
                break;
            case "moto":
                total = TARIFA_MOTO;
                break;
            case "bicicleta":
                total = TARIFA_BICI;
                break;
            default:
                System.out.println("Tipo de vehículo no válido.");
                sc.close();
                return; // salgo porque no puedo calcular algo que no se conoce.
        }

        // Si el cliente llegó a las 20:00 o más tarde, aplico 20% de recargo.
        boolean aplicaRecargo = hora >= 20;
        double recargo = 0;
        if (aplicaRecargo) {
            recargo = total * 0.20;
            total += recargo;
        }

        // Muestro el recibo final.
        System.out.println(" RECIBO PARQUEADERO ");
        System.out.println("Vehículo: " + tipo);
        System.out.println("Hora de llegada: " + hora + ":00");
        System.out.printf("Costo base: $%,.2f%n", (aplicaRecargo ? (total - recargo) : total));
        System.out.printf("Recargo nocturno: $%,.2f%n", recargo);
        System.out.printf("TOTAL a pagar: $%,.2f%n", total);

        sc.close();
    }
}
