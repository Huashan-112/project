package UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

import java.util.function.UnaryOperator;

public class Pane5 {

    private AnchorPane anchorPane5;

    public Pane5() {
        anchorPane5 = new AnchorPane();
        anchorPane5.setVisible(false);
        anchorPane5.setPrefSize(1080, 855);
        anchorPane5.setStyle("-fx-background-color:#ffffff");
    }

    public void load(AnchorPane anchorPane5) {
        Font font = Font.font("YouYuan", FontWeight.BLACK, 16);

        TextField textField = new TextField();
        textField.setPrefSize(300, 40);
        textField.requestFocus();
        textField.setPrefColumnCount(5);
        textField.setPromptText("请输入诊疗卡号");
        textField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change t) {
                String value = t.getText();
                if (value.matches("[0-9]*")) {
                    return t;
                }
                return null;
            }
        }));

        //lable--------------------------------------------------------

        Line line = new Line(15, 110, 1065, 110);
        line.setStroke(Color.valueOf("#BCBEBA"));

        Label label = new Label("全院住院患者 ");
        label.setPrefSize(110, 40);
        label.setTextFill(Color.rgb(120, 126, 131));
        label.setFont(font);

        Label name = new Label("姓名：");
        name.setPrefSize(200, 40);
        name.setTextFill(Color.rgb(120, 126, 131));
        name.setFont(font);

        Label sex = new Label("性别：");
        sex.setPrefSize(200, 40);
        sex.setTextFill(Color.rgb(120, 126, 131));
        sex.setFont(font);

        Label age = new Label("年龄：");
        age.setPrefSize(200, 40);
        age.setTextFill(Color.rgb(120, 126, 131));
        age.setFont(font);

        Label phone = new Label("手机号：");
        phone.setPrefSize(200, 40);
        phone.setTextFill(Color.rgb(120, 126, 131));
        phone.setFont(font);

        Label ID = new Label("身份证号：");
        ID.setPrefSize(200, 40);
        ID.setTextFill(Color.rgb(120, 126, 131));
        ID.setFont(font);

        Label diagnosis = new Label("诊断：");
        diagnosis.setPrefSize(200, 40);
        diagnosis.setTextFill(Color.rgb(120, 126, 131));
        diagnosis.setFont(font);

        Label doctor = new Label("主治医师：");
        doctor.setPrefSize(200, 40);
        doctor.setTextFill(Color.rgb(120, 126, 131));
        doctor.setFont(font);

        HBox hBox1 = new HBox();
        hBox1.setSpacing(70);
        hBox1.setPrefSize(1050, 180.0);
        hBox1.getChildren().addAll(name, sex, age, phone);

        HBox hBox2 = new HBox();
        hBox2.setSpacing(70);
        hBox2.setPrefSize(1050, 180.0);
        hBox2.getChildren().addAll(ID, diagnosis, doctor);

        //-------------------------------------------------------------  //分割线

        Label divider2_note = new Label("住院信息");//分割线
        divider2_note.setPrefSize(400, 30);
        divider2_note.setTextFill(Color.rgb(90, 90, 90));
        Font font2 = Font.font("Microsoft YaHei", FontWeight.BLACK, 17);
        divider2_note.setFont(font2);
        divider2_note.setStyle("-fx-background-color: #F4FEE5");
        divider2_note.setAlignment(Pos.CENTER_LEFT);

        Line divider2_decoration = new Line(20, 10, 20, 30);
        divider2_decoration.setStrokeWidth(9);
        divider2_decoration.setStroke(Color.valueOf("#2475C4"));

        AnchorPane divider2 = new AnchorPane();
        divider2.setPrefSize(1050, 40);
        divider2.setStyle("-fx-background-color: #F4FEE5");
        divider2.getChildren().addAll(divider2_decoration, divider2_note);
        AnchorPane.setLeftAnchor(divider2_note, 35.0);
        AnchorPane.setTopAnchor(divider2_note, 5.0);

        //lable--------------------------------------------------------  //分割线

        TableView table = new TableView();
        table.setEditable(true);
        table.setPrefSize(1050, 60);
        TableColumn t1 = new TableColumn("科室");
        TableColumn t2 = new TableColumn("病房号");
        TableColumn t3 = new TableColumn("床位号");
        TableColumn t4 = new TableColumn("入院时间");
        TableColumn t5 = new TableColumn("出院时间");
        t1.setPrefWidth(208);
        t2.setPrefWidth(200);
        t3.setPrefWidth(200);
        t4.setPrefWidth(220);
        t5.setPrefWidth(220);
        t1.setCellValueFactory(new PropertyValueFactory<>("department"));
        t2.setCellValueFactory(new PropertyValueFactory<>("ward"));
        t3.setCellValueFactory(new PropertyValueFactory<>("bed"));
        t4.setCellValueFactory(new PropertyValueFactory<>("inTime"));
        t5.setCellValueFactory(new PropertyValueFactory<>("outTime"));
        table.getColumns().addAll(t1, t2, t3, t4, t5);
        table.setColumnResizePolicy(new Callback<TableView.ResizeFeatures, Boolean>() {
            @Override
            public Boolean call(TableView.ResizeFeatures param) {
                return true;
            }
        });

        //-------------------------------------------------------------  //分割线

        Label divider3_note = new Label("已用药物");
        divider3_note.setPrefSize(400, 30);
        divider3_note.setTextFill(Color.rgb(90, 90, 90));
        divider3_note.setFont(font2);
        divider2_note.setStyle("-fx-background-color: #F4FEE5");
        divider2_note.setAlignment(Pos.CENTER_LEFT);

        Line divider3_decoration = new Line(20, 10, 20, 30);
        divider3_decoration.setStrokeWidth(9);
        divider3_decoration.setStroke(Color.valueOf("#2475C4"));

        AnchorPane divider3 = new AnchorPane();
        divider3.setPrefSize(1050, 40);
        divider3.setStyle("-fx-background-color: #F4FEE5");
        divider3.getChildren().addAll(divider3_decoration, divider3_note);
        AnchorPane.setLeftAnchor(divider3_note, 35.0);
        AnchorPane.setTopAnchor(divider3_note, 5.0);

        //-------------------------------------------------------------  //分割线

        TableView table_medicine = new TableView();
        table_medicine.setEditable(true);
        table_medicine.setPrefSize(1050, 115);
        TableColumn tc1 = new TableColumn("药品编码");
        TableColumn tc2 = new TableColumn("药品名称");
        TableColumn tc3 = new TableColumn("数量");
        TableColumn tc4 = new TableColumn("单价");
        TableColumn tc5 = new TableColumn("总金额");
        tc1.setPrefWidth(250);
        tc2.setPrefWidth(250);
        tc3.setPrefWidth(150);
        tc4.setPrefWidth(150);
        tc5.setPrefWidth(248);
        tc1.setCellValueFactory(new PropertyValueFactory<>("indexes"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("num"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("price"));
        tc5.setCellValueFactory(new PropertyValueFactory<>("total_price"));
        table_medicine.getColumns().addAll(tc1, tc2, tc3, tc4, tc5);

        //-------------------------------------------------------------  //分割线

        Label divider4_note = new Label("已检查项目");//分割线
        divider4_note.setPrefSize(400, 30);
        divider4_note.setTextFill(Color.rgb(90, 90, 90));
        divider4_note.setFont(font2);
        divider4_note.setStyle("-fx-background-color: #F4FEE5");
        divider4_note.setAlignment(Pos.CENTER_LEFT);

        Line divider4_decoration = new Line(20, 10, 20, 30);
        divider4_decoration.setStrokeWidth(9);
        divider4_decoration.setStroke(Color.valueOf("#2475C4"));

        AnchorPane divider4 = new AnchorPane();
        divider4.setPrefSize(1050, 40);
        divider4.setStyle("-fx-background-color: #F4FEE5");
        divider4.getChildren().addAll(divider4_decoration, divider4_note);
        AnchorPane.setLeftAnchor(divider4_note, 35.0);
        AnchorPane.setTopAnchor(divider4_note, 5.0);

        //lable--------------------------------------------------------  //分割线

        TableView table_check = new TableView();
        table_check.setEditable(true);
        table_check.setPrefSize(1050, 115);
        TableColumn check1 = new TableColumn("项目编码");
        TableColumn check2 = new TableColumn("项目名称");
        TableColumn check3 = new TableColumn("数量");
        TableColumn check4 = new TableColumn("单价");
        TableColumn check5 = new TableColumn("总金额");
        check1.setPrefWidth(250);
        check2.setPrefWidth(250);
        check3.setPrefWidth(150);
        check4.setPrefWidth(150);
        check5.setPrefWidth(248);
        check1.setCellValueFactory(new PropertyValueFactory<>("indexes"));
        check2.setCellValueFactory(new PropertyValueFactory<>("name"));
        check3.setCellValueFactory(new PropertyValueFactory<>("num"));
        check4.setCellValueFactory(new PropertyValueFactory<>("price"));
        check5.setCellValueFactory(new PropertyValueFactory<>("total_price"));
        table_check.getColumns().addAll(check1, check2, check3, check4, check5);

        Button reset = new Button("重置");
        reset.setPrefSize(100, 30);
        reset.setStyle("-fx-background-color: #2475C4");
        reset.setTextFill(Color.rgb(241, 241, 232));
        reset.setFont(font);
        reset.setOnAction(new EventHandler<ActionEvent>() {  // 重置
            @Override
            public void handle(ActionEvent event) {
                //所有框设内容为空,将表中内容清空
                textField.setText("");
                name.setText("姓名：");
                sex.setText("性别：");
                age.setText("年龄：");
                phone.setText("手机号：");
                ID.setText("身份证号：");
                diagnosis.setText("诊断：");
                doctor.setText("主治医师：");
                table.getItems().removeAll(table.getItems());
                table_medicine.getItems().removeAll(table_medicine.getItems());
                table_check.getItems().removeAll(table_check.getItems());
            }
        });

        Line line1 = new Line(15, 845, 1065, 845);
        line1.setStroke(Color.valueOf("#5C5D5B"));

        Button button = new Button("查询");
        button.setPrefSize(100, 40);
        button.setStyle("-fx-background-color: #2475C4");
        button.setTextFill(Color.rgb(241, 241, 232));
        button.setFont(font);
        button.setOnAction(new EventHandler<ActionEvent>() {  // 查询患者个人信息
            @Override
            public void handle(ActionEvent event) {
                //先清空下方的所有数据，然后调用胡的方法，将卡号传给他，让他找到该人的记录，返回来patient对象，我再一一插入表格中
                //可能还要有药品和检查项目的表（里面记录药品的检查项目的
                if (!textField.getText().equals("")) {
                    //调用胡的方法，返回字符串数组
                    if (true) {     //假如能找到该记录
                        String[] strings = new String[15];
                        for (int i = 0; i < 15; i++) {
                            strings[i] = Integer.toString(i);
                        }
                        name.setText("姓名：" + strings[1]);
                        sex.setText("性别：" + strings[2]);
                        age.setText("年龄：" + strings[3]);
                        phone.setText("手机号：" + strings[10]);
                        ID.setText("身份证号：" + strings[11]);
                        diagnosis.setText("诊断：" + strings[4]);
                        doctor.setText("主治医师：" + strings[14]);

                        Patient patient = new Patient();
                        table.getItems().removeAll(table.getItems());
                        table.getItems().addAll(patient.madeBean(strings));

                        Medicine medicine = new Medicine();
                        table_medicine.getItems().removeAll(table_medicine.getItems());
                        table_medicine.getItems().addAll(medicine.madeBean(strings));

                        CheckUp checkUp = new CheckUp();
                        table_check.getItems().removeAll(table_check.getItems());
                        table_check.getItems().addAll(checkUp.madeBean(strings));
                    }
                }
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(textField, button);

        //_____________________________________________________________________

        anchorPane5.getChildren().addAll(hBox, line, label, hBox1, hBox2, divider2, table, divider3, table_medicine, divider4, table_check, reset, line1);

        AnchorPane.setLeftAnchor(hBox, 125.0);
        AnchorPane.setTopAnchor(hBox, 40.0);

        AnchorPane.setLeftAnchor(label, 15.0);
        AnchorPane.setTopAnchor(label, 40.0);

        AnchorPane.setLeftAnchor(hBox1, 15.0);
        AnchorPane.setTopAnchor(hBox1, 125.0);

        AnchorPane.setLeftAnchor(hBox2, 15.0);
        AnchorPane.setTopAnchor(hBox2, 175.0);

        AnchorPane.setLeftAnchor(divider2, 15.0);
        AnchorPane.setTopAnchor(divider2, 240.0);

        AnchorPane.setLeftAnchor(table, 15.0);
        AnchorPane.setTopAnchor(table, 295.0);

        AnchorPane.setLeftAnchor(divider3, 15.0);
        AnchorPane.setTopAnchor(divider3, 390.0);

        AnchorPane.setLeftAnchor(table_medicine, 15.0);
        AnchorPane.setTopAnchor(table_medicine, 445.0);

        AnchorPane.setLeftAnchor(divider4, 15.0);
        AnchorPane.setTopAnchor(divider4, 590.0);

        AnchorPane.setLeftAnchor(table_check, 15.0);
        AnchorPane.setTopAnchor(table_check, 645.0);

        AnchorPane.setLeftAnchor(reset, 492.0);
        AnchorPane.setTopAnchor(reset, 785.0);
    }

    public AnchorPane getAnchorPane5() {
        return anchorPane5;
    }

    public void setAnchorPane5(AnchorPane anchorPane5) {
        this.anchorPane5 = anchorPane5;
    }
}
