package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));

        Scene scene = new Scene(grid, 500, 325);
        primaryStage.setScene(scene);


        Text scenetitle = new Text("Please enter numbers to sort");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label label1 = new Label("first number:");
        grid.add(label1, 0, 1);
        TextField label1input = new TextField();
        grid.add(label1input, 1, 1);

        Label label2 = new Label("second number:");
        grid.add(label2, 0, 2);
        TextField label2input = new TextField();
        grid.add(label2input, 1, 2);

        Label label3 = new Label("third number:");
        grid.add(label3, 0, 3);
        TextField label3input = new TextField();
        grid.add(label3input, 1, 3);


        Button btn = new Button("sort");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final TextArea result = new TextArea();
        grid.add(result, 1, 5);

        final TextArea result2 = new TextArea();
        grid.add(result2, 1, 6);

        primaryStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                int a = Integer.parseInt(label1input.getText());
                int b = Integer.parseInt(label2input.getText());
                int c = Integer.parseInt(label3input.getText());

                ArrayList<Integer> List = getArratList(a, b, c);
                String b4 = "before sort: " + List;
                Main.sort(List);
                String after = "after sort: " + List;


                result.setText(b4);
                result2.setText(after);
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static ArrayList<Integer> getArratList(int a, int b, int c) {
        Integer[] temparray = {new Integer(a), new Integer(b), new Integer(c)};
        ArrayList<Integer> List = new ArrayList<>(Arrays.asList(temparray));
        return List;
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        Collections.sort(list);}
}
