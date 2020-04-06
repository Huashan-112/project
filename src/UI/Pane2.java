package UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.util.function.UnaryOperator;

public class Pane2 {

    private AnchorPane anchorPane2;
    private TableView<Patient> table;

    public Pane2() {
        anchorPane2 = new AnchorPane();
        anchorPane2.setVisible(false);
        anchorPane2.setPrefSize(1080, 855);
        anchorPane2.setStyle("-fx-background-color:#ffffff");
        this.table = new TableView<>();
    }

    public void load(AnchorPane anchorPane2, TableView table, Pane2 pane2) {

        Font font = Font.font("YouYuan", FontWeight.BLACK, 16);

        //-------------------------------------------------------------  //分割线

        Label divider1_note = new Label("所有住院记录");//分割线
        divider1_note.setPrefSize(400, 30);
        divider1_note.setTextFill(Color.rgb(90, 90, 90));
        Font font2 = Font.font("Microsoft YaHei", FontWeight.BLACK, 17);
        divider1_note.setFont(font2);
        divider1_note.setStyle("-fx-background-color: #F4FEE5");
        divider1_note.setAlignment(Pos.CENTER_LEFT);

        Line divider1_decoration = new Line(20, 10, 20, 30);
        divider1_decoration.setStrokeWidth(9);
        divider1_decoration.setStroke(Color.valueOf("#2475C4"));

        AnchorPane divider1 = new AnchorPane();
        divider1.setPrefSize(1050, 40);
        divider1.setStyle("-fx-background-color: #F4FEE5");
        divider1.getChildren().addAll(divider1_decoration, divider1_note);
        AnchorPane.setLeftAnchor(divider1_note, 35.0);
        AnchorPane.setTopAnchor(divider1_note, 5.0);

        //lable--------------------------------------------------------  //分割线

        this.table.setEditable(true);
        this.table.setPrefSize(1050, 340);
        TableColumn t1 = new TableColumn("诊疗卡号");
        TableColumn t2 = new TableColumn("姓名");
        TableColumn t3 = new TableColumn("性别");
        TableColumn t4 = new TableColumn("年龄");
        TableColumn t5 = new TableColumn("诊断");
        TableColumn t6 = new TableColumn("科室");
        TableColumn t7 = new TableColumn("病房");
        TableColumn t8 = new TableColumn("床位");
        TableColumn t9 = new TableColumn("入院时间");
        TableColumn t10 = new TableColumn("出院时间");
        t1.setPrefWidth(110);
        t2.setPrefWidth(100);
        t3.setPrefWidth(50);
        t4.setPrefWidth(65);
        t5.setPrefWidth(130);
        t6.setPrefWidth(120);
        t7.setPrefWidth(90);
        t8.setPrefWidth(65);
        t9.setPrefWidth(159);
        t10.setPrefWidth(159);
        t1.setCellValueFactory(new PropertyValueFactory<>("card"));
        t2.setCellValueFactory(new PropertyValueFactory<>("name"));
        t3.setCellValueFactory(new PropertyValueFactory<>("sex"));
        t4.setCellValueFactory(new PropertyValueFactory<>("age"));
        t5.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        t6.setCellValueFactory(new PropertyValueFactory<>("department"));
        t7.setCellValueFactory(new PropertyValueFactory<>("ward"));
        t8.setCellValueFactory(new PropertyValueFactory<>("bed"));
        t9.setCellValueFactory(new PropertyValueFactory<>("inTime"));
        t10.setCellValueFactory(new PropertyValueFactory<>("outTime"));
        //table.setStyle("-fx-background-color:#E6F2FE");
        table.getColumns().addAll(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
        table.setColumnResizePolicy(new Callback<TableView.ResizeFeatures, Boolean>() {
            @Override
            public Boolean call(TableView.ResizeFeatures param) {
                return true;
            }
        });

        String[] strings = new String[15];
        for (int i = 0; i < 15; i++) {
            strings[i] = Integer.toString(i);
        }
        Patient patient = new Patient();
        patient.madeBean(strings);
        table.getItems().addAll(patient.madeBean(strings), patient.madeBean(strings), patient.madeBean(strings));

        //-------------------------------------------------------------  //分割线

        Label divider2_note = new Label("查找个人记录");//分割线
        divider2_note.setPrefSize(400, 30);
        divider2_note.setTextFill(Color.rgb(90, 90, 90));
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

        Font font1 = Font.font("YouYuan", FontWeight.BLACK, 16);

        TextField textField = new TextField();
        textField.setPrefSize(230, 35);
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

        TableView<Patient> table_del = new TableView<>();
        table_del.setEditable(true);
        table_del.setPrefSize(1050, 60);
        TableColumn td1 = new TableColumn("诊疗卡号");
        TableColumn td2 = new TableColumn("姓名");
        TableColumn td3 = new TableColumn("性别");
        TableColumn td4 = new TableColumn("年龄");
        TableColumn td5 = new TableColumn("诊断");
        TableColumn td6 = new TableColumn("科室");
        TableColumn td7 = new TableColumn("病房");
        TableColumn td8 = new TableColumn("床位");
        TableColumn td9 = new TableColumn("入院时间");
        TableColumn td10 = new TableColumn("出院时间");
        td1.setCellValueFactory(new PropertyValueFactory<>("card"));
        td2.setCellValueFactory(new PropertyValueFactory<>("name"));
        td3.setCellValueFactory(new PropertyValueFactory<>("sex"));
        td4.setCellValueFactory(new PropertyValueFactory<>("age"));
        td5.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        td6.setCellValueFactory(new PropertyValueFactory<>("department"));
        td7.setCellValueFactory(new PropertyValueFactory<>("ward"));
        td8.setCellValueFactory(new PropertyValueFactory<>("bed"));
        td9.setCellValueFactory(new PropertyValueFactory<>("inTime"));
        td10.setCellValueFactory(new PropertyValueFactory<>("outTime"));
        td1.setPrefWidth(110);
        td2.setPrefWidth(100);
        td3.setPrefWidth(50);
        td4.setPrefWidth(65);
        td5.setPrefWidth(130);
        td6.setPrefWidth(120);
        td7.setPrefWidth(90);
        td8.setPrefWidth(65);
        td9.setPrefWidth(159);
        td10.setPrefWidth(159);
        //table.setStyle("-fx-background-color:#E6F2FE");
        table_del.getColumns().addAll(td1, td2, td3, td4, td5, td6, td7, td8, td9, td10);
        table.setColumnResizePolicy(new Callback<TableView.ResizeFeatures, Boolean>() {
            @Override
            public Boolean call(TableView.ResizeFeatures param) {
                return true;
            }
        });

        Button query = new Button("查找");
        query.setPrefSize(100, 30);
        query.setStyle("-fx-background-color: #2475C4");
        query.setTextFill(Color.rgb(241, 241, 232));
        query.setFont(font1);
        query.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //先将表格和框内容清空，然后调用胡的方法，将s传给他，让他查到后返回patient对象给我，我再插入表格中
                if (!textField.getText().equals("")) {
                    table_del.getItems().removeAll(table_del.getItems());
                    String[] s1 = new String[15];
                    for (int i = 0; i < 15; i++) {
                        s1[i] = Integer.toString(i);
                    }
                    Patient patient = new Patient();
                    table_del.getItems().addAll(patient.madeBean(s1));
                    table_del.refresh();
                }
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().

                addAll(textField, query);

        Button delect = new Button("删除");
        delect.setPrefSize(100, 30);
        delect.setStyle("-fx-background-color: #2475C4");
        delect.setTextFill(Color.rgb(241, 241, 232));
        delect.setFont(font1);
        delect.setOnAction(new EventHandler<ActionEvent>() {  // 删除个人住院记录
            @Override
            public void handle(ActionEvent event) {
                //清空框和表中的内容，弹窗提示确认删除？
                if (!table_del.getItems().isEmpty()) {
                    Stage stage = new Stage();
                    Label tip = new Label("确认删除该条记录？");
                    tip.setPrefSize(400, 40);
                    tip.setTextFill(Color.rgb(113, 114, 112));
                    tip.setFont(font);
                    Button yes = new Button("确认");
                    yes.setPrefWidth(80);
                    yes.setOnAction(new EventHandler<ActionEvent>() {  // 确认删除
                        @Override
                        public void handle(ActionEvent event) {
                            table_del.getItems().removeAll(table_del.getItems());
                            textField.setText("");
                            stage.close();
                        }
                    });
                    Button no = new Button("取消");
                    no.setPrefWidth(80);
                    no.setOnAction(new EventHandler<ActionEvent>() {  // 取消删除
                        @Override
                        public void handle(ActionEvent event) {
                            stage.close();
                        }
                    });
                    AnchorPane anchorPane = new AnchorPane();
                    anchorPane.getChildren().addAll(tip, yes, no);
                    AnchorPane.setLeftAnchor(tip, 30.0);
                    AnchorPane.setTopAnchor(tip, 30.0);
                    AnchorPane.setLeftAnchor(yes, 250.0);
                    AnchorPane.setTopAnchor(yes, 100.0);
                    AnchorPane.setLeftAnchor(no, 350.0);
                    AnchorPane.setTopAnchor(no, 100.0);
                    Scene scene = new Scene(anchorPane, 460, 160);
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.UTILITY);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.show();
                    pane2.update();
                }
            }
        });

        Button reset = new Button("重置");
        reset.setPrefSize(100, 30);
        reset.setStyle("-fx-background-color: #2475C4");
        reset.setTextFill(Color.rgb(241, 241, 232));
        reset.setFont(font1);
        reset.setOnAction(new EventHandler<ActionEvent>() {  // 重置
            @Override
            public void handle(ActionEvent event) {
                textField.setText("");
                table_del.getItems().removeAll(table_del.getItems());
            }
        });

        HBox hBox2 = new HBox();
        hBox2.getChildren().

                addAll(delect, reset);
        hBox2.setSpacing(40);

        Line line1 = new Line(15, 845, 1065, 845);
        line1.setStroke(Color.valueOf("#5C5D5B"));

        //_____________________________________________________________________________________________

        anchorPane2.getChildren().addAll(table, divider1, divider2, hBox, table_del, hBox2, line1);

        AnchorPane.setLeftAnchor(divider1, 15.0);
        AnchorPane.setTopAnchor(divider1, 25.0);

        AnchorPane.setLeftAnchor(table, 15.0);
        AnchorPane.setTopAnchor(table, 90.0);

        AnchorPane.setLeftAnchor(divider2, 15.0);
        AnchorPane.setTopAnchor(divider2, 475.0);

        AnchorPane.setLeftAnchor(hBox, 15.0);
        AnchorPane.setTopAnchor(hBox, 540.0);

        AnchorPane.setLeftAnchor(table_del, 15.0);
        AnchorPane.setTopAnchor(table_del, 600.0);

        AnchorPane.setLeftAnchor(hBox2, 15.0);
        AnchorPane.setTopAnchor(hBox2, 690.0);
    }

    public void update() {
        //把表格里的内容清空，然后调用胡的方法，重新获取数据库所有数据，重新显示在表格上
//        table.getItems().removeAll(table.getItems());
//        Patient patient = new Patient("31", "31", "31", "831", "31", "318", "31", "381", "31", "31", "318", "31");
//        ObservableList<Patient> data = FXCollections.observableArrayList(patient);
//        table.getItems().addAll(data);
//        table.refresh();
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    public AnchorPane getAnchorPane2() {
        return anchorPane2;
    }

    public void setAnchorPane2(AnchorPane anchorPane2) {
        this.anchorPane2 = anchorPane2;
    }

    public TableView getTable() {
        return this.table;
    }

    public void setTable(TableView a) {
        this.table = a;
    }
}
