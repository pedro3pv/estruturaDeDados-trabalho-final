package com.example.estruturadedadostrabalhofinal.TechMart;

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
        return categorias;
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
}
