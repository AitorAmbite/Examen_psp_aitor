import java.util.Random;

public class Corredor extends Thread{
    public String pais;

    @Override
    public void run() {
        Random generarAleatorios = new Random();
        try {
            sleep(generarAleatorios.nextInt(4000)+1000);

            //esbozo primario de como calcular si pasa el obstaculo o no

            if(generarAleatorios.nextInt(100) <= 90 ){
                
            }else{
                System.out.println("me hice dañito que alguien me salve");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
