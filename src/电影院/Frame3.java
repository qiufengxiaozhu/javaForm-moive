package 电影院;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Frame3 extends JFrame {
	JPanel panel1 = new JPanel();	//���������
	
	JLabel label1 = new JLabel();	//ӰƬ1
	JLabel label2 = new JLabel();	//ӰƬ2
	JLabel label3 = new JLabel();	//ӰƬ3
	Label label4 = new Label(null, Label.CENTER);	//��Ӱ1��������ʾ��
	Label label5 = new Label(null, Label.CENTER);	//��Ӱ2��������ʾ��
	Label label6 = new Label(null, Label.CENTER);	//��Ӱ3��������ʾ��
	
	ImageIcon image1 = new ImageIcon("����.PNG");
	ImageIcon image2 = new ImageIcon("����1.PNG");
	ImageIcon image3 = new ImageIcon("����2.PNG");

	Button button[] = new Button[3];	//ѡ���Ӱ

	
	public Frame3(String s, int i, int j, int k, int l) throws SQLException   {//���ô���һ������
		// TODO Auto-generated constructor stub
		init();	
		setTitle(s);
		setLocation(i,j);
		setSize(k,l);
		ck();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);
	}
	
	public void ck() throws SQLException	//�жϴ����Ƿ�ر�
    {          
            addWindowListener(new WindowAdapter()
            {
            	public void windowClosing(WindowEvent e)
            	{
                     int result=JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�˳������ڲ���", "Information", JOptionPane.YES_NO_OPTION);
                     if(result==JOptionPane.YES_OPTION) {
                    	 
                    	 try {
     		                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     		            } 
     		            catch (ClassNotFoundException e1) {
     		                System.err.println("δ�ҵ�����");
     		            }
     		            try {
     		                String connectDB = "jdbc:sqlserver://localhost\\SQLEXPRESS:1434;DatabaseName=��ӰԺ���ݿ�";
     		                String user = "sa";
     		                String password = "123456";
     		                Connection conn=null;
     		                conn = DriverManager.getConnection(connectDB, user,password);     		
     		                Statement stmt = conn.createStatement(); 
     		                
     		                stmt.executeUpdate("update users set flag='"+0+"' where flag='"+1+"'");    		         
     		                stmt.executeUpdate("update movie set flag='"+0+"' where flag='"+1+"'"); 
     		                stmt.close();// �ر������������
     					    conn.close();// �ر����ݿ�����
     		            }
     					catch (SQLException e1) {
     						e1.printStackTrace();
     					    System.out.print(e1.getErrorCode());
     					    System.out.println("���ݿ����Ӵ���");
     					    System.exit(0);
     					}							
                    	 
                        System.exit(0); //����������ȽϺ��ʣ���Ϊ������ֱ���˳����򣬶�dispose()ֻ�رմ��壬������û������             
                        }
                     else
                      {
                    	 try {
							new Frame3("ѡ������",(1366-1000)/2, (768-700)/2, 1000, 700);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                     }
               }
         });
    }
	
	 void init(){
		Color c =new Color(100,200,200);	//������ɫ
		Color c1 =new Color(128,255,128);
		panel1.setBackground(c);	
		panel1.setLayout(null);		//���ÿղ���
		
		//ӰƬ1
		label1.setBounds(80, 10, 260, 400);
		label1.setBackground(Color.white);
		label1.setIcon(image1);
		//ӰƬ2
		label2.setBounds(370, 10, 260,400);
		label2.setBackground(Color.white);
		label2.setIcon(image2);
		//ӰƬ3
		label3.setBounds(660, 10, 260,400);
		label3.setBackground(Color.white);
		label3.setIcon(image3);
		//��Ӱ��ǩ1
		label4.setBounds(80, 420, 260, 40);
		label4.setText("���㺣�� ");
		label4.setFont(new Font("����", Font.PLAIN, 20));//���������С��ɫ
		label4.setBackground(c);
		//��Ӱ��ǩ2
		label5.setBounds(370, 420, 260, 40);
		label5.setText("֩��������3");
		label5.setFont(new Font("����", Font.PLAIN, 20));//���������С��ɫ
		label5.setBackground(c);	
		//��Ӱ��ǩ3
		label6.setBounds(660, 420, 260, 40);
		label6.setText("��ʥ����");
		label6.setFont(new Font("����", Font.PLAIN, 20));//���������С��ɫ
		label6.setBackground(c);
		
		for(int i=0;i<=2;i++) {	//ѭ������ ѡ��ӰƬ ��ť
			button[i] = new Button();
			button[i].setBounds(145+(290*i), 480, 130, 60);
			button[i].setLabel("ѡ��ѡ�ң�");	
			button[i].setFont(new Font("����", Font.PLAIN, 20));//���������С��ɫ
			button[i].setBackground(c1);			
		}
		for(int i=0;i<=2;i++) {
			int id = i+1;
			button[i].addActionListener(new ActionListener(){	//�������¼�������

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
		                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            } 
		            catch (ClassNotFoundException e1) {
		                System.err.println("δ�ҵ�����");
		            }
		            try {
		                String connectDB = "jdbc:sqlserver://localhost\\SQLEXPRESS:1434;DatabaseName=��ӰԺ���ݿ�";
		                String user = "sa";
		                String password = "123456";
		                Connection conn=null;
		                conn = DriverManager.getConnection(connectDB, user,password);
		                // �������ݿ����
		                //System.out.println("�������ݿ�ɹ�");
		                Statement stmt = conn.createStatement();
		                // ����SQL�������					                               	
		                stmt.executeUpdate("update dbo.movie set flag='1' where ID=N'"+id+"'"); // ������治��where����������������е�value�ֶ�
		                
						stmt.close();// �ر������������
					    conn.close();// �ر����ݿ�����
					    dispose();
					    Frame2 f2=new Frame2("ѡ������",(1366-1000)/2, (768-700)/2, 1000, 700);
		            }
					catch (SQLException e1) {
						e1.printStackTrace();
					    System.out.print(e1.getErrorCode());
					    System.out.println("���ݿ����Ӵ���");
					    System.exit(0);
					}							
					
					
				}
			});
		}
		
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(label3);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		panel1.add(button[0]);
		panel1.add(button[1]);
		panel1.add(button[2]);
		add(panel1);	//�����嵽����
	}
}
