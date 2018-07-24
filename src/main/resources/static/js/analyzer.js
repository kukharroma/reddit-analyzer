$("#btnAnalyze").click(function () {
    analyze();
});

function analyze() {
    let url = $("#redditAnswerURL").val();
    let questionId = getQuestionIdFormUrl(url);

    analyzerApi.analyze(questionId);
}

function getQuestionIdFormUrl(url) {
    return url.substring(44, 50);
}


