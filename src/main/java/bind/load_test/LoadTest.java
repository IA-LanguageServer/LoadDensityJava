package bind.load_test;

import utils.driver_manager.DriverManager;

public class LoadTest {

    private final DriverManager driverManager;

    /**
     *  use driverManager to init class
     * @param driverManager driver manager that manage driver
     */
    public LoadTest(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    /**
     *
     * @param requestMethod: http method [GET, HEAD, POST, PUT, DELETE, PATCH, OPTIONS]
     * @param requestUrl: http or https url we want to test it
     * @param userCount: how many user will spawn
     * @param spawnRate: one sec spawn user rate
     * @param testTime: (if not set will make test run forever)
     * @return server response
     */
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
