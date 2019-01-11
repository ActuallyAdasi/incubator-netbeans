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

/*
 * AddAnnotationProcessor.java
 *
 * Created on Jan 26, 2010, 11:35:56 AM
 */
package org.netbeans.modules.java.j2seproject.ui.customizer;

import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Dusan Balek
 */
class AddProcessorOption extends javax.swing.JPanel {

    private ChangeListener changeListener;

    /** Creates new form AddAnnotationProcessor */
    AddProcessorOption() {
        initComponents();
        keyTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (changeListener != null)
                    changeListener.stateChanged(null);
            }
        });
    }

    void addChangeListener(ChangeListener l) {
        changeListener = l;
    }

    void removeChangeListener(ChangeListener l) {
        changeListener = null;
    }

    String getOptionKey() {
        return keyTextField.getText().trim();
    }

    String getOptionValue() {
        return valueTextField.getText().trim();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        keyLabel = new javax.swing.JLabel();
        keyTextField = new javax.swing.JTextField();
        valueLabel = new javax.swing.JLabel();
        valueTextField = new javax.swing.JTextField();

        keyLabel.setLabelFor(keyTextField);
        org.openide.awt.Mnemonics.setLocalizedText(keyLabel, org.openide.util.NbBundle.getMessage(AddProcessorOption.class, "LBL_ProcessorOptionKey")); // NOI18N

        valueLabel.setLabelFor(valueTextField);
        org.openide.awt.Mnemonics.setLocalizedText(valueLabel, org.openide.util.NbBundle.getMessage(AddProcessorOption.class, "LBL_ProcessorOptionValue")); // NOI18N

        valueTextField.setText(org.openide.util.NbBundle.getMessage(AddProcessorOption.class, "AddProcessorOption.valueTextField.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keyLabel)
                    .addComponent(valueLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valueTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(keyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyLabel)
                    .addComponent(keyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueLabel)
                    .addComponent(valueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        keyTextField.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(AddProcessorOption.class, "T_ACSN_ProcessorOptionKey")); // NOI18N
        keyTextField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AddProcessorOption.class, "T_ACSD_ProcessorOptionKey")); // NOI18N
        valueTextField.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(AddProcessorOption.class, "T_ACSN_ProcessorOptionValue")); // NOI18N
        valueTextField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(AddProcessorOption.class, "T_ACSD_ProcessorOptionValue")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel keyLabel;
    private javax.swing.JTextField keyTextField;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTextField valueTextField;
    // End of variables declaration//GEN-END:variables
}
