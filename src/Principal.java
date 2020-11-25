public class Principal{
    private static final int PAISES = 9;

    // con esto obtengo cuantos paises han terminado
    public int paisesTerminados = 0;

    public static Pais paisGanador;

    public Principal() {
        for(int i = 0;i<PAISES;i++){
            Pais pais = new Pais(this);
            pais.setName("pais "+(i+1));
            pais.start();
        }
    }

    public int getPaisesTerminados() {
        return paisesTerminados;
    }

    public Pais getPaisGanador() {
        return paisGanador;
    }

    public synchronized void setPaisGanador(Pais ganador) {
        if(Principal.paisGanador == null){
            Principal.paisGanador = ganador;
            // System.out.println("entro aqui en pais ganador"); <- print para probar si entraba
        }
    }
    // aqui aprovecho que voy sumando siempre 1 cada vez que el pais termina para preguntar si han acabado todos
    //y de paso pues muestro cual es el ganador

    public void incrementarPaisesTerminados(){
        this.paisesTerminados++;
        if(paisesTerminados == 9){
            System.out.println("Ha ganado el "+paisGanador.getName()+" demosle la enhorabuena ");
        }
    }
}
