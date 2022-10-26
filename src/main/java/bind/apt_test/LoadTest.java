package bind.apt_test;

import utils.driver_manager.DriverManager;

public class LoadTest {

    private final DriverManager driverManager;

    public LoadTest(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public String loadingTestWithUser(String requestMethod, String requestUrl,
                                       int userCount, int spawnRate, int testTime) {
        return this.driverManager.sendCommand(
                String.format("[[\"loading_test_with_user\", " +
                                "{{" +
                                "\"request_method\": \"%s\", " +
                                "\"requestUrl\": \"%s\"," +
                                "}," +
                                "\"user_count\": %d," +
                                "\"spawn_rate\": %d," +
                                "\"test_time\": %d," +
                                "}]]",
                        requestMethod, requestUrl, userCount, spawnRate, testTime)
        );
    }

}
