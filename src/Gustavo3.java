/*3. Faça um programa que preencha uma matriz A[3][4], e outra matriz B[linhas][colunas]
 em que as dimensões são digitadas pelo usuário. Após isso, verifique se a operação de
 multiplicação de matrizes (A x B)  pode ser realizada, caso seja possível, realize a operação
 e imprima a matriz resultante.*/

/*3. Faça um programa que preencha uma matriz A[3][4], e outra matriz B[linhas][colunas]
 em que as dimensões são digitadas pelo usuário. Após isso, verifique se a operação de
 multiplicação de matrizes (A x B)  pode ser realizada, caso seja possível, realize a operação
 e imprima a matriz resultante.*/

import java.util.Scanner;

public class Gustavo3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double[][] matrizA = new double[3][4];
    System.out.println("Preencha a primeira matriz A (3x4):");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        System.out.print("Elemento [" + i + "][" + j + "]: ");
        matrizA[i][j] = sc.nextDouble();
      }
    }

    System.out.println("Digite o número de linhas da segunda matriz B:");
    int linhasB = sc.nextInt();
    System.out.println("Digite o número de colunas da segunda matriz B:");
    int colunasB = sc.nextInt();

    double[][] matrizB = new double[linhasB][colunasB];
    System.out.println("Preencha a segunda matriz B (" + linhasB + "x" + colunasB + "):");
    for (int i = 0; i < linhasB; i++) {
      for (int j = 0; j < colunasB; j++) {
        System.out.print("Elemento [" + i + "][" + j + "]: ");
        matrizB[i][j] = sc.nextDouble();
      }
    }

    // Verifica se dá pra multiplicar
    if (matrizA[0].length != matrizB.length) {
      System.out.println("A multiplicação de matrizes não é possível.");
      return;
    }

    ImprimirMatriz print = new ImprimirMatriz();
    double[][] matrizC = new double[matrizA.length][matrizB[0].length];

    //multiplicando
    for (int i = 0; i < matrizA.length; i++) {
      for (int j = 0; j < matrizB[0].length; j++) {
        for (int k = 0; k < matrizB.length; k++) {
          matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
        }
      }
    }

    System.out.println("Matriz resultante C:");

    print.imprimirMatriz(matrizC);
  }
}