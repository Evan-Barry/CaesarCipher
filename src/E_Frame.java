import java.awt.*;
import java.awt.event.*;

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
		
		
		Contents=new TextArea("���� �Է�",10,50);
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
		
		f.revalidate();
		
		button1.addActionListener(new Handler());
		button2.addActionListener(new Handler());
		button3.addActionListener(new Handler());
	}
	
	class Handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String name=e.getActionCommand();
			
			
			if(name.equals("���Ͽ���")) {
				
				FileDialog fileOpen=new FileDialog(f,"���Ͽ���",FileDialog.LOAD);
				fileOpen.setDirectory("C:\\");
				fileOpen.setVisible(true);
				
			}
			else if(name.equals("��ȣȭ �ϱ�")) {
				
			}
			else if(name.equals("��ȣȭ �ϱ�")) {
				
			}
		}
	}
}
