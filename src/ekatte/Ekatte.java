package ekatte;
import java.awt.EventQueue;
import ekatte.getSearchResult;
import ekatte.OpenFile;
import ekatte.oblastiData;
import ekatte.xlxsData;
import ekatte.getStats;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextPane;
import javax.swing.JLabel;
public class Ekatte {

	private oblastiData oblData= new oblastiData();
	private obstiniData obsData= new obstiniData();
	private selistaData selData= new selistaData();
	private JFrame frame;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ekatte window = new Ekatte();
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
	public Ekatte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.setAction(action);
		JTextArea path1 = new JTextArea();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpenFile op = new OpenFile();
				try {
					xlxsData data = new xlxsData();
					data = op.PickFile();
					oblData.setEnteties(data.getEntities());
					path1.setText(data.getPath());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
			}
		});
		btnNewButton.setBounds(263, 37, 23, 25);
		frame.getContentPane().add(btnNewButton);
		
		path1.setText("Select oblasti file");
		path1.setBounds(37, 42, 243, 15);
		frame.getContentPane().add(path1);
		
		JButton button = new JButton("...");
		JTextArea path2 = new JTextArea();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpenFile op = new OpenFile();
				try {
					xlxsData data = new xlxsData();
					data = op.PickFile();
					obsData.setEnteties(data.getEntities());
					path2.setText(data.getPath());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
			}
		});
		button.setBounds(263, 63, 23, 25);
		frame.getContentPane().add(button);
		
		path2.setText("Select obstini file");
		path2.setBounds(37, 68, 249, 15);
		frame.getContentPane().add(path2);
		
		JButton btnNewButton_1 = new JButton("...");
		JTextArea path3 = new JTextArea();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpenFile op = new OpenFile();
				try {
					xlxsData data = new xlxsData();
					data = op.PickFile();
					selData.setEnteties(data.getEntities());
					path3.setText(data.getPath());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
			}
		});
		btnNewButton_1.setBounds(263, 90, 23, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		path3.setText("Select selishta file");
		path3.setBounds(37, 95, 249, 15);
		frame.getContentPane().add(path3);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SubmitData.submitData(oblData, obsData, selData);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(304, 57, 112, 37);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(47, 131, 239, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(57, 210, 344, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(47, 177, 129, 21);
		frame.getContentPane().add(textPane);
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String s = getSearchResult.getSearchresults(textPane.getText());
					lblNewLabel_1.setText(s);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(203, 177, 114, 25);
		frame.getContentPane().add(btnSearch);
		
		JButton btnNewButton_2 = new JButton("Reload Stats");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String s = getStats.getStats();
					lblNewLabel.setText(s);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(304, 126, 134, 25);
		frame.getContentPane().add(btnNewButton_2);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
