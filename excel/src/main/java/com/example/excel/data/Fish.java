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

  @FileColumns(fieldName = "최소-ph",order = 0)
  double 최소ph;

  @FileColumns(fieldName = "최대-ph",order = 1)
  double 최대ph;

  @FileColumns(fieldName = "현재길이",order = 2)
  int 길이;

  @FileColumns(fieldName = "현재색깔",order = 5)
  String 색깔;

  @FileColumns(fieldName = "요구-포만도",order = 3)
  int 요구포만도;

  @FileColumns(fieldName = "현재 포만도",order = 4)
  int 현재포만도 = 0;

  @FileColumns(fieldName = "질병여부",order = 6)
  boolean 질병여부;

  public boolean get질병여부() {
    return 질병여부;
  }
}
