package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FeedMovie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieRepositoryTest {
    MovieRepository repository = new MovieRepository();
    private FeedMovie first = new FeedMovie(1,"First","Comedy","URL","URL",18102021);
    private FeedMovie second = new FeedMovie(2,"Second","Comedy","URL","URL",18102021);
    private FeedMovie third = new FeedMovie(3,"Third","Comedy","URL","URL",18102021);
    private FeedMovie fourth = new FeedMovie(4,"Fourth","Comedy","URL","URL",18102021);
    private FeedMovie fifth = new FeedMovie(5,"Fifth","Comedy","URL","URL",18102021);
    private FeedMovie sixth = new FeedMovie(6,"Sixth","Comedy","URL","URL",18102021);

    @BeforeEach
    public void setUp(){
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
    }

    @Test
    public void shouldSaveMovie(){
        FeedMovie[] actual = repository.findAll();
        FeedMovie[] expected = new FeedMovie[]{first,second,third,fourth,fifth,sixth};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void shouldRemoveById(){
        repository.removeById(2);
        FeedMovie[] actual = repository.findAll();
        FeedMovie[] expected = new FeedMovie[]{first,third,fourth,fifth,sixth};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void shouldRemoveByNonexistentId(){
        repository.removeById(7);
        FeedMovie[] actual = repository.findAll();
        FeedMovie[] expected = new FeedMovie[]{first,second,third,fourth,fifth,sixth};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void shouldFindById(){
        FeedMovie actual = repository.findById(4);
        FeedMovie expected = fourth;

        assertEquals(actual,expected);
    }

    @Test
    public void shouldFindByNonexistentId(){
        FeedMovie actual = repository.findById(8);
        FeedMovie expected = null;

        assertEquals(expected,actual);
    }
};
