package com.handsonspring.homeworkeleven.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ResponseDto {
    private ArrayList<String> ids = new ArrayList<>();
    public void addItem(String id){
        ids.add(id);
    }
}
