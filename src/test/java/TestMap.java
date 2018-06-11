import java.util.HashMap;
import java.util.Map;

/**
 * @author:wtw
 * @date:2018/6/11
 */
public class TestMap {
  public static void main(String[] args) {
    Map map = new HashMap()
    {
      {
        put("1","1");
        put("2","2");
        put("3","3");
      }
    };
    synchronized (TestMap.class){
      ClassLoader c = Thread.currentThread().getContextClassLoader();
      System.out.println(map);
      c = TestMap.class.getClassLoader();
      map.remove(c);
      System.out.println(map);
    }

  }
}
