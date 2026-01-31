Bob is stuck in a dungeon and must break n locks, each requiring some amount of energy to break. The required energy for each lock is stored in an array called strength where strength[i] indicates the energy needed to break the ith lock.

To break a lock, Bob uses a sword with the following characteristics:


	The initial energy of the sword is 0.
	The initial factor x by which the energy of the sword increases is 1.
	Every minute, the energy of the sword increases by the current factor x.
	To break the ith lock, the energy of the sword must reach at least strength[i].
	After breaking a lock, the energy of the sword resets to 0, and the factor x increases by a given value k.


Your task is to determine the minimum time in minutes required for Bob to break all n locks and escape the dungeon.

Return the minimum time required for Bob to break all n locks.

 
Example 1:


Input: strength = [3,4,1], k = 1

Output: 4

Explanation:

TimeEnergyxActionUpdated x001Nothing1111Break 3rd Lock2222Nothing2342Break 2nd Lock3433Break 1st Lock3

The locks cannot be broken in less than 4 minutes; thus, the answer is 4.


Example 2:


Input: strength = [2,5,4], k = 2

Output: 5

Explanation:

TimeEnergyxActionUpdated x001Nothing1111Nothing1221Break 1st Lock3333Nothing3463Break 2nd Lock5555Break 3rd Lock7

The locks cannot be broken in less than 5 minutes; thus, the answer is 5.


 
Constraints:


	n == strength.length
	1 <= n <= 8
	1 <= K <= 10
	1 <= strength[i] <= 106

