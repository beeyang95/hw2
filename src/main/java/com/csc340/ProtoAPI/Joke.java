package com.csc340.ProtoAPI;

import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Joke {

    @GetMapping("/randomjoke")
    public Object getJoke() {
        String url = "https://official-joke-api.appspot.com/random_joke";
        RestTemplate restTemplate = new RestTemplate();
        Object jSonQuote = restTemplate.getForObject(url, Object.class);

        //Print the whole response to console.
        String quote = restTemplate.getForObject(url, String.class);
        //Parse out the most important info from the response.
        
        JSONObject jo = new JSONObject(quote);
        System.out.println(jo.toString());
        
        String Setup = jo.getString("setup");
        System.out.println(Setup);
        
        String punchLine = jo.getString("punchline");
        
        System.out.println(punchLine);

        return jSonQuote;
    }
}

