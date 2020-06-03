package UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Pane0 {

    private AnchorPane anchorPane0;

    public Pane0() {
        anchorPane0 = new AnchorPane();
        anchorPane0.setPrefSize(1200, 1300);
        anchorPane0.setStyle("-fx-background-color:#2B303B");
        anchorPane0.setVisible(true);
    }

    public void load(AnchorPane anchorPane0, Button button1, AnchorPane anchorPane1, Button exit) {

        Font font1 = Font.font("YouYuan", FontWeight.BLACK, 23);

        Image image = new Image("UI/img1.png", 1300, 1400, true, false, true);
        ImageView imageView = new ImageView(image);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(450, 420);
        anchorPane.setStyle("-fx-background-color: #F4FEE5");
        anchorPane.setOpacity(0.1);

        TextField username = new TextField();
        username.setPrefWidth(350);
        username.setPrefHeight(40);
        username.setOpacity(0.6);
        username.setPromptText("请输入用户名");

        TextField password = new TextField();
        password.setPrefWidth(350);
        password.setPrefHeight(40);
        password.setOpacity(0.6);
        password.setPromptText("请输入密码");

        Button login = new Button("登录");
        login.setStyle("-fx-background-color: #304152");
        login.setTextFill(Color.rgb(217, 217, 217));
        login.setFont(font1);
        login.setPrefSize(350, 30);
        login.setOnAction(new EventHandler<ActionEvent>() {  // 登录
            @Override
            public void handle(ActionEvent event) {

                Util util = new Util();
                if (username.getText().equals("1") && password.getText().equals("1")) {

                    username.setText("");
                    password.setText("");

                    anchorPane0.setVisible(false);
                    anchorPane1.setVisible(true);
                    View.currentPane = 1;
                    button1.setStyle("-fx-background-color: #813151");

                    exit.setVisible(true);

                } else {
                    util.tip("用户名或密码不正确！", "");
                }
            }
        });

        anchorPane0.getChildren().addAll(imageView, anchorPane, username, password, login);
        AnchorPane.setLeftAnchor(anchorPane, 420.0);
        AnchorPane.setTopAnchor(anchorPane, 200.0);
        AnchorPane.setLeftAnchor(username, 470.0);
        AnchorPane.setTopAnchor(username, 290.0);
        AnchorPane.setLeftAnchor(password, 470.0);
        AnchorPane.setTopAnchor(password, 370.0);
        AnchorPane.setLeftAnchor(login, 470.0);
        AnchorPane.setTopAnchor(login, 490.0);
    }

    public AnchorPane getAnchorPane0() {
        return anchorPane0;
    }
}
