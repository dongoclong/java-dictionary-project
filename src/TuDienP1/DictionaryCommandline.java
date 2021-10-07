package TuDienP1;

import java.io.FileNotFoundException;

public class DictionaryCommandline {
	
	DictionaryManagement dictionaryManagemment = new DictionaryManagement();
	
	/**
	 * the method use show all word in dictionary
	 */
	public void showAllWord() {
		Dictionary myDictionary = new Dictionary();
		int count = 1;
		System.out.println("No     | English  \t | Vietnamses");
		for(Word i : myDictionary.listWord) {
			System.out.println(count + "      |" + i.getWord_target() + "\t\t | " + i.getWord_explain());
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
		this.showAllWord();
	}
	
	public void dictionaryAdvanced() throws FileNotFoundException {
		dictionaryManagemment.insertFromFile();
		dictionaryManagemment.dictionaryLookup();
		this.showAllWord();
	}
//	public static void main(String []args) {
//		DictionaryCommandline x = new DictionaryCommandline();
//		x.dictionaryBasic();
//	}
}
