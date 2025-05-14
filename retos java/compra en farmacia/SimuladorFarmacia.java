import java.util.Scanner;

public class SimuladorFarmacia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos
        System.out.print("Nombre del medicamento: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio unitario: ");
        double precio = scanner.nextDouble();

        System.out.print("Cantidad de piezas: ");
        int cantidad = scanner.nextInt();

        // Calcular total sin descuento
        var totalSinDescuento = precio * cantidad;

        // Verificar si aplica descuento
        boolean aplicaDescuento = totalSinDescuento > 500;

        // Calcular descuento usando operador ternario
        double descuento = aplicaDescuento ? totalSinDescuento * 0.15 : 0.0;

        // Calcular total final
        double totalFinal = totalSinDescuento - descuento;

        // Mostrar resumen
        System.out.println("\nResumen:");
        System.out.println("Medicamento: " + nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: $" + precio);
        System.out.println("Total sin descuento: $" + totalSinDescuento);
        System.out.println("¿Aplica descuento?: " + aplicaDescuento);
        System.out.println("Descuento: $" + descuento);
        System.out.println("Total a pagar: $" + totalFinal);
    }
}

