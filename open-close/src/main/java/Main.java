import core.Printer;
import core.Reader;
import implementation.ConsolePrinter;
import implementation.CsvReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader<Stream<List<String>>> reader = new CsvReader();

        String path = "single-responsibility/src/main/resources/test.csv";
        Stream<List<String>> lines = reader.readCsvAsStream(path);

        Printer<Stream<List<String>>> printer = new ConsolePrinter();
        printer.setLines(lines)
               .print();
    }
}
