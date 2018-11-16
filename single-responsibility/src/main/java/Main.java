import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvReader reader = new CsvReader();

        String path = "single-responsibility/src/main/resources/test.csv";
        Stream<List<String>> lines = reader.readCsvAsStream(path);

        ConsolePrinter printer = new ConsolePrinter();
        printer.setLines(lines)
               .print2Console();


        ModifiedCsvReader modified = new ModifiedCsvReader(",");
        Stream<List<String>> modifiedLines = modified.readCsvAsStream(path);

        ConsolePrinter modifiedPrinter = new ConsolePrinter();
        modifiedPrinter.setLines(modifiedLines)
               .print2Console();
    }
}
