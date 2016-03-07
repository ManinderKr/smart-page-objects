package RIEIT.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Entry {
	
		private String name1;
		private String pass;
		private String country;
		private String state;
		private int id;
		private float amount;
		private String opendate;
		private int mobile;
		
		public String getName1() {
			return name1;
		}

		public void setName1(String name1) {
			this.CaptilizeByWord(name1);
			this.name1 = name1;
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

		public void setPass(String pass1) {
			this.pass2(pass1, 0);
			this.pass = pass1;
		}
		
		private void pass2(String pass3, int flag) {
			CharSequence[] cs= {"@","#","$","%","&"};
			
			for(CharSequence c: cs)
			{
				if(pass3.contains(c))
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
		
		public String getCountry() {
			return country;
		}

		public void setCountry(String country1) {
			this.country = country1;
		}

		public String getState() {
			return state;
		}

		public void setState(String state1) {
			this.state = state1;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public float getAmount() {
			return amount;
		}

		public void setAmount(float amount) {
			this.amount = amount;
		}

		public String getOpendate() {
			return opendate;
		}

		public void setOpendate(String date1) {
			try {
				Date(date1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.opendate = date1;
			
		}
		private void Date(String date1) throws ParseException {
			Date mydate;
			SimpleDateFormat ft= new SimpleDateFormat("MM/dd/yyyy");
			
			        mydate = ft.parse(date1); 	
		}

		public int getMobile() {
			return mobile;
		}

		public void setMobile(int mobile) {
			this.mobile = mobile;
		}	
}