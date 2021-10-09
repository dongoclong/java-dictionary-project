package TuDienP1;

import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
//import java.io.BufferedOutputStream;
//import java.io.File;

public class DictionaryCommandline {
	
	DictionaryManagement dictionaryManagemment = new DictionaryManagement();
	
	/**
	 * the method use show all word in dictionary
	 */
	public void showAllWord() {
		Dictionary myDictionary = new Dictionary();
		int count = 1;
		System.out.println("No     | English  \t| Vietnamses");
		for(Word i : myDictionary.listWord) {
			System.out.println(count + "      |" + i.getWord_target() + "\t\t|" + i.getWord_explain());
			count++;
		}
	}
	
	/**
	 * the method dictionary basic from version 1
	 * insert the list word from command line
	 * call insertFromCommandlinde method and showAllWord method 
	 */
	public void dictionaryBasic() {
		dictionaryManagemment.insertFromCommandline();
		dictionaryManagemment.removeWord();
		dictionaryManagemment.editWord();
//		dictionaryManagemment.insertWord();
		this.showAllWord();
	}
	
	public void dictionaryAdvanced() throws FileNotFoundException, IOException{
		dictionaryManagemment.insertFromFile();
		dictionaryManagemment.dictionaryLookup();
		this.showAllWord();
		dictionaryManagemment.dictionaryExportToFile();
		this.dictionarySreach();
	}
	
	public void dictionarySreach() {
		System.out.println("Nhap tu can tra: ");
		String s;
		Scanner scan = new Scanner(System.in);
		s= scan.nextLine();
		System.out.println("Cac tu : " + s + " la: ");
//		forEach duyet listWord
//		i.getWord_target().indexOf(s) dung de kiem tra co bao nhieu tu bat dau bang s or cung co the la s.target giong trong listWord
		for( Word i : Dictionary.listWord) {			
			int index = i.getWord_target().indexOf(s);
			if	(index == 0) {
				System.out.println(i.getWord_target() + "\t" + i.getWord_explain());
			}
		}
	}
	
	/**
	 * test thu chuong trinh trong main
	 */
	public static void main(String []args) throws FileNotFoundException {
		DictionaryCommandline x = new DictionaryCommandline();
		x.dictionaryBasic();
		try {
			x.dictionaryAdvanced();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		x.dictionarySreach();
	}
}
