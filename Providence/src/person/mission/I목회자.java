package person.mission;

import faith.말씀;

import java.util.List;

public interface I목회자 extends I지도자 {
  말씀 말씀을전하다(말씀 w);
  void 지도자교육(말씀 w, List<I지도자> 지도자들);
  // 교회운영
}
