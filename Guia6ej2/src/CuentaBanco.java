import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.MutableComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class CuentaBanco extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel panelDerecho;
	private JPanel panelDerechoSup;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JTextField textfieldMonto;
	private JButton btnBotonAceptar;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField txtExcepciones;
	private CuentaBancaria cuenta = new CuentaBancaria("Pedro");
	private JList lista_atributos;
	private DefaultListModel <CuentaBancaria >modelolista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuentaBanco frame = new CuentaBanco();
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
	public CuentaBanco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 483);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane);
		
		this.lista_atributos = new JList();
		this.scrollPane.setViewportView(this.lista_atributos);

		this.panelDerecho = new JPanel();
		this.contentPane.add(this.panelDerecho);
		this.panelDerecho.setLayout(new GridLayout(2, 0, 0, 0));

		this.panelDerechoSup = new JPanel();
		this.panelDerechoSup
				.setBorder(new TitledBorder(null, "Operacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelDerecho.add(this.panelDerechoSup);
		this.panelDerechoSup.setLayout(new GridLayout(2, 2, 0, 0));

		this.panel = new JPanel();
		this.panelDerechoSup.add(this.panel);

		this.lblNewLabel = new JLabel("Monto:");
		this.panel.add(this.lblNewLabel);

		this.panel_1 = new JPanel();
		this.panelDerechoSup.add(this.panel_1);

		this.textfieldMonto = new JTextField();
		this.panel_1.add(this.textfieldMonto);
		this.textfieldMonto.setColumns(10);

		this.panel_2 = new JPanel();
		this.panelDerechoSup.add(this.panel_2);

		this.comboBox = new JComboBox();
		this.comboBox.addActionListener(this);
		this.panel_2.add(this.comboBox);
		this.comboBox.setModel(new DefaultComboBoxModel(new String[] { "Extraer", "Depositar" }));

		this.panel_3 = new JPanel();
		this.panelDerechoSup.add(this.panel_3);

		this.btnBotonAceptar = new JButton("Aceptar");
		this.btnBotonAceptar.addActionListener(this);
		this.panel_3.add(this.btnBotonAceptar);

		this.txtExcepciones = new JTextField();
		this.txtExcepciones.setText("Excepciones:");
		this.panelDerecho.add(this.txtExcepciones);
		this.txtExcepciones.setColumns(10);
		DefaultListModel modelolista= new DefaultListModel();
		modelolista.addElement(cuenta);
		this.lista_atributos.setModel(modelolista);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Aceptar")) {
			if (this.comboBox.getSelectedItem().equals("Extraer")) {
				try {
					cuenta.extraer(Integer.parseInt(textfieldMonto.getText()));
				} catch (NumberFormatException | ExtraccionInvalidaException e) {
					txtExcepciones.setText("Extraccion invalida, intente denuevo");
				}
			} else
				try {
					cuenta.depositar(Integer.parseInt(textfieldMonto.getText()));
				} catch (DepositoInvalidoException e) {
					txtExcepciones.setText("Deposito invalido, intente denuevo");
				}
		}
		this.actualizarLista();
	}

	private void actualizarLista() {
		this.modelolista.addElement(cuenta);
		this.repaint();
		
		
	}
}
;