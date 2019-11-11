package zad1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class GuiOferty extends JFrame{
	
	JFrame frame;
	JTable ofertyTable;
	FileReader fileReader;
	BufferedReader br;
	DefaultTableModel model;
	Locale locale;
	String[] columnsName  = { "lokalizacja_kontrahenta", "kraj", "data_wyjazdu",
							"data_powrotu", "miejsce", "cena", "symbol_waluty"};
	Object[][] data;
	
	public GuiOferty(File dataDir, Locale locale) {
		this.locale = locale;
		frame = new JFrame("Oferty");
		ofertyTable = new JTable(model);
		model = (DefaultTableModel) ofertyTable.getModel();
		model.setColumnIdentifiers(columnsName);

		File[] directoryFiles = dataDir.listFiles();
		try {
		for(File file : directoryFiles) {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			Object[] tableLines = br.lines().toArray();
			
			for(int i = 0; i<tableLines.length; i++) {
				String line = tableLines[i].toString().trim();			
				String[] dataRow = line.split("\t");
				model.addRow(dataRow);
			}
		}
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.add(ofertyTable.getTableHeader(),BorderLayout.NORTH);
		frame.add(ofertyTable);
		ofertyTable.setPreferredSize(new Dimension(1000, 200));
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
}
