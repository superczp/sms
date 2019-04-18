package biz;

import java.util.List;

import domain.Student;

public interface StudentBiz {//业务处理
	//添加学生的业务
	public String addStudent(int stuId, String name, double score);
	//查询学生的业务
	public List<Student> findAll();
	
	//排序查询
	public List<Student> sort(boolean b);
	//根据id查询学生
	public Student findStubyId(int id);
	
	//删除学生的业务
	public String deleteStu(int id);
	public String update(int id,double score);
	public List<Student> findLike(String s);
}
