import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class E_Frame {
	TextArea Contents; //���� ���� ���
	Panel P1;//�ؽ�Ʈ ���� ����
	Panel P2;//��ư�� ����
	Frame f;
	
	
	E_Frame(){
		f=new Frame("Encryption");
		f.setLayout(null);
		f.setSize(500,500);

		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();//ȭ���� ũ�⸦ ����

		f.setLocation(screenSize.width/2-250,screenSize.height/2-250);
		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);	
			}
		});
		
		P1=new Panel();
		P1.setSize(400,200);
		P1.setLocation(50,50);
		
		
		Contents=new TextArea(10,50);
		Contents.setEditable(false); //���Ƿ� ���ۺҰ�
		P1.add(Contents);
		f.add(P1);
		
		P2=new Panel();
		P2.setSize(400,200);
		P2.setLocation(50,300);
		
		Button button1=new Button("���Ͽ���");
		Button button2=new Button("��ȣȭ �ϱ�");
		Button button3=new Button("��ȣȭ �ϱ�");
		
		P2.add(button1);
		P2.add(button2);
		P2.add(button3);
		
		f.add(P2);
		
		f.revalidate();// ��ü�� ��ġ�� �������� �ϱ����� ���
		
		button1.addActionListener(new Handler());
		button2.addActionListener(new Handler());
		button3.addActionListener(new Handler());
	}
	
	class Handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String name=e.getActionCommand();
			String path="";
			
			FileReader fr=null;
			BufferedReader br=null;
			FileWriter fw=null;
			BufferedWriter bw=null;
			
			
			if(name.equals("���Ͽ���")) {
				Contents.setText("");//�ؽ�Ʈâ �ʱ�ȭ
				
				FileDialog fileOpen=new FileDialog(f,"���Ͽ���",FileDialog.LOAD);
				fileOpen.setDirectory("D:\\"); //���� ���� ��� ����
				fileOpen.setVisible(true); //���� â ���� ���̰� ����
				path=fileOpen.getDirectory()+fileOpen.getFile(); //������ ��� �� �̸��� ��� ����
				
				
				try {
					fr=new FileReader(path);//���Ͽ� ��Ʈ�� ��ġ
					br=new BufferedReader(fr);//���� ��Ʈ���� ���� ��Ʈ�� ��ġ �б� �ӵ��� ���̱� ����
					
					String line="";
					for(int i=0; (line=br.readLine())!=null; i++) {
						Contents.append(line+"\n");
					}
					br.close();//���� ��Ʈ�� ���� Ȥ�ó� ���ۿ� ���� ���� �����͸� ��� ����س�
				}catch(IOException IE) {}
			}

			else if(name.equals("��ȣȭ �ϱ�")) {
				
				FileDialog fileOpen=new FileDialog(f,"���Ͽ���",FileDialog.LOAD);
				fileOpen.setDirectory("D:\\"); 
				fileOpen.setVisible(true);
				path=fileOpen.getDirectory()+fileOpen.getFile(); 
				
				try {
					fr=new FileReader(path);
					br=new BufferedReader(fr);
				
					
					String filename=fileOpen.getFile();
					filename=filename.replace(".txt","_Encryption.txt");//���� ���� �̸��� �� ��ȣ�� ���� ���� ����
					File Fi=new File("D:\\",filename);
					Fi.createNewFile();
					
					fw=new FileWriter(Fi);//���� ������ ���Ͽ� ��Ʈ�� ��ġ
					bw=new BufferedWriter(fw);//���� ��Ʈ���� ���� ��Ʈ�� ��ġ
					
					String line="";
					for(int i=0; (line=br.readLine())!=null; i++) {
						int offset =-546541;
					    String cipher = CaesarCipher.encryptCaesarCipher(line, offset);
						bw.write(cipher+"\r\n");
					}
					br.close();//�Է� ��Ʈ�� ����
					bw.close();//��� ��Ʈ�� ����
				}catch(IOException IE) {}
			}

			else if(name.equals("��ȣȭ �ϱ�")) {
				
				FileDialog fileOpen=new FileDialog(f,"���Ͽ���",FileDialog.LOAD);
				fileOpen.setDirectory("D:\\"); 
				fileOpen.setVisible(true);
				path=fileOpen.getDirectory()+fileOpen.getFile(); 

				try {
					fr=new FileReader(path);
					br=new BufferedReader(fr);


					String filename=fileOpen.getFile();
					filename=filename.replace("_Encryption.txt","_Decryption.txt");
					File Fi=new File("D:\\",filename);
					Fi.createNewFile();

					fw=new FileWriter(Fi);
					bw=new BufferedWriter(fw);

					String line="";
					for(int i=0; (line=br.readLine())!=null; i++) {
						int offset =-546541;
						String cipher = CaesarCipher.encryptCaesarCipher(line, -offset);
						bw.write(cipher+"\r\n");
					}
					br.close();
					bw.close();

				}catch(IOException IE) {}
			}
		}
	}
}
