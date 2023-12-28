package com.springrest.springrest.controller;


import java.util.*;
public class timetable {
    Scanner in = new Scanner(System.in);

    int numsub=0; //Count number of subjects that user chooses
    String[] tstartm = {"A1","F1","D1","TB1","TG1"};
    String[] tstartt = {"B1","G1","E1","TC1","TAA1"};
    String [] tstartw = {"C1","A1","F1"};
    String [] tstartth = {"D1","B1","G1","TE1","TCC1"};
    String[] tstartf = {"E1","C1","TA1","TF1","TD1"};
    String[] tendm = {"A2","F2","D2","TB2","TG2"};
    String[] tendt = {"B2","G2","E2","TC2","TAA2"};
    String [] tendw = {"C2","A2","F2","TD2","TBB2"};
    String [] tendth = {"D2","B2","G2","TE2","TCC2"};
    String[] tendf = {"E2","C2","TA2","TF2","TDD2"};

    String[] lstartm = {"L1","L3","L5"};
    String[] lstartt = {"L7", "L9", "L11"};
    String [] lstartw = {"L13", "L15", "L17"};
    String [] lstartth = {"L19", "L21","L23"};
    String[] lstartf = {"L25", "L27", "L29"};
    String[] lendm = {"L31", "L33", "L35"};
    String[] lendt = {"L37", "L39", "L41"};
    String [] lendw = {"L43", "L45", "L47"};
    String [] lendth = {"L49", "L51", "L53"};
    String[] lendf = {"L55", "L57", "L59"};

    List<String[]> lstart = new ArrayList<>();

    List<String[]> tend = new ArrayList<>();

    List<String[]> tstart = new ArrayList<>();

    List<String[]> lend = new ArrayList<>();



    public HashMap<String, HashMap<String, HashSet<String>>> theory = new HashMap<>();
    public HashMap<String, HashMap<String, HashSet<String>>> lab = new HashMap<>();
    public HashMap<String, HashMap<String, List<List<String>>>> embedded = new HashMap<>();

    public HashMap<String, HashMap<String, HashSet<String>>> theory2=new HashMap<>();

    public HashMap<String, HashMap<String, HashSet<String>>> lab2=new HashMap<>();

    public HashMap<String, HashMap<String, List<List<String>>>> embedded2=new HashMap<>();

    public HashMap<String, HashMap<String, HashSet<String>>> theory3=new HashMap<>();

    public HashMap<String, HashMap<String, HashSet<String>>> lab3=new HashMap<>();

    public HashMap<String, HashMap<String, List<List<String>>>> embedded3=new HashMap<>();

    List<Brute> tcombinations = new ArrayList<>();


    List<String> teachers1 = new ArrayList<>();



    public timetable(HashMap<String, HashMap<String, HashSet<String>>> theory1, HashMap<String, HashMap<String, HashSet<String>>> lab1, HashMap<String, HashMap<String, List<List<String>>>> embedded1) {
        this.theory = theory1;
        this.lab = lab1;
        this.embedded = embedded1;
        lstart.add(lstartm);
        lstart.add(lstartt);
        lstart.add(lstartw);
        lstart.add(lstartth);
        lstart.add(lstartf);

        tend.add(tendm);
        tend.add(tendt);
        tend.add(tendw);
        tend.add(tendth);
        tend.add(tendf);

        tstart.add(tstartm);
        tstart.add(tstartt);
        tstart.add(tstartw);
        tstart.add(tstartth);
        tstart.add(tstartf);

        lend.add(lendm);
        lend.add(lendt);
        lend.add(lendw);
        lend.add(lendth);
        lend.add(lendf);


    }




