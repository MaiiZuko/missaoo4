package com.example.missaoo4;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FlowerCell extends ListCell<Flower> {
    private HBox content;
    private ImageView imageView;
    private VBox detailsBox;
    private Label nameLabel;
    private Label descriptionLabel;

    public FlowerCell() {
        imageView = new ImageView();
        imageView.setFitWidth(60);  // Ajuste conforme necessário
        imageView.setFitHeight(60);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        nameLabel = new Label();
        nameLabel.getStyleClass().add("flower-name");

        descriptionLabel = new Label();
        descriptionLabel.getStyleClass().add("flower-description");

        detailsBox = new VBox(nameLabel, descriptionLabel);
        detailsBox.setSpacing(5);

        content = new HBox(10, imageView, detailsBox);
        content.setPadding(new Insets(10));
    }

    @Override
    protected void updateItem(Flower flower, boolean empty) {
        super.updateItem(flower, empty);

        if (empty || flower == null) {
            setGraphic(null);
        } else {
            imageView.setImage(new Image(flower.getImagePath()));
            nameLabel.setText(flower.getName());
            descriptionLabel.setText(flower.getDescription());

            setGraphic(content);
        }
    }
}
