import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DrawFrame extends JFrame
{

    protected static final long serialVersionUID = 1L;

    protected Controls controlPanel;


    public class Controls extends JPanel
    {
        /**
         * Added to get rid of Eclipse warnings
         */
        protected static final long serialVersionUID = 1L;
        /** free Panel */
        protected JPanel freePanel;
        /** slider Panel */
        protected JPanel sliderPanel;
        /** Action Panel */
        protected JPanel actionPanel;
        
        protected JPanel textPanel;
        

        protected JSlider slider;

        

        
        protected JButton showStation;
        
        protected JButton calculateHD;
        
        protected JButton addStation;


        public Controls()
        {
                        
            // Create a border for the panels
            Border blackline = BorderFactory.createLineBorder(Color.black);
            this.setBorder(blackline);

            // Sub-panels with titles
            freePanel = new JPanel();
            TitledBorder title = new TitledBorder(blackline, "Shape");
            freePanel.setBorder(title);

            sliderPanel = new JPanel();
            title = new TitledBorder(blackline, "Color");
            sliderPanel.setBorder(title);

            actionPanel = new JPanel();
            title = new TitledBorder(blackline, "Actions");
            actionPanel.setBorder(title);

            // Add sub-panels to this panel
            this.setLayout(new GridBagLayout());
            GridBagConstraints layoutConst = new GridBagConstraints();
            layoutConst.gridx = 0;
            layoutConst.gridy = 0;
            layoutConst.insets = new Insets(10, 10, 10, 10);
            this.add(freePanel, layoutConst);

            layoutConst = new GridBagConstraints();
            layoutConst.gridx = 0;
            layoutConst.gridy = 1;
            layoutConst.insets = new Insets(10, 10, 10, 10);
            this.add(sliderPanel, layoutConst);

            layoutConst = new GridBagConstraints();
            layoutConst.gridx = 0;
            layoutConst.gridy = 2;
            layoutConst.insets = new Insets(10, 10, 10, 10);
            this.add(actionPanel, layoutConst);

            slider = new JSlider(0, 4);
            slider.setMinorTickSpacing(1); 
            slider.setMajorTickSpacing(1); 
            slider.setSnapToTicks(true);
            slider.setPaintTicks(true);

            // Layout manager
            freePanel.setLayout(new GridLayout(0, 1));


            sliderPanel.setLayout(new GridLayout(0, 1));
            //add slider
            sliderPanel.add(slider);

            // Add action listener to fill box for editing
            //.addActionListener(new ActionListener()
            slider.addChangeListener(new ChangeListener() {
            	public void stateChanged(ChangeEvent e) {
            		
                }
            });


            // Force the size of the panel to be equal to that of the shapePanel
            sliderPanel.setPreferredSize(freePanel.getPreferredSize());

            ///////////
            // Action Panel
            actionPanel.setLayout(new GridLayout(0, 1));
            showStation = new JButton("Delete");
            calculateHD = new JButton("Edit");
            addStation = new JButton("Random");
            actionPanel.add(showStation);
            actionPanel.add(calculateHD);
            actionPanel.add(addStation);

            // Set up undo behavior
            showStation.addActionListener(new ActionListener()
            {
                
                public void actionPerformed(ActionEvent e)
                {
                    
                }
            });
            calculateHD.addActionListener(new ActionListener()
            {
                
                @Override
                public void actionPerformed(ActionEvent e)
                {
                	
                }
            });
            addStation.addActionListener(new ActionListener()
            {
                
                @Override
                public void actionPerformed(ActionEvent e)
                {
                	
                }
                });
            

        }

        /**
         * Return action panel of the control panel.
         * 
         * @return The control panel's action panel.
         */
        public JPanel getActionPanel()
        {
            return actionPanel;
        }

    }

    public DrawFrame()
    {
        // set title of frame
        super("Meso Stations");
       
        controlPanel = new Controls();

        //Layout the components
        this.setLayout(new BorderLayout());
//        this.add(textPanel, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.EAST);

        // Set size and location
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //closing
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Make visible
        this.setVisible(true);

    }

    public static void main(String[] args)
    {
        DrawFrame frame = new DrawFrame();
        // Added to make WebCat happy
        frame.isActive();
    }

    public Controls getControlPanel()
    {
        return controlPanel;
    }

}
