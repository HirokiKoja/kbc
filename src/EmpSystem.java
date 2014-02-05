<<<<<<< HEAD
/*制作者：古謝景貴
 *制作日：１２月１０日
 * 社員システム本体
 */
=======
/*髯具ｽｻ�ｽ�ｶ髣厄ｽｴ隲幢ｿｽ�ｿ�ｽ�ｽ�ｽ陞｢�ｼ陜�ｿｽ蝙郁ｭ趣ｿｽ閭ｸ鬮ｮ蜈ｷ�ｽ�ｴ
 *髯具ｽｻ�ｽ�ｶ髣厄ｽｴ隲帑ｺ･�ｾ蜈ｷ�ｿ�ｽ陞滂ｽｲ�ｽ�ｼ隰�∞�ｽ�ｼ陷ｻ蝓滂ｿｽ�ｽ�ｽ隰�∞�ｽ�ｼ陷井ｺ･�ｾ�ｽ
 * 
 * 鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡驛｢�ｧ�ｽ�ｷ驛｢�ｧ�ｽ�ｹ驛｢譎｢�ｿ�ｽ�主ｮ夲ｽｭ蟷｢�ｽ�ｬ髣厄ｽｴ�ｽ�ｽ */

//update aki0018
//update Serina
//update Kadofuji
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf

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
<<<<<<< HEAD
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
=======
	int getIdAccess = 0 ,getDeptIdAccess =0,getSalAccess =0, getPassAccess = 0;
	String getEmpNameAccess = null, getDeptNameAccess = null;
	int getId = 0,getDeptId =0,getSal =0,getPass = 0;
	String getEmpName = null, getDeptName = null;
	static int count;
	
	/*驛｢譎｢�ｽ�ｭ驛｢�ｧ�ｽ�ｰ驛｢�ｧ�ｽ�､驛｢譎｢�ｽ�ｳ驛｢譎｢�ｿ�ｽ邵ｺ蜀暦ｽｹ�ｧ�ｽ�ｹ驛｢譎｢�ｿ�ｽ/
	JTextField idText = new JTextField(); 
//	JTextField passText = new JTextField();
	JButton loginButton = new JButton("驛｢譎｢�ｽ�ｭ驛｢�ｧ�ｽ�ｰ驛｢�ｧ�ｽ�､驛｢譎｢�ｽ�ｳ"); 
	
	JPasswordField passText = new JPasswordField(20);
	char[] password = passText.getPassword();
	String pass = new String(password);
	
	/*髯ｷ蜿ｰ�ｼ竏晄ｱるΔ譎｢�ｿ�ｽ邵ｺ蜀暦ｽｹ�ｧ�ｽ�ｹ驛｢譎｢�ｿ�ｽ/
	JTextField deleteEmpIdText =new JTextField();
	JTextField deleteEmpNameText = new JTextField();
	JTextField deleteDeptNameText = new JTextField();
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
	
	
	public static void main(String[] args) {
		EmpSystem frame = new EmpSystem();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 150, 640, 480);
<<<<<<< HEAD
		frame.setTitle("検索なう");
=======
		frame.setTitle("髫ｶ�ｽ繽搾ｿｽ�ｴ�ｽ�｢驍ｵ�ｺ�ｽ�ｪ驍ｵ�ｺ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｴ髫ｨ�ｳ隰夲ｽｫ�ｽ�ｽ驛｢�ｧ隴擾ｽｶ雎ｼ�ｫ驕ｯ�ｶ�ｽ�ｽ");
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
		frame.setVisible(true);
		frame.setResizable(false);
	}

	EmpSystem() {
<<<<<<< HEAD
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
=======
		/* login鬨ｾ蛹�ｽｽ�ｻ鬯ｮ�ｱ�ｽ�｢ */
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);

		JLabel loginTitle = new JLabel("驛｢譎｢�ｽ�ｭ驛｢�ｧ�ｽ�ｰ驛｢�ｧ�ｽ�､驛｢譎｢�ｽ�ｳ");
		JLabel loginId = new JLabel("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡ID");
		JLabel loginPass = new JLabel("驛｢譏懶ｽｻ�｣邵ｺ蟶ｷ�ｹ譎｢�ｽ�ｯ驛｢譎｢�ｽ�ｼ驛｢譎｢�ｿ�ｽ);
	//	JTextField idText = new JTextField(8); 
	//	JTextField passText = new JTextField(8); 
	//	JButton loginButton = new JButton("驛｢譎｢�ｽ�ｭ驛｢�ｧ�ｽ�ｰ驛｢�ｧ�ｽ�､驛｢譎｢�ｽ�ｳ"); 

		loginPanel.add(loginTitle);
		loginPanel.add(loginId);
		loginPanel.add(loginPass);
		loginPanel.add(idText);
		loginPanel.add(passText);
		loginPanel.add(loginButton);

		loginTitle.setBounds(300, 25, 160, 50); 
		loginId.setBounds(100, 125, 100, 30); 
		loginPass.setBounds(100, 175, 100, 30); 
		idText.setBounds(300, 125, 200, 30); 
		passText.setBounds(300, 175, 200, 30); 
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
		loginButton.setBounds(300, 300, 200, 50); 
		
		loginButton.addActionListener(this);
		loginButton.setActionCommand("top");
		
<<<<<<< HEAD
		/* TOP画面 */
=======
		/* TOP鬨ｾ蛹�ｽｽ�ｻ鬯ｮ�ｱ�ｽ�｢ */
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);

		JLabel topTitle = new JLabel("TOP");
