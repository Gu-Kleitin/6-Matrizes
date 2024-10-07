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
