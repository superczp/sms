package viewAndCon;

import java.util.List;

import domain.Teacher;
import domain.Student;

public interface SMSServer {
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
	//修改学生信息业务
	 
	public String update(Student stu);
	//教师登录功能
	public Teacher login(String account,String password);
	//教师修改教师成绩信息的方法
	public String update(Teacher t);
	//模糊查询方法
	public List<Student> like(String s);
}
