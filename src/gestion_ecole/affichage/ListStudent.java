package gestion_ecole.affichage;


import java.awt.Dimension;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gestion_ecole.service.StudentModel;

public class ListStudent extends JPanel {
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private JTable jtable;
	
	public ListStudent( List<StudentModel> studentList ) {
		super();
		this.setPreferredSize(new Dimension(500, 400));
		JLabel label = new JLabel("List student works");
		this.add(label);
		
		String[] columns = { "identifiant", "nom", "prénom" };
		
		this.tableModel = new DefaultTableModel(columns, 0);
		
		for( StudentModel stud : studentList ) {
			Object[] rowData = { stud.getId(), stud.getFirstname(), stud.getLastname() };
			tableModel.addRow(rowData);
		}
		
		this.jtable = new JTable(tableModel);
		this.jtable.getColumnModel().getColumn(0).setPreferredWidth(20);
		this.jtable.getColumnModel().getColumn(1).setPreferredWidth(30);
		this.jtable.getColumnModel().getColumn(2).setPreferredWidth(30);
		
		JScrollPane scrollPane = new JScrollPane(this.jtable);
		scrollPane.setPreferredSize(new Dimension(300, 400));
		this.add(scrollPane);
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public JTable getJtable() {
		return jtable;
	}

	public void setJtable(JTable jtable) {
		this.jtable = jtable;
	}
	
	public void updateTable( List<StudentModel> studentList ) {
		// Clear existing data in the DefaultTableModel
        this.getTableModel().setRowCount(0);

        // Populate the table model with updated data
        for (StudentModel student : studentList) {
            Object[] rowData = {student.getId(), student.getFirstname(), student.getLastname()};
            this.getTableModel().addRow(rowData);
        }

        // Notify the table that the data has changed
        this.getTableModel().fireTableDataChanged();
	}
	
}
