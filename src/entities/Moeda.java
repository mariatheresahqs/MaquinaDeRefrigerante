package entities;

public enum Moeda {
    DEZ("0.10", 0.10, 10),
    VINTECINCO("0.25", 0.25, 10),
    CINQUENTA("0.50", 0.50, 9),
    UM("1.00", 1.00, 2);

    // total moedas = 10.0
    private String moeda;
    private double valor;
    private int quantidade;
    private double valorTotalMoedas;

    /*
        CONSTRUTOR
    */
    private Moeda() {
    }

    Moeda(String moeda, double valor, int quantidade){
        this.moeda = moeda;
        this.valor = valor;
        this.quantidade = quantidade;
        this.valorTotalMoedas = 0.0;
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

    public int getQuantidade(){
        return quantidade;
    }

    public double getValorTotalMoedas(){
        return valorTotalMoedas;
    }

    /*
        SETTERS
    */
    public void setMoeda(String moeda){
        this.moeda = moeda;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    /*
        MÉTODOS ADICIONAL
    */
    public static void mostrarMoeda() {
        Moeda[] moedas = Moeda.values();
        for (Moeda moeda : moedas) {
            System.out.print(moeda.ordinal()+1 + "- R$ " + moeda.getMoeda() + "\n");
        }
        System.out.println();
    }

    public double somarValorMoedas() {
        Moeda[] moedas = Moeda.values();
        for (Moeda moeda : moedas) {
            this.valorTotalMoedas += moeda.getValor();
        }
        return this.valorTotalMoedas;
    }
}