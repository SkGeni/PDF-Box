import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import java.awt.Toolkit;




public class Compare_PDF {

	private JFrame frmComparePdfFiles;
	private JTextField textField;
	private JTextField textField_1;
	private JFileChooser openFileChooser;
	private String path1;
	private String path2;
	private JLabel label;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compare_PDF window = new Compare_PDF();
					window.frmComparePdfFiles.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Compare_PDF() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmComparePdfFiles = new JFrame();
		frmComparePdfFiles.setResizable(false);
		frmComparePdfFiles.setTitle("Compare PDF Files");
		frmComparePdfFiles.setIconImage(Toolkit.getDefaultToolkit().getImage(Compare_PDF.class.getResource("/buttons/backLogo.png")));
		frmComparePdfFiles.setBounds(100, 100, 596, 365);
		frmComparePdfFiles.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textField = new JTextField();
		textField.setText(System.getProperty("user.home")+"\\Documents");
		textField.setColumns(10);
		
		JLabel lblLoadPdf = new JLabel("Load PDF 1 :");
		lblLoadPdf.setFont(new Font("Segoe Script", Font.BOLD, 14));
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] exten = {"pdf"}; 
				openFileChooser = new JFileChooser();
				openFileChooser.setFileFilter(new FileNameExtensionFilter("PDF File", exten));
				int returnValue = openFileChooser.showOpenDialog(null);
				if(returnValue==JFileChooser.APPROVE_OPTION){
					File getSelectedFile = openFileChooser.getSelectedFile();
					path1 = getSelectedFile.getAbsolutePath();
					path1 = path1.replace("\\", "/");
					textField.setText(path1);
				}else{
					JOptionPane.showMessageDialog(null, "No file choosen!");
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setText(System.getProperty("user.home")+"\\Documents");
		textField_1.setColumns(10);
		
		JLabel lblLoadPdf_1 = new JLabel("Load PDF 2 :");
		lblLoadPdf_1.setFont(new Font("Segoe Script", Font.BOLD, 14));
		
		JButton button_1 = new JButton("Browse");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] exten = {"pdf"}; 
				openFileChooser = new JFileChooser();
				openFileChooser.setFileFilter(new FileNameExtensionFilter("PDF File", exten));
				int returnValue = openFileChooser.showOpenDialog(null);
				if(returnValue==JFileChooser.APPROVE_OPTION){
					File getSelectedFile = openFileChooser.getSelectedFile();
					path2 = getSelectedFile.getAbsolutePath();
					path2 = path2.replace("\\", "/");
					textField_1.setText(path2);
				}else{
					JOptionPane.showMessageDialog(null, "No file choosen!");
				}
			}
		});
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Compare_PDF.class.getResource("/buttons/PDF_Compare.png")));
		
		JLabel lblAreTheySame = new JLabel("Are they same ?");
		lblAreTheySame.setFont(new Font("SansSerif", Font.ITALIC, 13));
		
		label = new JLabel("");
		label.setFont(new Font("Script MT Bold", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frmComparePdfFiles.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblLoadPdf, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(447)
							.addComponent(btnBrowse, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(446)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblLoadPdf_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAreTheySame)
									.addGap(18)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(18, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(272, Short.MAX_VALUE)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(249))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblLoadPdf))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(btnBrowse, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblLoadPdf_1))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAreTheySame)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		frmComparePdfFiles.getContentPane().setLayout(groupLayout);
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file1 = new File(path1);
                File file2 = new File(path2);
        
                boolean compareResult;
				try {
					compareResult = FileUtils.contentEquals(file1, file2);
					
					if(compareResult)
					label.setText("Yes! Congrats");
					else label.setText("Sorry! They Aren't");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
			}
		});
		
	}
}
