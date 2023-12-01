package com.example.estruturadedadostrabalhofinal.TechMart;

public class No {
    public int ID;
    public String name;
    public String descricao;
    public double preco;
    public String categoria;
    public No direita = null;
    public No esquerda = null;

    public No(int ID, String name, String descricao, double preco, String categoria) {
        this.ID = ID;
        this.name = name;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "No{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", categoria='" + categoria + '\'' +
                ", direita=" + direita +
                ", esquerda=" + esquerda +
                '}';
    }
}
