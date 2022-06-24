package com.todo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor //NoArgs(Arugments) 인자값이 없는 기본생성자

public class Mouse {
	private String name;
}
