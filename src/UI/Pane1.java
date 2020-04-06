package UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

import java.util.function.UnaryOperator;

public class Pane1 {

    private AnchorPane anchorPane1;

    public Pane1() {
        anchorPane1 = new AnchorPane();
        anchorPane1.setPrefSize(1080, 855);
        anchorPane1.setStyle("-fx-background-color:#ffffff");
        anchorPane1.setVisible(false);
    }

    public void load(AnchorPane anchorPane1) {

        Font font5 = Font.font("YouYuan", FontWeight.BLACK, 16);

        //-------------------------------------------------------------  //分割线

        Label divider1_note = new Label("入院");//分割线
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

        Font font4 = Font.font("YouYuan", FontWeight.BLACK, 17);
        Font font3 = Font.font("YouYuan", FontWeight.BLACK, 15);
        int cell = 130;

        Label base_info = new Label("· 基本信息");
        base_info.setPrefSize(100, 20);
        base_info.setAlignment(Pos.CENTER_RIGHT);
        base_info.setTextFill(Color.rgb(36, 117, 196));
        base_info.setFont(font4);

        Label name = new Label("姓名");
        name.setAlignment(Pos.CENTER_RIGHT);
        name.setPrefSize(100, 20);
        name.setFont(font3);
        name.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_name = new TextField();
        tf_name.setPrefWidth(cell);

        Label sex = new Label("性别");
        sex.setAlignment(Pos.CENTER_RIGHT);
        sex.setPrefSize(100, 20);
        sex.setFont(font3);
        sex.setTextFill(Color.rgb(120, 126, 131));
        ComboBox comboBox = new ComboBox();
        comboBox.setPrefWidth(80);
        comboBox.setEditable(true);
        comboBox.getItems().addAll("男", "女");

        Label age = new Label("年龄");
        age.setAlignment(Pos.CENTER_RIGHT);
        age.setPrefSize(100, 20);
        age.setFont(font3);
        age.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_age = new TextField();
        tf_age.setPrefWidth(cell);
        tf_age.setPromptText("例    18");

        Label phone = new Label("手机号");
        phone.setAlignment(Pos.CENTER_RIGHT);
        phone.setPrefSize(100, 20);
        phone.setFont(font3);
        phone.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_phone = new TextField();
        tf_phone.setPrefWidth(cell);


        Label ID = new Label("身份证号");
        ID.setAlignment(Pos.CENTER_RIGHT);
        ID.setPrefSize(100, 20);
        ID.setFont(font3);
        ID.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_ID = new TextField();
        tf_ID.setPrefWidth(cell);

        Label card = new Label("诊疗卡号");
        card.setAlignment(Pos.CENTER_RIGHT);
        card.setPrefSize(100, 20);
        card.setFont(font3);
        card.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_card = new TextField();
        tf_card.setPrefWidth(cell);

        //////////////////////////

        Label inHospital_info = new Label("· 入院信息");
        inHospital_info.setPrefSize(100, 20);
        inHospital_info.setAlignment(Pos.CENTER_RIGHT);
        inHospital_info.setTextFill(Color.rgb(36, 117, 196));
        inHospital_info.setFont(font4);

        Label diagnosis = new Label("诊断");
        diagnosis.setAlignment(Pos.CENTER_RIGHT);
        diagnosis.setPrefSize(100, 20);
        diagnosis.setFont(font3);
        diagnosis.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_diagnosis = new TextField();
        tf_diagnosis.setPrefWidth(cell);

        Label doctor = new Label("主治医师");
        doctor.setAlignment(Pos.CENTER_RIGHT);
        doctor.setPrefSize(100, 20);
        doctor.setFont(font3);
        doctor.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_doctor = new TextField();
        tf_doctor.setPrefWidth(cell);

        Label inHospital_time = new Label("入院时间");
        inHospital_time.setAlignment(Pos.CENTER_RIGHT);
        inHospital_time.setPrefSize(100, 20);
        inHospital_time.setFont(font3);
        inHospital_time.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_inHospital_time = new TextField();
        tf_inHospital_time.setPrefWidth(cell);
        tf_inHospital_time.setPromptText("例    2020-3-2");

        Label department = new Label("科室");
        department.setAlignment(Pos.CENTER_RIGHT);
        department.setPrefSize(100, 20);
        department.setFont(font3);
        department.setTextFill(Color.rgb(120, 126, 131));
        ComboBox comboBox1 = new ComboBox();
        comboBox1.setPrefWidth(130);
        comboBox1.setEditable(true);
        comboBox1.getItems().addAll("内科", "五官科", "儿科", "口腔科", "妇科", "肿瘤科", "皮肤科", "外科", "神经科");

        Label ward = new Label("病房号");
        ward.setAlignment(Pos.CENTER_RIGHT);
        ward.setPrefSize(100, 20);
        ward.setFont(font3);
        ward.setTextFill(Color.rgb(120, 126, 131));
        ComboBox comboBox2 = new ComboBox();
        comboBox2.setPrefWidth(130);
        comboBox2.setEditable(true);
        comboBox2.getItems().addAll(101, 102, 103, 104, 105);

        Label bed = new Label("床位号");
        bed.setAlignment(Pos.CENTER_RIGHT);
        bed.setPrefSize(100, 20);
        bed.setFont(font3);
        bed.setTextFill(Color.rgb(120, 126, 131));
        ComboBox comboBox3 = new ComboBox();
        comboBox3.setPrefWidth(130);
        comboBox3.setEditable(true);
        comboBox3.getItems().addAll(1, 2, 3, 4, 5);

        GridPane gridPane1 = new GridPane();
        gridPane1.setHgap(12);
        gridPane1.setVgap(15);//行距
        gridPane1.setPrefSize(1050, 250);

        gridPane1.add(base_info, 0, 0);
        gridPane1.add(name, 0, 1);
        gridPane1.add(tf_name, 1, 1);
        gridPane1.add(sex, 11, 1);
        gridPane1.add(comboBox, 12, 1);
        gridPane1.add(age, 22, 1);
        gridPane1.add(tf_age, 23, 1);
        gridPane1.add(phone, 0, 2);
        gridPane1.add(tf_phone, 1, 2);
        gridPane1.add(ID, 11, 2);
        gridPane1.add(tf_ID, 12, 2);
        gridPane1.add(card, 22, 2);
        gridPane1.add(tf_card, 23, 2);

        gridPane1.add(inHospital_info, 0, 3);
        gridPane1.add(diagnosis, 0, 4);
        gridPane1.add(tf_diagnosis, 1, 4);
        gridPane1.add(doctor, 11, 4);
        gridPane1.add(tf_doctor, 12, 4);
        gridPane1.add(inHospital_time, 22, 4);
        gridPane1.add(tf_inHospital_time, 23, 4);
        gridPane1.add(department, 0, 5);
        gridPane1.add(comboBox1, 1, 5);
        gridPane1.add(ward, 11, 5);
        gridPane1.add(comboBox2, 12, 5);
        gridPane1.add(bed, 22, 5);
        gridPane1.add(comboBox3, 23, 5);

        Button save2 = new Button("保存");
        save2.setPrefSize(100, 30);
        save2.setStyle("-fx-background-color: #2475C4");
        save2.setTextFill(Color.rgb(241, 241, 232));
        save2.setFont(font5);
        save2.setOnAction(new EventHandler<ActionEvent>() {  // 住院记录
            @Override
            public void handle(ActionEvent event) {
                //把gridpane上的框里的内容汇总在一个字符串数组里，调用胡的方法传给他，让他的方法将数据写进数据库
                //弹窗提示保存成功，可选择清空所有或者保留
                // 有信息没填则失败
                if (!tf_card.getText().equals("")) {
                    String[] s = new String[4];
                    Object object;
                    object = comboBox.getValue();
                    if (object == null) {
                        s[0] = "";
                    } else {
                        s[0] = (String) comboBox.getValue();
                    }
                    object = comboBox1.getValue();
                    if (object == null) {
                        s[1] = "";
                    } else {
                        s[1] = (String) comboBox1.getValue();
                    }
                    object = comboBox2.getValue();
                    if (object == null) {
                        s[2] = "";
                    } else {
                        s[2] = (String) comboBox2.getValue();
                    }
                    object = comboBox3.getValue();
                    if (object == null) {
                        s[3] = "";
                    } else {
                        s[3] = (String) comboBox3.getValue();
                    }
                    String[] tmp = new String[15];
                    tmp[0] = tf_card.getText();
                    tmp[1] = tf_name.getText();
                    tmp[2] = s[0];
                    tmp[3] = tf_age.getText();
                    tmp[4] = tf_diagnosis.getText();
                    tmp[5] = s[1];
                    tmp[6] = s[2];
                    tmp[7] = s[3];
                    tmp[8] = tf_inHospital_time.getText();
                    tmp[9] = "";
                    tmp[10] = tf_phone.getText();
                    tmp[11] = tf_ID.getText();
                    tmp[12] = "";
                    tmp[13] = "";
                    tmp[14] = tf_doctor.getText();
                    //调用胡的方法，把tmp数组传给他，返回成功的话，弹窗提示成功
                    Label tip = new Label("保存成功！");
                    tip.setPrefSize(100, 40);
                    tip.setTextFill(Color.rgb(113, 114, 112));
                    tip.setFont(font5);
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setGraphic(tip);
                    alert.setTitle("入院");
                    alert.setHeaderText("");
                    alert.setContentText("");
                    alert.show();
//                Alert alert1 = new Alert(Alert.AlertType.WARNING);
//                alert1.setGraphic(new Button("保存失败！已有该住院记录。"));
//                alert1.setTitle("入院");
//                alert1.setHeaderText("");
//                alert1.setContentText("");
//                alert1.show();
                }
            }
        });

        Button reset2 = new Button("重置");
        reset2.setPrefSize(100, 30);
        reset2.setStyle("-fx-background-color: #2475C4");
        reset2.setTextFill(Color.rgb(241, 241, 232));
        reset2.setFont(font5);
        reset2.setOnAction(new EventHandler<ActionEvent>() {  // 住院记录
            @Override
            public void handle(ActionEvent event) {
                //遍历gridpane，将框内容设为“”
                Object[] objects = gridPane1.getChildren().toArray();
                for (Object o : objects) {
                    if (o instanceof TextField) {
                        ((TextField) o).setText("");
                    } else if (o instanceof ComboBox) {
                        ((ComboBox) o).setValue(new String(""));
                    } else continue;
                }
            }
        });

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(save2, reset2);
        hBox2.setSpacing(40);

        //-------------------------------------------------------------  //分割线

        Label divider2_note = new Label("出院");//分割线
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

        Font font6 = Font.font("YouYuan", FontWeight.BLACK, 16);

        TableView<Patient> table_outHospital = new TableView<>();
        table_outHospital.setEditable(true);
        table_outHospital.setPrefSize(1050, 60);
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
        td9.setPrefWidth(158);
        td10.setPrefWidth(160);
        //table.setStyle("-fx-background-color:#E6F2FE");
        table_outHospital.getColumns().addAll(td1, td2, td3, td4, td5, td6, td7, td8, td9, td10);
        table_outHospital.setColumnResizePolicy(new Callback<TableView.ResizeFeatures, Boolean>() {
            @Override
            public Boolean call(TableView.ResizeFeatures param) {
                return true;
            }
        });

        TextField textField = new TextField();
        textField.setPrefSize(230, 35);
        textField.requestFocus();
        textField.setPrefColumnCount(5);
        textField.setPromptText("请输入出院者的诊疗卡号");
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

        Button query = new Button("搜索");
        query.setPrefSize(100, 30);
        query.setStyle("-fx-background-color: #2475C4");
        query.setTextFill(Color.rgb(241, 241, 232));
        query.setFont(font5);
        query.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //先将表格和框内容清空，然后调用胡的方法，将s传给他，让他查到后返回patient对象给我，我再插入表格中
                if (!textField.getText().equals("")) {
                    table_outHospital.getItems().removeAll(table_outHospital.getItems());
                    String[] s1 = new String[15];
                    for (int i = 0; i < 15; i++) {
                        s1[i] = Integer.toString(i);
                    }
                    // Patient patient = new Patient(s1[0], s1[1], s1[2], s1[3], s1[4], s1[5], s1[6], s1[7], s1[8], s1[9], s1[10], s1[11], s1[12], s1[13]);
                    Patient patient = new Patient();
                    table_outHospital.getItems().addAll(patient.madeBean(s1));
                    table_outHospital.refresh();
                }
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(textField, query);

        Label label = new Label("· 出院信息");
        label.setPrefSize(100, 20);
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setTextFill(Color.rgb(36, 117, 196));
        label.setFont(font4);

        Label outTime = new Label("出院时间");
        outTime.setAlignment(Pos.CENTER_RIGHT);
        outTime.setPrefSize(100, 20);
        outTime.setFont(font3);
        outTime.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_outTime = new TextField();
        tf_outTime.setPrefWidth(cell);
        tf_outTime.setPromptText("例    2020-3-2");

        Label recovery = new Label("恢复状况");
        recovery.setAlignment(Pos.CENTER_RIGHT);
        recovery.setPrefSize(100, 20);
        recovery.setFont(font3);
        recovery.setTextFill(Color.rgb(120, 126, 131));
        ComboBox comboBox4 = new ComboBox();
        comboBox4.setPrefWidth(130);
        comboBox4.setEditable(true);
        comboBox4.getItems().addAll("健康", "良好", "一般");

        Label cost = new Label("花费总额");
        cost.setAlignment(Pos.CENTER_RIGHT);
        cost.setPrefSize(100, 20);
        cost.setFont(font3);
        cost.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_cost = new TextField();
        tf_cost.setPrefWidth(cell);
        tf_cost.setPromptText("例    500");
        Label yuan = new Label("元");
        yuan.setAlignment(Pos.CENTER_LEFT);
        yuan.setPrefSize(100, 20);
        yuan.setFont(font3);
        yuan.setTextFill(Color.rgb(120, 126, 131));

        Label reimbursement = new Label("报销比例");
        reimbursement.setAlignment(Pos.CENTER_RIGHT);
        reimbursement.setPrefSize(100, 20);
        reimbursement.setFont(font3);
        reimbursement.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_reimbursement = new TextField();
        tf_reimbursement.setPrefWidth(cell);
        tf_reimbursement.setPromptText("例     10");
        Label proportion = new Label("%");
        proportion.setAlignment(Pos.CENTER_LEFT);
        proportion.setPrefSize(100, 20);
        proportion.setFont(font3);
        proportion.setTextFill(Color.rgb(120, 126, 131));

        GridPane gridPane2 = new GridPane();
        gridPane2.setHgap(12);
        gridPane2.setVgap(23);//行距
        gridPane2.setPrefSize(1050, 300);

        gridPane2.add(label, 0, 0);
        gridPane2.add(outTime, 0, 1);
        gridPane2.add(tf_outTime, 1, 1);
        gridPane2.add(recovery, 11, 1);
        gridPane2.add(comboBox4, 12, 1);
        gridPane2.add(cost, 0, 2);
        gridPane2.add(tf_cost, 1, 2);
        gridPane2.add(yuan, 2, 2);
        gridPane2.add(reimbursement, 11, 2);
        gridPane2.add(tf_reimbursement, 12, 2);
        gridPane2.add(proportion, 13, 2);

        Button save1 = new Button("保存");
        save1.setPrefSize(100, 30);
        save1.setStyle("-fx-background-color: #2475C4");
        save1.setTextFill(Color.rgb(241, 241, 232));
        save1.setFont(font5);
        save1.setOnAction(new EventHandler<ActionEvent>() {  // 出院保存
            @Override
            public void handle(ActionEvent event) {
                //将出院时间插入后，传该对象回给胡，让他修改库中这条数据
                // 成功修改记录则弹窗提示，然后可以选择清空所有或保留
                //否则弹窗失败
                if (!table_outHospital.getItems().isEmpty() && !tf_outTime.getText().equals("")) {     //textField.getText()永不为空！！！
                    String[] strings = new String[2];
                    strings[0] = textField.getText();
                    strings[1] = tf_outTime.getText();
                    //调用胡的方法传数组给他，并返回是否修改成功
                    for (int i = 0; i < 2; i++) {
                        System.out.println(strings[i]);
                    }
                    Label tip = new Label("保存成功！");
                    tip.setPrefSize(100, 40);
                    tip.setTextFill(Color.rgb(113, 114, 112));
                    tip.setFont(font5);
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setGraphic(tip);
                    alert.setTitle("出院");
                    alert.setHeaderText("");
                    alert.setContentText("");
                    alert.show();
                }
            }
        });

        Button reset = new Button("重置");
        reset.setPrefSize(100, 30);
        reset.setStyle("-fx-background-color: #2475C4");
        reset.setTextFill(Color.rgb(241, 241, 232));
        reset.setFont(font5);
        reset.setOnAction(new EventHandler<ActionEvent>() {  // 出院重置
            @Override
            public void handle(ActionEvent event) {
                //遍历所有框，设内容为空,将表中内容清空
                textField.setText("");
                table_outHospital.getItems().removeAll(table_outHospital.getItems());
                Object[] objects = gridPane2.getChildren().toArray();
                for (Object o : objects) {
                    if (o instanceof TextField) {
                        ((TextField) o).setText("");
                    } else continue;
                }
            }
        });

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(save1, reset);
        hBox1.setSpacing(40);

        Line line1 = new Line(15, 845, 1065, 845);
        line1.setStroke(Color.valueOf("#5C5D5B"));

        //_____________________________________________________________________________________________

        anchorPane1.getChildren().addAll(divider1, gridPane1, hBox2, divider2, hBox, table_outHospital, gridPane2, hBox1, line1);

        AnchorPane.setLeftAnchor(divider1, 15.0);
        AnchorPane.setTopAnchor(divider1, 15.0);

        AnchorPane.setLeftAnchor(gridPane1, 15.0);
        AnchorPane.setTopAnchor(gridPane1, 75.0);

        AnchorPane.setLeftAnchor(hBox2, 410.0);
        AnchorPane.setTopAnchor(hBox2, 350.0);

        AnchorPane.setLeftAnchor(divider2, 15.0);
        AnchorPane.setTopAnchor(divider2, 415.0);

        AnchorPane.setLeftAnchor(hBox, 15.0);
        AnchorPane.setTopAnchor(hBox, 475.0);

        AnchorPane.setLeftAnchor(table_outHospital, 15.0);
        AnchorPane.setTopAnchor(table_outHospital, 535.0);

        AnchorPane.setLeftAnchor(gridPane2, 15.0);
        AnchorPane.setTopAnchor(gridPane2, 620.0);

        AnchorPane.setLeftAnchor(hBox1, 410.0);
        AnchorPane.setTopAnchor(hBox1, 780.0);
    }


    public AnchorPane getAnchorPane1() {
        return anchorPane1;
    }

    public void setAnchorPane1(AnchorPane anchorPane1) {
        this.anchorPane1 = anchorPane1;
    }
}