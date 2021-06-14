package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.FeedMovie;

@NoArgsConstructor
@AllArgsConstructor
public class MovieManager {
    private int feedSize = 10;
    private MovieRepository repository;

    public MovieManager(int feedSize){
        this.feedSize = feedSize;
    }
    public MovieManager(MovieRepository repository){
        this.repository = repository;
    }

    public void addMovie(FeedMovie feedMovie){
        repository.save(feedMovie);
    }

    public FeedMovie[] getAll(){
        FeedMovie[] movies = repository.findAll();
        FeedMovie[] result = new FeedMovie[movies.length];
        for (int i = 0; i < result.length; i++){
            int index = feedSize - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
