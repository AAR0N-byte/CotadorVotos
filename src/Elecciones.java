
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Elecciones extends JFrame {
	String cand1 = "Juanito";
	String cand2 = "Pepillo";
	String cand3 = "Lalito";
	String cand4 = "Esequiel";
	
	int numVotos1 = 0;
	int numVotos2 = 0;
	int numVotos3 = 0;
	int numVotos4 = 0;
	
	JPanel panelGraphic;
	
	JButton btnCand1;
	JButton btnCand2;
	JButton btnCand3;
	JButton btnCand4;
	
	JButton btnContFin;
	JButton btnReset;
	
	JLabel lblVotosCand1;
	JLabel lblVotosCand2;
	JLabel lblVotosCand3;
	JLabel lblVotosCand4;
	
	JLabel lblTotalVotos;
	
	
	public Elecciones() {
		loadComponents();
		validateVotos();
		
	}
	
	
	private void loadComponents() {
		
		JFrame  frame = new JFrame();
		JPanel panel1 = new JPanel();
		
		panelGraphic = new JPanel();
		
		lblVotosCand1 = new JLabel(cand1 +" tiene 0 Votos");
		lblVotosCand2 = new JLabel(cand2 +" tiene 0 Votos");
		lblVotosCand3 = new JLabel(cand3 +" tiene 0 Votos");
		lblVotosCand4 = new JLabel(cand4 +" tiene 0 Votos");
		
		lblTotalVotos = new JLabel("El total de votos es: 0");
		
		btnContFin = new JButton("Finalizar");
		btnReset = new JButton("reiniciar");
		
		btnCand1 = new JButton(cand1);
		btnCand2 = new JButton(cand2);
		btnCand3 = new JButton(cand3);
		btnCand4 = new JButton(cand4);
		
		frame.setTitle("Contador de votos");
		frame.setSize(600,360);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		panelGraphic.setBounds(220, 10, 300, 300);
		panel1.add(panelGraphic);
		
		panel1.setLayout(null);;
		panel1.setBounds(0, 0, 480, 320);
		panel1.setBackground(Color.white);
		frame.add(panel1);
			
		lblTotalVotos.setBounds(10, 10, 200, 20);
		panel1.add(lblTotalVotos);
		
		lblVotosCand1.setBounds(10, 30, 200, 20);
		panel1.add(lblVotosCand1);
		
		lblVotosCand2.setBounds(10, 50, 200, 20);
		panel1.add(lblVotosCand2);
		
		lblVotosCand3.setBounds(10, 70, 200, 20);
		panel1.add(lblVotosCand3);
		
		lblVotosCand4.setBounds(10, 90, 200, 20);
		panel1.add(lblVotosCand4);
		
		btnCand1.setBounds(10, 115, 100, 20);
		btnCand1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clasificarVotos(btnCand1);
				graphicBuild(panelGraphic);
				lblTotalVotos.setText("el total de votos es: " + getTotalVotos());
			}
		});
		panel1.add(btnCand1);
		
		btnCand2.setBounds(10, 140, 100, 20);
		btnCand2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clasificarVotos(btnCand2);
				graphicBuild(panelGraphic);
				lblTotalVotos.setText("el total de votos es: " + getTotalVotos());
			}
		});
		panel1.add(btnCand2);
		
		btnCand3.setBounds(10, 165, 100, 20);
		btnCand3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clasificarVotos(btnCand3);
				graphicBuild(panelGraphic);
				lblTotalVotos.setText("el total de votos es: " + getTotalVotos());
			}
		});
		panel1.add(btnCand3);
		
		btnCand4.setBounds(10, 190, 100, 20);
		btnCand4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clasificarVotos(btnCand4);
				graphicBuild(panelGraphic);
				lblTotalVotos.setText("el total de votos es: " + getTotalVotos());
			}
		});
		panel1.add(btnCand4);
		
		btnContFin.setBounds(10, 225, 100, 20);
		btnContFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fin();
				
			}
		});
		panel1.add(btnContFin);
		
		btnReset.setBounds(10, 250, 100, 20);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		panel1.add(btnReset);
		
		
		
		
        
	}
	
	private void graphicBuild(JPanel panelGraphic) {
		
		String txtNumVotos1 = Integer.toString(numVotos1);
		String txtNumVotos2 = Integer.toString(numVotos2);
		String txtNumVotos3 = Integer.toString(numVotos3);
		String txtNumVotos4 = Integer.toString(numVotos4);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.setValue(getPorcientoVotos(numVotos1), cand1, txtNumVotos1);
	    dataset.setValue(getPorcientoVotos(numVotos2), cand2, txtNumVotos2);
	    dataset.setValue(getPorcientoVotos(numVotos3), cand3, txtNumVotos3);
	    dataset.setValue(getPorcientoVotos(numVotos4), cand4, txtNumVotos4);
		
	    JFreeChart chart = ChartFactory.createBarChart3D("Estado actual del total de los votos", "numero de votos",
	    		   "porcentaje", dataset, PlotOrientation.VERTICAL, true,true, false);
	    
	    
	    ChartPanel grafico = new ChartPanel(chart);        
        panelGraphic.setLayout(new java.awt.BorderLayout());
        panelGraphic.add(grafico);   
        panelGraphic.validate();
        
	}
	
	private float getPorcientoVotos(float numVotos) {
		// TODO Auto-generated method stub
		float porcentaje = (numVotos/getTotalVotos())*100;
		return porcentaje;
	}
	
	private int getTotalVotos() {
		int totalVotos = numVotos1 + numVotos2 + numVotos3 + numVotos4;
		return totalVotos;
	}
	
	private void clasificarVotos(JButton boton) {
		String txtBoton = boton.getText();
		
		switch (txtBoton) {
		case "Juanito":
			numVotos1++;
			lblVotosCand1.setText(cand1 +" tiene "+ numVotos1+ " votos");
			break;
		case "Pepillo":
			numVotos2++;
			lblVotosCand2.setText(cand2 +" tiene "+ numVotos2+ " votos");
			break; 
		case "Lalito":
			numVotos3++;
			lblVotosCand3.setText(cand3 +" tiene "+ numVotos3+ " votos");
			break;
			
		case "Esequiel":
			numVotos4++;
			lblVotosCand4.setText(cand4 +" tiene "+ numVotos4+ " votos");
			break;
		}
	}
	
	private void reset() {
		lblVotosCand1.setText(cand1 +" tiene 0 Votos");
		lblVotosCand2.setText(cand2 +" tiene 0 Votos");
		lblVotosCand3.setText(cand3 +" tiene 0 Votos");
		lblVotosCand3.setText(cand4 +" tiene 0 Votos");
		
		numVotos1 = 0;
		numVotos2 = 0;
		numVotos3 = 0;
		numVotos4 = 0;
		
		btnCand1.setEnabled(true);
		btnCand2.setEnabled(true);
		btnCand3.setEnabled(true);
		btnCand4.setEnabled(true);
		graphicBuild(panelGraphic);
		
		lblTotalVotos.setText("el total de votos es: 0");
	}

	private void fin() {
		btnCand1.setEnabled(false);
		btnCand2.setEnabled(false);
		btnCand3.setEnabled(false);
		btnCand4.setEnabled(false);
		
		
	}
	
	private void validateVotos() {
		
		while(true) {
		if (numVotos1 == 0 && numVotos2 == 0 && numVotos3 == 0 && numVotos4 == 0) {
			btnContFin.setEnabled(false);
			btnReset.setEnabled(false);
		}else {
			btnContFin.setEnabled(true);
			btnReset.setEnabled(true);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Elecciones();
	}

}