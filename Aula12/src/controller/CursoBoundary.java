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

public class CursoBoundary extends Application{
	
	TextField txtId = new TextField();
	TextField txtNome = new TextField();
	TextField txtCod = new TextField();
	TextField txtNomeCoor = new TextField();
	TextField txtQtdAl = new TextField();
	Button btnAdc = new Button("Adicionar");
	Button btnPsq = new Button("Pesquisar");
	
	public List<Curso> curso = new ArrayList<>();
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		GridPane grid = new GridPane();
		Scene scn = new Scene(grid, 400, 250);
		
		grid.add(txtId, 1, 0);
		grid.add(txtNome, 1, 1);
		grid.add(txtCod, 1, 2);
		grid.add(txtNomeCoor, 1, 3);
		grid.add(txtQtdAl, 1, 4);
		
		
		Label lblId = new Label("ID:");
		grid.add(lblId, 0, 0);
		Label lblNome = new Label("Nome:");
		grid.add(lblNome, 0, 1);
		Label lblCod = new Label("Código:");
		grid.add(lblCod, 0, 2);
		Label lblNomeCoor = new Label("Nome do Coordenador:");
		grid.add(lblNomeCoor, 0, 3);
		Label lblQtdAl = new Label("Quantidade de Alunos:");
		grid.add(lblQtdAl, 0, 4);
		
		grid.add(btnAdc, 0, 5);
		grid.add(btnPsq, 1, 5);
		
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(15);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(15);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(15);
		RowConstraints row4 = new RowConstraints();
		row4.setPercentHeight(15);
		RowConstraints row5 = new RowConstraints();
		row5.setPercentHeight(15);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(35);
		
		
		grid.getRowConstraints().addAll(row1, row2, row3, row4, row5);
		grid.getColumnConstraints().addAll(col1);
		
		
		
		stage.setScene(scn);
		stage.setTitle("Curso");
		stage.show();
		
		btnAdc.setOnMouseClicked(e->{Curso c = boundaryToEntity();
			curso.add(c);
			cleanEntity();
		});
		
		
		btnPsq.setOnMouseClicked(e->{for (Curso c : curso){
				if(c.getNome().contains(txtNome.getText())) {
					entityToBoundary(c);
				}}});
		
		}
	
	
	public Curso boundaryToEntity() {
		Curso c = new Curso();
		c.setId(Long.parseLong(txtId.getText()));
		c.setNome(txtNome.getText());
		c.setCod(Long.parseLong(txtCod.getText()));
		c.setNomeCoor(txtNomeCoor.getText());
		c.setQtdAl(Integer.parseInt(txtQtdAl.getText()));
		return c;
	}
	
	public void entityToBoundary(Curso c) {
		txtId.setText(String.valueOf(c.getId()));
		txtNome.setText(c.getNome());
		txtCod.setText(String.valueOf(c.getCod()));
		txtNomeCoor.setText(c.getNomeCoor());
		txtQtdAl.setText(String.valueOf(c.getQtdAl()));
	}
	
	public Curso cleanEntity() {
		Curso c = new Curso();
		txtId.setText("");
		txtNome.setText("");
		txtNomeCoor.setText("");
		txtCod.setText("");
		txtQtdAl.setText("");
		return c;
	}
	
	public static void main(String[] args) {
		Application.launch(CursoBoundary.class, args);
	}

}
