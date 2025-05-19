import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RegistroSimulacion {

    private static final Path RUTA_CONFIG = Paths.get("config/parametros.txt");

    public static void main(String[] args) {
        String parametros = "Tiempo de ciclo: 55.8 segundos\n" +
                "Velocidad de línea: 1.2 m/s\n" +
                "Número de estaciones: 8";

        try {
            guardarParametros(parametros);
            if (Files.exists(RUTA_CONFIG)) {
                System.out.println("Archivo creado exitosamente.");
                leerParametros();
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void guardarParametros(String contenido) throws IOException {
        // Crear carpeta config si no existe
        Path carpetaConfig = RUTA_CONFIG.getParent();
        if (!Files.exists(carpetaConfig)) {
            Files.createDirectories(carpetaConfig);
        }

        // Escribir el archivo con el contenido
        Files.writeString(RUTA_CONFIG, contenido);
    }

    private static void leerParametros() throws IOException {
        String contenidoLeido = Files.readString(RUTA_CONFIG);
        System.out.println("Contenido del archivo parametros.txt:");
        System.out.println(contenidoLeido);
    }
}


