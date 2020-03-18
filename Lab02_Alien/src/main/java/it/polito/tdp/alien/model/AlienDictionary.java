package it.polito.tdp.alien.model;

import java.util.TreeMap;

public class AlienDictionary {
	
	private TreeMap<String, Word> words = new TreeMap<String, Word>();
	
	public TreeMap<String, Word> getWords() {
		return words;
	}

	public void addWord(String alienWord, String translation) {
		if(controlloFormato(alienWord) && controlloFormato(translation)) {
			if(words.containsKey(alienWord)) {
				words.get(alienWord).setTranslation(translation);
			}
			else {
				Word w = new Word(alienWord, translation);
				words.put(alienWord, w);
			}
		}
	}
	
	public String translate(String alienWord) {
		if(words.containsKey(alienWord))
			return words.get(alienWord).toString();
		else
			return "Il dizionario non contiene la parola inserita\n";
	}
	
	public boolean controlloFormato(String s) {
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c))
				return false;
		}
		return true;
	}

}
