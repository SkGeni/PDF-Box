import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JInternalFrame;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import java.io.IOException;



public class Main {

	private JFrame frame;
	JButton button;
	JButton button_1;
	JButton button_3;
	JButton button_4;
	JButton button_5;
	JButton button_6;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		createEvents();
	}

	private void createEvents() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//reader
				try {
					PDF_Reader.main(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//pdf to image
				try {
					Img_PDF.main(null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Compare_PDF.main(null);
			}
		});
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Merge_PDF.main(null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rem_Page.main(null);
			}
		});
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProtectPDF.main(null);
			}
		});
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(Color.WHITE);
		frame.setBackground(SystemColor.inactiveCaption);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("Logo.png")));
		frame.getContentPane().setBackground(SystemColor.scrollbar);
		frame.setTitle("PDF Box");
		frame.setBounds(100, 100, 859, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(SystemColor.scrollbar);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/buttons/backLogo.png")));
		
		button = new JButton("");
		button.setIcon(new ImageIcon(Main.class.getResource("/buttons/PDF_Reader.png")));
		
		JLabel lblPdfReader = new JLabel("PDF Reader");
		lblPdfReader.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPdfReader.setHorizontalAlignment(SwingConstants.CENTER);
		lblPdfReader.setForeground(new Color(0, 0, 51));
		
		JLabel lblImagePdf = new JLabel("Image <-> PDF");
		lblImagePdf.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagePdf.setForeground(new Color(0, 0, 51));
		lblImagePdf.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Main.class.getResource("/buttons/pdf2img.png")));
		
		JLabel lblComparePdf = new JLabel("Compare PDF");
		lblComparePdf.setHorizontalAlignment(SwingConstants.CENTER);
		lblComparePdf.setForeground(new Color(0, 0, 51));
		lblComparePdf.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Main.class.getResource("/buttons/PDF_Compare.png")));
		
		JLabel lblMergeSplit = new JLabel("Merge- Split");
		lblMergeSplit.setHorizontalAlignment(SwingConstants.CENTER);
		lblMergeSplit.setForeground(new Color(0, 0, 51));
		lblMergeSplit.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(Main.class.getResource("/buttons/mergePDF.png")));
		
		JLabel lblRemovePage = new JLabel("Remove Page");
		lblRemovePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemovePage.setForeground(new Color(0, 0, 51));
		lblRemovePage.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(Main.class.getResource("/buttons/PDF_Rem_Page.png")));
		
		JLabel lblProtection = new JLabel("Protection");
		lblProtection.setHorizontalAlignment(SwingConstants.CENTER);
		lblProtection.setForeground(new Color(0, 0, 51));
		lblProtection.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(Main.class.getResource("/buttons/PDFencDec.png")));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblImagePdf, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED, 6, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(89)
							.addComponent(lblPdfReader, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(104))
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 291, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblComparePdf, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED, 6, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblMergeSplit, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 291, Short.MAX_VALUE)
						.addComponent(lblRemovePage, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(lblProtection, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 291, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addComponent(lblPdfReader, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblImagePdf, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
							.addGap(15)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(lblComparePdf, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
							.addGap(11)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(lblMergeSplit, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
							.addGap(29)
							.addComponent(lblRemovePage, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
							.addGap(28)
							.addComponent(lblProtection, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
							.addGap(35))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE))
					.addGap(31))
		);
		
		JLabel lblAPdfUtility = new JLabel("A PDF Utility Software");
		panel.add(lblAPdfUtility);
		frame.getContentPane().setLayout(groupLayout);
	}
}
