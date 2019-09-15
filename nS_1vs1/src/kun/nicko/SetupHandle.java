package kun.nicko;

import java.io.IOException;

public class SetupHandle {
	
	public static void setsetup(boolean value){
		Main.cfg.set("1vs1.setup", value);
		try {
			Main.cfg.save(Main.file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean getsetup(){
		return Main.cfg.getBoolean("1vs1.setup");
	}

}
