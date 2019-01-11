/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.j2ee.ejbcore.ejb.wizard.mdb;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import org.netbeans.modules.j2ee.common.J2eeProjectCapabilities;
import org.netbeans.modules.j2ee.deployment.common.api.MessageDestination;
import org.netbeans.modules.j2ee.ejbcore.api.codegeneration.JmsDestinationDefinition;
import org.netbeans.modules.j2ee.ejbcore.ejb.wizard.mdb.ActivationConfigProperties.AcknowledgeMode;
import org.netbeans.modules.j2ee.ejbcore.ejb.wizard.mdb.ActivationConfigProperties.ActivationConfigProperty;
import org.netbeans.modules.j2ee.ejbcore.ejb.wizard.mdb.ActivationConfigProperties.DestinationType;
import org.netbeans.modules.j2ee.ejbcore.ejb.wizard.mdb.ActivationConfigProperties.EjbVersion;
import org.netbeans.modules.j2ee.ejbcore.ejb.wizard.mdb.ActivationConfigProperties.SubscriptionDurability;
import org.openide.WizardDescriptor;
import org.openide.util.NbBundle.Messages;

/**
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
@SuppressWarnings("serial") // not used to be serialized
public class MdbPropertiesPanelVisual extends javax.swing.JPanel {

    private final J2eeProjectCapabilities eeProjectCapabilities;
    private TableModel tableModel;
    private MessageDestination destination;

    /**
     * Creates new form MdbPropertiesPanelVisual.
     *
     * @param eeProjectCapabilities capabilities of the project where the MDB will be created
     */
    public MdbPropertiesPanelVisual(J2eeProjectCapabilities eeProjectCapabilities) {
        this.eeProjectCapabilities = eeProjectCapabilities;
        initComponents();
        updateTableUI();
    }

    private TableModel getPropertiesTableModel() {
        if (tableModel == null) {
            tableModel = new ACPTableModel(getActivationConfigProperties());
        }
        return tableModel;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        propertiesScrollPane = new javax.swing.JScrollPane();
        propertiesTable = new javax.swing.JTable();

        setName(org.openide.util.NbBundle.getMessage(MdbPropertiesPanelVisual.class, "LBL_SpecifyActivationProperties")); // NOI18N
        setPreferredSize(new java.awt.Dimension(460, 300));

        propertiesTable.setModel(getPropertiesTableModel());
        propertiesTable.setRowHeight(20);
        propertiesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        propertiesScrollPane.setViewportView(propertiesTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(propertiesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(propertiesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane propertiesScrollPane;
    private javax.swing.JTable propertiesTable;
    // End of variables declaration//GEN-END:variables

    private void updateTableUI() {
        TableColumnModel columnModel = propertiesTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(180);
        TableColumn columnTwo = columnModel.getColumn(1);
        columnTwo.setPreferredWidth(280);
        columnTwo.setCellEditor(createCellEditor(getActivationConfigProperties()));
        columnTwo.setCellRenderer(new ACPCellRenderer(getActivationConfigProperties()));
        propertiesTable.setSelectionModel(new NullSelectionModel());
    }

    private ACPCellEditor createCellEditor(List<ActivationConfigProperty> activationConfigProperties) {
        ACPCellEditor tce = new ACPCellEditor(propertiesTable);
        for (int i = 0; i < activationConfigProperties.size(); i++) {
            ActivationConfigProperty acp = activationConfigProperties.get(i);
            if (acp.getPropertyClass() == String.class) {
                tce.setEditorAt(i, new DefaultCellEditor(new JTextField()));
            } else if (acp.getPropertyClass().isEnum()) {
                Object[] consts = acp.getPropertyClass().getEnumConstants();
                JComboBox comboBox = new JComboBox(consts);
                tce.setEditorAt(i, new DefaultCellEditor(comboBox));
            }
        }
        return tce;
    }

    private List<ActivationConfigProperty> getActivationConfigProperties() {
        List<ActivationConfigProperty> activationConfigProperties;
        // XXX - it looks like EJB32 properties should be assumed already since EJB30
//        if (eeProjectCapabilities.isEjb32Supported()) {
        activationConfigProperties = ActivationConfigProperties.getActivationConfigProperties(EjbVersion.EJB_3_2);
//        } else {
//            activationConfigProperties = ActivationConfigProperties.getActivationConfigProperties(EjbVersion.EJB_3_0);
//        }
        return activationConfigProperties;
    }

    public Map<String, String> getProperties() {
        Map<String, String> props = new HashMap<String, String>();
        for (int i = 0; i < propertiesTable.getRowCount(); i++) {
            Object value = propertiesTable.getValueAt(i, 1);
            if (value instanceof String) {
                if (!((String) value).isEmpty()) {
                    props.put((String) propertiesTable.getValueAt(i, 0), (String) value);
                }
            } else if (value instanceof AcknowledgeMode) {
                if (((AcknowledgeMode) value) != AcknowledgeMode.AUTO_ACKNOWLEDGE) {
                    props.put((String) propertiesTable.getValueAt(i, 0), ((AcknowledgeMode) value).getValue());
                }
            } else if (value instanceof DestinationType) {
                props.put((String) propertiesTable.getValueAt(i, 0), ((DestinationType) value).getValue());
            } else if (value instanceof SubscriptionDurability) {
                if (((SubscriptionDurability) value) != SubscriptionDurability.NON_DURABLE) {
                    props.put((String) propertiesTable.getValueAt(i, 0), ((SubscriptionDurability) value).getValue());
                }
            }
        }
        return props;
    }

    public void setProperty(String propertyName, Object propertyValue) {
        for (int i = 0; i < propertiesTable.getRowCount(); i++) {
            if (!propertyName.equals(propertiesTable.getValueAt(i, 0))) {
                continue;
            } else {
                propertiesTable.setValueAt(propertyValue, i, 1);
            }
        }
    }

    public void setDefaultProperties(MessageDestination destination) {
        eraseAllProperties();
        switch (destination.getType()) {
            case QUEUE:
                setProperty(ActivationConfigProperties.ACKNOWLEDGE_MODE, AcknowledgeMode.AUTO_ACKNOWLEDGE);
                setProperty(ActivationConfigProperties.DESTINATION_TYPE, DestinationType.QUEUE);
                if (eeProjectCapabilities.isEjb32Supported()) {
                    setProperty(ActivationConfigProperties.DESTINATION_LOOKUP, destination.getName());
                }
                break;

            case TOPIC:
                setProperty(ActivationConfigProperties.ACKNOWLEDGE_MODE, AcknowledgeMode.AUTO_ACKNOWLEDGE);
                setProperty(ActivationConfigProperties.CLIENT_ID, destination.getName());
                setProperty(ActivationConfigProperties.DESTINATION_TYPE, DestinationType.TOPIC);
                setProperty(ActivationConfigProperties.SUBSCRIPTION_DURABILITY, SubscriptionDurability.DURABLE);
                setProperty(ActivationConfigProperties.SUBSCRIPTION_NAME, destination.getName());
                if (eeProjectCapabilities.isEjb32Supported()) {
                    setProperty(ActivationConfigProperties.DESTINATION_LOOKUP, destination.getName());
                }
                break;

            default:
                throw new UnsupportedOperationException("Not valid destination type: " + destination.getType().name());
        }
    }

    void read(WizardDescriptor descriptor) {
        destination = (MessageDestination) descriptor.getProperty(MdbWizard.PROP_DESTINATION_TYPE);
        setDefaultProperties(destination);
    }

    private void eraseAllProperties() {
        setProperty(ActivationConfigProperties.ACKNOWLEDGE_MODE, AcknowledgeMode.AUTO_ACKNOWLEDGE);
        setProperty(ActivationConfigProperties.CLIENT_ID, "");
        setProperty(ActivationConfigProperties.CONNECTION_FACTORY_LOOKUP, "");
        setProperty(ActivationConfigProperties.DESTINATION_LOOKUP, "");
        setProperty(ActivationConfigProperties.DESTINATION_TYPE, DestinationType.QUEUE);
        setProperty(ActivationConfigProperties.MESSAGE_SELECTOR, "");
        setProperty(ActivationConfigProperties.SUBSCRIPTION_DURABILITY, SubscriptionDurability.NON_DURABLE);
        setProperty(ActivationConfigProperties.SUBSCRIPTION_NAME, "");
    }

    @SuppressWarnings("serial") // not used to be serialized
    private static class ACPTableModel extends DefaultTableModel {

        private final List<ActivationConfigProperty> activationConfigProperties;

        public ACPTableModel(List<ActivationConfigProperty> activationConfigProperties) {
            this.activationConfigProperties = activationConfigProperties;
            initRows();
        }
        @Messages({
            "ACPTableModel.lbl.property.name=Property Name",
            "ACPTableModel.lbl.property.value=Property Value"
        })
        private static final String[] COLUMN_NAMES = new String[]{
            Bundle.ACPTableModel_lbl_property_name(),
            Bundle.ACPTableModel_lbl_property_value()
        };

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return column > 0;
        }

        private void initRows() {
            for (ActivationConfigProperty activationConfigProperty : activationConfigProperties) {
                if (activationConfigProperty.getPropertyClass().isEnum()) {
                    addRow(new Object[]{activationConfigProperty.getName(), activationConfigProperty.getPropertyClass().getEnumConstants()[0]});
                } else {
                    addRow(new Object[]{activationConfigProperty.getName(), null});
                }
            }
        }
    }

    @SuppressWarnings("serial") // not used to be serialized
    private static class ACPCellRenderer extends JComboBox implements TableCellRenderer {

        private final DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();
        private final List<ActivationConfigProperty> acp;

        public ACPCellRenderer(List<ActivationConfigProperty> activationConfigProperties) {
            this.acp = activationConfigProperties;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof String) {
                return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            } else if (value instanceof AcknowledgeMode) {
                JComboBox combo = new ComboCellRenderer(AcknowledgeMode.values(), table);
                combo.setSelectedItem(value);
                return combo;
            } else if (value instanceof ActivationConfigProperties.DestinationType) {
                JComboBox combo = new ComboCellRenderer(DestinationType.values(), table);
                combo.setSelectedItem(value);
                return combo;
            } else if (value instanceof ActivationConfigProperties.SubscriptionDurability) {
                JComboBox combo = new ComboCellRenderer(SubscriptionDurability.values(), table);
                combo.setSelectedItem(value);
                return combo;
            }
            return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    @SuppressWarnings("serial") // not used to be serialized
    private static class ComboCellRenderer extends JComboBox {

        public ComboCellRenderer(Object[] items, JTable table) {
            super(items);
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
    }

    private static class ACPCellEditor implements TableCellEditor {

        private final Map<Integer, TableCellEditor> cellEditors = new HashMap<Integer, TableCellEditor>();
        private TableCellEditor editor, defaultEditor = new DefaultCellEditor(new JTextField());
        private final JTable table;

        public ACPCellEditor(JTable table) {
            this.table = table;
        }

        /**
         * @param row table row
         * @param editor table cell editor
         */
        public void setEditorAt(int row, TableCellEditor editor) {
            cellEditors.put(row, editor);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
        }

        @Override
        public Object getCellEditorValue() {
            return editor.getCellEditorValue();
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            selectEditor(anEvent);
            return editor.isCellEditable(anEvent);
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            selectEditor(anEvent);
            return editor.shouldSelectCell(anEvent);
        }

        @Override
        public boolean stopCellEditing() {
            return editor.stopCellEditing();
        }

        @Override
        public void cancelCellEditing() {
            editor.cancelCellEditing();
        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {
            editor.addCellEditorListener(l);
        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {
            editor.removeCellEditorListener(l);
        }

        protected void selectEditor(EventObject e) {
            int row;
            if (e instanceof MouseEvent) {
                if (e == null) {
                    row = table.getSelectionModel().getAnchorSelectionIndex();
                } else {
                    row = table.rowAtPoint(((MouseEvent) e).getPoint());
                }
            } else {
                row = table.getSelectionModel().getAnchorSelectionIndex();
            }
            editor = (TableCellEditor) cellEditors.get(row);
            if (editor == null) {
                editor = defaultEditor;
            }
        }
    }

    private static class NullSelectionModel implements ListSelectionModel {

        @Override
        public boolean isSelectionEmpty() {
            return true;
        }

        @Override
        public boolean isSelectedIndex(int index) {
            return false;
        }

        @Override
        public int getMinSelectionIndex() {
            return -1;
        }

        @Override
        public int getMaxSelectionIndex() {
            return -1;
        }

        @Override
        public int getLeadSelectionIndex() {
            return -1;
        }

        @Override
        public int getAnchorSelectionIndex() {
            return -1;
        }

        @Override
        public void setSelectionInterval(int index0, int index1) {
        }

        @Override
        public void setLeadSelectionIndex(int index) {
        }

        @Override
        public void setAnchorSelectionIndex(int index) {
        }

        @Override
        public void addSelectionInterval(int index0, int index1) {
        }

        @Override
        public void insertIndexInterval(int index, int length, boolean before) {
        }

        @Override
        public void clearSelection() {
        }

        @Override
        public void removeSelectionInterval(int index0, int index1) {
        }

        @Override
        public void removeIndexInterval(int index0, int index1) {
        }

        @Override
        public void setSelectionMode(int selectionMode) {
        }

        @Override
        public int getSelectionMode() {
            return SINGLE_SELECTION;
        }

        @Override
        public void addListSelectionListener(ListSelectionListener lsl) {
        }

        @Override
        public void removeListSelectionListener(ListSelectionListener lsl) {
        }

        @Override
        public void setValueIsAdjusting(boolean valueIsAdjusting) {
        }

        @Override
        public boolean getValueIsAdjusting() {
            return false;
        }
    }
}
