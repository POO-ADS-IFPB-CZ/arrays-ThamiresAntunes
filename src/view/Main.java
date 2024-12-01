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
                case 3:
                    System.out.println(venda.getTotal()); break;
                case 4: venda.exibirProdutos(); break;
                case 0: System.out.println("Finalizando compra");
                        System.out.println("O valor total da compra foi " + "R$" + venda.getTotal()); break;
            }

        }
        while(opcao != 0);

        System.out.println("Foram comprados " + contadorItem + " itens");




/*
        do{

            System.out.println("Informe o codigo, o nome, o preço e a quantidade do item desejado: ");
            int codigo = scanner.nextInt();
            String descricao = scanner.next();
            double preco = scanner.nextDouble();
            int quantidade = scanner.nextInt();
            contadorItem++;


            boolean categoriaValida = false;
            Categoria categoriaSelecionada = null;
            do{
                System.out.println("Informe qual das categorias abaixo o item faz parte: ");
                for(Categoria categoria : Categoria.values()){
                    System.out.println(categoria);
                    String categoriaInput = scanner.nextLine().toUpperCase();
                    if(categoria.name().equals(categoriaInput)){
                        categoriaSelecionada = categoria;
                        categoriaValida = true;
                        break;
                    }
                }
                if(categoriaValida != true){
                    System.out.println("Categoria invalida");
                }
            }
            while(categoriaValida != true);

            venda.adicionarItem(
                    new Item(contadorItem,
                            new Produto(codigo, descricao, preco, categoriaSelecionada), quantidade)
                    );
            System.out.println("Digite 1 para continuar comprando ou 0 para finalizar a compra");
            opcao = scanner.nextInt();
        }
        while(opcao != 0);

        System.out.println("Foram comprados " + contadorItem + " itens");
        System.out.println("O valor total da compra foi " + "R$" + venda.getTotal());

*/

        /*
        Venda venda = new Venda();
        venda.adicionarItem(
                new Item(1,
                    new Produto(1, "Arroz",
                        6.20, Categoria.ALIMENTICIO),
                3));
        System.out.println(venda.getTotal());

         */
    }
}