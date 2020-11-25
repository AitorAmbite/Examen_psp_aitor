import java.util.concurrent.Semaphore;

public class Pais extends Thread {
    // constantes
    private static final int MAXCORREDORES = 1;
    private static final int NUMEROGRUPO = 4;

    // variables
    public int acabados = 0;
    public Semaphore corredorDentro = new Semaphore(MAXCORREDORES, true);

    Principal callback;

    public Pais(Principal callback) {
        this.callback = callback;
    }

    // esto se podria hacer con un join, asi espero hasta que el siguiente corredor haya acabado
    // añadir variable para poder contar cuantos han acabado
    @Override
    public void run() {
        for (int i = 0; i < NUMEROGRUPO; i++) {

            Corredor corredor = new Corredor(this);
            corredor.setName("Corredor " + (i + 1));
            corredor.start();

        }
    }

    public void siguiente(Corredor corredor, int tiempoCarrera) {
        try {
            corredorDentro.acquire();

            System.out.println(corredor.getName() + " del pais " + this.getName() + " esta corriendo ");
            sleep(tiempoCarrera);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void anteriorAcaba(Corredor corredor) {
        acabados++;
        corredorDentro.release();
        System.out.println(corredor.getName() + " del pais" + this.getName() + " he acabado la primera parte");

        if (acabados >= 4) {
            System.out.println("han acabado todos los corredores de " + this.getName());
            callback.setPaisGanador(this);
            callback.incrementarPaisesTerminados();
        }
    }


}
