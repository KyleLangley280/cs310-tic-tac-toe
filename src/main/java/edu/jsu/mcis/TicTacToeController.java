package edu.jsu.mcis;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeController implements ActionListener{

    public final TicTacToeModel model;
    private final TicTacToeView view;
    private TicTacToeMove move;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this,width);
        
    }  

    public String getMarkAsString(int row, int col) {        
        return (model.getMark(row, col).toString());        
    }
    
    public TicTacToeView getView() {        
        return view;        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
      
            JButton button = (JButton)event.getSource();
            String workingButton = button.getName();
            char workingChar = workingButton.charAt(6);
            char workingChar2 = workingButton.charAt(7);
            int row = Integer.parseInt(String.valueOf(workingChar));
            int col = Integer.parseInt(String.valueOf(workingChar2));
            model.makeMark(row,col);
            view.updateSquares();
            if(model.getResult().equals(TicTacToeModel.Result.X)||model.getResult().equals(TicTacToeModel.Result.O)||model.getResult().equals(TicTacToeModel.Result.TIE)){
                view.showResult(model.getResult().toString());
                view.disableSquares();
            }
            else{
                
            }
        }
    
}
