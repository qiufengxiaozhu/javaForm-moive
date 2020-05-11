package 电影院;

import java.sql.*;

public class SQL {
	
	
	public Connection getConnection() {	//��ʼ��users��
        Connection conn=null;
	
	try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    } 
    catch (ClassNotFoundException e) {
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
        // ����SQL�������

        // ������
        System.out.println("��ʼ������");
        String query1 = "drop table users";
        // ������SQL���
        String query = "create table users(ID NCHAR(10) PRIMARY KEY NOT NULL,passwd NCHAR(12),flag int )";

        stmt.executeUpdate(query1);// ִ��SQL�������
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
        stmt.executeUpdate("update dbo.users set passwd='12345678' where ID='168207101'"); // ������治��where����������������е�value�ֶ�
        System.out.println("�޸��������");
        rs = stmt.executeQuery("SELECT * FROM users");// ����SQL����ѯ�����(����)
        // ѭ�����ÿһ����¼
        while (rs.next()) {
            // ���ÿ���ֶ�
            System.out.println(rs.getString("ID") + "\t"
                    + rs.getString("passwd"));
        }
//        String sql = "delete from users where id='168207101'";
//        stmt.executeUpdate(sql);
//        System.out.println("ɾ���������");
//        rs = stmt.executeQuery("SELECT * FROM users");// ����SQL����ѯ�����(����)
//        // ѭ�����ÿһ����¼
//        while (rs.next()) {
//            // ���ÿ���ֶ�
//            System.out.println(rs.getString("ID") + "\t"
//                    + rs.getString("passwd"));
//        }

        // �ر�����
        stmt.close();// �ر������������
        conn.close();// �ر����ݿ�����
    } 
    catch (SQLException e) {
        e.printStackTrace();
        System.out.print(e.getErrorCode());
        System.out.println("���ݿ����Ӵ���");
        System.exit(0);
    }

    return conn; //����Ҫ�ǵ÷���һ�����Ӷ���
    }

	public Connection ticket() {	//��ʼ��seats��
		 Connection conn=null;
			
			try {
		        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    } 
		    catch (ClassNotFoundException e) {
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
		        System.out.println("ɾ��seats��ɹ���");
		        
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
		    catch (SQLException e) {
		        e.printStackTrace();
		        System.out.print(e.getErrorCode());
		        System.out.println("���ݿ����Ӵ���");
		        System.exit(0);
		    }

		    return conn; //����Ҫ�ǵ÷���һ�����Ӷ���		    
	}
	
	public Connection movie() {	//��ʼ�� movie ��
		 Connection conn=null;
			
			try {
		        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    } 
		    catch (ClassNotFoundException e) {
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
//		        System.out.println("ɾ��movie��ɹ���");
		        
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
		    catch (SQLException e) {
		        e.printStackTrace();
		        System.out.print(e.getErrorCode());
		        System.out.println("���ݿ����Ӵ���");
		        System.exit(0);
		    }

		    return conn; //����Ҫ�ǵ÷���һ�����Ӷ���	
		
	}
		
  	public  Connection data() {//�����������ݿ�
			
		String connectDB = "jdbc:sqlserver://localhost\\SQLEXPRESS:1434;DatabaseName=��ӰԺ���ݿ�";
        String user = "sa";
        String password = "123456";
        Connection con = null;
		try {
			con = DriverManager.getConnection(connectDB, user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}

