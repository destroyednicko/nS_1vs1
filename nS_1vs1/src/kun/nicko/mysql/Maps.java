package kun.nicko.mysql;

import java.io.IOException;

import kun.nicko.Main;

public class Maps {
	
	
	public static String getmap(){
		String map = Main.cfg2.getString("Map.nome").toUpperCase();
		return map;
	}
	public static String getmapautor(){
		String mapautor = Main.cfg2.getString("Map.autor");
		return mapautor;
	}
	public static void setmapvalue(){
		Main.cfg2.addDefault("Map.nome", "Nome Padrão");
		Main.cfg2.addDefault("Map.autor", "Autor Padrão");
		try {
			Main.cfg2.save(Main.file2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
