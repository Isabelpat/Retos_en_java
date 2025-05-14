public class Principal {
    public static void main(String[] args) {
        // Crear pasajero y vuelo
        Pasajero pasajero1 = new Pasajero("Ana Martínez", "X123456");
        Vuelo vuelo = new Vuelo("UX123", "París", "14:30");

        // Reservar asiento con objeto
        if (vuelo.reservarAsiento(pasajero1)) {
            System.out.println("✅ Reserva realizada con éxito.\n");
        }

        // Mostrar itinerario
        System.out.println(vuelo.obtenerItinerario() + "\n");

        // Cancelar reserva
        vuelo.cancelarReserva();
        System.out.println();

        // Mostrar itinerario sin reserva
        System.out.println(vuelo.obtenerItinerario() + "\n");

        // Reservar usando nombre y pasaporte
        vuelo.reservarAsiento("Mario Gonzalez", "Y987654");

        // Mostrar itinerario actualizado
        System.out.println(vuelo.obtenerItinerario());
    }
}

