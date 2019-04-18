package viewAndCon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.omg.PortableInterceptor.IORInterceptor;

 
import biz.StudentBiz;
import biz.impl.StudentBizImpl;
import domain.Student;

public class controy {
	private ServerSocket ser;//创建服务器套接字；
	private List<controyThread> listcon;
	public static final int PORT=7979;
//	//创建守护线程
//	 private watch w;
	private ExecutorService es;
	 private SMSServer sb;
	public controy() {
		super();
		 
		try {
			System.out.println("服务器开启中.....");
			ser=new ServerSocket(PORT);
			Thread.sleep(1000);
			System.out.println("服务器已连接.....");
			 listcon=new ArrayList<controyThread>();
//			 w=new watch(listcon);
//			//开启守护线程
//			 w.start();
			 es=Executors.newCachedThreadPool();
			 this.sb=new SMSServiceImpl();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	 
	public void start(){
		 while(true){
			 try {
				Socket accept = ser.accept();
				System.out.println("用户"+accept.getInetAddress().getHostAddress()+"已连接");
				controyThread ct=new controyThread(accept,sb);
				es.submit(ct);
			System.out.println("当前在线活跃用户："+((ThreadPoolExecutor)es).getActiveCount());
			 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		
	}
 
	 
	}
