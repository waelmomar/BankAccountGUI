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
	private JComboBox<String> comboBoxStartMonth;
	private JComboBox<Integer> comboBoxStartDay;
	private JComboBox<Integer> comboBoxStartYear;
	private JComboBox<String> comboBoxEndMonth;
	private JComboBox<Integer> comboBoxEndDay;
	private JComboBox<Integer> comboBoxEndYear;

	public TransactionDialog(BankAccount currentAccount) {
		this.currentAccount = currentAccount;
		setResizable(false);
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		chckbxStartDate = new JCheckBox("Start Date:");
		chckbxStartDate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				chckbxStartDate_mouseClicked(arg0);
			}
		});
		chckbxStartDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxStartDate.setBounds(29, 7, 97, 23);
		contentPanel.add(chckbxStartDate);
		chckbxStartDate.setSelected(false);

		chckbxEndDate = new JCheckBox("End Date:");
		chckbxEndDate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				chckbxEndDate_mouseClicked(arg0);
			}
		});
		chckbxEndDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxEndDate.setBounds(29, 44, 97, 23);
		contentPanel.add(chckbxEndDate);
		chckbxEndDate.setSelected(false);

		comboBoxStartMonth = new JComboBox<String>();
		comboBoxStartMonth.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxStartMonth.setMaximumRowCount(12);
		comboBoxStartMonth.addItem("JAN");
		comboBoxStartMonth.addItem("FEB");
		comboBoxStartMonth.addItem("MAR");
		comboBoxStartMonth.addItem("APR");
		comboBoxStartMonth.addItem("MAY");
		comboBoxStartMonth.addItem("JUN");
		comboBoxStartMonth.addItem("JUL");
		comboBoxStartMonth.addItem("AUG");
		comboBoxStartMonth.addItem("SEPT");
		comboBoxStartMonth.addItem("OCT");
		comboBoxStartMonth.addItem("NOV");
		comboBoxStartMonth.addItem("DEC");
		comboBoxStartMonth.setBounds(147, 7, 60, 22);
		contentPanel.add(comboBoxStartMonth);
		comboBoxStartMonth.setEnabled(false);

		comboBoxEndMonth = new JComboBox<String>();
		comboBoxEndMonth.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxEndMonth.setMaximumRowCount(12);
		comboBoxEndMonth.addItem("JAN");
		comboBoxEndMonth.addItem("FEB");
		comboBoxEndMonth.addItem("MAR");
		comboBoxEndMonth.addItem("APR");
		comboBoxEndMonth.addItem("MAY");
		comboBoxEndMonth.addItem("JUN");
		comboBoxEndMonth.addItem("JUL");
		comboBoxEndMonth.addItem("AUG");
		comboBoxEndMonth.addItem("SEPT");
		comboBoxEndMonth.addItem("OCT");
		comboBoxEndMonth.addItem("NOV");
		comboBoxEndMonth.addItem("DEC");
		comboBoxEndMonth.setBounds(147, 44, 60, 22);
		contentPanel.add(comboBoxEndMonth);
		comboBoxEndMonth.setEnabled(false);

		comboBoxStartDay = new JComboBox<Integer>();
		comboBoxStartDay.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxStartDay.setMaximumRowCount(31);
		comboBoxStartDay.addItem(1);
		comboBoxStartDay.addItem(2);
		comboBoxStartDay.addItem(3);
		comboBoxStartDay.addItem(4);
		comboBoxStartDay.addItem(5);
		comboBoxStartDay.addItem(6);
		comboBoxStartDay.addItem(7);
		comboBoxStartDay.addItem(8);
		comboBoxStartDay.addItem(9);
		comboBoxStartDay.addItem(10);
		comboBoxStartDay.addItem(11);
		comboBoxStartDay.addItem(12);
		comboBoxStartDay.addItem(13);
		comboBoxStartDay.addItem(14);
		comboBoxStartDay.addItem(15);
		comboBoxStartDay.addItem(16);
		comboBoxStartDay.addItem(17);
		comboBoxStartDay.addItem(18);
		comboBoxStartDay.addItem(19);
		comboBoxStartDay.addItem(20);
		comboBoxStartDay.addItem(21);
		comboBoxStartDay.addItem(22);
		comboBoxStartDay.addItem(23);
		comboBoxStartDay.addItem(24);
		comboBoxStartDay.addItem(25);
		comboBoxStartDay.addItem(26);
		comboBoxStartDay.addItem(27);
		comboBoxStartDay.addItem(28);
		comboBoxStartDay.addItem(29);
		comboBoxStartDay.addItem(30);
		comboBoxStartDay.addItem(31);	
		comboBoxStartDay.setBounds(270, 7, 60, 22);
		contentPanel.add(comboBoxStartDay);
		comboBoxStartDay.setEnabled(false);

		comboBoxEndDay = new JComboBox<Integer>();
		comboBoxEndDay.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxEndDay.setMaximumRowCount(31);
		comboBoxEndDay.addItem(1);
		comboBoxEndDay.addItem(2);
		comboBoxEndDay.addItem(3);
		comboBoxEndDay.addItem(4);
		comboBoxEndDay.addItem(5);
		comboBoxEndDay.addItem(6);
		comboBoxEndDay.addItem(7);
		comboBoxEndDay.addItem(8);
		comboBoxEndDay.addItem(9);
		comboBoxEndDay.addItem(10);
		comboBoxEndDay.addItem(11);
		comboBoxEndDay.addItem(12);
		comboBoxEndDay.addItem(13);
		comboBoxEndDay.addItem(14);
		comboBoxEndDay.addItem(15);
		comboBoxEndDay.addItem(16);
		comboBoxEndDay.addItem(17);
		comboBoxEndDay.addItem(18);
		comboBoxEndDay.addItem(19);
		comboBoxEndDay.addItem(20);
		comboBoxEndDay.addItem(21);
		comboBoxEndDay.addItem(22);
		comboBoxEndDay.addItem(23);
		comboBoxEndDay.addItem(24);
		comboBoxEndDay.addItem(25);
		comboBoxEndDay.addItem(26);
		comboBoxEndDay.addItem(27);
		comboBoxEndDay.addItem(28);
		comboBoxEndDay.addItem(29);
		comboBoxEndDay.addItem(30);
		comboBoxEndDay.addItem(31);
		comboBoxEndDay.setBounds(270, 44, 60, 22);
		contentPanel.add(comboBoxEndDay);
		comboBoxEndDay.setEnabled(false);

		comboBoxStartYear = new JComboBox<Integer>();
		comboBoxStartYear.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxStartYear.setMaximumRowCount(20);
		comboBoxStartYear.addItem(2020);
		comboBoxStartYear.addItem(2019);
		comboBoxStartYear.addItem(2018);
		comboBoxStartYear.addItem(2017);
		comboBoxStartYear.addItem(2016);
		comboBoxStartYear.addItem(2015);
		comboBoxStartYear.addItem(2014);
		comboBoxStartYear.addItem(2013);
		comboBoxStartYear.addItem(2012);
		comboBoxStartYear.addItem(2011);
		comboBoxStartYear.addItem(2010);
		comboBoxStartYear.addItem(2009);
		comboBoxStartYear.addItem(2008);
		comboBoxStartYear.addItem(2007);
		comboBoxStartYear.addItem(2006);
		comboBoxStartYear.addItem(2005);
		comboBoxStartYear.addItem(2004);
		comboBoxStartYear.addItem(2003);
		comboBoxStartYear.addItem(2002);
		comboBoxStartYear.addItem(2001);
		comboBoxStartYear.addItem(2000);
		comboBoxStartYear.setBounds(392, 7, 71, 22);
		contentPanel.add(comboBoxStartYear);
		comboBoxStartYear.setEnabled(false);

		comboBoxEndYear = new JComboBox<Integer>();
		comboBoxEndYear.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxEndYear.setMaximumRowCount(20);
		comboBoxEndYear.addItem(2020);
		comboBoxEndYear.addItem(2019);
		comboBoxEndYear.addItem(2018);
		comboBoxEndYear.addItem(2017);
		comboBoxEndYear.addItem(2016);
		comboBoxEndYear.addItem(2015);
		comboBoxEndYear.addItem(2014);
		comboBoxEndYear.addItem(2013);
		comboBoxEndYear.addItem(2012);
		comboBoxEndYear.addItem(2011);
		comboBoxEndYear.addItem(2010);
		comboBoxEndYear.addItem(2009);
		comboBoxEndYear.addItem(2008);
		comboBoxEndYear.addItem(2007);
		comboBoxEndYear.addItem(2006);
		comboBoxEndYear.addItem(2005);
		comboBoxEndYear.addItem(2004);
		comboBoxEndYear.addItem(2003);
		comboBoxEndYear.addItem(2002);
		comboBoxEndYear.addItem(2001);
		comboBoxEndYear.addItem(2000);
		comboBoxEndYear.setBounds(392, 44, 71, 22);
		contentPanel.add(comboBoxEndYear);
		comboBoxEndYear.setEnabled(false);

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
		boolean var = chckbxStartDate.isSelected();
		comboBoxStartDay.setEnabled(var);
		comboBoxStartMonth.setEnabled(var);
		comboBoxStartYear.setEnabled(var);
	}
	
	protected void chckbxEndDate_mouseClicked(MouseEvent arg0) {
		boolean bar = chckbxEndDate.isSelected();
		comboBoxEndDay.setEnabled(bar);
		comboBoxEndMonth.setEnabled(bar);
		comboBoxEndYear.setEnabled(bar);
	}
}

