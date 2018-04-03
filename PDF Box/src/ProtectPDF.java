import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Toolkit;
import javax.swing.JPasswordField;


public class ProtectPDF {

	private JFrame frmProtectPdf;
	private JTextField textField;
	private JFileChooser openFileChooser;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProtectPDF window = new ProtectPDF();
					window.frmProtectPdf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public ProtectPDF() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		frmProtectPdf = new JFrame();
		frmProtectPdf.setTitle("Protect PDF");
		frmProtectPdf.setIconImage(Toolkit.getDefaultToolkit().getImage(ProtectPDF.class.getResource("/buttons/backLogo.png")));
		frmProtectPdf.setBounds(100, 100, 458, 300);
		frmProtectPdf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout groupLayout = new GroupLayout(frmProtectPdf.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label = new JLabel("Load PDF :");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField = new JTextField();
		textField.setText("C:\\Users\\ShubKaus\\Documents");
		textField.setColumns(10);
		
		JButton button = new JButton("Load");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] exten = {"pdf"}; 
				openFileChooser = new JFileChooser();
				openFileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", exten));
				int returnValue = openFileChooser.showOpenDialog(null);
				if(returnValue==JFileChooser.APPROVE_OPTION){
					File getSelectedFile = openFileChooser.getSelectedFile();
					String path = getSelectedFile.getAbsolutePath();
					path = path.replace("\\", "/");
					textField.setText(path);				
				}else{
					JOptionPane.showMessageDialog(null, "No file choosen!");
				}
			}
		});
		
		JLabel lblPassword = new JLabel("Password : ");
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password : ");
		
		JButton btnProtect = new JButton("Protect");
		btnProtect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String lol = JOptionPane.showInputDialog("Enter Admin Password : ");
				if(passwordField.getText().equals(passwordField_1.getText())){
					File file = new File(textField.getText());
				    PDDocument document;
					try {
						document = PDDocument.load(file);
						AccessPermission ap = new AccessPermission();         
						StandardProtectionPolicy spp = new StandardProtectionPolicy(passwordField.getText(), lol, ap);
						spp.setEncryptionKeyLength(128);
						spp.setPermissions(ap);
						document.protect(spp);
						document.save(textField.getText());
					    document.close();
					    JOptionPane.showMessageDialog(null, "Done!!");
					} catch (InvalidPasswordException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   
				}
				else JOptionPane.showMessageDialog(null, "Passwords not Same");
			}
		});
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(151)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(passwordField_1)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
					.addContainerGap(100, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(191, Short.MAX_VALUE)
					.addComponent(btnProtect)
					.addGap(160))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(label))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmPassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(btnProtect)
					.addGap(27))
		);
		panel.setLayout(gl_panel);
		frmProtectPdf.getContentPane().setLayout(groupLayout);
	}
}
