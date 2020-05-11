package 电影院;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Frame2 extends JFrame {
	
	SQL dc=new SQL();  //�������ݿ�Ķ���
	
	int i1,j1=0;
	
	Button btnSeat[][]=new Button[7][9];	//���� ��λ��ť ����
	
	JPanel panel1 = new JPanel();	//�������
	JPanel panel2 = new JPanel();	//�������
	
	Label label1 = new Label();	//�����û���ʶ 
	Label label2 = new Label();	//�����û���ʶ 
	JLabel label3 = new JLabel();	//չʾ����
	Label label4 = new Label();	//����ǩ
	Label label5 = new Label();	//���۱�ǩ
	Label label6 = new Label();	//������ǩ
	Label label7 = new Label();	//�ܼ۱�ǩ
	JLabel label8 = new JLabel();	//չʾ����Ļ
	
	JTextArea text= new JTextArea(); //չʾ���
	JScrollPane text1 = new JScrollPane(text);	//�����������ı���

	Button button1 = new Button();//ע���˺�
	Button button2 = new Button();//���ص�Ӱ����

	ImageIcon image1 = new ImageIcon("����3.PNG");
	ImageIcon image2 = new ImageIcon("����4.PNG");
	ImageIcon image3 = new ImageIcon("����5.PNG");
	ImageIcon image5 = new ImageIcon("timg.gif");
	ImageIcon image4 = new ImageIcon("timg2.gif");
	ImageIcon image6 = new ImageIcon("timg3.gif");
	
	public Frame2(String s, int i, int j, int k, int l) throws SQLException {//���ô����������
		// TODO Auto-generated constructor stub
		
		init();	//��ʼ���ؼ�
		setTitle(s);
		setLocation(i,j);
		setSize(k,l);
		close();	//�رմ���
		create();	//��ԭ��ȡ����
		setVisible(true);
			 
		
	}
	
	 void create() throws SQLException {//��ԭ��ȡ����
		// TODO Auto-generated method stub
		
		//�Ǳ��˹�����λ��ʾΪ��ɫ
		Connection cc=dc.data();	
		
		//���ݵ�Ӱ������Ӧ����λ��
		Statement stmt3=cc.createStatement();//����һ��Statement����
		ResultSet rs3 = stmt3.executeQuery("SELECT ID,jianjie FROM movie where flag='"+1+"'");
		if(rs3.next()) {
			text.setText(rs3.getString("jianjie"));	//�������				
			text.setCaretPosition(text.getText().charAt(0));	//���Ƽ��������ʾ
			
			i1 = Integer. parseInt (rs3.getString("ID"));	//ƥ����λ��	
			
			switch(i1) {					
			case 1: {	//ƥ�䵽��λ��1
					label3.setIcon(image1);	//չʾ��Ӧ����
					label8.setIcon(image4);
					label5.setText("ÿ��Ʊ����Ϊ��30.5 Ԫ");
					Statement stmt=cc.createStatement();//����һ��Statement����		
					ResultSet rs = stmt.executeQuery("SELECT * FROM seats1 where flag='"+1+"'");	
					while (rs.next()) {
			            // ���ÿ���ֶ�			
						int row=  Integer. parseInt (rs.getString("row"));
						int col=  Integer. parseInt (rs.getString("col"));	
						
						btnSeat[row][col].setBackground(Color.YELLOW);	//ֻҪ����λ�����ͽ���λ��Ϊ��ɫ
						btnSeat[row][col].setLabel("����");
						btnSeat[row][col].setEnabled(false);
			        }		
					stmt.close();
				}
			break;
			case 2: {	//ƥ�䵽��λ��2
					label3.setIcon(image2);	//չʾ��Ӧ����
					label8.setIcon(image5);
					label5.setText("ÿ��Ʊ����Ϊ��20.0 Ԫ");
					Statement stmt=cc.createStatement();//����һ��Statement����		
					ResultSet rs = stmt.executeQuery("SELECT * FROM seats2 where flag='"+1+"'");
					while (rs.next()) {
			            // ���ÿ���ֶ�			
						int row=  Integer. parseInt (rs.getString("row"));
						int col=  Integer. parseInt (rs.getString("col"));	
						
						btnSeat[row][col].setBackground(Color.YELLOW);	//ֻҪ����λ�����ͽ���λ��Ϊ��ɫ
						btnSeat[row][col].setLabel("����");
						btnSeat[row][col].setEnabled(false);
			        }		
					stmt.close();
				}
			break;
			case 3: {	//ƥ�䵽��λ��3
					label3.setIcon(image3);	//չʾ��Ӧ����
					label8.setIcon(image6);
					label5.setText("ÿ��Ʊ����Ϊ��33.3 Ԫ");
					Statement stmt=cc.createStatement();//����һ��Statement����		
					ResultSet rs = stmt.executeQuery("SELECT * FROM seats3 where flag='"+1+"'");
					while (rs.next()) {
			            // ���ÿ���ֶ�			
						int row=  Integer. parseInt (rs.getString("row"));
						int col=  Integer. parseInt (rs.getString("col"));	
						
						btnSeat[row][col].setBackground(Color.YELLOW);	//ֻҪ����λ�����ͽ���λ��Ϊ��ɫ
						btnSeat[row][col].setLabel("����");
						btnSeat[row][col].setEnabled(false);
			        }		
					stmt.close();
				}
			break;
			}
		}
		stmt3.close();		
		
		//�ж��Ƿ�Ϊ���˹���
		Statement stmt1=cc.createStatement();
		ResultSet rs1 = stmt1.executeQuery("SELECT * FROM users where flag='1'");//��ʾ�û�ID
		while (rs1.next()) {
            // ����û�ID
			label2.setText(rs1.getString("ID"));	//��ʾ�û�ID	
			
        }		
		stmt1.close();// �ر������������

		//���˹�����λ��ʾΪ��ɫ		
		switch(i1) {
		case 1: {
				Statement stmt2=cc.createStatement();//����һ��Statement����
				ResultSet rs2 = stmt2.executeQuery("SELECT * FROM seats1 where  name = N'"+label2.getText()+"'");
				while (rs2.next()) {
		            // ���ÿ���ֶ�		
					int row1=  Integer. parseInt (rs2.getString("row"));
					int col1=  Integer. parseInt (rs2.getString("col"));	
					
					btnSeat[row1][col1].setBackground(Color.red);
					btnSeat[row1][col1].setLabel(row1+1+"-"+(col1+1));
					btnSeat[row1][col1].setEnabled(true);
					j1++;
					label6.setText("�������Ʊ��Ϊ��"+j1+" ��");
					label7.setText("֧���ܽ�"+j1*30.5+" Ԫ");
		        }		
				stmt2.close();
			}
		break;
		case 2: {
				Statement stmt2=cc.createStatement();//����һ��Statement����
				ResultSet rs2 = stmt2.executeQuery("SELECT * FROM seats2 where name = N'"+label2.getText()+"'");
				while (rs2.next()) {
		            // ���ÿ���ֶ�		
					int row1=  Integer. parseInt (rs2.getString("row"));
					int col1=  Integer. parseInt (rs2.getString("col"));	
					
					btnSeat[row1][col1].setBackground(Color.red);
					btnSeat[row1][col1].setLabel(row1+1+"-"+(col1+1));
					btnSeat[row1][col1].setEnabled(true);
					j1++;
					label6.setText("�������Ʊ��Ϊ��"+j1+" ��");
					label7.setText("֧���ܽ�"+j1*20.0+" Ԫ");
		        }		
				stmt2.close();
			}
		break;
		case 3: {
				Statement stmt2=cc.createStatement();//����һ��Statement����
				ResultSet rs2 = stmt2.executeQuery("SELECT * FROM seats3 where name = N'"+label2.getText()+"'");
				while (rs2.next()) {
		            // ���ÿ���ֶ�		
					int row1=  Integer. parseInt (rs2.getString("row"));
					int col1=  Integer. parseInt (rs2.getString("col"));	
					
					btnSeat[row1][col1].setBackground(Color.red);
					btnSeat[row1][col1].setLabel(row1+1+"-"+(col1+1));
					btnSeat[row1][col1].setEnabled(true);
					j1++;
					label6.setText("�������Ʊ��Ϊ��"+j1+" ��");
					label7.setText("֧���ܽ�"+j1*33.33+" Ԫ");
		        }		
				stmt2.close();
			}
		break;
		}	
				
		cc.close();	
	}

	public void close()	//�жϴ����Ƿ�ر�
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
							new Frame2("ѡ������",(1366-1000)/2, (768-700)/2, 1000, 700);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                     }
               }
         });
    }
	
	void init()  {
		Color c =new Color(100,200,200);	//������ɫ
		panel1.setBackground(c);	
		panel1.setLayout(null);		//���ÿղ���
		panel2.setBounds(200, 150, 780, 500);		
		panel2.setLayout(new GridLayout(7,9,20,30));	//ʹ�ø�ʽ���ֿ������
		panel2.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));	//���ñ�Ե�ľ���	
		
		//��ʾ��ǩ
		label1.setBounds(870, 20, 100, 20);
		label1.setText("�����˺�Ϊ��");	
		label1.setBackground(Color.orange);
		//����˺�
		label2.setBounds(870, 45, 100, 20);
		label2.setText("");		
		label2.setBackground(Color.white);
		//���ú���
		label3.setBounds(10, 80, 180, 255);
		label3.setBackground(Color.white);
		//����ǩ
		label4.setBounds(10, 350, 40, 40);
		label4.setText("���");
		label4.setFont(new Font("����", Font.PLAIN, 20));//���������С��ɫ
		label4.setBackground(c);
		//���۱�ǩ
		label5.setBounds(200, 20, 150, 30);
		label5.setText("��ʾ��ӰƱ����");
		label5.setFont(new Font("����", Font.PLAIN, 14));//���������С��ɫ
		label5.setBackground(Color.white);
		//Ʊ����ǩ
		label6.setBounds(200, 60, 150, 30);
		label6.setText("��ʾ�������Ʊ��");
		label6.setFont(new Font("����", Font.PLAIN, 14));//���������С��ɫ
		label6.setBackground(Color.WHITE);
		//�ܼ۱�ǩ
		label7.setBounds(200,100, 150, 30);
		label7.setText("��ʾ����Ҫ֧���ܽ��");
		label7.setFont(new Font("����", Font.PLAIN, 14));//���������С��ɫ
		label7.setBackground(Color.WHITE);
		//��������Ļ
		label8.setBounds(400, 20, 400,110);
		label8.setBackground(Color.WHITE);		
		
		//չʾ���
		text1.setBounds(10, 400, 180, 235);
		text.setLineWrap(true);	//�����Զ����й���
		text.setEditable(false);//���ɱ༭
		text.setWrapStyleWord(true);   // ������в����ֹ���	
		text.setBackground(Color.gray);
		text.setFont(new Font("����", Font.PLAIN, 14));	//���������С��ɫ
		text.setForeground(Color.pink);

		
        //Ĭ�ϵ������ǳ����ı���Ż���ʾ�����������������ù�����һֱ��ʾ
		text1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//ע����ť
		button1.setBounds(870, 80, 100, 50);
		button1.setLabel("ע���˺�");	
		button1.setBackground(Color.cyan);
		//���ص�Ӱ����
		button2.setBounds(10, 20, 180, 40);
		button2.setLabel("������һ��");	
		button2.setBackground(Color.cyan);						
		
		//ע����¼
		button1.addActionListener(new ActionListener(){	//�� ע����ť �����¼�������

			@Override
			public void actionPerformed(ActionEvent e) {
                int result=JOptionPane.showConfirmDialog(null, "��ȷ��Ҫע���˺���", "Information", JOptionPane.YES_NO_OPTION);
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
  					    Frame1 f1=new Frame1("��½����",(1366-1000)/2, (768-700)/2, 1000, 700);
  		            }
  					catch (SQLException e1) {
  						e1.printStackTrace();
  					    System.out.print(e1.getErrorCode());
  					    System.out.println("���ݿ����Ӵ���");
  					    System.exit(0);
  					}	
  		            dispose();
                }
                else {
		        	   JOptionPane.showMessageDialog(null, "����ȡ��ע����");
                }
				
			}
		});
		
		//���ص�Ӱ����
		button2.addActionListener(new ActionListener(){	//�� ע����ť �����¼�������

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
		                Statement stmt = conn.createStatement(); 
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
				dispose();
				try {
					Frame3 f3=new Frame3("ѡ��ӰƬ",(1366-1000)/2, (768-700)/2, 1000, 700);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//��ѭ��������λ��ť		
		for(int i=1;i<=7;i++) {	//��ѭ��������λ��ť
			for(int j=1;j<=9;j++) {
				int row =i-1;
				int col =j-1;
				btnSeat[row][col] = new Button();
				btnSeat[row][col].setLabel(i+"-"+j);
				btnSeat[row][col].setName(row+"-"+col);
				btnSeat[row][col].setBackground(Color.green);
				panel2.add(btnSeat[row][col]);
			}
		}
		//��ѭ��������λ��ť
		for(int i=1;i<=7;i++) {	
			for(int j=1;j<=9;j++) {				
				int row =i-1;
				int col =j-1;
				btnSeat[row][col].addActionListener(new ActionListener(){	//����ť�����¼�������
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						int choose = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�����λ��");
						
						//������λ
						if(choose == JOptionPane.YES_OPTION) {
	
							Color b=btnSeat[row][col].getBackground();	//b��ʼֵΪ��ɫ��ִ��һ�κ��Ϊ��ɫ
							
							btnSeat[row][col].setBackground(Color.red);
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
//������λ	                	
				                if(i1==1) {			           
					                stmt.executeUpdate("update dbo.seats1 set flag='"+1+"' where row='"+row+"' and col='"+col+"'"); 
					                stmt.executeUpdate("update dbo.seats1 set name=N'"+label2.getText()+"' where flag='1' and name =N'"+null+"'"); 				                
					                
					                if( b==Color.green) {
						                j1++;
						                label6.setText("�������Ʊ��Ϊ��"+j1+" ��");
						                label7.setText("֧���ܽ�"+j1*30.5+" Ԫ");
					                }
				                }
				                if(i1==2) {			                	
					                stmt.executeUpdate("update dbo.seats2 set flag='"+1+"' where row='"+row+"' and col='"+col+"'"); 
					                stmt.executeUpdate("update dbo.seats2 set name=N'"+label2.getText()+"' where flag='1' and name =N'"+null+"'"); 
					                if( b==Color.green) {
						                j1++;
						                label6.setText("�������Ʊ��Ϊ��"+j1+" ��");
						                label7.setText("֧���ܽ�"+j1*20.0+" Ԫ");
					                }
				                }
				                if(i1==3) {				                	
					                stmt.executeUpdate("update dbo.seats3 set flag='"+1+"' where row='"+row+"' and col='"+col+"'"); 
					                stmt.executeUpdate("update dbo.seats3 set name=N'"+label2.getText()+"' where flag='1'and name =N'"+null+"'");					               
					                if( b==Color.green) {
						                j1++;
						                label6.setText("�������Ʊ��Ϊ��"+j1+" ��");
						                label7.setText("֧���ܽ�"+j1*33.33+" Ԫ");
					                }
				                }
				                stmt.close();// �ر������������
							    conn.close();// �ر����ݿ�����
				            }
							catch (SQLException e1) {
								e1.printStackTrace();
							    System.out.print(e1.getErrorCode());
							    System.out.println("���ݿ����Ӵ���");
							    System.exit(0);
							}							
						}
						
						//�˻���λ
						if(choose == JOptionPane.NO_OPTION) {
							
							Color a=btnSeat[row][col].getBackground();	//a��ʼֵΪ��ɫ��ִ��һ�κ��Ϊ��ɫ

							btnSeat[row][col].setBackground(Color.green);
							
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
//�˻���λ	                	
				                if(i1==1) {
					                stmt.executeUpdate("update dbo.seats1 set flag='"+0+"' where row='"+row+"' and col='"+col+"'"); // ������治��where����������������е�value�ֶ�
					                stmt.executeUpdate("update dbo.seats1 set name=N'"+null+"' where flag='0' and name = N'"+label2.getText()+"'"); // ������治��where����������������е�value�ֶ�
					                if( a==Color.red) {
						                j1--;
						                label6.setText("�������Ʊ��Ϊ��"+j1+" ��");
						                label7.setText("֧���ܽ�"+j1*30.5+" Ԫ");
					                }
				                }
				                if(i1==2) {
					                stmt.executeUpdate("update dbo.seats2 set flag='"+0+"' where row='"+row+"' and col='"+col+"'"); // ������治��where����������������е�value�ֶ�
					                stmt.executeUpdate("update dbo.seats2 set name=N'"+null+"' where flag='0'and name = N'"+label2.getText()+"'"); // ������治��where����������������е�value�ֶ�
					                if( a==Color.red) {
						                j1--;
						                label6.setText("�������Ʊ��Ϊ��"+j1+" ��");
						                label7.setText("֧���ܽ�"+j1*20.0+" Ԫ");
					                }
				                }
				                if(i1==3) {
					                stmt.executeUpdate("update dbo.seats3 set flag='"+0+"' where row='"+row+"' and col='"+col+"'"); // ������治��where����������������е�value�ֶ�
					                stmt.executeUpdate("update dbo.seats3 set name=N'"+null+"' where flag='0'and name = N'"+label2.getText()+"'"); // ������治��where����������������е�value�ֶ�
					                if( a==Color.red) {
						                j1--;
						                label6.setText("�������Ʊ��Ϊ��"+j1+" ��");
						                label7.setText("֧���ܽ�"+j1*33.33+" Ԫ");
					                }
				                }
								stmt.close();// �ر������������
							    conn.close();// �ر����ݿ�����
				            }
							catch (SQLException e1) {
								e1.printStackTrace();
							    System.out.print(e1.getErrorCode());
							    System.out.println("���ݿ����Ӵ���");
							    System.exit(0);
							}													
							
						}
						
					}
					
				});
				
			}
		}

		panel1.add(text1);
		panel1.add(button2);
		panel1.add(button1);
		panel1.add(label8);
		panel1.add(label7);
		panel1.add(label6);
		panel1.add(label5);
		panel1.add(label4);
		panel1.add(label3);
		panel1.add(label2);
		panel1.add(label1);
		panel1.add(panel2);		
		add(panel1);	//�����嵽����
		
	}

}
