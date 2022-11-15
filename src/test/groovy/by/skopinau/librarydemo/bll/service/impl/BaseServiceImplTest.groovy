package by.skopinau.librarydemo.bll.service.impl

import by.skopinau.librarydemo.dal.entity.Author
import by.skopinau.librarydemo.dal.entity.BaseEntity
import by.skopinau.librarydemo.dal.entity.Book
import by.skopinau.librarydemo.dal.entity.Genre
import by.skopinau.librarydemo.dal.entity.Magazine
import by.skopinau.librarydemo.dal.entity.Newspaper
import by.skopinau.librarydemo.dal.entity.Publisher
import by.skopinau.librarydemo.dal.repository.BaseRepository
import by.skopinau.librarydemo.dal.repository.BookRepository
import spock.lang.Specification

import java.time.LocalDate

class BaseServiceImplTest<T extends BaseEntity, R extends BaseRepository<T>, S extends BaseServiceImpl<T>>
        extends Specification {

    private final R repository = Mock()
    
    // todo: think about better solution of testing abstract class
    private final S service = new BookServiceImpl(repository as BookRepository) as S

    private static Publisher publisher
    private static Genre genre
    private static Author author
    private static Book book
    private static Magazine magazine
    private static Newspaper newspaper
    private static final LocalDate PUBLICATION_DATE = LocalDate.now()

    def setupSpec() {
        publisher = new Publisher(1, "Some Publisher")
        genre = new Genre(1, "Some Genre")
        author = new Author(1, "Some Author")
        book = new Book(1, "Some name", publisher, PUBLICATION_DATE, Set.of(genre), Set.of(author))
        magazine = new Magazine(1, "Some name", publisher, PUBLICATION_DATE, Set.of(genre))
        newspaper = new Newspaper(1, "Some name", publisher, PUBLICATION_DATE, Set.of(genre))
    }

    def "Should save entity #expected and return its optional"(T expected) {
        when:
        Optional<T> actual = service.save(expected)

        then:
        1 * repository.save(expected) >> expected
        Optional.of(expected) == actual

        where:
        expected  | _
        publisher | _
        genre     | _
        author    | _
        book      | _
        magazine  | _
        newspaper | _
    }

    def "Should return a list of all entities"() {
        when:
        List<T> actual = service.findAll()

        then:
        1 * repository.findAll() >> expected
        expected == actual

        where:
        expected              | _
        List<T>.of()          | _
        List<T>.of(publisher) | _
        List<T>.of(genre)     | _
        List<T>.of(author)    | _
        List<T>.of(book)      | _
        List<T>.of(magazine)  | _
        List<T>.of(newspaper) | _
    }

    def "Should return an optional entity by id #id"(int id) {
        when:
        Optional<T> actual = service.findById(id)

        then:
        1 * repository.findById(id) >> expected
        expected == actual

        where:
        id                     | expected
        new Random().nextInt() | Optional<T>.empty()
        Integer.MIN_VALUE      | Optional<T>.of(publisher)
        Integer.MAX_VALUE      | Optional<T>.of(genre)
        1                      | Optional<T>.of(author)
        2                      | Optional<T>.of(book)
        3                      | Optional<T>.of(magazine)
        4                      | Optional<T>.of(newspaper)

    }

    def "Should update a found entity by id #id and return its optional"(T entity, int id) {
        given:
        repository.existsById(id) >> foundById

        when:
        Optional<T> actual = service.update(entity, id)

        then:
        i * repository.save(entity) >> entity
        expected == actual

        where:
        entity    | id                     | foundById | expected            | i
        publisher | new Random().nextInt() | true      | Optional.of(entity) | 1
        genre     | Integer.MIN_VALUE      | true      | Optional.of(entity) | 1
        author    | Integer.MAX_VALUE      | true      | Optional.of(entity) | 1
        book      | 1                      | true      | Optional.of(entity) | 1
        magazine  | 2                      | true      | Optional.of(entity) | 1
        newspaper | 3                      | true      | Optional.of(entity) | 1
        newspaper | 3                      | false     | Optional<T>.empty() | 0
    }

    def "Should delete an entity by id #id and return true if exists"(int id) {
        given:
        repository.existsById(id) >> expected

        when:
        boolean actual = service.deleteById(id)

        then:
        i * repository.deleteById(id)
        expected == actual

        where:
        id                     | expected | i
        new Random().nextInt() | true     | 1
        Long.MIN_VALUE         | false    | 0
        Long.MAX_VALUE         | true     | 1
    }
}
