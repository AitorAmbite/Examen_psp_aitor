import java.util.concurrent.Semaphore;

public class Pais extends Thread {
    // constantes
    private static final int MAXCORREDORES = 1;
    private static final int NUMEROGRUPO = 4;

    // variables
    public int acabados = 0;
    public static Semaphore corredor_dentro = new Semaphore(MAXCORREDORES, true);

    // esto se podria hacer con un join, asi espero hasta que el siguiente corredor haya acabado
    // añadir variable para poder contar cuantos han acabado
    @Override
    public void run() {
        for (int i = 0; i < NUMEROGRUPO; i++) {
            Corredor corredor = new Corredor(this);
            corredor.setName("Corredor " + (i+1));
            corredor.start();

        }
    }

    public void siguiente(Corredor corredor) {
        try {
            corredor_dentro.acquire();
            System.out.println(corredor.getName() + " del pais " + this.getName() + " entro");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void anteriorAcaba(Corredor corredor) {
        acabados++;
        System.out.println(corredor.getName() + " del pais" + this.getName() + " he acabado la primera parte");
        corredor_dentro.release();
        if(acabados >= 4){
            System.out.println("han acabado todos los corredores de "+this.getName());
        }
    }
}
