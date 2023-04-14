package Programa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gerenciador {
	
    static Scanner input = new Scanner(System.in);
    static ArrayList<Criptoativo> criptoativos;

	public static void main(String[] args) {
		
		criptoativos = new ArrayList<Criptoativo>();
		menu();

	}
	
	public static void menu() {

        System.out.println("                                                      ");
        System.out.println("                                                      ");
        System.out.println("                                                      ");
        System.out.println("   Bem vindos ao Sistema de Gerenciamento de Cripto   ");
        System.out.println("                                                      ");
        System.out.println("               Selecione uma das Opções               ");
        System.out.println("                                                      ");
        System.out.println("         |   Opção 1 - Cadastrar Cripto   |");
        System.out.println("         |   Opção 2 - Depositar Cripto   |");
        System.out.println("         |   Opção 3 - Sacar Cripto       |");
        System.out.println("         |   Opção 4 - Extrato            |");
        System.out.println("         |   Opção 5 - Sair               |");

        int opcao = input.nextInt();;

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

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nSigla: ");
        String sigla = input.next();

        System.out.println("Exchange: ");
        String exchange = input.next();
        
        Criptomoeda criptomoeda = new Criptomoeda(nome, sigla, exchange);
        
        Criptoativo  criptoativo = new Criptoativo(criptomoeda); 
        
        criptoativos.add(criptoativo);

        System.out.println("Conta cadastrada com sucesso!");
        
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
