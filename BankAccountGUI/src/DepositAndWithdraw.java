import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DepositAndWithdraw extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldAmount;
	private JTextField textFieldDescription;
	private JButton btnConfirm;
	private JLabel lblAmount;
	public static BankAccount currentAccount;
	public static boolean transactionType;
	private boolean ok = false;

	public double getAmount() {
		return Double.valueOf(textFieldAmount.getText());
	}

	public String getDescription() {
		return textFieldDescription.getText();
	}

	public boolean isOk() {
		return ok;
	}

	public DepositAndWithdraw(BankAccount currentAccount, boolean transactionType) {

		setFont(new Font("Times New Roman", Font.PLAIN, 15));
		setTitle("Deposit");
		setBounds(100, 100, 300, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		if (!transactionType) {
			lblAmount = new JLabel("Please provide the amount to be withdrawn:");
		}
		else {
			lblAmount = new JLabel("Please provide the amount to deposit:");
		}
		lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAmount.setBounds(10, 40, 265, 14);
		contentPanel.add(lblAmount);

		JLabel lblDescription = new JLabel("(Optional) provide a description");
		lblDescription.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDescription.setBounds(10, 98, 265, 14);
		contentPanel.add(lblDescription);

		textFieldAmount = new JTextField();
		textFieldAmount.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textFieldAmount.setBounds(10, 67, 256, 20);
		contentPanel.add(textFieldAmount);
		textFieldAmount.setColumns(10);

		textFieldDescription = new JTextField();
		textFieldDescription.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(10, 123, 256, 20);
		contentPanel.add(textFieldDescription);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnCancel.setBounds(185, 157, 89, 23);
		contentPanel.add(btnCancel);

		textFieldAmount.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				System.out.println("change");
				setControls();
			}
			public void removeUpdate(DocumentEvent e) {
				System.out.println("remove");
				setControls();
			}
			public void insertUpdate(DocumentEvent e) {
				System.out.println("insert");
				setControls();
			}
		});

		btnConfirm = new JButton("OK");
		btnConfirm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (btnConfirm.isEnabled()) {
					ok = true;
					dispose();
				}
			}
		});

		btnConfirm.setEnabled(false);
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnConfirm.setBounds(86, 157, 89, 23);
		contentPanel.add(btnConfirm); 
	}

	private void setControls() {
		String input = textFieldAmount.getText();
		try {
			textFieldDescription.setForeground(Color.BLACK);
			textFieldAmount.setForeground(Color.BLACK);
			Double.valueOf(input);
			this.btnConfirm.setEnabled(true);
		} catch(Exception s) {
			textFieldAmount.setForeground(Color.RED);
			btnConfirm.setEnabled(false);
		}
	}
}