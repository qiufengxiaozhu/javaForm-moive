package 电影院;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Frame1 extends JFrame {

	 // JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/��ӰԺ���ݿ�";
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "123456";

	
	JPanel panel1 = new JPanel();	//���������
	JPanel panel2 = new JPanel();	//������ӭ���
	JPanel panel3 = new JPanel();	//��������Ա���
	
	JTextField text1 = new JTextField("�������û���(ֻ��Ϊ���֣�)...",15);	//�����ı���
	
	JPasswordField pass=new JPasswordField("����������...",15);////���������
	
	JLabel label1 = new JLabel("�˺ţ�"); //������ǩ
	JLabel label2 = new JLabel("���룺");	//������ǩ
	JLabel label3 = new JLabel("��ӭ������ӰԺѡ��ϵͳ");	//������ǩ
	
	//JLabel���֧��HTML��Ǵ���
	//�����ʾ���û���¼ϵͳ���������ӳ����ӣ�������ʵ��
	//JLabel label1= new JLabel("<html><a href='��ַ'>�û���½ϵͳ</a></html>", JLabel.CENTER);
	
	JButton button1 = new JButton("��¼");	//������ť
	JButton button2 = new JButton("ע��");	//������ť
	JButton button3 = new JButton("�����û���");	//������ť
	JButton button4 = new JButton("���õ�Ӱ��");	//������ť
	JButton button5 = new JButton("������λ��");	//������ť
	JButton button6 = new JButton("ע����¼");	//������ť
	
	public Frame1(String s, int i, int j, int k, int l)  {//���ô���һ������
		// TODO Auto-generated constructor stub
		init();	
		setTitle(s);
		setLocation(i,j);
		setSize(k,l);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);
	}
	
	
	void init() {	//��ʼ��	
		
		Color c =new Color(100,200,200);	//���������ɫ
		panel1.setBackground(c);
		panel3.setBackground(c);		
		panel2.setBackground(Color.BLUE);	//���������ɫ
		
		panel3.setBounds(0, 80, 1000, 620);
		panel3.setVisible(false);
		
		label3.setPreferredSize(new Dimension(400,80));	//�Զ���Dimension�Ĵ�С�ñ�ǩ��С���� 
		label3.setForeground(Color.cyan);
		label3.setFont(new Font("����", Font.PLAIN, 30));//���������С��ɫ
		
		//�����ʾ�����������������ʽ��������ƶ��������ϣ���������� 
		button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		label1.setForeground(Color.RED);
		label1.setFont(new Font("����", Font.PLAIN, 20));	//���������С��ɫ
		label2.setForeground(Color.RED);
		label2.setFont(new Font("����", Font.PLAIN, 20));	//���������С��ɫ
		
		text1.setBounds(500, 100, 200, 40);		//���ÿؼ���Сλ��
		pass.setBounds(500, 160, 200, 40);		//���ÿؼ���Сλ��
		label1.setBounds(300, 100, 100, 40);	//���ÿؼ���Сλ��
		label2.setBounds(300, 160, 100, 40);	//���ÿؼ���Сλ��
		button1.setBounds(300, 320, 100, 40);	//���ÿؼ���Сλ��
		button2.setBounds(550, 320, 100, 40);	//���ÿؼ���Сλ��
		button3.setBounds(300, 120, 100, 40);	//���ÿؼ���Сλ��
		button4.setBounds(550, 120, 100, 40);	//���ÿؼ���Сλ��
		button5.setBounds(300, 320, 100, 40);	//���ÿؼ���Сλ��
		button6.setBounds(550, 320, 100, 40);	//���ÿؼ���Сλ��		
		
		//�������� �˺� ������ֻ��Ϊ����
		text1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if(!(keyChar == 0x08) &&!(keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9)){ 
					e.consume();	//ȱ�㣬���ܿ��Ƹ�ֵ���������
					return;
					}
				}
			});
		
		//�������� ���� ������ֻ��Ϊ���ġ�Ӣ��
		pass.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if(!(keyChar == 0x08) && !(keyChar >= '0' && keyChar <= '9')&&!(keyChar >= 'A' && keyChar <= 'Z')&&!(keyChar >= 'a' && keyChar <= 'z')){
					JOptionPane.showMessageDialog(panel1, "�û���ֻ�������֡���ĸ������");
					
					e.consume();
					return;
					}
				}
			});
		
		//�� �����1���˺ţ� ��ӵ���¼�
		text1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				JTextField text = (JTextField) e.getSource();
				if(text.getText().equals("�������û���(ֻ��Ϊ���֣�)...")) {
					text.setText(null);
				}
			}
			
		});

		//�� �����2 �����룩��ӵ���¼�
		pass.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				JTextField text = (JTextField) e.getSource();
				if(text.getText().equals("����������...")) {
					text.setText(null);
				}
			}
			
		});	
		
		//�� ��ť1����¼�� ����¼�������		
		button1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){

					if(text1.getText().equals("") || text1.getText().trim().equals("")) {
		        	   JOptionPane.showMessageDialog(panel1, "�û��������벻��Ϊ�գ�");
		        	   return ;
					}
					else if(pass.getText().equals("") || pass.getText().trim().equals("")) {
		        	   JOptionPane.showMessageDialog(panel1, "�û��������벻��Ϊ�գ�");
		        	   return ;
					}
					else if(text1.getText().equals("�������û���...") && pass.getText().equals("����������...")) {
		        	   JOptionPane.showMessageDialog(panel1, "�������û��������룡");
		        	   return ;
					}	
					else {
				
						String userID = null;
						String passWord = null;
						userID = text1.getText().trim();
						passWord = pass.getText().trim();
						
						if(text1.getText().equals("1")&& pass.getText().equals("1")) {
							text1.setText("�������û���(ֻ��Ϊ���֣�)...");;
							pass.setText("����������...");;
													
							int result=JOptionPane.showConfirmDialog(null, "��ӭ����Ա��¼", "Information", JOptionPane.YES_NO_OPTION);
							if(result==JOptionPane.YES_OPTION) {
								panel1.setVisible(false);
								panel3.setVisible(true);	
							}

						}
						else {
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
				                ResultSet rs = stmt.executeQuery("SELECT ID,passwd FROM users where ID=N'"+userID+"'and passwd=N'"+passWord+"'  ");// ����SQL����ѯ�����(����)
								if(rs.next()) {
									JOptionPane.showMessageDialog(panel1, "��ӭ"+userID+"��¼");
									stmt.executeUpdate("update dbo.users set flag='1' where ID=N'"+userID+"'");
									//setVisible(false);	//��������Դ
									dispose();	//��������
									stmt.close();// �ر������������
								    conn.close();// �ر����ݿ�����
								    Frame3 f3=new Frame3("ѡ��ӰƬ",(1366-1000)/2, (768-700)/2, 1000, 700);
									f3.setVisible(true);	//��ѡ������								
								}	
								else {
									JOptionPane.showMessageDialog(panel1,"�˺Ż������������������룡");
									text1.setText(null);
									pass.setText(null);
								}
								
				            }
							catch (SQLException e1) {
								e1.printStackTrace();
							    System.out.print(e1.getErrorCode());
							    System.out.println("���ݿ����Ӵ���");
							    System.exit(0);
							}
						}
					}						
				}
		});
		
		//�� ��ť2��ע�ᣩ ����¼�������
		button2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){

					if(text1.getText().equals("") || text1.getText().trim().equals("")) {
		        	   JOptionPane.showMessageDialog(panel1, "�û��������벻��Ϊ�գ�");
		        	   return ;
					}
					else if(pass.getText().equals("") || pass.getText().trim().equals("")) {
		        	   JOptionPane.showMessageDialog(panel1, "�û��������벻��Ϊ�գ�");
		        	   return ;
					}
					else if(text1.getText().equals("�������û���(ֻ��Ϊ���֣�)...") && pass.getText().equals("����������...")) {
		        	   JOptionPane.showMessageDialog(panel1, "�������û��������룡");
		        	   return ;
					}	
					else {
					
						String userID = null;
			            String passWord = null;
			            userID = text1.getText().trim();
			            passWord = pass.getText().trim();
			            
			            
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
			                System.out.println("�������ݿ�ɹ�");
			                Statement stmt = conn.createStatement();
			                // ����SQL�������	
			                
			        		System.out.println("��ʼע��");	
			        		ResultSet rs = stmt.executeQuery("SELECT ID FROM users where ID=N'"+userID+"' ");// ����SQL����ѯ�����(����)
			        		    if(rs.next()) {
			        		    	JOptionPane.showMessageDialog(panel1, "�Ѵ���IDΪ"+userID+"���˺ţ�");
			        		    	//break;
			        		    	}
			        		    else {
			        		    	String a1 = "INSERT INTO users VALUES(N'"+userID+"',N'"+passWord+"','"+0+"')";	
			        		    	stmt.executeUpdate(a1);//ִ��sql���
			        		    	JOptionPane.showMessageDialog(panel1, "��ϲ"+userID+"ע��ɹ�");
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
		
		//�����û���
		button3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				
				int result=JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�����û�����", "Information", JOptionPane.YES_NO_OPTION);
                if(result==JOptionPane.YES_OPTION) {
            	
                	Connection conn = null;
                    try{
                        // ע�� JDBC ����
                        try {
							Class.forName("com.mysql.jdbc.Driver");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                    
                        // ������
                        System.out.println("�������ݿ�...");
                        conn = DriverManager.getConnection(DB_URL,USER,PASS);
                    
                        // ִ�в�ѯ
                        System.out.println(" ʵ����Statement����...");

                        System.out.println("�������ݿ�ɹ�");
                        Statement stmt = conn.createStatement();
                        // ����SQL�������

                        // ������
                        System.out.println("��ʼ������1");
                        String query1 = "drop table users";
                        stmt.executeUpdate(query1);// ִ��SQL�������
                        System.out.println("��ʼ������2");
                        // ������SQL���
                        String query = "create table users(ID NCHAR(10) PRIMARY KEY NOT NULL,passwd NCHAR(12),flag int )";
                        System.out.println("��ʼ������3");
                        
                        System.out.println("��ʼ������4");
                        stmt.executeUpdate(query);// ִ��SQL�������
                        System.out.println("�����ɹ�");

                        // ��������
                        System.out.println("��ʼ��������");
                        String a1 = "INSERT INTO users VALUES('168207101','123456','0')";
                        // ��������SQL���
                        String a2 = "INSERT INTO users VALUES('168207102','234567','0')";
                        String a3 = "INSERT INTO users VALUES('168207130','345678','0')";
                        String a4 = "INSERT INTO users VALUES('123','123','0')";
                        stmt.executeUpdate(a1);// ִ��SQL�������
                        stmt.executeUpdate(a2);
                        stmt.executeUpdate(a3);
                        stmt.executeUpdate(a4);
                        System.out.println("�������ݳɹ�");

                        // ��ȡ����
                        System.out.println("��ʼ��ȡ����");
                        ResultSet rs = stmt.executeQuery("SELECT * FROM users");// ����SQL����ѯ�����(����)
                        // ѭ�����ÿһ����¼
                        while (rs.next()) {
                            // ���ÿ���ֶ�
                            System.out.println(rs.getString("ID") + "\t"
                                    + rs.getString("passwd"));
                        }
                        System.out.println("��ȡ���");
                        stmt.executeUpdate("update users set passwd='12345678' where ID='168207101'"); // ������治��where����������������е�value�ֶ�
                        System.out.println("�޸��������");
                        rs = stmt.executeQuery("SELECT * FROM users");// ����SQL����ѯ�����(����)
                        // ѭ�����ÿһ����¼
                        while (rs.next()) {
                            // ���ÿ���ֶ�
                            System.out.println(rs.getString("ID") + "\t"
                                    + rs.getString("passwd"));
                        }
//                        String sql = "delete from users where id='168207101'";
//                        stmt.executeUpdate(sql);
//                        System.out.println("ɾ���������");
//                        rs = stmt.executeQuery("SELECT * FROM users");// ����SQL����ѯ�����(����)
//                        // ѭ�����ÿһ����¼
//                        while (rs.next()) {
//                            // ���ÿ���ֶ�
//                            System.out.println(rs.getString("ID") + "\t"
//                                    + rs.getString("passwd"));
//                        }

                        // �ر�����
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
		
		//���õ�Ӱ��
		button4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				int result=JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ���õ�Ӱ����", "Information", JOptionPane.YES_NO_OPTION);
                if(result==JOptionPane.YES_OPTION) {
                	Connection conn=null;
        			
        			try {
        		        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        		    } 
        		    catch (ClassNotFoundException e1) {
        		        System.err.println("δ�ҵ�����");
        		    }
        		    System.out.println("���ݿ������ɹ�");

        		    try {
        		        String connectDB = "jdbc:sqlserver://localhost\\SQLEXPRESS:1434;DatabaseName=��ӰԺ���ݿ�";
        		        String user = "sa";
        		        // ����ֻҪע���û������벻Ҫд����
        		        String password = "123456";
        		        conn = DriverManager.getConnection(connectDB, user,password);
        		        // �������ݿ����
        		        System.out.println("�������ݿ�ɹ�");
        		        Statement stmt = conn.createStatement();
        		        
        		        String query1 = "drop table movie";
        		        stmt.executeUpdate(query1);// ִ��SQL�������
//        		        System.out.println("ɾ��movie��ɹ���");
        		        
        		        String query = "create table movie (ID int PRIMARY KEY NOT NULL,name nchar(20),price numeric(5,2) ,jianjie nchar(1000),flag int)";
        		        stmt.executeUpdate(query);// ִ��SQL�������
        		        System.out.println("����movie��ɹ���");   
        		        // ����SQL�������
        		        String a1 = "INSERT INTO movie VALUES('1','���㺣��','30.5','    ���������������Ĵ������ĺ������"
        		        		+ "�������ƹ������������������й��ɵġ������ˡ�����ס�ڡ���֮Χ¥�����Ů����������ʮ���������������һ������"
        		        		+ "���˼�Ѳ�񣬱����е�һ������ס��һ�������к���Ϊ�������������ȥ��Ϊ�˱���������Ҫ���Լ���������"
        		        		+ "�����к�����ꡪ��һ��Ĵָ��ô���С�㣬�ɳ�Ϊ�Ⱦ����޴���㲢�ع�󺣡����������������谭���к���������"
        		        		+ "�������������һ����ȴ���ϵ�Υ�����񡱵�������ɶ�������������... ','0')";
        		        String a2 = "INSERT INTO movie VALUES('2','֩��������3','25','    ��Ӣ����ս������ս��Ļ�󣬱˵á�����"
        		        		+ "����ķ���������Σ��ڶ�ʦ���ᡤ˹���ˣ�С�޲��ء������Σ���Э���£���ͼ��һ����ͨ�������ʹ�������"
        		        		+ "����Ӣ��֩�����䱣��ƽ�⣬������ͺ�գ����˶��������Σ������������������µ���в����������Ϊ֩�����ĵ�ʦ"
        		        		+ "�ٴγ��֣���Ϊ������̤��Ӣ��֮·�Ĺؼ����ȷ������δ�����ʸ��Ϊ���������˵�һ����','0')";
        		        String a3 = "INSERT INTO movie VALUES('3','��ʥ����','33.33','    �����칬���İ�����꣬�����ʥ����һ����˵��"
        		        		+ "��ɽ�����еĳ����ǣ��¶����������н�ɮ��������Ϊ����СС���곣�����������칬������ա� ��һ�죬ɽ��������"
        		        		+ "ͯ��ͯŮ������������һ��СŮ�����ǵ�ɽ��׷ɱ����һ·���ܣ��ܽ�������ɽ��ä����ײ�ؽ��������յķ�ӡ��"
        		        		+ "�������֮��ֻ��ػ���ɽ��ȴ�������Ϸ�ӡδ�⣬��Ƿ���������飬��ǿ�ػ������س�����...','0')";
        		        stmt.executeUpdate(a1);// ִ��SQL�������
        		        stmt.executeUpdate(a2);
        		        stmt.executeUpdate(a3);
        		        
        		     // �ر�����
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
		
		//������λ��
		button5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				int result=JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ������λ����", "Information", JOptionPane.YES_NO_OPTION);
                if(result==JOptionPane.YES_OPTION) {
                	Connection conn=null;
        			
        			try {
        		        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        		    } 
        		    catch (ClassNotFoundException e1) {
        		        System.err.println("δ�ҵ�����");
        		    }
        		    System.out.println("���ݿ������ɹ�");

        		    try {
        		        String connectDB = "jdbc:sqlserver://localhost\\SQLEXPRESS:1434;DatabaseName=��ӰԺ���ݿ�";
        		        String user = "sa";
        		        // ����ֻҪע���û������벻Ҫд����
        		        String password = "123456";
        		        conn = DriverManager.getConnection(connectDB, user,password);
        		        // �������ݿ����
        		        System.out.println("�������ݿ�ɹ�");
        		        Statement stmt = conn.createStatement();
        		        
        		        String querya = "drop table seats1";
        		        stmt.executeUpdate(querya);// ִ��SQL�������
        		        String queryb = "drop table seats2";
        		        stmt.executeUpdate(queryb);// ִ��SQL�������
        		        String queryc = "drop table seats3";
        		        stmt.executeUpdate(queryc);// ִ��SQL�������
        		        //System.out.println("ɾ��seats��ɹ���");
        		        
        		        String query1 = "create table seats1 (row int NOT NULL,col int NOT NULL ,PRIMARY KEY (row,col),price float NOT NULL,flag int NOT NULL,name nchar(10))";
        		        String query2 = "create table seats2 (row int NOT NULL,col int NOT NULL ,PRIMARY KEY (row,col),price float NOT NULL,flag int NOT NULL,name nchar(10))";
        		        String query3 = "create table seats3 (row int NOT NULL,col int NOT NULL ,PRIMARY KEY (row,col),price float NOT NULL,flag int NOT NULL,name nchar(10))";

        		        stmt.executeUpdate(query1);// ִ��SQL�������
        		        stmt.executeUpdate(query2);// ִ��SQL�������
        		        stmt.executeUpdate(query3);// ִ��SQL�������
        		        System.out.println("����seats��ɹ���");
        		        
        		        // ����SQL�������
        		        for(int i=0;i<7;i++) {
        		        	for(int j=0;j<9;j++) {
        		        		int row=i;
        		        		int col=j;
        		        		String a1 = "INSERT INTO seats1 (row,col,price,flag,name) VALUES('"+row+"','"+col+"','"+30+"','"+0+"','"+null+"') ";
        		        		String a2 = "INSERT INTO seats2 (row,col,price,flag,name) VALUES('"+row+"','"+col+"','"+30+"','"+0+"','"+null+"') ";
        		        		String a3 = "INSERT INTO seats3 (row,col,price,flag,name) VALUES('"+row+"','"+col+"','"+30+"','"+0+"','"+null+"') ";

        		        		stmt.executeUpdate(a1);// ִ��SQL�������
        		        		stmt.executeUpdate(a2);// ִ��SQL�������
        		        		stmt.executeUpdate(a3);// ִ��SQL�������
        		        	}
        		        }
          
        		     // �ر�����
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
		
		//ע����¼
		button6.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				panel1.setVisible(true);
				panel3.setVisible(false);
			}
		});
		
		panel3.add(button3);	//��Ӱ�ť�����	
		panel3.add(button4);	//��Ӱ�ť�����	
		panel3.add(button5);	//��Ӱ�ť�����	
		panel3.add(button6);	//��Ӱ�ť�����	
		panel1.add(text1);		//����ı������
		panel1.add(pass);		//����ı������
		panel1.add(label1);		//��ӱ�ǩ�����
		panel1.add(label2);		//��ӱ�ǩ�����
		panel2.add(label3);		//��ӱ�ǩ�����
		panel1.add(button1);	//��Ӱ�ť�����	
		panel1.add(button2);	//��Ӱ�ť�����	
		panel3.setLayout(null);	//�ղ���
		add(panel3);	//�����嵽����
		add(panel2,BorderLayout.NORTH);	//�����嵽����,�Ա߽籱����
		panel1.setLayout(null);	//�ղ���
		add(panel1);	//�����嵽����
	
	}	

}
