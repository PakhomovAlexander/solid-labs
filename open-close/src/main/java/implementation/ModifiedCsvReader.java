package implementation;

import core.Reader;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ModifiedCsvReader implements Reader<Stream<List<String>>> {
    private final String delimiter;

    public ModifiedCsvReader() {
        this(",");
    }

    public ModifiedCsvReader(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public Stream<List<String>> readCsvAsStream(Path path, String charsetName, boolean withHeader) throws NoSuchFileException {
        try {
            File inputF = new File(path.toString());
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

            return withHeader ?
                    br.lines().map(line -> Arrays.asList(line.split(delimiter))) :
                    br.lines().skip(1).map(line -> Arrays.asList(line.split(delimiter)));
        } catch (FileNotFoundException e) {
            throw new NoSuchFileException(e.getMessage());
        }
    }
}