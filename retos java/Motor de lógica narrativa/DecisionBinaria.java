public class DecisionBinaria implements LogicaDecision {
    @Override
    public String decidir(String accionJugador) {
        if ("sí".equalsIgnoreCase(accionJugador)) {
            return "aceptar";
        } else {
            return "rechazar";
        }
    }
}

