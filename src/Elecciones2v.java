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

public class Elecciones2v extends JFrame {
	
	String cand[] = { "Juanito","Pepillo","Lalito","Esequiel"};
	int numVotos[] = new int[4];
	JButton btnCand[] = new JButton[4];
	JLabel lblVotosCand[] = new JLabel[4];
	
	JFrame  frame;
	
	JPanel panel1;
	JPanel panelGraphic;
	
	JLabel lblTotalVotos;
	JButton btnContFin;
	JButton btnReset;

	
	public Elecciones2v() {
		loadComponents();
		validateVotos();
	}
	
	private void loadComponents() {
		
		frame = new JFrame();
		panel1 = new JPanel();
		panelGraphic = new JPanel();
		
		lblTotalVotos = new JLabel("El total de votos es: 0");
		
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
	
		buildLblVotosCand(lblVotosCand,0,10,30,200,20);
		buildLblVotosCand(lblVotosCand,1,10,50,200,20);
		buildLblVotosCand(lblVotosCand,2,10,70,200,20);
		buildLblVotosCand(lblVotosCand,3,10,90,200,20);
		
		buildBtnCand(btnCand,0,10,115,100,20);
		buildBtnCand(btnCand,1,10,140,100,20);
		buildBtnCand(btnCand,2,10,165,100,20);
		buildBtnCand(btnCand,3,10,190,100,20);
		
		btnFin(10, 225, 100, 20);
		btnReset(10, 250, 100, 20);

	}
	
	private void buildBtnCand(JButton btnCandX[],int i ,int x,int y,int ancho,int alto) {
		
		btnCandX[i] = new JButton(cand[i]);
		btnCandX[i].setBounds(x, y, ancho, alto);
		
		btnCandX[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clasificarVotos(btnCandX[i]);
				graphicBuild(panelGraphic);
				lblTotalVotos.setText("el total de votos es: " + getTotalVotos());
			}
		});
		panel1.add(btnCand[i]);
	}
	
	private void buildLblVotosCand(JLabel lblVotosCadX[],int i,int x, int y,int ancho,int alto) {
		lblVotosCand[i] = new JLabel(cand[i] +" tiene 0 Votos");
		lblVotosCand[i].setBounds(x, y, ancho, alto);
		panel1.add(lblVotosCand[i]);
	}
	
	private void graphicBuild(JPanel panelGraphic) {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String txtNumVotos[] = new String[4];
		
		for(int i = 0; i < 4 ;i++) {
		txtNumVotos[i] = Integer.toString(numVotos[i]);
		dataset.setValue(getPorcientoVotos(numVotos[i]), cand[i], txtNumVotos[i]);
		
		}
		
	    JFreeChart chart = ChartFactory.createBarChart3D("Estado actual del total de los votos", "numero de votos",
	    		   "porcentaje", dataset, PlotOrientation.VERTICAL, true,true, false);
	    
	    ChartPanel grafico = new ChartPanel(chart);        
        panelGraphic.setLayout(new java.awt.BorderLayout());
        panelGraphic.add(grafico);   
        panelGraphic.validate();
        
	}
	
	private float getPorcientoVotos(float numVotos) {
		float porcentaje = (numVotos/getTotalVotos())*100;
		return porcentaje;
	}
	
	private int getTotalVotos() {
		int totalVotos = numVotos[0] + numVotos[1] + numVotos[2] + numVotos[3];
		return totalVotos;
	}
	
	private void clasificarVotos(JButton boton) {
		String txtBoton = boton.getText();
		
		switch (txtBoton) {
		case "Juanito":
			numVotos[0]++;
			lblVotosCand[0].setText(cand[0] +" tiene "+ numVotos[0]+ " votos");
			break;
		case "Pepillo":
			numVotos[1]++;
			lblVotosCand[1].setText(cand[1] +" tiene "+ numVotos[1]+ " votos");
			break; 
		case "Lalito":
			numVotos[2]++;
			lblVotosCand[2].setText(cand[2] +" tiene "+ numVotos[2]+ " votos");
			break;
		case "Esequiel":
			numVotos[3]++;
			lblVotosCand[3].setText(cand[3] +" tiene "+ numVotos[3]+ " votos");
			break;
		}
	}
	
	private void btnReset(int x, int y,int ancho,int alto) {
		btnReset = new JButton("reiniciar");
		btnReset.setBounds(x, y, ancho, alto);
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				for (int i =0; i< 4; i++) {
					lblVotosCand[i].setText(cand[0] +" tiene 0 Votos");
					btnCand[i].setEnabled(true);
					numVotos[i] = 0;
				}

				graphicBuild(panelGraphic);
				lblTotalVotos.setText("el total de votos es: 0");
			}
		});
		panel1.add(btnReset);
	}

	private void btnFin(int x, int y,int ancho,int alto) {
		btnContFin = new JButton("Finalizar");
		btnContFin.setBounds(x, y, ancho, alto);
		
		btnContFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i =0; i< btnCand.length; i++) {
					btnCand[i].setEnabled(false);
				}
			}
		});
		panel1.add(btnContFin);

	}
	
	private void validateVotos() {
		
		while(true) {
		if (numVotos[0] == 0 && numVotos[1] == 0 && numVotos[2] == 0 && numVotos[3] == 0) {
			btnContFin.setEnabled(false);
			btnReset.setEnabled(false);
		}else {
			btnContFin.setEnabled(true);
			btnReset.setEnabled(true);
			}
		}
	}
	
	public static void main(String[] args) {
		new Elecciones2v();
	}
}
