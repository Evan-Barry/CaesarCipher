import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Handler2 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String name2=e.getActionCommand();
		
		String path2="";
		
		FileReader fr2=null;
		BufferedReader br2=null;
		FileWriter fw2=null;
		BufferedWriter bw2=null;
		
		if(name2.equals("CaesarCipher")) {
			FileDialog fileOpen=new FileDialog(E_Frame.f,"���Ͽ���",FileDialog.LOAD);
			fileOpen.setDirectory("D:\\"); //���� ���� ��� ����
			fileOpen.setVisible(true); //���� â ���� ���̰� ����
			path2=fileOpen.getDirectory()+fileOpen.getFile(); //������ ��� �� �̸��� ��� ����
			
			
			try {
				fr2=new FileReader(path2);
				br2=new BufferedReader(fr2);
			
				
				String filename2=fileOpen.getFile();
				filename2=filename2.replace(".txt","_Encryption(Caesar).txt");//���� ���� �̸��� �� ��ȣ�� ���� ���� ����
				File Fi2=new File("D:\\",filename2);
				Fi2.createNewFile();
				
				fw2=new FileWriter(Fi2);//���� ������ ���Ͽ� ��Ʈ�� ��ġ
				bw2=new BufferedWriter(fw2);//���� ��Ʈ���� ���� ��Ʈ�� ��ġ
				
				String line="";
				for(int i=0; (line=br2.readLine())!=null; i++) {
					int offset =-546541;
				    String cipher = CaesarCipher.encryptCaesarCipher(line, offset);
					bw2.write(cipher+"\r\n");
				}
				br2.close();//�Է� ��Ʈ�� ����
				bw2.close();//��� ��Ʈ�� ����
			}catch(IOException IE) {}
		}
		else if(name2.equals("AES")) {
			FileDialog fileOpen=new FileDialog(E_Frame.f,"���Ͽ���",FileDialog.LOAD);
			fileOpen.setDirectory("D:\\"); //���� ���� ��� ����
			fileOpen.setVisible(true); //���� â ���� ���̰� ����
			path2=fileOpen.getDirectory()+fileOpen.getFile(); //������ ��� �� �̸��� ��� ����
			
			
			try {
				fr2=new FileReader(path2);
				br2=new BufferedReader(fr2);
			
				
				String filename2=fileOpen.getFile();
				filename2=filename2.replace(".txt","_Encryption(AES).txt");//���� ���� �̸��� �� ��ȣ�� ���� ���� ����
				File Fi2=new File("D:\\",filename2);
				Fi2.createNewFile();
				
				fw2=new FileWriter(Fi2);//���� ������ ���Ͽ� ��Ʈ�� ��ġ
				bw2=new BufferedWriter(fw2);//���� ��Ʈ���� ���� ��Ʈ�� ��ġ
				
				String line="";
				for(int i=0; (line=br2.readLine())!=null; i++) {
			        String keyString = "1234567890";
			        String encryptStr="";
			        
			        try {
			        	encryptStr = AES.encrypt(keyString, line);
			        }catch(Exception E) {}
			        bw2.write(encryptStr+"\r\n");
				}
				br2.close();//�Է� ��Ʈ�� ����
				bw2.close();//��� ��Ʈ�� ����
			}catch(IOException IE) {}
		}
		
		else if(name2.equals("TripleDES")) {
			FileDialog fileOpen=new FileDialog(E_Frame.f,"���Ͽ���",FileDialog.LOAD);
			fileOpen.setDirectory("D:\\");
			fileOpen.setVisible(true);
			path2=fileOpen.getDirectory()+fileOpen.getFile();
			
			try {
				fr2=new FileReader(path2);
				br2=new BufferedReader(fr2);
				
				String filename2=fileOpen.getFile();
				filename2=filename2.replaceAll(".txt", "_Encryption(TripleDES).txt");//���� ���� �̸��� �� ��ȣȭ ���� ���� ����
				File Fi2=new File("D:\\",filename2);
				Fi2.createNewFile();
				
				fw2=new FileWriter(Fi2);//���� ������ ���Ͽ� ��Ʈ�� ��ġ
				bw2=new BufferedWriter(fw2);//���� ��Ʈ���� ���� ��Ʈ�� ��ġ
				
				String line="";
				for(int i=0; (line=br2.readLine())!=null; i++) {
					String DESbase64Key = "6lRqh2yaYyc1NV2oCcqltC0hYp/9Lnn5";
					String encryptedBase63_3DES="";
					try {
						encryptedBase63_3DES = TripleDESBase64.encrypt(DESbase64Key, line);
					} catch(Exception E) {}
					bw2.write(encryptedBase63_3DES+"\r\n");
				}
				br2.close();//�Է� ��Ʈ�� ����
				bw2.close();//��� ��Ʈ�� ����
			}catch(IOException IE) {}
		}
	}
}
