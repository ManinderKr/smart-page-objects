package RIEIT.model;


public class EmailID {
	 boolean isValid(String email)
	{
		 
		
		if(email.indexOf('@')==-1)
			return false;
		int atIndex=email.indexOf('@');
		
		int dotIndex = email.indexOf('.');
		if(dotIndex==-1 || dotIndex==atIndex+1 || dotIndex==email.length()-1)
			return false;
		
			
			return true;
	}
	 
	 
}
