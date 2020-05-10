package UI;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import service.DoctorService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public Patient changePatient(entity.Patient p) {

        DoctorService doctorService = new DoctorService();

        String s1 = String.valueOf(p.getId());
        String s2 = p.getName();
        String s3 = p.getSex();
        String s4 = String.valueOf(p.getAge());
        String s5 = p.getPhone_number();
        String s6 = p.getIdentity_card();
        String s7 = p.getDiagnose();
        String s8 = doctorService.get(p.getId()).getName();
        String s9 = String.valueOf(p.getRoom_id());

        return new Patient(s1, s2, s3, s4, s7, "", s9, "", "", s5, s6, "", "", "", s8);

    }
}
