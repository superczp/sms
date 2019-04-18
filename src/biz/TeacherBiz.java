package biz;

import domain.Teacher;

public interface TeacherBiz {
	Teacher findByAccountAndPassword(String account,String password);
	String update(Teacher t);
}
