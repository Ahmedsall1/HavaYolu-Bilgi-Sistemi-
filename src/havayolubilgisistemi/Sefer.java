package havayolubilgisistemi;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Sefer {

    private static int No = 100;
    public int no;
    public float KM;
    public String nerden;
    public String nereye;
    public LocalTime sure;
    public LocalDateTime date;
    public String formattedDate;
    // 1 Oluşturcu
    public Sefer(float KM, String nerden, String nereye, LocalTime sure, LocalDateTime date) {
        this.no = No;  No++;
        this.KM = KM;
        this.nerden = nerden;
        this.nereye = nereye;
        this.sure = sure;
        this.date = date;
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formattedDate = date.format(myFormatObj);
        if (this.getClass() == Sefer.class) {
            HavaYolu.SeferList.add(this);
        }
    }
    // 2 Oluşturcu
    public Sefer(float KM, String nerden, String nereye, String sure, String date) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime sure1 = LocalTime.parse(sure, timeFormatter);
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime date1 = LocalDateTime.parse(date, dateFormatter);
            new Sefer(KM, nerden, nereye, sure1, date1);
        } catch (DateTimeParseException e) {
            formattedDate = date;
            this.no = No;
            No++;
            this.KM = KM;
            this.nerden = nerden;
            this.nereye = nereye;
            this.sure = LocalTime.parse(sure,timeFormatter);
            if (this.getClass() == Sefer.class) {
                HavaYolu.SeferList.add(this);
            }
        }
    }
}
