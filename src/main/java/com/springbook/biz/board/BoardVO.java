package com.springbook.biz.board;

import java.util.Date;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
public class BoardVO {
	private int seq,cnt;
	private String title,writer,content;
	private Date regdate;
}
