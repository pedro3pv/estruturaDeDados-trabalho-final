package com.example.estruturadedadostrabalhofinal.TechMart;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {
    private No raiz;
    private int ID = 0;
    public void inserir(String name, String descricao, double preco, String categoria) {
        No no = new No(ID,name,descricao,preco,categoria);
        ID++;
        raiz = inserirRec(raiz, no);
    }

    private No inserirRec(No raiz, No no) {
        if (raiz == null) {
            raiz = no;
            return raiz;
        }

        if (no.ID < raiz.ID) {
            raiz.esquerda = inserirRec(raiz.esquerda, no);
        } else if (no.ID > raiz.ID) {
            raiz.direita = inserirRec(raiz.direita, no);
        }

        return raiz;
    }

    public void percorrerEmOrdem(){
        percorrerEmOrdem(raiz);
    }

    public String[] retornarEmOrdem() {
        String[] categorias = new String[ID*5];
        percorrerEmOrdem(raiz, categorias);
        categorias = removerNulos(categorias);
        return categorias;
    }
    private static String[] removerNulos(String[] arrayComNulos) {
        List<String> listaSemNulos = new ArrayList<>();

        // Adiciona valores não nulos à lista
        for (String valor : arrayComNulos) {
            if (valor != null) {
                listaSemNulos.add(valor);
            }
        }

        // Converte a lista para um novo array
        return listaSemNulos.toArray(new String[0]);
    }
    private void percorrerEmOrdem(No no, String[] categorias) {
        if (no != null) {
            percorrerEmOrdem(no.esquerda, categorias);
                categorias[(no.ID*5)+0] = String.valueOf(no.ID);
                categorias[(no.ID*5)+1] = String.valueOf(no.name);
                categorias[(no.ID*5)+2] = String.valueOf(no.descricao);
                categorias[(no.ID*5)+3] = String.valueOf(no.preco);
                categorias[(no.ID*5)+4] = String.valueOf(no.categoria);
            /*arrayList.add(no.ID);
            arrayList.add(no.name);
            arrayList.add(no.descricao);
            arrayList.add(no.preco);
            arrayList.add(no.categoria);*/
            percorrerEmOrdem(no.direita, categorias);
        }
    }

    private void percorrerEmOrdem(No raiz) {
        if (raiz != null) {
            percorrerEmOrdem(raiz.esquerda);
            System.out.print(raiz.ID + " ");
            percorrerEmOrdem(raiz.direita);
        }
    }
    // Adicione o seguinte método para remover um nó pelo ID.
    public void remover(int id) {
        raiz = removerRec(raiz, id);
    }

    private No removerRec(No raiz, int id) {
        // Caso base: se a árvore está vazia
        if (raiz == null) {
            return raiz;
        }

        // Encontrar o nó a ser removido
        if (id < raiz.ID) {
            raiz.esquerda = removerRec(raiz.esquerda, id);
        } else if (id > raiz.ID) {
            raiz.direita = removerRec(raiz.direita, id);
        } else {
            // Nó com apenas um filho ou nenhum filho
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }

            // Nó com dois filhos: encontrar o menor nó na subárvore direita
            raiz.ID = encontrarMenorValor(raiz.direita);

            // Remover o menor nó na subárvore direita
            raiz.direita = removerRec(raiz.direita, raiz.ID);
        }

        return raiz;
    }

    private int encontrarMenorValor(No raiz) {
        int menorValor = raiz.ID;
        while (raiz.esquerda != null) {
            menorValor = raiz.esquerda.ID;
            raiz = raiz.esquerda;
        }
        return menorValor;
    }
}
