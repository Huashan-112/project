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
        tip.setPrefSize(320, 40);
        tip.setTextFill(Color.rgb(113, 114, 112));
        tip.setFont(font5);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setGraphic(tip);
        alert.setTitle(s2);
        alert.setHeaderText("");
        alert.setContentText("");
        alert.show();
    }

    public int isUsed_bed(int ward, int bed, String id) {

        RoomService roomService = new RoomService();
        PatientService patientService = new PatientService();

        int isUsed = 0;//0表示该床位未被使用。1表示该床位已被使用。2表示该病房已满

        if (patientService.get(Integer.parseInt(id)).getOut_time() != null) {//该患者已出院
            isUsed = 0;//则可以随意修改病房号和床位号
        } else {//该患者还在住院中，要修改病房号和床位号，则要认真判断

            boolean[] bed_state = new boolean[6];
            for (int i = 0; i < 6; i++) {
                bed_state[i] = false;
            }

            List<Patient> list = patientService.list();

            for (int i = 0; i < list.size(); i++) {//把该病房已使用的床位标记为true

                Room room = roomService.get(list.get(i).getRoom_id());
                if (room.getWard_id() == ward && room.getOut_time() == null && list.get(i).getId() != Integer.parseInt(id)) {//说明还在住院
                    bed_state[room.getBed_id()] = true;
                }
            }

            //首先判断该病房是否已满
            int a = 0;
            for (int i = 1; i <= 5; i++) {
                if (bed_state[i] == true) {
                    a++;
                }
            }

            if (a == 5) {//该病房满了
                isUsed = 2;
            } else if (bed_state[bed] == true) {//在没满的情况下，该床位是否被使用
                isUsed = 1;
            }
        }

        return isUsed;
    }
}
