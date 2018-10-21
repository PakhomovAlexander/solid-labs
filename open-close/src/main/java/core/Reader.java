package core;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public interface Reader<T extends Stream<? extends List<?>>> {
    default T readCsvAsStream(String path) throws IOException {
        return readCsvAsStream(path, true);
    }

    default T readCsvAsStream(String path, boolean withHeader) throws IOException {
        return readCsvAsStream(Paths.get(path), "windows-1251", withHeader);
    }

    T readCsvAsStream(Path path, String charsetName, boolean withHeader) throws IOException;
}
