class Solution {

    public String getHint(String secret, String guess) {
        
        int[] digits = new int[10];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<secret.length(); i++){

            if(secret.charAt(i) == guess.charAt(i)) set.add(i);
            else digits[secret.charAt(i)-'0']++;
        }
        int y = 0;
        for(int i=0; i<guess.length(); i++){

            if(set.contains(i)) continue;
            if(digits[guess.charAt(i)-'0'] > 0) y++;
            digits[guess.charAt(i)-'0']--;
        }
        return ""+set.size()+"A"+y+"B";
    }
}
