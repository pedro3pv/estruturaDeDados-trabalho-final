package com.example.estruturadedadostrabalhofinal;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.estruturadedadostrabalhofinal.TechMart.ArvoreBinaria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    @FXML
    void limpar(ActionEvent event) {

    }

    @FXML
    void pesquisar(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //listviewform.getItems().addAll(erro);
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, ArvoreBinaria userData) {
                System.out.println("nova tela:"+newScreen+", "+userData);
                String[] dados = new String[Integer.parseInt(String.valueOf(userData.retornarEmOrdem().length/5))];
                int posicao = 0;
                for (int i = 0;i < userData.retornarEmOrdem().length;i += 5){
                    int ID = Integer.parseInt(userData.retornarEmOrdem()[i]);
                    dados[posicao] = "ID:" + userData.retornarEmOrdem()[(ID*5)+0] + " Nome:" + userData.retornarEmOrdem()[(ID*5)+1] + " Preço" + userData.retornarEmOrdem()[(ID*5)+3] + " Categoria:" + userData.retornarEmOrdem()[(ID*5)+4];
                    posicao++;
                }
                listviewform.getItems().addAll(dados);
            }
        });
    }
}
