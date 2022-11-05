package unit_test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.driver_manager.DriverManager;

import java.io.IOException;
import java.nio.file.Path;

public class LoadingTest {

    public static DriverManager driverManager;

    @BeforeClass
    public static void setDriver() {
        driverManager = null;
        try {
            driverManager = new DriverManager(
                    "localhost",
                    9940,
                    Path.of("").toAbsolutePath() + "/generate_load_density_driver_win.exe",
                    "windows"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void afterTest() {
        driverManager.quit();
    }

    @Test
    public void testLoading(){
        driverManager.loadTest.loadingTestWithUser("get", "http://httpbin.org/get", 1000, 10, 10);
    }

}
