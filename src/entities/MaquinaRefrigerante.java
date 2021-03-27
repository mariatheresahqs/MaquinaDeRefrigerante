package entities;

public class MaquinaRefrigerante {
    /*
        PROPRIEDADES PEDIDAS
    */
    private double saldo;
    private double creditoAtual;
    // private int quantidadeRefrigerante; - Foi usado um método para percorrer a classe refrigerante para exibir o estoque de cada marca
    
    /*
        PROPRIEDADES ADICIONAIS
    */
    private String refrigeranteEscolhido;
    private int quantidadeRetirar;
    Refrigerante[] refrigerantes = Refrigerante.values();
    Refrigerante refrigerante = Refrigerante.COCACOLA; // Inicializando opcoes de refrigerante

    /*
        CONSTRUTORES
    */
    public MaquinaRefrigerante() {
    }

    public MaquinaRefrigerante(double saldo, double creditoAtual) {
        this.saldo = 10.00;
        this.creditoAtual = 0.00;
    }

    /*
        SETTERS
    */
    public void setCreditoAtual(double creditoAtual) {
        this.creditoAtual = creditoAtual;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /*
        GETTERS
    */
    public double getCreditoAtual() {
        return creditoAtual;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getRefrigeranteEscolhido() {
        return refrigeranteEscolhido;
    }

    public int getQuantidadeRetirar() {
        return quantidadeRetirar;
    }

    /*
        MÉTODOS PEDIDOS
    */
    public void receberCredito(int valor){
        creditoAtual += valor;
    }

    public double exibirCreditoAtual(){
        return getCreditoAtual();
    }

    public void cancelarVenda(){
        System.out.println("Venda cancelada.");
        System.out.println("Seu troco de " + getCreditoAtual() + " já está disponível.");
        creditoAtual = 0.0;
    }

    public void escolherRefrigerante(String refrigeranteEscolhido){
        Refrigerante.mostrarRefrigerantes();
        this.refrigeranteEscolhido = refrigeranteEscolhido;
    }

    public void alterarEstoque(int quantidadeRetirar){
        this.quantidadeRetirar = quantidadeRetirar;
        refrigerante.retirarRefrigerante(getRefrigeranteEscolhido(), getQuantidadeRetirar());
    }
    
    /*
        MÉTODOS ADICIONAL
    */
    public void exibirQuantiadePorRefrigerante(){
        Refrigerante.quantidadeRefrigerantes();
    }
}
