package RIEIT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Info  {
	private String name;
	private String pass;
	private String date;
	private String country;
	private String state;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.CaptilizeByWord(name);
		this.name = name;
	}
	
	
	private String CaptilizeByWord(String name2) {
		String s="";
		if(name2.length()==0)
		{
			System.out.println("Please enter name");
		}
		
		s=name2.substring(0,1).toUpperCase();
		s=s+name2.substring(1).toLowerCase();
		return s;
		
	}
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass1(pass, 0);
		this.pass = pass;
	}
	
		private void pass1(String pass2, int flag) {
			CharSequence[] cs= {"@","#","$","%","&"};
			
			for(CharSequence c: cs)
			{
				if(pass2.contains(c))
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				System.out.println("Please enter valid password having special character");
			}
		}

	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		try {
			Date(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.date = date;
		
	}
	
	private void Date(String date) throws ParseException {
		Date mydate;
		SimpleDateFormat ft= new SimpleDateFormat("MM/dd/yyyy");
		
		    //Calendar cal = Calendar.getInstance();
		        mydate = ft.parse(date); 
			
	}	
		
		//if(date.equals(ft.format(dNow)))
	//	{
		//	System.out.println(date);
	//	}
		//else
		//{
			//System.out.println("Please enter Date having pattern " + ft.format(dNow));
	//	}
	//}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}	
	
}
