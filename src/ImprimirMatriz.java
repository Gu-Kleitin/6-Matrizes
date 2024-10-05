public class ImprimirMatriz {
  public void imprimirMatriz(double[][] matriz) { // Modifica o tipo do parâmetro
    // Imprime o cabeçalho da tabela com os números das colunas
    System.out.print("      ");
    for (int j = 0; j < matriz[0].length; j++) {
      System.out.printf("%6d ", j);
    }
    System.out.println();
    // Imprime as linhas da matriz
    for (int i = 0; i < matriz.length; i++) {
      System.out.printf("%3d: ", i); // Imprime o número da linha
      for (int j = 0; j < matriz[0].length; j++) {
        System.out.printf("%6.2f ", matriz[i][j]); // Imprime os elementos da matriz com 2 casas decimais
      }
      System.out.println();
    }
  }
}