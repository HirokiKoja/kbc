/*制作者：古謝景貴
 *制作日：１２月１０日
 * 社員システム本体
 */

import javax.swing.*;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpSystem extends JFrame implements ActionListener {

	JPanel mainPanel;
	CardLayout layout;
	
	/*oracle*/
	static Connection conn = null;
	int flag = 0;
	int sqlEmpId = 0 ,sqlDeptId =0,sqlSal =0, sqlPass = 0, sqldeptId =0;
	String sqlEmpName = null, sqlDeptName = null ;
	int getEmpId = 0,getDeptId =0,getSal =0,getPass = 0;
	String getEmpName = null, getDeptName = null;
	static int count;
	
	/*login*/
	JTextField empIdText = new JTextField(); 
	JButton loginButton = new JButton("ログイン"); 
	
	JPasswordField empPassText = new JPasswordField(20);
	char[] password = empPassText.getPassword();
	String pass = new String(password);
	
	/*delete*/
	JTextField deleteEmpIdText;
	JTextField deleteEmpNameText;
	JTextField deleteDeptNameText;
	
	/*add*/
	JTextField addEmpIdText;
	JTextField addEmpNameText;
	JTextField addDeptNameText;
	JTextField addSalText;
	JTextField addEmpPassText;
	
	
	public static void main(String[] args) {
		EmpSystem frame = new EmpSystem();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 150, 640, 480);
		frame.setTitle("検索なう");
		frame.setVisible(true);
		frame.setResizable(false);
	}

	EmpSystem() {
		/* login画面 */
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);

		JLabel loginTitleLabel = new JLabel("ログイン");
		JLabel loginEmpIdLabel = new JLabel("社員ID");
		JLabel loginPassLabel = new JLabel("パスワード");


		loginPanel.add(loginTitleLabel);
		loginPanel.add(loginEmpIdLabel);
		loginPanel.add(loginPassLabel);
		loginPanel.add(empIdText);
		loginPanel.add(empPassText);
		loginPanel.add(loginButton);

		loginTitleLabel.setBounds(300, 25, 160, 50); 
		loginEmpIdLabel.setBounds(100, 125, 100, 30); 
		loginPassLabel.setBounds(100, 175, 100, 30); 
		empIdText.setBounds(300, 125, 200, 30); 
		empPassText.setBounds(300, 175, 200, 30); 
		loginButton.setBounds(300, 300, 200, 50); 
		
		loginButton.addActionListener(this);
		loginButton.setActionCommand("top");
		
		/* TOP画面 */
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);

		JLabel topTitle = new JLabel("TOP");
		JButton empSearch = new JButton("社員検索");
		JButton empAdd = new JButton("社員追加");
		JButton empDelete = new JButton("社員削除");

		topPanel.add(topTitle);
		topPanel.add(empSearch);
		topPanel.add(empAdd);
		topPanel.add(empDelete);

		topTitle.setBounds(280, 10, 200, 100);
		empSearch.setBounds(50, 100, 300, 50);
		empAdd.setBounds(50, 200, 300, 50);
		empDelete.setBounds(50, 300, 300, 50);

		empSearch.addActionListener(this);
		empSearch.setActionCommand("search");
		empAdd.addActionListener(this);
		empAdd.setActionCommand("add");
		empDelete.addActionListener(this);
		empDelete.setActionCommand("delete");

		/* 検索 */
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(null);

		JLabel searchTitle = new JLabel("検索");
		JLabel searchEmpNo = new JLabel("社員ID");
		JLabel searchEmpName = new JLabel("社員名");
		JLabel searchDeptName = new JLabel("部署");
		JTextField searchEmpNoText = new JTextField();
		JTextField searchEmpNameText = new JTextField();
		JTextField searchDeptNameText = new JTextField();
		JButton searchButton = new JButton("検索");
		JButton searchTopButton = new JButton("TOP");

		searchPanel.add(searchTitle);
		searchPanel.add(searchEmpNo);
		searchPanel.add(searchEmpName);
		searchPanel.add(searchDeptName);
		searchPanel.add(searchEmpNoText);
		searchPanel.add(searchEmpNameText);
		searchPanel.add(searchDeptNameText);
		searchPanel.add(searchButton);
		searchPanel.add(searchTopButton);

		searchTitle.setBounds(50, 20, 80, 40);
		searchEmpNo.setBounds(100, 100, 100, 40);
		searchEmpName.setBounds(100, 150, 100, 40);
		searchDeptName.setBounds(100, 200, 100, 40);
		searchEmpNoText.setBounds(160, 110, 200, 20);
		searchEmpNameText.setBounds(160, 160, 200, 20);
		searchDeptNameText.setBounds(160, 210, 200, 20);
		searchButton.setBounds(300, 300, 80, 40);
		searchTopButton.setBounds(530, 400, 60, 30);

		searchButton.addActionListener(this);
		searchButton.setActionCommand("searchDisplay");
		searchTopButton.addActionListener(this);
		searchTopButton.setActionCommand("top");
		
		/*検索結果表示画面*/
		JPanel searchActionPanel = new JPanel();
		searchActionPanel.setLayout(null);
		
		JButton searchReturnButton = new JButton();

		/* 追加 */
		JPanel addPanel = new JPanel();
		addPanel.setLayout(null);

		JLabel addTitle = new JLabel("追加");
		JLabel addEmpPass = new JLabel("パスワード");
		JLabel addEmpNo = new JLabel("社員ID");
		JLabel addEmpName = new JLabel("社員名");
		JLabel addDeptName = new JLabel("部署");
		JLabel addSalLabel = new JLabel("給料");
		addEmpIdText = new JTextField();
		addEmpNameText = new JTextField();
		addDeptNameText = new JTextField();
		addSalText = new JTextField();
		addEmpPassText = new JTextField();
		JButton addButton = new JButton("追加");
		JButton addTopButton = new JButton("TOP");

		addPanel.add(addTitle);
		addPanel.add(addEmpNo);
		addPanel.add(addEmpName);
		addPanel.add(addDeptName);
		addPanel.add(addEmpPass);
		addPanel.add(addSalLabel);
		addPanel.add(addEmpIdText);
		addPanel.add(addEmpNameText);
		addPanel.add(addDeptNameText);
		addPanel.add(addSalText);
		addPanel.add(addEmpPassText);
		addPanel.add(addButton);
		addPanel.add(addTopButton);

		addTitle.setBounds(10, 5, 80, 45);
		addEmpNo.setBounds(100, 100, 100, 50);
		addEmpName.setBounds(100, 100, 120, 150);
		addDeptName.setBounds(100, 100, 140, 250);
		addSalLabel.setBounds(100, 100, 160, 350);
		addEmpPass.setBounds(100, 100, 180, 450);
		addEmpIdText.setBounds(200, 110, 200, 30);
		addEmpNameText.setBounds(200, 160, 200, 30);
		addDeptNameText.setBounds(200, 210, 200, 30);
		addSalText.setBounds(200, 260, 200, 30);
		addEmpPassText.setBounds(200, 310, 200, 30);
		addButton.setBounds(220, 370, 150, 50);
		addTopButton.setBounds(450, 370, 150, 50);

		addTopButton.addActionListener(this);
		addTopButton.setActionCommand("top");
		addButton.addActionListener(this);
		addButton.setActionCommand("addAction");

		/* 削除 */
		JPanel deletePanel = new JPanel();
		deletePanel.setLayout(null);

		JLabel deleteTitle = new JLabel("削除");
		JLabel deleteEmpNo = new JLabel("社員ID");
		JLabel deleteEmpName = new JLabel("社員名");
		JLabel deleteDeptName = new JLabel("部署");
		deleteEmpIdText = new JTextField();
		deleteEmpNameText = new JTextField();
		deleteDeptNameText = new JTextField();
		Button deleteButton = new Button("削除");
		JButton deleteTopButton = new JButton("TOP");

		deleteTitle.setBounds(60, 40, 80, 30);
		deleteEmpNo.setBounds(100, 100, 80, 30);
		deleteEmpName.setBounds(100, 150, 80, 30);
		deleteDeptName.setBounds(100, 200, 80, 30);
		deleteEmpIdText.setBounds(250, 100, 200, 25);
		deleteEmpNameText.setBounds(250, 150, 200, 25);
		deleteDeptNameText.setBounds(250, 200, 200, 25);
		deleteButton.setBounds(300, 300, 80, 30);
		deleteTopButton.setBounds(450, 370, 150, 50);

		deletePanel.add(deleteTitle);
		deletePanel.add(deleteEmpNo);
		deletePanel.add(deleteEmpName);
		deletePanel.add(deleteDeptName);
		deletePanel.add(deleteEmpIdText);
		deletePanel.add(deleteEmpNameText);
		deletePanel.add(deleteDeptNameText);
		deletePanel.add(deleteButton);
		deletePanel.add(deleteTopButton);

		deleteButton.addActionListener(this);
		deleteButton.setActionCommand("deleteAction");
		deleteTopButton.addActionListener(this);
		deleteTopButton.setActionCommand("top");
		
		mainPanel = new JPanel();
		layout = new CardLayout();
		mainPanel.setLayout(layout);

		mainPanel.add(loginPanel, "login");
		mainPanel.add(topPanel, "top");
		mainPanel.add(searchPanel, "search");
		mainPanel.add(addPanel, "add");
		mainPanel.add(deletePanel, "delete");
		mainPanel.add(searchActionPanel, "searchAction");

		getContentPane().add(mainPanel, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
	if(command.equals("search") || command.equals("add") || command.equals("delete")){
		layout.show(mainPanel, command);
		
	}else if(command.equals("top")){//ログイン処理
			if(flag == 0){
				getEmpId = Integer.parseInt(empIdText.getText());
				getPass = Integer.parseInt(empPassText.getText());
				try{
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myorcl","scott","tiger");
					conn.setAutoCommit(true);
					Statement stmt = conn.createStatement();
					ResultSet loginRs = stmt.executeQuery("select * from java_emp where EMPID =　 "+ getEmpId +" and PASSWORD = "+ getPass +" and FLAG =0 " );
					while(loginRs.next()){
						sqlEmpId = loginRs.getInt("EMPID");
						sqlPass = loginRs.getInt("PASSWORD");
					}
					conn.close();
				}catch (SQLException e1){
					System.out.println("SQLException:" + e1.getMessage());
				}
				if(getEmpId == sqlEmpId && getPass == sqlPass){
					System.out.print("成功");//判定テスト
					flag ++;
					layout.show(mainPanel, command);
				}
			}if(flag == 1){
				layout.show(mainPanel, command);
			}
		}else if(command.equals("searchAction")){//検索処理（カドさんが作る場所）
		////////////////////////////////////////////////////////////////	
		}else if(command.equals("addAction")){//追加処理
			System.out.print("tuika");
			getEmpId = Integer.parseInt(addEmpIdText.getText());
			getEmpName = addEmpNameText.getText();
			getDeptName = addDeptNameText.getText();
			getSal = Integer.parseInt(addSalText.getText());
			getPass = Integer.parseInt(addEmpPassText.getText());
			try{
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myorcl","scott","tiger");
				conn.setAutoCommit(false);
				Statement stmt = conn.createStatement();
				ResultSet deptRs = stmt.executeQuery("select * from java_dept where deptname =　 '"+getDeptName+"'" );
				while(deptRs.next()){
					sqlDeptId = deptRs.getInt("DEPTID");
				}
				int addRs = stmt.executeUpdate("insert into java_emp(empid,empname,deptid,deptname,sal,password,flag)"
						+ "values("+getEmpId+",'"+getEmpName+"',"+sqlDeptId+",'"+getDeptName+"',"+getSal+","+getPass+",0)");
				int option = JOptionPane.showConfirmDialog(this, addRs+"件追加しますか？",
					      "追加確認", JOptionPane.YES_NO_OPTION, 
					      JOptionPane.WARNING_MESSAGE);
				count = addRs;
				    if (option == JOptionPane.YES_OPTION){
				    	conn.commit();
				    	JOptionPane.showMessageDialog(this, addRs+"件追加。");
				      }else if (option == JOptionPane.NO_OPTION){
				    	conn.rollback();
				      }
				    conn.close();
			}catch (SQLException e1){
				System.out.println("SQLException:" + e1.getMessage());
			}
		}else if(command.equals("deleteAction")){//削除処理
			getEmpId = Integer.parseInt(deleteEmpIdText.getText());
			getEmpName = deleteEmpNameText.getText();
			getDeptName = deleteDeptNameText.getText();
			try{
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myorcl","scott","tiger");
				conn.setAutoCommit(false);
				Statement stmt = conn.createStatement();
				int deleteRs = stmt.executeUpdate("update java_emp set FLAG = 1 where EMPID = "
					+ getEmpId +" and EMPNAME = '"+ getEmpName +"' and DEPTNAME　= '" + getDeptName +"' and FLAG = 0" );
				int option = JOptionPane.showConfirmDialog(this, "削除しますか？",
					      "削除確認", JOptionPane.YES_NO_OPTION, 
					      JOptionPane.WARNING_MESSAGE);
				count = deleteRs;
				    if (option == JOptionPane.YES_OPTION){
				    	conn.commit();
				    	JOptionPane.showMessageDialog(this, deleteRs+"件削除しました。");
				    	System.out.print(deleteRs);
				      }else if (option == JOptionPane.NO_OPTION){
				    	conn.rollback();
				      }
				    conn.close();
			}catch (SQLException e1){
				System.out.println("SQLException:" + e1.getMessage());
			}
		}
	}
}