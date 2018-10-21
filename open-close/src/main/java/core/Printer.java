package core;

import java.util.List;
import java.util.stream.Stream;

public interface Printer<T extends Stream<? extends List<?>>> {

    default void print() { getLines().forEach(list -> list.forEach(System.out::println)); }

    T getLines();

    Printer setLines(T lines);
}
