package person;

import mike.SingMike;
import movie.SongMovie;
import person.prepare.PraiseLead;

import java.util.List;

public class LeadSinger extends Singer {

    List<PraiseLead> songsWithMent;

    public LeadSinger(String name, List<PraiseLead> songs) {
        super(name);
        this.songsWithMent = songs;
    }

    public List<PraiseLead> getSongsWithMent(){
        return songsWithMent;
    }

//    public void 인도자멘트(String script){
//        System.out.println(name);
//        if(mike == null){
//            System.out.println("인도자 마이크가 없습니다");
//            return;
//        }
//        mike.speak(script);
//    }

    public void 인도자멘트(int index){
        if(songsWithMent.get(index).getMent() == null){
            return;
        }
        System.out.println(name);
        if(mike == null){
            System.out.println("인도자 마이크가 없습니다");
            return;
        }
        mike.speak(songsWithMent.get(index).getMent());
    }
}
