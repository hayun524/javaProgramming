package functions;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import player.Player;
import weapon.Weapon;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JProgressBar;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_first extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Player p1;
	private Player p2;
	private Player target;
	private Player attacker;
	
	private JLabel hpValue;
	private JProgressBar progressBar_1;
	private JProgressBar MonsterHP;
	private JLabel monsterImageLabel;
	protected Weapon weapon;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_first frame = new UI_first();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_first() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel SteveName = new JLabel("스티브");
		SteveName.setBounds(130, 287, 36, 15);
		contentPane.add(SteveName);
		
		JLabel SteveImage = new JLabel();
		SteveImage.setIcon(new ImageIcon(UI_first.class.getResource("/images/스티브.png")));
		SteveImage.setBounds(30, 12, 213, 290);
		contentPane.add(SteveImage);
		
		JButton attackButton = new JButton("공격하기");
		attackButton.setForeground(SystemColor.desktop);
		attackButton.setBackground(Color.RED);
		attackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//공격버튼 눌리면 실행되어야 할 것 적기
				System.out.println("공격 버튼 눌림!");
				p1.attack(attacker, target, weapon);

				// 공격 후 HP 갱신
				hpValue.setText(Integer.toString(target.getHp()));
				progressBar_1.setValue(target.getHp());
				
			}
		});
		attackButton.setBounds(30, 453, 103, 23);
		attackButton.setHorizontalAlignment(SwingConstants.LEADING);
		contentPane.add(attackButton);
		
		JButton AbilityButton = new JButton("능력 사용");
		AbilityButton.setForeground(Color.WHITE);
		AbilityButton.setBackground(Color.BLUE);
		AbilityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//능력버튼 눌리면 실행되어야할 것 적기
				System.out.println("능력 버튼 눌림!");
				
			}
		});
		AbilityButton.setBounds(156, 453, 103, 23);
		contentPane.add(AbilityButton);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(49, 327, 194, 14);
		contentPane.add(progressBar_1);

		hpValue = new JLabel("0");
        hpValue.setBounds(140, 312, 14, 42);
        contentPane.add(hpValue);
		
		MonsterHP = new JProgressBar();
		MonsterHP.setBounds(376, 327, 229, 14);
		MonsterHP.setValue(100);
		MonsterHP.setStringPainted(true);      
		contentPane.add(hpValue);
		
		
		monsterImageLabel = new JLabel();
		monsterImageLabel.setBounds(421, 23, 154, 252); 
		contentPane.add(monsterImageLabel);
		
		JLabel monsterNameLabel = new JLabel("(몬스터이름)");
		monsterNameLabel.setBounds(464, 287, 97, 15);
		contentPane.add(monsterNameLabel);
		
		JButton btnNewButton_2 = new JButton("검\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_2.setBounds(49, 370, 62, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("활\r\n");
		btnNewButton_2_1.setBounds(170, 370, 62, 23);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("폭탄");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_2.setBounds(49, 403, 62, 23);
		contentPane.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("독");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_3.setBounds(170, 403, 62, 23);
		contentPane.add(btnNewButton_2_3);
		
		
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(406, 327, 194, 14);
		contentPane.add(progressBar_2);
		
	}

	public UI_first(Player p1,Player p2,Player p3,Player p4,
			Weapon w1,Weapon w2,Weapon w3,Weapon w4) {
		
		//p1, p2,... 정보를 관련 업데이트하기
		//이미지, 이름, hp, bar
		
		this(); // 기본 생성자를 부른다..?
		
		this.p1 = p1;
		this.p2 = p2;
		
		
		// 플레이어 이름, 이미지, HP 반영
		
		
	    // p1(스티브) UI 반영
	    hpValue.setValue(p1.getHp());
	    
	    // p2(몬스터) UI 반영
	    MonsterHP.setValue(target.getHp());
	 
	}
		
}