package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.FeedMovie;

@NoArgsConstructor
@AllArgsConstructor
public class MovieRepository {
    private FeedMovie[] movies = new FeedMovie[0];

    public void save(FeedMovie feedMovie){
        int length = movies.length + 1;
        FeedMovie[] tmp = new FeedMovie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = feedMovie;
        movies = tmp;
    }

    public FeedMovie[] findAll(){
        return movies;
    }

    public void removeById(int id) {
        if (id > movies.length){
            return;
        }
        int length = movies.length - 1;
        FeedMovie[] tmp = new FeedMovie[length];
        int index = 0;
        for (FeedMovie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public FeedMovie findById(int id){
        if (id > movies.length){
            return null;
        }
        FeedMovie result = null;
        for (FeedMovie movie : movies) {
            if (movie.getId() == id){
                result = movies[id-1];
            }
        }
        return result;
    }

    public void removeAll(){
        movies = null;
    }
}
