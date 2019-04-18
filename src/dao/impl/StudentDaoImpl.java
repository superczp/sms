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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.StudentDao;
import domain.Student;

public class StudentDaoImpl implements StudentDao {
	private PrintWriter out;
	private BufferedReader in;
	public static final String DIZ="data/student.txt";
	@Override
	public boolean addStu(Student stu) {
		try {
			out=new PrintWriter(new OutputStreamWriter(new FileOutputStream(DIZ,true),"utf-8"));
			out.println(stu.show());
			out.flush();
			return true;
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			return false;
		}
		finally {
			if(out!=null)
				out.close();
		}
		 
	}

	@Override
	public List<Student> findAllstu() {
		List <Student> l1=new ArrayList<Student>();
		File newFile=new File(DIZ);
		if(!newFile.exists()){
			try {
				newFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream(DIZ),"utf-8"));
			String st="";
			while((st=in.readLine())!=null){
				String[] arr=st.split("#");
				l1.add(new Student(Integer.parseInt(arr[0]),arr[1], Double.parseDouble(arr[2])));
			}
			return l1;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 
				try {
					if(in!=null)
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return null;
	}

	@Override
	public Student findStu(int a) {
		 List<Student> list=this.findAllstu();
		 for (Student student : list) {
			if(student.getStuId()==a)
			{
				return student;
				 
			}
		}return null;
		 
	}

	@Override
	public boolean delete(int a) {
		 List<Student> list=this.findAllstu();
		 for (Student student : list) {
			if(student.getStuId()==a){
				list.remove(student);
				break;
			}
		}
		 File file=new File(DIZ);
		 if(file.exists())
			 file.delete();
		 
		 for (Student student : list) {
			this.addStu(student);
		}
		 
		return true;
	}

	@Override
	public boolean updata(int id, double newScort) {
		Student findStu = this.findStu(id);
			 
			String name=findStu.getName();
			this.delete(id);
			this.addStu(new Student(id, name, newScort));
			return true;
		 
		 
	}

	@Override
	public List<Student> findLike(String s) {
		 List<Student> findAllstu = this.findAllstu();
		  Iterator<Student> iterator = findAllstu.iterator();
		 while(iterator.hasNext()){
			 if(iterator.next().getName().indexOf(s)==-1)
				 iterator.remove();
				 
		 }
		return findAllstu;
	}

	 

}
