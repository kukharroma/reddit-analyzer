class AnalyzerApi{

    analyze(questionId){
        $.ajax({
            type: "POST",
            url: "analyze/reddit/" + questionId,
            success: function () {

            },
            error:function(){

            }
        });
    }
}

let analyzerApi = new AnalyzerApi();