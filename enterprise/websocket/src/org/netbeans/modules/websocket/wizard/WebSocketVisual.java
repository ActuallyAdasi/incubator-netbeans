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
package org.netbeans.modules.websocket.wizard;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.event.ChangeListener;

import org.openide.WizardDescriptor;
import org.openide.util.NbBundle;

/**
 *
 * @author den
 */
class WebSocketVisual extends javax.swing.JPanel {

    WebSocketVisual(WizardDescriptor myDescriptor) {
        initComponents();
        myUri.setText("/endpoint");         // NOI18N
        myListeners = new CopyOnWriteArrayList<ChangeListener>();
    }
    
    void addChangeListener( ChangeListener listener ) {
        myListeners.add(listener);
    }

    String getError() {
        if ( myUri.getText().trim().length() == 0 ){
            return NbBundle.getMessage(WebSocketVisual.class, "ERR_EmptyUri");  // NOI18N
        }
        return null;
    }

    void readSettings( WizardDescriptor descriptor ) {
        // TODO Auto-generated method stub
        
    }

    void removeChangeListener( ChangeListener listener ) {
        myListeners.remove(listener);
    }

    void storeSettings( WizardDescriptor descriptor ) {
        descriptor.putProperty(WebSocketPanel.URI, myUri.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPathLbl = new javax.swing.JLabel();
        myUri = new javax.swing.JTextField();

        myPathLbl.setLabelFor(myUri);
        org.openide.awt.Mnemonics.setLocalizedText(myPathLbl, org.openide.util.NbBundle.getMessage(WebSocketVisual.class, "LBL_URI")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(myPathLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myUri, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myPathLbl)
                    .addComponent(myUri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        myPathLbl.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(WebSocketVisual.class, "ACSN_URI")); // NOI18N
        myPathLbl.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(WebSocketVisual.class, "ACSD_URI")); // NOI18N
        myUri.getAccessibleContext().setAccessibleName(myPathLbl.getAccessibleContext().getAccessibleName());
        myUri.getAccessibleContext().setAccessibleDescription(myPathLbl.getAccessibleContext().getAccessibleDescription());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel myPathLbl;
    private javax.swing.JTextField myUri;
    // End of variables declaration//GEN-END:variables

    private List<ChangeListener> myListeners;
}
