package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TodoController {

    private final AtomicLong counter = new AtomicLong();
    private final URL path = TodoController.class.getResource("todoDB");
    private final String filePath = "todoDB";
    BufferedReader br;

    @GetMapping("/todo")
    public ArrayList<Todo> getTodos() throws IOException {
        System.out.println("dsa");
        ArrayList<Todo> todos = new ArrayList<>();

        try {
            File file = new File(TodoController.class.getClassLoader().getResource("todoDB")
                    .getPath());
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                todos.add(new Todo(Long.parseLong(attributes[0]), attributes[1], attributes[2]));
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("File Not Found");
        }
        //vcs

        Todo todo = new Todo(1, "Hello", "World");
        return todos;
    }


}
