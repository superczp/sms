package biz.impl;

import biz.TeacherBiz;
import dao.TeacherDao;
import dao.impl.TeacherDaoImpl;
import domain.Teacher;

public class TeacherBizImpl implements TeacherBiz {
		private TeacherDao TeaDao;
	public TeacherBizImpl() {
			super();
			TeaDao =new TeacherDaoImpl();
		}

	@Override
	public Teacher findByAccountAndPassword(String account, String password) {
		 
		return this.TeaDao.find(account, password);
	}

	@Override
	public String update(Teacher t) {
		// TODO Auto-generated method stub
		return this.TeaDao.update(t);
	}

}
