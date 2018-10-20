import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvReader reader = new CsvReader();

        String path = "non-single-responsibility/src/main/resources/test.csv";
        Stream<List<String>> lines = reader.readCsvAsStream(path);

        reader.print2Console(lines);
    }
}
