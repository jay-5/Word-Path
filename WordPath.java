/**
 * @author Rakith "Jay" Jayewardene
 * raj69
 *  A class named WordPath that tracks the path of adjacent words (if the path exists) from the initial word to the end word.
 */

import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.LinkedList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class WordPath {
  
  // Stores the reader
  private Reader reader;  
  
  /**
   * A method that opens a file, counts the number of lines in the file, and returns the result
   * @param a reader of type Reader 
   * @return result
   */
  public static int numLines(Reader reader) throws IOException {
    BufferedReader br = new BufferedReader(reader);
    int result = 0;
    
    //The while loop continues to count the number of lines in a file until there are no more lines to read
    while (br.readLine() != null) {
      result = result + 1;
    }
    return result;
  }
  
  /**
   * A method that opens a file, gets the number of lines of the file, and creates an ArrayList of that size
   * @param string fileName
   * @return fileArray
   */
  public ArrayList <WordData> makeWordArray(String fileName) throws FileNotFoundException , IOException{
    FileReader readingFile = new FileReader(fileName);
    BufferedReader br = new BufferedReader(readingFile);
    int fileLength = numLines(readingFile);
    ArrayList<WordData> fileArrayList = new ArrayList <WordData>(fileLength);
    
    // The while loop continues to add to the ArrayList until there are no more lines to read in the file
    while (br.readLine() != null) {
      fileArrayList.add(WordData.parseWordData(br.readLine()));
    }
    return fileArrayList;
  }
  
  /**
   * A method that gets the path from the startIndex to the destinationIndex
   * @param startIndex, destinationIndex, and arrayList
   * @return path
   */
  public LinkedList<Integer>  getPath(int startIndex, int destinationIndex, ArrayList<WordData> arrayList) {
    if (startIndex == destinationIndex) {
      LinkedList<Integer>  path = new LinkedList<Integer> ();
      path.add(startIndex);
      return path;
    }
    else  {
      WordData startWord = arrayList.get(startIndex);
      LinkedList<Integer> differByOne =startWord.getList();
      ListIterator <Integer> listIterator = differByOne.listIterator();
      
      // The while loop continues until the listIterator is finished
      while(listIterator.hasNext()) {
        int referenceInteger = listIterator.next();
        if (!arrayList.get(referenceInteger).getBool()) {
          arrayList.get(referenceInteger).setBool(true);
          LinkedList<Integer> path = getPath(referenceInteger, destinationIndex, arrayList);
          if (path != null) {
            path.addFirst(startIndex);
            return path;
          }
        }
      }
      return null;
    }
  }
  
  /**
   * A method that gets the path between two words from the user
   * @param file of type String 
   */
  public void getWordPath(String file) {
    try {
      ArrayList <WordData> wordPath =  makeWordArray(file);
    }
    catch (FileNotFoundException e){
      System.out.println ("FileNotFoundException");
    }
    catch(IOException e){
      System.out.println ("IOException");
    }
    String beginningWord = JOptionPane.showInputDialog(null, "Enter a word"); 
    String endWord = JOptionPane.showInputDialog(null, "Enter another word");
  }
  
  /**
   * The main method
   * @param String args[]
   */
  public static void main(String[] args) throws UnsupportedOperationException, FileNotFoundException, IOException {
    WordPath newPath = new WordPath();
    try {
      while (true) {
        newPath.getWordPath(args[0]);
      }
    }
    catch(UnsupportedOperationException e) {
      System.out.println("File fails to exist");
    }
  }
}