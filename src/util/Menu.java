package util;

import java.util.Scanner;

import entities.*;

public class Menu {
    Scanner sc = new Scanner(System.in);
    String nome;
    double valor;
    int escolha;
    MaquinaRefrigerante maquina = new MaquinaRefrigerante();
    Opcoes[] opcoes = Opcoes.values();
    Moeda [] moedas = Moeda.values(); 
    Refrigerante[] refrigerantes = Refrigerante.values();


    Opcoes opcao = Opcoes.RECEBERCREDITO; // Inicializando opcoes de menu
    Moeda moeda = Moeda.DEZ; // Inicializando opcoes de moeda
    Refrigerante refrigerante = Refrigerante.COCACOLA; // Inicializando opcoes de refrigerante
    
    public void mostrarMenu(){
            System.out.println("-----------------------------------------------------------------");
            System.out.println("    Bem vindo a aplicação \"Refrigerante não mata a sede\"");
            System.out.println("-------------------------- MENU ---------------------------------");
            Opcoes.mostrarOpcoes();
        
        do{    
            System.out.print("Qual a operação que você deseja fazer:");
            int tmp = sc.nextInt();
            System.out.println("-----------------------------------------------------------------");

            while (tmp < Opcoes.MINOPCOES || tmp > Opcoes.MAXOPCOES){
                System.out.println("-------------------------- MENU ---------------------------------");
                Opcoes.mostrarOpcoes();
                System.out.print("Digite a operação que você deseja fazer: ");
                tmp = sc.nextInt();
            }
            opcao = opcoes[tmp-1];

            switch (opcao) {

                /*
                    OPCAO PARA RECEBER MOEDAS
                */
                case RECEBERCREDITO:
                    System.out.println("Opções de moeda:");
                    Moeda.mostrarMoeda();
                    System.out.print("Digite o valor que deseja depositar: ");
                    tmp = sc.nextInt();
                    while (tmp < 1 || tmp > 4){
                        System.out.println("Opções de moeda:");
                        Moeda.mostrarMoeda();
                        System.out.print("Digite o valor que deseja depositar: ");
                        tmp = sc.nextInt();
                    }
                    moeda = moedas[tmp-1];
                    for (Moeda moeda : moedas) {
                        if((moeda.ordinal()+1) == tmp){
                            valor = moeda.getValor();
                            break;
                        }
                    }
                    maquina.receberCredito(valor);
                    maquina.somarCreditoAtualAoSaldo(valor);
                    maquina.exibirCreditoAtual();
                    System.out.println();
                    break;

                /*
                    OPCAO PARA EXIBIR CREDITO
                */
                case EXIBIRCREDITO:
                    maquina.exibirCreditoAtual();
                    break;

                /*
                    OPCAO PARA CANCELAR VENDA
                */
                case CANCELARVENDA:
                    System.out.println("Sua compra foi cancelada com sucesso!");
                    System.out.println("Seu troco é de: R$ " + String.format("%.2f", maquina.getCreditoAtual()));
                    maquina.setCreditoAtual(0.0);
                    break;

                /*
                    OPCAO PARA ESCOLHER O REFRIGERANTE
                */
                case ESCOLHERREFRIGERANTE:
                    System.out.println("Refrigerantes disponíveis para você não matar sua sede: ");
                    Refrigerante.mostrarRefrigerantes();
                    System.out.print("Digite a opção que deseja: ");
                    escolha = sc.nextInt();
                    while (escolha < Refrigerante.MINREFRIGERANTE || escolha > Refrigerante.MAXREFRIGERANTE){
                        System.out.println("Refrigerantes disponíveis para você não matar sua sede: ");
                        Refrigerante.mostrarRefrigerantes();
                        System.out.print("Digite a opção que deseja: ");
                        escolha = sc.nextInt();
                    }
                    refrigerante = refrigerantes[escolha-1];
                    for (Refrigerante refrigerante : refrigerantes) {
                        if((refrigerante.ordinal()+1) == escolha){
                            // Checar se há quantidade em estoque para a compra
                            if(refrigerante.getEstoque() > 0){
                                // Checar se o credito atual é suficiente para a compra
                                if(maquina.getCreditoAtual() >= refrigerante.getValor() ){
                                    // Decrementa estoque
                                    maquina.alterarEstoque(refrigerante.getNome(),1);
                                    // Subtrai preco do refrigerante no valor de credito atual
                                    maquina.atualizarCreditoAtualPosCompra(refrigerante.getValor());
                                    // Subtrair valor da compra no saldo da maquina
                                    maquina.subtrairValorCompraNoSaldo(refrigerante.getValor());
                                    // Informa compra
                                    System.out.println("Você já pode retirar seu refrigerante " + refrigerante.getNome()+ "!");
                                    // Informa o troco, quando houver
                                    if(maquina.getCreditoAtual()>0)
                                        System.out.println("Seu troco é de: R$ " + String.format("%.2f", maquina.getCreditoAtual()));

                                } else{
                                    System.out.println("Você não inseriu crédito suficiente para essa compra.");
                                    System.out.println("Seu troco é de: R$ " + String.format("%.2f", maquina.getCreditoAtual()));
                                }
                            } else{
                            System.out.println("Não há mais estoque desse refrigerante.");
                            System.out.println("Quantidades disponível por refrigerante:");
                            maquina.exibirQuantiadePorRefrigerante();
                            }
                        }
                    }
                    break;

                /*
                    OPCAO PARA RECEBER TROCO
                */
                // case RECEBERTROCO:
                //     System.out.println("Seu troco é de: R$ " + String.format("%.2f", maquina.getCreditoAtual()));
                //     break;

                /*
                    OPCAO DE ACESSO PARA ADMINISTRADOR
                */
                case ACESSOADMINISTRADOR:
                    System.out.println("Acesso permitido apenas ao administrador");
                    System.out.print("Digite a senha de acesso \"12345\": ");
                    tmp = sc.nextInt();
                    if(tmp == 12345){
                        System.out.println();
                        System.out.println("Qual produto você deseja alterar:");
                        Refrigerante.mostrarRefrigerantes();
                        System.out.print("6. SAIR");
                        System.out.print("\nOpção escolhida: ");
                        escolha = sc.nextInt();
                        while (escolha < Refrigerante.MINREFRIGERANTE || escolha > Refrigerante.MAXREFRIGERANTE+1){
                            System.out.println();
                            System.out.println("Qual produto você deseja alterar:");
                            Refrigerante.mostrarRefrigerantes();
                            System.out.println("6. SAIR");
                            System.out.print("Opção escolhida: ");
                            escolha = sc.nextInt();
                        }
                        if(escolha == 6) break;
                        refrigerante = refrigerantes[escolha-1];
                        System.out.println("O que você deseja alterar no produto: ");
                        System.out.println("1. Preço");
                        System.out.println("2. Estoque");
                        System.out.println("3. Cancelar operação");
                        System.out.print("Opção escolhida: ");
                        tmp = sc.nextInt();
                        if(tmp == 3){
                            break;
                        }else if( tmp == 1){
                            System.out.print("Digite o novo preço: ");
                            valor = sc.nextDouble();
                            for (Refrigerante refrigerante : refrigerantes) {
                                if((refrigerante.ordinal()+1) == escolha)
                                    refrigerante.alterarValor(refrigerante.getNome(), valor);
                            }
                            Refrigerante.mostrarRefrigerantes();
                        } else if(tmp ==2){
                            System.out.print("Digite o novo estoque: ");
                            tmp = sc.nextInt();
                            for (Refrigerante refrigerante : refrigerantes) {
                                if((refrigerante.ordinal()+1) == escolha)
                                    refrigerante.setEstoque(tmp);
                            }
                            Refrigerante.mostrarRefrigerantes();
                        } 
                    } else{
                        System.out.println("Senha incorreta!\nAcesso negado!");
                    }
                    break;

                /*
                    OPCAO PARA ENCERRAR O PROGRAMA
                */
                case ENCERRARPEDIDO:
                    System.out.println("\n\"Refrigerante não mata a sede\" agradece seu dinheiro!\nVolte Sempre!\n");
                    break;
            }
            if(opcao != Opcoes.ENCERRARPEDIDO){
                System.out.println("-------------------------- MENU ---------------------------------");
                Opcoes.mostrarOpcoes();
            }
        } while (opcao != Opcoes.ENCERRARPEDIDO);
    }
}
