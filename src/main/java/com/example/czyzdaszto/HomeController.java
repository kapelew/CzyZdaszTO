package com.example.czyzdaszto;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomeController {
    @FXML
    private Button playQuizButton;

    @FXML
    private void initialize(){

        playQuizButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    Stage thisStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                    thisStage.close();

                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("quiz.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    scene.setFill(Color.TRANSPARENT);

                    stage.show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    public void opt5Clicked(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}