/*6. O desvio padrão de uma amostra de dados calcula o quanto de variação existe da amostra em relação à
média. Valores baixos indicam que os dados tendem a estar próximos à média, por outro lado, valores
altos indicam maior dispersão dos dados. O gerente de produção da Refrigerator Tabajará está avaliando
o processo de fabricação de seus refrigerantes em lata, especificamente a etapa de preenchimento do
conteúdo. As latas devem possuir 390 ml, com desvio padrão de + ou – 5 ml. Na análise foram coletadas
20 amostras aleatórias das 6 linhas de produção da fábrica, medindo-se a quantidade de produto das
mesmas. Você é o programador da empresa, e ficou incumbido de implementar um programa que auxilie
seu gerente, mostrando ao mesmo a média e o desvio padrão de cada linha de produção. Além disso,
exiba, se for o caso, qual das linhas de produção precisa ser revisada.*/

import java.util.Scanner;

public class Gustavo6 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double DPE = 5;
    System.out.println("Vamos calcular o desvio padrão do enchimento das latas");
    System.out.println("Nossa amostra contém 20 latas, preencha quantos mL cada uma tem: ");
    int[][] mLs = new int[6][20];
    for (int i = 0; i < mLs.length; i++) {
      System.out.println("Linha " + (i + 1) + ":");
      for (int j = 0; j < mLs[0].length; j++) {
        mLs[i][j] = sc.nextInt();
      }
    }

    // Calcula a média de cada linha
    double[] medias = new double[mLs.length];
    for (int i = 0; i < mLs.length; i++) {
      int somaLinha = 0;
      for (int j = 0; j < mLs[0].length; j++) {
        somaLinha += mLs[i][j];
      }
      medias[i] = (double) somaLinha / mLs[0].length;
    }

    // Calcula o desvio padrão de cada linha
    double[] desviosPadrao = new double[mLs.length];
    for (int i = 0; i < mLs.length; i++) {
      double diferenca = 0;
      for (int j = 0; j < mLs[0].length; j++) {
        diferenca += Math.pow((mLs[i][j] - medias[i]), 2);
      }
      double varianca = diferenca / mLs[0].length; // Divide pela quantidade de amostras
      desviosPadrao[i] = Math.sqrt(varianca);
    }

    //média e o desvio padrão de cada linha
    for (int i = 0; i < mLs.length; i++) {
      System.out.println("Linha " + (i + 1) + ":");
      System.out.format("Média: %.2f\n", medias[i]);
      System.out.format("Desvio Padrão: %.2f\n", desviosPadrao[i]);

      // Verifica se o desvio padrão está dentro do limite
      if (desviosPadrao[i] > DPE) {
        System.out.println("A linha de produção precisa ser revisada.\n");
      }
      else {
        System.out.println("A linha de produção está dentro dos padrões.\n");
      }
    }
  }
}