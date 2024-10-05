/*2. Faça um programa que preencha uma matriz 3 x 5 com números reais. Some os valores de cada linha e
armazene em um vetor. A seguir, mostre qual a linha que tem maior valor somado.*/
import java.util.Scanner;

public class Gustavo2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double Matriz[][] = new double[3][5];
    double VetSum[] = new double[3];
    System.out.println("Preencha a matriz 3x5 com números reais: ");
    for(int i=0; i<Matriz.length;i++){
      for (int j = 0; j < Matriz[0].length; j++) {
        int Ind = i+1;
        int Jind = j+1;
        System.out.printf("Elemento ["+ Ind + "]["+ Jind+"]: ");
        Matriz[i][j] = sc.nextInt();
        VetSum[i] += Matriz[i][j];
      }
    }

    int linhaMV = 0;
    double maiorValor = VetSum[0];
    for (int i = 1; i < VetSum.length; i++) {
      if (VetSum[i] > maiorValor) {
        maiorValor = VetSum[i];
        linhaMV = i;
      }
    }
    System.out.println("Soma dos valores de cada linha:");
    for (int i = 0; i < VetSum.length; i++) {
      System.out.println("Linha " + (i + 1) + ": " + VetSum[i]);
    }
    System.out.println("Linha com o maior valor: " + (linhaMV + 1));
  }

}
