/* This is the C# port of the LA5 BinaryCounter Java class
    
    @Author: Jaime Guevara
    @Class: CS-354
 */

delegate void eventListerner();

 class BinaryCounter : Label, EventHandler {
     
     private int count;

     public BinaryCounter(int count) {
         base(ToString(count));
         this.count = count;
     }

     public void actionPerformed() {
         setText(count++);
     }
 }