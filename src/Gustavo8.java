/*8. Uma matriz quadrada de dimensão n é dita uma matriz permutação se em cada dimensao e em cada dimensao
houver n-1 elementos nulos e um único elemento igual à 1. Dada uma matriz digitada pelo usuário,
informe se a mesma é ou não uma matriz permutação.
Ex.: Matriz permutação:
[0 0 0 1
 1 0 0 0
 0 1 0 0
 0 0 1 0 ]*/

import java.util.Scanner;
public class Gustavo8 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Digite a dimensão da matriz: ");
    int dimensao = sc.nextInt();
    System.out.println("Agora preencha a matriz: " + dimensao + "x" + dimensao);
    //Preenchendo a matriz
    int[][] matriz = new int[dimensao][dimensao];
    for (int i = 0; i < dimensao; i++) {
      for (int j = 0; j < dimensao; j++) {
        System.out.print(" linha: " + (i + 1) + " coluna: " + (j + 1)+" ");
        matriz[i][j] = sc.nextInt();
      }
    }
    // Verifica se a matriz é uma matriz permutação
    boolean ePermutacao = true; // Assume inicialmente que é uma matriz permutação
    for (int i = 0; i < dimensao; i++) {
      int somaLinha = 0;
      int somaColuna = 0;
      for (int j = 0; j < dimensao; j++) {
        somaLinha += matriz[i][j];
        somaColuna += matriz[j][i];
      }
      if (somaLinha != 1 || somaColuna != 1) {
        ePermutacao = false;
        break;
      }
    }
    if (ePermutacao) {
      System.out.println("A matriz é uma matriz permutação.");
    } else {
      System.out.println("A matriz não é uma matriz permutação.");
    }
  }
}
