import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

/**
 * @Author: Linker
 * @Date: 2023/4/24 9:43
 * @Description:
 */
@SpringBootTest
public class Test {

    @org.junit.Test
    public void test() {
        File file = new File("xx.jpg");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(File.separator);
        System.out.println(file.getTotalSpace());
        System.out.println(file.getFreeSpace());
        System.out.println(file.getUsableSpace());

    }
}
