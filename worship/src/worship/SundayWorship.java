package worship;

import mike.*;
import movie.*;
import person.*;

import java.util.ArrayList;
import java.util.List;

public class SundayWorship implements Worship{

    List<Singer> singer;
    LeadSinger leadSinger;

    Preacher preacher;

    Moderator moderator;

    RepresentativePrayer prayer;

    List<SongMovie> songs;

    BibleMovie bibleMovie;
    BlessingMovie blessingMovie;
    OfferingMovie offeringMovie;
    PromiseMovie promiseMovie;
    List<SermonMovie> sermonMovies;
    SpecialSongMovie specialSongMovie;
    WholeSongMovie wholeSongMovie;

    public static SundayWorship of(List<Singer> singer,
                                   LeadSinger leadSinger,
                                   Preacher preacher,
                                   Moderator moderator,
                                   RepresentativePrayer prayer,
                                   List<Mike> mikes,
                                   List<SongMovie> prepareWorship,
                                   BibleMovie bibleMovie,
                                   BlessingMovie blessingMovie,
                                   OfferingMovie offeringMovie,
                                   PromiseMovie promiseMovie,
                                   List<SermonMovie> sermonMovies,
                                   SpecialSongMovie specialSongMovie,
                                   WholeSongMovie wholeSongMovie){
        SundayWorship data = new SundayWorship();
        data.singer = singer;
        data.leadSinger = leadSinger;
        data.preacher = preacher;
        data.moderator = moderator;
        data.prayer = prayer;

        List<Speacher> speachers = new ArrayList<>();
        speachers.add(data.prayer);
        speachers.add(data.preacher);
        speachers.add(data.moderator);

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
        data.bibleMovie=bibleMovie;
        data.blessingMovie=blessingMovie;
        data.offeringMovie=offeringMovie;
        data.promiseMovie=promiseMovie;
        data.sermonMovies=sermonMovies;
        data.specialSongMovie=specialSongMovie;
        data.wholeSongMovie=wholeSongMovie;

        return data;
    }

    @Override
    public void 예배진행() {
        System.out.println("..");
        System.out.println("----------------------- 주일예배시작 ------------------------");

        준비찬양();
        우리의다짐();
        대표기도();
        특송();
        전체찬양();
        성경봉독();
        설교();
        봉헌();
        축도();
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

    public void 우리의다짐(){
        promiseMovie.show();
        System.out.println("##### 대표기도자는 앞으로 나옵니다 #####");
    }

    public void 대표기도(){
        System.out.println("##### 음악이 흐릅니다 #####");
        prayer.기도하다();
        System.out.println("##### 대표기도자는 퇴장합니다 #####");
    }

    public void 특송(){
        System.out.println("##### 특송을 시작합니다 #####");
        specialSongMovie.show();
    }
    public void 전체찬양(){
        System.out.println("##### 선생님 지휘에 맞추어 전체찬양을 합니다. 자리에서 일어서주시기 바랍니다. #####");
        wholeSongMovie.show();
        System.out.println("##### 자리에 모두 앉습니다. #####");
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
    public void 봉헌(){
        System.out.println("##### 봉헌시작 #####");
        offeringMovie.show();
    }
    public void 축도(){
        System.out.println("##### 축도시작 #####");
        preacher.축도하다();
        blessingMovie.show();
    }
    public void 광고(){
        System.out.println("##### 광고하시겠습니다 #####");
        moderator.광고하다();
        System.out.println("##### 이것으로 모든 주일예배를 마쳤습니다. 행복한 주일되시기 바랍니다 #####");
        System.out.println("주일예배 종료");
    }
}
