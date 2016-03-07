 package RIEIT.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YahooHomePage implements ILib{
	public String url;
	
	
	public YahooHomePage(String url){
		 
		 this.url=url;
	 }
	
	public String url() {
		
		return url;
	}

	public boolean isReady() {
		
		return true ;
	}

	public void open() {
		
		if (url=="http://www.yahoo.com")
		{
			isReady();
		}
		else
		{
			System.out.println("Please enter correct url!");
		}
	}

	public void reload(){
		ActionListener a= new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				 if (e.getSource()==url){
					 isReady();
				 }	
			}
		};
		
	}
	
	public void error(){
	Thread timer= new Thread(){
		public void run() {
			try{
				sleep(5000);
			}
			catch(InterruptedException e){
				
			System.out.println("An error is occur!!");
			}
		}
	};
		timer.start();
	}
	
	
}
