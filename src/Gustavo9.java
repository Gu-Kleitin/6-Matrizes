/*9. Faça um programa que carregue uma matriz 8 x 8 com números reias e mostre uma mensagem dizendo se
a matriz é ou não simétrica. Uma matriz é simétrica se para todas as posições da mesma, tem-se a relação
A[i][j] = A[j][i].*/
import java.util.Scanner;

public class Gustavo9 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double[][] A = new double[8][8];
    System.out.println("Preencha a matriz 8x8: ");
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        A[i][j] = sc.nextDouble();
      }
    }
    boolean eSimetrica = true; // Assume que a matriz é simétrica inicialmente
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A[0].length; j++) {
        if (A[i][j] != A[j][i]) {
          eSimetrica = false;
          break; // Interrompe os loops se a matriz não for simétrica
        }
      }
      if (!eSimetrica) { // Se a matriz não for simétrica, interrompe o loop externo também
        break;
      }
    }
    if (eSimetrica) {
      System.out.println("A matriz é simétrica.");
    } else {
      System.out.println("A matriz não é simétrica.");
    }
  }
}


/*
    double sumLinha = 0;
    double sumColuna = 0;
    boolean Simetrico = true;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        sumLinha += A[i][j];
        sumColuna += A[j][i];
      }
      if (sumLinha != sumColuna) {
        Simetrico = false;
        break;
      }
    }
    if (Simetrico) {
      System.out.println("É uma matriz simétrica");
    }
    else{
      System.out.println("Não é simétrica");
    }

    tinha feito assim, mas confundi a lógica*/