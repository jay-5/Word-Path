/**
 * @author Rakith "Jay" Jayewardene
 * raj69
 * Establishes a class named "WordData" that collects data from a file of words. 
 */

import java.util.LinkedList;
import java.util.Scanner;

public class WordData {
  
  // stores an index
  private int index; 
  
  // stores a string
  private String string; 
  
  // stores a boolean
  private boolean bool;    
  
  // stores a LinkedList
  private LinkedList<Integer> list;    
  
  /**
   * This method retrieves the index
   * @return index
   */
  public int getIndex() {
    return index;
  }
  
  /**
   * This method sets the index of a WordData object in list
   * @param index 
   */
  public void setIndex(int index) {
    this.index = index;
  }
  
  /**
   * This methid retrieves the String 
   * @return string
   */
  public String getString() {
    return string;
  }
  
  /**
   * This method sets the String
   * @param string
   */
  public void setString(String string) {
    this.string = string;
  }
  
  /**
   * This method retrieves the boolean
   * @return bool of type Boolean
   */
  public boolean getBool() {
    return bool;
  }
  
  /**
   * This method sets the boolean
   * @param a single boolean
   */
  public void setBool(boolean bool) {
    this.bool = bool;
  }
  
  /**
   * This method retrieves the list
   * @return list
   */
  public LinkedList<Integer> getList() {
    return list;
  }
  
  /**
   * This method sets the list
   * @param LinkedList<Integer>
   */
  public void setList(LinkedList<Integer> list) {
    this.list = list;
  }
  
  /**
   * A method that parses through a WordIndex file and sets the string, boolean, and list
   * @param stringInput of the WordIndex file form
   * @return a WordData object named "return"
   */
  public static WordData parseWordData(String wordIndexFile) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    Scanner scanner = new Scanner(wordIndexFile);
    scanner.next();
    while (scanner.hasNextInt()) {
      Integer thisIndex = new Integer(scanner.nextInt());
      list.add(thisIndex);
    }
    WordData result = new WordData();
    result.setString(wordIndexFile);
    result.setBool(false);
    result.setList(list);
    return result;
  }
}

