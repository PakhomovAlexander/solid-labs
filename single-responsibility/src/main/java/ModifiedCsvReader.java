import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ModifiedCsvReader {
    private final String delimiter;

    public ModifiedCsvReader() {
        this(";");
    }

    public ModifiedCsvReader(String delimiter) {
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