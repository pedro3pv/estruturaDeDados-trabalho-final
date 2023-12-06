package com.example.estruturadedadostrabalhofinal.TechMart;

import java.io.*;

public class PersistenciaDaArvoreBinaria {

    public static void salvarArvoreBinaria(ArvoreBinaria arvoreBinaria, String nomeArquivo) {
        try {
            FileOutputStream fos = new FileOutputStream(nomeArquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(arvoreBinaria);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static ArvoreBinaria carregarArvoreBinaria(String nomeArquivo) {
        ArvoreBinaria arvoreBinaria = null;
        try {
            FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            arvoreBinaria = (ArvoreBinaria) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
            return new ArvoreBinaria();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Classe não encontrada");
            c.printStackTrace();
            return null;
        }
        return arvoreBinaria;
    }
}