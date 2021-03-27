package entities;

public enum Moeda {
    DEZ("0.10", 0.10),
    VINTECINCO("0.25", 0.25),
    CINQUENTA("0.50", 0.50),
    UM("1.00", 1.00);

    private final String moeda;
    private double valor;

    /*
        CONSTRUTOR
    */
    Moeda(String moeda, double valor){
        this.moeda = moeda;
        this.valor = 0.00;
    }

    /*
        GETTERS
    */
    public String getMoeda(){
        return moeda;
    }

    public double getValor(){
        return valor;
    }

    /*
        SETTERS
    */
    public void setValor(double valor){
        this.valor = valor;
    }

    /*
        MÉTODOS ADICIONAL
    */
    public static void mostrarMoeda() {
        Moeda[] moedas = Moeda.values();
        for (Moeda moeda : moedas) {
            System.out.print(moeda.ordinal()+1 + "-" + moeda.getMoeda() + "\n");
        }
        System.out.println();
    }
}