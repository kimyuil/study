package worship;

import mike.CleanMike;
import mike.Mike;
import mike.SmallMike;
import mike.SpreadMike;
import movie.SongMovie;
import person.*;

import java.util.ArrayList;
import java.util.List;

public class DawnWorship implements Worship{

    public DawnWorship(String 요일){
        this.요일 = 요일;
    }

    String 요일;
    List<Singer> singer;
    LeadSinger leadSinger;

    Preacher preacher;

    List<SongMovie> songs;

    public static DawnWorship of(String 요일,
                                 List<Singer> singer,
                                 LeadSinger leadSinger,
                                 Preacher preacher,
                                 List<Mike> mikes,
                                 List<SongMovie> prepareWorship){
        DawnWorship data = new DawnWorship(요일);
        data.singer = singer;
        data.leadSinger = leadSinger;
        data.preacher = preacher;


        List<Speacher> speachers = new ArrayList<>();
        speachers.add(data.preacher);

        int singerIndex = 0;
        int speacherIndex = 0;
        for(var mike : mikes){

            if(mike instanceof SpreadMike){
                data.leadSinger.setMike(mike);
            }else if(mike instanceof SmallMike){
                data.singer.get(singerIndex).setMike(mike);
                singerIndex ++;
            }else if(mike instanceof CleanMike){
                speachers.get(speacherIndex).setMike(mike);
                speacherIndex++;
            }
        }

        data.songs = prepareWorship;
        return data;
    }

    @Override
    public void 예배진행() {
        System.out.println("..");
        System.out.println("----------------------- "+요일+"새벽예배시작 ------------------------");

        준비찬양();
        설교();

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

    @Override
    public void 설교(){
        System.out.println("##### 설교시작 #####");
        preacher.설교하다();
        System.out.println("##### 설교 끝 #####");
    }

}
