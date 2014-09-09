package helpers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import play.mvc.Http.MultipartFormData.FilePart;
import utils.ImageResize;

public class ImageFormatter {
	
	static FilePart picture;
	
	public static byte[] image(FilePart filePart) throws IOException{
		picture = filePart;
		File file = picture.getFile();

		BufferedImage originalImage = null;
		try {
			originalImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		BufferedImage image = ImageResize.resizeImage(originalImage ,type);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", baos);
		baos.flush();
		byte[] bytes = baos.toByteArray();
		baos.close();

		return bytes;
	}
	
	public static String imageName(){
		return picture.getFilename();
	}
}

