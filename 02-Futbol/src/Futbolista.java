import java.util.Random;

public class Futbolista extends Thread {

    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (random.nextFloat() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public static void main(String[] args) {
        String[] nomsJugadors = {
            "Piqué", "Vinicius", "Torres", "Ramos",
            "Ronaldo", "Lewan", "Belli", "Arnau",
            "Aspas", "Messi", "MBapé"
        };

        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];

    
        for (int i = 0; i < NUM_JUGADORS; i++) {
            String nom = i < nomsJugadors.length ? nomsJugadors[i] : "Jugador_" + (i + 1);
            jugadors[i] = new Futbolista(nom);
        }

        System.out.println("Inici dels xuts ------------------------");

        for (Futbolista jugador : jugadors) {
            jugador.start();
        }

        for (Futbolista jugador : jugadors) {
            try {
                jugador.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("El fil principal s'ha interromput esperant a " + jugador.getName());
            }
        }

        System.out.println("Fí dels xuts --------------------------");

    
        System.out.println("--- Estadístiques -------");
        for (Futbolista jugador : jugadors) {
            System.out.printf("%-10s -> %2d gols%n", jugador.getName(), jugador.getNgols());
        }
    }
}