package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FeedMovie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FeedNotFilledTest {
    MovieManager manager = new MovieManager(10);
    private FeedMovie first = new FeedMovie(1,"First","Comedy","URL","URL",18102021);
    private FeedMovie second = new FeedMovie(2,"Second","Comedy","URL","URL",18102021);
    private FeedMovie third = new FeedMovie(3,"Third","Comedy","URL","URL",18102021);
    private FeedMovie fourth = new FeedMovie(4,"Fourth","Comedy","URL","URL",18102021);
    private FeedMovie fifth = new FeedMovie(5,"Fifth","Comedy","URL","URL",18102021);


    @BeforeEach
    public void setUp(){
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
    }

    @Test
    public void shouldGetLess(){

        FeedMovie[] actual = manager.getMovies();
        FeedMovie[] expected = new FeedMovie[]{ fifth,
                                                fourth,
                                                third,
                                                second,
                                                first};
        assertArrayEquals(actual,expected);
    }
};
