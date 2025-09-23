package com.example.label;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(40);
        grid.setVgap(30);

        Label lbl1 = new Label("Etiqueta simple");
        grid.add(lbl1, 0, 0);
        GridPane.setHalignment(lbl1, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(lbl1, javafx.geometry.VPos.CENTER);

        Label lbl2 = new Label("Buscar");
        try {
            Image icon = new Image(getClass().getResourceAsStream("/search.png"));
            ImageView iv = new ImageView(icon);
            iv.setFitWidth(32);
            iv.setFitHeight(32);
            iv.setPreserveRatio(true);
            lbl2.setGraphic(iv);
        } catch (Exception ignored) {}
        lbl2.setFont(Font.font("Arial", 24));
        lbl2.setTextFill(Color.BLUE);
        lbl2.setOnMouseEntered(e -> { lbl2.setScaleX(1.2); lbl2.setScaleY(1.2); });
        lbl2.setOnMouseExited(e -> { lbl2.setScaleX(1.0); lbl2.setScaleY(1.0); });
        grid.add(lbl2, 0, 1);
        GridPane.setHalignment(lbl2, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(lbl2, javafx.geometry.VPos.CENTER);

        Label lblExplicacion1 = new Label("<--- Texto con imagen que crece al pasar el ratón");
        lblExplicacion1.setFont(Font.font("Arial", 16));
        lblExplicacion1.setTextFill(Color.DARKGRAY);
        grid.add(lblExplicacion1, 1, 1);

        Label lbl3 = new Label("Esto es un label con un texto demasiado largo que necesita partirse en varias líneas.");
        lbl3.setWrapText(true);
        lbl3.setMaxWidth(250);
        grid.add(lbl3, 0, 2);

        Label lbl4 = new Label("Texto rotado");
        lbl4.setFont(Font.font("Comic Sans MS", 28));
        lbl4.setRotate(270);
        StackPane rotadoBox = new StackPane(lbl4);
        rotadoBox.setMinHeight(120);
        lbl4.setOnMouseEntered(e -> lbl4.setRotate(0));
        lbl4.setOnMouseExited(e -> lbl4.setRotate(270));
        grid.add(rotadoBox, 0, 3);

        Label lbl5 = new Label("Texto de colores");
        lbl5.setFont(Font.font("Arial", 20));
        List<Color> colors = List.of(
                Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.PURPLE,
                Color.BROWN, Color.PINK, Color.CYAN, Color.DARKGOLDENROD, Color.DARKMAGENTA
        );
        Random random = new Random();
        lbl5.setOnMouseEntered(e -> {
            Color c = colors.get(random.nextInt(colors.size()));
            lbl5.setTextFill(c);
        });
        StackPane coloresBox = new StackPane(lbl5);
        coloresBox.setMinHeight(60);
        grid.add(coloresBox, 0, 4);

        Label lblExplicacion2 = new Label("<--- Texto que cambia de color al pasar el ratón");
        lblExplicacion2.setFont(Font.font("Arial", 16));
        lblExplicacion2.setTextFill(Color.DARKGRAY);
        grid.add(lblExplicacion2, 1, 4);

        Label lbl6 = new Label("Texto muy largo para probar el overrun...");
        lbl6.setPrefWidth(150);
        lbl6.setWrapText(false);
        lbl6.setTextOverrun(OverrunStyle.ELLIPSIS);
        lbl6.setTooltip(new Tooltip("Texto muy largo para probar el overrun con puntos suspensivos en JavaFX"));
        grid.add(lbl6, 0, 5);
        GridPane.setHalignment(lbl6, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(lbl6, javafx.geometry.VPos.CENTER);

        Label lblExplicacion3 = new Label("<--- Texto que se corta con '...' al final si no cabe");
        lblExplicacion3.setFont(Font.font("Arial", 16));
        lblExplicacion3.setTextFill(Color.DARKGRAY);
        grid.add(lblExplicacion3, 1, 5);

        Label lbl7 = new Label("Otro texto largo con elipsis...");
        lbl7.setPrefWidth(150);
        lbl7.setWrapText(false);
        lbl7.setTextOverrun(OverrunStyle.CENTER_ELLIPSIS);
        lbl7.setTooltip(new Tooltip("Otro texto largo con elipsis centrada para comparar"));
        grid.add(lbl7, 0, 6);
        GridPane.setHalignment(lbl7, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(lbl7, javafx.geometry.VPos.CENTER);

        Label lblExplicacion4 = new Label("<--- Texto que se corta con '...' en el centro si no cabe");
        lblExplicacion4.setFont(Font.font("Arial", 16));
        lblExplicacion4.setTextFill(Color.DARKGRAY);
        grid.add(lblExplicacion4, 1, 6);

        stage.setScene(new Scene(grid, 800, 600));
        stage.setTitle("Ejemplo Label");
        stage.show();
    }
}
