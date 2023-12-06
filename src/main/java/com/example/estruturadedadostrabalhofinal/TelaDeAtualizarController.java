package com.example.estruturadedadostrabalhofinal;

import com.example.estruturadedadostrabalhofinal.TechMart.ArvoreBinaria;
import com.example.estruturadedadostrabalhofinal.TechMart.PersistenciaDaArvoreBinaria;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TelaDeAtualizarController implements Initializable {
    @FXML
    private ChoiceBox<String> categoriaItem;

    @FXML
    private TextArea descItem;

    @FXML
    private TextField nomeItem;

    @FXML
    private TextField precoItem;
    private String[] categorias = {"eletronicos","eletrodomesticos","acessorios"};
    private ArrayList<String> retornoArvoreBinaria;
    private ArvoreBinaria arvoreBinaria;
    private int iD;

    @FXML
    void atualizarItem(ActionEvent event) {
        if (!Objects.equals(nomeItem.getText(), "") && !Objects.equals(descItem.getText(), "") && !Objects.equals(precoItem.getText(), "") && !Objects.equals(categoriaItem.getValue(), "")) {
            arvoreBinaria.remover(iD);
            arvoreBinaria.inserir(nomeItem.getText(), descItem.getText(), Double.parseDouble(precoItem.getText()), categoriaItem.getValue());
            for (int i = 0; i < arvoreBinaria.retornarEmOrdem().length; i++) {
                System.out.println(arvoreBinaria.retornarEmOrdem()[i]);
            }
            PersistenciaDaArvoreBinaria.salvarArvoreBinaria(arvoreBinaria, "./arvoreBinaria.dat");
            HelloApplication.changeScreen("details",arvoreBinaria,-1,-1);
        }
    }

    @FXML
    void cancelarAtualizacao(ActionEvent event) {
        HelloApplication.changeScreen("details",arvoreBinaria,-1,-1);
    }

    @FXML
    void excluirItem(ActionEvent event) {
        System.out.println(iD);
        arvoreBinaria.remover(iD);
        PersistenciaDaArvoreBinaria.salvarArvoreBinaria(arvoreBinaria, "./arvoreBinaria.dat");
        HelloApplication.changeScreen("details",arvoreBinaria,-1,-1);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {

            @Override
            public void OnChangeScreen(String newScreen, ArvoreBinaria userData, int ID,int IDFake) {
                if (ID >= 0) {
                    iD = ID;
                    arvoreBinaria = userData;
                    String[] retorno = arvoreBinaria.retornarEmOrdem();
                    retornoArvoreBinaria = new ArrayList<>(List.of(userData.retornarEmOrdem()));
                    categoriaItem.getItems().clear();
                    categoriaItem.getItems().addAll(categorias);
                    nomeItem.setText(retorno[(IDFake * 5) + 1]);
                    descItem.setText(retorno[(IDFake * 5) + 2]);
                    precoItem.setText(retorno[(IDFake * 5) + 3]);
                    categoriaItem.setValue(retorno[(IDFake * 5) + 4]);
                }
            }
        });
    }
}
