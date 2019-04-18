package dao;

import java.util.List;

import domain.Student;

public interface StudentDao {//数据的增删改查，
	//创建一个添加学生方法
	public boolean addStu(Student stu);
	//创建一个查询所有学生的方法
	public List<Student> findAllstu();
	//创建一个查询学生的方法通过id查询
	public Student findStu(int a);
	//创建一个删除学生的方法
	public boolean delete(int a);
	//修改学生成绩方法
	public boolean updata(int id,double newScort);
	public List<Student> findLike(String s);
}
