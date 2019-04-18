package dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import dao.TeacherDao;
import domain.Teacher;

public class TeacherDaoImpl implements TeacherDao {
	private BufferedReader in;
	private PrintWriter out;
	public static final String URL="data/teacher.txt";
	@Override
	public Teacher find(String account, String password) {
		List<Teacher> list=this.selectAll();
		for (Teacher teacher : list) {
			if(teacher.getAccout().equals(account)&&teacher.getPassword().equals(password)){
				return teacher;
			}
		}
		return null;
	}
	public List<Teacher> selectAll(){
		List<Teacher> list=new ArrayList<Teacher>();
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream(URL)));
			String s="";
			while ((s=in.readLine())!=null){
				String[] arr=s.split("#");
				list.add(new Teacher(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]));
			}
			return list;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			 
				try {if(in!=null)
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
		
	}

	@Override
	public String update(Teacher t) {
		 List<Teacher> list=this.selectAll();
		 for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getId()==t.getId()){
				list.set(i,t);
			}
		}
		 File file=new File(URL);
		 if(file.exists()){
			 file.delete();
		 }
		 for (Teacher teacher : list) {
			this.addTeacher(teacher);
		}
		 return "修改成功";
	}
	private boolean addTeacher(Teacher t){
		try {
			out=new PrintWriter(new OutputStreamWriter(new FileOutputStream(URL,true)));
			out.println(t.show());
			out.flush();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
		finally {
			if(out!=null)out.close();
		}
	}

}
