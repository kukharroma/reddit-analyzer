package co.sandbx.redditanalyzer.adapter.reddit;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedditAdapterImpl implements RedditAdapter {

    private @Autowired RedditUrlBuilder redditUrlBuilder;

    @Override
    public void authorize() {

        try {
            Unirest.post("http://httpbin.org/post")
                    .queryString("name", "Mark")
                    .field("last", "Polo")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
