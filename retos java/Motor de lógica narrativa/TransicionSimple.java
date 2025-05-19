public class TransicionSimple implements TransicionHistoria {
    @Override
    public void avanzarEscena(String decision) {
        System.out.println("Transición basada en decisión: " + decision);
    }
}

