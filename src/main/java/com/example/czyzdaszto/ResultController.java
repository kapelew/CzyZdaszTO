package com.example.czyzdaszto;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

public class ResultController {
        @FXML
        public Label remark, marks, marksText,correctAnswers, wrongAnswers;

        @FXML
        public ProgressIndicator correctProgress, wrongProgress;

        @FXML
        public void opt5Clicked(ActionEvent event) {
           Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.close();
        }


        @FXML
        public void opt6Clicked(ActionEvent event) {
            try {
                QuizController.correct = 0;
                QuizController.wrong = 0;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @FXML
        private void initialize(){
            correctAnswers.setText("Poprawnych odpowiedzi:" + String.valueOf(QuizController.correct));
            wrongAnswers.setText("Blednych odpowiedzi:" + String.valueOf(QuizController.wrong));
            marksText.setText("Zdobyte punkty:" + String.valueOf(QuizController.correct));

            marks.setText(QuizController.correct + "/5");

            float correctf = (float) QuizController.correct/5;
            correctProgress.setProgress(correctf);

            float wrongf = (float) QuizController.wrong/5;
            wrongProgress.setProgress(wrongf);

            int correct = QuizController.correct;

            if (correct < 3) {
                remark.setText("Nie udalo ci sie uzyskac zaliczenia odpowiedzi, pocwicz i sprobuj ponownie");
            } else{
                remark.setText("Dobra robota, jestes gotowy na odpowiedz ustna z przedmiotu Technologie Obiektowe!");
            }

        }
    }


