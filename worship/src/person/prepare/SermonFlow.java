package person.prepare;

import movie.SermonMovie;
import movie.SongMovie;

public class SermonFlow {

    String beforeSermon;
    SermonMovie sermonMovie;

    public SermonFlow(String beforeSermon, SermonMovie movie){
        this.sermonMovie=movie;
        this.beforeSermon=beforeSermon;
    }

    public String getBeforeSermon(){
        return beforeSermon;
    }

    public SermonMovie getSermonMovie(){
        return sermonMovie;
    }


}
