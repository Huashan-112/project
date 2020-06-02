package UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import service.*;
import entity.Patient;

import java.util.List;
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

        RoomService roomService = new RoomService();
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        CheckService checkService = new CheckService();
        DepartmentService departmentService = new DepartmentService();
        DragService dragService = new DragService();
        Util util = new Util();

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
        TableColumn t5 = new TableColumn("手机号");
        TableColumn t6 = new TableColumn("身份证号");
        TableColumn t7 = new TableColumn("诊断");
        TableColumn t8 = new TableColumn("主治医师");
        TableColumn t9 = new TableColumn("病房号");
        t1.setPrefWidth(120);
        t2.setPrefWidth(110);
        t3.setPrefWidth(60);
        t4.setPrefWidth(75);
        t5.setPrefWidth(140);
        t6.setPrefWidth(130);
        t7.setPrefWidth(100);
        t8.setPrefWidth(160);
        t9.setPrefWidth(133);
        t1.setCellValueFactory(new PropertyValueFactory<>("id"));
        t2.setCellValueFactory(new PropertyValueFactory<>("name"));
        t3.setCellValueFactory(new PropertyValueFactory<>("sex"));
        t4.setCellValueFactory(new PropertyValueFactory<>("age"));
        t5.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        t6.setCellValueFactory(new PropertyValueFactory<>("identity_card"));
        t7.setCellValueFactory(new PropertyValueFactory<>("diagnose"));
        t8.setCellValueFactory(new PropertyValueFactory<>("doc_name"));
        t9.setCellValueFactory(new PropertyValueFactory<>("ward_id"));
        table.getColumns().addAll(t1, t2, t3, t4, t5, t6, t7, t8, t9);
        table.setColumnResizePolicy(new Callback<TableView.ResizeFeatures, Boolean>() {
            @Override
            public Boolean call(TableView.ResizeFeatures param) {
                return true;
            }
        });

        //显示所有住院记录
        List<Patient> list = patientService.list();
        for (Patient patient : list) {
            patient.setRoomDetail(roomService.get(patient.getRoom_id()));
            patient.setDoc_name(doctorService.get(patient.getDoc_id()));//获取主治医师名字
        }
        table.getItems().addAll(list);

        //-------------------------------------------------------------  //分割线

        Label divider2_note = new Label("快速查找记录");//分割线
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
        TableColumn td5 = new TableColumn("手机号");
        TableColumn td6 = new TableColumn("身份证号");
        TableColumn td7 = new TableColumn("诊断");
        TableColumn td8 = new TableColumn("主治医师");
        TableColumn td9 = new TableColumn("病房号");
        td1.setPrefWidth(120);
        td2.setPrefWidth(110);
        td3.setPrefWidth(60);
        td4.setPrefWidth(75);
        td5.setPrefWidth(140);
        td6.setPrefWidth(130);
        td7.setPrefWidth(100);
        td8.setPrefWidth(160);
        td9.setPrefWidth(149);
        td1.setCellValueFactory(new PropertyValueFactory<>("id"));
        td2.setCellValueFactory(new PropertyValueFactory<>("name"));
        td3.setCellValueFactory(new PropertyValueFactory<>("sex"));
        td4.setCellValueFactory(new PropertyValueFactory<>("age"));
        td5.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        td6.setCellValueFactory(new PropertyValueFactory<>("identity_card"));
        td7.setCellValueFactory(new PropertyValueFactory<>("diagnose"));
        td8.setCellValueFactory(new PropertyValueFactory<>("doc_id"));
        td9.setCellValueFactory(new PropertyValueFactory<>("ward_id"));
        table_del.getColumns().addAll(td1, td2, td3, td4, td5, td6, td7, td8, td9);
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
        query.setOnAction(new EventHandler<ActionEvent>() {//快速查找记录
            @Override
            public void handle(ActionEvent event) {

                if (!textField.getText().equals("")) {

                    Patient patient = patientService.get(Integer.parseInt(textField.getText()));

                    if (patient == null) {
                        textField.setText("");
                        util.tip("无此记录！请输入正确的卡号", "");
                    } else {

                        table_del.getItems().removeAll(table_del.getItems());//将表格和框内容清空
                        patient.setRoomDetail(roomService.get(patient.getRoom_id()));//获取病房号等
                        patient.setDoc_name(doctorService.get(patient.getDoc_id()));//获取主治医师名字
                        table_del.getItems().addAll(patient);
                        table_del.refresh();
                    }
                }
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(textField, query);

        Button delect = new Button("删除");
        delect.setPrefSize(100, 30);
        delect.setStyle("-fx-background-color: #2475C4");
        delect.setTextFill(Color.rgb(241, 241, 232));
        delect.setFont(font1);
        delect.setOnAction(new EventHandler<ActionEvent>() {  // 删除个人住院记录
            @Override
            public void handle(ActionEvent event) {

                if (!table_del.getItems().isEmpty() && !textField.getText().equals("")) {

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

                            //drag和check有patient的主键，patient有room的主键。
                            //删除时，要先删除 包含别人主键 的。
                            //先删除drag和check表的记录，再删除patient表的记录，最后删除room表的记录
                            patientService.delete(Integer.valueOf(textField.getText()));//先从数据库中删除
                            pane2.update();//更新总表

                            table_del.getItems().removeAll(table_del.getItems());//再删除界面的数据
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
        hBox2.getChildren().addAll(delect, reset);
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

        PatientService patientService = new PatientService();
        RoomService roomService = new RoomService();
        DoctorService doctorService = new DoctorService();

        table.getItems().removeAll(table.getItems());

        List<Patient> list = patientService.list();
        for (Patient patient : list) {
            patient.setRoomDetail(roomService.get(patient.getRoom_id()));
            patient.setDoc_name(doctorService.get(patient.getDoc_id()));//获取主治医师名字
        }

        //ObservableList<Patient> data = FXCollections.observableArrayList(patient);
        table.getItems().addAll(list);
        table.refresh();
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
