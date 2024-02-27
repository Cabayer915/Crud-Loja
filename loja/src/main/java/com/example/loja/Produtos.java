package com.example.loja;

public class Produtos {
    private String nome;
    private double preco;
    private int qtdEstoque;
    private double valorTotalEstoque;

    public Produtos() {
    }

    public Produtos(String nome, double preco, int qtdEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.valorTotalEstoque = preco * qtdEstoque;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getValorTotalEstoque() {
        return valorTotalEstoque;
    }

    public void setValorTotalEstoque(double valorTotalEstoque) {
        this.valorTotalEstoque = valorTotalEstoque;
    }
}