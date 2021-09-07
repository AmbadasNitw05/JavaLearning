package my.learning.leetcode.array;

import java.util.Arrays;

public class MinSessions {
    int res;
    int maxSessionTime;
    int[] tasks;
    int[] sessions;
    public int minSessions(int[] tasks, int sessionTime) {
	    reverseSort(tasks);
        this.res = tasks.length;
        this.maxSessionTime = sessionTime;
        this.tasks = tasks;
        this.sessions = new int[tasks.length];
        dfs(0, 0);
        return res;
    }
    
    private void dfs(int taskID, int sessionCount) {
        if (sessionCount > res) return; //prune, if we didn't use prune, it will be 2200ms, if lucky you get ac
        if (taskID == tasks.length) {
            res = Math.min(res, sessionCount);
            return;
        }
        for (int i = 0; i < sessionCount; i++)
            if (sessions[i] + tasks[taskID] <= maxSessionTime) { //put task into old session bucket
                sessions[i] += tasks[taskID];
                dfs(taskID + 1, sessionCount);
                sessions[i] -= tasks[taskID];
            }
        sessions[sessionCount] += tasks[taskID]; //put task into new empty session bucket
        dfs(taskID + 1, sessionCount + 1);
        sessions[sessionCount] -= tasks[taskID];
    }
	
	//optional, it just speed up from 68ms to 1ms
	private void reverseSort(int[] tasks) {
        Arrays.sort(tasks);
        int[] a = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++)
            a[i] = tasks[tasks.length - 1 - i];
        for (int i = 0; i < tasks.length; i++) 
            tasks[i] = a[i];
    }
	
	public static void main(String[] args) {
		System.out.println(new MinSessions().minSessions(new int[] {1,2,3}, 5));
	}
}