package UI;

import entity.Drag;
import entity.Patient;
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

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Pane4 {

    private AnchorPane anchorPane4;

    public Pane4() {
        anchorPane4 = new AnchorPane();
        anchorPane4.setVisible(false);
        anchorPane4.setPrefSize(1080, 855);
        anchorPane4.setStyle("-fx-background-color:#ffffff");
    }

    public void load(AnchorPane anchorPane4) {

        RoomService roomService = new RoomService();
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        CheckService checkService = new CheckService();
        DepartmentService departmentService = new DepartmentService();
        DragService dragService = new DragService();
        Util util = new Util();

        Font font1 = Font.font("YouYuan", FontWeight.BLACK, 16);
        Font font3 = Font.font("YouYuan", FontWeight.BLACK, 15);
        Font font4 = Font.font("YouYuan", FontWeight.BLACK, 19);

        Label label = new Label("治疗方案  ");
        label.setPrefSize(80, 34);
        label.setFont(font1);
        label.setTextFill(Color.rgb(120, 126, 131));

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

        Line line = new Line(15, 75, 1065, 75);
        line.setStroke(Color.valueOf("#BCBEBA"));

        Label name = new Label("姓名：");
        name.setPrefSize(190, 40);
        name.setTextFill(Color.rgb(120, 126, 131));
        name.setFont(font1);

        Label sex = new Label("性别：");
        sex.setPrefSize(190, 40);
        sex.setTextFill(Color.rgb(120, 126, 131));
        sex.setFont(font1);


        Label age = new Label("年龄：");
        age.setPrefSize(190, 40);
        age.setTextFill(Color.rgb(120, 126, 131));
        age.setFont(font1);


        Label diagnosis = new Label("诊断：");
        diagnosis.setPrefSize(190, 40);
        diagnosis.setTextFill(Color.rgb(120, 126, 131));
        diagnosis.setFont(font1);

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(name, sex, age, diagnosis);
        hBox1.setSpacing(60);

        Button query = new Button("搜索");
        query.setPrefSize(100, 30);
        query.setStyle("-fx-background-color: #2475C4");
        query.setTextFill(Color.rgb(241, 241, 232));
        query.setFont(font1);
        query.setOnAction(new EventHandler<ActionEvent>() {  //  搜索
            @Override
            public void handle(ActionEvent event) {

                if (!textField.getText().equals("")) {
                    Patient patient = patientService.get(Integer.valueOf(textField.getText()));
                    if (patient != null) {
                        name.setText("姓名：" + patient.getName());
                        sex.setText("性别：" + patient.getSex());
                        age.setText("年龄：" + patient.getAge());
                        diagnosis.setText("诊断：" + patient.getDiagnose());
                    } else {
                        util.tip("未找到该卡号的病人!", "");
                        textField.setText("");
                    }
                }
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(label, textField, query);


        //-------------------------------------------------------------  //分割线

        Label divider1_note = new Label("开药");//分割线
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

        Label label1 = new Label("抗生素类");
        label1.setAlignment(Pos.CENTER_RIGHT);
        label1.setPrefSize(100, 20);
        label1.setFont(font3);
        label1.setTextFill(Color.rgb(120, 126, 131));

        Label label2 = new Label("激素类");
        label2.setAlignment(Pos.CENTER_RIGHT);
        label2.setPrefSize(100, 20);
        label2.setFont(font3);
        label2.setTextFill(Color.rgb(120, 126, 131));

        Label label3 = new Label("抗风湿类");
        label3.setAlignment(Pos.CENTER_RIGHT);
        label3.setPrefSize(100, 20);
        label3.setFont(font3);
        label3.setTextFill(Color.rgb(120, 126, 131));

        Label label4 = new Label("皮肤类");
        label4.setAlignment(Pos.CENTER_RIGHT);
        label4.setPrefSize(100, 20);
        label4.setFont(font3);
        label4.setTextFill(Color.rgb(120, 126, 131));

        Label label5 = new Label("抗肿瘤");
        label5.setAlignment(Pos.CENTER_RIGHT);
        label5.setPrefSize(100, 20);
        label5.setFont(font3);
        label5.setTextFill(Color.rgb(120, 126, 131));

        Label label6 = new Label("抗过敏");
        label6.setAlignment(Pos.CENTER_RIGHT);
        label6.setPrefSize(100, 20);
        label6.setFont(font3);
        label6.setTextFill(Color.rgb(120, 126, 131));

        Label label7 = new Label("注射剂类");
        label7.setAlignment(Pos.CENTER_RIGHT);
        label7.setPrefSize(100, 20);
        label7.setFont(font3);
        label7.setTextFill(Color.rgb(120, 126, 131));

        Label label8 = new Label("心脑血管类");
        label8.setAlignment(Pos.CENTER_RIGHT);
        label8.setPrefSize(100, 20);
        label8.setFont(font3);
        label8.setTextFill(Color.rgb(120, 126, 131));

        ComboBox<String> comboBox1 = new ComboBox<>();
        comboBox1.setPrefWidth(120);
        comboBox1.setEditable(false);
        comboBox1.setStyle("-fx-background-color: #F1F1F1");
        comboBox1.setPromptText("请选择");
        comboBox1.getItems().addAll("头孢匹罗", "罗红霉素");
        ComboBox<Integer> comboBox1_num = new ComboBox<>();
        comboBox1_num.setPrefWidth(70);
        comboBox1_num.setEditable(false);
        comboBox1_num.setStyle("-fx-background-color: #F1F1F1");
        comboBox1_num.setPromptText("份");
        comboBox1_num.getItems().addAll(1, 2, 3, 4, 5);

        ComboBox<String> comboBox2 = new ComboBox<>();
        comboBox2.setPrefWidth(120);
        comboBox2.setEditable(false);
        comboBox2.setStyle("-fx-background-color: #F1F1F1");
        comboBox2.setPromptText("请选择");
        comboBox2.getItems().addAll("地塞米松", "泼尼松龙");
        ComboBox<Integer> comboBox2_num = new ComboBox<>();
        comboBox2_num.setPrefWidth(70);
        comboBox2_num.setEditable(false);
        comboBox2_num.setStyle("-fx-background-color: #F1F1F1");
        comboBox2_num.setPromptText("份");
        comboBox2_num.getItems().addAll(1, 2, 3, 4, 5);

        ComboBox<String> comboBox3 = new ComboBox<>();
        comboBox3.setPrefWidth(120);
        comboBox3.setEditable(false);
        comboBox3.setStyle("-fx-background-color: #F1F1F1");
        comboBox3.setPromptText("请选择");
        comboBox3.getItems().addAll("布洛芬", "他克莫司");
        ComboBox<Integer> comboBox3_num = new ComboBox<>();
        comboBox3_num.setPrefWidth(70);
        comboBox3_num.setEditable(false);
        comboBox3_num.setStyle("-fx-background-color: #F1F1F1");
        comboBox3_num.setPromptText("份");
        comboBox3_num.getItems().addAll(1, 2, 3, 4, 5);

        ComboBox<String> comboBox4 = new ComboBox<>();
        comboBox4.setPrefWidth(120);
        comboBox4.setEditable(false);
        comboBox4.setStyle("-fx-background-color: #F1F1F1");
        comboBox4.setPromptText("请选择");
        comboBox4.getItems().addAll("曲安奈德", "阿昔洛韦");
        ComboBox<Integer> comboBox4_num = new ComboBox<>();
        comboBox4_num.setPrefWidth(70);
        comboBox4_num.setEditable(false);
        comboBox4_num.setStyle("-fx-background-color: #F1F1F1");
        comboBox4_num.setPromptText("份");
        comboBox4_num.getItems().addAll(1, 2, 3, 4, 5);

        ComboBox<String> comboBox5 = new ComboBox<>();
        comboBox5.setPrefWidth(120);
        comboBox5.setEditable(false);
        comboBox5.setStyle("-fx-background-color: #EEEEEE");
        comboBox5.setPromptText("请选择");
        comboBox5.getItems().addAll("舒尼替尼", "利妥昔");
        ComboBox<Integer> comboBox5_num = new ComboBox<>();
        comboBox5_num.setPrefWidth(70);
        comboBox5_num.setEditable(false);
        comboBox5_num.setStyle("-fx-background-color: #F1F1F1");
        comboBox5_num.setPromptText("份");
        comboBox5_num.getItems().addAll(1, 2, 3, 4, 5);

        ComboBox<String> comboBox6 = new ComboBox<>();
        comboBox6.setPrefWidth(120);
        comboBox6.setEditable(false);
        comboBox6.setStyle("-fx-background-color: #EEEEEE");
        comboBox6.setPromptText("请选择");
        comboBox6.getItems().addAll("氯雷他定", "左西替利");
        ComboBox<Integer> comboBox6_num = new ComboBox<>();
        comboBox6_num.setPrefWidth(70);
        comboBox6_num.setEditable(false);
        comboBox6_num.setStyle("-fx-background-color: #F1F1F1");
        comboBox6_num.setPromptText("份");
        comboBox6_num.getItems().addAll(1, 2, 3, 4, 5);

        ComboBox<String> comboBox7 = new ComboBox<>();
        comboBox7.setPrefWidth(120);
        comboBox7.setEditable(false);
        comboBox7.setStyle("-fx-background-color: #EEEEEE");
        comboBox7.setPromptText("请选择");
        comboBox7.getItems().addAll("利巴韦林", "氨甲环酸");
        ComboBox<Integer> comboBox7_num = new ComboBox<>();
        comboBox7_num.setPrefWidth(70);
        comboBox7_num.setEditable(false);
        comboBox7_num.setStyle("-fx-background-color: #F1F1F1");
        comboBox7_num.setPromptText("份");
        comboBox7_num.getItems().addAll(1, 2, 3, 4, 5);

        ComboBox<String> comboBox8 = new ComboBox<>();
        comboBox8.setPrefWidth(120);
        comboBox8.setEditable(false);
        comboBox8.setStyle("-fx-background-color: #EEEEEE");
        comboBox8.setPromptText("请选择");
        comboBox8.getItems().addAll("硝酸甘油", "卡托普利");
        ComboBox<Integer> comboBox8_num = new ComboBox<>();
        comboBox8_num.setPrefWidth(70);
        comboBox8_num.setEditable(false);
        comboBox8_num.setStyle("-fx-background-color: #F1F1F1");
        comboBox8_num.setPromptText("份");
        comboBox8_num.getItems().addAll(1, 2, 3, 4, 5);

        GridPane gridPane1 = new GridPane();
        gridPane1.setHgap(10);
        gridPane1.setVgap(24);//行距
        gridPane1.setPrefSize(1050, 250);

        gridPane1.add(label1, 0, 1);
        gridPane1.add(comboBox1, 1, 1);
        gridPane1.add(comboBox1_num, 2, 1);

        gridPane1.add(label2, 6, 1);
        gridPane1.add(comboBox2, 7, 1);
        gridPane1.add(comboBox2_num, 8, 1);

        gridPane1.add(label3, 12, 1);
        gridPane1.add(comboBox3, 13, 1);
        gridPane1.add(comboBox3_num, 14, 1);

        gridPane1.add(label4, 0, 2);
        gridPane1.add(comboBox4, 1, 2);
        gridPane1.add(comboBox4_num, 2, 2);

        gridPane1.add(label5, 6, 2);
        gridPane1.add(comboBox5, 7, 2);
        gridPane1.add(comboBox5_num, 8, 2);

        gridPane1.add(label6, 12, 2);
        gridPane1.add(comboBox6, 13, 2);
        gridPane1.add(comboBox6_num, 14, 2);

        gridPane1.add(label7, 0, 3);
        gridPane1.add(comboBox7, 1, 3);
        gridPane1.add(comboBox7_num, 2, 3);

        gridPane1.add(label8, 6, 3);
        gridPane1.add(comboBox8, 7, 3);
        gridPane1.add(comboBox8_num, 8, 3);

        Button save1 = new Button("保存");
        save1.setPrefSize(100, 30);
        save1.setStyle("-fx-background-color: #2475C4");
        save1.setTextFill(Color.rgb(241, 241, 232));
        save1.setFont(font1);
        save1.setOnAction(new EventHandler<ActionEvent>() {  // 保存开药
            @Override
            public void handle(ActionEvent event) {

                if (!name.getText().equals("姓名：") && !textField.getText().equals("")) {

                    Object[] objects = gridPane1.getChildren().toArray();

                    if (util.has_Medicine(objects) == true) {//判断有无开药，true表示有开药

                        if (util.has_Num(objects) == false) {//判断开的药有无选择数量，false表示有药品没有选择数量
                            util.tip("请为药品选择数量！", "");
                        } else {//选择了数量

                            List<Drag> drags = new ArrayList<>();
                            for (int i = 1; i < objects.length; i = i + 3) {
                                if (((ComboBox) objects[i]).getValue() != null) {
                                    int id = 31;//id怎么获取？？？？
                                    String name = (String) ((ComboBox) objects[i]).getValue();
                                    String category = "处方药";
                                    Float price = 50.0f;//价格怎么获取？？？
                                    int count = (int) ((ComboBox) objects[i + 1]).getValue();
                                    int pt_id = Integer.parseInt(textField.getText());
                                    Drag drag = new Drag(id, name, category, price, count, pt_id);
                                    drags.add(drag);
                                }
                            }

                            //在这里调用胡的方法，传递drags集合给他
                            util.tip("开药成功！", "");

                        }
                    }
                }
            }
        });

        Button reset = new Button("重置");
        reset.setPrefSize(100, 30);
        reset.setStyle("-fx-background-color: #2475C4");
        reset.setTextFill(Color.rgb(241, 241, 232));
        reset.setFont(font1);
        reset.setOnAction(new EventHandler<ActionEvent>()

        {  // 重置开药
            @Override
            public void handle(ActionEvent event) {

                Object[] objects = gridPane1.getChildren().toArray();
                for (Object o : objects) {
                    if (o instanceof ComboBox) {
                        ((ComboBox) o).setValue(null);
                    }
                }
            }
        });

        HBox hBox2 = new HBox();
        hBox2.getChildren().

                addAll(save1, reset);
        hBox2.setSpacing(40);

        //-------------------------------------------------------------  //分割线

        Label divider2_note = new Label("开立检查项目");//分割线
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
        divider2.getChildren().

                addAll(divider2_decoration, divider2_note);
        AnchorPane.setLeftAnchor(divider2_note, 35.0);
        AnchorPane.setTopAnchor(divider2_note, 5.0);

        //lable--------------------------------------------------------  //分割线

        Label label9 = new Label("· 检验");
        label9.setPrefSize(100, 20);
        label9.setAlignment(Pos.CENTER_RIGHT);
        label9.setTextFill(Color.rgb(36, 117, 196));
        label9.setFont(font4);

        Label label10 = new Label("· 影像");
        label10.setPrefSize(100, 20);
        label10.setAlignment(Pos.CENTER_RIGHT);
        label10.setTextFill(Color.rgb(36, 117, 196));
        label10.setFont(font4);

        Label label11 = new Label("· 腔镜");
        label11.setPrefSize(100, 20);
        label11.setAlignment(Pos.CENTER_RIGHT);
        label11.setTextFill(Color.rgb(36, 117, 196));
        label11.setFont(font4);

        CheckBox checkBox1 = new CheckBox("血常规");
        CheckBox checkBox2 = new CheckBox("肝功能");
        CheckBox checkBox3 = new CheckBox("血脂");
        CheckBox checkBox4 = new CheckBox("肾功能");
        CheckBox checkBox5 = new CheckBox("尿常规");
        CheckBox checkBox6 = new CheckBox("肿瘤标志物");
        CheckBox checkBox7 = new CheckBox("CT");
        CheckBox checkBox8 = new CheckBox("核磁共振");
        CheckBox checkBox9 = new CheckBox("B超");
        CheckBox checkBox10 = new CheckBox("X光");
        CheckBox checkBox11 = new CheckBox("胸片");
        CheckBox checkBox12 = new CheckBox("胃镜");
        CheckBox checkBox13 = new CheckBox("肠镜");
        CheckBox checkBox14 = new CheckBox("腹腔镜");
        CheckBox checkBox15 = new CheckBox("宫腔镜");

        GridPane gridPane2 = new GridPane();
        gridPane2.setHgap(25);
        gridPane2.setVgap(22);//行距
        gridPane2.setPrefSize(1050, 250);

        gridPane2.add(label9, 1, 0);
        gridPane2.add(label10, 1, 2);
        gridPane2.add(label11, 1, 4);
        gridPane2.add(checkBox1, 7, 0);
        gridPane2.add(checkBox2, 14, 0);
        gridPane2.add(checkBox3, 21, 0);
        gridPane2.add(checkBox4, 7, 1);
        gridPane2.add(checkBox5, 14, 1);
        gridPane2.add(checkBox6, 21, 1);
        gridPane2.add(checkBox7, 7, 2);
        gridPane2.add(checkBox8, 14, 2);
        gridPane2.add(checkBox9, 21, 2);
        gridPane2.add(checkBox10, 7, 3);
        gridPane2.add(checkBox11, 14, 3);
        gridPane2.add(checkBox12, 7, 4);
        gridPane2.add(checkBox13, 14, 4);
        gridPane2.add(checkBox14, 21, 4);
        gridPane2.add(checkBox15, 7, 5);

        Button save2 = new Button("保存");
        save2.setPrefSize(100, 30);
        save2.setStyle("-fx-background-color: #2475C4");
        save2.setTextFill(Color.rgb(241, 241, 232));
        save2.setFont(font1);
        save2.setOnAction(new EventHandler<ActionEvent>()

        {  // 保存检查
            @Override
            public void handle(ActionEvent event) {

                if (!name.getText().equals("姓名：") && !textField.getText().equals("")) {
                    //获取诊疗卡号和所开的检查项目，调用胡的方法传递给胡
                    StringBuilder stringBuilder = new StringBuilder("");
                    Object[] objects = gridPane2.getChildren().toArray();
                    for (Object o : objects) {
                        if (o instanceof CheckBox) {
                            if (((CheckBox) o).isSelected()) {         //被选中
                                stringBuilder.append(((CheckBox) o).getText());
                                stringBuilder.append(" ");
                            }
                        }
                    }
                    System.out.println(textField.getText());
                    System.out.println(stringBuilder.toString());

                    util.tip("开立检查成功！", "");
                }
            }
        });

        Button reset2 = new Button("重置");
        reset2.setPrefSize(100, 30);
        reset2.setStyle("-fx-background-color: #2475C4");
        reset2.setTextFill(Color.rgb(241, 241, 232));
        reset2.setFont(font1);
        reset2.setOnAction(new EventHandler<ActionEvent>()

        {  // 重置检查
            @Override
            public void handle(ActionEvent event) {
                //遍历所有checkbox，将选择状态设为未选择
                Object[] objects = gridPane2.getChildren().toArray();
                for (Object o : objects) {
                    if (o instanceof CheckBox) {
                        ((CheckBox) o).setSelected(false);
                    }
                }
            }
        });

        HBox hBox3 = new HBox();
        hBox3.getChildren().

                addAll(save2, reset2);
        hBox3.setSpacing(40);

        Line line1 = new Line(15, 845, 1065, 845);
        line1.setStroke(Color.valueOf("#5C5D5B"));

        //_____________________________________________________________________________________________

        anchorPane4.getChildren().

                addAll(hBox, line, hBox1, divider1, gridPane1, hBox2, divider2, gridPane2, hBox3, line1);

        AnchorPane.setLeftAnchor(hBox, 15.0);
        AnchorPane.setTopAnchor(hBox, 20.0);

        AnchorPane.setLeftAnchor(hBox1, 15.0);
        AnchorPane.setTopAnchor(hBox1, 85.0);

        AnchorPane.setLeftAnchor(divider1, 15.0);
        AnchorPane.setTopAnchor(divider1, 135.0);

        AnchorPane.setLeftAnchor(gridPane1, 15.0);
        AnchorPane.setTopAnchor(gridPane1, 175.0);

        AnchorPane.setLeftAnchor(hBox2, 410.0);
        AnchorPane.setTopAnchor(hBox2, 365.0);

        AnchorPane.setLeftAnchor(divider2, 15.0);
        AnchorPane.setTopAnchor(divider2, 430.0);

        AnchorPane.setLeftAnchor(gridPane2, 15.0);
        AnchorPane.setTopAnchor(gridPane2, 505.0);

        AnchorPane.setLeftAnchor(hBox3, 410.0);
        AnchorPane.setTopAnchor(hBox3, 780.0);
    }


    public AnchorPane getAnchorPane4() {
        return anchorPane4;
    }

    public void setAnchorPane4(AnchorPane anchorPane4) {
        this.anchorPane4 = anchorPane4;
    }
}
