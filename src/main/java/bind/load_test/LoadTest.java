package bind.load_test;

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
                                "{\"user_detail_dict\": {" +
                                "\"request_method\": \"%s\", " +
                                "\"request_url\": \"%s\"" +
                                "}," +
                                "\"user_count\": %d," +
                                "\"spawn_rate\": %d," +
                                "\"test_time\": %d," +
                                "\"web_ui_dict\": null" +
                                "}]]",
                        requestMethod, requestUrl, userCount, spawnRate, testTime)
        );
    }

}
