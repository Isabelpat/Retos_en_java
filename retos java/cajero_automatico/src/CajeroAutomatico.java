import java.util.Scanner;

public class CajeroAutomatico {

    public static void main(String[] args) {
        // Inicializamos el saldo del cajero
        double saldo = 1000.0;  // saldo inicial
        Scanner scanner = new Scanner(System.in);  // Objeto para leer la entrada del usuario

        // Menú interactivo
        while (true) {
            // Mostramos el menú con las opciones
            System.out.println("Bienvenido al cajero automático");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();  // Leemos la opción del usuario

            switch (opcion) {
                case 1: // Opción 1: Consultar saldo
                    System.out.println("Tu saldo actual es: " + saldo);
                    break;

                case 2: // Opción 2: Depositar dinero
                    System.out.print("Ingresa el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    saldo += deposito;  // Sumamos el monto depositado al saldo
                    System.out.println("Has depositado " + deposito + ". Tu nuevo saldo es: " + saldo);
                    break;

                case 3: // Opción 3: Retirar dinero
                    System.out.print("Ingresa el monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    if (retiro > saldo) {
                        System.out.println("No tienes suficiente saldo para esta operación.");
                        continue;  // Si no hay saldo suficiente, volvemos al menú sin restar nada
                    }
                    saldo -= retiro;  // Restamos el monto retirado del saldo
                    System.out.println("Has retirado " + retiro + ". Tu nuevo saldo es: " + saldo);
                    break;

                case 4: // Opción 4: Salir
                    System.out.println("Gracias por usar el cajero automático. ¡Hasta luego!");
                    return;  // Terminamos el programa

                default: // Opción inválida
                    System.out.println("Opción no válida. Por favor, selecciona una opción del 1 al 4.");
                    break;
            }
        }
    }
}

