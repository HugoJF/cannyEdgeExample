package cannyEdgeExample;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class ParameterInterface extends JFrame {

	private JPanel contentPane;
	private JSlider blurSlider;
	private JSlider lowThresholdSlider;
	private JSlider highThresholdSlider;

	public float getBlurValue() {
		return (float) blurSlider.getValue() / (float) blurSlider.getMaximum();
	}
	
	public float getLowThresValue() {
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParameterInterface frame = new ParameterInterface(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param main
	 */
	public ParameterInterface(final Main main) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 232, 235);
		setLocation(getX() + 500, getY());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		blurSlider = new JSlider();
		blurSlider.setMaximum(1000);
		blurSlider.setBounds(10, 11, 200, 23);
		contentPane.add(blurSlider);

		lowThresholdSlider = new JSlider();
		lowThresholdSlider.setMaximum(1000);
		lowThresholdSlider.setBounds(10, 70, 200, 23);
		contentPane.add(lowThresholdSlider);

		highThresholdSlider = new JSlider();
		highThresholdSlider.setMaximum(1000);
		highThresholdSlider.setBounds(10, 129, 200, 23);
		contentPane.add(highThresholdSlider);

		JLabel blurLabel = new JLabel("Blur");
		blurLabel.setHorizontalAlignment(SwingConstants.CENTER);
		blurLabel.setBounds(88, 45, 46, 14);
		contentPane.add(blurLabel);

		JLabel lowThresLabel = new JLabel("Low threshold ");
		lowThresLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lowThresLabel.setBounds(76, 104, 70, 14);
		contentPane.add(lowThresLabel);

		JLabel highThresLabel = new JLabel("High threshold");
		highThresLabel.setHorizontalAlignment(SwingConstants.CENTER);
		highThresLabel.setBounds(71, 163, 75, 14);
		contentPane.add(highThresLabel);
	}
}
