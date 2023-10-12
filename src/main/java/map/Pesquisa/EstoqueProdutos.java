package main.java.map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
  //atributos
  private Map<Long, Produto> estoqueProdutosMap;

  public EstoqueProdutos() {
    this.estoqueProdutosMap = new HashMap<>();
  }
  public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
    estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
  }
  public void exibirProdutos() {
    System.out.println(estoqueProdutosMap);
  }
  public double calcularValorTotalEstoque() {
    double valorTotalEstoque = 0;
    if (!estoqueProdutosMap.isEmpty()) {
      for (Produto p : estoqueProdutosMap.values()) {
        valorTotalEstoque += p.getQuantidade() * p.getPreco();
      }
    }
    return valorTotalEstoque;
  }

  public Produto obterProdutoMaisCaro() {
    Produto produtoMaisCaro = null;
    double maiorPreco = Double.MIN_VALUE;
    for(Produto p : estoqueProdutosMap.values()) {
      if (p.getPreco() > maiorPreco) {
        produtoMaisCaro = p;
        maiorPreco = p.getPreco();
      }
    }
    return produtoMaisCaro;
  }

  public static void main(String[] args) {
    EstoqueProdutos estoque = new EstoqueProdutos();

    // Exibe o estoque vazio
    estoque.exibirProdutos();

    // Adiciona produtos ao estoque
    estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
    estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
    estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
    estoque.adicionarProduto(4L, "Teclado", 2, 40.0);

    estoque.exibirProdutos();

    // Calcula e exibe o valor total do estoque
    System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

    // Obtém e exibe o produto mais caro
    Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
    System.out.println("Produto mais caro: " + produtoMaisCaro);
  }
}
