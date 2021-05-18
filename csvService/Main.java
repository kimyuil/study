import java.util.ArrayList;
import java.util.List;

import util.MakeCsv;

public class Main {
    public static void main(String[] args) {
        List<List<String>> data = new ArrayList<List<String>>();
        List<String> header = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        List<String> row2 = new ArrayList<>();

        header.add("no");
        header.add("이름");
        header.add("나이");

        row1.add("1");
        row1.add("홍길동");
        row1.add("30");

        row2.add("2");
        row2.add("홍길순");
        row2.add("27");
        data.add(row1);
        data.add(row2);

        MakeCsv service = new MakeCsv();
        service.setHeader(header);
        service.setContent(data);
        service.setFileName("test");
        service.downloadCSV();

    }
}
