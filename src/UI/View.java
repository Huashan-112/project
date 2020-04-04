package UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class View {
    public static int currentPane = 0;
    public static int paneNum = 5;
    private AnchorPane anchorPanes[];
    private Pane1 pane1;
    private Pane2 pane2;
    private Pane3 pane3;
    private Pane4 pane4;
    private Pane5 pane5;

    public View() {
        pane1 = new Pane1();
        pane1.load(pane1.getAnchorPane1());
        pane2 = new Pane2();
        pane2.load(pane2.getAnchorPane2(), pane2.getTable(), pane2);
        pane3 = new Pane3();
        pane3.load(pane3.getAnchorPane3());
        pane4 = new Pane4();
        pane4.load(pane4.getAnchorPane4());
        pane5 = new Pane5();
        pane5.load(pane5.getAnchorPane5());
    }

    public AnchorPane getAnchorPanes(int num) {
        AnchorPane anchorPane = anchorPanes[num];
        return anchorPane;
    }


    public AnchorPane load_base(View view) {//该方法只从数据库加载数据到首页基础的pane，然后把所有pane加进根节点里。（其他pane先不用，等到用时会刷新他们的页面）

        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setPrefHeight(300);
        anchorPane1.setPrefSize(1300, 85);
        anchorPane1.setStyle("-fx-background-color:#2B303B");
        //BackgroundFill backgroundFill=new BackgroundFill(Paint.valueOf("#102b6a"),new CornerRadii(1),new Insets(1));
        //Background background=new Background(backgroundFill);
        // anchorPane1.setBackground(background);

        Label label = new Label("住院管理信息系统");
        Font font1 = Font.font("Microsoft YaHei", FontWeight.BLACK, 30);
        label.setFont(font1);
        label.setTextFill(Color.rgb(232, 232, 222));

        anchorPane1.getChildren().addAll(label);
        AnchorPane.setLeftAnchor(label, 30.0);
        AnchorPane.setTopAnchor(label, 25.0);

        Font font = Font.font("YouYuan", FontWeight.BLACK, 16);

        Button button1 = new Button("    入院出院登记");
        Button button2 = new Button("    查找住院记录");
        Button button3 = new Button("    修改住院记录");
        Button button4 = new Button("    开立药品检查");
        Button button5 = new Button("    患者详细信息");
        button1.setAlignment(Pos.CENTER_LEFT);
        button2.setAlignment(Pos.CENTER_LEFT);
        button3.setAlignment(Pos.CENTER_LEFT);
        button4.setAlignment(Pos.CENTER_LEFT);
        button5.setAlignment(Pos.CENTER_LEFT);
        button1.setStyle("-fx-background-color: #143352");
        button2.setStyle("-fx-background-color: #143352");
        button3.setStyle("-fx-background-color: #143352");
        button4.setStyle("-fx-background-color: #143352");
        button5.setStyle("-fx-background-color: #143352");
        button1.setTextFill(Color.rgb(224, 224, 215));
        button2.setTextFill(Color.rgb(224, 224, 215));
        button3.setTextFill(Color.rgb(224, 224, 215));
        button4.setTextFill(Color.rgb(224, 224, 215));
        button5.setTextFill(Color.rgb(224, 224, 215));
        button1.setFont(font);
        button2.setFont(font);
        button3.setFont(font);
        button4.setFont(font);
        button5.setFont(font);
        button1.setPrefSize(180, 68);
        button2.setPrefSize(180, 68);
        button3.setPrefSize(180, 68);
        button4.setPrefSize(180, 68);
        button5.setPrefSize(180, 68);
        button1.setOnAction(new EventHandler<ActionEvent>() {  // 入院出院登记
            @Override
            public void handle(ActionEvent event) {
                view.showPane(0, view);
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {  // 查找住院记录
            @Override
            public void handle(ActionEvent event) {
                view.showPane(1, view);
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {  // 修改住院记录
            @Override
            public void handle(ActionEvent event) {
                view.showPane(2, view);
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {  // 药品与检查
            @Override
            public void handle(ActionEvent event) {
                view.showPane(3, view);
            }
        });
        button5.setOnAction(new EventHandler<ActionEvent>() {  // 患者信息
            @Override
            public void handle(ActionEvent event) {
                view.showPane(4, view);
            }
        });

        //把4个button变成属性封装起来，等到pane5（登录首页）密码通过后，调用view的buttonEnable方法使得其他按钮可用
//        button1.setDisable(true);
//        button1.setDisable(true);
//        button1.setDisable(true);
//        button1.setDisable(true);
//        button1.setDisable(false);
//        button1.setDisable(false);
//        button1.setDisable(false);
//        button1.setDisable(false);

        VBox vBox = new VBox();
        vBox.setPrefSize(180, 895);
        vBox.setStyle("-fx-background-color:#444C63");
        vBox.getChildren().addAll(button1, button2, button3, button4, button5);

        AnchorPane anchorPane = new AnchorPane();//根节点
        anchorPane.setStyle("-fx-background-color:#F3F3F3");
        anchorPane.getChildren().addAll(anchorPane1, vBox);
        AnchorPane.setTopAnchor(vBox, 85.0);

        /////////////////////////////

        anchorPane.getChildren().add(pane1.getAnchorPane1());
        anchorPane.getChildren().add(pane2.getAnchorPane2());
        anchorPane.getChildren().add(pane3.getAnchorPane3());
        anchorPane.getChildren().add(pane4.getAnchorPane4());
        anchorPane.getChildren().add(pane5.getAnchorPane5());
        AnchorPane.setLeftAnchor(pane1.getAnchorPane1(), 200.0);
        AnchorPane.setTopAnchor(pane1.getAnchorPane1(), 105.0);
        AnchorPane.setLeftAnchor(pane2.getAnchorPane2(), 200.0);
        AnchorPane.setTopAnchor(pane2.getAnchorPane2(), 105.0);
        AnchorPane.setLeftAnchor(pane3.getAnchorPane3(), 200.0);
        AnchorPane.setTopAnchor(pane3.getAnchorPane3(), 105.0);
        AnchorPane.setLeftAnchor(pane4.getAnchorPane4(), 200.0);
        AnchorPane.setTopAnchor(pane4.getAnchorPane4(), 105.0);
        AnchorPane.setLeftAnchor(pane5.getAnchorPane5(), 200.0);
        AnchorPane.setTopAnchor(pane5.getAnchorPane5(), 105.0);

        return anchorPane;
    }

    public void showPane(int num, View view) {
        if (num == currentPane)
            return;
        else {
            if (num == 0) {
                view.setUnVisiable(view);
                View.currentPane = num;//当前的换人
                view.pane1.getAnchorPane1().setVisible(true);//新的设置为可见
            }
            if (num == 1) {
                view.setUnVisiable(view);
                View.currentPane = num;//当前的换人
                view.pane2.getAnchorPane2().setVisible(true);//新的设置为可见
                view.pane2.update();
            }
            if (num == 2) {
                view.setUnVisiable(view);
                View.currentPane = num;//当前的换人
                view.pane3.getAnchorPane3().setVisible(true);//新的设置为可见
            }
            if (num == 3) {
                view.setUnVisiable(view);
                View.currentPane = num;//当前的换人
                view.pane4.getAnchorPane4().setVisible(true);//新的设置为可见
            }
            if (num == 4) {
                view.setUnVisiable(view);
                View.currentPane = num;//当前的换人
                view.pane5.getAnchorPane5().setVisible(true);//新的设置为可见
            }
        }
    }


    public void setUnVisiable(View view) {

        if (View.currentPane == 0) {
            view.pane1.getAnchorPane1().setVisible(false);
        }
        if (View.currentPane == 1) {
            view.pane2.getAnchorPane2().setVisible(false);
        }
        if (View.currentPane == 2) {
            view.pane3.getAnchorPane3().setVisible(false);
        }
        if (View.currentPane == 3) {
            view.pane4.getAnchorPane4().setVisible(false);
        }
        if (View.currentPane == 4) {
            view.pane5.getAnchorPane5().setVisible(false);
        } else {
            return;
        }
    }

}

