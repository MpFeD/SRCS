package TME2;

import java.net.Socket;

public class ThreadServeur extends Thread{

	String request;
	Socket c;
	public ThreadServeur(String request,Socket c){
		super();
		this.request=request;
		this.c=c;
	}
	
	public void run (){
		HttpRequest httpr = new HttpRequest(request,this.c);
		httpr.processRequest();
	}
}
