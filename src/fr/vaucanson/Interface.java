package fr.vaucanson;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Interface extends JFrame implements KeyListener
{
	private static Map<String, Integer> requests;
	private static final long serialVersionUID = 7231194594050358481L;
	private static final int VERSION = 1, stepSliderSpeed = 250;
	private static JFrame frame;
	private static Hashtable<Integer,JLabel> labelTableOrientation, labelTableSustentation, labelTableSpeed;
	private static JSlider sliderSpeed, sliderOrientation, sliderSustentation;
	private static JPanel panelSliderSpeed, panelTextSpeed, panelSpeed, panelSliderOrientation, panelTextOrientation, panelOrientation, panelSliderSustentation, panelTextSustentation, panelSustentation;
	private static JLabel labelSpeed, labelOrientation, labelSustentation;

	synchronized public static void addToSend(final String key, final int value)
	{
		Main.logger.log(Level.FINEST, "Changing " + key + " to " + value);
		requests.put(key, value);
	}

	public Interface()
	{
		requests = new HashMap<String, Integer>();
		requests.put("or", 5);
		requests.put("vi", 0);
		requests.put("st", 0);
		labelTableOrientation = new Hashtable<Integer,JLabel>();
		labelTableOrientation.put(0, new JLabel("Gauche"));
		labelTableOrientation.put(1, new JLabel("Devant"));
		labelTableOrientation.put(2, new JLabel("Droite"));
		labelTableSustentation = new Hashtable<Integer,JLabel>();
		labelTableSustentation.put(0, new JLabel("OFF"));
		labelTableSustentation.put(1, new JLabel("ON"));
		labelTableSpeed = new Hashtable<Integer,JLabel>();
		labelTableSpeed.put(0, new JLabel("0"));
		labelTableSpeed.put(4612, new JLabel("4612"));
		labelTableSpeed.put(9225, new JLabel("9225"));
		frame = new JFrame("Controleur de l'a\351roglisseur v" + VERSION);
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(570, 200));
		frame.setResizable(true);
		frame.setAlwaysOnTop(true);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.addWindowListener(new WindowListener()
		{
			@Override
			public void windowActivated(final WindowEvent e)
			{
			}

			@Override
			public void windowClosed(final WindowEvent e)
			{
			}

			@Override
			public void windowClosing(final WindowEvent e)
			{
				frame.dispose();
			}

			@Override
			public void windowDeactivated(final WindowEvent e)
			{
			}

			@Override
			public void windowDeiconified(final WindowEvent e)
			{
			}

			@Override
			public void windowIconified(final WindowEvent e)
			{
			}

			@Override
			public void windowOpened(final WindowEvent e)
			{
			}
		});
		panelSliderSpeed = new JPanel();
		panelSliderSpeed.setLayout(new BorderLayout());
		panelSliderSpeed.setPreferredSize(new Dimension(500, 30));
		panelSliderSpeed.setFocusable(false);
		panelSliderOrientation = new JPanel();
		panelSliderOrientation.setLayout(new BorderLayout());
		panelSliderOrientation.setPreferredSize(new Dimension(500, 30));
		panelSliderOrientation.setFocusable(false);
		panelSliderSustentation = new JPanel();
		panelSliderSustentation.setLayout(new BorderLayout());
		panelSliderSustentation.setPreferredSize(new Dimension(500, 30));
		panelSliderSustentation.setFocusable(false);
		panelSpeed = new JPanel();
		panelSpeed.setLayout(new BorderLayout());
		panelSpeed.setPreferredSize(new Dimension(570, 66));
		panelSpeed.setFocusable(false);
		panelOrientation = new JPanel();
		panelOrientation.setLayout(new BorderLayout());
		panelOrientation.setPreferredSize(new Dimension(570, 66));
		panelOrientation.setFocusable(false);
		panelSustentation = new JPanel();
		panelSustentation.setLayout(new BorderLayout());
		panelSustentation.setPreferredSize(new Dimension(570, 66));
		panelSustentation.setFocusable(false);
		panelTextSpeed = new JPanel();
		panelTextSpeed.setLayout(new BorderLayout());
		panelTextSpeed.setBackground(Color.GREEN);
		panelTextSpeed.setPreferredSize(new Dimension(50, 5));
		panelTextSpeed.setFocusable(false);
		panelTextOrientation = new JPanel();
		panelTextOrientation.setLayout(new BorderLayout());
		panelTextOrientation.setBackground(Color.GREEN);
		panelTextOrientation.setPreferredSize(new Dimension(50, 5));
		panelTextOrientation.setFocusable(false);
		panelTextSustentation = new JPanel();
		panelTextSustentation.setLayout(new BorderLayout());
		panelTextSustentation.setBackground(Color.RED);
		panelTextSustentation.setPreferredSize(new Dimension(50, 5));
		panelTextSustentation.setFocusable(false);
		labelSpeed = new JLabel();
		labelSpeed.setBackground(Color.GRAY);
		labelSpeed.setText("0");
		labelSpeed.setFocusable(false);
		labelOrientation = new JLabel();
		labelOrientation.setBackground(Color.GRAY);
		labelOrientation.setText("Devant");
		labelOrientation.setFocusable(false);
		labelSustentation = new JLabel();
		labelSustentation.setBackground(Color.GRAY);
		labelSustentation.setText("OFF");
		labelSustentation.setFocusable(false);
		sliderSpeed = new JSlider();
		sliderSpeed.setValue(0);
		sliderSpeed.setMaximum(9225);
		sliderSpeed.setLabelTable(labelTableSpeed);
		sliderSpeed.setPaintLabels(true);
		sliderSpeed.setFocusable(false);;
		sliderSpeed.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(final ChangeEvent arg0)
			{
				addToSend("vi", sliderSpeed.getValue());
				labelSpeed.setText(String.valueOf(sliderSpeed.getValue()));
			}
		});
		sliderOrientation = new JSlider();
		sliderOrientation.setValue(1);
		sliderOrientation.setMaximum(2);
		sliderOrientation.setLabelTable(labelTableOrientation);
		sliderOrientation.setPaintLabels(true);
		sliderOrientation.setFocusable(false);
		sliderOrientation.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(final ChangeEvent arg0)
			{
				addToSend("or", sliderOrientation.getValue());
				switch(sliderOrientation.getValue())
				{
				case 0:
					labelOrientation.setText("Gauche");
					break;
				case 1:
					labelOrientation.setText("Devant");
					break;
				case 2:
					labelOrientation.setText("Droite");
					break;
				}
			}
		});
		sliderSustentation = new JSlider();
		sliderSustentation.setValue(0);
		sliderSustentation.setMaximum(1);
		sliderSustentation.setLabelTable(labelTableSustentation);
		sliderSustentation.setPaintLabels(true);
		sliderSustentation.setFocusable(false);
		sliderSustentation.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(final ChangeEvent arg0)
			{
				addToSend("st", sliderSustentation.getValue());
				switch(sliderSustentation.getValue())
				{
				case 0:
					labelSustentation.setText("OFF");
					panelTextSustentation.setBackground(Color.RED);
					break;
				case 1:
					labelSustentation.setText("ON");
					panelTextSustentation.setBackground(Color.GREEN);
					break;
				}
			}
		});
		panelSliderSpeed.add(sliderSpeed);
		panelTextSpeed.add(labelSpeed);
		panelSpeed.add(panelSliderSpeed, BorderLayout.WEST);
		panelSpeed.add(panelTextSpeed, BorderLayout.EAST);
		panelSliderOrientation.add(sliderOrientation);
		panelTextOrientation.add(labelOrientation);
		panelOrientation.add(panelSliderOrientation, BorderLayout.WEST);
		panelOrientation.add(panelTextOrientation, BorderLayout.EAST);
		panelSliderSustentation.add(sliderSustentation);
		panelTextSustentation.add(labelSustentation);
		panelSustentation.add(panelSliderSustentation, BorderLayout.WEST);
		panelSustentation.add(panelTextSustentation, BorderLayout.EAST);
		frame.add(panelSpeed, BorderLayout.NORTH);
		frame.add(panelOrientation, BorderLayout.CENTER);
		frame.add(panelSustentation, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}

	public static Map<String, Integer> getRequests()
	{
		return requests;
	}

	public static void setRequests(Map<String, Integer> requests)
	{
		Interface.requests = requests;
	}

	@Override
    public void keyPressed(KeyEvent e)
    {
		//System.out.println(e.getExtendedKeyCode());
		if(e.getExtendedKeyCode() == 37)
		{
			if(sliderOrientation.getValue() > 0)
			{
				sliderOrientation.setValue(sliderOrientation.getValue() - 1);
				addToSend("or", sliderOrientation.getValue());
				switch(sliderOrientation.getValue())
				{
				case 0:
					labelOrientation.setText("Gauche");
					break;
				case 1:
					labelOrientation.setText("Devant");
					break;
				case 2:
					labelOrientation.setText("Droite");
					break;
				}
			}
		}
		else if(e.getExtendedKeyCode() == 39)
		{
			if(sliderOrientation.getValue() < 2)
			{
				sliderOrientation.setValue(sliderOrientation.getValue() + 1);
				addToSend("or", sliderOrientation.getValue());
				switch(sliderOrientation.getValue())
				{
				case 0:
					labelOrientation.setText("Gauche");
					break;
				case 1:
					labelOrientation.setText("Devant");
					break;
				case 2:
					labelOrientation.setText("Droite");
					break;
				}
			}
		}
		else if(e.getExtendedKeyCode() == 38)
		{
			sliderSpeed.setValue(sliderSpeed.getValue() < (9225 - stepSliderSpeed) ? sliderSpeed.getValue() + stepSliderSpeed : 9225);
			labelSpeed.setText(String.valueOf(sliderSpeed.getValue()));
			addToSend("or", sliderOrientation.getValue());
		}
		else if(e.getExtendedKeyCode() == 40)
		{
			sliderSpeed.setValue(sliderSpeed.getValue() >= stepSliderSpeed ? sliderSpeed.getValue() - stepSliderSpeed : 0);
			labelSpeed.setText(String.valueOf(sliderSpeed.getValue()));
			addToSend("or", sliderOrientation.getValue());
		}
		else if(e.getExtendedKeyCode() == 17)
		{
			sliderSustentation.setValue(sliderSustentation.getValue() == 0 ? 1 : 0);
			addToSend("st", sliderSustentation.getValue());
			switch(sliderSustentation.getValue())
			{
			case 0:
				labelSustentation.setText("OFF");
				panelTextSustentation.setBackground(Color.RED);
				break;
			case 1:
				labelSustentation.setText("ON");
				panelTextSustentation.setBackground(Color.GREEN);
				break;
			}
		}
    }
	    

	@Override
    public void keyReleased(KeyEvent e){}

	@Override
    public void keyTyped(KeyEvent e){}
}