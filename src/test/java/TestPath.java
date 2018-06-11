import com.wtw.bpc.service.ChainService;
import com.wtw.bpc.utils.SearchFile;

/**
 * @author:wtw
 * @date:2018/6/1
 */
public class TestPath {
  static {
    System.out.println("静态代码块");
  }
  {
    System.out.println("普通代码块");
  }

  public static void main(String[] args) throws Exception {
    //下一步传参
    System.out.println("静态方法");
    System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
  }
}
