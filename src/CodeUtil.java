import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class CodeUtil {
	
	/**
	 * BASE64加密
	 * @param str
	 * @return
	 */
    public static String Base64EncoderFromString(String str) {  
        byte[] b = null;  
        try {  
            b = str.getBytes(Code.UTF8);  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return Base64EncoderFromByte(b);  
    }  
    /**
     * BASE64加密
     * @param b
     * @return
     */
    public static String Base64EncoderFromByte(byte[] b){
    	 if (b != null) {  
    		 return new BASE64Encoder().encode(b);  
    	 }
    	return null;
    }
  
    /**
     * BASE64解密  
     * @param s
     * @return
     */
    public static String Base64DecoderToString(String s) {  
        byte[] b = null;  
        String result = null;  
        if (s != null) {  
            try {  
                b = Base64DecoderToByte(s);  
                result = new String(b, Code.UTF8);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
    /**
     * BASE64解密  
     * @param s
     * @return
     */
	public static byte[] Base64DecoderToByte(String s){
		byte[] b = null;
		if(s != null){
			try {
				b = new BASE64Decoder().decodeBuffer(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return b;
	}
	/**
	 * 转为MD5
	 * @param str
	 * @return
	 */
	public static String MD5Encoder(String str){
		return encode(str,Code.Md5);
	}
	/**
	 * 转为SHA1
	 * @param str
	 * @return
	 */
	public static String SHA1Encoder(String str){
		return encode(str,Code.SHA1);
	}
	/**
	 * 转为SHA256
	 * @param str
	 * @return
	 */
	public static String SHA256Encoder(String str){
		return encode(str,Code.SHA256);
	}

	//加密
	private static String encode(String str,String algorithm){
		if(str==null){
			return null;
		}
		StringBuilder sb=new StringBuilder();
		try{
			MessageDigest code=MessageDigest.getInstance(algorithm);
			
			code.update(str.getBytes());
			byte[] bs=code.digest();
			for(int j=0;j<bs.length;j++){
				int v=bs[j]&0xFF;
				if(v<16){
					sb.append(0);
				}
				sb.append(Integer.toHexString(v));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return sb.toString().toLowerCase();
	}
}
