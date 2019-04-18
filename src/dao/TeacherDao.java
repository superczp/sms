package dao;

import domain.Teacher;

public interface TeacherDao {
	Teacher find(String account,String password);
	String update(Teacher t);
}
