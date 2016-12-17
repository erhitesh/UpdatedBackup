package parallelTesting;

import org.openqa.grid.common.RegistrationRequest;
import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
import org.openqa.grid.web.Hub;



public class StartHubNodeByPro {
	
	/* Global Variable Declaration */
	static String hubJsonLoc = "";
	static String nodeJsonLoc = "";
	
	
	public static void main(String args[]){
		
		/* Hub And Node configuration */
		GridHubConfiguration con = new GridHubConfiguration();
		/*con.host = "localhost";
		con.port = 4444;*/
		//con.loadFromJSON(hubJsonLoc);
		
		/* Create Hub instance */
		Hub hub = new Hub(con.loadFromJSON(hubJsonLoc));
		try {
			hub.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Node Registration */
		RegistrationRequest reg = new RegistrationRequest();
		reg.fromJson(nodeJsonLoc);
		
	}

}
