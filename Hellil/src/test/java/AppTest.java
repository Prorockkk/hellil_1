import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test
    void testArrToList() {
        String[] x = {"1", "2", "3"};
        List<String> list = new ArrayList<String>();
        System.out.println(list);
        App.arrToList(x, list);
        System.out.println(list);
    }

    @org.junit.jupiter.api.Test
    void testFindWords() {
        File file = new File("D://test_1.txt");
        try {
            List<String> list_1 = new ArrayList<String>();
            list_1  = App.findWords(file);
            System.out.println(list_1);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}