package dailyleetcode;

import java.util.Arrays;
import java.util.Map;

import recur.Sorted;

// April - 20th

public class RabbitCount {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 0, 0, 2 ,0,4};

        System.out.println(count(arr));

    }

    public static int count(int[] answers){
        Arrays.sort(answers);
        int res = 0, count = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 0) {
                res++;
            } else if (i == 0 || answers[i] != answers[i - 1] || count == 0) {
                res += answers[i] + 1;
                count = answers[i];
            } else {
                count--;
            }
        }
        return res;
    }
}

////
//No i didnt got this logic fully
//
//
//ChatGPT said:
//Awesome — let’s slow this down and I’ll explain this code line by line with a dry run and visuals. No rush, we’ll nail this together.
//
//📌 Problem Recap:
//Each rabbit says how many other rabbits have the same color as them.
//We need to compute the minimum number of rabbits in the forest.
//
//Example:
//
//java
//        Copy
//Edit
//answers = [1, 1, 2]
//Two rabbits say "1" → group size = 1+1 = 2
//
//One rabbit says "2" → group size = 2+1 = 3
//
//Total rabbits needed: 2 + 3 = 5
//
//        📌 Your Code (Restated)
//java
//        Copy
//Edit
//Arrays.sort(answers);
//        int res = 0, count = 0;
//
//for (int i = 0; i < answers.length; i++) {
//        if (answers[i] == 0) {
//res++;
//        } else if (i == 0 || answers[i] != answers[i - 1] || count == 0) {
//res += answers[i] + 1;
//count = answers[i];
//        } else {
//count--;
//        }
//        }
//        return res;
//📌 What’s happening here?
//        📍 1️⃣ Sort the array
//Why?
//        👉 So that all same answers (like all 1s) are grouped together.
//
//Example:
//
//java
//        Copy
//Edit
//Input:  [1, 0, 1, 2]
//Sorted: [0, 1, 1, 2]
//        📍 2️⃣ Initialize
//        java
//Copy
//        Edit
//int res = 0;    // total rabbits needed
//int count = 0;  // how many more rabbits can fit in this current group
//📍 3️⃣ Loop through each answer
//📌 Case A — if rabbit says 0
//java
//        Copy
//Edit
//if (answers[i] == 0)
//res++;
//        👉 No group needed, it’s alone.
//
//        📌 Case B — if it’s a new group start
//java
//        Copy
//Edit
//else if (i == 0 || answers[i] != answers[i - 1] || count == 0)
//        👉 If:
//
//first rabbit
//
//or current answer ≠ previous rabbit’s answer (new group)
//
//or current group is full (count == 0)
//
//Then:
//
//java
//        Copy
//Edit
//res += answers[i] + 1; // group size
//count = answers[i];    // how many spots left for this group
//        📌 Case C — if still adding to an ongoing group
//java
//        Copy
//Edit
//else
//count--;
//        👉 One rabbit added to the existing group → reduce count by 1.
//
//        📌 🔍 Dry Run Example:
//answers = [1, 1, 2]
//
//After sort:
//
//java
//        Copy
//Edit
//[1, 1, 2]
//
//i	answers[i]	res	count	Action
//0	1	0	0	new group → res=2, count=1
//        1	1	2	1	existing group → count=0
//        2	2	2	0	new group → res=5, count=2
//Final res = 5 ✅
//
//        📌 Intuition
//This logic treats the sorted array as grouped buckets.
//Whenever a new number comes or current bucket is full (count == 0), it starts a new group by adding (answers[i] + 1) rabbits (because one rabbit says there are that many others).
//
//        📣 TL;DR
//Sort first so same answers are together
//
//Use count to track how many rabbits can still be added to a current group
//
//If no rabbits left for a group (or number changes), start a new group
//
//Super clever way to manage groups without a Map
//
//Do you want me to visualize this as a table for a bigger example too? I can chart it out for you. Want that? 👌✨
