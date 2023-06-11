package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class Gerenciador {
	
    static Scanner input = new Scanner(System.in);
    static ArrayList<Criptoativo> criptoativos;

	public static void main(String[] args) {
		
		criptoativos = new ArrayList<Criptoativo>();
		printInicial();
        menu();
	}

    // Função para criar um atraso de tempo 
    public static void tempo(int tempo){
        
        try {
            Thread.sleep(tempo);
        }
        catch (InterruptedException e) {
            System.out.println("Erro na Thread Sleep()");
        }
        
    }

    // Função para limpar a tela do console
    public static void limparTela(){

        System.out.print("\033c");
    }

    // Função para imprimir a tela inicial com informações do projeto e equipe
    public static void printInicial(){
        
        limparTela();

        System.out.println("                                                      ");
        System.out.println("        CENTRO UNIVERSITÁRIO DE JOÃO PESSOA - UNIPÊ        ");
        tempo(1000);
        System.out.println("                   CIÊNCIAS DA COMPUTAÇÃO                  ");
        tempo(1000);
        System.out.println("       PROJETO FINAL - PROGRAMAÇÃO ORIENTADA A OBJETO\n");
        tempo(1000);

        System.out.println("   EQUIPE:        ");
        tempo(1000);
        System.out.println("     - Ayrton Marcos Rodrigues Delfino - RGM 30858569");
        tempo(1000);
        System.out.println("     - Joel Adelaide Medeiros - RGM 29799384");
        tempo(1000);
        System.out.println("     - Juliana Chacon - RGM 29677467");
        tempo(1000);
        System.out.println("     - Marcos Barbosa Vieira Filho - RGM 30174503");
        tempo(1000);
        System.out.println("     - Rian Lucas Gomes Candido - RGM 30632722");
        tempo(1000);
        System.out.println("     - Thiago Emanuel ferreira de paiva - RGM 29510678");
        tempo(1000);
        
    }

    // Função para exibir o menu principal e solicitar uma opção ao usuário
	public static void menu() {

        limparTela();

        System.out.println("\n\n                  CARTEIRA DIGITAL   \n");
        System.out.println("               Selecione uma das Opções               \n");
        System.out.println("         |   Opção 1 - Cadastrar Cripto   |");
        System.out.println("         |   Opção 2 - Depositar Cripto   |");
        System.out.println("         |   Opção 3 - Sacar Cripto       |");
        System.out.println("         |   Opção 4 - Extrato            |");
        System.out.println("         |   Opção 5 - Sair               |\n");
        System.out.println("Opção: ");

        int opcao = input.nextInt();

        switch (opcao) {
            case 1:
                cadastrar();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                listar();
                break;

            case 5:
                System.out.println("Saindo do Sistema...");
                System.exit(0); 

            default:
                System.out.println("Opção inválida!");
                menu();
                break;
        }
    }
	
    // Função para cadastrar uma nova criptomoeda
	public static void cadastrar(){

        limparTela();

        System.out.println("\n\n                  CADASTRO DE CRIPTOMOEDAS   \n");

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nSigla: ");
        String sigla = input.next();

        System.out.println("\nExchange: ");
        String exchange = input.next();

        try {
            Criptomoeda criptomoeda = new Criptomoeda(nome, sigla, exchange);
            Criptoativo  criptoativo = new Criptoativo(criptomoeda, nome, sigla, exchange); 
            criptoativos.add(criptoativo);

            limparTela();
            System.out.println("Cadastro realizado com SUCESSO!");
            tempo(2000);
        }
        catch (Exception e) {

            limparTela();
            System.out.println("Erro ao realizar o cadastro!");
            tempo(2000);
        }

        menu();

    }

	 // Função para encontrar um criptoativo com base no seu ID
	private static Criptoativo encontrarCriptoativo(int idCriptoativo) {
        Criptoativo criptoativo  = null;
        if(criptoativos.size() > 0) {
            for(Criptoativo cripto : criptoativos) {
                if(cripto.getIdCriptoativo() == idCriptoativo) {
                	criptoativo = cripto;
                }
            }
        }
        return criptoativo;
    }

    // Função para realizar um depósito em um criptoativo
    public static void depositar() {

        limparTela();

        System.out.println("\n\n                  DEPÓSITO DE CRIPTOMOEDAS   \n");

        System.out.println("Insira o Número do ID: ");
        int idCriptoativo = input.nextInt();
        Criptoativo criptoativo = encontrarCriptoativo(idCriptoativo); 

        if(criptoativo != null) {

            try {
                System.out.println("Qual a quantidade de " + criptoativo.getNome() + " que deseja depositar ? ");
                Double valorDeposito = input.nextDouble();
            
                criptoativo.depositar(valorDeposito);

                limparTela();
                System.out.println("Depósito realizado com SUCESSO!");
                tempo(2000);
            }
            catch (Exception e) {

                limparTela();
                System.out.println("Erro ao realizar o depósito!");
                tempo(2000);
            }
        }else {
            limparTela();
            System.out.println("Criptomoeda não encontrada!");
            tempo(2000);
        }

        menu();

    }

    // Função para realizar um saque de um criptoativo
    public static void sacar() {

        limparTela();

        System.out.println("\n\n                  SAQUE DE CRIPTOMOEDAS   \n");

        System.out.println("Insira o Número do ID: ");
        int id = input.nextInt();
        
        Criptoativo criptoativo = encontrarCriptoativo(id);

        if(criptoativo != null) {
            try {
                System.out.println("Qual a quantidade de " + criptoativo.getNome() + " que deseja sacar ? ");
                Double valorSaque = input.nextDouble();
            
                criptoativo.sacar(valorSaque);

                limparTela();
                System.out.println("Saque realizado com SUCESSO!");
                tempo(2000);
            }
            catch (Exception e) {

                limparTela();
                System.out.println("Erro ao realizar o depósito!");
                tempo(2000);
            }

        }else {
            limparTela();
            System.out.println("Criptomoeda não encontrada!");
            tempo(2000);
        }

        menu();

    }
   
    // Função para realizar um saque de um criptoativo
    public static void listar() {
        if(criptoativos.size() > 0) {
            limparTela();
            for(Criptoativo cripto: criptoativos) {
                System.out.println(cripto);
            }
        }else {
            limparTela();
            System.out.println("Não há criptomoedas cadastradas! ");
            tempo(2000);
        }

        input.nextLine();
        input.nextLine();
        
        menu();
    }

}
