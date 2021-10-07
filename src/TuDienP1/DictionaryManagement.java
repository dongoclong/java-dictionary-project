package TuDienP1;

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.File;

public class DictionaryManagement {
	
	Dictionary myDictionary = new Dictionary();
	
	/**
	 * this method use insert list word from command line
	 * return void
	 */
	public void insertFromCommandline() {
		Scanner scan = new Scanner(System.in);
		int numberOfWord;
		System.out.println("Nhap so tu: ");
		numberOfWord = Integer.parseInt(scan.nextLine());
		for(int i = 0;i < numberOfWord;i++) {
			Word _word = new Word();
			_word.setWord_target(scan.nextLine());
			_word.setWord_explain(scan.nextLine());
			myDictionary.listWord.add(_word);
		}
	}
	
	/**
	 * 
	 * 
	 */
	public void insertFromFile() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("dictionaries.txt"));
		while(scan.hasNext()) {
			String stringWord = scan.nextLine();
			Scanner s = new Scanner(stringWord).useDelimiter("*s\ts*");
			Word _word = new Word();
			_word.setWord_target(s.next());
			_word.setWord_explain(s.next());
			myDictionary.listWord.add(_word);
		}
	}
	
	/**
	 * 
	 * 
	 */
	public void dictionaryLookup() {
		String a = "";
		System.out.println("Ban hay nhap tu muon tra: ");
		Scanner scan = new Scanner(System.in);
		a = scan.nextLine();
		for(Word i : myDictionary.listWord) {
			if(i.getWord_target().equals(a)) {
				System.out.println(a + "  mean :" + i.getWord_explain());
			}
		}
	}
	
	public void insertWord() throws FileNotFoundException,IOException {
		
		
	}
	
}
