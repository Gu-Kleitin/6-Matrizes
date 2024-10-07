/*12. Faça um programa que receba o estoque atual de 3 produtos que estão armazenados em 4 armazéns e
coloque esses dados em uma matriz 5 x 3. Sendo que a última linha da matriz contém o custo de
estocagem de uma unidade de cada produto, calcule e mostre:
a) Quantidade de itens armazenados em cada armazém;
b) Qual armazém possui maior estoque do produto 2;
c) Qual armazém possui menor estoque;
d) Qual armazém possui maior custo de estocagem.*/

import java.util.Scanner;

public class gustavo12 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Criação da matriz 5x3
    int[][] matriz = new int[5][3];

    // Entrada do estoque de 3 produtos em 4 armazéns
    System.out.println("Digite a quantidade de estoque para cada produto nos 4 armazéns:");
    for (int i = 0; i < 4; i++) {  // Linhas para os 4 armazéns
      System.out.println("Armazém " + (i + 1) + ":");
      for (int j = 0; j < 3; j++) {  // Colunas para os 3 produtos
        System.out.print("Produto " + (j + 1) + ": ");
        matriz[i][j] = scanner.nextInt();
      }
    }

    // Entrada do custo de estocagem na última linha
    System.out.println("Digite o custo de estocagem para cada produto:");
    for (int j = 0; j < 3; j++) {
      System.out.print("Custo de estocagem do produto " + (j + 1) + ": ");
      matriz[4][j] = scanner.nextInt();
    }

    // a) Quantidade de itens armazenados em cada armazém
    System.out.println("\nQuantidade de itens em cada armazém:");
    for (int i = 0; i < 4; i++) {
      int totalArmazem = 0;
      for (int j = 0; j < 3; j++) {
        totalArmazem += matriz[i][j];
      }
      System.out.println("Armazém " + (i + 1) + ": " + totalArmazem);
    }

    // b) Armazém com maior estoque do produto 2
    int maiorEstoqueProd2 = matriz[0][1];
    int armazemMaiorProd2 = 1;
    for (int i = 1; i < 4; i++) {
      if (matriz[i][1] > maiorEstoqueProd2) {
        maiorEstoqueProd2 = matriz[i][1];
        armazemMaiorProd2 = i + 1;
      }
    }
    System.out.println("\nArmazém com maior estoque do produto 2: " + armazemMaiorProd2);

    // c) Armazém com menor estoque total
    int menorEstoque = Integer.MAX_VALUE;
    int armazemMenorEstoque = 1;
    for (int i = 0; i < 4; i++) {
      int totalEstoque = 0;
      for (int j = 0; j < 3; j++) {
        totalEstoque += matriz[i][j];
      }
      if (totalEstoque < menorEstoque) {
        menorEstoque = totalEstoque;
        armazemMenorEstoque = i + 1;
      }
    }
    System.out.println("Armazém com menor estoque total: " + armazemMenorEstoque);

    // d) Armazém com maior custo de estocagem
    int maiorCusto = 0;
    int armazemMaiorCusto = 1;
    for (int i = 0; i < 4; i++) {
      int custoTotal = 0;
      for (int j = 0; j < 3; j++) {
        custoTotal += matriz[i][j] * matriz[4][j];
      }
      if (custoTotal > maiorCusto) {
        maiorCusto = custoTotal;
        armazemMaiorCusto = i + 1;
      }
    }
    System.out.println("Armazém com maior custo de estocagem: " + armazemMaiorCusto);

    scanner.close();
  }
}
