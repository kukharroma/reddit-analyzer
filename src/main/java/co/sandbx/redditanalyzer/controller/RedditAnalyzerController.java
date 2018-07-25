package co.sandbx.redditanalyzer.controller;

import co.sandbx.redditanalyzer.service.RedditAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedditAnalyzerController {

    private @Autowired RedditAnalyzerService redditAnalyzerService;

    @PostMapping("analyze/reddit/{questionId}")
    public void analyzeQuestionId(@PathVariable("questionId") String questionId){

        redditAnalyzerService.analyzeQuestion(questionId);
    }

}
