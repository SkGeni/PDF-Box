import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Rem_Page {

	private JFrame frmRemovePage;
	private JTextField textField;
	private JTextField textField_1;
	private JFileChooser openFileChooser;
	private JTextField textField_2;
	private String saveAt;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rem_Page window = new Rem_Page();
					window.frmRemovePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Rem_Page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRemovePage = new JFrame();
		frmRemovePage.setResizable(false);
		frmRemovePage.setTitle("Remove Page");
		frmRemovePage.setIconImage(Toolkit.getDefaultToolkit().getImage(Rem_Page.class.getResource("/buttons/backLogo.png")));
		frmRemovePage.setBounds(100, 100, 454, 383);
		frmRemovePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout groupLayout = new GroupLayout(frmRemovePage.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 422, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label = new JLabel("Load PDF :");
		label.setFont(new Font("Segoe Script", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setText(System.getProperty("user.home")+"\\Documents");
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
		
		JLabel lblPageNumbersTo = new JLabel("Page Numbers to be Removed : ");
		lblPageNumbersTo.setFont(new Font("Segoe Script", Font.BOLD, 14));
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("eg: 1,2,3,4,....in ascending order");
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] words=textField_1.getText().split(",");
				PDDocument document = null;
				File file1;
				int j=0;
				try {
				for(int i=0;i<words.length;i++){
					int pageNum = Integer.parseInt(words[i].trim());
					File file = new File(textField.getText());
				    document = PDDocument.load(file);
				    if(document.getNumberOfPages()>=pageNum){
				    	if(j!=0){
				    	file1 = new File(textField_2.getText()+".pdf");
					    document = PDDocument.load(file1);
				    	}
					    document.removePage(pageNum-1-j);
					    document.save(textField_2.getText()+".pdf");
				    	document.close();
						j++;
				    }
				}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Done!!");
			}
		});
		button_1.setIcon(new ImageIcon(Rem_Page.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		
		textField_2 = new JTextField();
		textField_2.setText(System.getProperty("user.home")+"\\Documents");
		textField_2.setColumns(10);
		
		JLabel label_1 = new JLabel("Save PDF :");
		label_1.setFont(new Font("Segoe Script", Font.BOLD, 14));
		
		JButton button_2 = new JButton("Browse");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save");
				String [] ext = {"pdf"}; 
				fileChooser.setFileFilter(new FileNameExtensionFilter("PDF File", ext));
				 
				int userSelection = fileChooser.showSaveDialog(frmRemovePage);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToSave = fileChooser.getSelectedFile();
				    saveAt = fileToSave.getAbsolutePath().replace("\\", "/");
				    textField_2.setText(saveAt);
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(17, Short.MAX_VALUE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addGap(12)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(282)
										.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPageNumbersTo, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(178)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPageNumbersTo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button_1)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmRemovePage.getContentPane().setLayout(groupLayout);
	}
}
