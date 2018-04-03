import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

//import javafx.stage.FileChooser;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;


public class PDF_Reader {
	private static JFileChooser openFileChooser;
	public static void main(String[] args) throws IOException {
		String[] exten = {"pdf"}; 
		openFileChooser = new JFileChooser();
		openFileChooser.setFileFilter(new FileNameExtensionFilter("PDF Files", exten));
		int returnValue = openFileChooser.showOpenDialog(null);
		if(returnValue==JFileChooser.APPROVE_OPTION){
			File getSelectedFile = openFileChooser.getSelectedFile();
			String path = getSelectedFile.getAbsolutePath();
			path = path.replace("\\", "/");
			
			SwingController controller = new SwingController();
	        SwingViewBuilder factory = new SwingViewBuilder(controller);
	        JPanel viewerComponentPanel = factory.buildViewerPanel();
	        controller.getDocumentViewController().setAnnotationCallback(
	                new org.icepdf.ri.common.MyAnnotationCallback(
	                        controller.getDocumentViewController()));

	        JFrame applicationFrame = new JFrame();
	        applicationFrame.setTitle("PDF Box Reader");
	        applicationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        //applicationFrame.getContentPane().add(viewerComponentPanel);
	        applicationFrame.add(viewerComponentPanel);
	        
	        controller.openDocument(path);
	        applicationFrame.pack();
	        applicationFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("Logo.png")));
	        applicationFrame.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "No file choosen!");
		}
	}

}
