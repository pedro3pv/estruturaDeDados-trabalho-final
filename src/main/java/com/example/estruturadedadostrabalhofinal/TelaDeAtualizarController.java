package com.example.estruturadedadostrabalhofinal;

import com.example.estruturadedadostrabalhofinal.TechMart.ArvoreBinaria;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaDeAtualizarController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, ArvoreBinaria userData) {
                System.out.println("nova tela:"+newScreen+", "+userData);
            }
        });
    }
}
