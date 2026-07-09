// Last updated: 7/9/2026, 5:16:52 PM
class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour == 12) hour = 0;
        double a = hour*30.00 + minutes/2.00;
        double b = minutes * 6.00; 
        // System.out.println(a + "  "  +b);
        double x = Math.abs(a-b);
        return Math.min(x,360-x);



        // How to calculate the angle of clock hands

// 1. Angle made by the hour hand
// Every hour mark is 30 degrees apart (360 / 12 = 30)
// So for 'hour' hours, the angle is:hour * 30

// The hour hand also moves continuously as minutes pass.
// In 60 minutes, it moves an additional 30 degrees.
// Therefore, additional angle due to minutes is:(minute * 30) / 60

// Total angle of hour hand:hourAngle = (hour * 30) + (minute * 30) / 60.0;


// 2. Angle made by the minute hand
// The minute hand completes 360 degrees in 60 minutes.
// Therefore, it moves:360 / 60 = 6 degrees per minute

// Total angle of minute hand:minuteAngle = minute * 6;


// 3. Required angle between the handsangle = Math.abs(hourAngle - minuteAngle);

// Smaller angle between the two handsangle = Math.min(angle, 360 - angle);
    }
}