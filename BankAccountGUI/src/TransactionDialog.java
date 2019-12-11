import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.util.stream.Collectors;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class TransactionDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldTransactions;
	public static BankAccount currentAccount;

	public TransactionDialog(BankAccount currentAccount) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JCheckBox chckbxStartDate = new JCheckBox("Start Date:");
		chckbxStartDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxStartDate.setBounds(6, 7, 97, 23);
		contentPanel.add(chckbxStartDate);
		
		JCheckBox chckbxEndDate = new JCheckBox("End Date:");
		chckbxEndDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxEndDate.setBounds(6, 44, 97, 23);
		contentPanel.add(chckbxEndDate);
		
		JComboBox comboBoxStartMonth = new JComboBox();
		comboBoxStartMonth.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxStartMonth.setMaximumRowCount(12);
		comboBoxStartMonth.setBounds(121, 7, 60, 22);
		contentPanel.add(comboBoxStartMonth);
		
		JComboBox comboBoxEndMonth = new JComboBox();
		comboBoxEndMonth.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxEndMonth.setMaximumRowCount(12);
		comboBoxEndMonth.setBounds(121, 44, 60, 22);
		contentPanel.add(comboBoxEndMonth);
		
		JComboBox comboBoxStartDay = new JComboBox();
		comboBoxStartDay.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxStartDay.setMaximumRowCount(12);
		comboBoxStartDay.setBounds(191, 7, 60, 22);
		contentPanel.add(comboBoxStartDay);
		
		JComboBox comboBoxEndDay = new JComboBox();
		comboBoxEndDay.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxEndDay.setMaximumRowCount(12);
		comboBoxEndDay.setBounds(191, 44, 60, 22);
		contentPanel.add(comboBoxEndDay);
		
		JComboBox comboBoxStartYear = new JComboBox();
		comboBoxStartYear.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxStartYear.setMaximumRowCount(12);
		comboBoxStartYear.setBounds(261, 7, 71, 22);
		contentPanel.add(comboBoxStartYear);
		
		JComboBox comboBoxEndYear = new JComboBox();
		comboBoxEndYear.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxEndYear.setMaximumRowCount(12);
		comboBoxEndYear.setBounds(261, 44, 71, 22);
		contentPanel.add(comboBoxEndYear);
		
		JLabel lblLegend = new JLabel("              Date                      Time                           Amount                   Description");
		lblLegend.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLegend.setBounds(6, 77, 418, 23);
		contentPanel.add(lblLegend);
		
		JLabel lblLegend2 = new JLabel("--------------------------------------------------------------------------------------------------------");
		lblLegend2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblLegend2.setBounds(6, 97, 418, 14);
		contentPanel.add(lblLegend2);
		
		textFieldTransactions = new JTextField();
		textFieldTransactions.setEditable(false);
		textFieldTransactions.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldTransactions.setBounds(6, 111, 418, 139);

		contentPanel.add(textFieldTransactions);
		textFieldTransactions.setColumns(10);

		String listString = currentAccount.getTransactions(null, null).stream().map(Object::toString)
				.collect(Collectors.joining(", "));	
		String dates = listString.replace("-", ".");
		dates = dates.replace("T", " ");
		String lines[] = dates.split("class  ransaction: ");
		for(String w:lines){  
			System.out.println(w);
			textFieldTransactions.setText(w);
		}  

	}
}
