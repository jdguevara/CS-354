/* This is the C# port of the LA5 ToggleButton Java class 
    
    @Author: Jaime Guevara
    @Class: CS-354
 */
using System;

 class ToggleButton : Button, EventHandler {
     private string label1, label2;

     public ToggleButton(string label1, string label2) {
         base(label1);
         this.label1 = label1;
         this.label2 = label2;
         this.actionPerformed += OnActionPerformed;
     }

     public event EventHandler actionPerformed;

     protected virtual void OnActionPerformed(EventArgs e) {
         string s = label1;
         label1 = label2;
         label2 = s;
         this.setText(label1);
     }
 }