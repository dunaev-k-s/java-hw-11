package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FeedMovie;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieManagerMockitoTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    MovieManager manager = new MovieManager();
    private FeedMovie first = new FeedMovie(1,"First","Comedy","URL","URL",18102021);
    private FeedMovie second = new FeedMovie(2,"Second","Comedy","URL","URL",18102021);
    private FeedMovie third = new FeedMovie(3,"Third","Comedy","URL","URL",18102021);
    private FeedMovie fourth = new FeedMovie(4,"Fourth","Comedy","URL","URL",18102021);
    private FeedMovie fifth = new FeedMovie(5,"Fifth","Comedy","URL","URL",18102021);
    private FeedMovie sixth = new FeedMovie(6,"Sixth","Comedy","URL","URL",18102021);


    @Test
    public void shouldGetAllMovies(){
        FeedMovie[] returned = new FeedMovie[]{first,second,third,fourth,fifth,sixth};
        doReturn(returned).when(repository).findAll();

        FeedMovie[] actual = manager.getAll();
        FeedMovie[] expected = new FeedMovie[]{sixth,fifth,fourth,third,second,first};

        assertArrayEquals(actual,expected);

        verify(repository).findAll();
    }

}
