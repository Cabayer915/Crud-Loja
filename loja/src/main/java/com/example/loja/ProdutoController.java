package com.example.loja;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produtos> produtos = new ArrayList<>();

    public ProdutoController(){
        Produtos produto1 = new Produtos("Nutella", 20.0, 11);
        Produtos produto2 = new Produtos("Shampoo do CR7", 32.0, 5);
        Produtos produto3 = new Produtos("CD Aviões do forro", 19.82, 20);
        Produtos produto4 = new Produtos("CD Celso Portiolli - Tempo de Alegria", 14.50, 25);
        Produtos produto5 = new Produtos("Cadeira gamer de bar (Skol - Amarela)", 60.0, 15);

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);
    }

    @PostMapping
     public Produtos cadastrarProduto(@RequestBody Produtos produto) {
        produto.setValorTotalEstoque(produto.getPreco() * produto.getQtdEstoque());
        produtos.add(produto);
        return produto;
    }

    @GetMapping
    public List<Produtos> getProdutos() {
        return produtos;
    }

    @PutMapping("/{indice}")
    public Produtos atualizarProduto(@PathVariable int indice, @RequestBody Produtos produtoAtualizado) {
        if (indice >= 0 && indice < produtos.size()) {
            Produtos produto = produtos.get(indice);
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setQtdEstoque(produtoAtualizado.getQtdEstoque());
            produto.setValorTotalEstoque(produto.getPreco() * produto.getQtdEstoque());
            return produto;
        } else {
            return null;
        }
    }

    @GetMapping("/estoque/{qtdEstoque}")
    public List<Produtos> getProdutosByEstoque(@PathVariable int qtdEstoque) {
        List<Produtos> produtosEstoque = new ArrayList<>();
        for (Produtos produto : produtos) {
            if (produto.getQtdEstoque() >= qtdEstoque) {
                produtosEstoque.add(produto);
            }
        }
        return produtosEstoque;
    }
}