package com.example.excel.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Fish {
  double 최소ph;
  double 최대ph;
  int 길이;
  String 색깔;
  int 요구포만도;
  int 현재포만도 = 0;
  boolean 질병여부;

  public boolean get질병여부() {
    return 질병여부;
  }
}
