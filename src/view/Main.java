package view;

import java.util.Scanner;
import model.Categoria;
import model.Item;
import model.Produto;
import model.Venda;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao, contadorItem = 0;
        Venda venda = new Venda();

        do{
            System.out.println("-----Menu de Vendas-----");
            System.out.println("1- Adicionar Item | 2- Remover Item | 3- Valor atual da compra | 4- Produtos adicionados | 0- Finalizar Compra ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1: venda.preencherItem(venda); break;
                case 2: venda.removerItem(venda); break;
                case 3: System.out.println(venda.getTotal()); break;
                case 4: venda.exibirProdutos(); break;
                case 0: System.out.println("Finalizando compra");
                        System.out.println("O valor total da compra foi " + "R$" + venda.getTotal()); break;
            }

        }
        while(opcao != 0);


    }
}