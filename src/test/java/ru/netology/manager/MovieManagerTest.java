package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FeedMovie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    private FeedMovie first = new FeedMovie(1,"First","Comedy","URL","URL",18102021);
    private FeedMovie second = new FeedMovie(2,"Second","Comedy","URL","URL",18102021);
    private FeedMovie third = new FeedMovie(3,"Third","Comedy","URL","URL",18102021);
    private FeedMovie fourth = new FeedMovie(4,"Fourth","Comedy","URL","URL",18102021);
    private FeedMovie fifth = new FeedMovie(5,"Fifth","Comedy","URL","URL",18102021);
    private FeedMovie sixth = new FeedMovie(6,"Sixth","Comedy","URL","URL",18102021);

    @Test
    public void shouldAddOneMovie(){
        MovieManager manager = new MovieManager(1);
        manager.addMovie(second);

        FeedMovie[] actual = manager.getMovies();
        FeedMovie[] expected = new FeedMovie[]{second};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void shouldGetFiveMovies(){
        MovieManager manager = new MovieManager(5);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);

        FeedMovie[] actual = manager.getMovies();
        FeedMovie[] expected = new FeedMovie[]{fifth,fourth,third,second,first};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void shouldGetHowMuchMovies(){
        MovieManager manager = new MovieManager();
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);

        FeedMovie[] actual = manager.getMovies();
        FeedMovie[] expected = new FeedMovie[]{third,second,first};

        assertArrayEquals(actual,expected);
    }
};
