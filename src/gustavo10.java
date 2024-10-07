/*10. Os elementos aij de uma matriz An x n representam os custos de transporte da cidade i para a cidade j. O
caminhão de uma empresa de logística deve passar exatamente uma vez por cada uma da n cidades.
Sabendo que, uma rota é representada por um vetor de n posições, em que cada posição representa a
cidade visitada, você deve implementar um algoritmo que calcule o custo da rota de um caminhão da
empresa. Note que, a rota e a matriz de custo devem ser fornecidas pelo usuário.
Exemplo: Considere 4 cidades em que os custos de transporte entre as mesmas são representados pela
matriz de custo M abaixo. Considere ainda uma rota denotada pelo vetor = [ 3 1 0 2] significando que
o caminhão parte da cidade 3 com destino à cidade 1; sai de 1 e vai para 0; e por fim parte da cidade 0
para a cidade 2. Portanto, o custo de transporte dessa rota é: M[3][1] + M[1][0] + M[0][2] = 19 + 15 + 16
= 50 unidades.

Matriz de custos M =
[0 10 16 20
15 0 25 18
12 14 0 20
20 19 35 0]*/

import java.util.Scanner;
public class gustavo10 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ImprimirMatrizInt print = new ImprimirMatrizInt();
    System.out.println("Digite quantas cidades estão na rota: ");
    int cidades = sc.nextInt();
    // Cria a matriz de custos
    int[][] custo = new int[cidades][cidades];
    System.out.println("Digite o custo de viagem entre as cidades:");
    for (int i = 0; i < cidades; i++) {
      for (int j = 0; j < cidades; j++) {
        System.out.printf("Custo de %d para %d: ", i + 1, j + 1);
        custo[i][j] = sc.nextInt();
      }
    }
    // Lê a rota
    System.out.println("Digite a rota (use números de 1 a " + cidades + "):");
    int[] rota = new int[cidades];
    for (int i = 0; i < cidades; i++) {
      System.out.print("Cidade " + (i + 1) + ": ");
      rota[i] = sc.nextInt() - 1; // Ajusta o índice para começar em 0
    }
    // Calcula o custo da rota
    int custoTotal = 0;
    for (int i = 0; i < cidades - 1; i++) {
      custoTotal += custo[rota[i]][rota[i + 1]];
    }

    print.imprimirMatrizInteira(custo, cidades);
    // Imprime o custo total da rota
    System.out.println("\nCusto total da rota: " + custoTotal);
  }
}