package br.edu.univas.main;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.univas.vo.*;

public class StartApp {
	
	public static void main(String[] args) {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		Scanner scan = new Scanner(System.in);
		int opt = 0;
		
		do {
			printMenu();
			opt = readInt(scan);
			
			switch(opt) {
			case 1:
				System.out.println("\nCadastrar Aluno: ");
				cadAluno(alunos, scan);
				break;
			case 2:
				System.out.println("\nListar Alunos: ");
				
				listarAlunos(alunos, scan);
				break;
			}
					
			
			if(opt == 1) {
				
			}
			
		} while (opt != 0);
		
		
		cadAluno(alunos, scan);
		scan.close();
	}
	
	public static Aluno cadAluno(ArrayList<Aluno> alunos, Scanner scan) {
		Aluno aluno = null;
		
		System.out.println("Cadastrar Aluno");
		System.out.println("Mestrado ou Pós Graduação?");
		System.out.println("1. Mestrado");
		System.out.println("2. Pós Graduação");
		System.out.println("3. Cancelar Cadastro");
		int opt = 0;
		
		do {
			opt = readInt(scan);
			
			if(opt == 0) {
				System.out.println("Cadastro Cancelado");
			} else if (opt == 1) {
				System.out.println("Aluno == Mestrado");
				aluno = new Mestrado();
			} else if (opt == 2) {
				System.out.println("Aluno == Pós Graduação");
				aluno = new PosGraduacao();
			} else {
				System.out.println("Opção Invalida");
			}
		} while(opt == 0);
		
		
		System.out.println("Digite o Nome do Aluno: ");
		aluno.setNome(scan.nextLine());
		
		System.out.println("Digite o CPF do Aluno: ");
		aluno.setCpf(readInt(scan));
		
		System.out.println("Digite o E-Mail do Aluno: ");
		aluno.setEmail(scan.nextLine());
		
		//
		
		for(int i=0; i<alunos.size(); i++) {
			if(aluno.equals(alunos.get(i))) {
				System.out.println("Este Aluno já foi Cadastrado");
			} else if (aluno == alunos.get(i)) {
				System.out.println("Este Aluno já foi Cadastrado");
			} else {
				
				System.out.println("");
				
				System.out.println("Aluno Cadastrado com Sucesso :)");
				alunos.add(aluno);
				
			}
			
		}
		
		return aluno;
	}
	
	public static void listarAlunos(ArrayList<Aluno> alunos, Scanner scan){
		System.out.println("Digite uma Opção: ");
		System.out.println("1. Mestrado");
		System.out.println("2. Pós-Graduação");
		int num = readInt(scan);
		
		Aluno tipo = null;
		
		if(num == 1) {
			tipo = new Mestrado();
		} else {
			tipo = new PosGraduacao();
		}
		
		for(int i=0; i<alunos.size(); i++) {
			if(alunos.get(i).getClass() == tipo.getClass()) {
				System.out.println(alunos.get(i).getNome());
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("Cadastro de Alunos");
		System.out.println("1. Cadastrar Aluno");
		System.out.println("2. Listar Alunos ");
		System.out.println("0. Finalizar Programa");
	}
	
	//
	
	public static int readInt(Scanner scan) {
		int num = scan.nextInt();
		scan.nextLine();
		return num;
	}
}