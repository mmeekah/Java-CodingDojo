package com.codingdojo.mika.tries;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");

        System.out.println("Is Prefix valid?");
        System.out.println(trie.isPrefixValid("tri"));      //true
        System.out.println(trie.isPrefixValid("tre"));      //false

        System.out.println("\n*****************************");
        System.out.println("Is Word valid?");
        System.out.println(trie.isWordValid("tri"));        //false
        System.out.println(trie.isWordValid("trie"));       //true

        System.out.println("\n*****************************");
        System.out.println("Print all keys");
        trie.printAllKeys();
    }
}