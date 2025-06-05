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
	private JProgressBar hpValue;
	private JProgressBar MonsterHP;
	private JLabel monsterImageLabel;
	

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
	
		JLabel lblNewLabel_1 = new JLabel("스티브");
		lblNewLabel_1.setBounds(130, 287, 36, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("공격하기");
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//공격한다고 출력해주고
				//hp깎고(attack 실행)
				//bar에 반영
				//사망처리(사진변경)

				
			}
		});
		btnNewButton.setBounds(30, 453, 103, 23);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("능력 사용");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(156, 453, 103, 23);
		contentPane.add(btnNewButton_1);
		
		hpValue = new JProgressBar();
		hpValue.setBounds(30, 327, 229, 14);
		hpValue.setValue(100);                   // 초기값 (초기 체력 0)
		hpValue.setStringPainted(true);       // 숫자 체력도 막대 위에 표시되게 함
		contentPane.add(hpValue);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(UI_first.class.getResource("/images/스티브.png")));
		lblNewLabel.setBounds(30, 12, 213, 290);
		contentPane.add(lblNewLabel);
		
		
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
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(386, 327, 229, 14);
		contentPane.add(progressBar);
		
	}

	public UI_first(Player p1,Player p2,Player p3,Player p4,
			Weapon w1,Weapon w2,Weapon w3,Weapon w4) {
		
		//p1, p2,... 정보를 관련 업데이트하기
		//이미지, 이름, hp, bar
		
		this(); // 기본 생성자를 부른다..?
		
		this.p1 = p1;
		this.p2 = p2;
		this.target = target; 
		
		// 플레이어 이름, 이미지, HP 반영
		
	    // p1(스티브) UI 반영
	    hpValue.setValue(p1.getHp());
	    
	    // p2(몬스터) UI 반영
	    MonsterHP.setValue(p2.getHp());
	    
		String monsterName = p2.getName();
		ImageIcon monsterIcon;
		
		switch(monsterName) {
		    case "스켈레톤":
		        monsterIcon = new ImageIcon(UI_first.class.getResource("/images/스켈레톤.png"));
		        break;
		    case "좀비":
		        monsterIcon = new ImageIcon(UI_first.class.getResource("/images/좀비.png"));
		        break;
		    default:
		        monsterIcon = new ImageIcon(UI_first.class.getResource("/images/크리퍼.png"));
		        break;
		}

		monsterImageLabel.setIcon(monsterIcon);
	}
}
