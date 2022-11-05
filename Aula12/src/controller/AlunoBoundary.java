package controller;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class AlunoBoundary extends Application {
	
	TextField txtId = new TextField();
	TextField txtNome = new TextField();
	TextField txtRa = new TextField();
	TextField txtDataNasc = new TextField();
	Button btnAdc = new Button("Adicionar");
	Button btnPsq = new Button("Pesquisar");
	
	public List<Aluno> lista = new ArrayList<>();


	@Override
	public void start(Stage stage) throws Exception {
		
		GridPane grid = new GridPane();
		Scene scn = new Scene(grid, 450, 250);

		Label lblId = new Label("ID:");
		grid.add(lblId, 0, 0);

		Label lblNome = new Label("Nome:");
		grid.add(lblNome, 0, 1);
		
		Label lblRa = new Label("RA:");
		grid.add(lblRa, 0, 2);
		
		Label lblDataNasc = new Label("Nascimento:");
		grid.add(lblDataNasc, 0, 3);
		
		grid.add(txtId, 1, 0);
		grid.add(txtNome, 1, 1);
		grid.add(txtRa, 1, 2);
		grid.add(txtDataNasc, 1, 3);
		
		grid.add(btnAdc, 0, 4);
		grid.add(btnPsq, 1, 4);
		
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(15);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(15);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(15);
		RowConstraints row4 = new RowConstraints();
		row4.setPercentHeight(15);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(15);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(15);

		
		grid.getRowConstraints().addAll(row1, row2, row3, row4);
		grid.getColumnConstraints().addAll(col1);
		
		
		
		btnAdc.setOnAction(e->{Aluno a = boundaryToEntity();
			lista.add(a);
			cleanBoundary();
		});
		
		
		
		btnPsq.setOnAction(e->{for (Aluno a : lista) { 
				if (a.getNome().contains(txtNome.getText())) { 
					entityToBoundary(a);
				}
			}
		});
		
		stage.setScene(scn);
		stage.setTitle("Gest�o de Aluno");
		stage.show();
		
		
	}
	
		public Aluno boundaryToEntity() {
			Aluno a = new Aluno();
			a.setId(
					Long.parseLong(txtId.getText())
				    );
			a.setNome(txtNome.getText());
			a.setRa(txtRa.getText());
			a.setDataNasc(txtDataNasc.getText());
			return a;
		}
		
			
		public void entityToBoundary(Aluno a) {
			txtId.setText(String.valueOf(a.getId()));
			txtNome.setText(a.getNome());
			txtRa.setText(a.getRa());
			txtDataNasc.setText(a.getDataNasc());
		}
		
		public void cleanBoundary() { 
			txtId.setText("");
			txtNome.setText("");
			txtRa.setText("");
			txtDataNasc.setText("");
		}
		
		public static void main(String[] args) {
			Application.launch(AlunoBoundary.class, args);
		}

		
		
	}
	
	

