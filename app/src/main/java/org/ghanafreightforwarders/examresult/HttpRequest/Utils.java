package org.ghanafreightforwarders.examresult.HttpRequest;

public class Utils {
    private Utils() {}

    public static final String BASE_URL = "http://ghanafreightforwarders.org/";

    public static Services getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(Services.class);
    }
}