    public List<Brute> bruteForce() {
    	theory3.putAll(theory);
        lab3.putAll(lab);
        embedded3.putAll(embedded);
        List<HashMap<String, HashMap<String, HashSet<String>>>> combinations = generateCombinations(theory3);
        List<HashMap<String, HashMap<String, HashSet<String>>>> combinations1 = generateCombinations(lab3);
        List<HashMap<String, HashMap<String, List<List<String>>>>> combinations2 = generateCombinations1(embedded3);
        HashSet<String> t = new HashSet<>();
        HashSet<String> l = new HashSet<>();
        HashSet<String> e = new HashSet<>();
        HashMap<String,HashSet<String>> teachers = new HashMap<>();
        HashSet<String> slots = new HashSet<>();


        for (HashMap<String, HashMap<String, HashSet<String>>> combination : combinations) {
            t.clear();
            for (Map.Entry<String, HashMap<String, HashSet<String>>> get : combination.entrySet()) {
                for (Map.Entry<String, HashSet<String>> get1 : get.getValue().entrySet()) {
                    for (String x :
                            get1.getValue()) {
                        t.add(x);
                    }
                }

            }

            for (HashMap<String, HashMap<String, HashSet<String>>> combination1 : combinations1) {
                l.clear();
                for (Map.Entry<String, HashMap<String, HashSet<String>>> get2 : combination1.entrySet()) {
                    for (Map.Entry<String, HashSet<String>> get3 : get2.getValue().entrySet()) {
                        for (String y :
                                get3.getValue()) {
                            l.add(y);
                        }
                    }
                }


                        for (HashMap<String, HashMap<String, List<List<String>>>> combination2 : combinations2) {
                            e.clear();
                            boolean k1 = false;
                            for (Map.Entry<String, HashMap<String, List<List<String>>>> get4 : combination2.entrySet()) {
                                for (Map.Entry<String, List<List<String>>> get5 : get4.getValue().entrySet()) {
                                    for (List<String> x1 :
                                            get5.getValue()) {
                                        for (String x2 :
                                                x1) {
                                            if (t.contains(x2) || l.contains(x2)) {
                                                k1 = true;
                                                e.clear();
                                                break;
                                            }
                                        }
                                        if (k1) {
                                            break;
                                        }
                                    }
                                    if (k1) {
                                        break;
                                    }

                                }
                                if (k1) {
                                    break;
                                }
                            }
                            if (!k1) {
                                teachers = findTeachers(combination, combination1, combination2);
                                slots = findSlots(combination, combination1, combination2);
                                Brute ob = new Brute(combination, combination1, combination2,teachers,slots);
                                tcombinations.add(ob);
                            }
                        }




            }


        }
        return tcombinations;
    }

    private HashSet<String> findSlots(HashMap<String, HashMap<String, HashSet<String>>> combination, HashMap<String, HashMap<String, HashSet<String>>> combination1, HashMap<String, HashMap<String, List<List<String>>>> combination2) {
        HashSet<String> slots = new HashSet<>();
        for (Map.Entry<String, HashMap<String, HashSet<String>>> get : combination.entrySet()) {
            for (Map.Entry<String, HashSet<String>> get1 : get.getValue().entrySet()) {
                slots.addAll(get1.getValue());
            }
        }
        for (Map.Entry<String, HashMap<String, HashSet<String>>> entry : combination1.entrySet()) {
            for (Map.Entry<String, HashSet<String>> innerEntry : entry.getValue().entrySet()) {
                slots.addAll(innerEntry.getValue());
            }
        }
        for (Map.Entry<String, HashMap<String, List<List<String>>>> subjectEntry : combination2.entrySet()) {
            for (Map.Entry<String, List<List<String>>> teacherEntry : subjectEntry.getValue().entrySet()) {
                for(List<String> x:teacherEntry.getValue()){
                    slots.addAll(x);
                }
            }
        }
        return slots;
    }

    private HashMap<String,HashSet<String>> findTeachers(HashMap<String, HashMap<String, HashSet<String>>> combination, HashMap<String, HashMap<String, HashSet<String>>> combination1, HashMap<String, HashMap<String, List<List<String>>>> combination2) {
        HashMap<String,HashSet<String>> teachers = new HashMap<>();
        for (Map.Entry<String, HashMap<String, HashSet<String>>> get : combination.entrySet()) {
            teachers.put(get.getKey(),new HashSet<>());
            for (Map.Entry<String, HashSet<String>> get1 : get.getValue().entrySet()) {
                teachers.get(get.getKey()).add(get1.getKey());
            }
        }
        for (Map.Entry<String, HashMap<String, HashSet<String>>> entry : combination1.entrySet()) {
            teachers.put(entry.getKey(),new HashSet<>());
            for (Map.Entry<String, HashSet<String>> innerEntry : entry.getValue().entrySet()) {
                teachers.get(entry.getKey()).add(innerEntry.getKey());
            }
        }
        for (Map.Entry<String, HashMap<String, List<List<String>>>> subjectEntry : combination2.entrySet()) {
            teachers.put(subjectEntry.getKey(),new HashSet<>());
            for (Map.Entry<String, List<List<String>>> teacherEntry : subjectEntry.getValue().entrySet()) {
                teachers.get(subjectEntry.getKey()).add(teacherEntry.getKey());
            }
        }
        return teachers;
    }

