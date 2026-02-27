class Solution {
public:
    void bfs(vector<vector<char>>& grid,int i,int j){
        queue <pair<int,int>> q;
        q.push({i,j});
        grid[i][j]=0;
        int dx[4]={1,-1,0,0};
        int dy[4]={0,0,-1,1};
        while(!q.empty()){
            auto [m,n]=q.front();
            q.pop();
            for(int i=0;i<4;i++ ){
                int newx=m+dx[i];
                int newy=n+dy[i];
                if(newx>=0&&newx<grid.size()&& newy>=0&& newy<grid[0].size()&&grid[newx][newy]=='1'){
                    q.push({newx,newy});
                    grid[newx][newy]=0;
                }
            }
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    bfs(grid,i,j);
                }
            }
        }
        return ans;
    }
};