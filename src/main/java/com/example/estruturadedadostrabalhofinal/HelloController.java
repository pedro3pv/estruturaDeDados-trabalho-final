package com.example.estruturadedadostrabalhofinal;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.estruturadedadostrabalhofinal.TechMart.ArvoreBinaria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> cateForm;

    @FXML
    private TextArea descForm;

    @FXML
    private TextField nomeForm;

    @FXML
    private TextField precoForm;

    private ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
    private Parent root;

    private String[] categorias = {"eletronicos","eletrodomesticos","acessorios"};

    @FXML
    protected void cadastroDeProduto(ActionEvent event) {
        if (!Objects.equals(nomeForm.getText(), "") && !Objects.equals(descForm.getText(), "") && !Objects.equals(precoForm.getText(), "") && !Objects.equals(cateForm.getValue(), "")) {
            arvoreBinaria.inserir(nomeForm.getText(), descForm.getText(), Double.parseDouble(precoForm.getText()), cateForm.getValue());
            System.out.println("cadastro");
        }
    }

    @FXML
    protected void limparForm(ActionEvent event) {
        nomeForm.setText("");
        descForm.setText("");
        precoForm.setText("");
        System.out.println("limpou");
    }

    @FXML
    void teladois(ActionEvent event) {
        HelloApplication.changeScreen("details",arvoreBinaria,-1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, ArvoreBinaria userData, int ID) {
                System.out.println("nova tela:"+newScreen+", "+userData);
                arvoreBinaria = userData;
            }
        });
        cateForm.getItems().addAll(categorias);
    }
}
