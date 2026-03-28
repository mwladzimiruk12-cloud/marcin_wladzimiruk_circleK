import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tuKlasy.apiResponse;


public class firstTests {

    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = {"fast"})
    public void aFastTest() {
        System.out.println("Fast test");
//        apiResponse apiResponse= new apiResponse.setBody("XDF");
    }

    @Test(groups = {"slow"})
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}
