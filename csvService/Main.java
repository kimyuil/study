import java.util.ArrayList;
import java.util.List;

import service.SundayService;
import service.WednesdayService;
import service.WorshipList;
import util.MakeCsv;

public class Main {
    public static void main(String[] args) {
        
        List<WorshipList> data = new ArrayList<>();
        data.add(new SundayService("김유일", "청년부", "전도사", 27,"정인태"));
        data.add(new SundayService("홍길동", "가정국", "집사", 30,"정인태"));
        data.add(new SundayService("홍길순", "캠퍼스", "강도사", 24,"정인태"));
        data.add(new SundayService("주별별", "청년부", "", 25,"정인태"));
        data.add(new SundayService("주달달", "가정국", "집사", 37,"정인태"));
        data.add(new SundayService("주해해", "캠퍼스", "", 40,"정인태"));

        MakeCsv service = new MakeCsv();
        service.setFileName("주일예배.csv");
        service.setContent(data);
        service.downloadCSV();

        List<WorshipList> data2 = new ArrayList<>();
        data2.add(new WednesdayService("정별별", "캠퍼스", "", 29));
        data2.add(new WednesdayService("정달달", "캠퍼스", "전도사", 27));
        data2.add(new WednesdayService("정해해", "장년부", "집사", 57));
        

        MakeCsv service2 = new MakeCsv();
        service2.setFileName("수요예배.csv");
        service2.setContent(data2);
        service2.downloadCSV();

    }
}
