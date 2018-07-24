package co.sandbx.redditanalyzer.adapter.reddit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedditUrlBuilder {

    @Value("${analyzer.reddit.url}")
    private String baseUrl;

    @Value("${analyzer.reddit.clientSecret}")
    private String clientSecret;

    private static final String authorize = "?requestType=getCurrency&code=";

    public String getAuthorizeUrl() {
        return "";
    }

}
