/*7. Na teoria de sistemas define-se o elemento MINMAX de uma matriz como sendo o maior elemento da
linha onde se encontra o menor elemento da matriz. Faça um programa que carregue uma matriz 4 x 7
com números reias, calcule e mostre o MINMAX e sua posição (linha e coluna). */

import java.util.Scanner;

public class Gustavo7 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Cria a matriz 4x7
    double[][] matriz = new double[4][7];

    // Lê os elementos da matriz
    System.out.println("Preencha a matriz 4x7 com números reais:");
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 7; j++) {
        System.out.print("Elemento [" + i + "][" + j + "]: ");
        matriz[i][j] = scanner.nextDouble();
      }
    }

    // Encontra o menor elemento da matriz
    double menorElemento = matriz[0][0];
    int linhaMenor = 0;
    int colunaMenor = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 7; j++) {
        if (matriz[i][j] < menorElemento) {
          menorElemento = matriz[i][j];
          linhaMenor = i;
          colunaMenor = j;
        }
      }
    }

    // Encontra o maior elemento da linha onde está o menor elemento
    double minmax = matriz[linhaMenor][0];
    int colunaMax = 0;
    for (int j = 1; j < 7; j++) {
      if (matriz[linhaMenor][j] > minmax) {
        minmax = matriz[linhaMenor][j];
        colunaMax = j;
      }
    }

    // Imprime o MINMAX e sua posição
    System.out.println("\nMenor elemento da matriz: " + menorElemento + " na posição [" + linhaMenor + "][" + colunaMenor + "]");
    System.out.println("MINMAX (maior elemento na linha do menor elemento): " + minmax);
    System.out.println("Posição do MINMAX: [" + linhaMenor + "][" + colunaMax + "]");

    // Fechar o scanner
    scanner.close();
  }
}
