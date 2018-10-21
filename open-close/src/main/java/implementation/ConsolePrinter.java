package implementation;

import core.Printer;

import java.util.List;
import java.util.stream.Stream;

public class ConsolePrinter implements Printer<Stream<List<String>>> {
    private Stream<List<String>> lines;

    @Override
    public Stream<List<String>> getLines() {
        return lines;
    }

    @Override
    public ConsolePrinter setLines(Stream<List<String>> lines) {
        this.lines = lines;
        return this;
    }
}
