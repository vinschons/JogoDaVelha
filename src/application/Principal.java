package application;

import java.util.Scanner;

import entities.Jogador;
import entities.JogoDaVelha;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer dnv;
		@SuppressWarnings("unused")
		boolean verificaJogada = true;
		
		System.out.print("Insira o nome do jogador 1 (Símbolo: x): ");
		String n1 = sc.nextLine();
		Jogador j1 = new Jogador(n1);
		System.out.print("Insira o nome do jogador 2 (Símbolo: o): ");
		String n2 = sc.nextLine();
		Jogador j2 = new Jogador(n2);
		do {
			System.out.print("Insira o tamanho do tabuleiro (somente um número): ");
			Integer tamanho = sc.nextInt();
			JogoDaVelha jv = new JogoDaVelha(tamanho);
		
			Integer primeiroJogador;
		
			do {
				System.out.print("Que jogador irá começar jogando? 1 ou 2? ");
				primeiroJogador = sc.nextInt();
			}while(primeiroJogador != 1 && primeiroJogador !=2);
		
			char c;
		
			if(primeiroJogador == 1)
				c = 'x';
			else
				c = 'o';
		
			while(jv.getJogadasRestantes() > 0) {
				if(jv.getJogadasRestantes() != 0) {
					if(primeiroJogador == 1) {
						do {
							System.out.println("-----RODADA DO JOGADOR 1 -----");
							System.out.print("Insira em que linha gostaria de jogar (de 0 a " + (tamanho-1) +"):");
							Integer x = sc.nextInt();
							System.out.print("Insira em que coluna gostaria de jogar (de 0 a " + (tamanho-1) +"):");
							Integer y = sc.nextInt();
							verificaJogada = jv.realizaJogada(x, y, c);
							jv.toString();
							boolean ganhador = jv.verificaGanhador();
							if(ganhador) {
								jv.terminaJogo();
								j1.setPonto(1);
								break;
							}
							else {
								if(verificaJogada = true) {
									System.out.println("Jogadas restantes: " +jv.getJogadasRestantes());
									c = 'o';
									primeiroJogador = 2;
								}
							}
						}while(verificaJogada = false);
					}
				}
				
				if(jv.getJogadasRestantes() != 0) {
					if(primeiroJogador == 2) {
						do {
							System.out.println("-----RODADA DO JOGADOR 2 -----");
							System.out.print("Insira em que linha gostaria de jogar (0 a " + (tamanho-1) + "):");
							Integer x = sc.nextInt();
							System.out.print("Insira em que coluna gostaria de jogar (0 a " + (tamanho-1) + "):");
							Integer y = sc.nextInt();
							jv.realizaJogada(x, y, c);
							jv.toString();
							boolean ganhador = jv.verificaGanhador();
							if(ganhador) {
								jv.terminaJogo();
								j2.setPonto(1);
								break;
							}
							else {
								if(verificaJogada = true) {
									System.out.println("Jogadas restantes: " +jv.getJogadasRestantes());
									c = 'x';
									primeiroJogador = 1;
								}
							}
						}while(verificaJogada = false);		
					}
				}
			}
				
			System.out.print("Gostariam de jogar de novo? 1=SIM 0=NÃO");
			dnv = sc.nextInt();
		}while(dnv == 1);
		
		if(j1.getPontos() > j2.getPontos()) {
			System.out.println("----- VENCEDOR -----");
			System.out.println(j1.toString());
		}
		else if(j2.getPontos() > j1.getPontos()) {
			System.out.println("----- VENCEDOR -----");
			System.out.println(j2.toString());
		}
		else
			System.out.println("----- EMPATE -----");
		
		sc.close();
	}
}
