import org.junit.*;
import  static org.junit.Assert.*;
import java.util.LinkedList;

/** 
 * Tests the WordData class
 */
public class WordDataTester {
  
  /** 
   * Tests the setIndex method and the getIndex method
   */
  @Test
  public void setIndexTest() {
    WordData data = WordData.parseWordData("21 cat 5 20 36 38");
    data.setIndex(5);
    assertTrue("Test index getter and setter methods", 5 == data.getIndex());
  }
  /** 
   * Tests the setString method and the getString method
   */
  @Test
  public void setStringTest() {
    WordData data = WordData.parseWordData("21 cat 5 20 36 38");
    data.setString("This will be successful");
    assertEquals("Test String getter and setter methods","This will be successful", data.getString());
  }
  /** 
   * Tests the setBool method and the getBool method
   */
  @Test
  public void setBoolTest() {
    WordData data = WordData.parseWordData("21 cat 5 20 36 38");
    data.setBool(true);
    assertTrue("test 3", data.getBool());
    data.setBool(false);
    assertFalse("test 3", data.getBool());                                                            
  }
  /** 
   * Tests the setList method and the getList method
   */
  @Test
  public void setListTest() {
    WordData data = WordData.parseWordData("21 cat 5 20 36 38");
    LinkedList<Integer> list = new LinkedList<Integer> ();
    data.setList(list);
    assertTrue("Test setList method", data.getList().equals(list));
  }
  /** 
   * Tests the parseWordData method
   */
  @Test
  public void parseWordDataTest() {
    WordData data = WordData.parseWordData("21 cat 5 20 36 38");
    LinkedList<Integer> list = new LinkedList<Integer> ();
    String string = "yes";
    assertTrue("Test getEquals in parseWordData", data.getList().equals(list));
    assertEquals("Test getString in parseWordData","21 cat 5 20 36 38", data.getString());
    assertFalse("Test getBool in parseWordData", data.getBool());
    
  }
}