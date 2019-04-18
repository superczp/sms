package viewAndCon;

import java.util.List;

import biz.StudentBiz;
import biz.TeacherBiz;
import biz.impl.StudentBizImpl;
import biz.impl.TeacherBizImpl;
import domain.Teacher;
import domain.Student;

public class SMSServiceImpl implements SMSServer {
	private StudentBiz stuBiz;
	private TeacherBiz teaBiz;
	
	public SMSServiceImpl() {
		super();
		this.stuBiz=new StudentBizImpl();
		this.teaBiz=new TeacherBizImpl();
	}

	@Override
	public String addStudent(int stuId, String name, double score) {
		 
		return this.stuBiz.addStudent(stuId, name, score);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return this.stuBiz.findAll();
	}

	@Override
	public List<Student> sort(boolean b) {
		// TODO Auto-generated method stub
		return stuBiz.sort(b);
	}

	@Override
	public Student findStubyId(int id) {
	 
		return this.stuBiz.findStubyId(id);
	}

	@Override
	public String deleteStu(int id) {
		// TODO Auto-generated method stub
		return stuBiz.deleteStu(id);
	}

	@Override
	public String update(Student stu) {
		// TODO Auto-generated method stub
		return this.stuBiz.update(stu.getStuId(),stu.getScore());
	}

	@Override
	public Teacher login(String account, String password) {
		// TODO Auto-generated method stub
		return this.teaBiz.findByAccountAndPassword(account, password);
	}

	@Override
	public String update(Teacher t) {
		// TODO Auto-generated method stub
		return this.teaBiz.update(t);
	}

	@Override
	public List<Student> like(String s) {
		// TODO Auto-generated method stub
		return this.stuBiz.findLike(s);
	}

}
