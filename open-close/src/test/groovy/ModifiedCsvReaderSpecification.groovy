import implementation.CsvReader
import implementation.ModifiedCsvReader
import org.supercsv.prefs.CsvPreference
import spock.lang.Specification

import java.nio.file.NoSuchFileException
import java.util.stream.Collectors

class ModifiedCsvReaderSpecification extends Specification {

    def 'wrong resource'() {
        given:
        def reader = new ModifiedCsvReader()

        when:
        reader.readCsvAsStream(path)

        then:
        thrown(NoSuchFileException.class)

        where:
        path = 'src/test/resources/NO-SUCH-FILE.csv'
    }

    def 'read test resource'() {
        given:
        def reader = new ModifiedCsvReader()

        when:
        def lines = reader.readCsvAsStream(path).collect(Collectors.toList())

        then:
        lines.size() == 3
        and: 'lines are split correctly'
        lines.every { it.size() == 2 }

        where:
        path = 'src/test/resources/test.csv'
    }

    def 'read with wrong pattern'() {
        given: 'wrong csv preference, tab separation'
        def reader = new ModifiedCsvReader("|")

        when: 'read 3 lines where separated by ;'
        def lines = reader.readCsvAsStream(path)

        then: 'separation is not recognized'
        lines.allMatch { it.size() != 1 }

        where:
        path = 'src/test/resources/test.csv'
    }
}
