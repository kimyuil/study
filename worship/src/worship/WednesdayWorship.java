package worship;

import mike.CleanMike;
import mike.Mike;
import mike.SmallMike;
import mike.SpreadMike;
import movie.*;
import person.*;

import java.util.ArrayList;
import java.util.List;

public class WednesdayWorship implements Worship{

    List<Singer> singer;
    LeadSinger leadSinger;

    Preacher preacher;

    Moderator moderator;

    List<SongMovie> songs;

    BibleMovie bibleMovie;
    List<SermonMovie> sermonMovies;

    public void preparePerson(
            List<Singer> singer,
            LeadSinger leadSinger,
            Preacher preacher,
            Moderator moderator,
            List<Mike> mikes){

        this.singer = singer;
        this.leadSinger = leadSinger;
        this.preacher = preacher;
        this.moderator = moderator;

        List<Speacher> speachers = new ArrayList<>();
        speachers.add(this.preacher);
        speachers.add(this.moderator);

        int singerIndex = 0;
        int speacherIndex = 0;
        for(var mike : mikes){

            if(mike instanceof SpreadMike){
                leadSinger.setMike(mike);
            }else if(mike instanceof SmallMike){
                singer.get(singerIndex).setMike(mike);
                singerIndex ++;
            }else if(mike instanceof CleanMike){
                speachers.get(speacherIndex).setMike(mike);
                speacherIndex++;
            }
        }

    }

    public void prepareSetting(List<SongMovie> prepareWorship,
                               BibleMovie bibleMovie,
                               List<SermonMovie> sermonMovies){

        this.songs = prepareWorship;
        this.bibleMovie=bibleMovie;
        this.sermonMovies=sermonMovies;

    }

    @Override
    public void 예배진행() {
        System.out.println("..");
        System.out.println("----------------------- 수요예배시작 ------------------------");

        준비찬양();
        대표기도();
        성경봉독();
        설교();
        광고();

        System.out.println("..");
    }

    @Override
    public void 준비찬양(){

        System.out.println("##### 준비찬양 시작 #####");

        // 찬양시작
        // 현재 인도자 멘트가 하드코딩되어 있음.
        int count = 0;
        for(var song : songs){
            System.out.println("##### "+(count+1)+"번재 곡 #####");
            leadSinger.인도자멘트(count);
            leadSinger.찬양(song.get가사());
            for(var s : singer){
                s.찬양(song.get가사());
            }
            count++;
        }

        System.out.println("##### 잔잔한 음악이 흐릅니다 #####");
    }

    public void 대표기도(){
        System.out.println("##### 사회자가 대표기도를 합니다 #####");
        moderator.대표기도();
    }

    public void 성경봉독(){
        System.out.println("##### 성경봉독 시간입니다 #####");
        bibleMovie.show();
    }

    @Override
    public void 설교(){
        System.out.println("##### 설교시작 #####");
        preacher.설교하다();
        System.out.println("##### 설교 끝 #####");
    }

    public void 광고(){
        System.out.println("##### 광고하시겠습니다 #####");
        moderator.광고하다();
        System.out.println("##### 이것으로 모든 수요예배를 마쳤습니다. 감사합니다 #####");
        System.out.println("수요예배 종료");
    }
}
