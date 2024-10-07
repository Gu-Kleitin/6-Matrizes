/*17. Uma rede social de amizades pode ser representada por uma matriz quadrada (mesmo número de linhas e
colunas) de dimensão número de pessoas da rede social. A amizade entre as pessoas presentes nessa rede
se dá da seguinte forma: suponha que n0, n1, n2... representa uma pessoa e, caso duas pessoas sejam
amigas, então a posição da matriz será 1, caso contrário será 0 (zero). Considere a matriz de exemplo
abaixo:

Essa matriz representa uma rede social entre 5 pessoas: n0, n1, n2, n3 e n4. Além disso, quando a
posição (i, j) da matriz é 1, então as pessoas ni e nj são amigas entre si. Caso a posição (i, j) da matriz é
0, então ni e nj não são amigas. Observe que a pessoa n0 é amiga das pessoas n1, n2 e n4, mas não é
amiga da pessoa n3. Importante: a relação de amizade é simétrica: se ni é amigo de nj, então nj é,
necessariamente, amigo de ni. Além disso, em redes sociais de amizade, não existe amizade da pessoa
com ela mesma. Sabendo disso, implemente um algoritmo que:
a) preencha a matriz de amizades de uma rede social contendo 5 pessoas;
b) calcule e imprima a quantidade de amigos que cada pessoa possui.*/

import java.util.Scanner;

public class gustavo17 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[][] amizades = new int[5][5];
    int[] contagemAmigos = new int[5]; // Array para contar amigos de cada pessoa

    // Preenchimento da matriz de amizades
    for (int i = 0; i < 5; i++) {
      for (int j = i + 1; j < 5; j++) { // `j = i + 1` para evitar diagonais e duplicatas
        System.out.print("Pessoa " + i + " é amiga da pessoa " + j + "? (1 para Sim, 0 para Não): ");
        int amizade = scanner.nextInt();

        if (amizade == 1) {
          amizades[i][j] = 1;
          amizades[j][i] = 1; // Simetria na amizade
        }
      }
    }

    // Calcula e exibe a quantidade de amigos de cada pessoa
    for (int i = 0; i < 5; i++) {
      int amigos = 0;
      for (int j = 0; j < 5; j++) {
        if (amizades[i][j] == 1) {
          amigos++;
        }
      }
      contagemAmigos[i] = amigos;
      System.out.println("Pessoa " + i + " tem " + amigos + " amigo(s).");
    }

    scanner.close();
  }
}

