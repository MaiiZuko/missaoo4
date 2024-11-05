package com.example.missaoo4;

import javafx.scene.control.ListCell;

public class ListViewCell extends ListCell<Flower> {
    @Override
    protected void updateItem(Flower flower, boolean empty) {
        super.updateItem(flower, empty);

        if (empty || flower == null) {
            setText(null);
        } else {
            setText(flower.getName());  // Exibe apenas o nome da flor
        }
    }
}
