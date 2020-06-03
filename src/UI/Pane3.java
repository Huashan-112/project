package UI;

import dao.DoctorDAO;
import entity.Doctor;
import entity.Patient;
import entity.Room;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import service.*;

import java.sql.Date;
import java.util.function.UnaryOperator;

public class Pane3 {

    private AnchorPane anchorPane3;

    public Pane3() {
        anchorPane3 = new AnchorPane();
        anchorPane3.setVisible(false);
        anchorPane3.setPrefSize(1080, 855);
        anchorPane3.setStyle("-fx-background-color:#ffffff");
    }

    public void load(AnchorPane anchorPane3) {

        RoomService roomService = new RoomService();
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        DoctorDAO doctorDAO = new DoctorDAO();
        CheckService checkService = new CheckService();
        DepartmentService departmentService = new DepartmentService();
        DragService dragService = new DragService();
        Util util = new Util();

        Font font5 = Font.font("YouYuan", FontWeight.BLACK, 16);
        GridPane gridPane1 = new GridPane();

        //-------------------------------------------------------------  //分割线

        Label divider1_note = new Label("修改住院记录");//分割线
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

        TextField textField = new TextField();
        textField.setPrefSize(238, 35);
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

        Line line4 = new Line(37, 190, 993, 190);
        line4.setStroke(Color.valueOf("#A9ABA7"));

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

        Label inHospital_info = new Label("· 住院信息");
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

        Label inHospital_time = new Label("入院时间");
        inHospital_time.setAlignment(Pos.CENTER_RIGHT);
        inHospital_time.setPrefSize(100, 20);
        inHospital_time.setFont(font3);
        inHospital_time.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_inHospital_time = new TextField();
        tf_inHospital_time.setPrefWidth(cell);
        tf_inHospital_time.setPromptText("例  2020-03-02");

        Label outHospital_time = new Label("出院时间");
        outHospital_time.setAlignment(Pos.CENTER_RIGHT);
        outHospital_time.setPrefSize(100, 20);
        outHospital_time.setFont(font3);
        outHospital_time.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_outHospital_time = new TextField();
        tf_outHospital_time.setPrefWidth(cell);
        tf_outHospital_time.setPromptText("例  2020-03-02");

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

        Label doctor = new Label("主治医师");
        doctor.setAlignment(Pos.CENTER_RIGHT);
        doctor.setPrefSize(100, 20);
        doctor.setFont(font3);
        doctor.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_doctor = new TextField();
        tf_doctor.setPrefWidth(cell);

        gridPane1.setHgap(12);
        gridPane1.setVgap(35);//行距
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

        gridPane1.add(inHospital_info, 0, 3);
        gridPane1.add(diagnosis, 0, 4);
        gridPane1.add(tf_diagnosis, 1, 4);
        gridPane1.add(inHospital_time, 11, 4);
        gridPane1.add(tf_inHospital_time, 12, 4);
        gridPane1.add(outHospital_time, 22, 4);
        gridPane1.add(tf_outHospital_time, 23, 4);
        gridPane1.add(ward, 11, 5);
        gridPane1.add(comboBox2, 12, 5);
        gridPane1.add(bed, 22, 5);
        gridPane1.add(comboBox3, 23, 5);
        gridPane1.add(doctor, 0, 5);
        gridPane1.add(tf_doctor, 1, 5);

        Button search = new Button("搜索");
        search.setPrefSize(100, 30);
        search.setStyle("-fx-background-color: #2475C4");
        search.setTextFill(Color.rgb(241, 241, 232));
        search.setFont(font5);
        search.setOnAction(new EventHandler<ActionEvent>() {  // 搜索
            @Override
            public void handle(ActionEvent event) {

                if (!textField.getText().equals("")) {

                    Patient patient = patientService.get(Integer.valueOf(textField.getText()));

                    if (patient == null) {
                        util.tip("没有该记录！请输入正确的卡号", "");
                        textField.setText("");
                    } else {//有记录

                        //显示数据
                        patient.setRoomDetail(roomService.get(patient.getRoom_id()));
                        patient.setDoc_name(doctorService.get(patient.getDoc_id()));

                        tf_name.setText(patient.getName());
                        comboBox.setValue(patient.getSex());
                        tf_age.setText(patient.getAge() + "");
                        tf_phone.setText(patient.getPhone_number());
                        tf_ID.setText(patient.getIdentity_card());
                        tf_diagnosis.setText(patient.getDiagnose());
                        tf_inHospital_time.setText(patient.getIn_time().toString());
                        comboBox2.setValue(patient.getWard_id());
                        comboBox3.setValue(patient.getBed_id());
                        tf_doctor.setText(patient.getDoc_name());
                        if (patient.getOut_time() == null) {
                            tf_outHospital_time.setText("");//显示为空，表示还在住院中
                        } else {
                            tf_outHospital_time.setText(patient.getOut_time().toString());
                        }
                    }
                }
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(textField, search);

        Button save2 = new Button("保存");
        save2.setPrefSize(100, 40);
        save2.setStyle("-fx-background-color: #2475C4");
        save2.setTextFill(Color.rgb(241, 241, 232));
        save2.setFont(font5);
        save2.setOnAction(new EventHandler<ActionEvent>() { //保存修改
            @Override
            public void handle(ActionEvent event) {

                if (textField.getText().equals("") || tf_name.getText().equals("") || comboBox.getValue() == null || tf_age.getText().equals("") || tf_phone.getText().equals("") || tf_ID.getText().equals("") || tf_diagnosis.getText().equals("") || tf_inHospital_time.getText().equals("") || comboBox2.getValue() == null || comboBox3.getValue() == null || tf_doctor.getText().equals("")) {
                    util.tip("请完整填写信息！", "");
                } else if (patientService.get(Integer.parseInt(textField.getText())) == null) {
                    util.tip("没有该病人！", "");
                } else if (!util.isLegalDate(tf_inHospital_time.getText())) {
                    util.tip("入院时间的格式不正确！", "");
                } else if (roomService.get(patientService.get(Integer.parseInt(textField.getText())).getRoom_id()).getOut_time() == null && !tf_outHospital_time.getText().equals("")) {
                    util.tip("该患者住院中，禁止填写出院时间！", "");
                } else if (roomService.get(patientService.get(Integer.parseInt(textField.getText())).getRoom_id()).getOut_time() != null && tf_outHospital_time.getText().equals("")) {
                    util.tip("该患者已出院，出院时间不能为空！", "");
                } else if (roomService.get(patientService.get(Integer.parseInt(textField.getText())).getRoom_id()).getOut_time() != null && !tf_outHospital_time.getText().equals("") && !util.isLegalDate(tf_outHospital_time.getText())) {
                    util.tip("出院时间格式不正确！", "");
                } else if (roomService.get(patientService.get(Integer.parseInt(textField.getText())).getRoom_id()).getOut_time() != null && !tf_outHospital_time.getText().equals("") && util.isLegalDate(tf_outHospital_time.getText()) && !Date.valueOf(tf_outHospital_time.getText()).after(Date.valueOf(tf_inHospital_time.getText()))) {
                    util.tip("出院时间必须晚于入院时间！", "");
                } else if (doctorDAO.get(tf_doctor.getText()) == null) {
                    util.tip("没有该医生！请核对后输入", "");
                } else if (util.isUsed_bed((Integer) comboBox2.getValue(), (Integer) comboBox3.getValue(), textField.getText()) == 2) {
                    util.tip("该病房已满！请换病房", "");
                } else if (util.isUsed_bed((Integer) comboBox2.getValue(), (Integer) comboBox3.getValue(), textField.getText()) == 1) {
                    util.tip("该床位已经被使用！", "");
                } else {

                    Date out_time;
                    if (tf_outHospital_time.getText().equals("")) {
                        out_time = null;//表示还在住院中
                    } else {
                        out_time = Date.valueOf(tf_outHospital_time.getText());
                    }

                    int doc_id = doctorService.getId(tf_doctor.getText());   //get doctor id
                    int id = Integer.parseInt(textField.getText()); //诊疗卡号
                    String name = tf_name.getText();
                    int age = Integer.parseInt(tf_age.getText());
                    String diagnose = tf_diagnosis.getText();
                    Date in_time = Date.valueOf(tf_inHospital_time.getText());
                    String phone_number = tf_phone.getText();
                    String identity_card = tf_ID.getText();
                    String sex = comboBox.getValue().toString();
                    int ward_id = Integer.parseInt(comboBox2.getValue().toString());
                    int bed_id = Integer.parseInt(comboBox3.getValue().toString());
                    String dept_name = doctorService.get(doctorService.getId(tf_doctor.getText())).getDept_name();//根据医生名字获取医生所属的科室名，也是病人的科室名

                    Patient p1 = patientService.get(id);
                    int room_id = p1.getRoom_id();
                    Patient patient = new Patient(id, name, sex, age, phone_number, identity_card, diagnose, doc_id, room_id);
                    Room room = new Room(room_id, ward_id, bed_id, dept_name, in_time, out_time);

                    //update
                    patientService.update(patient);
                    roomService.update(room);

                    util.tip("修改成功！", "");
                }
            }
        });

        Button reset2 = new Button("重置");
        reset2.setPrefSize(100, 40);
        reset2.setStyle("-fx-background-color: #2475C4");
        reset2.setTextFill(Color.rgb(241, 241, 232));
        reset2.setFont(font5);
        reset2.setOnAction(new EventHandler<ActionEvent>() {  // 重置
            @Override
            public void handle(ActionEvent event) {

                //遍历gridPane，将框内容设为""
                textField.setText("");
                Object[] objects = gridPane1.getChildren().toArray();
                for (Object o : objects) {
                    if (o instanceof TextField) {
                        ((TextField) o).setText("");
                    }
                    if (o instanceof ComboBox) {
                        ((ComboBox) o).setValue(null);
                    }
                }
            }
        });

        HBox hBox2 = new HBox();
        hBox2.getChildren().

                addAll(save2, reset2);
        hBox2.setSpacing(40);

        Line line1 = new Line(15, 845, 1065, 845);
        line1.setStroke(Color.valueOf("#5C5D5B"));

        Line line2 = new Line(17, 68, 17, 845);
        line2.setStroke(Color.valueOf("#E0E0E0"));

        Line line3 = new Line(1063, 68, 1063, 845);
        line3.setStroke(Color.valueOf("#E0E0E0"));

        //_____________________________________________________________________________________________

        anchorPane3.getChildren().addAll(divider1, hBox, line4, gridPane1, hBox2, line1, line2, line3);

        AnchorPane.setLeftAnchor(divider1, 15.0);
        AnchorPane.setTopAnchor(divider1, 20.0);

        AnchorPane.setLeftAnchor(hBox, 39.0);
        AnchorPane.setTopAnchor(hBox, 110.0);

        AnchorPane.setLeftAnchor(gridPane1, 15.0);
        AnchorPane.setTopAnchor(gridPane1, 240.0);

        AnchorPane.setLeftAnchor(hBox2, 410.0);
        AnchorPane.setTopAnchor(hBox2, 650.0);
    }

    public AnchorPane getAnchorPane3() {
        return anchorPane3;
    }
}
