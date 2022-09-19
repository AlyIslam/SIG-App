package View;

import Model.invoiceHeader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Model.invoiceHeader.*;
import static javax.swing.BorderFactory.*;
public class userInterface extends JFrame implements ActionListener{
    String[][] invoicesData;
    public userInterface(String title){

        //Basic JFrame setup//
        super(title);
        setSize(1000,650);
        setLocation(170,10);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        //--------------------------------//

        //Panel division//
        setLayout(new GridLayout(1,2));
        JPanel leftPanel = new JPanel();
        JPanel rightPanel=new JPanel();
        add(leftPanel);
        add(rightPanel);
        //--------------------------------//

        //Menu bar with "File" button//
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenuItem loadFile = new JMenuItem("Load File");
        JMenuItem saveFile = new JMenuItem("Save File");
        setJMenuBar(menuBar);
        menuBar.add(menu1);
        menu1.add(loadFile);
        menu1.add(saveFile);
        //--------------------------------//

        //Left panel table//
        String[] headers={"No.","Date","Customer","Total"};

        String[] row1= {"1","22-11-2020","Ali","500"};
        String[] row2= {"2","13-10-2021","Saleh","1000"};
        String[] row3= {"","","",""};
        String[] row4= {"","","",""};
        invoicesData= new String[][]{row1, row2, row3,row4};
        JTable invoicesTable=new JTable(invoicesData,headers);
        leftPanel.add(new JScrollPane(invoicesTable));
        leftPanel.setBorder(createTitledBorder("Invoices Table"));
        //invoicesTable.setEnabled(false);
        //--------------------------------//

        //Left panel buttons//
        JButton createNewInvoice=new JButton("Create New Invoice");
        createNewInvoice.setActionCommand("CNI");
        createNewInvoice.addActionListener(this);
        JButton deleteInvoice=new JButton("Delete Invoice");
        leftPanel.add(createNewInvoice);
        leftPanel.add(deleteInvoice);
        //--------------------------------//


        //Right panel labels and fields//
        JLabel label1 = new JLabel("Invoice Number         ");
        rightPanel.add(label1);

        JTextArea textArea1=new JTextArea(String.valueOf(invoiceHeader.invoiceNum));
        textArea1.setEditable(false);
        textArea1.setColumns(30);
        rightPanel.add(textArea1);

        JLabel label2 = new JLabel("Invoice Date               ");
        rightPanel.add(label2);

        JTextField textField1=new JTextField(30);
        invoiceDate=textField1.getText();
        rightPanel.add(textField1);

        JLabel label3 = new JLabel("Customer Name        ");
        rightPanel.add(label3);

        JTextField textField2=new JTextField(30);
        invoiceHeader.customerName=textField2.getText();
        rightPanel.add(textField2);

        JLabel label4 = new JLabel("Invoice Total              ");
        rightPanel.add(label4);

        JTextArea textArea2=new JTextArea("");
        textArea2.setEditable(false);
        textArea2.setColumns(30);
        rightPanel.add(textArea2);
        //--------------------------------//

        //Right panel table//
        int numberOfItems=0;
        String[][] data= new String[5][numberOfItems+5];
        String[] headings2={"No.","Item Name","Item Price","Count","Item Total"};
        JTable itemsTable=new JTable(data,headings2);
        JPanel tablePanel = new JPanel();
        rightPanel.add(tablePanel);
        tablePanel.setBorder(createTitledBorder("Invoice Items"));
        tablePanel.add(new JScrollPane(itemsTable));
        //--------------------------------//

        //Right panel buttons//
        JButton save=new JButton("Save");
        save.setActionCommand("save");
        save.addActionListener(this);
        JButton cancel=new JButton("Cancel");
        rightPanel.add(save);
        rightPanel.add(cancel);
        //--------------------------------//
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("CNI")){
            invoiceHeader newInvoice= new invoiceHeader();
        }
        if(e.getActionCommand().equals("save")){
            //String [] row3={String.valueOf(invoiceNum),invoiceDate,customerName,"400"};
            invoicesData[0][invoiceNum+2]=String.valueOf(invoiceNum);
            invoicesData[1][invoiceNum+2]=invoiceDate;
            invoicesData[2][invoiceNum+2]=customerName;
            invoicesData[3][invoiceNum+2]="400";
        }
    }
}

