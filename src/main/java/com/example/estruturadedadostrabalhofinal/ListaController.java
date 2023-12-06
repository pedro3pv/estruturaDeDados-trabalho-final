package com.example.estruturadedadostrabalhofinal;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.estruturadedadostrabalhofinal.TechMart.ArvoreBinaria;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    private ArrayList<String> retornoArvoreBinaria;
    private ArrayList<String> dadosLista;
    private ArvoreBinaria arvoreBinaria;
    private String currentSelection;

    @FXML
    void limpar(ActionEvent event) {
        IDForm.setText("");
        nomeForm.setText("");
        catFiltro.setValue("");
        listviewform.getItems().clear();
        listviewform.getItems().addAll(dadosLista);
    }

    @FXML
    void pesquisar(ActionEvent event) {
        int ID = -1;
        if (!Objects.equals(IDForm.getText(), "")){
            ID = Integer.parseInt(IDForm.getText());
        }
        pesquisar(ID,nomeForm.getText(),catFiltro.getValue());
    }

    @FXML
    void voltarAoCadastro(ActionEvent event) {
        HelloApplication.changeScreen("main",arvoreBinaria,-1,-1);
    }

    private void pesquisar(int ID,String nome,String Categoria){
        ArrayList<String> resposta = new ArrayList<>();
        boolean idvalido = ID >= 0;
        boolean nomevalido = !Objects.equals(nome, "");
        boolean catvalido = !Objects.equals(Categoria, null);
        System.out.println(idvalido);
        System.out.println(nomevalido);
        System.out.println(catvalido);
        if (idvalido && nomevalido && catvalido){
                for (int j = 0;j < retornoArvoreBinaria.size();j += 5){
                    int iD = Integer.parseInt(retornoArvoreBinaria.get(j));
                    if (Integer.parseInt(retornoArvoreBinaria.get((iD * 5) + 0)) == ID && Objects.equals(retornoArvoreBinaria.get((iD * 5) + 1), nome) && Objects.equals(retornoArvoreBinaria.get((iD * 5) + 4), Categoria)){
                        resposta.add("ID:" + retornoArvoreBinaria.get((iD*5)+0) + " Nome:" + retornoArvoreBinaria.get((iD*5)+1) + " Preço" + retornoArvoreBinaria.get((iD*5)+3) + " Categoria:" + retornoArvoreBinaria.get((iD*5)+4));
                    }
                }
        } else if (idvalido && nomevalido) {
            for (int j = 0;j < retornoArvoreBinaria.size();j += 5){
                int iD = Integer.parseInt(retornoArvoreBinaria.get(j));
                if (Integer.parseInt(retornoArvoreBinaria.get((iD * 5) + 0)) == ID && Objects.equals(retornoArvoreBinaria.get((iD * 5) + 1), nome)){
                    resposta.add("ID:" + retornoArvoreBinaria.get((iD*5)+0) + " Nome:" + retornoArvoreBinaria.get((iD*5)+1) + " Preço" + retornoArvoreBinaria.get((iD*5)+3) + " Categoria:" + retornoArvoreBinaria.get((iD*5)+4));
                }
            }
        } else if (idvalido && catvalido) {
            for (int j = 0;j < retornoArvoreBinaria.size();j += 5){
                int iD = Integer.parseInt(retornoArvoreBinaria.get(j));
                if (Integer.parseInt(retornoArvoreBinaria.get((iD * 5) + 0)) == ID && Objects.equals(retornoArvoreBinaria.get((iD * 5) + 4), Categoria)){
                    System.out.println("aqui");
                    resposta.add("ID:" + retornoArvoreBinaria.get((iD*5)+0) + " Nome:" + retornoArvoreBinaria.get((iD*5)+1) + " Preço" + retornoArvoreBinaria.get((iD*5)+3) + " Categoria:" + retornoArvoreBinaria.get((iD*5)+4));
                }
            }
        } else if (nomevalido && catvalido) {
            for (int j = 0;j < retornoArvoreBinaria.size();j += 5){
                int iD = Integer.parseInt(retornoArvoreBinaria.get(j));
                if (Objects.equals(retornoArvoreBinaria.get((iD * 5) + 1), nome) && Objects.equals(retornoArvoreBinaria.get((iD * 5) + 4), Categoria)){
                    resposta.add("ID:" + retornoArvoreBinaria.get((iD*5)+0) + " Nome:" + retornoArvoreBinaria.get((iD*5)+1) + " Preço" + retornoArvoreBinaria.get((iD*5)+3) + " Categoria:" + retornoArvoreBinaria.get((iD*5)+4));
                }
            }
        } else if (idvalido && !nomevalido && !catvalido) {
            System.out.println("aqui");
            for (int j = 0; j < retornoArvoreBinaria.size(); j += 5) {
                int iD = Integer.parseInt(retornoArvoreBinaria.get(j));
                if (Integer.parseInt(retornoArvoreBinaria.get((iD * 5) + 0)) == ID) {
                    resposta.add("ID:" + retornoArvoreBinaria.get((iD*5)+0) + " Nome:" + retornoArvoreBinaria.get((iD*5)+1) + " Preço" + retornoArvoreBinaria.get((iD*5)+3) + " Categoria:" + retornoArvoreBinaria.get((iD*5)+4));
                }
            }
        } else if (nomevalido && !catvalido && ID < 0) {
            for (int j = 0; j < retornoArvoreBinaria.size(); j += 5) {
                int iD = Integer.parseInt(retornoArvoreBinaria.get(j));
                if (Objects.equals(retornoArvoreBinaria.get((iD * 5) + 1), nome)) {
                    resposta.add("ID:" + retornoArvoreBinaria.get((iD*5)+0) + " Nome:" + retornoArvoreBinaria.get((iD*5)+1) + " Preço" + retornoArvoreBinaria.get((iD*5)+3) + " Categoria:" + retornoArvoreBinaria.get((iD*5)+4));
                }
            }
        } else if (catvalido && !nomevalido && ID < 0) {
            for (int j = 0; j < retornoArvoreBinaria.size(); j += 5) {
                int iD = Integer.parseInt(retornoArvoreBinaria.get(j));
                if (Objects.equals(retornoArvoreBinaria.get((iD * 5) + 4), Categoria)) {
                    resposta.add("ID:" + retornoArvoreBinaria.get((iD*5)+0) + " Nome:" + retornoArvoreBinaria.get((iD*5)+1) + " Preço" + retornoArvoreBinaria.get((iD*5)+3) + " Categoria:" + retornoArvoreBinaria.get((iD*5)+4));
                }
            }
        } else if (!idvalido && !nomevalido && !catvalido){
            System.out.println("error");
            System.out.println(ID);
            System.out.println(nome);
            System.out.println(Categoria);

        }
        if (resposta.size() == 0){
            resposta.add("Nenhum produto encontrado");
        } /*else if (resposta.size() > 0){
            for (int i = 0; i < resposta.size(); i++) {
                for (int j = i+1; j < resposta.size(); j++) {
                    if (Objects.equals(resposta.get(i), resposta.get(j))){
                        resposta.remove(j);
                    }
                }
            }
        }*/
        listviewform.getItems().clear();
        listviewform.getItems().addAll(resposta);
        System.out.println(resposta);
        resposta.clear();
        listviewform.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //listviewform.getItems().addAll(erro);
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, ArvoreBinaria userData, int ID,int IDFake) {
                arvoreBinaria = userData;
                String[] retorno = userData.retornarEmOrdem();
                retornoArvoreBinaria = new ArrayList<>(List.of(userData.retornarEmOrdem()));
                String[] dados = new String[Integer.parseInt(String.valueOf(retorno.length/5))];
                String[] realID = new String[Integer.parseInt(String.valueOf(retorno.length/5))];
                ArrayList<String> categorias = new ArrayList();
                int posicao = 0;
                boolean duplo = false;
                for (int i = 0;i < retorno.length/5;i++){
                    int iD = i;
                    dados[posicao] = "ID:" + retorno[(iD*5)+0] + " Nome:" + retorno[(iD*5)+1] + " Preço" + retorno[(iD*5)+3] + " Categoria:" + retorno[(iD*5)+4];
                    realID[posicao] = retorno[(iD*5)+0];
                    duplo = false;
                    for (String j : categorias){
                        if (Objects.equals(j, retorno[(iD * 5) + 4])){
                            duplo = true;
                        }
                    }
                    if (!duplo) {
                        categorias.add(retorno[(iD * 5) + 4]);
                    }
                    posicao++;
                }
                catFiltro.getItems().clear();
                catFiltro.getItems().addAll(categorias);
                listviewform.getItems().clear();
                listviewform.getItems().addAll(dados);
                dadosLista = new ArrayList<>(List.of(dados));
                listviewform.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                        currentSelection = listviewform.getSelectionModel().getSelectedItem();
                        for (int i = 0;i<dadosLista.size();i++){
                            if (Objects.equals(dadosLista.get(i), currentSelection)){
                                HelloApplication.changeScreen("atualizar",arvoreBinaria,Integer.parseInt(realID[i]),i);
                            }
                        }
                    }
                });
            }
        });
    }
}
