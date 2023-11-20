package smile;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.time.LocalDateTime;

/**
 * BaseTest
 *
 * @author xps
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BaseTest {

    @Before
    public void beforeTest() {
        System.out.println("test begin. time [][][][] " + LocalDateTime.now());
    }


    @After
    public void afterTest() {
        System.out.println("test end.   time [][][][] " + LocalDateTime.now());
    }

}
