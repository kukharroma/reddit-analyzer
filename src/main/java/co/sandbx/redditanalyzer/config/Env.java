package co.sandbx.redditanalyzer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Env {

    @Value("${analyzer.reddit.url:}")
    String redditUrl;

    @Value("${analyzer.reddit.clientId:}")
    String clientId;

    @Value("${analyzer.reddit.redirectUrl:}")
    String redirectUrl;

    @Value("${analyzer.reddit.clientSecret:}")
    String clientSecret;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getAuthorizeUrl() {
        return redditUrl + "/authorize?"
                + "client_id=" + clientId
                + "&redirect_uri=" + redirectUrl
                + "&state=" + UUID.randomUUID().toString()
                + "&response_type=code"
                + "&duration=temporary"
                + "&scope=read";
    }

    public String getTokenUrl(String code) {
        return redditUrl + "/access_token?"
                + "grant_type=authorization_code"
                + "&code=" + code
                + "&redirect_uri=" + redirectUrl;
    }
}
