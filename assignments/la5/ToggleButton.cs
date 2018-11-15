/* This is the C# port of the LA5 ToggleButton Java class 
    
    @Author: Jaime Guevara
    @Class: CS-354
 */

// Declare a delegate that can be used later
delegate void eventListener();

 class ToggleButton : Button, EventHandler {
     private string label1, label2;

     public ToggleButton(string label1, string label2) {
         base(label1);
         this.label1 = label1;
         this.label2 = label2;
         eventListener listener = new eventListener(actionPerformed);
     }

     public void actionPerformed() {
         string s = label1;
         label1 = label2;
         label2 = s;
         setText(label1);
     }
 }