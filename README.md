Instructions for using the API:

1) The endpoint for the API is: https://ffcs-api-production.up.railway.app/home. A post request will have to be sent which will return the possible timetables.

2) The body of the post request must contain the details of the teachers and their slots in a particular format (JSON Format)
   Example of the body of post request:
```
{
    "theoretical": {
        "TOC": {
            "Raghavan": ["B1", "TB1"],
            "Uma": ["B2", "TB2"]
        },
        "CAO": {
            "Srinivas": ["E2", "TE2"],
            "Deepa": ["G1", "TG1"]
        }
    },
    "laboratory": {
        "Python": {
            "Shynu": ["L1", "L2", "L3", "L4"],
            "Uma": ["L14", "L15", "L16", "L17"]
        },
        "OOPS": {
            "Jothish": ["L5", "L6", "L7", "L8"],
            "Thilagavathy": ["L18", "L19", "L20", "L21"]
        }
    },
    "embedded": {
        "AOD": {
            "Raghavendar": [["B2", "TB2"], ["L11", "L12"]],
            "Kuruva": [["F2", "TF2"], ["L23", "L24"]]
        },
        "EEE": {
            "Yuvapriya": [["B1", "TB1"], ["L7", "L8"]],
            "Zakir": [["E2", "TE2"], ["L22", "L23"]]
        }
    }
}
```
The subjects are divided into 3 components theoretical,laboratory and embedded based on the components of the particular subject (theoretical subjects only have theory component, laboratory subjects only have lab component and embedded subjects have both components)

3) The returned value will be a list of JSON objects, each JSON object will represent a particular timetable. The object will contain details for the teachers in the theory, lab and embedded subjects with their respective slots. The object also contains a list of all the teachers in the timetable and all the slots used.

   Sample JSON Object from the output list:

```

    {
        "theory": {
            "CAO": {
                "Srinivas": [
                    "TE2",
                    "E2"
                ]
            },
            "TOC": {
                "Uma": [
                    "B2",
                    "TB2"
                ]
            }
        },
        "lab": {
            "OOPS": {
                "Thilagavathy": [
                    "L18",
                    "L19",
                    "L21",
                    "L20"
                ]
            },
            "Python": {
                "Uma": [
                    "L16",
                    "L15",
                    "L17",
                    "L14"
                ]
            }
        },
        "embedded": {
            "EEE": {
                "Yuvapriya": [
                    [
                        "B1",
                        "TB1"
                    ],
                    [
                        "L7",
                        "L8"
                    ]
                ]
            },
            "AOD": {
                "Kuruva": [
                    [
                        "F2",
                        "TF2"
                    ],
                    [
                        "L23",
                        "L24"
                    ]
                ]
            }
        },
        "teachers": {
            "CAO": [
                "Srinivas"
            ],
            "EEE": [
                "Yuvapriya"
            ],
            "OOPS": [
                "Thilagavathy"
            ],
            "AOD": [
                "Kuruva"
            ],
            "TOC": [
                "Uma"
            ],
            "Python": [
                "Uma"
            ]
        },
        "slots": [
            "TE2",
            "TF2",
            "TB1",
            "TB2",
            "L21",
            "L20",
            "L7",
            "L8",
            "F2",
            "L23",
            "E2",
            "L14",
            "B1",
            "L24",
            "B2",
            "L16",
            "L15",
            "L18",
            "L17",
            "L19"
        ]
    }
    
```


   
