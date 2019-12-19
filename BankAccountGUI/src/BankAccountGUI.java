import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BankAccountGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBalance;
	public BankAccount savings = BankAccountTestData.getSavingsBankAccount();
	public BankAccount chequing = BankAccountTestData.getChequingBankAccount();
	private JComboBox<String> comboBoxSelectAccount;
	private JButton btnWithdraw;
	private JButton btnDeposit;
	private JButton btnTransactions;
	public static BankAccount currentAccount;
	public static boolean deposit;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankAccountGUI frame = new BankAccountGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BankAccountGUI() {
		setFont(new Font("Times New Roman", Font.PLAIN, 15));
		setTitle("Bank Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAccount.setBounds(90, 22, 75, 35);
		contentPane.add(lblAccount);

		JLabel lblCurrentBalance = new JLabel("Current Balance:  ");
		lblCurrentBalance.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblCurrentBalance.setBounds(27, 122, 138, 20);
		contentPane.add(lblCurrentBalance);

		textFieldBalance = new JTextField();
		textFieldBalance.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textFieldBalance.setEditable(false);
		textFieldBalance.setBounds(175, 116, 178, 35);
		contentPane.add(textFieldBalance);
		textFieldBalance.setColumns(10);


		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnWithdraw_mouseClicked(arg0);
			}
		});
		btnWithdraw.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnWithdraw.setBounds(10, 198, 118, 46);
		contentPane.add(btnWithdraw);


		btnDeposit = new JButton("Deposit");
		btnDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDeposit_mouseClicked(e);
			}
		});
		btnDeposit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnDeposit.setBounds(190, 198, 118, 46);
		contentPane.add(btnDeposit);


		btnTransactions = new JButton("Transactions");
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionDialog transaction = new TransactionDialog(currentAccount);
				transaction.setVisible(true);
			}
		});
		btnTransactions.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnTransactions.setBounds(356, 198, 138, 46);
		contentPane.add(btnTransactions);


		comboBoxSelectAccount = new JComboBox<String>();
		comboBoxSelectAccount.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBoxSelectAccount.setMaximumRowCount(3);
		comboBoxSelectAccount.addItem("Please select an Account");
		comboBoxSelectAccount.addItem("Chequing");
		comboBoxSelectAccount.addItem("Savings");
		comboBoxSelectAccount.setBounds(180, 22, 208, 34);
		contentPane.add(comboBoxSelectAccount);
		comboBoxSelectAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setControls();
			}
		});
		setControls();

	}

	private void setControls() {
		try {
			String rowName = (String)comboBoxSelectAccount.getSelectedItem();
			if (rowName == "Chequing") {
				currentAccount = chequing;
				textFieldBalance.setEnabled(true);
				textFieldBalance.setText(String.format("%.2f", chequing.getBalance()));
				btnWithdraw.setEnabled(true);
				btnDeposit.setEnabled(true);
				btnTransactions.setEnabled(true);
			}
			else if(rowName == "Savings"){
				currentAccount = savings;
				textFieldBalance.setEnabled(true);
				textFieldBalance.setText(String.format("%.2f", savings.getBalance()));
				btnWithdraw.setEnabled(true);
				btnDeposit.setEnabled(true);
				btnTransactions.setEnabled(true);
			}
			else {

				textFieldBalance.setEnabled(false);
				btnWithdraw.setEnabled(false);
				btnDeposit.setEnabled(false);
				btnTransactions.setEnabled(false);
			}
		} catch(NullPointerException e) {
			textFieldBalance.setEnabled(false);
			btnWithdraw.setEnabled(false);
			btnDeposit.setEnabled(false);
			btnTransactions.setEnabled(false);

		}
	}

	protected void btnWithdraw_mouseClicked(MouseEvent arg0) {
		DepositAndWithdraw withdrawDialog = new DepositAndWithdraw(currentAccount, false);
		withdrawDialog.setModal(true);
		withdrawDialog.setVisible(true);
		boolean ok = withdrawDialog.isOk();
		withdrawDialog.setLocationRelativeTo(this);
		if(ok) {
			double amount = withdrawDialog.getAmount();
			String description = withdrawDialog.getDescription();
			currentAccount.withdraw(amount, description);
			setControls();
		}	
	}

	protected void btnDeposit_mouseClicked(MouseEvent e) {
		DepositAndWithdraw depositDialog = new DepositAndWithdraw(currentAccount, true);
		depositDialog.setModal(true);
		depositDialog.setVisible(true);
		depositDialog.setLocationRelativeTo(this);
		boolean ok = depositDialog.isOk();
		if(ok) {
			double amount = depositDialog.getAmount();
			String description = depositDialog.getDescription();
			currentAccount.deposit(amount, description);
			setControls();
		}			
	}
}
