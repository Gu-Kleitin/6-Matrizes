/*16. Uma floricultura conhecedora de sua clientela gostaria de fazer um algoritmo que pudesse controlar
sempre um estoque mínimo de determinadas plantas, pois todos os dias, pela manhã, o dono faz novas
aquisições. Crie um algoritmo que possua as seguintes opções:

==========================================
FLORICULTURA MARIASFLOR
==========================================
1. CADASTRAR NOVA PLANTA
2. RETIRAR PLANTA
3. INSERIR PLANTA
4. IMPRIMIR RELATÓRIO
5. SAIR
===========================================

O algoritmo deve permitir o cadastro de 50 tipos de plantas. Na opção de cadastro, para cada planta, o
algoritmo deve cadastrar um código (inteiro), o nome (string), o estoque ideal e a quantidade atual em
estoque. Na opção retirar planta, o sistema deve permitir a retirada do estoque atual de uma planta,
dado o código digitado pelo usuário, lembre-se de verificar se o estoque é suficiente para atender o
pedido. Para a opção de inserção, seu algoritmo deve atualizar o estoque atual de uma certa planta,
dadas as informações de quantidade comprada e do código da planta que são digitadas pelo usuário.
Na opção de imprimir relatório, seu algoritmo deve imprimir os nomes, os estoques atuais e as
quantidades a serem compradas das plantas que possuem estoque abaixo do ideal.*/
import java.util.Scanner;

public class gustavo16 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] nomes = new String[50]; // Array separado para os nomes das plantas
    int[][] plantas = new int[50][4]; // Matriz para códigos, estoque ideal, estoque atual, etc.
    int totalPlantas = 0;

    while (true) {
      System.out.println("==========================================");
      System.out.println("          FLORICULTURA MARIASFLOR         ");
      System.out.println("==========================================");
      System.out.println("1. CADASTRAR NOVA PLANTA");
      System.out.println("2. RETIRAR PLANTA");
      System.out.println("3. INSERIR PLANTA");
      System.out.println("4. IMPRIMIR RELATÓRIO");
      System.out.println("5. SAIR");
      System.out.println("==========================================");
      System.out.print("Escolha uma opção: ");

      int opcao = scanner.nextInt();

      if (opcao == 1) {
        if (totalPlantas < 50) {
          System.out.print("Digite o código da planta: ");
          plantas[totalPlantas][0] = scanner.nextInt(); // Código da planta
          scanner.nextLine(); // Limpar buffer

          System.out.print("Digite o nome da planta: ");
          nomes[totalPlantas] = scanner.nextLine();

          System.out.print("Digite o estoque ideal: ");
          plantas[totalPlantas][1] = scanner.nextInt(); // Estoque ideal

          System.out.print("Digite a quantidade atual em estoque: ");
          plantas[totalPlantas][2] = scanner.nextInt(); // Estoque atual

          totalPlantas++;
          System.out.println("Planta cadastrada com sucesso!");
        } else {
          System.out.println("Limite de cadastro de plantas atingido.");
        }

      } else if (opcao == 2) { // RETIRAR PLANTA
        System.out.print("Digite o código da planta para retirada: ");
        int codigoRetirar = scanner.nextInt();
        boolean plantaEncontrada = false;

        for (int i = 0; i < totalPlantas; i++) {
          if (plantas[i][0] == codigoRetirar) {
            plantaEncontrada = true;
            System.out.print("Digite a quantidade a ser retirada: ");
            int quantidade = scanner.nextInt();

            if (quantidade <= plantas[i][2]) { // Verifica se o estoque é suficiente
              plantas[i][2] -= quantidade; // Atualiza estoque atual
              System.out.println("Retirada realizada com sucesso!");
            } else {
              System.out.println("Estoque insuficiente.");
            }
            break;
          }
        }
        if (!plantaEncontrada) {
          System.out.println("Planta não encontrada.");
        }

      } else if (opcao == 3) { // INSERIR PLANTA
        System.out.print("Digite o código da planta para inserção: ");
        int codigoInserir = scanner.nextInt();
        boolean plantaEncontrada = false;

        for (int i = 0; i < totalPlantas; i++) {
          if (plantas[i][0] == codigoInserir) {
            plantaEncontrada = true;
            System.out.print("Digite a quantidade comprada: ");
            int quantidade = scanner.nextInt();

            plantas[i][2] += quantidade; // Atualiza estoque atual
            System.out.println("Estoque atualizado com sucesso!");
            break;
          }
        }
        if (!plantaEncontrada) {
          System.out.println("Planta não encontrada.");
        }

      } else if (opcao == 4) { // IMPRIMIR RELATÓRIO
        System.out.println("Relatório de Plantas com Estoque Abaixo do Ideal:");
        for (int i = 0; i < totalPlantas; i++) {
          if (plantas[i][2] < plantas[i][1]) { // Se estoque atual < estoque ideal
            int quantidadeComprar = plantas[i][1] - plantas[i][2];
            System.out.println("Nome: " + nomes[i]);
            System.out.println("Estoque Atual: " + plantas[i][2]);
            System.out.println("Quantidade a ser comprada: " + quantidadeComprar);
            System.out.println("------------------------------------------");
          }
        }

      } else if (opcao == 5) { // SAIR
        System.out.println("Saindo do sistema...");
        break;
      } else {
        System.out.println("Opção inválida. Tente novamente.");
      }
    }
    scanner.close();
  }
}