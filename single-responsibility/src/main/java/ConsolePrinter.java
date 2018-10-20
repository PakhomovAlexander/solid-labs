import java.util.List;
import java.util.stream.Stream;

public class ConsolePrinter {
    private Stream<List<String>> lines;

    ConsolePrinter setLines(Stream<List<String>> lines) {
        this.lines = lines;
        return this;
    }

    public void print2Console() {
        lines.forEach(list -> list.forEach(System.out::println));
    }
}
