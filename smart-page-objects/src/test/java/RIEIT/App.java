package RIEIT;

public class App {

	public static void main(String[] args) {
			
		YahooHomePage yahoohomepage=  new YahooHomePage("http://www.yahoo.com");
		
		boolean s= yahoohomepage.isReady();
		yahoohomepage.open();
		yahoohomepage.reload();
		yahoohomepage.error();
		
		System.out.println("Is page ready ?" + s );
		
	}

}
