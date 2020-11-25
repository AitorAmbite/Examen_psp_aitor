public class Curar {
    public synchronized void curar() {
        try {
            Thread.sleep(5000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

    public synchronized void esperarSerCurado(Corredor corredor) {
        try {
            // espero a que la ambulancia me notifique. porque la ambulancia esta ahi dandolo todo 24/7
            wait();
            System.out.println(corredor.getName()+" me han curado doy paso al siguiente");
            corredor.miPais.siguiente(corredor);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
