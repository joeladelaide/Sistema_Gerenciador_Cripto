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

    public static void tempo(int tempo){
        
        try {
            Thread.sleep(tempo);
        }
        catch (InterruptedException e) {
            System.out.println("Erro no método Sleep");
        }
        
    }

    public static void limparTela(){

        System.out.print("\033c");
    }

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
    
	public static void menu() {

        System.out.println("                                                      ");
        System.out.println("                                                      ");
        System.out.println("                                                      ");
        System.out.println("   Bem vindo ao Sistema de Gerenciamento de Cripto   ");
        System.out.println("                                                      ");
        System.out.println("               Selecione uma das Opções               ");
        System.out.println("                                                      ");
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
	
	public static void cadastrar(){

        limparTela();

        System.out.println("CADASTRO DE CRIPTOMOEDAS: \n");

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nSigla: ");
        String sigla = input.next();

        System.out.println("\nExchange: ");
        String exchange = input.next();


        Criptomoeda criptomoeda = new Criptomoeda(nome, sigla, exchange);
        
        Criptoativo  criptoativo = new Criptoativo(criptomoeda, nome, sigla, exchange); 
        
        criptoativos.add(criptoativo);

        limparTela();
        System.out.println("Criptomoeda cadastrada com sucesso...");
        
        menu();

    }
	
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

    public static void depositar() {

        System.out.println("DEPÓSITO DE CRIPTOMOEDAS: \n");

        System.out.println("Número do id: ");
        int idCriptoativo = input.nextInt();
        Criptoativo criptoativo = encontrarCriptoativo(idCriptoativo); 

        if(criptoativo != null) {
            System.out.println("Qual a quantidade de criptomoedas que deseja depositar? ");
            Double valorDeposito = input.nextDouble();
            
            criptoativo.depositar(valorDeposito);
        }else {
            System.out.println("Conta não encontrada!");
        }

        menu();

    }

    public static void sacar() {

        System.out.println("SAQUE DE CRIPTOMOEDAS: \n");

        System.out.println("Número do id: ");
        int id = input.nextInt();
        
        Criptoativo criptoativo = encontrarCriptoativo(id);

        if(criptoativo != null) {
            System.out.println("Qual a quantidade de criptomoedas que deseja sacar? ");
            Double valorSaque = input.nextDouble();

            criptoativo.sacar(valorSaque);
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Conta não encontrada!");
        }

        menu();

    }
   

    public static void listar() {
        if(criptoativos.size() > 0) {
            for(Criptoativo cripto: criptoativos) {
                System.out.println(cripto);
            }
        }else {
            System.out.println("Não há contas cadastradas! ");
        }
        
        menu();
    }
    
   

}
