// Last updated: 6/18/2026, 12:00:25 PM
class Solution {
    public double angleClock(int hour, int minutes) {
        return ((720 - (((((hour<<6) - (hour<<2) - (minutes<<4) + (minutes<<2) + minutes) ^ (((hour<<6) - (hour<<2) - (minutes<<4) + (minutes<<2) + minutes) >> 31)) - (((hour<<6) - (hour<<2) - (minutes<<4) + (minutes<<2) + minutes) >> 31)) % 720)) + ((((((((hour<<6) - (hour<<2) - (minutes<<4) + (minutes<<2) + minutes) ^ (((hour<<6) - (hour<<2) - (minutes<<4) + (minutes<<2) + minutes) >> 31)) - (((hour<<6) - (hour<<2) - (minutes<<4) + (minutes<<2) + minutes) >> 31)) % 720)<<1) - 720) & ((((((((hour<<6) - (hour<<2) - (minutes<<4) + (minutes<<2) + minutes) ^ (((hour<<6) - (hour<<2) - (minutes<<4) + (minutes<<2) + minutes) >> 31)) - (((hour<<6) - (hour<<2) - (minutes<<4) + (minutes<<2) + minutes) >> 31)) % 720)<<1) - 720) >> 31))) / 2.0;
    }
}