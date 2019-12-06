package com.sinhro.mentorapp.API;

import android.os.Build;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

/**
 * VK API sample implementation for Java 8.
 * @see https://github.com/liosha2007/vkontakte-api
 * @author liosha2007
 * @author aNNiMON
 */
public final class VkApi {
    private static final String API_VERSION = "5.21";

    private static final String AUTH_URL = "https://oauth.vk.com/authorize"
            + "?client_id={APP_ID}"
            + "&scope={PERMISSIONS}"
            + "&redirect_uri={REDIRECT_URI}"
            + "&display={DISPLAY}"
            + "&v={API_VERSION}"
            + "&response_type=token";

    private static final String API_REQUEST = "https://api.vk.com/method/{METHOD_NAME}"
            + "?{PARAMETERS}"
            + "&access_token={ACCESS_TOKEN}"
            + "&v=" + API_VERSION;

    public static VkApi with(String appId, String accessToken) throws IOException {
        return new VkApi(appId, accessToken);
    }

    private final String accessToken;

    public VkApi(String appId, String accessToken) throws IOException {
        this.accessToken = accessToken;
        if (accessToken == null || accessToken.isEmpty()) {
            auth(appId);
            throw new Error("Need access token");
        }
    }

     public String auth(String appId) throws IOException {
        String reqUrl = AUTH_URL
                .replace("{APP_ID}", appId)
                .replace("{PERMISSIONS}", "photos")
                .replace("{REDIRECT_URI}", "m.vk.com")
                .replace("{DISPLAY}", "page")
                .replace("{API_VERSION}", API_VERSION);
         System.out.println(reqUrl);
        invokeApi(reqUrl);
       return reqUrl;
    }

    public String getDialogs() throws IOException {
        return invokeApi("messages.getDialogs", null);
    }

    public String getHistory(String userId, int offset, int count, boolean rev) throws IOException {
        return invokeApi("messages.getHistory", Params.create()
                .add("user_id", userId)
                .add("offset", String.valueOf(offset))
                .add("count", String.valueOf(count))
                .add("rev", rev ? "1" : "0"));
    }

    public String getAlbums(String userId) throws IOException {
        return invokeApi("photos.getAlbums", Params.create()
                .add("owner_id", userId)
                .add("photo_sizes", "1")
                .add("thumb_src", "1"));
    }

    private String invokeApi(String method, Params params) throws IOException {
         String parameters="";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            parameters = (params == null) ? "" : params.build();
        }
        String reqUrl = API_REQUEST
                .replace("{METHOD_NAME}", method)
                .replace("{ACCESS_TOKEN}", accessToken)
                .replace("{PARAMETERS}&", parameters);
        return invokeApi(reqUrl);
    }

    public static String invokeApi(String requestUrl) throws IOException {
        final StringBuilder result = new StringBuilder();
        final URL url = new URL(requestUrl);
        System.out.println(url);
        new AsyncTask().execute(url);

        return result.toString();
    }



    private static class Params {

        public static Params create() {
            return new Params();
        }

        private final HashMap<String, String> params;

        private Params() {
            params = new HashMap<>();
        }

        public Params add(String key, String value) {
            params.put(key, value);
            return this;
        }

        public String build() {
            if (params.isEmpty()) return "";
            final StringBuilder result = new StringBuilder();
            params.keySet().forEach(key ->
                    result.append(key).append('=').append(params.get(key)).append('&')
            );
            return result.toString();
        }
    }
}