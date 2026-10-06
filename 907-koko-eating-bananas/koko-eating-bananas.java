class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = 0;
        for(int pile : piles){
            maxSpeed = Math.max(maxSpeed, pile);
        }
        while(minSpeed < maxSpeed){
            int mid = minSpeed + (maxSpeed - minSpeed)/2;

            if(canEat(piles, h, mid)){
                maxSpeed = mid;
            }
            else{
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }
    public boolean canEat(int[] piles, int h, int speed){
        int sum = 0;
        for(int pile : piles){
            sum += (int) Math.ceil((double)pile/speed);
        }
        return sum <= h;
    }
}