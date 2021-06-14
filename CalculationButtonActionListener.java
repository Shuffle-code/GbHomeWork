import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculationButtonActionListener implements ActionListener {
    private final JTextField textField;

    public CalculationButtonActionListener(JTextField textField) {
        this.textField = textField;
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if (textField.getText().indexOf("+") != -1) {
            String[] operands = textField.getText().split("\\+");
            int sum = 0;
            for (int i = 0; i < operands.length; i++) {
                sum += Integer.parseInt(operands[i]);
            }
            textField.setText(String.valueOf(sum));
        } else if (textField.getText().indexOf("-") != -1) {
            String[] operands = textField.getText().split("\\-");
            int sum = Integer.parseInt(operands[0]);
            for (int i = 1; i < operands.length; i++) {
                sum -= Integer.parseInt(operands[i]);
//            sum = sum - Integer.parseInt(operands[i]);
            }
            textField.setText(String.valueOf(sum));
        } else if (textField.getText().indexOf("/") != -1) {
            String[] operands = textField.getText().split("\\/");
            int sum = Integer.parseInt(operands[0]);
            for (int i = 1; i < operands.length; i++) {
                sum /= Integer.parseInt(operands[i]);
            }
            textField.setText(String.valueOf(sum));


        } else if (textField.getText().indexOf("*") != -1) {
            String[] operands = textField.getText().split("\\*");
            int sum = Integer.parseInt(operands[0]);
            for (int i = 1; i < operands.length; i++) {
                sum *= Integer.parseInt(operands[i]);
            }
            textField.setText(String.valueOf(sum));
//
        } else if (textField.getText().indexOf("√") != -1) {
            String[] operands = textField.getText().split("\\√");
            double sum = Integer.parseInt(operands[0]);
                sum = Math.sqrt(Integer.parseInt(operands[0]));


            textField.setText(String.valueOf(sum));
        }
    }
}
