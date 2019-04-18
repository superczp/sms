package viewAndCon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Util.MySort;
import biz.StudentBiz;
import biz.impl.StudentBizImpl;
 
import domain.Student;
 

public class controyThread extends Thread {
	private Socket soc;//创建套接字
	 //创建一个被代理的对象
	private Object o;
	public controyThread(Socket soc,Object o) {
		super();
		this.soc = soc;
		 this.o=o;
	}
	@Override
	public void run() {
	 //获取输入流勇于接受客户端代理发送的方法名称 参数类型参数列表
		try {
			ObjectInputStream ois=new ObjectInputStream(soc.getInputStream());
			//获取方法名称
			String methodName=ois.readUTF();
			//获取方法参数类型
			Class<?>[] methodTypes=(Class<?>[]) ois.readObject();
			//获取方法参数列表
			Object[] methodParams=(Object[]) ois.readObject();
			//获取方法对象
			Method method2 =o.getClass().getMethod(methodName, methodTypes);
			//执行该方法返回结果
			Object result =method2.invoke(o, methodParams);
			//创建输出流
			ObjectOutputStream oos=new ObjectOutputStream(soc.getOutputStream());
			//将结果发送给客户端
			oos.writeObject(result);
			oos.flush();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
 
	 
 
 
}
