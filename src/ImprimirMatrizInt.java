public class ImprimirMatrizInt {
  public void imprimirMatrizInteira(int[][] matriz, int numCidades) {
    // Encontra o maior número de dígitos na matriz
    int maxDigitos = 0;
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[0].length; j++) {
        int digitos = String.valueOf(matriz[i][j]).length();
        if (digitos > maxDigitos) {
          maxDigitos = digitos;
        }
      }
    }

    // Calcula o espaçamento total para cada coluna
    int espacoColuna = maxDigitos + 2; // +2 para o espaço entre os números

    // Imprime o cabeçalho da tabela com os números das cidades
    System.out.print("      ");
    for (int j = 0; j < numCidades; j++) {
      System.out.printf("%" + espacoColuna + "d ", j + 1); // j + 1 para mostrar o número da cidade
    }
    System.out.println();

    // Imprime as linhas da matriz
    for (int i = 0; i < numCidades; i++) {
      System.out.printf("%3d: ", i + 1); // i + 1 para mostrar o número da cidade
      for (int j = 0; j < numCidades; j++) {
        System.out.printf("%" + espacoColuna + "d ", matriz[i][j]);
      }
      System.out.println();
    }
  }
}