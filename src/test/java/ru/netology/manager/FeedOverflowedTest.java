package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FeedMovie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FeedOverflowedTest {
    MovieManager manager = new MovieManager(10);
    private FeedMovie first = new FeedMovie(1,"First","Comedy","URL","URL",18102021);
    private FeedMovie second = new FeedMovie(2,"Second","Comedy","URL","URL",18102021);
    private FeedMovie third = new FeedMovie(3,"Third","Comedy","URL","URL",18102021);
    private FeedMovie fourth = new FeedMovie(4,"Fourth","Comedy","URL","URL",18102021);
    private FeedMovie fifth = new FeedMovie(5,"Fifth","Comedy","URL","URL",18102021);
    private FeedMovie sixth = new FeedMovie(6,"Sixth","Comedy","URL","URL",18102021);
    private FeedMovie seventh = new FeedMovie(7,"Sixth","Comedy","URL","URL",18102021);
    private FeedMovie eighth = new FeedMovie(8,"Sixth","Comedy","URL","URL",18102021);
    private FeedMovie ninth = new FeedMovie(9,"Sixth","Comedy","URL","URL",18102021);
    private FeedMovie tenth = new FeedMovie(10,"Sixth","Comedy","URL","URL",18102021);
    private FeedMovie eleventh = new FeedMovie(11,"Sixth","Comedy","URL","URL",18102021);

    @BeforeEach
    public void setUp(){
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        manager.addMovie(eleventh);
    }

    @Test
    public void shouldGetTen(){

        FeedMovie[] actual = manager.getMovies();
        FeedMovie[] expected = new FeedMovie[]{ tenth,
                                                ninth,
                                                eighth,
                                                seventh,
                                                sixth,
                                                fifth,
                                                fourth,
                                                third,
                                                second,
                                                first};
        assertArrayEquals(actual,expected);
    }
};
