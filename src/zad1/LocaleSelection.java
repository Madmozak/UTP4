package zad1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LocaleSelection extends JFrame{
	
	
	JFrame frame; 
	File dataDir;
	JPanel panelButton;
	JButton polskiButton;
	JButton englishButton;
	JButton deutscheButton;
	JButton frenchButton;
	Locale locale;
	
	public LocaleSelection(File dataDir) {
		frame = new JFrame("Select localization");
		this.dataDir = dataDir;
		frame.add(panelButton = new JPanel());
		panelButton.add(polskiButton = new JButton("Polska"));
		panelButton.add(englishButton = new JButton("Anglia"));
		panelButton.add(deutscheButton = new JButton("Germany"));
		panelButton.add(frenchButton = new JButton("France"));
		
		polskiButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				locale = Locale.getDefault();
				System.out.println("Lokalizacja: " + locale);
				new GuiOferty(dataDir, locale);
				frame.setVisible(false);
				
			}
			
		});
		englishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				locale = Locale.UK;
				System.out.println("Lokalizacja: " + locale);
				new GuiOferty(dataDir, locale);
				frame.setVisible(false);
			}
			
		});
		
		deutscheButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				locale = Locale.GERMANY;
				System.out.println("Lokalizacja: " + locale);
				new GuiOferty(dataDir, locale);
				frame.setVisible(false);
			}
			
		});
		
		frenchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				locale = Locale.FRANCE;
				System.out.println("Lokalizacja: " + locale);
				new GuiOferty(dataDir, locale);
				frame.setVisible(false);
			}
			
		});
		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void close() {
		
	}

}
