package TuDienP1;

import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//import java.io.BufferedOutputStream;
//import java.io.File;
import java.util.*;

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
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void dictionaryBasic() throws FileNotFoundException, IOException {
		dictionaryManagemment.insertFromCommandline();
		dictionaryManagemment.removeWord();
		dictionaryManagemment.editWord();
		dictionaryManagemment.insertWord();
		this.showAllWord();
	}
	
	public void dictionaryAdvanced() throws FileNotFoundException, IOException{
		dictionaryManagemment.insertFromFile();
		dictionaryManagemment.dictionaryLookup();
		dictionaryManagemment.dictionaryExportToFile();
		this.showAllWord();
		this.searchFive();
	}
	
//	show 5 word dau tien
	public ArrayList<Word> dictionarySearch(String input) {
		ArrayList<Word> list = new ArrayList<>();
		for( Word word : Dictionary.listWord) {			
			int index = word.getWord_target().indexOf(input);
			if	(index == 0) {
				list.add(word);
			}
		}
		return list;
	}
	
	public void searchFive() {
		System.out.println("Nhap tu can tra: ");
		String s;
		Scanner scan = new Scanner(System.in);
		s= scan.nextLine();
		System.out.println("Cac tu bat dau bang : " + s + " la: ");
		ArrayList<Word> list = this.dictionarySearch(s);
		if (list.size() == 0) {
			System.out.println("Khong co tu nay trong tu dien, than!");
		} else  if (list.size() > 5) {
			List<Word> fiveElement = list.subList(0, 5);
			String rs = this.showListWord(fiveElement);
			System.out.println("Result: \n" + rs);
		} else {
			String rs = this.showListWord(list);
			System.out.println("Result: \n" + rs);
		}
	}
	
	public String showListWord(List<Word> list) {
		String result = "";
		int count = 1;
		for(Word i : list) {
			String wResult = count + "      |" + i.getWord_target() + "\t\t|" + i.getWord_explain() + "\n";
			result += wResult;
			count++;
			
		}
		return result; 
	}
	
	/**
	 * test thu chuong trinh trong main
	 * @throws FileNotFoundException
	 * @throws IOException 
	 */
	public static void main(String []args) throws IOException,FileNotFoundException {
		DictionaryCommandline x = new DictionaryCommandline();
		x.dictionaryBasic();
//		try {
//			x.dictionaryAdvanced();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		x.dictionarySreach();
	}
}
