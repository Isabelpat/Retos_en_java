import java.util.Objects;

public class Factura {
    private String folio;
    private String cliente;
    private double total;

    // Constructor con parámetros
    public Factura(String folio, String cliente, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    // Método toString con el formato solicitado
    @Override
    public String toString() {
        return " Factura [folio=" + folio + ", cliente=" + cliente + ", total=$" + total + "]";
    }

    // Método equals: solo compara el folio
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Factura factura = (Factura) obj;
        return Objects.equals(folio, factura.folio);
    }

    // Método hashCode basado solo en el folio
    @Override
    public int hashCode() {
        return Objects.hash(folio);
    }
}

