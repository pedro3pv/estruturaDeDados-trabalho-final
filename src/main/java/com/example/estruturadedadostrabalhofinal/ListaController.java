package com.example.estruturadedadostrabalhofinal;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.estruturadedadostrabalhofinal.TechMart.ArvoreBinaria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ListaController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField IDForm;

    @FXML
    private ChoiceBox<String> catFiltro;

    @FXML
    private ListView<String> listviewform;

    @FXML
    private TextField nomeForm;

    String[] erro = {"error","error","error"};
    public void setArvoreBinaria(ArvoreBinaria arvoreBinaria) {
        //System.out.println(arvoreBinaria.retornarEmOrdem());
        listviewform.getItems().addAll(arvoreBinaria.retornarEmOrdem());
    }

    @FXML
    void limpar(ActionEvent event) {

    }

    @FXML
    void pesquisar(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //listviewform.getItems().addAll(erro);
    }
}
