package entities;

public enum Refrigerante{
    COCACOLA("Coca-Cola", 5.00, 20),
    GUARANA("Guarana", 4.50, 20),
    FANTA("Fanta", 4.00, 20),
    PEPSI("Pepsi", 3.50, 20),
    JESUS("Jesus", 3.00, 20);

    /*
        PROPRIEDADES PEDIDAS
    */
    private double valor;
    private String nome;
    /*
        PROPRIEDADES ADICIONAL
    */
    private int estoque;

    /*
        CONSTRUTORES
    */
    private Refrigerante() {
    }

    Refrigerante(String nome, double valor, int estoque){
        this.nome = nome;
        this.valor = valor;
        this.estoque = estoque;
    }

    /*
        SETTERS
    */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }

    public void setEstoque(int estoque){
        this.estoque = estoque;
    }

    /*
        GETTERS
    */
    public String getNome(){
        return this.nome;
    }

    public double getValor(){
        return valor;
    }

    public double getEstoque(){
        return estoque;
    }
    
    /*
        MÉTODOS PEDIDOS
    */
    public void alterarValor(String nome, double valor){
        if(this.nome == nome)
            setValor(valor);
    }
    

    /*
        MÉTODOS ADICIONAIS
    */
    public void retirarRefrigerante(String nome, int estoque){
        if(this.nome == nome)
            this.estoque -= estoque;
    }

    public static void mostrarRefrigerantes() {
        Refrigerante[] opcoes = Refrigerante.values();
        for (Refrigerante opcao : opcoes) {
            System.out.print(opcao.ordinal()+1 + "-" + opcao.getNome() + ", R$" + String.format("%.2f", opcao.getValor()) + "\n");
        }
        System.out.println();
    }

    public static void quantidadeRefrigerantes() {
        Refrigerante[] opcoes = Refrigerante.values();
        for (Refrigerante opcao : opcoes) {
            System.out.print(opcao.ordinal()+1 + "-" + opcao.getNome() + ", " + opcao.getEstoque() + " unidades \n");
        }
        System.out.println();
    }

}
