package co.sandbx.redditanalyzer.controller;


import co.sandbx.redditanalyzer.config.Env;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class AuthorizeController {

    @Autowired
    private Env env;

    @GetMapping("/authorize")
    public String authorize(@RequestParam(required = false) String state, @RequestParam String code, HttpSession session) {
        if (state != null) {
            session.setAttribute("access_token", getAccessToken(code));
            return "redirect:analyzer";
        } else {
            return "redirect:error";
        }
    }

    private String getAccessToken(String code) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + env.getClientSecret());

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = env.getTokenUrl(code);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        String authJson = response.getBody();

        Map<String, Object> auth = parseJson(authJson);

        return auth.get("access_token").toString();
    }

    private Map<String, Object> parseJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse JSON: " + json);
        }
    }
}