package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        View view = new View();

        Scene scene = new Scene(view.load_base(view), 1285, 955);
        primaryStage.setTitle("hospital");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        //退出程序前可以先 pane.getChildren().removeAll();  也可以java自己回收
    }

    public static void main(String[] args) {
        launch(args);
    }
}