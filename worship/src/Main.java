import mike.*;
import movie.*;
import person.*;
import person.prepare.PraiseLead;
import person.prepare.SermonFlow;
import worship.DawnWorship;
import worship.SundayWorship;
import worship.WednesdayWorship;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SundayWorship 주일예배 = new SundayWorship();

        List<Singer> singers = new ArrayList<>();
        singers.add(new Singer("싱어1"));
        singers.add(new Singer("싱어2"));
        singers.add(new Singer("싱어3"));
        singers.add(new Singer("싱어4"));

        List<PraiseLead> praises = new ArrayList<>();
        praises.add(new PraiseLead(new SongMovie("주님은 나의 기쁨이요 나의 자랑 거리요 ~ " , "나의기쁨나의소망 music"),"활기찬 주일입니다! 찬양 시작하시겠습니다."));
        praises.add(new PraiseLead(new SongMovie("왜 살아야 하는지 왜 먹어야 하는지 알았네 깨달았네 ~ " , "님이여 music"),"사랑하는 님을 생각하시면서 찬양하시겠습니다."));
        LeadSinger leadSinger = new LeadSinger("인도자", praises);

        List<SermonFlow> sermonFlows = new ArrayList<>();
        sermonFlows.add(new SermonFlow("할렐루야! 주일말씀 시작하시겠습니다. 먼저 영상을 보면서 시작하겠습니다.",
                new SermonMovie("하나님께서는 이렇게 말씀하셨습니다", "웅장한 음악")));
        sermonFlows.add(new SermonFlow("여러분 모두 감동이 오지 않습니까? 이어서 말씀하시겠습니다. 영상을 또 보겠습니다.",
                new SermonMovie("나의 심정을 깨달아라. 나는 너를 믿는다", "감동적 음악")));
        Preacher preacher = new Preacher("설교자");
        preacher.set원고(sermonFlows,
                "모두 깨달았습니까? 깨닫고 행하는 모든 신부들 되기를 기도합니다. 말씀마쳤습니다. 기도마쳤습니다.",
                "하나님 성령님 성자주님의 이름으로 축원하노라 아멘.");

        Moderator moderator = new Moderator("사회자");
        moderator.set광고("이번주 금요일에 금요기도회가 있으니 많은 참여 바랍니다.");
        RepresentativePrayer player = new RepresentativePrayer("대표기도자");
        player.set기도내용("사랑하는 하나님 오늘도 귀한 주일예배 드리게 해주심에 감사합니다. 아멘.");

        List<Mike> mikes = new ArrayList<>();
        mikes.add(new SmallMike());
        mikes.add(new SmallMike());
        mikes.add(new SmallMike());
        mikes.add(new SmallMike());
        mikes.add(new SpreadMike());
        mikes.add(new CleanMike());
        mikes.add(new CleanMike());
        mikes.add(new CleanMike());

        List<SongMovie> songs = new ArrayList<>();
        for( var s : leadSinger.getSongsWithMent()){
            songs.add(s.getSong());
        }

        BibleMovie bibleMovie = new BibleMovie();
        bibleMovie.set성구("너의 마음을 다하고 뜻을 다하여 주 너의 하나님을 사랑하라 하셨으니 이것이 크고 첫째되는 계명이요");

        BlessingMovie blessingMovie = new BlessingMovie();
        OfferingMovie offeringMovie = new OfferingMovie();
        PromiseMovie promiseMovie = new PromiseMovie();
        SpecialSongMovie specialSongMovie = new SpecialSongMovie("감사 가사 ","감사 찬양");
        WholeSongMovie wholeSongMovie = new WholeSongMovie("존재의 근본은 힘이라고 하나님 말씀하시기를", "존재는 힘이다");

        List<SermonMovie> sermonMovies = new ArrayList<>();
        for(var s : preacher.get설교원고()){
            sermonMovies.add(s.getSermonMovie());
        }

        주일예배.preparePerson(singers, leadSinger, preacher, moderator, player, mikes);
        주일예배.prepareSetting(songs, bibleMovie, blessingMovie, offeringMovie, promiseMovie, sermonMovies, specialSongMovie, wholeSongMovie);

        주일예배.예배진행();




        WednesdayWorship wednesdayWorship = new WednesdayWorship();

        List<Singer> singers2 = new ArrayList<>();
        singers2.add(new Singer("w싱어1"));
        singers2.add(new Singer("w싱어2"));

        List<PraiseLead> praisesW = new ArrayList<>();
        praisesW.add(new PraiseLead(new SongMovie("진리로 모든걸 얻었네 영원한 사랑 영원한 축복 " , "진리로 music"),"행복한 수요일입니다!  찬양 시작하시겠습니다."));
        praisesW.add(new PraiseLead(new SongMovie("그는 나를 택하셨고 나 또한 마음 정했으니 나는 하나님 뜻을 이뤄 갑니다 " , "나는 하나님 뿐입니다 music"),null));

        LeadSinger leadSinger2 = new LeadSinger("w인도자", praisesW);

        List<SermonFlow> sermonFlows2 = new ArrayList<>();
        sermonFlows2.add(new SermonFlow("할렐루야! 행복한 수요일입니다. 선생님께서 코치해주신 영상을 보시겠습니다.",
                new SermonMovie("이 말씀을 받게된 사연이 이러합니다. 선생님께서는 꿈을 꾸시고 ...", "조용한 음악")));
        Preacher preacher2 = new Preacher("설교자");
        preacher2.set원고(sermonFlows2, "모두 이 사연을 깨닫고 마음과 뜻과 목숨을 다해야겠습니다. 기도함으로 수요예배 마무리하겠습니다. 아멘.", null);
        Moderator moderator2 = new Moderator("사회자");
        moderator2.set대표기도("오늘도 귀한 수요예배를 드리게 해주심에 감사합니다. 처음부터 끝까지 함께하여 주시옵소서. 아멘.");
        moderator2.set광고("돌아오는 주일에 바자회가 있습니다. 많은 관심과 후원 부탁드립니다.");


        List<Mike> mikes2 = new ArrayList<>();
        mikes2.add(new SmallMike());
        mikes2.add(new SmallMike());
        mikes2.add(new SpreadMike());
        mikes2.add(new CleanMike());
        mikes2.add(new CleanMike());

        List<SongMovie> songs2 = new ArrayList<>();
        for( var s : leadSinger2.getSongsWithMent()){
            songs2.add(s.getSong());
        }
        BibleMovie bibleMovie2 = new BibleMovie();
        bibleMovie2.set성구("게으른 자는 비없는 구름과 같으니라");
        List<SermonMovie> sermonMovies2 = new ArrayList<>();
        for(var s : preacher2.get설교원고()){
            sermonMovies2.add(s.getSermonMovie());
        }

        wednesdayWorship.preparePerson(singers2, leadSinger2, preacher2, moderator2,mikes2);
        wednesdayWorship.prepareSetting(songs2, bibleMovie2, sermonMovies2);
        wednesdayWorship.예배진행();




        DawnWorship dawnWorship = new DawnWorship("목요일");

        List<PraiseLead> praisesD = new ArrayList<>();
        praisesW.add(new PraiseLead(new SongMovie("주님 그 사랑으로 나를 기르시고 큰 기대를 하셨죠 이젠 실망보다 기쁨되고 싶어 " , "하얀꽃 music"),"찬양하심으로 새벽예배의 문을 열겠습니다."));

        LeadSinger leadSinger3 = new LeadSinger("인도자4", praisesD);
        preacher2.set원고(new ArrayList<>(), "오늘 새벽도 깊은 기도를 해야할 것입니다. 말씀마쳤습니다.", null);
        List<Mike> mikes3 = new ArrayList<>();
        mikes3.add(new SpreadMike());
        mikes3.add(new CleanMike());

        dawnWorship.preparePerson(new ArrayList<>(), leadSinger3, preacher2, mikes3);

        List<SongMovie> songs3 = new ArrayList<>();
        for(var s : leadSinger3.getSongsWithMent()){
            songs3.add(s.getSong());
        }


        dawnWorship.prepareSetting(songs3);

        dawnWorship.예배진행();

    }
}