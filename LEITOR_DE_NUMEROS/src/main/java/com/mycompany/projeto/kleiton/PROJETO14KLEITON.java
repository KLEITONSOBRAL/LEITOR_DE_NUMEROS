/*
Desenvolva um programa em Java que leia **25 números inteiros** e os armazene em uma matriz **5 × 5**.
Após o preenchimento, o programa deverá:
1. Exibir a matriz original;
2. Ordenar todos os elementos da matriz em ordem crescente;
3. Exibir a matriz ordenada;
4. Calcular e mostrar a soma dos elementos de cada linha;
5. Calcular e mostrar a soma dos elementos de cada coluna;
6. Identificar os números que aparecem mais de uma vez e informar a quantidade de ocorrências de cada um;
7. Calcular e mostrar a soma dos elementos da diagonal principal;
8. Calcular e mostrar a soma dos elementos da diagonal secundária;
9. Substituir todos os números primos da matriz pelo valor **-1**;
10. Exibir a matriz após a substituição dos números primos.
*/

package com.mycompany.projeto.kleiton;

import java.util.*;

public class PROJETO14KLEITON {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[5][5];
        int[] vetorAuxiliar = new int[25];

        System.out.println("Digite os números inteiros para a matriz 5x5:");
        int contador = 0;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = scanner.nextInt();
                vetorAuxiliar[contador++] = matriz[i][j];
            }
        }

        System.out.println("Matriz original:");
        exibirMatriz(matriz);

        Arrays.sort(vetorAuxiliar);
        contador = 0;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = vetorAuxiliar[contador++];
            }
        }
        System.out.println("Matriz ordenada:");
        exibirMatriz(matriz);

        System.out.println("Soma de cada linha e coluna:");
        calcularSomas(matriz);

        System.out.println("Números repetidos e suas quantidades:");
        encontrarNumerosRepetidos(vetorAuxiliar);

        calcularSomasDiagonais(matriz);

        substituirPrimos(matriz);
        System.out.println("Matriz após substituição dos números primos por -1:");
        exibirMatriz(matriz);

        scanner.close();
    }

    private static void exibirMatriz(int[][] matriz) {
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void calcularSomas(int[][] matriz) {
        
        for (int i = 0; i < 5; i++) {
            int somaLinha = 0;
            int somaColuna = 0;
            for (int j = 0; j < 5; j++) {
                somaLinha += matriz[i][j];
                somaColuna += matriz[j][i];
            }
            System.out.println("Soma da linha " + i + ": " + somaLinha);
            System.out.println("Soma da coluna " + i + ": " + somaColuna);
        }
    }

    private static void encontrarNumerosRepetidos(int[] vetor) {
        Map<Integer, Integer> frequencia = new HashMap<>();
        
        for (int num : vetor) {
            frequencia.put(num, frequencia.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Número " + entry.getKey() + " aparece " + entry.getValue() + " vezes.");
            }
        }
    }

    private static void calcularSomasDiagonais(int[][] matriz) {
        int somaPrincipal = 0;
        int somaSecundaria = 0;
        for (int i = 0; i < 5; i++) {
            somaPrincipal += matriz[i][i];
            somaSecundaria += matriz[i][4 - i];
        }
        System.out.println("Soma da diagonal principal: " + somaPrincipal);
        System.out.println("Soma da diagonal secundária: " + somaSecundaria);
    }

    private static boolean isPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    private static void substituirPrimos(int[][] matriz) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (isPrimo(matriz[i][j])) {
                    matriz[i][j] = -1;
                }
            }
        }
    }
}
