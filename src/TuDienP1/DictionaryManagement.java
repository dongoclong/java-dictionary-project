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
	 * use insert list word from dictionares
	 * @throws FileNotFoundException
	 */
	public void insertFromFile() throws FileNotFoundException {
		int idxTarget = 0;
		int idxExplain = 1;
		Scanner scan = new Scanner(new File("dictionaries.txt"));
		while(scan.hasNext()) {
			String stringWord = scan.nextLine();
			String[] parts = stringWord.split("\t");	
			if (parts.length >= 2) {
				Word _word = new Word();
				_word.setWord_target(parts[idxTarget]);
				_word.setWord_explain(parts[idxExplain]);
				myDictionary.listWord.add(_word);
			} else {
				System.out.println("Gia tri co nhieu nghia");
			}
		}
	}
	
	/**
	 * find the word  and show mean
	 */
	public void dictionaryLookup() {
		String a = "";
		System.out.println("Ban hay nhap tu muon tra: ");
		Scanner scan = new Scanner(System.in);
		a = scan.nextLine();
		boolean check  = false;
		for(Word i : myDictionary.listWord) {
			if(i.getWord_target().equals(a)) {
				System.out.println(a + " mean  :" + i.getWord_explain());
				check = true;
				break;
			}
		}
		if(!check) {
			System.out.println("Khong co tu nay trong tu dien, than!");
		}
	}
	
	/**
	 * insert the word from command line
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void insertWord() throws FileNotFoundException,IOException {
		System.out.println("Nhap tu can them vao: ");
		Scanner scan = new Scanner(System.in);
		String stringWord = scan.nextLine();
		boolean check = false;
		for (Word i : Dictionary.listWord) {
			if (i.getWord_target().equalsIgnoreCase(stringWord)) {
				System.out.println("Tu nay da co trong tu dien roi ...");
				check = true;
				break;
			}
		}
		if (!check) {
			System.out.println("Nhap nghia cua tu nay: ");
			String stringExplain = scan.nextLine();
			Dictionary.listWord.add(new Word(stringWord,stringExplain));
			System.out.println("Tu da duoc them vao thanh cong");
		}
	}
	/**
	 * remove word from command line
	 */
	public void removeWord() {
		String word_target;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap tu can xoa: ");
		word_target = scan.nextLine();
		boolean check = false;
		for (Word i : Dictionary.listWord) {
			if (i.getWord_target().equalsIgnoreCase(word_target)) {
				Dictionary.listWord.remove(i);
				check = true;
			}
		}
		if (check) {
			System.out.println("Xoa thanh cong tu trong tu dien");
		} 
		else {
			System.out.println("Khong co tu nay trong tu dien");
		}
	}
	
	/**
	 * edit word from command line 
	 */
	public void editWord() {
		System.out.println("Nhap tu can sua: ");
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		boolean check = false;
		for (Word i : Dictionary.listWord) {
			if (i.getWord_target().equalsIgnoreCase(word)) {
				System.out.println("Nhap tu moi: ");
				String Newtarget = scan.nextLine();
				i.setWord_target(Newtarget);
				System.out.println("Nghia cua tu moi la: ");
				String Neweplain = scan.nextLine();
				i.setWord_explain(Neweplain);
				check = true;
				break;
			}
		}
		if (!check) {
			System.out.println("Tu nay khong co trong tu dien");
		}
	}
	
	public void dictionaryExportToFile() throws FileNotFoundException,IOException {
		FileOutputStream file = new FileOutputStream("dictionaries.txt");
		BufferedOutputStream bfileout = new BufferedOutputStream(file);
		for (Word i : Dictionary.listWord) {
			String line = i.getWord_target() + "\t" + i.getWord_explain();
			bfileout.write(line.getBytes());
			bfileout.write(System.lineSeparator().getBytes());
		}
		bfileout.close();
	}
}
