package com.prachi.training.model;

public class Course {

	private int course_id;
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public Course(int course_id, String c_name, String c_desc, String c_fees, String c_resource) {
		super();
		this.course_id = course_id;
		this.c_name = c_name;
		this.c_desc = c_desc;
		this.c_fees = c_fees;
		this.c_resource = c_resource;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_desc() {
		return c_desc;
	}
	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}
	public String getC_fees() {
		return c_fees;
	}
	public void setC_fees(String c_fees) {
		this.c_fees = c_fees;
	}
	public String getC_resource() {
		return c_resource;
	}
	public void setC_resource(String c_resource) {
		this.c_resource = c_resource;
	}
	private String c_name,c_desc, c_fees, c_resource;
}
