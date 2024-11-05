package com.example.missaoo4;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FlowerController {

    @FXML
    private VBox mainContainer;

    private FlowerService flowerService;

    public void initialize() {
        flowerService = new FlowerService();

        // Cria o botão "Flores" para seleção individual de flores
        Button flowerButton = new Button("Flores");
        flowerButton.getStyleClass().add("button");  // Aplica a classe CSS para o estilo floral
        flowerButton.setOnAction(e -> showFlowerSelectionDialog());

        // Cria o botão "Ver Todas as Flores" para exibir a lista completa
        Button allFlowersButton = new Button("Ver Todas as Flores");
        allFlowersButton.getStyleClass().add("button");  // Aplica a classe CSS para o estilo floral
        allFlowersButton.setOnAction(e -> showAllFlowersDialog());

        // Adiciona os botões em um VBox centralizado e espaçado
        VBox buttonBox = new VBox(15, flowerButton, allFlowersButton);  // Espaçamento maior para visual agradável
        buttonBox.setAlignment(Pos.CENTER);

        // Adiciona o VBox dos botões ao contêiner principal
        mainContainer.getChildren().add(buttonBox);
    }

    // Abre a caixa de diálogo para seleção de flores
    private void showFlowerSelectionDialog() {
        Stage allFlowersStage = new Stage();
        allFlowersStage.setTitle("Flores");

        ListView<Flower> listView = new ListView<>();
        listView.getItems().addAll(flowerService.getFlowers());

        // Define a célula personalizada para exibir imagem, nome e descrição
        listView.setCellFactory(param -> new ListFlower());

        VBox dialogVBox = new VBox(listView);
        dialogVBox.setAlignment(Pos.CENTER);
        dialogVBox.setSpacing(10);

        Scene dialogScene = new Scene(dialogVBox, 400, 400);
        dialogScene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        allFlowersStage.setScene(dialogScene);
        allFlowersStage.show();
    }

    // Abre uma janela para exibir todas as flores em uma lista
    private void showAllFlowersDialog() {
        Stage allFlowersStage = new Stage();
        allFlowersStage.setTitle("Lista Completa de Flores");

        ListView<Flower> listView = new ListView<>();
        listView.getItems().addAll(flowerService.getFlowers());

        // Define a célula personalizada para exibir imagem, nome e descrição
        listView.setCellFactory(param -> new FlowerCell());

        VBox dialogVBox = new VBox(listView);
        dialogVBox.setAlignment(Pos.CENTER);
        dialogVBox.setSpacing(10);

        Scene dialogScene = new Scene(dialogVBox, 400, 400);

        // Adiciona o CSS para o estilo floral
        dialogScene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        allFlowersStage.setScene(dialogScene);
        allFlowersStage.show();
    }
}
