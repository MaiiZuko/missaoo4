package com.example.missaoo4;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListFlower extends ListCell<Flower> {
    private HBox content;
    private ImageView imageView;
    private VBox detailsBox;
    private Label nameLabel;
    private Label descriptionLabel;

    public ListFlower() {
        imageView = new ImageView();
        imageView.setFitWidth(50);  // Tamanho da imagem pequeno e fofo
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);

        nameLabel = new Label();
        nameLabel.getStyleClass().add("flower-name");  // Aplica estilo de nome fofo

        descriptionLabel = new Label();
        descriptionLabel.getStyleClass().add("flower-description");  // Aplica estilo de descrição

        // Configura detalhes apenas com o nome por padrão
        detailsBox = new VBox(nameLabel);
        detailsBox.setSpacing(5);

        // Configura o conteúdo inicial com apenas o nome
        content = new HBox(10, detailsBox);
        content.setPadding(new Insets(10));
        content.getStyleClass().add("flower-cell");  // Aplica estilo de célula
    }

    @Override
    protected void updateItem(Flower flower, boolean empty) {
        super.updateItem(flower, empty);

        if (empty || flower == null) {
            setGraphic(null);
        } else {
            nameLabel.setText(flower.getName());

            // Exibe imagem e descrição apenas se selecionado
            if (isSelected()) {
                descriptionLabel.setText(flower.getDescription());
                imageView.setImage(new Image(flower.getImagePath()));

                if (!detailsBox.getChildren().contains(descriptionLabel)) {
                    detailsBox.getChildren().add(descriptionLabel);
                }
                if (!content.getChildren().contains(imageView)) {
                    content.getChildren().add(0, imageView);  // Adiciona a imagem à esquerda
                }
            } else {
                // Remove imagem e descrição se não estiver selecionado
                detailsBox.getChildren().remove(descriptionLabel);
                content.getChildren().remove(imageView);
            }

            setGraphic(content);  // Define o layout personalizado para a célula
        }
    }
}
