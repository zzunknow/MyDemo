import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class StreamUtil {

	/**
	 * 读取文件
	 * @param path
	 * @return
	 */
	public static byte[] getByteFromFile(String path){
		InputStream in = null;
		byte[] b = null;
		try {
			in = new FileInputStream(path);
			b = new byte[in.available()];
			in.read(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(in != null){
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return b;
	}
	
	/**
	 * 输出String到文件
	 * @param val
	 * @param path
	 */
	public static void outFileFromString(String val,String path){
		if(val != null){
			byte[] b = val.getBytes();
			outFileFromByte(b,path);
		}
	}
	
	/**
	 * 输出byte到文件
	 * @param b
	 * @param path
	 */
	public static void outFileFromByte(byte[] b,String path){
		if(b != null){
			OutputStream out = null;
			try {
				out = new FileOutputStream(path);
				out.write(b);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
