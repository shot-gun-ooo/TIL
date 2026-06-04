package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL; // For loading resources from classpath

public class SimpleCalculator extends JFrame implements ActionListener {

    private JTextField display;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, equalsButton, clearButton, decimalButton;

    private double num1 = 0;
    private double num2 = 0;
    private char operator = ' ';
    private boolean expectingNewNumber = true; // Flag to indicate if the next digit should start a new number

    // Define colors for better contrast and realism
    private static final Color DISPLAY_BG_COLOR = Color.decode("#263238"); // Dark background for display
    private static final Color DISPLAY_FG_COLOR = Color.WHITE; // White text for display
    private static final Color NUMBER_BUTTON_BG = Color.WHITE;
    private static final Color NUMBER_BUTTON_FG = Color.BLACK;
    private static final Color OPERATOR_BUTTON_BG = Color.decode("#7E57C2"); // Deep Purple for operators
    private static final Color OPERATOR_BUTTON_FG = Color.WHITE;
    private static final Color CLEAR_BUTTON_BG = Color.decode("#E53935"); // Red for Clear
    private static final Color CLEAR_BUTTON_FG = Color.WHITE;
    private static final Color EQUALS_BUTTON_BG = Color.decode("#4CAF50"); // Green for Equals
    private static final Color EQUALS_BUTTON_FG = Color.WHITE;
    private static final Color DECIMAL_BUTTON_BG = Color.WHITE;
    private static final Color DECIMAL_BUTTON_FG = Color.BLACK;

