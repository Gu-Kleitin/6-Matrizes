/*11. Considere n cidades numeradas de 0 a n-1 que estão interligadas por uma série de estradas de mão única.
As ligações entre as cidades são representadas pelos elementos de uma matriz quadrada Lnxn, cujos
elementos lij assumem o valor 1 ou 0, conforme exista ou não estrada direta que saia da cidade i e chegue
à cidade j. Assim, os elementos da linha i indicam as estradas que saem da cidade i, e os elementos da coluna j indicam as estradas que chegam à cidade j. Por convenção lii = 1. A figura abaixo um exemplo
para n = 4.

a) Dada uma cidade k, determine quantas estradas saem de k e quantas cidades chegam à k.
b) Qual das cidades possuem maior número de estradas chegando?
c) Encontre, se existirem, as cidades isoladas. Ou seja, aquelas em que não chegam nem saem estradas.
d) Dada uma determinada rota de m cidades, representada por um vetor de inteiros cujos valores estão
entre 0 e n-1, tal como exercício anterior, verifique se é possível realizar tal rota. No exemplo anterior,
a rota (m = 5) 2 3 2 1 0 é impossível; já a rota (m = 6) 0 1 2 3 2 0 é possível.*/
import java.util.Scanner;

public class gustavo11 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o número de cidades: ");
    int n = scanner.nextInt();
    int[][] matriz = new int[n][n];

    //matriz de estradas
    System.out.println("Digite a matriz de estradas:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matriz[i][j] = scanner.nextInt();
      }
    }

    // A- Quantidade de estradas que saem e chegam em uma cidade k
    System.out.print("Digite a cidade k para análise: ");
    int k = scanner.nextInt();
    int saemDeK = 0;
    int chegamEmK = 0;
    for (int i = 0; i < n; i++) {
      if (matriz[k][i] == 1) saemDeK++;  // Estradas saindo da cidade k
      if (matriz[i][k] == 1) chegamEmK++; // Estradas chegando à cidade k
    }
    System.out.println("Estradas que saem da cidade " + k + ": " + saemDeK);
    System.out.println("Estradas que chegam à cidade " + k + ": " + chegamEmK);

    //B- Cidade com maior número de estradas chegando
    int maxChegam = 0;
    int cidadeMaisEstradas = 0;
    for (int j = 0; j < n; j++) {
      int chegamEmJ = 0;
      for (int i = 0; i < n; i++) {
        if (matriz[i][j] == 1) chegamEmJ++;
      }
      if (chegamEmJ > maxChegam) {
        maxChegam = chegamEmJ;
        cidadeMaisEstradas = j;
      }
    }

    System.out.println("Cidade com o maior número de estradas chegando: " + cidadeMaisEstradas);

    //C- Cidades isoladas
    System.out.print("Cidades isoladas: ");
    for (int i = 0; i < n; i++) {
      boolean isolada = true;
      for (int j = 0; j < n; j++) {
        if (matriz[i][j] == 1 || matriz[j][i] == 1) {
          isolada = false;
          break;
        }
      }
      if (isolada) {
        System.out.print(i + " ");
      }
    }
    System.out.println();

    //D- Verificar se uma rota é possível
    System.out.print("Digite o número de cidades na rota: ");
    int m = scanner.nextInt();
    int[] rota = new int[m];

    System.out.println("Digite a sequência da rota:");
    for (int i = 0; i < m; i++) {
      rota[i] = scanner.nextInt();
    }
    boolean possivel = true;
    for (int i = 0; i < m - 1; i++) {
      int origem = rota[i];
      int destino = rota[i + 1];
      if (matriz[origem][destino] != 1) {
        possivel = false;
        break;
      }
    }

    if (possivel) {
      System.out.println("A rota é possível.");
    } else {
      System.out.println("A rota não é possível.");
    }
    scanner.close();
  }
}
