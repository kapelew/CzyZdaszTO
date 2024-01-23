package com.example.czyzdaszto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuizController {

    @FXML
    public Label question;
    @FXML
    public Button opt1, opt2, opt3, opt4;

    private static QuizController instance;
    private List<Question> easyQuestions;
    private List<Question> hardQuestions;
    private Question currentQuestion;
    private int counter = 0;
    public static int correct = 0;
    public static int wrong = 0;


    // Singleton pattern
    public QuizController() {
        easyQuestions = new ArrayList<>();
        hardQuestions = new ArrayList<>();

        easyQuestions.add(new Question("Co to jest wzorzec projektowy?", Arrays.asList( "Język programowania", "Sposób na rozwiązanie częstego problemu programistycznego", "Biblioteka kodu", "Rodzaj algorytmu"), "Sposób na rozwiązanie częstego problemu programistycznego"));
        easyQuestions.add(new Question("Co to jest klasa?", Arrays.asList("Metoda w programowaniu", "Typ danych", "Zmienna", "Szablon do tworzenia obiektów"), "Szablon do tworzenia obiektów"));
        easyQuestions.add(new Question("Co to jest obiekt?", Arrays.asList("Instancja klasy", "Funkcja", "Pętla", "Warunek"), "Instancja klasy"));
        easyQuestions.add(new Question("Co to jest hermetyzacja?", Arrays.asList("Tworzenie interfejsów", "Dziedziczenie klas","Ukrywanie wewnętrznej struktury obiektu", "Tworzenie aplikacji"), "Ukrywanie wewnętrznej struktury obiektu"));
        easyQuestions.add(new Question("Co to jest polimorfizm?", Arrays.asList("Wiele form jednego obiektu", "Jeden rodzaj pętli", "Typ zmiennej", "Struktura danych"), "Wiele form jednego obiektu"));
        easyQuestions.add(new Question("Co to jest relacja?", Arrays.asList("Typ danych", "Sekwencja instrukcji", "Warunek logiczny", "Związek między dwoma obiektami"), "Związek między dwoma obiektami"));
        easyQuestions.add(new Question("Jakim symbolem oznaczamy kompozycję (agregacja całkowita) i czym ona jest?", Arrays.asList("Niebieskim kwadratem, relacja równoległa", "Czerwoną strzałką, relacja dziedziczenia","Czarnym diamentem, relacja całość-część", "Zielonym kółkiem, relacja asocjacyjna"), "Czarnym diamentem, relacja całość-część"));
        easyQuestions.add(new Question("Jakim symbolem oznaczamy agregacje częściową i czym ona jest?", Arrays.asList("Białym diamentem, relacja całość-część", "Czarnym kwadratem, relacja równoległa", "Niebieską strzałką, relacja dziedziczenia", "Zielonym trójkątem, relacja asocjacyjna"), "Białym diamentem, relacja całość-część"));
        easyQuestions.add(new Question("Jakim symbolem oznaczamy asocjacje i czym ona jest?", Arrays.asList("Czarnym diamentem, relacja dziedziczenia","Niebieską strzałką, relacja między obiektami", "Zieloną linią, relacja równoległa", "Czerwonym kwadratem, relacja zależności"), "Niebieską strzałką, relacja między obiektami"));
        easyQuestions.add(new Question("Jakim symbolem oznaczamy zależność i czym ona jest?", Arrays.asList("Czarnym kwadratem, relacja dziedziczenia", "Zieloną strzałką, relacja równoległa", "Przerywaną linią, relacja między obiektami", "Czerwonym diamentem, relacja zależności"), "Przerywaną linią, relacja między obiektami"));
        easyQuestions.add(new Question("Co to jest klasa abstrakcyjna?", Arrays.asList("Klasa, która nie może być instancjonowana", "Klasa bez metod", "Klasa pochodna", "Interfejs"), "Klasa, która nie może być instancjonowana"));
        easyQuestions.add(new Question("Co to jest interfejs?", Arrays.asList("Typ zmiennej", "Sekwencja instrukcji", "Warunek logiczny", "Szablon dla klas z deklaracjami metod"), "Szablon dla klas z deklaracjami metod"));
        easyQuestions.add(new Question("Co to jest metoda wirtualna?", Arrays.asList("Metoda, która może być nadpisana w klasie pochodnej", "Metoda bez ciała", "Metoda statyczna", "Typ zmiennej"), "Metoda, która może być nadpisana w klasie pochodnej"));
        easyQuestions.add(new Question("Czym różni się dekorator od dziedziczenia?", Arrays.asList("Dekorator jest typem zmiennej, dziedziczenie jest metodą", "Dekorator dodaje zachowania w czasie wykonania, dziedziczenie w czasie kompilacji", "Dekorator jest wzorcem projektowym, dziedziczenie jest funkcją", "Dekorator jest relacją, dziedziczenie jest klasą"), "Dekorator dodaje zachowania w czasie wykonania, dziedziczenie w czasie kompilacji"));
        easyQuestions.add(new Question("Od jakich parametrów zależy krzywa gęstości prawdopodobieństwa?", Arrays.asList("Od średniej i wariancji", "Od sumy i iloczynu", "Od maksimum i minimum", "Od długości i szerokości"), "Od średniej i wariancji"));
        easyQuestions.add(new Question("Wzorzec Singleton - jakie cechy musi spełnić konstruktor?", Arrays.asList("Muszą być publiczne", "Muszą być statyczne", "Muszą być finalne", "Muszą być prywatne"), "Muszą być prywatne"));
        easyQuestions.add(new Question("Co podlega dziedziczeniu?", Arrays.asList("Nazwa klasy", "Metody i właściwości", "Deklaracje lokalne", "Instrukcje warunkowe"), "Metody i właściwości"));
        easyQuestions.add(new Question("Co to są cechy?", Arrays.asList("Właściwości obiektów klasy", "Funkcje w programie", "Typy zmiennych", "Pętle w programie"), "Właściwości obiektów klasy"));
        easyQuestions.add(new Question("Co to jest overload?", Arrays.asList("Przeciążenie operatorów", "Zbyt wiele klas w programie", "Definiowanie wielu metod o tej samej nazwie ale różnych parametrach", "Błąd w programie"), "Definiowanie wielu metod o tej samej nazwie ale różnych parametrach"));
        easyQuestions.add(new Question("Jaką siłę ma relacja dziedziczenia?", Arrays.asList("Silną", "Słabą", "Średnią", "Żadną"), "Silną"));
        easyQuestions.add(new Question("Jakie cechy miała metoda, która pobierała instancje we wzorcu Singleton?", Arrays.asList("Była publiczna", "Była prywatna", "Była finalna", "Była statyczna"), "Była statyczna"));
        easyQuestions.add(new Question("Co gwarantuje, że obiekt typu Singleton będzie miał pojedynczą instancję?", Arrays.asList("Prywatny konstruktor i statyczna metoda dostępu", "Publiczny konstruktor i statyczna metoda dostępu", "Statyczne pole w klasie", "Pętla w konstruktorze"), "Prywatny konstruktor i statyczna metoda dostępu"));
        easyQuestions.add(new Question("W jaki sposób w Pyłku tworzone są instancje (jak to się dzieje za pomocą Singletona)?", Arrays.asList("Tworząc nowe obiekty za każdym razem", "Używając publicznego konstruktora", "Za pomocą współdzielonych obiektów i prywatnego konstruktora", "Przez kopiowanie istniejących instancji"), "Za pomocą współdzielonych obiektów i prywatnego konstruktora"));


        hardQuestions.add(new Question("Co to jest singelton?", Arrays.asList("Wzorzec tworzący rodzinę powiązanych obiektów", "Wzorzec zapewniający istnienie tylko jednej instancji obiektu", "Wzorzec umożliwiający tworzenie obiektów bez określania ich konkretnych klas", "Wzorzec zapewniający dynamiczne dodawanie obowiązków do obiektu"), "Wzorzec zapewniający istnienie tylko jednej instancji obiektu"));
        hardQuestions.add(new Question("Co to jest metoda fabrykująca?", Arrays.asList("Metoda tworząca obiekt bez ujawniania logiki tworzenia", "Metoda umożliwiająca kopiowanie istniejących obiektów", "Metoda zapewniająca dynamiczne zmiany zachowania obiektu", "Metoda umożliwiająca tworzenie obiektów jednego rodzaju"), "Metoda tworząca obiekt bez ujawniania logiki tworzenia"));
        hardQuestions.add(new Question("Co to jest fabryka abstrakcyjna?", Arrays.asList("Wzorzec tworzący pojedynczą instancję obiektu", "Wzorzec umożliwiający tworzenie obiektów bez określania ich konkretnych klas", "Wzorzec projektowy do tworzenia rodzin obiektów", "Wzorzec umożliwiający sekwencyjny dostęp do elementów kolekcji"), "Wzorzec projektowy do tworzenia rodzin obiektów"));
        hardQuestions.add(new Question("Co to jest budowniczy?", Arrays.asList("Wzorzec umożliwiający tworzenie rodzin powiązanych obiektów", "Wzorzec umożliwiający dynamiczne dodawanie obowiązków do obiektów", "Wzorzec umożliwiający kopiowanie istniejących obiektów", "Wzorzec projektowy umożliwiający składanie złożonych obiektów"), "Wzorzec projektowy umożliwiający składanie złożonych obiektów"));
        hardQuestions.add(new Question("Co to jest prototyp?", Arrays.asList("Wzorzec projektowy umożliwiający kopiowanie istniejących obiektów", "Wzorzec umożliwiający tworzenie obiektów jednego rodzaju", "Wzorzec umożliwiający dynamiczne dodawanie obowiązków do obiektów", "Wzorzec umożliwiający składanie złożonych obiektów"), "Wzorzec projektowy umożliwiający kopiowanie istniejących obiektów"));
        hardQuestions.add(new Question("Co to jest adapter?", Arrays.asList("Wzorzec umożliwiający kopiowanie istniejących obiektów", "Wzorzec projektowy umożliwiający współdziałanie klas o niekompatybilnych interfejsach", "Wzorzec umożliwiający dynamiczne dodawanie obowiązków do obiektów", "Wzorzec umożliwiający tworzenie rodzin powiązanych obiektów"), "Wzorzec projektowy umożliwiający współdziałanie klas o niekompatybilnych interfejsach"));
        hardQuestions.add(new Question("Czym jest dekorator?", Arrays.asList("Wzorzec umożliwiający tworzenie obiektów jednego rodzaju", "Wzorzec umożliwiający kopiowanie istniejących obiektów", "Wzorzec projektowy umożliwiający dodawanie nowych funkcji do obiektów w czasie wykonania", "Wzorzec umożliwiający dynamiczne zmiany zachowania obiektu"), "Wzorzec projektowy umożliwiający dodawanie nowych funkcji do obiektów w czasie wykonania"));
        hardQuestions.add(new Question("Co to jest most?", Arrays.asList("Wzorzec umożliwiający dynamiczne dodawanie obowiązków do obiektu", "Wzorzec umożliwiający kopiowanie istniejących obiektów", "Wzorzec umożliwiający tworzenie rodzin powiązanych obiektów", "Wzorzec projektowy oddzielający abstrakcję od implementacji"), "Wzorzec projektowy oddzielający abstrakcję od implementacji"));
        hardQuestions.add(new Question("Co to jest kompozyt?", Arrays.asList("Wzorzec projektowy umożliwiający traktowanie pojedynczych obiektów i ich kompozycji w jednolity sposób", "Wzorzec umożliwiający dynamiczne dodawanie obowiązków do obiektów", "Wzorzec umożliwiający tworzenie obiektów jednego rodzaju", "Wzorzec umożliwiający kopiowanie istniejących obiektów"), "Wzorzec projektowy umożliwiający traktowanie pojedynczych obiektów i ich kompozycji w jednolity sposób"));
        hardQuestions.add(new Question("Co to jest fasada?", Arrays.asList("Wzorzec umożliwiający dynamiczne dodawanie obowiązków do obiektów", "Wzorzec projektowy zapewniający uproszczony interfejs do złożonego systemu", "Wzorzec umożliwiający tworzenie rodzin powiązanych obiektów", "Wzorzec umożliwiający kopiowanie istniejących obiektów"), "Wzorzec projektowy zapewniający uproszczony interfejs do złożonego systemu"));
        hardQuestions.add(new Question("Co to jest pyłek?", Arrays.asList("Wzorzec umożliwiający dynamiczne dodawanie obowiązków do obiektów", "Wzorzec umożliwiający tworzenie rodzin powiązanych obiektów", "Wzorzec projektowy umożliwiający efektywne współdzielenie dużych ilości drobnych obiektów", "Wzorzec umożliwiający kopiowanie istniejących obiektów"), "Wzorzec projektowy umożliwiający efektywne współdzielenie dużych ilości drobnych obiektów"));
        hardQuestions.add(new Question("Co to jest pośrednik?", Arrays.asList("Wzorzec umożliwiający dynamiczne dodawanie obowiązków do obiektów", "Wzorzec umożliwiający tworzenie rodzin powiązanych obiektów", "Wzorzec umożliwiający kopiowanie istniejących obiektów", "Wzorzec projektowy umożliwiający zmniejszenie bezpośrednich zależności między klasami"), "Wzorzec projektowy umożliwiający zmniejszenie bezpośrednich zależności między klasami"));
        hardQuestions.add(new Question("Co to jest łańcuch zobowiązań?", Arrays.asList("Wzorzec projektowy umożliwiający przekazywanie żądań wzdłuż łańcucha obiektów", "Wzorzec projektowy do tworzenia hierarchii obiektów", "Wzorzec projektowy do dynamicznego dodawania obowiązków obiektom", "Wzorzec projektowy do sekwencyjnego przetwarzania obiektów"), "Wzorzec projektowy umożliwiający przekazywanie żądań wzdłuż łańcucha obiektów"));
        hardQuestions.add(new Question("Co to jest iterator?", Arrays.asList("Wzorzec projektowy do zarządzania algorytmami sortowania", "Wzorzec projektowy umożliwiający sekwencyjny dostęp do elementów kolekcji", "Wzorzec projektowy do przechodzenia przez złożone struktury danych", "Wzorzec projektowy do przetwarzania kolekcji w różny sposób"), "Wzorzec projektowy umożliwiający sekwencyjny dostęp do elementów kolekcji"));
        hardQuestions.add(new Question("Co to jest polecenie?", Arrays.asList("Wzorzec projektowy do tworzenia sekwencji operacji", "Wzorzec projektowy do delegowania zadań", "Wzorzec projektowy umożliwiający enkapsulację żądania jako obiektu", "Wzorzec projektowy do zarządzania operacjami wykonania i cofania"), "Wzorzec projektowy umożliwiający enkapsulację żądania jako obiektu"));
        hardQuestions.add(new Question("Co to jest mediator?", Arrays.asList("Wzorzec projektowy do zarządzania interakcjami między różnymi komponentami", "Wzorzec projektowy do redukcji zależności w aplikacji", "Wzorzec projektowy do tworzenia centralnego punktu kontroli", "Wzorzec projektowy umożliwiający centralizację złożonych komunikacji i zależności między obiektami"), "Wzorzec projektowy umożliwiający centralizację złożonych komunikacji i zależności między obiektami"));
        hardQuestions.add(new Question("Co to jest pamiątka?", Arrays.asList("Wzorzec projektowy umożliwiający zapisywanie i przywracanie poprzedniego stanu obiektu", "Wzorzec projektowy do tworzenia kopii stanu obiektu", "Wzorzec projektowy do zarządzania historią zmian obiektu", "Wzorzec projektowy do przechowywania stanów aplikacji"), "Wzorzec projektowy umożliwiający zapisywanie i przywracanie poprzedniego stanu obiektu"));
        hardQuestions.add(new Question("Co to jest obserwator?", Arrays.asList("Wzorzec projektowy do powiadamiania o zmianach stanu", "Wzorzec projektowy umożliwiający obiektom subskrypcję zmian innego obiektu", "Wzorzec projektowy do monitorowania zmian w danych", "Wzorzec projektowy do tworzenia reakcji na zdarzenia"), "Wzorzec projektowy umożliwiający obiektom subskrypcję zmian innego obiektu"));
        hardQuestions.add(new Question("Co to jest stan?", Arrays.asList("Wzorzec projektowy do zarządzania różnymi stanami aplikacji", "Wzorzec projektowy do przełączania kontekstu działania obiektu", "Wzorzec projektowy umożliwiający zmianę zachowania obiektu w zależności od jego stanu", "Wzorzec projektowy do przechowywania różnych wariantów obiektu"), "Wzorzec projektowy umożliwiający zmianę zachowania obiektu w zależności od jego stanu"));
        hardQuestions.add(new Question("Co to jest strategia?", Arrays.asList("Wzorzec projektowy umożliwiający definiowanie rodziny algorytmów", "Wzorzec projektowy do implementacji różnych metod rozwiązania problemu", "Wzorzec projektowy do dynamicznej zmiany algorytmu działania", "Wzorzec projektowy do wyboru odpowiedniej metody działania w zależności od kontekstu"), "Wzorzec projektowy umożliwiający definiowanie rodziny algorytmów"));

    }

    public static QuizController getInstance() {
        if (instance == null) {
            instance = new QuizController();
        }
        return instance;
    }

    @FXML
    private void initialize() {
        loadQuestion();
    }

    private void loadQuestion() {
        Random random = new Random();
        if (counter < 3) {
            currentQuestion = easyQuestions.get(random.nextInt(easyQuestions.size()));
        } else {
            currentQuestion = hardQuestions.get(random.nextInt(hardQuestions.size()));
        }

        question.setText(currentQuestion.getQuestion());
        List<String> answers = currentQuestion.getAnswers();
        opt1.setText(answers.get(0));
        opt2.setText(answers.get(1));
        opt3.setText(answers.get(2));
        opt4.setText(answers.get(3));
    }

    boolean checkAnswer(String answer) {
        return currentQuestion.getCorrectAnswer().equals(answer);
    }

    @FXML
    public void opt1Clicked(ActionEvent actionEvent) {
        processAnswer(opt1.getText(), actionEvent);
    }

    @FXML
    public void opt2Clicked(ActionEvent actionEvent) {
        processAnswer(opt2.getText(), actionEvent);
    }

    @FXML
    public void opt3Clicked(ActionEvent actionEvent) {
        processAnswer(opt3.getText(), actionEvent);
    }

    @FXML
    public void opt4Clicked(ActionEvent actionEvent) {
        processAnswer(opt4.getText(), actionEvent);
    }

    @FXML
    public void opt5Clicked(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void opt6Clicked(ActionEvent event) {
        try {
            counter = 0;
            correct = 0;
            wrong = 0;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml")); // Zastąp "home.fxml" odpowiednią nazwą pliku FXML początkowej sceny
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private void processAnswer(String selectedAnswer, ActionEvent actionEvent) {
        if (checkAnswer(selectedAnswer)) {
            correct++;
        } else {
            wrong++;
        }

        // Przejdź do następnego pytania lub zakończ quiz
        if (counter < 4) {
            counter++;
            loadQuestion();
        } else {
            try {
                Stage thisStage = (Stage)((Button)actionEvent.getSource()).getScene().getWindow();
                thisStage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("result.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initStyle(StageStyle.TRANSPARENT);
                scene.setFill(Color.TRANSPARENT);

                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
