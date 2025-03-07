/**

In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Constraints:

1 <= N <= 1000
0 <= trust.length <= 10^4
trust[i].length == 2
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N

**/


/**
Worked on Leetcode : YES
Brute Force appraoch : maintain Indegree and outdegree array 
if any of the node in indegree have indegree N-1 and no out degree then we can say that its jodge.

Time complexity : O(V + E)
Space compelxity : O(V)
**/
class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(N == 1) return 1;
       
        
        HashMap<Integer,Integer> incomingMap = new HashMap();
        HashMap<Integer,Integer> outgoingMap = new HashMap();
        for(int i= 0 ; i<trust.length; i++) {
            int out = trust[i][0];
            int in = trust[i][1];
            incomingMap.put(in, incomingMap.getOrDefault(in,0) +1);
            outgoingMap.put(out, outgoingMap.getOrDefault(out,0) +1);
            
        }
        
        for(Integer id : incomingMap.keySet()) {
            if(incomingMap.get(id) == N-1) {
                if(!outgoingMap.containsKey(id)) {
                    return id;
                }
            }
        }
        
        /
        return -1;
    
    }
}
