package Veterinaria;

import java.util.Scanner;

public class ClasificacionVeterinaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pido el tipo de animal para decidir el veterinario especializado.
        System.out.print("Tipo de animal (perro, gato, ave, otro): ");
        String tipo = sc.nextLine().trim().toLowerCase();

        //  Pido la edad para saber si requiere vacunación adicional (solo perros y gatos > 5 años).
        System.out.print("Edad del animal (en años, puede ser decimal): ");
        double edad = Double.parseDouble(sc.nextLine().trim());

        // Defino el veterinario según el tipo. Esto me sirve para asignar la especialidad.
        String veterinarioAsignado;
        switch (tipo) {
            case "perro":
                veterinarioAsignado = "Dr. Canino";
                break;
            case "gato":
                veterinarioAsignado = "Dra. Felina";
                break;
            case "ave":
                veterinarioAsignado = "Dr. Aves";
                break;
            default:
                veterinarioAsignado = "Dra. General";
        }

        // Regla de vacunación: perros o gatos con más de 5 años.
        boolean recomendarVacuna = (tipo.equals("perro") || tipo.equals("gato")) && (edad > 5);

        // Muestro la asignación y la recomendación.
        System.out.println(" ASIGNACIÓN VETERINARIA ");
        System.out.println("Tipo de animal: " + tipo);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Veterinario asignado: " + veterinarioAsignado);
        if (recomendarVacuna) {
            System.out.println("Recomendación: Vacunación adicional por edad (>5 años).");
        } else {
            System.out.println("Recomendación: No requiere vacunación adicional por edad.");
        }

        sc.close();
    }
}
