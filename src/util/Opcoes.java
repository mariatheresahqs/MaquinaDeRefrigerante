package util;

public enum Opcoes {
    RECEBERCREDITO ("Inserir moeda"),
    EXIBIRCREDITO ("Exibir crédito"),
    CANCELARVENDA ("Cancelar venda"),
    ESCOLHERREFRIGERANTE("Escolher refrigerante"),
    // RECEBERTROCO("Receber troco"),
    ACESSOADMINISTRADOR("Acessar privilégios de administrador"),
    ENCERRARPEDIDO("Encerrar pedido");

    private final String opcao;
    public static final int MAXOPCOES = 6;
    public static final int MINOPCOES =1;

    /*
        CONSTRUTOR
    */
    Opcoes(String opcao){
        this.opcao = opcao;
    }
    
    /*
        GETTER
    */
    public String getOpcao(){
        return opcao;
    }

    /*
        MÉTODOS ADICIONAL
    */
    public static void mostrarOpcoes() {
        Opcoes[] opcoes = Opcoes.values();
        for (Opcoes opcao : opcoes) {
            System.out.print(opcao.ordinal()+1 + "-" + opcao.getOpcao() + "\n");
        }
        System.out.println();
    }
}
