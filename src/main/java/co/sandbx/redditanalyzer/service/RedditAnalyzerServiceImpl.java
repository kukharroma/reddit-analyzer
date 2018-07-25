package co.sandbx.redditanalyzer.service;

import co.sandbx.redditanalyzer.adapter.reddit.RedditAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedditAnalyzerServiceImpl implements RedditAnalyzerService{

    private @Autowired RedditAdapter redditAdapter;


    public void analyzeQuestion(String questionId) {

    }
}
