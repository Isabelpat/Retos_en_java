interface Autenticable {
    boolean autenticar();
}

abstract class MetodoPago {
    protected double monto;

    public MetodoPago(double monto) {
        this.monto = monto;
    }

    public abstract void procesarPago();

    public void mostrarResumen() {
        System.out.println("📄 Tipo: " + this.getClass().getSimpleName() + " - Monto: $" + monto);
    }
}

class PagoEfectivo extends MetodoPago implements Autenticable {
    public PagoEfectivo(double monto) {
        super(monto);
    }

    @Override
    public boolean autenticar() {
        return true; // siempre válido
    }

    @Override
    public void procesarPago() {
        System.out.println("💵 Procesando pago en efectivo por $" + monto);
    }
}

class PagoTarjeta extends MetodoPago implements Autenticable {
    private double fondosDisponibles;

    public PagoTarjeta(double monto, double fondosDisponibles) {
        super(monto);
        this.fondosDisponibles = fondosDisponibles;
    }

    @Override
    public boolean autenticar() {
        return fondosDisponibles >= monto;
    }

    @Override
    public void procesarPago() {
        System.out.println("💳 Procesando pago con tarjeta por $" + monto);
    }
}

class PagoTransferencia extends MetodoPago implements Autenticable {
    private boolean bancoDisponible;

    public PagoTransferencia(double monto, boolean bancoDisponible) {
        super(monto);
        this.bancoDisponible = bancoDisponible;
    }

    @Override
    public boolean autenticar() {
        return bancoDisponible;
    }

    @Override
    public void procesarPago() {
        System.out.println("🏦 Procesando transferencia bancaria por $" + monto);
    }
}

public class CajaRegistradora {
    public static void main(String[] args) {
        MetodoPago[] pagos = {
                new PagoEfectivo(150.0),
                new PagoTarjeta(320.0, 500.0),
                new PagoTransferencia(200.0, false) // este fallará
        };

        for (MetodoPago pago : pagos) {
            if (((Autenticable) pago).autenticar()) {
                System.out.println("✅ Autenticación exitosa.");
                pago.procesarPago();
                pago.mostrarResumen();
            } else {
                System.out.println("❌ Fallo de autenticación. " + pago.getClass().getSimpleName() + " no válido.");
            }
            System.out.println(); // separación entre pagos
        }
    }
}
