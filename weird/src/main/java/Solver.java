import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Solver {
    public Stream<List<String>> readFromFile() {
        FileReader reader1 = null;
        try {
            reader1 = new FileReader("D:\\projects\\weird-code\\weird\\src\\main\\resources\\test.csv");
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong...");
        }
        CsvListReader reader2 = new CsvListReader(reader1, CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
        CsvIterator csvIterator = null;
        try {
            csvIterator = new CsvIterator(reader2);
        } catch (IOException e) {
            System.out.println("Something went wrong...");
        }
        CsvIterator finalCsvIterator = csvIterator;
        Iterable<List<String>> iterableCsv = () -> finalCsvIterator;

        return StreamSupport.stream(iterableCsv.spliterator(), false);
    }

    public void writeToFile() {
        //TODO: implement in future
    }


    private static class CsvIterator implements Iterator<List<String>> {
        private CsvListReader reader;
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
