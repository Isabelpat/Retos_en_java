import java.util.Scanner;

public class MainNarrativa {

    private final TransicionHistoria transicion;
    private final GestorDialogo gestorDialogo;
    private final LogicaDecision logicaDecision;

    public MainNarrativa(TransicionHistoria transicion, GestorDialogo gestorDialogo, LogicaDecision logicaDecision) {
        this.transicion = transicion;
        this.gestorDialogo = gestorDialogo;
        this.logicaDecision = logicaDecision;
    }

    public void iniciarEscena() {
        gestorDialogo.mostrarDialogo("¿Quieres abrir la puerta? (sí/no)");

        Scanner scanner = new Scanner(System.in);
        String accion = scanner.nextLine();

        String decision = logicaDecision.decidir(accion);
        transicion.avanzarEscena(decision);

        if ("aceptar".equals(decision)) {
            gestorDialogo.mostrarDialogo("Has entrado en la habitación misteriosa.");
        } else {
            gestorDialogo.mostrarDialogo("Decidiste no entrar y sigues explorando el pasillo.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TransicionHistoria transicion = new TransicionSimple();
        GestorDialogo gestorDialogo = new DialogoTexto();
        LogicaDecision logicaDecision = new DecisionBinaria();

        MainNarrativa narrativa = new MainNarrativa(transicion, gestorDialogo, logicaDecision);
        narrativa.iniciarEscena();
    }
}

