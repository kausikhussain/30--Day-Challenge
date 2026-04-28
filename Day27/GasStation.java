/*
Problem: Gas Station
Platform: LeetCode
Topic: Greedy / Array

Approach:
If the total gas is less than the total cost, completing the circuit is impossible.
Otherwise, a solution is guaranteed to exist.
Maintain a current gas level. Iterate through the stations; if at any point the current gas 
drops below zero, it means we can't reach the current station from the starting point. 
Thus, the starting point must be the *next* station, and we reset the current gas to 0.

Time Complexity: O(N) where N is the number of stations.
Space Complexity: O(1)
*/

class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startStation = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            
            currentGas += gas[i] - cost[i];
            
            // If we run out of gas, the starting station must be after this point
            if (currentGas < 0) {
                startStation = i + 1;
                currentGas = 0; // Reset for the new potential start
            }
        }
        
        return totalGas >= totalCost ? startStation : -1;
    }
}
