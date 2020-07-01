package com.coderby.myapp.hr.model;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class AssignVO {

	@Autowired
	LecVO lec;
	
	private int lec_id;
	private String asign_name = null;
	private Date asign_end= null;
	public int getLec_id() {
		return lec_id;
	}
	
	public void setLec_id(int lec_id) {
		this.lec_id = lec_id;
	}
	public String getAsign_name() {
		return asign_name;
	}
	public void setAsign_name(String asign_name) {
		this.asign_name = asign_name;
	}
	public Date getAsign_end() {
		return asign_end;
	}
	public void setAsign_end(Date asign_end) {
		this.asign_end = asign_end;
	}
	@Override
	public String toString() {
		return 
				"\n 강의명:" + lec.getLec_name()+
				"\n 시험 및 과제명: "+asign_name+
				"\n 시험 및 과제 종료일: "+asign_end;
	}
}
