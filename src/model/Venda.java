package model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Venda {

    private Item[] itens;
    private LocalDateTime dataHora;
    private int quantidadeItens;

    public Venda() {
        itens = new Item[3];
        dataHora = LocalDateTime.now();
        quantidadeItens = 0;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < quantidadeItens; i++) {
            total += itens[i].getSubtotal();
        }
        return total;
    }

    public boolean adicionarItem(Item item){
        if(quantidadeItens == itens.length){
            itens = Arrays.copyOf(itens, itens.length+3);
        }
        itens[quantidadeItens++] = item;
        return true;
    }


        public Venda preencherItem(Venda venda) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Código do produto: ");
            int codigoProduto = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Descrição do produto: ");
            String descricao = scanner.nextLine();

            System.out.print("Preço do produto: ");
            double preco = scanner.nextDouble();

            System.out.println("Categorias disponíveis: ALIMENTICIO, HIGIENE, LIMPEZA, HORTIFRUTI, PADARIA");
            System.out.print("Categoria do produto: ");
            String categoriaInput = scanner.next().toUpperCase();
            Categoria categoria = Categoria.valueOf(categoriaInput);

            System.out.print("Quantidade do item: ");
            int quantidade = scanner.nextInt();

            Item item = new Item(codigoProduto,
                    new Produto(codigoProduto, descricao, preco, categoria), quantidade);
            venda.adicionarItem(item);
            System.out.println("Item adicionado com sucesso!");
        return venda;
    }

    public void removerItem(Venda venda){
        Scanner scanner = new Scanner(System.in);
        Item[] itens = venda.getItens();
        boolean itemRemovido = false;
        System.out.print("Informe o nome do item que deseja remover: ");
        String nomeProduto = scanner.nextLine();

        for(int i = 0; i < quantidadeItens; i++){
            Produto produto = itens[i].getProduto();
            if(produto.getDescricao().equals(nomeProduto)){
                for(int k = i; k < quantidadeItens -1; k++){
                    itens[k] = itens[k+1];
                }
                itens[quantidadeItens-1] = null;
                quantidadeItens--;
                itemRemovido = true; break;

            }
        }

    }

    public Item[] getItens() {
        return Arrays.copyOf(itens, quantidadeItens);
    }

    public void exibirProdutos() {
        System.out.println("Produtos na venda:");
        for (int i = 0; i < quantidadeItens; i++) {
            Item item = itens[i];
            Produto produto = item.getProduto();
            System.out.println("Código: " + produto.getCodigo() +
                    ", Produto: " + produto.getDescricao() +
                    ", Preço: R$ " + produto.getPreco() +
                    ", Quantidade: " + item.getQuantidade() +
                    ", Subtotal: R$ " + item.getSubtotal());
        }
    }

}
