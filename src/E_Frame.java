import java.awt.*;
import java.awt.event.*;

public class E_Frame extends Frame {
	TextArea Contents; //���� ���� ���
	Panel P1;//�ؽ�Ʈ ���� ����
	Panel P2;//��ư�� ����
	
	
	E_Frame(){
		super("Encryption");
		setLayout(null);
		setSize(500,500);

		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();//ȭ���� ũ�⸦ ����

		setLocation(screenSize.width/2-250,screenSize.height/2-250);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);	
			}
		});
		
		P1=new Panel();
		P1.setSize(400,200);
		P1.setLocation(50,50);
		P1.setBackground(Color.yellow);
		
		Contents=new TextArea("���� �Է�",10,50);
		P1.add(Contents);
		add(P1);
		
		P2=new Panel();
		P2.setSize(400,200);
		P2.setLocation(50,300);
		P2.setBackground(Color.red);
		Button button1=new Button("���Ͽ���");
		Button button2=new Button("��ȣȭ �ϱ�");
		Button button3=new Button("��ȣȭ �ϱ�");
		
		P2.add(button1);
		P2.add(button2);
		P2.add(button3);
		
		add(P2);
		
		
		
	}
}
