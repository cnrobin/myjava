import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Encrypt
{
 
  /**
   * �����ı����ݣ����� SHA-256 ��
   * 
   * @param strText
   * @return
   */
  public String SHA256(final String strText)
  {
    return SHA(strText, "SHA-256");
  }
 
  /**
   * �����ı����ݣ����� SHA-512 ��
   * 
   * @param strText
   * @return
   */
  public String SHA512(final String strText)
  {
    return SHA(strText, "SHA-512");
  }
 
  /**
   * �ַ��� SHA ����
   * 
   * @param strSourceText
   * @return
   */
  private String SHA(final String strText, final String strType)
  {
    // ����ֵ
    String strResult = null;
 
    // �Ƿ�����Ч�ַ���
    if (strText != null && strText.length() > 0)
    {
      try
      {
        // SHA ���ܿ�ʼ
        // �������ܶ��� ������������
        MessageDigest messageDigest = MessageDigest.getInstance(strType);
        // ����Ҫ���ܵ��ַ���
        messageDigest.update(strText.getBytes());
        // �õ� byte ��ͽ��
        byte byteBuffer[] = messageDigest.digest();
 
        // �� byte �D�Q�� string
        StringBuffer strHexString = new StringBuffer();
        // ��v byte buffer
        for (int i = 0; i < byteBuffer.length; i++)
        {
          String hex = Integer.toHexString(0xff & byteBuffer[i]);
          if (hex.length() == 1)
          {
            strHexString.append('0');
          }
          strHexString.append(hex);
        }
        // �õ����ؽY��
        strResult = strHexString.toString();
      }
      catch (NoSuchAlgorithmException e)
      {
        e.printStackTrace();
      }
    }
 
    return strResult;
  }
  public static void main(String args[]){
	  Encrypt e=new Encrypt();
	  System.out.println(e.SHA512("itc007!@#$"));
  }
}