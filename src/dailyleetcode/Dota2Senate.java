package dailyleetcode;

import java.rmi.server.Skeleton;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;

// 06/27/2025
public class Dota2Senate {

    public static void main(String[] args) {
        String senate1 = "RD";
        String senate2 = "RDD";
        String senate3 = "DDRRR";

        System.out.println("Senate \"RD\" winner: " + predictPartyVictory(senate1));
        System.out.println("Senate \"RDD\" winner: " + predictPartyVictory(senate2));
        System.out.println("Senate \"DDRRR\" winner: " + predictPartyVictory(senate3));
    }

    public static String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        // Initialize queues with senator positions
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }

        // Simulate the voting rounds
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();

            if (r < d) {
                radiant.add(r + n);  // Radiant senator bans Dire and goes to next round
            } else {
                dire.add(d + n);     // Dire senator bans Radiant and goes to next round
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

}



//        You're absolutely right in your explanation — this is a clever use of queues and index manipulation to simulate rounds in the Dota2 Senate problem. Let's break down and reinforce the key parts to ensure complete clarity:
//
//        🔁 Problem Summary
//        You are given a string like "RDD" representing senators from two parties:
//
//        'R' = Radiant
//
//'D' = Dire
//        Each round, the first senator gets to ban someone from the opposite party, and the game continues until all senators from one party are banned.
//
//🧠 Core Idea Behind the +n Trick
//        Using two queues:
//
//        java
//                Copy
//        Edit
//        Queue<Integer> radiant = new LinkedList<>();
//        Queue<Integer> dire = new LinkedList<>();
//        Each queue holds the indices of senators.
//
//        By pushing index + n back into the queue after a senator takes action, we:
//
//        Simulate multiple rounds without modifying the original list.
//
//        Preserve the round-robin nature of the game.
//
//        This effectively unfolds the game as:
//
//        mathematica
//                Copy
//        Edit
//0..n-1 → Round 1
//        n..2n-1 → Round 2
//        2n..3n-1 → Round 3
//        ...
//        ✅ How the Comparison Works
//        java
//                Copy
//        Edit
//if (r < d) {
//        radiant.offer(r + n);
//} else {
//        dire.offer(d + n);
//}
//        The senator with the smaller index acts first.
//
//        That senator bans the opponent.
//
//        Then, they're requeued to act in the next round.
//
//        ⚠️ Edge Case Example: "RDD"
//        Initial queues:
//
//        radiant = [0]
//
//        dire = [1, 2]
//
//        🔄 Round 1:
//        r = 0, d = 1 → Radiant acts first
//
//        Radiant bans D(1)
//
//        Requeue Radiant as 0 + 3 = 3
//
//        radiant = [3], dire = [2]
//
//        🔄 Round 2:
//        r = 3, d = 2 → Dire acts first
//
//        Dire bans R(3)
//
//        Requeue Dire as 2 + 3 = 5
//
//        radiant = [], dire = [5] → Radiant is empty
//
//➡️ Dire wins
//
//🧪 Final Code Skeleton in Java
//        java
//        Copy
//                Edit
//        public String predictPartyVictory(String senate) {
//            int n = senate.length();
//            Queue<Integer> radiant = new LinkedList<>();
//            Queue<Integer> dire = new LinkedList<>();
//
//            for (int i = 0; i < n; i++) {
//                if (senate.charAt(i) == 'R') {
//                    radiant.offer(i);
//                } else {
//                    dire.offer(i);
//                }
//            }
//
//            while (!radiant.isEmpty() && !dire.isEmpty()) {
//                int r = radiant.poll();
//                int d = dire.poll();
//
//                if (r < d) {
//                    radiant.offer(r + n);  // Radiant bans Dire
//                } else {
//                    dire.offer(d + n);     // Dire bans Radiant
//                }
//            }
//
//            return radiant.isEmpty() ? "Dire" : "Radiant";
//        }
//🎯 Summary
//+n simulates future turns without a separate data structure.
//
//        Queue ordering naturally resolves turn-taking.
//
//        A clean, elegant O(n) simulation of a complex, multi-round interaction.
//
//        Let me know if you'd like to see a dry-run of a more complex input or a step-by-step debug version.
//
//
//
//
//
//
//
//
//
//        Ask ChatGPT
//        You said:
//        how we got the idea to use +n in the if condition and why we need to use it
//
//
//        ChatGPT said:
//        Great question! The idea of using +n in the Dota2 Senate problem is one of those elegant insights that comes from understanding queue behavior + round-based games. Let me walk you through the intuition, necessity, and why it works so well.
//
//        🔍 Why Do We Need +n?
//        In this game:
//
//        Each senator acts in round-robin order.
//
//        If a senator is not banned, they get to act again in the next round.
//
//        So when a senator survives this round, we need to:
//        ✅ Keep them in the game
//✅ Let them act again after all current senators get their chance
//
//🧠 Key Insight: Simulating Infinite Rounds
//        If we only used their original index, we would lose track of which round they should act in.
//
//        Say we have:
//
//        java
//                Copy
//        Edit
//                senate = "RDD"  // indexes: R(0), D(1), D(2)
//        Suppose:
//
//        R(0) bans D(1)
//
//        R survives and should act again after D(2)
//
//        How do we make sure R doesn’t go again immediately?
//
//        ➕ Using r + n
//        n is the total number of senators in the first round.
//
//        So r + n means: "R will come back in next cycle"
//
//        It ensures order: all current senators get their turn before any repeat actions.
//
//        It creates a virtual timeline:
//
//        mathematica
//                Copy
//        Edit
//        Index:      0    1    2    3    4    5
//        Senators:   R    D    D    R    D    D  ← same people requeued
//        So after R(0) bans D(1), R is put at position 0 + 3 = 3.
//        R acts again after D(2) gets a chance at index 2.
//
//        ✅ Why It Works in the if Condition
//        java
//        Copy
//                Edit
//        int r = radiant.poll();
//        int d = dire.poll();
//
//if (r < d) {
//        radiant.offer(r + n);  // R goes to next round
//} else {
//        dire.offer(d + n);     // D goes to next round
//}
//        Here:
//
//        Whichever index is smaller acts first and bans the other.
//
//        That senator is requeued at index + n to act again in the next round.
//
//        This ensures:
//
//        Correct turn order
//
//        Proper round simulation
//
//        No need for extra bookkeeping like "round number"
//
//        💡 How We Might Arrive at This Approach
//        Let’s say you're solving this problem and start with a basic queue simulation:
//
//        You store indexes of Radiant and Dire senators.
//
//        But quickly you notice: if a senator survives, they should act again after all remaining senators get their turns.
//
//        You might think: “How do I represent that delay?”
//
//        And then the idea hits: just push them to the back of the line — but make sure their index keeps increasing so you can sort them correctly.
//
//        That’s where the +n comes in:
//
//        Acts as a way to push their turn into the future while keeping queue order.
//
//🧪 Simple Visual Summary
//        Round	Radiant Queue	Dire Queue	Action Taken	Requeued
//        Init	[0]	[1, 2]	R(0) bans D(1)	R(3)
//2	[3]	[2]	D(2) bans R(3)	D(5)
//3	[]	[5]	---	Dire wins
//
//🔚 TL;DR
//+n is used to simulate "next round" without extra data structures.
//
//        Ensures fair turn order and proper round simulation.
//
//        Keeps code clean, efficient, and logical.
//
//        Would you like me to show how this logic might break without using +n?