    public SimpleCalculator() {
        // Frame setup
        setTitle("Advanced Calculator");
        setSize(380, 550); // Slightly increased height to accommodate potential icon space
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Center the window

        // Set Frame Icon - IMPORTANT: Replace "calculator_icon.png" with your actual icon file path.
        // This image should be in a location accessible by the application.
        // For example, place it in a resource folder and load it like:
        // URL iconURL = getClass().getResource("/images/calculator_icon.png");
        // If using a simple file path, ensure the file exists relative to where the app is run, or use an absolute path.
        try {
            // Example using a common system resource if available, or replace with your path.
            // You can use absolute paths or relative paths from where the application is executed.
            // For example, if 'calculator_icon.png' is in the same directory as the .class file:
            // URL iconURL = getClass().getResource("calculator_icon.png");
            // If it's in a subfolder 'icons':
            // URL iconURL = getClass().getResource("/icons/calculator_icon.png");

            // If you have an icon file named 'calculator_icon.png' in the same directory:
            // ImageIcon frameIcon = new ImageIcon("calculator_icon.png");
            // if (frameIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            //     setIconImage(frameIcon.getImage());
            // } else {
            //     System.err.println("Warning: Frame icon 'calculator_icon.png' not found or could not be loaded.");
            // }

            // As a fallback, using a generic system icon if no image is provided
            // Replace this path with your actual icon file path.
            URL defaultIconURL = getClass().getResource("/icons/java_icon.png"); // Example path, adjust as needed.
            if (defaultIconURL != null) {
                setIconImage(new ImageIcon(defaultIconURL).getImage());
            } else {
                System.err.println("Warning: Default frame icon resource not found. Please provide a frame icon.");
            }
        } catch (Exception e) {
            System.err.println("Error setting frame icon: " + e.getMessage());
        }


        // Display panel
        display = new JTextField("0"); // Initialize with "0"
        display.setFont(new Font("Arial", Font.BOLD, 36)); // Larger font for display
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false); // User cannot type directly
        display.setBackground(DISPLAY_BG_COLOR);
        display.setForeground(DISPLAY_FG_COLOR);
        display.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 3), // Thicker border
                BorderFactory.createEmptyBorder(15, 15, 15, 15) // More padding
        ));
        add(display, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel();
        // Using a 5x4 grid for a more standard and functional calculator layout
        buttonPanel.setLayout(new GridLayout(5, 4, 7, 7)); // Slightly larger gaps between buttons
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around buttons

        // Initialize number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 24));
            numberButtons[i].setBackground(NUMBER_BUTTON_BG);
            numberButtons[i].setForeground(NUMBER_BUTTON_FG);
            numberButtons[i].setFocusPainted(false);
            numberButtons[i].addActionListener(this);
        }

        // Initialize special buttons
        decimalButton = new JButton(".");
        decimalButton.setFont(new Font("Arial", Font.BOLD, 24));
        decimalButton.setBackground(DECIMAL_BUTTON_BG);
        decimalButton.setForeground(DECIMAL_BUTTON_FG);
        decimalButton.setFocusPainted(false);
        decimalButton.addActionListener(this);

        clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.BOLD, 24));
        clearButton.setBackground(CLEAR_BUTTON_BG);
        clearButton.setForeground(CLEAR_BUTTON_FG);
        clearButton.setFocusPainted(false);
        clearButton.addActionListener(this);

        equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Arial", Font.BOLD, 24));
        equalsButton.setBackground(EQUALS_BUTTON_BG);
        equalsButton.setForeground(EQUALS_BUTTON_FG);
        equalsButton.setFocusPainted(false);
        equalsButton.addActionListener(this);

        // --- Operator Buttons ---
        // IMPORTANT: To add icons, you need to provide the image files and uncomment/modify the relevant lines.
        // For example, if you have 'plus.png' in the same directory:
        // ImageIcon plusIcon = new ImageIcon("plus.png");
        // addButton.setIcon(plusIcon);
        // addButton.setText(""); // Clear text if only icon is desired

        addButton = new JButton("+");
        addButton.setFont(new Font("Arial", Font.BOLD, 24));
        addButton.setBackground(OPERATOR_BUTTON_BG);
        addButton.setForeground(OPERATOR_BUTTON_FG);
        addButton.setFocusPainted(false);
        addButton.addActionListener(this);
        // Example: If 'plus.png' is available and you want it as the icon:
        // try {
        //     URL plusURL = getClass().getResource("/icons/plus.png"); // Example path
        //     if (plusURL != null) {
        //         ImageIcon plusIcon = new ImageIcon(plusURL);
        //         // Check if image loaded correctly before setting
        //         if (plusIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
        //             addButton.setIcon(plusIcon);
        //             addButton.setText(""); // Remove text if icon is sufficient
        //         } else {
        //              System.err.println("Warning: '+' icon failed to load.");
        //         }
        //     }
        // } catch (Exception e) { System.err.println("Error loading '+' icon: " + e.getMessage()); }


        subButton = new JButton("-");
        subButton.setFont(new Font("Arial", Font.BOLD, 24));
        subButton.setBackground(OPERATOR_BUTTON_BG);
        subButton.setForeground(OPERATOR_BUTTON_FG);
        subButton.setFocusPainted(false);
        subButton.addActionListener(this);
        // Example for '-': uncomment and adjust path if 'minus.png' is available
        // try {
        //     URL minusURL = getClass().getResource("/icons/minus.png"); // Example path
        //     if (minusURL != null) {
        //         ImageIcon minusIcon = new ImageIcon(minusURL);
        //         if (minusIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
        //             subButton.setIcon(minusIcon);
        //             subButton.setText("");
        //         }
        //     }
        // } catch (Exception e) { System.err.println("Error loading '-' icon."); }


        mulButton = new JButton("*");
        mulButton.setFont(new Font("Arial", Font.BOLD, 24));
        mulButton.setBackground(OPERATOR_BUTTON_BG);
        mulButton.setForeground(OPERATOR_BUTTON_FG);
        mulButton.setFocusPainted(false);
        mulButton.addActionListener(this);
        // Example for '*': uncomment and adjust path if 'multiply.png' is available
        // try {
        //     URL multiplyURL = getClass().getResource("/icons/multiply.png"); // Example path
        //     if (multiplyURL != null) {
        //         ImageIcon multiplyIcon = new ImageIcon(multiplyURL);
        //         if (multiplyIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
        //             mulButton.setIcon(multiplyIcon);
        //             mulButton.setText("");
        //         }
        //     }
        // } catch (Exception e) { System.err.println("Error loading '*' icon."); }

        divButton = new JButton("/");
        divButton.setFont(new Font("Arial", Font.BOLD, 24));
        divButton.setBackground(OPERATOR_BUTTON_BG);
        divButton.setForeground(OPERATOR_BUTTON_FG);
        divButton.setFocusPainted(false);
        divButton.addActionListener(this);
        // Example for '/': uncomment and adjust path if 'divide.png' is available
        // try {
        //     URL divideURL = getClass().getResource("/icons/divide.png"); // Example path
        //     if (divideURL != null) {
        //         ImageIcon divideIcon = new ImageIcon(divideURL);
        //         if (divideIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
        //             divButton.setIcon(divideIcon);
        //             divButton.setText("");
        //         }
        //     }
        // } catch (Exception e) { System.err.println("Error loading '/' icon."); }


        // Add buttons to the panel using the 5x4 grid layout
        // Row 1: C, (empty), (empty), /
        buttonPanel.add(clearButton);
        buttonPanel.add(new JLabel("")); // Placeholder for spacing
        buttonPanel.add(new JLabel("")); // Placeholder for spacing
        buttonPanel.add(divButton);

        // Row 2: 7, 8, 9, *
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(mulButton);

        // Row 3: 4, 5, 6, -
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(subButton);

        // Row 4: 1, 2, 3, +
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(addButton);

        // Row 5: 0, ., =, (empty)
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(decimalButton);
        buttonPanel.add(equalsButton);
        buttonPanel.add(new JLabel("")); // Placeholder for spacing

        add(buttonPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Number buttons
        for (int i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                if (expectingNewNumber) {
                    display.setText(String.valueOf(i));
                    expectingNewNumber = false;
                } else {
                    // Prevent leading zeros if not after an operator
                    if (display.getText().equals("0")) {
                        display.setText(String.valueOf(i));
                    } else {
                        display.setText(display.getText() + i);
                    }
                }
                return;
            }
        }

        // Decimal button
        if (source == decimalButton) {
            if (expectingNewNumber) { // Start with 0. if a new number is expected
                display.setText("0.");
                expectingNewNumber = false;
            } else if (!display.getText().contains(".")) { // Only add decimal if not already present
                display.setText(display.getText() + ".");
            }
            return;
        }

        // Operator buttons (+, -, *, /)
        if (source == addButton || source == subButton || source == mulButton || source == divButton) {
            // If an operator is pressed after a number, perform the previous calculation first
            // unless it's the first number input.
            if (!expectingNewNumber) {
                calculate();
            }
            try {
                num1 = Double.parseDouble(display.getText());
            } catch (NumberFormatException ex) {
                display.setText("Error");
                return;
            }
            operator = ((JButton) source).getText().charAt(0);
            expectingNewNumber = true; // Next input should be a new number
            return;
        }

        // Equals button
        if (source == equalsButton) {
            calculate();
            operator = ' '; // Reset operator after calculation
            expectingNewNumber = true; // Next input can start a new calculation
            return;
        }

        // Clear button
        if (source == clearButton) {
            display.setText("0");
            num1 = 0;
            num2 = 0;
            operator = ' ';
            expectingNewNumber = true;
            return;
        }
    }

    private void calculate() {
        try {
            // If operator is empty, and we pressed '=', the num1 should be the current display value.
            if (operator == ' ') {
                num1 = Double.parseDouble(display.getText());
                return;
            }

            num2 = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        display.setText("Error: Div by 0");
                        num1 = 0; // Reset num1
                        operator = ' ';
                        expectingNewNumber = true;
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    return; // Should not happen
            }

            // Format the result: show as integer if it's a whole number
            if (result == (long) result) {
                display.setText(String.format("%d", (long) result));
            } else {
                // Limit decimal places for non-integers to avoid very long numbers
                // For now, just show the double value. Can be refined if needed.
                display.setText(String.valueOf(result));
            }

            num1 = result; // The result becomes the new num1 for chained operations
            expectingNewNumber = true; // Ready for a new operation or number

        } catch (NumberFormatException ex) {
            display.setText("Error");
            num1 = 0;
            operator = ' ';
            expectingNewNumber = true;
        }
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure GUI updates are on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleCalculator();
            }
        });
    }
}
