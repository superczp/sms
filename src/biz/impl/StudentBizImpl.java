package biz.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import Util.MySort;
import biz.StudentBiz;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.Student;

public class StudentBizImpl implements StudentBiz {
	private StudentDao sd;
	
	public StudentBizImpl() {
		super();
		this.sd = new StudentDaoImpl();
	}

	@Override
	public String addStudent(int stuId, String name, double score) {
		   
		return this.sd.addStu(new Student(stuId, name, score))?"添加成功！":"添加失败！";
	}

	@Override
	public List<Student> findAll() {
		 
		return this.sd.findAllstu();
	}

	@Override
	public List<Student> sort(boolean b) {
		 List<Student> l1=this.sd.findAllstu();
		 Collections.sort(l1,new MySort(b));
		return l1;
	}

	@Override
	public Student findStubyId(int id) {
		
		return this.sd.findStu(id);
	}

	@Override
	public String deleteStu(int id) {
		 
		return this.sd.delete(id)?"删除成功！":"删除失败！";
	}

	@Override
	public String update(int id, double score) {
		return this.sd.updata(id, score)?"修改成功！":"修改失败！";
	}

	@Override
	public List<Student> findLike(String s) {
		// TODO Auto-generated method stub
		return this.sd.findLike(s);
	}
	

}
