import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

public class TransactionDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textFieldTransactions;
	public BankAccount currentAccount;
	private JCheckBox chckbxStartDate;
	private JCheckBox chckbxEndDate;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public TransactionDialog(BankAccount currentAccount) {
		this.currentAccount = currentAccount;
		setResizable(false);
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JCheckBox chckbxStartDate = new JCheckBox("Start Date:");
		chckbxStartDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				chckbxStartDate_mouseClicked(arg0);
			}
		});
		chckbxStartDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxStartDate.setBounds(29, 7, 97, 23);
		contentPanel.add(chckbxStartDate);

		JCheckBox chckbxEndDate = new JCheckBox("End Date:");
		chckbxEndDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxEndDate.setBounds(29, 44, 97, 23);
		contentPanel.add(chckbxEndDate);

		JComboBox comboBoxStartMonth = new JComboBox<String>();
		comboBoxStartMonth.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxStartMonth.setMaximumRowCount(12);
		comboBoxStartMonth.setBounds(147, 7, 60, 22);
		contentPanel.add(comboBoxStartMonth);

		JComboBox comboBoxEndMonth = new JComboBox<String>();
		comboBoxEndMonth.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxEndMonth.setMaximumRowCount(12);
		comboBoxEndMonth.setBounds(147, 44, 60, 22);
		contentPanel.add(comboBoxEndMonth);

		JComboBox comboBoxStartDay = new JComboBox<String>();
		comboBoxStartDay.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxStartDay.setMaximumRowCount(12);
		comboBoxStartDay.setBounds(270, 7, 60, 22);
		contentPanel.add(comboBoxStartDay);

		JComboBox comboBoxEndDay = new JComboBox<String>();
		comboBoxEndDay.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxEndDay.setMaximumRowCount(12);
		comboBoxEndDay.setBounds(270, 44, 60, 22);
		contentPanel.add(comboBoxEndDay);

		JComboBox comboBoxStartYear = new JComboBox<Object>();
		comboBoxStartYear.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxStartYear.setMaximumRowCount(12);
		comboBoxStartYear.setBounds(392, 7, 71, 22);
		contentPanel.add(comboBoxStartYear);

		JComboBox comboBoxEndYear = new JComboBox<Object>();
		comboBoxEndYear.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxEndYear.setMaximumRowCount(12);
		comboBoxEndYear.setBounds(392, 44, 71, 22);
		contentPanel.add(comboBoxEndYear);

		JLabel lblLegend = new JLabel("              Date                       Time                                   Amount                                   Description");
		lblLegend.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLegend.setBounds(6, 77, 578, 23);
		contentPanel.add(lblLegend);

		JLabel lblLegend2 = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------");
		lblLegend2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLegend2.setBounds(6, 97, 578, 14);
		contentPanel.add(lblLegend2);

		textFieldTransactions = new JTextArea();
		textFieldTransactions.setEditable(false);
		textFieldTransactions.setFont(new Font("Consolas", Font.PLAIN, 12));
		textFieldTransactions.setBounds(6, 111, 418, 139);
		contentPanel.add(textFieldTransactions);
		textFieldTransactions.setColumns(10);

		JScrollPane scrollbarTransactions = new JScrollPane(textFieldTransactions,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);				
		scrollbarTransactions.setBounds(6, 111, 578, 139);
		contentPanel.add(scrollbarTransactions);
		
		setControls();
	}  
	
	private void setControls() {
		if (!chckbxStartDate.isSelected()) {
			startTime = null;
		}
		if (!chckbxEndDate.isSelected()) {
			endTime = null;
		}
		ArrayList<Transaction> transactionList = currentAccount.getTransactions(startTime, endTime);	
		transactionList.remove(0);
		int maxLength = 0;
		StringBuilder sb = new StringBuilder();
		for(Transaction transaction : transactionList) {
			maxLength = Integer.max(maxLength, String.format("%.2f", transaction.getAmount()).length());
		}

		for(Transaction transaction : transactionList) {
			String date = String.valueOf(transaction.getTransactionTime()).replace("T", "      ");
			String dateTime = date.substring(0, 24);
			String amount = String.format("%.2f", transaction.getAmount());
			String description = transaction.getDescription();
			int numberZeroes = maxLength - amount.length();
			sb.append(dateTime + "            $" + amount + String.format("%" + (numberZeroes+1) + "s", "") + "        " + description + "\n");
		}
		textFieldTransactions.setText(sb.toString());
	}
	protected void chckbxStartDate_mouseClicked(MouseEvent arg0) {
	}
}

