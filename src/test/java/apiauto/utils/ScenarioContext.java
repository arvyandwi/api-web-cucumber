package apiauto.utils;

public class ScenarioContext {

    private static String storedId;

    public static String getStoredId() {
        return storedId;
    }

    public static void setStoredId(String id) {
        storedId = id;
    }
}
