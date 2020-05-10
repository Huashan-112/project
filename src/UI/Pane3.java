package UI;

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
    //待做
    //同Pane1 保存前check方法
    private AnchorPane anchorPane3;
    PatientService patientService = new PatientService();
    RoomService roomService = new RoomService();
    DoctorService doctorService = new DoctorService();

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
        Font font6 = Font.font("YouYuan", FontWeight.BLACK, 16);
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
        tf_inHospital_time.setPromptText("例  2020-3-2");

        Label outHospital_time = new Label("出院时间");
        outHospital_time.setAlignment(Pos.CENTER_RIGHT);
        outHospital_time.setPrefSize(100, 20);
        outHospital_time.setFont(font3);
        outHospital_time.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_outHospital_time = new TextField();
        tf_outHospital_time.setPrefWidth(cell);
        tf_outHospital_time.setPromptText("例  2020-3-2");

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

        Label doctor = new Label("主治医师");
        doctor.setAlignment(Pos.CENTER_RIGHT);
        doctor.setPrefSize(100, 20);
        doctor.setFont(font3);
        doctor.setTextFill(Color.rgb(120, 126, 131));
        TextField tf_doctor = new TextField();
        tf_doctor.setPrefWidth(cell);

        gridPane1.setHgap(12);
        gridPane1.setVgap(25);//行距
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
        //诊疗卡号不可修改
        //gridPane1.add(card, 22, 2);
        //gridPane1.add(tf_card, 23, 2);

        gridPane1.add(inHospital_info, 0, 3);
        gridPane1.add(diagnosis, 0, 4);
        gridPane1.add(tf_diagnosis, 1, 4);
        gridPane1.add(inHospital_time, 11, 4);
        gridPane1.add(tf_inHospital_time, 12, 4);
        gridPane1.add(outHospital_time, 22, 4);
        gridPane1.add(tf_outHospital_time, 23, 4);
        gridPane1.add(department, 0, 5);
        gridPane1.add(comboBox1, 1, 5);
        gridPane1.add(ward, 11, 5);
        gridPane1.add(comboBox2, 12, 5);
        gridPane1.add(bed, 22, 5);
        gridPane1.add(comboBox3, 23, 5);
        gridPane1.add(doctor, 0, 6);
        gridPane1.add(tf_doctor, 1, 6);

        Button search = new Button("搜索");
        search.setPrefSize(100, 30);
        search.setStyle("-fx-background-color: #2475C4");
        search.setTextFill(Color.rgb(241, 241, 232));
        search.setFont(font5);
        search.setOnAction(new EventHandler<ActionEvent>() {  // 搜索
            @Override
            public void handle(ActionEvent event) {
                //先将所有框内容清空，然后调用胡的方法，将s传给他，让他查到后返回patient对象给我，我再全部显示在框中
                Object[] objects = gridPane1.getChildren().toArray();
                for (Object o : objects) {
                    if (o instanceof TextField) {
                        ((TextField) o).setText("");
                    }
                    if (o instanceof ComboBox) {
                        ((ComboBox) o).setValue(new String(""));
                    }
                }
                /////调用胡的方法得到字符串数组
                int id = Integer.parseInt(textField.getText());
                Patient patient = patientService.get(id);
                patient.setRoomDetail(roomService.get(patient.getRoom_id()));
                patient.setDoc_name(doctorService.get(patient.getDoc_id()));

                tf_name.setText(patient.getName());
                comboBox.setValue(patient.getSex());
                tf_age.setText(patient.getAge()+"");
                tf_diagnosis.setText(patient.getDiagnose());
                comboBox1.setValue(patient.getDept_name());
                comboBox2.setValue(patient.getWard_id());
                comboBox3.setValue(patient.getBed_id());
                tf_inHospital_time.setText(patient.getIn_time().toString());
                tf_outHospital_time.setText(patient.getOut_time().toString());
                tf_phone.setText(patient.getPhone_number());
                tf_ID.setText(patient.getIdentity_card());
                tf_doctor.setText(patient.getDoc_name());
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(textField, search);

        Button save2 = new Button("保存");
        save2.setPrefSize(100, 40);
        save2.setStyle("-fx-background-color: #2475C4");
        save2.setTextFill(Color.rgb(241, 241, 232));
        save2.setFont(font5);
        save2.setOnAction(new EventHandler<ActionEvent>() {  // 保存修改
            @Override
            public void handle(ActionEvent event) {
                //把gridpane上的框里的内容汇总在一个patient对象里，调用胡的方法传给他，让他的方法将数据写进数据库
                //弹窗提示保存成功，可选择清空所有或者保留
                // 有信息没填则失败
                if (!textField.getText().equals("")) {


                    int id = Integer.parseInt(textField.getText()); //诊疗卡号
                    String name = tf_name.getText();
                    int age = Integer.parseInt(tf_age.getText());
                    String diagnose = tf_diagnosis.getText();
                    Date in_time = Date.valueOf(tf_inHospital_time.getText());
                    Date out_time = Date.valueOf(tf_outHospital_time.getText());
                    String phone_number = tf_phone.getText();
                    String identity_card = tf_ID.getText();
                    String doc_name = tf_doctor.getText();
                    //System.out.println(doc_name);
                    //get id
                    int doc_id = doctorService.getId(doc_name);
                    String sex = comboBox.getValue().toString();
                    String dept_name = comboBox1.getValue().toString();
                    int ward_id = Integer.parseInt(comboBox2.getValue().toString());
                    int bed_id = Integer.parseInt(comboBox3.getValue().toString());

                    Patient p1 = patientService.get(id);
                    int room_id = p1.getRoom_id();
                    Patient patient = new Patient(id,name,sex,age,phone_number,identity_card,diagnose,doc_id,room_id);
                    Room room = new Room(room_id,ward_id,bed_id,dept_name,in_time,out_time);

                    //update
                    patientService.update(patient);
                    roomService.update(room);

                    //假设已经修改成功，然后弹窗
                    Label tip = new Label("修改成功！");
                    tip.setPrefSize(100, 40);
                    tip.setTextFill(Color.rgb(113, 114, 112));
                    tip.setFont(font5);
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setGraphic(tip);
                    alert.setTitle("修改");
                    alert.setHeaderText("");
                    alert.setContentText("");
                    alert.show();
                    //如果找不到该诊疗卡号，则弹窗提示无该记录
//                    Label tip1 = new Label("没有该卡号的住院记录！");
//                    tip1.setPrefSize(200, 40);
//                    tip1.setTextFill(Color.rgb(113, 114, 112));
//                    tip1.setFont(font5);
//                    Alert alert1 = new Alert(Alert.AlertType.WARNING);
//                    alert1.setGraphic(tip1);
//                    alert1.setTitle("");
//                    alert1.setHeaderText("");
//                    alert1.setContentText("");
//                    alert1.show();
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
                //遍历gridpane，将框内容设为“”
                textField.setText("");
                Object[] objects = gridPane1.getChildren().toArray();
                for (Object o : objects) {
                    if (o instanceof TextField) {
                        ((TextField) o).setText("");
                    }
                    if (o instanceof ComboBox) {
                        ((ComboBox) o).setValue(new String(""));
                    }
                }
            }
        });

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(save2, reset2);
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

    public void setAnchorPane3(AnchorPane anchorPane3) {
        this.anchorPane3 = anchorPane3;
    }
}
