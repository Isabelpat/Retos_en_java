import java.util.Optional;

public class Factura {
    // Atributos privados
    private double monto;
    private String descripcion;
    private Optional<String> rfc;

    // Constructor
    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.rfc = (rfc != null) ? Optional.of(rfc) : Optional.empty();
    }

    // Método público para obtener resumen
    public String getResumen() {
        StringBuilder resumen = new StringBuilder();
        resumen.append("Factura generada:\n");
        resumen.append("Descripción: ").append(descripcion).append("\n");
        resumen.append("Monto: $").append(monto).append("\n");
        resumen.append("RFC: ").append(rfc.orElse("[No proporcionado]"));
        return resumen.toString();
    }
}
