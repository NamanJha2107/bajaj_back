package com.example.demo.controller;

import com.example.demo.model.RequestData;
import com.example.demo.model.ResponseData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bfhl")
public class ApiController {

    @PostMapping
    public ResponseData processData(@RequestBody RequestData requestData) {
        ResponseData responseData = new ResponseData();

        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        String highestLowercase = null;

        for (String item : requestData.getData()) {
            if (item.matches("[0-9]+")) {
                numbers.add(item);
            } else if (item.matches("[a-zA-Z]")) {
                alphabets.add(item);
                if (item.matches("[a-z]") && (highestLowercase == null || item.compareTo(highestLowercase) > 0)) {
                    highestLowercase = item;
                }
            }
        }

        responseData.setSuccess(true);
        responseData.setUserId("john_doe_17091999");
        responseData.setEmail("john@xyz.com");
        responseData.setRollNumber("ABCD123");
        responseData.setNumbers(numbers);
        responseData.setAlphabets(alphabets);
        responseData.setHighestLowercaseAlphabet(highestLowercase == null ? new ArrayList<>() : List.of(highestLowercase));

        return responseData;
    }

    @GetMapping
    public String getOperationCode() {
        return "{\"operation_code\":1}";
    }
}
