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
    public int romanToInt(String s) {
        int last = Roman.M.value();
        int res = 0;

        for(char curr : s.toCharArray()) {
            if(curr == 'M') {
                if(last == Roman.M.value()) res += Roman.M.value();
                else res += Roman.M.value()-(2*last);
                
                last = Roman.M.value();
            } else if(curr == 'D') {
                if(last >= Roman.D.value()) res += Roman.D.value();
                else res += Roman.D.value()-(2*last);
                
                last = Roman.D.value();
            } else if(curr == 'C') {
                if(last >= Roman.C.value()) res += Roman.C.value();
                else res += Roman.C.value()-(2*last);
                
                last = Roman.C.value();
            } else if(curr == 'L') {
                if(last >= Roman.L.value()) res += Roman.L.value();
                else res += Roman.L.value()-(2*last);
                
                last = Roman.L.value();
            } else if(curr == 'X') {
                if(last >= Roman.X.value()) res += Roman.X.value();
                else res += Roman.X.value()-(2*last);
                
                last = Roman.X.value();
            } else if(curr == 'V') {
                if(last >= Roman.V.value()) res += Roman.V.value();
                else res += Roman.V.value()-(2*last);
                
                last = Roman.L.value();
            }  else if(curr == 'I') {
                res += Roman.I.value();
                last = Roman.I.value();
            }
        }

        return res;
    }
}