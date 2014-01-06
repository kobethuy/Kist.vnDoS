package vn.kist.postdos;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import java.awt.Color;

public class PostGui {

	private JFrame frmPostdos;
	private JPanel targetHost;
	private JPanel optionPane;
	private JScrollPane scroll;
	private JLabel lblTitle;
	private JTextArea console;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel proxySettings;
	private JPanel paramSettings;
	private JRadioButton randomParameters;
	private JRadioButton customParameters;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmChangelog;
	private static boolean ranParam;
	private static String param;
	private JPanel threadPane;
	private JLabel lblAttackType;
	private JComboBox attackType;
	private JPanel controlPanel;
	private JRadioButton rdioSimple;
	private JSlider simpleSlider;
	private JRadioButton rdioAdvance;
	private JSpinner advSpin;
	private JSpinner timeSpin;
	private JLabel lblSleepTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostGui window = new PostGui();
					window.frmPostdos.setVisible(true);
					PostThread th = new PostThread(149, "localhost/xampp/welcome.php");
					th.initThread();
					
					
					/*
					 * Temporary!!!
					 */
					ranParam = true;
					
					th.startThread();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PostGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPostdos = new JFrame();
		frmPostdos.setTitle("KistvnDoS");
		frmPostdos.setBounds(100, 100, 800, 600);
		frmPostdos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPostdos.getContentPane().setLayout(null);
		
		lblTitle = new JLabel("KistvnDoS by Kobe Thuy");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblTitle.setBounds(1, 23, 800, 44);
		frmPostdos.getContentPane().add(lblTitle);
		
		console = new JTextArea();
		console.setBounds(10, 253, 281, 298);
		console.setLineWrap(true);
		console.setEditable(false);
		
		scroll = new JScrollPane(console);
		scroll.setBounds(10, 251, 300, 300);
		frmPostdos.getContentPane().add(scroll);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		targetHost = new JPanel();
		targetHost.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Target Host", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		targetHost.setBounds(11, 78, 763, 174);
		frmPostdos.getContentPane().add(targetHost);
		targetHost.setLayout(null);
		
		JLabel lblHostname = new JLabel("Hostname:");
		lblHostname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHostname.setBounds(10, 30, 67, 28);
		targetHost.add(lblHostname);
		
		textField = new JTextField();
		textField.setBounds(131, 36, 250, 20);
		targetHost.add(textField);
		textField.setColumns(10);
		
		JLabel lblHttp = new JLabel("http://");
		lblHttp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHttp.setBounds(87, 37, 46, 14);
		targetHost.add(lblHttp);
		
		proxySettings = new JPanel();
		proxySettings.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Proxy Settings (To be added)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		proxySettings.setBounds(10, 69, 371, 94);
		targetHost.add(proxySettings);
		proxySettings.setLayout(null);
		
		JLabel lblProxyHost = new JLabel("Proxy Host:");
		lblProxyHost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProxyHost.setBounds(10, 20, 74, 20);
		proxySettings.add(lblProxyHost);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(87, 19, 274, 20);
		proxySettings.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPort.setBounds(10, 51, 46, 14);
		proxySettings.add(lblPort);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(87, 50, 50, 20);
		proxySettings.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setEnabled(false);
		btnApply.setBounds(272, 50, 89, 23);
		proxySettings.add(btnApply);
		
		paramSettings = new JPanel();
		paramSettings.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Parameters", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paramSettings.setBounds(391, 69, 362, 94);
		targetHost.add(paramSettings);
		paramSettings.setLayout(null);
		
		randomParameters = new JRadioButton("Random Parameters");
		randomParameters.setSelected(true);
		randomParameters.setBounds(6, 15, 162, 20);
		paramSettings.add(randomParameters);
		
		customParameters = new JRadioButton("Custom Parameters");
		customParameters.setBounds(170, 15, 170, 20);
		paramSettings.add(customParameters);
		
		JTextArea cusParam = new JTextArea();
		
		JScrollPane paramScroll = new JScrollPane(cusParam);
		paramScroll.setSize(346, 41);
		paramScroll.setLocation(6, 42);
		paramScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		paramSettings.add(paramScroll);
		
		lblAttackType = new JLabel("Attack Type:");
		lblAttackType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAttackType.setBounds(391, 34, 80, 20);
		targetHost.add(lblAttackType);
		
		attackType = new JComboBox();
		attackType.setBounds(481, 36, 272, 20);
		targetHost.add(attackType);
		
		optionPane = new JPanel();
		optionPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		optionPane.setBounds(320, 251, 454, 300);
		frmPostdos.getContentPane().add(optionPane);
		optionPane.setLayout(null);
		
		threadPane = new JPanel();
		threadPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Threads", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		threadPane.setBounds(10, 25, 434, 200);
		optionPane.add(threadPane);
		threadPane.setLayout(null);
		
		rdioSimple = new JRadioButton("Simple");
		rdioSimple.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdioSimple.setBounds(6, 20, 109, 23);
		threadPane.add(rdioSimple);
		
		simpleSlider = new JSlider();
		simpleSlider.setForeground(Color.BLACK);
		simpleSlider.setPaintLabels(true);
		simpleSlider.setPaintTicks(true);
		simpleSlider.setSnapToTicks(true);
		simpleSlider.setMaximum(5);
		simpleSlider.setFont(new Font("Tahoma", Font.PLAIN, 14));
		simpleSlider.setBounds(6, 50, 208, 40);
		threadPane.add(simpleSlider);
		
		rdioAdvance = new JRadioButton("Advance");
		rdioAdvance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdioAdvance.setBounds(6, 139, 109, 23);
		threadPane.add(rdioAdvance);
		
		advSpin = new JSpinner();
		advSpin.setBounds(10, 169, 204, 20);
		threadPane.add(advSpin);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Time Interval", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(216, 11, 208, 178);
		threadPane.add(panel);
		panel.setLayout(null);
		
		lblSleepTime = new JLabel("Sleep Time:");
		lblSleepTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSleepTime.setBounds(10, 40, 79, 20);
		panel.add(lblSleepTime);
		
		timeSpin = new JSpinner();
		timeSpin.setEnabled(false);
		timeSpin.setBounds(10, 71, 188, 20);
		panel.add(timeSpin);
		
		controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Control Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		controlPanel.setBounds(10, 236, 434, 53);
		optionPane.add(controlPanel);
		controlPanel.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(10, 19, 89, 23);
		controlPanel.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(109, 19, 89, 23);
		controlPanel.add(btnStop);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(335, 19, 89, 23);
		controlPanel.add(btnExit);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(1, 0, 787, 21);
		frmPostdos.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmChangelog = new JMenuItem("Changelog");
		mnHelp.add(mntmChangelog);
		
		mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);

	}

	/**
	 * @return the ranParam
	 */
	public static boolean isRanParam() {
		return ranParam;
	}

	/**
	 * @param ranParam the ranParam to set
	 */
	public static void setRanParam(boolean ranParam) {
		PostGui.ranParam = ranParam;
	}

	/**
	 * @return the param
	 */
	public static String getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public static void setParam(String param) {
		PostGui.param = param;
	}
}
