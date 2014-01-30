/*髯具ｽｻ�ｽ�ｶ髣厄ｽｴ隲幢ｿｽ�ｿ�ｽ�ｽ�ｽ陞｢�ｼ陜�ｿｽ蝙郁ｭ趣ｿｽ閭ｸ鬮ｮ蜈ｷ�ｽ�ｴ
 *髯具ｽｻ�ｽ�ｶ髣厄ｽｴ隲帑ｺ･�ｾ蜈ｷ�ｿ�ｽ陞滂ｽｲ�ｽ�ｼ隰�∞�ｽ�ｼ陷ｻ蝓滂ｿｽ�ｽ�ｽ隰�∞�ｽ�ｼ陷井ｺ･�ｾ�ｽ
 * 
 * 鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡驛｢�ｧ�ｽ�ｷ驛｢�ｧ�ｽ�ｹ驛｢譎｢�ｿ�ｽ�主ｮ夲ｽｭ蟷｢�ｽ�ｬ髣厄ｽｴ�ｽ�ｽ */

//update aki0018
//update Serina
//update Kadofuji

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
	
	
	public static void main(String[] args) {
		EmpSystem frame = new EmpSystem();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200, 150, 640, 480);
		frame.setTitle("髫ｶ�ｽ繽搾ｿｽ�ｴ�ｽ�｢驍ｵ�ｺ�ｽ�ｪ驍ｵ�ｺ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｽ�ｴ髫ｨ�ｳ隰夲ｽｫ�ｽ�ｽ驛｢�ｧ隴擾ｽｶ雎ｼ�ｫ驕ｯ�ｶ�ｽ�ｽ");
		frame.setVisible(true);
		frame.setResizable(false);
	}

	EmpSystem() {
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
		loginButton.setBounds(300, 300, 200, 50); 
		
		loginButton.addActionListener(this);
		loginButton.setActionCommand("top");
		
		/* TOP鬨ｾ蛹�ｽｽ�ｻ鬯ｮ�ｱ�ｽ�｢ */
		JPanel topPanel = new JPanel();
		topPanel.setLayout(null);

		JLabel topTitle = new JLabel("TOP");
		JButton empSearch = new JButton("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡髫ｶ�ｽ繽搾ｿｽ�ｴ�ｽ�｢");
		JButton empAdd = new JButton("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡鬮ｴ謇假ｽｽ�ｽ髯ｷ莨夲ｽｿ�ｽ);
		JButton empDelete = new JButton("鬩穂ｼ夲ｽｽ�ｾ髯ｷ�ｩ�ｽ�｡髯ｷ蜿ｰ�ｼ竏晄ｱ�);

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
		
		/*髫ｶ�ｽ繽搾ｿｽ�ｴ�ｽ�｢鬩搾ｽｨ陷亥沺�｣�｡鬮ｯ�ｦ�ｽ�ｨ鬩穂ｼ夲ｽｽ�ｺ鬨ｾ蛹�ｽｽ�ｻ鬯ｮ�ｱ�ｽ�｢*/
		JPanel searchActionPanel = new JPanel();
		searchActionPanel.setLayout(null);
		
		JButton searchReturnButton = new JButton();

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
		JButton addTopButton = new JButton("TOP");

		addPanel.add(addTitle);
		addPanel.add(addEmpNo);
		addPanel.add(addEmpName);
		addPanel.add(addDeptName);
		addPanel.add(addEmpPass);
		addPanel.add(addEmpNoText);
		addPanel.add(addEmpNameText);
		addPanel.add(addDeptNameText);
		addPanel.add(addEmpPassText);
		addPanel.add(addButton);
		addPanel.add(addTopButton);

		addTitle.setBounds(10, 5, 80, 45);
		addEmpNo.setBounds(100, 100, 100, 50);
		addEmpName.setBounds(100, 100, 120, 150);
		addDeptName.setBounds(100, 100, 140, 250);
		addEmpPass.setBounds(100, 100, 160, 350);
		addEmpNoText.setBounds(200, 110, 200, 30);
		addEmpNameText.setBounds(200, 160, 200, 30);
		addDeptNameText.setBounds(200, 210, 200, 30);
		addEmpPassText.setBounds(200, 260, 200, 30);
		addButton.setBounds(220, 320, 150, 50);
		addTopButton.setBounds(450, 370, 150, 50);

		addTopButton.addActionListener(this);
		addTopButton.setActionCommand("top");

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
		
	}else if(command.equals("top")){//驛｢譎｢�ｽ�ｭ驛｢�ｧ�ｽ�ｰ驛｢�ｧ�ｽ�､驛｢譎｢�ｽ�ｳ髯ｷ�ｽ�ｽ�ｦ鬨ｾ�ｽ�ｿ�ｽ			if(flag == 0){
				getId = Integer.parseInt(idText.getText());
				getPass = Integer.parseInt(passText.getText());
				try{
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myorcl","scott","tiger");
					conn.setAutoCommit(true);
					Statement stmt = conn.createStatement();
					ResultSet loginRs = stmt.executeQuery("select * from java_emp where EMPID =驍ｵ�ｲ�ｽ�ｽ"+ getId +" and PASSWORD = "+ getPass +" and FLAG =0 " );
					while(loginRs.next()){
						getIdAccess = loginRs.getInt("EMPID");
						getPassAccess = loginRs.getInt("PASSWORD");
					}
					conn.close();
				}catch (SQLException e1){
					System.out.println("SQLException:" + e1.getMessage());
				}
				if(getId == getIdAccess && getPass == getPassAccess){
					System.out.print("髫ｰ蠕｡�ｻ蜥擾ｽｲ�･");//髯具ｽｻ�ｽ�､髯橸ｽｳ陞｢�ｹ郢晢ｽｦ驛｢�ｧ�ｽ�ｹ驛｢譎｢�ｿ�ｽ					flag ++;
					layout.show(mainPanel, command);
				}
			}if(flag == 1){
				layout.show(mainPanel, command);
			}
		}else if(command.equals("searchAction")){//髫ｶ�ｽ繽搾ｿｽ�ｴ�ｽ�｢髯ｷ�ｽ�ｽ�ｦ鬨ｾ�ｽ�ｿ�ｽ�ｽ�ｼ陋ｹ�ｻ邵ｺ蜥ｲ�ｹ譎擾ｽｳ�ｨ�ｽ�ｽ�ｹ�ｧ髦ｮ蜷ｮ�ｽ髣厄ｽｴ隲帛･�ｽｽ邇匁捗�ｽ�ｴ髫ｰ�ｽ�ｿ�ｽ�ｽ�ｼ�ｽ�ｽ		////////////////////////////////////////////////////////////////	
		}else if(command.equals("addAction")){
			

		}else if(command.equals("addAction")){//鬮ｴ謇假ｽｽ�ｽ髯ｷ莨夲ｽｿ�ｽ�ｽ�ｽ鬨ｾ�ｽ�ｿ�ｽ			getId = Integer.parseInt(deleteEmpIdText.getText());
			getEmpName = deleteEmpNameText.getText();
			getDeptName = deleteDeptNameText.getText();
			System.out.print("驛｢譎｢�ｿ�ｽ邵ｺ蟶ｷ�ｹ譎∬か�ｽ�ｼ�ｽ�ｽ+getId +getEmpName + getDeptName);
			try{
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myorcl","scott","tiger");
				conn.setAutoCommit(false);
				Statement stmt = conn.createStatement();
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
				      }
				    conn.close();
			}catch (SQLException e1){
				System.out.println("SQLException:" + e1.getMessage());
			}
		}else if(command.equals("deleteAction")){//髯ｷ蜿ｰ�ｼ竏晄ｱる匚�ｽ�ｽ�ｦ鬨ｾ�ｽ�ｿ�ｽ			getId = Integer.parseInt(deleteEmpIdText.getText());
			getEmpName = deleteEmpNameText.getText();
			getDeptName = deleteDeptNameText.getText();
			try{
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myorcl","scott","tiger");
				conn.setAutoCommit(false);
				Statement stmt = conn.createStatement();
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
				      }else if (option == JOptionPane.NO_OPTION){
				      }
				    conn.close();
			}catch (SQLException e1){
				System.out.println("SQLException:" + e1.getMessage());
			}
		}
	}
}