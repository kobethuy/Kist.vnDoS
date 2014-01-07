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
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSpinner;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PostGui {

	private JFrame frmPostdos;
	private JPanel targetHost;
	private JPanel optionPane;
	private JScrollPane scroll;
	private JLabel lblTitle;
	private JTextField hostName;
	private JTextField proxyHostText;
	private JTextField proxyPort;
	private JPanel proxySettings;
	private JPanel paramSettings;
	private JRadioButton randomParameters;
	private JRadioButton customParameters;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmChangelog;
	private JPanel threadPane;
	private JLabel lblAttackType;
	private JComboBox<?> attackType;
	private JPanel controlPanel;
	private JRadioButton rdioSimple;
	private JSlider simpleSlider;
	private JRadioButton rdioAdvance;
	private JSpinner advSpin;
	private JSpinner timeSpin;
	private JLabel lblSleepTime;
	private JLabel lblHostname;
	private JLabel lblHttp;
	private JLabel lblProxyHost;
	private JLabel lblPort;
	private JButton btnApply;
	private JScrollPane paramScroll;
	private JTextArea cusParam;
	private JPanel timePane;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnExit;
	private JMenu mnFile;
	private JMenuItem mntmExit;
	private JMenuBar menuBar;
	private String[] attackList;
	private static JTextArea console;
	private static boolean ranParam, simple;
	private static String param;
	private static StringBuilder consoleLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					} catch (Exception e) {
						  
					}
					PostGui window = new PostGui();
					window.frmPostdos.setVisible(true);
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
		frmPostdos 			= 			new JFrame();
		lblTitle 			= 			new JLabel("Kist.vnDoS by Kobe Thuy");
		lblHttp 			= 			new JLabel("http://");
		lblHostname 		= 			new JLabel("Hostname:");
		lblProxyHost 		= 			new JLabel("Proxy Host:");
		lblPort 			= 			new JLabel("Port:");
		lblAttackType 		= 			new JLabel("Attack Type:");
		lblSleepTime 		= 			new JLabel("Sleep Time:");
		targetHost 			= 			new JPanel();
		paramSettings 		=			new JPanel();
		optionPane 			= 			new JPanel();
		threadPane 			= 			new JPanel();
		controlPanel 		= 			new JPanel();
		proxySettings 		= 			new JPanel();
		timePane 			= 			new JPanel();
		proxyHostText 		= 			new JTextField();
		hostName 			= 			new JTextField();
		proxyPort 			= 			new JTextField();
		randomParameters 	= 			new JRadioButton("Random Parameters");
		customParameters 	= 			new JRadioButton("Custom Parameters");
		rdioAdvance 		= 			new JRadioButton("Advance");
		rdioSimple 			= 			new JRadioButton("Simple");
		btnApply 			= 			new JButton("Apply");
		btnStart 			= 			new JButton("Start");
		btnStop 			= 			new JButton("Stop");
		btnExit 			= 			new JButton("Exit");
		cusParam 			= 			new JTextArea();
		console 			= 			new JTextArea();
		paramScroll 		= 			new JScrollPane(cusParam);
		scroll 				= 			new JScrollPane(console);
		advSpin 			= 			new JSpinner();
		timeSpin 			= 			new JSpinner();
		menuBar 			= 			new JMenuBar();
		mnFile 				= 			new JMenu("File");
		mnHelp 				= 			new JMenu("Help");
		mntmExit 			= 			new JMenuItem("Exit");
		mntmChangelog 		= 			new JMenuItem("Changelog");
		mntmAbout 			= 			new JMenuItem("About");
		simpleSlider 		= 			new JSlider();
		attackList			=			new String[1];
		
		setAttackList("Slow POST", 0);
		
		attackType 			= 			new JComboBox<Object>(attackList);
		consoleLog 			= 			new StringBuilder();
		
		setSimple(true);
		setRanParam(true);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		if (isRanParam()) {
			randomParameters.setSelected(true);
			cusParam.setEnabled(false);
		}
		
		if (isSimple()) {
			rdioSimple.setSelected(true);
			advSpin.setEnabled(false);
		}
		
		frmPostdos			.setTitle("Kist.vnDoS");
		frmPostdos			.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmPostdos			.setBounds(100, 100, 800, 600);
		lblTitle			.setBounds(1, 23, 800, 44);
		console				.setBounds(10, 253, 281, 298);
		scroll				.setBounds(10, 251, 300, 300);
		targetHost			.setBounds(11, 78, 763, 174);
		lblHostname			.setBounds(10, 30, 67, 28);
		hostName			.setBounds(131, 36, 250, 20);
		lblHttp				.setBounds(87, 37, 46, 14);
		proxySettings		.setBounds(10, 69, 371, 94);
		lblProxyHost		.setBounds(10, 20, 74, 20);
		proxyHostText		.setBounds(87, 19, 274, 20);
		lblPort				.setBounds(10, 51, 46, 14);
		proxyPort			.setBounds(87, 50, 50, 20);
		btnApply			.setBounds(272, 50, 89, 23);
		randomParameters	.setBounds(6, 15, 162, 20);
		paramSettings		.setBounds(391, 69, 362, 94);
		customParameters	.setBounds(170, 15, 170, 20);
		lblAttackType		.setBounds(391, 34, 80, 20);
		attackType			.setBounds(481, 36, 272, 20);
		optionPane			.setBounds(320, 251, 454, 300);
		threadPane			.setBounds(10, 25, 434, 200);
		rdioSimple			.setBounds(6, 20, 109, 23);
		simpleSlider		.setBounds(6, 50, 208, 40);
		advSpin				.setBounds(10, 169, 204, 20);
		rdioAdvance			.setBounds(6, 139, 109, 23);
		timePane			.setBounds(216, 11, 208, 178);
		lblSleepTime		.setBounds(10, 40, 79, 20);
		timeSpin			.setBounds(10, 71, 188, 20);
		controlPanel		.setBounds(10, 236, 434, 53);
		btnStart			.setBounds(10, 19, 89, 23);
		btnStop				.setBounds(109, 19, 89, 23);
		btnExit				.setBounds(335, 19, 89, 23);
		menuBar				.setBounds(1, 0, 787, 21);
		
		
		frmPostdos			.getContentPane().setLayout(null);
		
		
		targetHost			.setLayout(null);
		proxySettings		.setLayout(null);
		paramSettings		.setLayout(null);
		optionPane			.setLayout(null);
		threadPane			.setLayout(null);
		timePane			.setLayout(null);
		controlPanel		.setLayout(null);
		
		lblTitle			.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblTitle			.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHostname			.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHttp				.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProxyHost		.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPort				.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAttackType		.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdioSimple			.setFont(new Font("Tahoma", Font.PLAIN, 14));
		simpleSlider		.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdioAdvance			.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSleepTime		.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		console				.setLineWrap(true);
		console				.setEditable(false);
		
		scroll				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		targetHost			.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Target Host", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		proxySettings		.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Proxy Settings (To be added)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paramSettings		.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Parameters", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		optionPane			.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		threadPane			.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Threads", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		timePane			.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Time Interval", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		controlPanel		.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Control Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		hostName			.setColumns(10);
		proxyHostText		.setColumns(10);
		proxyPort			.setColumns(10);

		proxyHostText		.setEnabled(false);
		proxyPort			.setEnabled(false);
		btnApply			.setEnabled(false);
		timeSpin			.setEnabled(false);

		randomParameters	.setSelected(true);
		paramScroll			.setSize(346, 41);
		paramScroll			.setLocation(6, 42);
		paramScroll			.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		simpleSlider		.setForeground(Color.BLACK);
		simpleSlider		.setPaintLabels(true);
		simpleSlider		.setPaintTicks(true);
		simpleSlider		.setSnapToTicks(true);
		simpleSlider		.setMaximum(5);

		proxySettings		.add(lblPort);
		proxySettings		.add(lblProxyHost);
		proxySettings		.add(proxyHostText);
		proxySettings		.add(proxyPort);
		proxySettings		.add(btnApply);
		paramSettings		.add(paramScroll);
		paramSettings		.add(randomParameters);
		paramSettings		.add(customParameters);
		targetHost			.add(lblHostname);
		targetHost			.add(hostName);
		targetHost			.add(lblHttp);
		targetHost			.add(proxySettings);
		targetHost			.add(paramSettings);
		targetHost			.add(lblAttackType);
		targetHost			.add(attackType);
		threadPane			.add(rdioSimple);
		threadPane			.add(simpleSlider);
		threadPane			.add(rdioAdvance);
		threadPane			.add(advSpin);
		threadPane			.add(timePane);
		timePane			.add(lblSleepTime);
		timePane			.add(timeSpin);
		controlPanel		.add(btnStart);
		controlPanel		.add(btnStop);
		controlPanel		.add(btnExit);
		optionPane			.add(threadPane);
		optionPane			.add(controlPanel);
		mnFile				.add(mntmExit);
		menuBar				.add(mnFile);
		menuBar				.add(mnHelp);
		mnHelp				.add(mntmChangelog);	
		mnHelp				.add(mntmAbout);
		
		frmPostdos.getContentPane().add(menuBar);
		frmPostdos.getContentPane().add(optionPane);
		frmPostdos.getContentPane().add(lblTitle);
		frmPostdos.getContentPane().add(targetHost);
		frmPostdos.getContentPane().add(scroll);

		
		randomParameters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customParameters.setSelected(false);
				cusParam.setEnabled(false);
				setRanParam(true);
			}
		});
		
		customParameters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				randomParameters.setSelected(false);
				cusParam.setEnabled(true);
				setRanParam(false);
			}
		});
		
		rdioSimple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdioAdvance.setSelected(false);
				advSpin.setEnabled(false);
				simpleSlider.setEnabled(true);
				setSimple(true);
			}
		});
		
		rdioAdvance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdioSimple.setSelected(false);
				simpleSlider.setEnabled(false);
				advSpin.setEnabled(true);
				setSimple(false);
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
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
	 * @return the simple
	 */
	public static boolean isSimple() {
		return PostGui.simple;
	}
	
	/**
	 * @param val
	 */
	public static void setSimple(boolean val) {
		PostGui.simple = val;
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
	
	public static StringBuilder getConsoleLog() {
		return PostGui.consoleLog;
	}
	
	public static void setConsoleLog(String text) {
		consoleLog.append(text);
	}
	
	public static void clearConsole() {
		consoleLog.delete(0, consoleLog.length());
	}
	
	public static void setConsole(String text) {
		console.setText(text);
	}

	/**
	 * @return the attackList
	 */
	public String[] getAttackList() {
		return attackList;
	}

	/**
	 * @param attackList the attackList to set
	 */
	public void setAttackList(String attackList, int index) {
		this.attackList[index] = attackList;
	}
}
