/* LightSwitch port of the LA5 Java class of the same name
 * 
 * @Author: Jaime Guevara
 * @Class: CS-354
 */
using System;
using System.Drawing;
using System.Windows.Forms;

 class LightSwitch {

    // These are our private globals
    private ToggleButton button;
    private BinaryCounter counter;

    // Instance of our LightSwitch class
    public LightSwitch() {
        button = new ToggleButton("off", "on");
        counter = new BinaryCounter(0);
        button.click += counter;
        Panel contentPane = new Panel();
        contentPane.Controls.Add(button);
        contentPane.Controls.Add(counter);
        // TODO: Need to finish implementing this part (help: what is C#'s jFrame?)
    }       
 }
