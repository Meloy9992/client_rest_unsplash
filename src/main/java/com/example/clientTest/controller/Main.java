package com.example.clientTest.controller;

import com.example.clientTest.model.User;
import com.example.clientTest.parseJson.ParseQuery;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import java.util.List;

@Controller
public class Main {

    @PostMapping("/search")
    public String search(@RequestParam String search, Model model) throws IOException, ParseException {
        URL url = new URL("http://localhost:8080/search/" + search);

        URLConnection connection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String input = reader.readLine();
        reader.close();

        List<User> searching = new ParseQuery().getUsers(new ParseQuery().getResults(input));
        System.out.println(searching);

        model.addAttribute("search", searching);
        return "search";
    }

    @GetMapping("/search")
    public String searching( Model model) throws IOException, ParseException {
        return "search";
    }

}
