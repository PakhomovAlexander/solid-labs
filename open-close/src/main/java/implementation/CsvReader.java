package implementation;

import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.supercsv.prefs.CsvPreference.STANDARD_PREFERENCE;

public class CsvReader implements core.Reader<Stream<List<String>>> {
    private final CsvPreference preference;

    public CsvReader() {
        this(STANDARD_PREFERENCE);
    }

    public CsvReader(CsvPreference preference) {
        this.preference = preference;
    }

    public CsvReader(Character quote, Character delimiter, String eofSymbols) {
        preference = new CsvPreference.Builder(quote, delimiter, eofSymbols).build();
    }

    @Override
    public Stream<List<String>> readCsvAsStream(Path path, String charsetName, boolean withHeader) throws IOException {
        Reader reader = Files.newBufferedReader(path, Charset.forName(charsetName));
        CsvListReader csvListReader = new CsvListReader(reader, preference);
        CsvIterator csvIterator = new CsvIterator(csvListReader);

        Iterable<List<String>> iterableCsv = () -> csvIterator;

        Stream<List<String>> result = StreamSupport.stream(iterableCsv.spliterator(), false);

        if (!withHeader) {
            return result.skip(1);
        }

        return result;
    }

    private static class CsvIterator implements Iterator<List<String>> {
        private final CsvListReader reader;
        private List<String> nextRow;

        public CsvIterator(CsvListReader reader) throws IOException {
            this.reader = reader;
            nextRow = reader.read();
        }


        @Override
        public boolean hasNext() {
            return nextRow != null;
        }

        @Override
        public List<String> next() {
            List<String> result = nextRow;

            try {
                nextRow = reader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return result;
        }
    }
}