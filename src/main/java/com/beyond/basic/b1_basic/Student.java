package com.beyond.basic.b1_basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private String email;
    private List<Scores> scores = new ArrayList<>();


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Scores {
        private String subject;
        private int point;
    }


}
