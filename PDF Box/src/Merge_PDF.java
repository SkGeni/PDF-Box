import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;


public class Merge_PDF {

	private JFrame frmMergeSplit;
	private JTable table;
	private JFileChooser openFileChooser;
	private JTextField name;
	private String saveAt = "file";
	private String saveAtFol="New_Folder";
	private JTextField textField;
	private JTextField textField_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Merge_PDF window = new Merge_PDF();
					window.frmMergeSplit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Merge_PDF() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMergeSplit = new JFrame();
		frmMergeSplit.setResizable(false);
		frmMergeSplit.setIconImage(Toolkit.getDefaultToolkit().getImage(Merge_PDF.class.getResource("Logo.png")));
		frmMergeSplit.setBounds(100, 100, 700, 556);
		frmMergeSplit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMergeSplit.setTitle("Merge - Split PDF");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.setFont(new Font("Trajan Pro", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(frmMergeSplit.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 682, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Merge", null, panel, "Image to PDF");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] exten = {"pdf"}; 
				openFileChooser = new JFileChooser();
				openFileChooser.setFileFilter(new FileNameExtensionFilter("PDF File", exten));
				int returnValue = openFileChooser.showOpenDialog(null);
				if(returnValue==JFileChooser.APPROVE_OPTION){
					File getSelectedFile = openFileChooser.getSelectedFile();
					String path = getSelectedFile.getAbsolutePath();
					path = path.replace("\\", "/");
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[]{openFileChooser.getSelectedFile().getName(),path});
					//TableItem item = new TableItem(table, SWT.NONE);
		            //item.setText(text.getText());
				}else{
					JOptionPane.showMessageDialog(null, "No file choosen!");
				}
			}
		});
		
		btnNewButton.setIcon(new ImageIcon(Merge_PDF.class.getResource("/buttons/if_file_add_48761 (1).png")));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Merge_PDF.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-fewer-details@2x.png")));
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Merge_PDF.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-more-details@2x.png")));
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Merge_PDF.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-error.png")));
				
		JInternalFrame internalFrame = new JInternalFrame("Images");
		internalFrame.setFrameIcon(null);
		internalFrame.setVisible(true);
		internalFrame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 642, 238);
		internalFrame.getContentPane().add(scrollPane);
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Path"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(230);
		table.getColumnModel().getColumn(1).setPreferredWidth(551);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		JLabel lblNameOfThe = new JLabel("Save As :");
		lblNameOfThe.setFont(new Font("Segoe Script", Font.BOLD, 14));
		lblNameOfThe.setBounds(51, 263, 90, 16);
		internalFrame.getContentPane().add(lblNameOfThe);
		
		name = new JTextField();
		name.setBounds(153, 256, 446, 28);
		internalFrame.getContentPane().add(name);
		name.setColumns(10);
		name.setText(System.getProperty("user.home")+"\\Documents");
		
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save");
				String [] ext = {"pdf"}; 
				fileChooser.setFileFilter(new FileNameExtensionFilter("PDF File", ext));
				 
				int userSelection = fileChooser.showSaveDialog(frmMergeSplit);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToSave = fileChooser.getSelectedFile();
				    saveAt = fileToSave.getAbsolutePath().replace("\\", "/");
				    name.setText(saveAt);
				}
			}
		});
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				PDFMergerUtility PDFmerger = new PDFMergerUtility();
				PDFmerger.setDestinationFileName(name.getText()+".pdf");

				for(int i = 0; i<table.getRowCount();i++){
					File file1 = new File((String) table.getValueAt(i, 1));
					try {
						PDDocument doc1 = PDDocument.load(file1);
						PDFmerger.addSource(file1);
						doc1.close();
						//PDFmerger.appendDocument(doc1, doc1);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvalidPasswordException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
				}
				try {
					PDFmerger.mergeDocuments();
					JOptionPane.showMessageDialog(null, "Done!!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button_3.setIcon(new ImageIcon(Merge_PDF.class.getResource("/buttons/if_player_play_1825.png")));

		
		//Up Button
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.moveRow(index, index, index-1);
			}
		});
		
		//Down Button
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.moveRow(index, index, index+1);
			}
		});
		
		//Remove pdf
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(index);
			}
		});
		
		
		
		btnBrowse.setBounds(474, 296, 125, 35);
		internalFrame.getContentPane().add(btnBrowse);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(internalFrame, GroupLayout.PREFERRED_SIZE, 666, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(97)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(internalFrame, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		//////////
		//Split   ////
		///////
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Split", null, panel_1, "Splitting the PDF");
		
		textField = new JTextField();
		textField.setText(System.getProperty("user.home")+"\\Documents");
		textField.setColumns(10);
		
		JLabel lblLoadPdf = new JLabel("Load PDF :");
		lblLoadPdf.setFont(new Font("Segoe Script", Font.BOLD, 14));
		
		//load PDF
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
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
		
		final JRadioButton rdbtnAllPages = new JRadioButton("All Pages");
		buttonGroup.add(rdbtnAllPages);
		rdbtnAllPages.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtnAllPages.setSelected(true);
		
		JLabel lblFolderName = new JLabel("Folder Path :");
		lblFolderName.setFont(new Font("Segoe Script", Font.BOLD, 14));
		
		textField_2 = new JTextField();
		textField_2.setText(System.getProperty("user.home"));
		textField_2.setColumns(10);
		
		///save Browse
		JButton btnBrowse_1 = new JButton("Browse");
		btnBrowse_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save");
				String [] ext = {"pdf"}; 
				fileChooser.setFileFilter(new FileNameExtensionFilter("PDF File", ext));
				 
				int userSelection = fileChooser.showSaveDialog(frmMergeSplit);
				if (userSelection == JFileChooser.APPROVE_OPTION) {
				    File fileToSave = fileChooser.getSelectedFile();
				    saveAtFol = fileToSave.getAbsolutePath().replace("\\", "/");
				    textField_2.setText(saveAtFol);
				}
			}
		});
		
		JButton button_5 = new JButton("");
		
				button_5.setIcon(new ImageIcon(Merge_PDF.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnBrowse_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(50)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblFolderName, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblLoadPdf, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
										.addGap(12)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGap(423)
										.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(317)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 669, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(273)
							.addComponent(rdbtnAllPages, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(lblLoadPdf))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(rdbtnAllPages)
					.addGap(60)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFolderName, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBrowse_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		frmMergeSplit.getContentPane().setLayout(groupLayout);
		
		///split
				button_5.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent arg0) {
						File dir = new File(textField_2.getText());
						dir.mkdirs();
						
						String nameOfFolder = textField_2.getText().substring(textField_2.getText().lastIndexOf("/")+1);
						File file = new File(textField.getText());
						PDDocument document = null;
						try {
						document = PDDocument.load(file);
						Splitter splitter = new Splitter();
						List<PDDocument> Pages = splitter.split(document);
						Iterator<PDDocument> iterator = Pages.listIterator();
						int i = 1;
					      while(iterator.hasNext()) {
					         PDDocument pd = iterator.next();
					         pd.save(textField_2.getText()+"/"+nameOfFolder+ i++ +".pdf");
					      }
					      JOptionPane.showMessageDialog(null, "Done!!");
						} catch (InvalidPasswordException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						    
					}
				});
	}
}
