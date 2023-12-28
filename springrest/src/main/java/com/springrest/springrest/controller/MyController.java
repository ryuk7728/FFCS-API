package com.springrest.springrest.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class MyController {
	
	@PostMapping("/home")
	public List<Brute> home(@RequestBody SubjectData subjectData ) {


	        HashMap<String, HashMap<String, HashSet <String>>> theory = new HashMap<>();
	        HashMap<String, HashMap<String, HashSet<String>>> lab = new HashMap<>();
	        HashMap<String, HashMap<String, List<List<String>>>> embedded = new HashMap<>();
	        
	        theory.putAll(subjectData.getTheoretical());
	        lab.putAll(subjectData.getLaboratory());
	        embedded.putAll(subjectData.getEmbedded());

            timetable ob = new timetable(theory,lab,embedded);
	        List<Brute> allComb = ob.bruteForce();
	        return allComb;
	}

}


class SubjectData {
    private HashMap<String, HashMap<String, HashSet<String>>> theoretical;
    private HashMap<String, HashMap<String, HashSet<String>>> laboratory;
    private HashMap<String, HashMap<String, List<List<String>>>> embedded;


    public HashMap<String, HashMap<String, HashSet<String>>> getTheoretical() {
        return theoretical;
    }

    public HashMap<String, HashMap<String, HashSet<String>>> getLaboratory() {
        return laboratory;
    }
    public HashMap<String, HashMap<String, List<List<String>>>> getEmbedded() {
        return embedded;
    }

}


//{
//    "theoretical": {
//        "subject1": {
//            "student1": ["grade1", "grade2"],
//            "student2": ["grade3", "grade4"]
//        },
//        "subject2": {
//            "student1": ["grade5", "grade6"],
//            "student2": ["grade7", "grade8"]
//        }
//    },
//    "laboratory": {
//        "subject3": {
//            "student3": ["grade9", "grade10"],
//            "student4": ["grade11", "grade12"]
//        },
//        "subject4": {
//            "student3": ["grade13", "grade14"],
//            "student4": ["grade15", "grade16"]
//        }
//    },
//
//    "embedded":{
//         "subject5":{
//         "student5":[["A1","A2"],["B1","B2"]],
//         "student6":[["A3","A4"],["B3","B4"]]
//       },
//       "subject6":{
//         "student7":[["A5","A6"],["B7","B8"]],
//         "student8":[["A13","A14"],["B23","B34"]]
//       }
//    }
//}
