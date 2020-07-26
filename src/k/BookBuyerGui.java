package k;

import jade.core.Agent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BookBuyerGui extends JFrame {	
	private BookBuyerAgent buyerAgent;
	
	private JTextField titleField;
	
	BookBuyerGui(BookBuyerAgent b) {
	//	super(b.getLocalName());
		
		buyerAgent = b;
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2));
		p.add(new JLabel("Book title:"));
		titleField = new JTextField(15);
		p.add(titleField);
		getContentPane().add(p, BorderLayout.CENTER);
		
		JButton addButton = new JButton("Buy");
		addButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String title = titleField.getText().trim();
					String empty = "";
			//		buyerAgent.updateCatalogue(title, empty);
					titleField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(BookBuyerGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
		p = new JPanel();
		p.add(addButton);
		getContentPane().add(p, BorderLayout.SOUTH);
		
		// Make the agent terminate when the user closes 
		// the GUI using the button on the upper right corner	
		addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				buyerAgent.doDelete();
			}
		} );
		
		setResizable(false);
	}
	
	public void show() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.show();
	}	
}
