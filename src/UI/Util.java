package UI;

import entity.Patient;
import entity.Room;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import service.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Util {

    public boolean isLegalDate(String sDate) {
        int legalLen = 10;
        if ((sDate == null) || (sDate.length() != legalLen)) {
            return false;
        }

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(sDate);
            return sDate.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }
    }

    public void tip(String s1, String s2) {
        Font font5 = Font.font("YouYuan", FontWeight.BLACK, 16);
        Label tip = new Label(s1);
        tip.setPrefSize(250, 40);
        tip.setTextFill(Color.rgb(113, 114, 112));
        tip.setFont(font5);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setGraphic(tip);
        alert.setTitle(s2);
        alert.setHeaderText("");
        alert.setContentText("");
        alert.show();
    }

    public int isUsed_bed(String ward, String bed) {

        RoomService roomService = new RoomService();
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        CheckService checkService = new CheckService();
        DepartmentService departmentService = new DepartmentService();
        DragService dragService = new DragService();

        int isUsed = 0;//0表示该床位未被使用。1表示该床位已被使用。2表示该病房已满

        boolean[] bed_state = new boolean[5];
        for (int i = 0; i < 5; i++) {
            bed_state[i] = false;
        }

        List<Patient> list = patientService.list();

        for (int i = 0; i < list.size(); i++) {//把该病房已使用的床位标记为true

            Room room = roomService.get(list.get(i).getRoom_id());

            if (room.getWard_id() == Integer.valueOf(ward) && room.getOut_time() == null) {//说明还在住院
                bed_state[room.getBed_id()] = true;
            }
        }

        //首先判断该病房是否已满
        int a = 0;
        for (int i = 0; i < 5; i++) {
            if (bed_state[i] == true) {
                a++;
            }
        }
        if (a == 5) {
            return 2;
        }

        //在没满的情况下，该床位是否被使用
        if (bed_state[Integer.valueOf(bed)] == true) {
            isUsed = 1;
        }

        return isUsed;
    }
}
