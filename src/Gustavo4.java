/*4- a produção de uma fábrica é armazenada, semana a semana em uma tabela com o seguinte formato:
        Dia1 Dia 2 ... Dia 7
Semana1
Semana2
:
:
Semana n
Faaça um programa que a partir dos dados contidos na tabela gere o seguinte relatório:
RELATORIO DE PRODUÇÃO RELATIVO À n SEMANAS
Numero de produção media: xxxxx.x
Numero de dias com produção acima da media = XX
INDICAÇÃO DOS DIAS DE MINIMA PRODUÇÃO:
Semana 1........................Dia X
Semana 2........................Dia X
Semana 3........................Dia X
Semana 4........................Dia X
Semana N........................Dia X*0/
 */
import java.util.Scanner;

public class Gustavo4 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o número de semanas: ");
    int numSemanas = scanner.nextInt();

    int[][] tabelaProducao = new int[numSemanas][7];

    // Lê a produção para cada semana e dia
    for (int semana = 0; semana < numSemanas; semana++) {
      System.out.println("\nSemana " + (semana + 1) + ":");
      for (int dia = 0; dia < 7; dia++) {
        System.out.print("Dia " + (dia + 1) + ": ");
        tabelaProducao[semana][dia] = scanner.nextInt();
      }
    }

    // Calcula a produção média
    double producaoMedia = 0;
    int totalProducao = 0;
    for (int semana = 0; semana < numSemanas; semana++) {
      for (int dia = 0; dia < 7; dia++) {
        totalProducao += tabelaProducao[semana][dia];
      }
    }
    producaoMedia = (double) totalProducao / (numSemanas * 7);

    // Conta os dias com produção acima da média
    int diasAcimaMedia = 0;
    for (int semana = 0; semana < numSemanas; semana++) {
      for (int dia = 0; dia < 7; dia++) {
        if (tabelaProducao[semana][dia] > producaoMedia) {
          diasAcimaMedia++;
        }
      }
    }

    // Encontra os dias de mínima produção
    int[] diasMinimaProducao = new int[numSemanas];
    for (int semana = 0; semana < numSemanas; semana++) {
      int diaMinimaProducao = 0;
      for (int dia = 1; dia < 7; dia++) {
        if (tabelaProducao[semana][dia] < tabelaProducao[semana][diaMinimaProducao]) {
          diaMinimaProducao = dia;
        }
      }
      diasMinimaProducao[semana] = diaMinimaProducao;
    }

    System.out.println("\nRELATORIO DE PRODUÇÃO RELATIVO À " + numSemanas + " SEMANAS");
    System.out.println("Número de produção média: " + String.format("%.1f", producaoMedia));
    System.out.println("Número de dias com produção acima da média = " + diasAcimaMedia);
    System.out.println("INDICAÇÃO DOS DIAS DE MINIMA PRODUÇÃO:");
    for (int semana = 0; semana < numSemanas; semana++) {
      System.out.println("Semana " + (semana + 1) + "........................Dia " + (diasMinimaProducao[semana] + 1));
    }
  }
}