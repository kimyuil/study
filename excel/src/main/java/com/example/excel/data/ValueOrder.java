package com.example.excel.data;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValueOrder {
  String fieldName;
  String displayName;
  int order;
}
