package zad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;


public class TravelData{
	
	File dataDir;
	File[] directoryFiles;
	FileReader fileReader;
	BufferedReader bufferedReader;
	StringBuilder stringBuilder;
	Locale localization = Locale.getDefault();
	SimpleDateFormat sdf;
	String[] str;
	String line;
	ArrayList<String> splitedList = new ArrayList<String>();
	ArrayList<String> mergedList = new ArrayList<String>();
	ResourceBundle message;

	
	public TravelData(File dataDir) {
		this.dataDir = dataDir;
		this.directoryFiles = dataDir.listFiles();

		
		
		
		
	}

	public List<String> getOffersDescriptionsList(String locale, String dateFormat) {
		List<String> ofertyList = new ArrayList<String>();
		sdf = new SimpleDateFormat(dateFormat);
		String[] s = locale.split("_");
		Locale localization = new Locale.Builder().setLanguage(s[0]).setRegion(s[1]).build();
		if(localization.equals("pl_PL"))
			localization = Locale.getDefault();
		message = ResourceBundle.getBundle("MessagesBundle", localization);
		/*
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i< splitedList.size(); i++) {
			if(i == 1 | i == 4 | i == 8 | i == 11 | i == 15 | i == 18)
				sb.append(message.getString(splitedList.get(i)));
			else
				sb.append(splitedList.get(i));
		}
		*/
		//System.out.println(sb);
		
		//mergedList.add(ts);
		for(File file : directoryFiles) {
			try {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				stringBuilder = new StringBuilder();
				String line = null;
				while((line = bufferedReader.readLine()) != null) {	
					ofertyList.add(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ofertyList;
	}

}
