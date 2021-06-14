import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CalculatorFrame extends JFrame {
    private JTextField inputArea;
    public CalculatorFrame(){
        setTitle("Calculator V1.0");
        setBounds(900, 100, 300,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
        setLayout(new BorderLayout());

        add(createTopPanel(),BorderLayout.NORTH);
        add(createCenterPanel(),BorderLayout.CENTER);
        add(createRightPanel(),BorderLayout.EAST);
        add(createBottomPanel(),BorderLayout.SOUTH);

        setVisible(true);
    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenu("Exit");
        JMenuItem openItem = new JMenu("Open");
        fileMenu.add(openItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        return menuBar;
    }
    private JPanel createTopPanel(){
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        inputArea = new JTextField();
        inputArea.setEditable(false);
        top.add(inputArea,BorderLayout.CENTER);
        return top;
    }
    private JPanel createBottomPanel(){
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1,1));
        JButton equally = new JButton("=");
        equally.addActionListener(new CalculationButtonActionListener(inputArea));
        bottom.add(equally);
        return bottom;
    }
    private JPanel createCenterPanel(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4,3));
        DigitButtonActionListener digitButtonActionListener = new DigitButtonActionListener(inputArea);

        for (int i = 1; i < 10; i++){
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(digitButtonActionListener);
            center.add(btn);
        }
        JButton clear = new JButton("C");
        clear.addActionListener(e -> inputArea.setText(""));

        center.add(clear);

        JButton zero = new JButton("0");
        zero.addActionListener(digitButtonActionListener);
        center.add(zero);

        JButton squareRoot  = new JButton("√");
        squareRoot.addActionListener(e -> inputArea.setText(inputArea.getText() + "√"));
//        squareRoot.addActionListener(new CalculationButtonActionListener(inputArea));
        center.add(squareRoot);

        return center;
    }
    private JPanel createRightPanel(){
        JPanel right  = new JPanel();
        right.setLayout(new GridLayout(4,1));

        JButton addition = new JButton("+");
        addition.addActionListener(e -> inputArea.setText(inputArea.getText() + "+"));
        right.add(addition);

        JButton subtraction  = new JButton("-");
        subtraction.addActionListener(e -> inputArea.setText(inputArea.getText() + "-"));
        right.add(subtraction);

        JButton multiplication  = new JButton("*");
        multiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputArea.setText(inputArea.getText() + "*");
            }
        });
        right.add(multiplication);

        JButton division  = new JButton("/");
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputArea.setText(inputArea.getText() + "/");
            }
        });
        right.add(division);

        return right;
    }
}

