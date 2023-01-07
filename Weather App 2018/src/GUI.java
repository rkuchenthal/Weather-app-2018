import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.program.Program;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends Program
 {
    public JTextField enterZip;
    private GCanvas canvas = new GCanvas();



    public GUI()
    {
        start();
        setSize(300, 350);
    }

    public void init()
    {
        canvas = new GCanvas();
        add(canvas);

        setTitle("Weather Checker");

        JLabel zipLabel = new JLabel("Enter Zip Code");

        enterZip = new JTextField();

        JButton goButton = new JButton("Go");
        JButton clearButton = new JButton("Clear");

        canvas.add(zipLabel, 40, 20);
        canvas.add(enterZip, 20, 50);
        enterZip.setSize(150, 20);

        canvas.add(goButton, 20, 90);
        canvas.add(clearButton, 120, 90);

        addActionListeners();
    }

    public void actionPerformed(ActionEvent e)
    {
        String what = e.getActionCommand();
        Bitly b = new Bitly(enterZip.getText());

        JLabel temp1 = new JLabel(b.getTemp());
        JLabel ConditionsI = new JLabel(b.getConditions());
        JLabel location = new JLabel(b.getCity());



        if (what.equals("Go")) {

              canvas.removeAll();

      // new SecondFrame();
            add(canvas);
            setTitle("Current");

           /* if (b.getTime().charAt(18) <= '0' && b.getTime().charAt(19) > '7' && b.getTime().charAt(18) == '1' && b.getTime().charAt(19) < '9')
            {
                canvas.setBackground(Color.BLACK);
                canvas.add(ConditionsI, 20, 10);
                ConditionsI.setForeground(Color.WHITE);
                canvas.add(temp1, 60, 10);
                temp1.setForeground(Color.WHITE);
                GImage condition = new GImage(b.getIcon());
                canvas.add(condition, 20, 30);
                GImage logo = new GImage("https://www.wunderground.com/logos/images/wundergroundLogo_4c_rev.jpg");
                canvas.add(logo, 20, 200);
            }
             else if (b.getTime().charAt(18) <= '0' && b.getTime().charAt(19) <= '7' || b.getTime().charAt(18) == '1' && b.getTime().charAt(19) <= '9' && b.getTime().charAt(18) == '2' && b.getTime().charAt(19) <= '4')
             {
                canvas.setBackground(Color.CYAN);
                canvas.add(ConditionsI, 20, 10);
                canvas.add(location, 75, 10);
                canvas.add(temp1, 60, 10);
                temp1.setForeground(Color.WHITE);
                GImage condition = new GImage(b.getIcon());
                canvas.add(condition, 20, 30);
                GImage logo = new GImage("https://www.wunderground.com/logos/images/wundergroundLogo_4c_rev.jpg");
                canvas.add(logo, 20, 200);
             }
             else
            {*/
                canvas.setBackground(Color.GRAY);
                canvas.add(ConditionsI, 20, 60);
                canvas.add(location, 20, 10);
                canvas.add(temp1, 20, 40);

                GImage condition = new GImage(b.getIcon());
                canvas.add(condition, 12, 80);
                GImage logo = new GImage("https://www.wunderground.com/logos/images/wundergroundLogo_4c_rev.jpg");
                canvas.add(logo, 20, 150);
           // }
        }

        else if (what.equals("Clear"))
        {
            enterZip.setText(" ");
        }
    }

    public static void main(String [] args)
    {
        GUI g = new GUI();
    }
 }