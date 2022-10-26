package bind.util;

import utils.driver_manager.DriverManager;

public class Util {

    private final DriverManager driverManager;

    public Util(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void generateHtml() {
        driverManager.sendCommand(
                "[[\"generate_html\"]]"
        );
    }

    public void generateHtml(String htmlName) {
        driverManager.sendCommand(
                String.format("[[\"generate_html\", {\"html_name\": \"%s\"}]]", htmlName)
        );
    }

}