<<<<<<< HEAD
		JButton empSearch = new JButton("社員検索");
		JButton empAdd = new JButton("社員追加");
		JButton empDelete = new JButton("社員削除");
=======
		JButton empSearch = new JButton("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡髫ｶ�ｽ繽搾ｿｽ�ｴ�ｽ�｢");
		JButton empAdd = new JButton("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡鬮ｴ謇假ｽｽ�ｽ髯ｷ莨夲ｽｿ�ｽ);
		JButton empDelete = new JButton("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡髯ｷ蜿ｰ�ｼ竏晄ｱ�);
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf

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

<<<<<<< HEAD
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
=======
		/* 髫ｶ�ｽ繽搾ｿｽ�ｴ�ｽ�｢ */
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(null);

		JLabel searchTitle = new JLabel("髫ｶ�ｽ繽搾ｿｽ�ｴ�ｽ�｢");
		JLabel searchEmpNo = new JLabel("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡ID");
		JLabel searchEmpName = new JLabel("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡髯ｷ�ｷ�ｽ�ｽ);
		JLabel searchDeptName = new JLabel("鬯ｩ蟷｢�ｽ�ｨ鬩励ｑ�ｽ�ｲ");
		JTextField searchEmpNoText = new JTextField();
		JTextField searchEmpNameText = new JTextField();
		JTextField searchDeptNameText = new JTextField();
		JButton searchButton = new JButton("髫ｶ�ｽ繽搾ｿｽ�ｴ�ｽ�｢");
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
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
		
<<<<<<< HEAD
		/*検索結果表示画面*/
=======
		/*髫ｶ�ｽ繽搾ｿｽ�ｴ�ｽ�｢鬩搾ｽｨ陷亥沺�｣�｡鬮ｯ�ｦ�ｽ�ｨ鬩穂ｼ夲ｽｽ�ｺ鬨ｾ蛹�ｽｽ�ｻ鬯ｮ�ｱ�ｽ�｢*/
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
		JPanel searchActionPanel = new JPanel();
		searchActionPanel.setLayout(null);
		
		JButton searchReturnButton = new JButton();

<<<<<<< HEAD
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
=======
		/* 鬮ｴ謇假ｽｽ�ｽ髯ｷ莨夲ｽｿ�ｽ*/
		JPanel addPanel = new JPanel();
		addPanel.setLayout(null);

		JLabel addTitle = new JLabel("鬮ｴ謇假ｽｽ�ｽ髯ｷ莨夲ｽｿ�ｽ);
		JLabel addEmpPass = new JLabel("驛｢譏懶ｽｻ�｣邵ｺ蟶ｷ�ｹ譎｢�ｽ�ｯ驛｢譎｢�ｽ�ｼ驛｢譎｢�ｿ�ｽ);
		JLabel addEmpNo = new JLabel("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡ID");
		JLabel addEmpName = new JLabel("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡髯ｷ�ｷ�ｽ�ｽ);
		JLabel addDeptName = new JLabel("鬯ｩ蟷｢�ｽ�ｨ鬩励ｑ�ｽ�ｲ");
		JTextField addEmpNoText = new JTextField();
		JTextField addEmpNameText = new JTextField();
		JTextField addDeptNameText = new JTextField();
		JTextField addEmpPassText = new JTextField();
		JButton addButton = new JButton("鬮ｴ謇假ｽｽ�ｽ髯ｷ莨夲ｽｿ�ｽ);
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
		JButton addTopButton = new JButton("TOP");

		addPanel.add(addTitle);
		addPanel.add(addEmpNo);
		addPanel.add(addEmpName);
		addPanel.add(addDeptName);
		addPanel.add(addEmpPass);
<<<<<<< HEAD
		addPanel.add(addSalLabel);
		addPanel.add(addEmpIdText);
		addPanel.add(addEmpNameText);
		addPanel.add(addDeptNameText);
		addPanel.add(addSalText);
=======
		addPanel.add(addEmpNoText);
		addPanel.add(addEmpNameText);
		addPanel.add(addDeptNameText);
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
		addPanel.add(addEmpPassText);
		addPanel.add(addButton);
		addPanel.add(addTopButton);

		addTitle.setBounds(10, 5, 80, 45);
		addEmpNo.setBounds(100, 100, 100, 50);
		addEmpName.setBounds(100, 100, 120, 150);
		addDeptName.setBounds(100, 100, 140, 250);
<<<<<<< HEAD
		addSalLabel.setBounds(100, 100, 160, 350);
		addEmpPass.setBounds(100, 100, 180, 450);
		addEmpIdText.setBounds(200, 110, 200, 30);
		addEmpNameText.setBounds(200, 160, 200, 30);
		addDeptNameText.setBounds(200, 210, 200, 30);
		addSalText.setBounds(200, 260, 200, 30);
		addEmpPassText.setBounds(200, 310, 200, 30);
		addButton.setBounds(220, 370, 150, 50);
=======
		addEmpPass.setBounds(100, 100, 160, 350);
		addEmpNoText.setBounds(200, 110, 200, 30);
		addEmpNameText.setBounds(200, 160, 200, 30);
		addDeptNameText.setBounds(200, 210, 200, 30);
		addEmpPassText.setBounds(200, 260, 200, 30);
		addButton.setBounds(220, 320, 150, 50);
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
		addTopButton.setBounds(450, 370, 150, 50);

		addTopButton.addActionListener(this);
		addTopButton.setActionCommand("top");
<<<<<<< HEAD
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
=======

		/* 髯ｷ蜿ｰ�ｼ竏晄ｱ�*/
		JPanel deletePanel = new JPanel();
		deletePanel.setLayout(null);

		JLabel deleteTitle = new JLabel("髯ｷ蜿ｰ�ｼ竏晄ｱ�);
		JLabel deleteEmpNo = new JLabel("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡ID");
		JLabel deleteEmpName = new JLabel("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡髯ｷ�ｷ�ｽ�ｽ);
		JLabel deleteDeptName = new JLabel("鬯ｩ蟷｢�ｽ�ｨ鬩励ｑ�ｽ�ｲ");
		deleteEmpIdText = new JTextField();
		deleteEmpNameText = new JTextField();
		deleteDeptNameText = new JTextField();
		Button deleteButton = new Button("髯ｷ蜿ｰ�ｼ竏晄ｱ�);
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
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
		
<<<<<<< HEAD
	}else if(command.equals("top")){//ログイン処理
			if(flag == 0){
				getEmpId = Integer.parseInt(empIdText.getText());
				getPass = Integer.parseInt(empPassText.getText());
=======
	}else if(command.equals("top")){//驛｢譎｢�ｽ�ｭ驛｢�ｧ�ｽ�ｰ驛｢�ｧ�ｽ�､驛｢譎｢�ｽ�ｳ髯ｷ�ｽ�ｽ�ｦ鬨ｾ�ｽ�ｿ�ｽ			if(flag == 0){
				getId = Integer.parseInt(idText.getText());
				getPass = Integer.parseInt(passText.getText());
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
				try{
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myorcl","scott","tiger");
					conn.setAutoCommit(true);
					Statement stmt = conn.createStatement();
<<<<<<< HEAD
					ResultSet loginRs = stmt.executeQuery("select * from java_emp where EMPID =　 "+ getEmpId +" and PASSWORD = "+ getPass +" and FLAG =0 " );
					while(loginRs.next()){
						sqlEmpId = loginRs.getInt("EMPID");
						sqlPass = loginRs.getInt("PASSWORD");
=======
					ResultSet loginRs = stmt.executeQuery("select * from java_emp where EMPID =驍ｵ�ｲ�ｽ�ｽ"+ getId +" and PASSWORD = "+ getPass +" and FLAG =0 " );
					while(loginRs.next()){
						getIdAccess = loginRs.getInt("EMPID");
						getPassAccess = loginRs.getInt("PASSWORD");
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
					}
					conn.close();
				}catch (SQLException e1){
					System.out.println("SQLException:" + e1.getMessage());
				}
<<<<<<< HEAD
				if(getEmpId == sqlEmpId && getPass == sqlPass){
					System.out.print("成功");//判定テスト
					flag ++;
=======
				if(getId == getIdAccess && getPass == getPassAccess){
					System.out.print("髫ｰ蠕｡�ｻ蜥擾ｽｲ�･");//髯具ｽｻ�ｽ�､髯橸ｽｳ陞｢�ｹ郢晢ｽｦ驛｢�ｧ�ｽ�ｹ驛｢譎｢�ｿ�ｽ					flag ++;
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
					layout.show(mainPanel, command);
				}
			}if(flag == 1){
				layout.show(mainPanel, command);
			}
<<<<<<< HEAD
		}else if(command.equals("searchAction")){//検索処理（カドさんが作る場所）
		////////////////////////////////////////////////////////////////	
		}else if(command.equals("addAction")){//追加処理
			System.out.print("tuika");
			getEmpId = Integer.parseInt(addEmpIdText.getText());
			getEmpName = addEmpNameText.getText();
			getDeptName = addDeptNameText.getText();
			getSal = Integer.parseInt(addSalText.getText());
			getPass = Integer.parseInt(addEmpPassText.getText());
=======
		}else if(command.equals("searchAction")){//髫ｶ�ｽ繽搾ｿｽ�ｴ�ｽ�｢髯ｷ�ｽ�ｽ�ｦ鬨ｾ�ｽ�ｿ�ｽ�ｽ�ｼ陋ｹ�ｻ邵ｺ蜥ｲ�ｹ譎擾ｽｳ�ｨ�ｽ�ｽ�ｹ�ｧ髦ｮ蜷ｮ�ｽ髣厄ｽｴ隲帛･�ｽｽ邇匁捗�ｽ�ｴ髫ｰ�ｽ�ｿ�ｽ�ｽ�ｼ�ｽ�ｽ		////////////////////////////////////////////////////////////////	
		}else if(command.equals("addAction")){
			

		}else if(command.equals("addAction")){//鬮ｴ謇假ｽｽ�ｽ髯ｷ莨夲ｽｿ�ｽ�ｽ�ｽ鬨ｾ�ｽ�ｿ�ｽ			getId = Integer.parseInt(deleteEmpIdText.getText());
			getEmpName = deleteEmpNameText.getText();
			getDeptName = deleteDeptNameText.getText();
			System.out.print("驛｢譎｢�ｿ�ｽ邵ｺ蟶ｷ�ｹ譎∬か�ｽ�ｼ�ｽ�ｽ+getId +getEmpName + getDeptName);
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
			try{
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myorcl","scott","tiger");
				conn.setAutoCommit(false);
				Statement stmt = conn.createStatement();
<<<<<<< HEAD
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
=======
				int deleteRs = stmt.executeUpdate("update java_emp set FLAG = 1 where EMPID = "
					+ getId +" and EMPNAME = '"+ getEmpName +"' and DEPTNAME驍ｵ�ｲ�ｽ�ｽ '" + getDeptName +"' and FLAG = 0" );
				int option = JOptionPane.showConfirmDialog(this, "髯ｷ蜿ｰ�ｼ竏晄ｱるし�ｺ陷会ｽｱ遶擾ｽｪ驍ｵ�ｺ陷ｷ�ｶ�ゑｽｰ�ｽ�ｽ�ｽ�ｽ,
					      "髯ｷ蜿ｰ�ｼ竏晄ｱるｩ墓慣�ｽ�ｺ鬮ｫ�ｱ�ｽ�ｽ, JOptionPane.YES_NO_OPTION, 
					      JOptionPane.WARNING_MESSAGE);
				count = deleteRs;
				    if (option == JOptionPane.YES_OPTION){
				    	conn.commit();
				    	JOptionPane.showMessageDialog(this, deleteRs+"髣比ｼ夲ｽｽ�ｶ髯ｷ蜿ｰ�ｼ竏晄ｱるし�ｺ陷会ｽｱ遶擾ｽｪ驍ｵ�ｺ陷会ｽｱ隨ｳ�ｽ�ｸ�ｲ�ｽ�ｽ);
				    	System.out.print(deleteRs);
				    //	layout.show(mainPanel, command);
				      }else if (option == JOptionPane.NO_OPTION){
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
				      }
				    conn.close();
			}catch (SQLException e1){
				System.out.println("SQLException:" + e1.getMessage());
			}
<<<<<<< HEAD
		}else if(command.equals("deleteAction")){//削除処理
			getEmpId = Integer.parseInt(deleteEmpIdText.getText());
=======
		}else if(command.equals("deleteAction")){//髯ｷ蜿ｰ�ｼ竏晄ｱる匚�ｽ�ｽ�ｦ鬨ｾ�ｽ�ｿ�ｽ			getId = Integer.parseInt(deleteEmpIdText.getText());
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
			getEmpName = deleteEmpNameText.getText();
			getDeptName = deleteDeptNameText.getText();
			try{
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myorcl","scott","tiger");
				conn.setAutoCommit(false);
				Statement stmt = conn.createStatement();
				int deleteRs = stmt.executeUpdate("update java_emp set FLAG = 1 where EMPID = "
<<<<<<< HEAD
					+ getEmpId +" and EMPNAME = '"+ getEmpName +"' and DEPTNAME　= '" + getDeptName +"' and FLAG = 0" );
				int option = JOptionPane.showConfirmDialog(this, "削除しますか？",
					      "削除確認", JOptionPane.YES_NO_OPTION, 
=======
					+ getId +" and EMPNAME = '"+ getEmpName +"' and DEPTNAME驍ｵ�ｲ�ｽ�ｽ '" + getDeptName +"' and FLAG = 0" );
				int option = JOptionPane.showConfirmDialog(this, "髯ｷ蜿ｰ�ｼ竏晄ｱるし�ｺ陷会ｽｱ遶擾ｽｪ驍ｵ�ｺ陷ｷ�ｶ�ゑｽｰ�ｽ�ｽ�ｽ�ｽ,
					      "髯ｷ蜿ｰ�ｼ竏晄ｱるｩ墓慣�ｽ�ｺ鬮ｫ�ｱ�ｽ�ｽ, JOptionPane.YES_NO_OPTION, 
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
					      JOptionPane.WARNING_MESSAGE);
				count = deleteRs;
				    if (option == JOptionPane.YES_OPTION){
				    	conn.commit();
<<<<<<< HEAD
				    	JOptionPane.showMessageDialog(this, deleteRs+"件削除しました。");
				    	System.out.print(deleteRs);
				      }else if (option == JOptionPane.NO_OPTION){
				    	conn.rollback();
=======
				    	JOptionPane.showMessageDialog(this, deleteRs+"髣比ｼ夲ｽｽ�ｶ髯ｷ蜿ｰ�ｼ竏晄ｱるし�ｺ陷会ｽｱ遶擾ｽｪ驍ｵ�ｺ陷会ｽｱ隨ｳ�ｽ�ｸ�ｲ�ｽ�ｽ);
				    	System.out.print(deleteRs);
				      }else if (option == JOptionPane.NO_OPTION){
>>>>>>> 6cdd80edc0055987608940966868a20dca8a1baf
				      }
				    conn.close();
			}catch (SQLException e1){
				System.out.println("SQLException:" + e1.getMessage());
			}
		}
	}
}