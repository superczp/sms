package domain;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serivalVersionUID=123456;
	private int stuId;
	private String name;
	private double score;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Student(int stuId, String name, double score) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.stuId+"\t"+this.name+"\t"+this.score;
	}
	public String show(){
		return this.stuId+"#"+this.name+"#"+this.score;
	}
	
}
