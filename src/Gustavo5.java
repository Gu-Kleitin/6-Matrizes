/*5. Faça um programa que:
 Receba as notas de 10 alunos em cinco provas diferentes e armazene-as em uma matriz 10 x 5.
 Receba o nome dos 10 alunos e armazene-os em um vetor de string com 10 posições
 Calcule e exiba o nome do aluno, a média das notas do mesmo e a situação:
    o Aprovado: média maior ou igual a 7
    o Reprovado: média menor que 4
    o Exame Especial: média entre 4 e 7*/

import java.util.Scanner;
public class Gustavo5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double Notas[][] = new double[10][5];
    double[] SumNotas = new double[10];
    String[] Nomes = new String[10];
    System.out.println("Preencha o nome, e a nota do aluno em cada matéria");
    for(int i = 0; i < Notas.length; i++){
      System.out.println("Preencha o nome do aluno: ");
      Nomes[i] = sc.nextLine();
      for(int j = 0; j < Notas[0].length; j++){
        int indice = 1;
        indice+= j;
        //System.out.print("Digite a nota "+indice+ " de "+Nomes[i]+" ");
        Notas[i][0] = sc.nextDouble();
        SumNotas[i] += Notas[i][0];
      }
      sc.nextLine();
    }
    //cálculo da média
    double[] Media = new double[10];
    for(int i = 0; i < SumNotas.length; i++){
      Media[i] = SumNotas[i]/5;
    }
    for(int i = 0; i < Nomes.length; i++){
      for(int j = 0; j < Nomes.length; j++){
        if(Media[i]>=7){
          System.out.println("O aluno "+Nomes[i]+" obteve uma média de "+Media[i]+" portanto está aprovado");
          break;
        }
        else if(Media[i]<4){
          System.out.println("O aluno "+Nomes[i]+" obteve uma média de "+Media[i]+" portanto está reprovado");
          break;
        }
        else{
          System.out.println("O aluno "+Nomes[i]+" obteve uma média de "+Media[i]+" portanto está no exame especial");
          break;
        }
      }
    }
  }
}
