// Last updated: 6/18/2026, 12:10:39 PM
1class Solution {
2    public double angleClock(int hour, int minutes) {
3        if(hour == 12) hour = 0;
4        double a = hour*30.00 + minutes/2.00;
5        double b = minutes * 6.00; 
6        // System.out.println(a + "  "  +b);
7        double x = Math.abs(a-b);
8        return Math.min(x,360-x);
9
10
11
12        // How to calculate the angle of clock hands
13
14// 1. Angle made by the hour hand
15// Every hour mark is 30 degrees apart (360 / 12 = 30)
16// So for 'hour' hours, the angle is:hour * 30
17
18// The hour hand also moves continuously as minutes pass.
19// In 60 minutes, it moves an additional 30 degrees.
20// Therefore, additional angle due to minutes is:(minute * 30) / 60
21
22// Total angle of hour hand:hourAngle = (hour * 30) + (minute * 30) / 60.0;
23
24
25// 2. Angle made by the minute hand
26// The minute hand completes 360 degrees in 60 minutes.
27// Therefore, it moves:360 / 60 = 6 degrees per minute
28
29// Total angle of minute hand:minuteAngle = minute * 6;
30
31
32// 3. Required angle between the handsangle = Math.abs(hourAngle - minuteAngle);
33
34// Smaller angle between the two handsangle = Math.min(angle, 360 - angle);
35    }
36}