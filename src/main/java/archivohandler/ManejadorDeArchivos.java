package archivohandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

@SuppressWarnings({ "unused" })
public class ManejadorDeArchivos {
	
	
		
	
	public void guardarArchivo(String ruta, Set<String> perm) throws MdaException {
		FileWriter fw = null;
		try {
			File miArchivo = new File(ruta);
			fw = new FileWriter(miArchivo);
			for (String s : perm) {
				fw.write(s);
			}
		} catch (Exception e) {
			System.out.println("Error al generar el archivo...");
			throw new MdaException("Hay un problema para generar archivo",e);
		} finally {
			try {
				if(fw != null)
					fw.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
			
		}
	}
}
