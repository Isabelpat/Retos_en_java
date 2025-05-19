import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalizadorDeLogs {
    public static void main(String[] args) {
        String archivoEntrada = "errores.log";
        String archivoError = "registro_fallos.txt";

        int totalLineas = 0;
        int totalErrores = 0;
        int totalWarnings = 0;

        // try-with-resources para leer el archivo
        try (BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                totalLineas++;

                if (linea.contains("ERROR")) {
                    totalErrores++;
                }
                if (linea.contains("WARNING")) {
                    totalWarnings++;
                }
            }

            // Mostrar resumen
            System.out.println("----- Resumen del análisis -----");
            System.out.println("Total de líneas leídas: " + totalLineas);
            System.out.println("Cantidad de errores: " + totalErrores);
            System.out.println("Cantidad de advertencias: " + totalWarnings);

            double porcentajeErrores = (totalErrores + totalWarnings) * 100.0 / totalLineas;
            System.out.printf("Porcentaje de líneas con errores o advertencias: %.2f%%\n", porcentajeErrores);

        } catch (IOException e) {
            // Escribir el error en archivo de registro
            try (FileWriter escritor = new FileWriter(archivoError, true)) {
                escritor.write("Error al procesar el archivo: " + e.getMessage() + "\n");
                System.out.println("Ocurrió un error. Revisa el archivo: " + archivoError);
            } catch (IOException ex) {
                System.out.println("No se pudo escribir en el archivo de registro: " + ex.getMessage());
            }
        }
    }
}
