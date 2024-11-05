package com.example.missaoo4;

import java.util.List;

public class FlowerService {
    public List<Flower> getFlowers() {
        return List.of(
                new Flower("Margarida", "Flor comum encontrada em prados.", "/images/margarida.jpg"),
                new Flower("Lírio", "Flor elegante, símbolo de pureza.", "/images/lirio.jpg"),
                new Flower("Rosa", "Simboliza amor e carinho.", "/images/rosa.jpg"),
                new Flower("Orquídea", "Flor exótica e diversificada.", "/images/orquidea.jpg"),
                new Flower("Girassol", "Flor que segue o sol, simboliza adoração.", "/images/girassol.jpg")
        );
    }
}
