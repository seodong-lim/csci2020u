import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CSVDemo {
    public static void main(String[] args) {
        try {
            Reader in = new FileReader("data.csv");
            Iterable<CSVRecord> records =
                    CSVFormat.DEFAULT.withHeader("First Name", "Last Name", "SID",
                            "Grade").parse(in);
            for (CSVRecord record: records) {
                String lastName = record.get("Last Name");
                String firstName = record.get("First Name");
                String grade = record.get("Grade");
                System.out.println(firstName + " " + lastName + " (" +
                        grade + ")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  