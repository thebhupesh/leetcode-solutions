enum Roman {
    I(1),V(5),X(10),L(50),C(100),D(500),M(1000);

    private int val;

    Roman(int val) {
        this.val = val;
    }

    public int value() {
        return val;
    }
}

class Solution {
    private int last;
    private int res;

    private void evaluate(int curr) {
        if(last >= curr) res += curr;
        else res += curr-(2*last);
                
        last = curr;
    }

    public int romanToInt(String s) {
        last = Roman.M.value();
        res = 0;

        for(char curr : s.toCharArray()) {
            if(curr == 'M') evaluate(Roman.M.value());
            else if(curr == 'D') evaluate(Roman.D.value());
            else if(curr == 'C') evaluate(Roman.C.value());
            else if(curr == 'L') evaluate(Roman.L.value());
            else if(curr == 'X') evaluate(Roman.X.value());
            else if(curr == 'V') evaluate(Roman.V.value());
            else if(curr == 'I') evaluate(Roman.I.value());
        }

        return res;
    }
}