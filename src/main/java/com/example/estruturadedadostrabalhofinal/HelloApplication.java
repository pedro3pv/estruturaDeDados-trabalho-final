package com.example.estruturadedadostrabalhofinal;

import com.example.estruturadedadostrabalhofinal.TechMart.ArvoreBinaria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    private static Stage stage;
    private static Scene mainScreen;
    private static Scene listaScreen;
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlMain = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader fxmlLista = new FXMLLoader(HelloApplication.class.getResource("Tela_ListadeProdutos.fxml"));
        mainScreen = new Scene(fxmlMain.load(), 983, 700);
        listaScreen = new Scene(fxmlLista.load(),983,700);
        primaryStage.setTitle("Estrutura de Dados");
        primaryStage.setScene(mainScreen);
        stage = primaryStage;
        primaryStage.show();
    }

    public static void changeScreen(String scr, ArvoreBinaria arvoreBinaria){
        switch (scr){
            case "main":
                stage.setScene(mainScreen);
                notifyAllListeners("main",arvoreBinaria);
            case "details":
                stage.setScene(listaScreen);
                notifyAllListeners("details",arvoreBinaria);
        }
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();
    public static interface OnChangeScreen{
        void OnChangeScreen(String newScreen, ArvoreBinaria userData);
    }
    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }
    private static void notifyAllListeners(String newScreen, ArvoreBinaria userData){
        for (OnChangeScreen l : listeners){
            l.OnChangeScreen(newScreen,userData);
        }
    }
}