    private static List<HashMap<String, HashMap<String, HashSet<String>>>> generateCombinations(HashMap<String, HashMap<String, HashSet<String>>> theoryT) {
        List<HashMap<String, HashMap<String, HashSet<String>>>> combinations = new ArrayList<>();
        generateCombinationsHelper(theoryT, new ArrayList<>(), combinations);
        return combinations;
    }
    private static List<HashMap<String, HashMap<String, List<List<String>>>>> generateCombinations1(HashMap<String, HashMap<String, List<List<String>>>> theoryT) {
        List<HashMap<String, HashMap<String, List<List<String>>>>> combinations = new ArrayList<>();
        generateCombinationsHelper1(theoryT, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinationsHelper(HashMap<String, HashMap<String, HashSet<String>>> theoryT,
                                                   List<SubjectTeacherSlot> currentCombination,
                                                   List<HashMap<String, HashMap<String, HashSet<String>>>> combinations) {
        // If all subjects have been covered, add the current combination to the list of combinations
        if (currentCombination.size() == theoryT.size()) {
            combinations.add(new HashMap<>());
            for (SubjectTeacherSlot comb1: currentCombination) {
                if(!combinations.get(combinations.size()-1).containsKey(comb1.subject)){
                    combinations.get(combinations.size()-1).put(comb1.subject,new HashMap<>());
                }
                combinations.get(combinations.size()-1).get(comb1.subject).put(comb1.teacher, comb1.slot);
            }
            return;
        }

        // Get the next subject
        String[] subjects = theoryT.keySet().toArray(new String[0]);
        String subject = subjects[currentCombination.size()];

        // Get the teachers for the current subject
        HashMap<String, HashSet<String>> teachers = theoryT.get(subject);

        // Iterate over the teachers and their slots for the current subject
        for (Map.Entry<String, HashSet<String>> entry : teachers.entrySet()) {
            String teacher = entry.getKey();
            HashSet<String> slots = entry.getValue();

            // For each slot of the current teacher, check if it clashes with any of the existing slots in the current combination

            if (!isSlotTaken(currentCombination, slots)) {
                // If no clash, create a new SubjectTeacherSlot object with the subject, teacher, and slot and add it to the current combination
                SubjectTeacherSlot sts = new SubjectTeacherSlot(subject, teacher, slots);
                currentCombination.add(sts);
                // Call itself recursively with the updated current combination
                generateCombinationsHelper(theoryT, currentCombination, combinations);
                // Remove the SubjectTeacherSlot object from the current combination
                currentCombination.remove(sts);
            }


        }
    }
    private static void generateCombinationsHelper1(HashMap<String, HashMap<String, List<List<String>>>> theoryT,
                                                   List<SubjectTeacherSlotEmbedded> currentCombination,
                                                   List<HashMap<String, HashMap<String, List<List<String>>>>> combinations) {
        // If all subjects have been covered, add the current combination to the list of combinations
        if (currentCombination.size() == theoryT.size()) {
            combinations.add(new HashMap<>());
            for (SubjectTeacherSlotEmbedded comb1: currentCombination) {
                if(!combinations.get(combinations.size()-1).containsKey(comb1.subject)){
                    combinations.get(combinations.size()-1).put(comb1.subject,new HashMap<>());
                }
                combinations.get(combinations.size()-1).get(comb1.subject).put(comb1.teacher, comb1.slot);
            }
            return;
        }

        // Get the next subject
        String[] subjects = theoryT.keySet().toArray(new String[0]);
        String subject = subjects[currentCombination.size()];

        // Get the teachers for the current subject
        HashMap<String, List<List<String>>> teachers = theoryT.get(subject);

        // Iterate over the teachers and their slots for the current subject
        for (Map.Entry<String, List<List<String>>> entry : teachers.entrySet()) {
            String teacher = entry.getKey();
            List<List<String>> slots = entry.getValue();

            // For each slot of the current teacher, check if it clashes with any of the existing slots in the current combination

            if (!isSlotTaken1(currentCombination, slots)) {
                // If no clash, create a new SubjectTeacherSlot object with the subject, teacher, and slot and add it to the current combination
                SubjectTeacherSlotEmbedded sts = new SubjectTeacherSlotEmbedded(subject, teacher, slots);
                currentCombination.add(sts);
                // Call itself recursively with the updated current combination
                generateCombinationsHelper1(theoryT, currentCombination, combinations);
                // Remove the SubjectTeacherSlot object from the current combination
                currentCombination.remove(sts);
            }


        }
    }
    private static boolean isSlotTaken(List<SubjectTeacherSlot> currentCombination, HashSet<String> slot) {
        for (SubjectTeacherSlot sts : currentCombination) {
            for(String x : sts.slot){
                if (slot.contains(x)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSlotTaken1(List<SubjectTeacherSlotEmbedded> currentCombination, List<List<String>> slot) {
        boolean k = false;
        for (SubjectTeacherSlotEmbedded sts : currentCombination) {
            for(List<String> x : sts.slot){
                if(!k) {
                    for (String y: x)
                          {
                        if (slot.get(0).contains(y)){
                            return true;
                        }

                    }

                }
                else{
                    for (String y: x)
                    {
                        if (slot.get(1).contains(y)){
                            return true;
                        }

                    }
                }
                k=!k;
            }
        }
        return false;
    }







}


