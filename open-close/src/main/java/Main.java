import core.Printer;
import core.Reader;
import implementation.ConsolePrinter;
import implementation.CsvReader;
import implementation.ModifiedCsvReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader<Stream<List<String>>> reader = new CsvReader();
        Reader<Stream<List<String>>> modified = new ModifiedCsvReader(",");

        String path = "single-responsibility/src/main/resources/test.csv";

        readWithPrint(reader, path);
        readWithPrint(modified, path);
    }

    static void readWithPrint(Reader<Stream<List<String>>> reader, String path) throws IOException {
        Stream<List<String>> lines = reader.readCsvAsStream(path);

        Printer<Stream<List<String>>> printer = new ConsolePrinter();
        printer.setLines(lines)
               .print();

    }
}
