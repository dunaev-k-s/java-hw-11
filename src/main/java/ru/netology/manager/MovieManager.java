package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.FeedMovie;

@NoArgsConstructor
@AllArgsConstructor
public class MovieManager {
    private int feedSize = 10;

    public MovieManager(int feedSize){
        this.feedSize = feedSize;
    }

    private FeedMovie[] movies = new FeedMovie[0];

    public void addMovie(FeedMovie feedMovie){
        int length = movies.length + 1;
        FeedMovie[] tmp = new FeedMovie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = feedMovie;
        movies = tmp;
    }

    public FeedMovie[] getMovies(){
        if (feedSize > movies.length){
            this.feedSize = movies.length;
        }
        FeedMovie[] feed = new FeedMovie[feedSize];
        for (int i = 0; i < feed.length; i++){
            int index = feedSize - i - 1;
            feed[i] = movies[index];
        }
        return feed;
    }
}
