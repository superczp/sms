package Util;

import java.util.Comparator;

import domain.Student;

public class MySort implements Comparator<Student> {
	private boolean flag;
	
	public MySort(boolean flag) {
		super();
		this.flag = flag;
	}

	@Override
	public int compare(Student o1, Student o2) {
		 if(flag){
			 if(o1.getScore()>o2.getScore()){
				 return 1;
			 }else{
				 return -1;
			 }
			 
		 }else {
			 if(o1.getScore()>o2.getScore()){
				 return -1;
			 }else{
				 return 1;
			 }
		}
		
	}

}
