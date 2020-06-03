package UI;

import entity.Room;
import entity.Patient;
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
import service.*;

import java.sql.Date;
import java.util.function.UnaryOperator;

public class Pane1 {

    private AnchorPane anchorPane1;
    GridPane gridPane1;

    public Pane1() {
        anchorPane1 = new AnchorPane();
        anchorPane1.setPrefSize(1080, 855);
        anchorPane1.setStyle("-fx-background-color:#ffffff");
        anchorPane1.setVisible(false);
    }

    public void load(AnchorPane anchorPane1) {

        RoomService roomService = new RoomService();
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        CheckService checkService = new CheckService();
        DepartmentService departmentService = new DepartmentService();
        DragService dragService = new DragService();
        Util util = new Util();

        Font font5 = Font.font("YouYuan", FontWeight.BLACK, 16);

        //-------------------------------------------------------------  //分割线

        Label divider1_note = new Label("办理入院");//分割线
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
        comboBox.setPrefWidth(100);
        comboBox.setEditable(false);
        comboBox.setStyle("-fx-background-color: #EEEEEE");
        comboBox.setPromptText("请选择");
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
        tf_inHospital_time.setPromptText("例   2020-03-02");

        Label ward = new Label("病房号");
        ward.setAlignment(Pos.CENTER_RIGHT);
        ward.setPrefSize(100, 20);
        ward.setFont(font3);
        ward.setTextFill(Color.rgb(120, 126, 131));
        ComboBox comboBox2 = new ComboBox();
        comboBox2.setPrefWidth(130);
        comboBox2.setEditable(false);
        comboBox2.setStyle("-fx-background-color: #EEEEEE");
        comboBox2.setPromptText("请选择");
        comboBox2.getItems().addAll(101, 102, 103, 104, 105);

        Label bed = new Label("床位号");
        bed.setAlignment(Pos.CENTER_RIGHT);
        bed.setPrefSize(100, 20);
        bed.setFont(font3);
        bed.setTextFill(Color.rgb(120, 126, 131));
        ComboBox comboBox3 = new ComboBox();
        comboBox3.setPrefWidth(130);
        comboBox3.setEditable(false);
        comboBox3.setStyle("-fx-background-color: #EEEEEE");
        comboBox3.setPromptText("请选择");
        comboBox3.getItems().addAll(1, 2, 3, 4, 5);

        gridPane1 = new GridPane();
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
        gridPane1.add(ward, 0, 5);
        gridPane1.add(comboBox2, 1, 5);
        gridPane1.add(bed, 11, 5);
        gridPane1.add(comboBox3, 12, 5);

        Button save2 = new Button("保存");
        save2.setPrefSize(100, 30);
        save2.setStyle("-fx-background-color: #2475C4");
        save2.setTextFill(Color.rgb(241, 241, 232));
        save2.setFont(font5);
        save2.setOnAction(new EventHandler<ActionEvent>() {  // 入院保存
            @Override
            public void handle(ActionEvent event) {

                //textField的初始内容是"",comboBox只有2种情况，要么为null，要么选择了
                if (tf_name.getText().equals("") || tf_age.getText().equals("") || tf_phone.getText().equals("") || tf_ID.getText().equals("") || tf_card.getText().equals("") || tf_diagnosis.getText().equals("") || tf_doctor.getText().equals("") || tf_inHospital_time.getText().equals("") || comboBox.getValue() == null || comboBox2.getValue() == null || comboBox3.getValue() == null) {
                    util.tip("请完整填写信息！", "入院");
                } else if (util.isExit_ID(tf_card.getText()) == 1) {
                    util.tip("已有该ID的记录，勿重复添加！", "");
                } else if (doctorService.getId(tf_doctor.getText()) == 0) {
                    util.tip("没有该医生！请核查后输入", "");
                } else if (!util.isLegalDate(tf_inHospital_time.getText())) {
                    util.tip("入院时间的格式不对！", "入院");
                } else if (util.isUsed_bed((Integer) comboBox2.getValue(), (Integer) comboBox3.getValue(), tf_card.getText()) == 2) {
                    util.tip("该病房已满！请换病房", "");
                } else if (util.isUsed_bed((Integer) comboBox2.getValue(), (Integer) comboBox3.getValue(), tf_card.getText()) == 1) {
                    util.tip("该床位已经被使用！", "");
                } else {

                    String sex = (String) comboBox.getValue();
                    int ward_id = (Integer) comboBox2.getValue();
                    int bed_id = (Integer) comboBox3.getValue();
                    int id = Integer.parseInt(tf_card.getText());
                    String name = tf_name.getText();
                    int age = Integer.parseInt(tf_age.getText());
                    String diagnose = tf_diagnosis.getText();
                    Date in_time = Date.valueOf(tf_inHospital_time.getText());
                    String phone_number = tf_phone.getText();
                    String identity_card = tf_ID.getText();
                    String doc_name = tf_doctor.getText();

                    int doc_id = doctorService.getId(doc_name);

                    String dept_name = doctorService.get(doctorService.getId(doc_name)).getDept_name();//根据医生名字获取医生所属的科室名，也是病人的科室名

                    int room_id = roomService.add(ward_id, bed_id, dept_name, in_time);//这里room的out_time为null
                    Patient patient = new Patient(id, name, sex, age, phone_number, identity_card, diagnose, doc_id, room_id);
                    patientService.add(patient);

                    util.tip("保存成功！", "入院");
                }
            }
        });

        Button reset2 = new Button("重置");
        reset2.setPrefSize(100, 30);
        reset2.setStyle("-fx-background-color: #2475C4");
        reset2.setTextFill(Color.rgb(241, 241, 232));
        reset2.setFont(font5);
        reset2.setOnAction(new EventHandler<ActionEvent>() {  // 重置1
            @Override
            public void handle(ActionEvent event) {

                Object[] objects = gridPane1.getChildren().toArray();
                for (Object o : objects) {
                    if (o instanceof TextField) {
                        ((TextField) o).setText("");
                    } else if (o instanceof ComboBox) {
                        ((ComboBox) o).setValue(null);
                    } else continue;
                }
            }
        });

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(save2, reset2);
        hBox2.setSpacing(40);

        //-------------------------------------------------------------  //分割线

        Label divider2_note = new Label("办理出院");//分割线
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

        TableView<Patient> table_outHospital = new TableView<>();
        table_outHospital.setEditable(true);
        table_outHospital.setPrefSize(1050, 60);
        TableColumn td1 = new TableColumn("姓名");
        TableColumn td2 = new TableColumn("性别");
        TableColumn td3 = new TableColumn("年龄");
        TableColumn td5 = new TableColumn("手机号");
        TableColumn td4 = new TableColumn("诊断");
        TableColumn td6 = new TableColumn("主治医师");
        TableColumn td7 = new TableColumn("病房号");
        TableColumn td8 = new TableColumn("入院时间");
        td1.setCellValueFactory(new PropertyValueFactory<>("name"));
        td2.setCellValueFactory(new PropertyValueFactory<>("sex"));
        td3.setCellValueFactory(new PropertyValueFactory<>("age"));
        td4.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        td5.setCellValueFactory(new PropertyValueFactory<>("diagnose"));
        td6.setCellValueFactory(new PropertyValueFactory<>("doc_name"));
        td7.setCellValueFactory(new PropertyValueFactory<>("ward_id"));
        td8.setCellValueFactory(new PropertyValueFactory<>("in_time"));
        td1.setPrefWidth(130);
        td2.setPrefWidth(80);
        td3.setPrefWidth(80);
        td4.setPrefWidth(150);
        td5.setPrefWidth(150);
        td6.setPrefWidth(150);
        td7.setPrefWidth(145);
        td8.setPrefWidth(160);
        table_outHospital.getColumns().addAll(td1, td2, td3, td4, td5, td6, td7, td8);
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
        tf_outTime.setPromptText("例   2020-03-02");

        Label recovery = new Label("恢复状况");
        recovery.setAlignment(Pos.CENTER_RIGHT);
        recovery.setPrefSize(100, 20);
        recovery.setFont(font3);
        recovery.setTextFill(Color.rgb(120, 126, 131));
        ComboBox comboBox4 = new ComboBox();
        comboBox4.setPrefWidth(130);
        comboBox4.setEditable(false);
        comboBox4.setStyle("-fx-background-color: #EEEEEE");
        comboBox4.setPromptText("请选择");
        comboBox4.getItems().addAll("健康", "良好", "一般");

        Label cost = new Label("花费总额");
        cost.setAlignment(Pos.CENTER_RIGHT);
        cost.setPrefSize(100, 20);
        cost.setFont(font3);
        cost.setTextFill(Color.rgb(120, 126, 131));
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
        gridPane2.add(yuan, 1, 2);
        gridPane2.add(reimbursement, 11, 2);
        gridPane2.add(proportion, 12, 2);

        Button query = new Button("搜索");
        query.setPrefSize(100, 30);
        query.setStyle("-fx-background-color: #2475C4");
        query.setTextFill(Color.rgb(241, 241, 232));
        query.setFont(font5);
        query.setOnAction(new EventHandler<ActionEvent>() {//搜索
            @Override
            public void handle(ActionEvent event) {

                if (!textField.getText().equals("")) {
                    Patient patient = patientService.get(Integer.valueOf(textField.getText()));
                    if (patient == null) {//根本没有记录
                        util.tip("没有该记录！请输入正确卡号", "");
                        textField.setText("");
                    } else {//有住院记录

                        if (roomService.get(patientService.get(Integer.valueOf(textField.getText())).getRoom_id()).getOut_time() == null) {//住院中，可以办理出院

                            table_outHospital.getItems().removeAll(table_outHospital.getItems());//先将表格和框内容清空
                            patient.setDoc_name(doctorService.get(patient.getDoc_id()));//获取主治医师名字
                            patient.setWard_id(roomService.get(patient.getRoom_id()).getWard_id());//获取病房号
                            patient.setIn_time(roomService.get(patient.getRoom_id()).getIn_time());//获取入院时间
                            table_outHospital.getItems().add(patient);
                            table_outHospital.refresh();

                            yuan.setText(util.calCost(textField.getText()) + "  元");//计算花费总额
                            proportion.setText(util.calProportion(util.calCost(textField.getText())) + "  %");//显示报销比例

                        } else {
                            util.tip("该患者已出院，勿重复办理出院！", "");
                            textField.setText("");
                        }

                    }
                }
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(textField, query);

        Button save1 = new Button("保存");
        save1.setPrefSize(100, 30);
        save1.setStyle("-fx-background-color: #2475C4");
        save1.setTextFill(Color.rgb(241, 241, 232));
        save1.setFont(font5);
        save1.setOnAction(new EventHandler<ActionEvent>() {  // 出院保存
            @Override
            public void handle(ActionEvent event) {

                if (table_outHospital.getItems().isEmpty() || textField.getText().equals("") || tf_outTime.getText().equals("")) {
                    util.tip("请先搜索记录并填写下方信息！", "");//有3个地方不能空
                } else if (patientService.get(Integer.valueOf(textField.getText())) == null) {
                    util.tip("没有该记录！请输入正确卡号", "");
                } else if (roomService.get(patientService.get(Integer.valueOf(textField.getText())).getRoom_id()).getOut_time() != null) {
                    util.tip("该患者已出院，勿重复办理出院！", "");
                } else if (!util.isLegalDate(tf_outTime.getText())) {
                    util.tip("出院时间的格式不正确！", "");
                } else if (!Date.valueOf(tf_outTime.getText()).after(roomService.get(patientService.get(Integer.valueOf(textField.getText())).getRoom_id()).getIn_time())) {
                    util.tip("出院时间必须晚于入院时间！", "");
                } else {

                    Patient patient = patientService.get(Integer.valueOf(textField.getText()));
                    Room room = roomService.get(patient.getRoom_id());

                    room.setOut_time(Date.valueOf(tf_outTime.getText()));
                    roomService.update(room);
                    util.tip("保存成功！", "");
                }

            }
        });

        Button reset = new Button("重置");
        reset.setPrefSize(100, 30);
        reset.setStyle("-fx-background-color: #2475C4");
        reset.setTextFill(Color.rgb(241, 241, 232));
        reset.setFont(font5);
        reset.setOnAction(new EventHandler<ActionEvent>() {  // 重置2
            @Override
            public void handle(ActionEvent event) {

                textField.setText("");
                table_outHospital.getItems().removeAll(table_outHospital.getItems());

                Object[] objects = gridPane2.getChildren().toArray();
                ((TextField) objects[2]).setText("");
                ((ComboBox) objects[4]).setValue(null);
                ((Label) objects[6]).setText("元");
                ((Label) objects[8]).setText("%");
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