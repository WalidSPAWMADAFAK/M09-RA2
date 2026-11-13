public class Fil extends Thread {
    private int delay;

    public Fil(String nom, int prioritat, int delay) {
        super(nom);
        this.setPriority(prioritat);
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(getName() + " " + i);

            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                int comptador = 0;
                while (comptador < 1000) {
                    comptador++;
                }
            }
        }
        System.out.println("Termina el fil " + getName());
    }
}