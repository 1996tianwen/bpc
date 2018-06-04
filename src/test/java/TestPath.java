import com.wtw.bpc.utils.SearchFile;

/**
 * @author:wtw
 * @date:2018/6/1
 */
public class TestPath {
  public static void main(String[] args) throws Exception {
    SearchFile.search(TestPath.class.getClassLoader().getResource("").getPath());
  }
}
