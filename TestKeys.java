import java.io.*;

public class TestKeys{




	public static void main(String args[]){
		String s="23f284bd9e10a32c04092721ff36caf343be4312b5f7e675a4af5e61a26ea5cb490e2576203860917a26f15b2834daa06d04e737220ba52a35ff57248be869fd23f284bd9e10a32c04092721ff36caf343be4312b5f7e675a4af5e61a26ea5cb490e2576203860917a26f15b2834daa06d04e737220ba52a35ff57248be869fd23f284bd9e10a32c04092721ff36caf343be4312b5f7e675a4af5e61a26ea5cb490e2576203860917a26f15b2834daa06d04e737220ba52a35ff57248be869fd23f284bd9e10a32c04092721ff36caf343be4312b5f7e675a4af5e61a26ea5cb490e2576203860917a26f15b2834daa06d04e737220ba52a35ff57248be869fd23f284bd9e10a32c04092721ff36caf343be4312b5f7e675a4af5e61a26ea5cb490e2576203860917a26f15b2834daa06d04e737220ba52a35ff57248be869fd23f284bd9e10a32c04092721ff36caf343be4312b5f7e675a4af5e61a26ea5cb490e2576203860917a26f15b2834daa06d04e737220ba52a35ff57248be869fd23f284bd9e10a32c04092721ff36caf343be4312b5f7e675a4af5e61a26ea5cb490e2576203860917a26f15b2834daa06d04e737220ba52a35ff57248be869fd23f284bd9e10a32c04092721ff36caf343be4312b5f7e675a4af5e61a26ea5cb490e2576203860917a26f15b2834daa06d04e737220ba52a35ff57248be869fd";
		char keys[];
		byte keys2[];
		keys=s.toCharArray();
		keys2=s.getBytes();
		System.out.println(s.length());

		System.out.println(keys2[0]);

		try{
			DataInputStream dis = null;
			DataOutputStream dos = null;
			dis = new DataInputStream(new FileInputStream ("C:\\myjava\\tools\\en_test.txt"));
			dos = new DataOutputStream(new FileOutputStream ("C:\\myjava\\tools\\en2_test.txt"));

			byte []b = new byte [1024];
			int l=dis.read(b);
			while(l>0){
				System.out.println("l="+l);
				for(int i=0;i<l;i++){
					b[i]=(byte)(b[i]^keys2[i]);
				}
				dos.write(b,0,l);
				l=dis.read(b);
			}
			dos.close();
			dis.close();
		}catch(Exception e){
			System.out.println(e);
		}
		

	}
}