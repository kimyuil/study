package person.prepare;

import movie.SongMovie;

public class PraiseLead {
    SongMovie song;
    String ment;

    public PraiseLead(SongMovie movie, String ment){
        this.song=movie;
        this.ment=ment;
    }

    public SongMovie getSong(){
        return song;
    }

    public String getMent(){
        return ment;
    }
}
