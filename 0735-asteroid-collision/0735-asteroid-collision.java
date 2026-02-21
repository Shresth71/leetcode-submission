class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < asteroids.length; i++) {
            boolean alive = true;
            while (!st.isEmpty() && asteroids[i] < 0 && st.peek() > 0 && alive) {
                
                int top=st.peek();
                if(Math.abs(top)<Math.abs(asteroids[i])){
                    st.pop();
                }
                else if(Math.abs( top)==Math.abs(asteroids[i])){
                    st.pop();
                    alive=false;
                }
                else{
                    alive=false;
                }
            }
            if(alive){
                st.push(asteroids[i]);
            }
        }
        int ans[]=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.peek();
            st.pop();
        }
        return ans;

    }
}