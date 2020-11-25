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

        // calculo tiempo que va a tardar funciona, lo unico es que parece que lo hacen todos a la vez
        // porque suele haber muy poca diferencia entre ellos al ser 1 a 5 segundos.
       //  tiempoCarrera = generarAleatorios.nextInt(4000)+15000; <- para ver que se hacia correctamente los sleep etc si no era demasiado rapido.

        tiempoCarrera = generarAleatorios.nextInt(4000)+1000;

        // Entro a la "pista" a competir
        miPais.siguiente(this,tiempoCarrera);

        //esta puesto en 100 siempre porque no conseguia la funcionalidad de la ambulancia.
        if(generarAleatorios.nextInt(100) <= 100 ){
            // digo que he pasado el obstaculo y permito que entre otro
            // System.out.println("he pasado el obstaculo"); <- esto era para informacion mia.
            miPais.anteriorAcaba(this);

        }else{
            // no me ha dado tiempo :(
            System.out.println("me hice dañito que alguien me salve");
            miPais.anteriorAcaba(this);
        }

    }
}
