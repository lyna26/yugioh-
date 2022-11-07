package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardInfosController implements Initializable {
	
	@FXML  
	ImageView bigCardImageView;
	
	@FXML
	TextArea cardDescriptionTextArea ;

	public void setBigCardImageView(String Image) {
		bigCardImageView.setImage(new Image(Image));
	}


	public void setCardDescriptionTextArea(String text) {
		cardDescriptionTextArea.setText(text);
	}
	
	
	@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("init");
    }
}
