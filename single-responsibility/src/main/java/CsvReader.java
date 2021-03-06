import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.supercsv.prefs.CsvPreference.STANDARD_PREFERENCE;

public class CsvReader {
    private final String delimiter;

    public CsvReader() {
        this(";");
    }

    public CsvReader(String delimiter) {
        this.delimiter = delimiter;
    }

    public Stream<List<String>> readCsvAsStream(String path) throws IOException {
        return readCsvAsStream(path, true);
    }

    public Stream<List<String>> readCsvAsStream(String path, boolean withHeader) throws IOException {
        return readCsvAsStream(Paths.get(path), "windows-1251", withHeader);
    }

    public Stream<List<String>> readCsvAsStream(Path path, String charsetName, boolean withHeader) {
        try {
            File inputF = new File(path.toString());
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

            return withHeader ?
                    br.lines().map(line -> Arrays.asList(line.split(delimiter))) :
                    br.lines().skip(1).map(line -> Arrays.asList(line.split(delimiter)));
        } catch (Exception e) {

            return Stream.of();
        }
    }
}