import java.util.Random;

public class Corredor extends Thread{
    public Pais miPais;

    public Corredor(Pais miPais) {
        this.miPais = miPais;
    }

    @Override
    public void run() {
        Random generarAleatorios = new Random();
        int tiempoCarrera = 0;
        try {
            miPais.siguiente(this);
            // calculo tiempo que va a tardar
            tiempoCarrera = generarAleatorios.nextInt(4000)+1000;
            sleep(tiempoCarrera);

            //esbozo primario de como calcular si pasa el obstaculo o no
            // por pruebas siepre pasan el obstaculo.


            if(generarAleatorios.nextInt(100) <= 90 ){
                // digo que he pasado el obstaculo y permito que entre otro
                System.out.println("he pasado el obstaculo");
                miPais.anteriorAcaba(this);
            }else{
                System.out.println("me hice dañito que alguien me salve");
                wait();
                miPais.anteriorAcaba(this);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
