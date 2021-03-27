package util;

import java.util.Scanner;
// import java.util.Locale;

import entities.*;

public class Menu {
    // Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    String nome;
    double valor;
    int escolha;

    Opcoes[] opcoes = Opcoes.values();
    Refrigerante[] refrigerantes = Refrigerante.values();


    Opcoes opcao = Opcoes.RECEBERCREDITO; // Inicializando opcoes de menu
    Refrigerante refrigerante = Refrigerante.COCACOLA; // Inicializando opcoes de refrigerante
    
    public void mostrarMenu(){
            System.out.println("Bem vindo a aplicação \"Refrigerante não mata a sede\"");
            Opcoes.mostrarOpcoes();
        
        do{    
            System.out.print("Qual a operação que você deseja fazer:");
            int tmp = sc.nextInt();

            while (tmp < 1 || tmp > 7){
                System.out.println();
                Opcoes.mostrarOpcoes();
                System.out.print("Digite a operação que você deseja fazer: ");
                tmp = sc.nextInt();
            }
            opcao = opcoes[tmp-1];

            switch (opcao) {
                
                case RECEBERCREDITO:
                    System.out.print("Digite o valor que deseja depositar: ");
                    break;
                case EXIBIRCREDITO:
                    System.out.print("Digite o valor que deseja sacar: ");
                    break;
                case CANCELARVENDA:
                    System.out.print("Deseja alterar o nome do titular (Sim/Nao):");
                    break;
                case ESCOLHERREFRIGERANTE:
                    System.out.print("Digite o valor que deseja sacar: ");
                    break;
                case RECEBERTROCO:
                    System.out.print("Digite o valor que deseja sacar: ");
                    break;
                case ACESSOADMINISTRADOR:
                    System.out.println("Opções de refrigerante: ");
                    Refrigerante.mostrarRefrigerantes();
                    System.out.print("Digite a opção que deseja alterar o preço: ");
                    escolha = sc.nextInt();
                    while (escolha < 1 || escolha > 5){
                        System.out.println();
                        Refrigerante.mostrarRefrigerantes();
                        System.out.print("Digite a opção que deseja alterar o preço: ");
                        escolha = sc.nextInt();
                    }
                    System.out.print("Digite o novo preço: ");
                    valor = sc.nextDouble();
                    refrigerante = refrigerantes[escolha-1];
                    for (Refrigerante refrigerante : refrigerantes) {
                        // System.out.println("entrou");
                        if((refrigerante.ordinal()+1) == escolha)
                            refrigerante.alterarValor(refrigerante.getNome(), valor);
                    }
                    Refrigerante.mostrarRefrigerantes();

                    break;
                case ENCERRARPEDIDO:
                    System.out.println("\n\"Refrigerante não mata a sede\" agradece seu dinheiro!\nVolte Sempre!");
                    break;
            }
                System.out.println();
                System.out.println();
        } while (opcao != Opcoes.ENCERRARPEDIDO);
        // pedido.imprimirPedido();
    }
}
