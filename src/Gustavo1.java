/*1. Faça um programa que preencha uma matriz 2 x 2, calcule e mostre uma matriz resultante que será a
matriz digitada multiplicada pelo maior elemento da mesma.*/

import java.util.Scanner;

public class Gustavo1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] matriz = new int[2][2];

    System.out.println("Preencha a matriz 2x2 com números inteiros:");
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        matriz[i][j] = sc.nextInt();
      }
    }

    int maiorElemento = matriz[0][0];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        if (matriz[i][j] > maiorElemento) {
          maiorElemento = matriz[i][j];
        }
      }
    }

    System.out.println("Matriz original:");
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        System.out.print(matriz[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("Matriz multiplicada pelo maior elemento (" + maiorElemento + "):");
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        System.out.print(matriz[i][j] * maiorElemento + " ");
      }
      System.out.println();
    }
  }
}