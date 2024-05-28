package com.morning.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data    //getter, setter, toString
@NoArgsConstructor   //매개변수가 없는 기본 생성자
@AllArgsConstructor    //모든 필드를 매개변수로 갖는 생성자
public class Board {
	private int bno; 
	private String title;
	private String content; 
	private String author;
	private int vcnt;
	private String resdate;
}
