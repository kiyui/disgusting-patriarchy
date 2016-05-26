package com.Kiyivinski.graphical.listeners;

import com.Kiyivinski.graphical.UnitTable;
import com.Kiyivinski.graphical.listeners.interfaces.ModelTableInterface;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UnitTableRowListener implements ListSelectionListener {
    private UnitTable table;
    private ModelTableInterface observer;

    public UnitTableRowListener(UnitTable table, ModelTableInterface observer) {
        this.table = table;
        this.observer = observer;
    }

    /**
     * Called whenever the value of the selection changes.
     *
     * @param e the event that characterizes the change.
     */
    public void valueChanged(ListSelectionEvent e) {
        if (! e.getValueIsAdjusting()) {
            String id = table.getValueAt(table.getSelectedRow(), 0).toString();
            observer.updateModelForm(id);
        }
    }
}
