public class Principal {
    private static final int PAISES = 9;
    public int paisesTerminados = 0;
    public Principal() {
        for(int i = 0;i<PAISES;i++){
            Pais pais = new Pais();
            pais.setName("pais "+(i+1));
            pais.start();
        }

    }

}
