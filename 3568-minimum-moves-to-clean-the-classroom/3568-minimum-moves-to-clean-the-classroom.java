class State {
    private int i;
    private int j;
    private int energy;
    private int litter;
    private int distance;

    public State(int i, int j, int energy, int litter, int distance) {
        this.i = i;
        this.j = j;
        this.energy = energy;
        this.litter = litter;
        this.distance = distance;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getEnergy() {
        return energy;
    }

    public int getLitter() {
        return litter;
    }

    public int getDistance() {
        return distance;
    }
}

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        Deque<State> q = new ArrayDeque<>();
        int[][] litters = new int[m][n];
        int litterCount = 0;

        for(int i=0; i<m; i++) {
            Arrays.fill(litters[i],-1);
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(classroom[i].charAt(j) == 'S') q.offerLast(new State(i,j,energy,0,0));
                else if(classroom[i].charAt(j) == 'L') {
                    litters[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        boolean[][][][] visited = new boolean[m][n][energy+1][1<<litterCount];

        while(!q.isEmpty()) {
            State curr = q.pollFirst();

            int i = curr.getI();
            int j = curr.getJ();
            int currEnergy = curr.getEnergy();
            int litter = curr.getLitter();
            int dist = curr.getDistance();

            if(visited[i][j][currEnergy][litter]) continue;
            visited[i][j][currEnergy][litter] = true;

            char ch = classroom[i].charAt(j);

            if(ch == 'R') currEnergy = energy;
            if(ch == 'L') litter |= 1 << litters[i][j];

            if(litter == (1 << litterCount)-1) return dist;

            currEnergy--;

            if(currEnergy >= 0) {
                if(i>0 && classroom[i-1].charAt(j) != 'X') q.offerLast(new State((i-1),j,currEnergy,litter,dist+1));
                if(j>0 && classroom[i].charAt(j-1) != 'X') q.offerLast(new State(i,(j-1),currEnergy,litter,dist+1));
                if(i+1<m && classroom[i+1].charAt(j) != 'X') q.offerLast(new State((i+1),j,currEnergy,litter,dist+1));
                if(j+1<n && classroom[i].charAt(j+1) != 'X') q.offerLast(new State(i,(j+1),currEnergy,litter,dist+1));
            }
        }

        return -1;
    }
}