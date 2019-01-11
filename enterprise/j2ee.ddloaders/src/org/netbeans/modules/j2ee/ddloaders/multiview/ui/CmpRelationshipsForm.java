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

package org.netbeans.modules.j2ee.ddloaders.multiview.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutFocusTraversalPolicy;
import org.netbeans.modules.j2ee.ddloaders.multiview.Utils;

/**
 * @author pfiala
 */
public class CmpRelationshipsForm extends javax.swing.JPanel {

    /**
     * Creates new form AddCmpRelationshipsForm
     */
    public CmpRelationshipsForm() {
        initComponents();
        errorLabel.setForeground(Utils.getErrorColor());
        org.netbeans.modules.xml.multiview.Utils.makeTextAreaLikeTextField(descriptionTextArea,
                relationshipNameTextField);
    }

    public FocusTraversalPolicy createFocusTraversalPolicy() {
        return new CustomFocusTraversalPolicy();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        multiplicityButtonGroup = new javax.swing.ButtonGroup();
        multiplicityButtonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        relationshipNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descriptionTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        roleNameTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        roleNameTextField2 = new javax.swing.JTextField();
        ejbComboBox = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        ejbComboBox2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        multiplicityOneRadioButton = new javax.swing.JRadioButton();
        multiplicityManyRadioButton = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        multiplicityOneRadioButton2 = new javax.swing.JRadioButton();
        multiplicityManyRadioButton2 = new javax.swing.JRadioButton();
        cascadeDeleteCheckBox = new javax.swing.JCheckBox();
        cascadeDeleteCheckBox2 = new javax.swing.JCheckBox();
        createCmrFieldCheckBox = new javax.swing.JCheckBox();
        createCmrFieldCheckBox2 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        fieldNameTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fieldNameTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fieldTypeComboBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        fieldTypeComboBox2 = new javax.swing.JComboBox();
        errorLabel = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setLabelFor(relationshipNameTextField);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_RelationshipName")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 5);
        add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(relationshipNameTextField, gridBagConstraints);
        relationshipNameTextField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "RelationshipName_AD")); // NOI18N

        jLabel3.setLabelFor(descriptionTextArea);
        jLabel3.setText(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_Description")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 5);
        add(jLabel3, gridBagConstraints);

        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setRows(3);
        descriptionTextArea.setWrapStyleWord(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(descriptionTextArea, gridBagConstraints);
        descriptionTextArea.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "Description_AN")); // NOI18N
        descriptionTextArea.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "Description_AD")); // NOI18N

        jLabel4.setLabelFor(ejbComboBox);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_EntityBean_1")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 12, 0, 5);
        add(jLabel4, gridBagConstraints);

        jLabel2.setLabelFor(roleNameTextField);
        jLabel2.setText(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_RoleName")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 5);
        add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(roleNameTextField, gridBagConstraints);
        roleNameTextField.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "RoleName_AN_1")); // NOI18N
        roleNameTextField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "RoleName_AD_1")); // NOI18N

        jLabel14.setLabelFor(roleNameTextField2);
        jLabel14.setText(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_RoleName")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 5);
        add(jLabel14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(roleNameTextField2, gridBagConstraints);
        roleNameTextField2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "RoleName_AN_2")); // NOI18N
        roleNameTextField2.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "RoleName_AD_2")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 12);
        add(ejbComboBox, gridBagConstraints);
        ejbComboBox.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "EntityBean_AN_1")); // NOI18N
        ejbComboBox.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "EntityBean_AD_1")); // NOI18N

        jLabel12.setLabelFor(ejbComboBox2);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel12, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_EntityBean_2")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 12, 0, 5);
        add(jLabel12, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 0, 12);
        add(ejbComboBox2, gridBagConstraints);
        ejbComboBox2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "EntityBean_AN_2")); // NOI18N
        ejbComboBox2.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "EntityBean_AD_2")); // NOI18N

        jLabel5.setText(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_Multiplicity")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 5);
        add(jLabel5, gridBagConstraints);

        multiplicityButtonGroup.add(multiplicityOneRadioButton);
        multiplicityOneRadioButton.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(multiplicityOneRadioButton, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_One_1")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(multiplicityOneRadioButton, gridBagConstraints);
        multiplicityOneRadioButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "One_AN_1")); // NOI18N
        multiplicityOneRadioButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "One_AD_1")); // NOI18N

        multiplicityButtonGroup.add(multiplicityManyRadioButton);
        org.openide.awt.Mnemonics.setLocalizedText(multiplicityManyRadioButton, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_Many_1")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(multiplicityManyRadioButton, gridBagConstraints);
        multiplicityManyRadioButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "Many_AN_1")); // NOI18N
        multiplicityManyRadioButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "Many_AD_1")); // NOI18N

        jLabel13.setText(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_Multiplicity")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 5);
        add(jLabel13, gridBagConstraints);

        multiplicityButtonGroup2.add(multiplicityOneRadioButton2);
        multiplicityOneRadioButton2.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(multiplicityOneRadioButton2, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_One_2")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        add(multiplicityOneRadioButton2, gridBagConstraints);
        multiplicityOneRadioButton2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "One_AN_2")); // NOI18N
        multiplicityOneRadioButton2.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "One_AD_2")); // NOI18N

        multiplicityButtonGroup2.add(multiplicityManyRadioButton2);
        org.openide.awt.Mnemonics.setLocalizedText(multiplicityManyRadioButton2, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_Many_2")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(multiplicityManyRadioButton2, gridBagConstraints);
        multiplicityManyRadioButton2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "Many_AN_2")); // NOI18N
        multiplicityManyRadioButton2.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "Many_AD_2")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cascadeDeleteCheckBox, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_CascadeDelete_1")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 12);
        add(cascadeDeleteCheckBox, gridBagConstraints);
        cascadeDeleteCheckBox.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "CascadeDelete_AN_1")); // NOI18N
        cascadeDeleteCheckBox.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "CascadeDelete_AD_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cascadeDeleteCheckBox2, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_CascadeDelete_2")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 12);
        add(cascadeDeleteCheckBox2, gridBagConstraints);
        cascadeDeleteCheckBox2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "CascadeDelete_AN_2")); // NOI18N
        cascadeDeleteCheckBox2.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "CascadeDelete_AD_2")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(createCmrFieldCheckBox, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_CreateCMRField_1")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 12, 0, 12);
        add(createCmrFieldCheckBox, gridBagConstraints);
        createCmrFieldCheckBox.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "CreateCMRField_AN_1")); // NOI18N
        createCmrFieldCheckBox.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "CreateCMRField_AD_1")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(createCmrFieldCheckBox2, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_CreateCMRField_2")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 12, 0, 12);
        add(createCmrFieldCheckBox2, gridBagConstraints);
        createCmrFieldCheckBox2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "CreateCMRField_AN_2")); // NOI18N
        createCmrFieldCheckBox2.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "CreateCMRField_AD_2")); // NOI18N

        jLabel6.setLabelFor(fieldNameTextField);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_FieldName_1")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 5);
        add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(fieldNameTextField, gridBagConstraints);
        fieldNameTextField.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "FieldName_AN_1")); // NOI18N
        fieldNameTextField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "FieldName_AD_1")); // NOI18N

        jLabel9.setLabelFor(fieldNameTextField2);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_FieldName_2")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 5);
        add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(fieldNameTextField2, gridBagConstraints);
        fieldNameTextField2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "FieldName_AN_2")); // NOI18N
        fieldNameTextField2.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "FieldName_AD_2")); // NOI18N

        jLabel7.setLabelFor(fieldTypeComboBox);
        jLabel7.setText(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_FieldType")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 5);
        add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(fieldTypeComboBox, gridBagConstraints);
        fieldTypeComboBox.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "FieldType_AN_1")); // NOI18N
        fieldTypeComboBox.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "FieldType_AD_1")); // NOI18N

        jLabel10.setLabelFor(fieldTypeComboBox2);
        jLabel10.setText(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "LBL_FieldType")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 5);
        add(jLabel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 12);
        add(fieldTypeComboBox2, gridBagConstraints);
        fieldTypeComboBox2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "FieldType_AN_2")); // NOI18N
        fieldTypeComboBox2.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "FieldType_AD_2")); // NOI18N

        errorLabel.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 12);
        add(errorLabel, gridBagConstraints);

        getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(CmpRelationshipsForm.class, "AddCmpRelationshipDialog_AD")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Traversal policy which changes order of focus traversal in the form.
     * The order is changed so that components are focused in the following
     * order:
     * <ol>
     *     <li>Relationship Name</li>
     *     <li>Description</li>
     *     <li>Entity Bean combo-box on the left
     *         followed by components below it</li>
     *     <li>Entity Bean combo-box on the right
     *         followed by components below it</li>
     *     <li>standard dialog buttons (OK, Cancel)</li>
     * </ol>
     */
    final class CustomFocusTraversalPolicy extends LayoutFocusTraversalPolicy {
        
        private final Component[] compList;
        
        CustomFocusTraversalPolicy() {
            super();

            // <editor-fold defaultstate="collapsed" desc=" compList = new Component[] { ... } ">
            compList = new Component[] {
                    relationshipNameTextField,
                    descriptionTextArea,
                    ejbComboBox,
                    roleNameTextField,
                    multiplicityOneRadioButton,
                    multiplicityManyRadioButton,
                    cascadeDeleteCheckBox,
                    createCmrFieldCheckBox,
                    fieldNameTextField,
                    fieldTypeComboBox,
                    ejbComboBox2,
                    roleNameTextField2,
                    multiplicityOneRadioButton2,
                    multiplicityManyRadioButton2,
                    cascadeDeleteCheckBox2,
                    createCmrFieldCheckBox2,
                    fieldNameTextField2,
                    fieldTypeComboBox2,
            };
            // </editor-fold>
        }

        /**
         */
        private int getIndex(Component c) {
            for (int i = 0; i < compList.length; i++) {
                if (compList[i] == c) {
                    return i;
                }
            }
            return -1;
        }

        /**
         */
        public Component getComponentBefore(Container focusCycleRoot, Component c) {
            for (int i = getIndex(c); i > 0 && i < compList.length;) {
                c = compList[--i];
                if (accept(c)) {
                    return c;
                }
            }
            return super.getComponentBefore(focusCycleRoot, c);
        }

        /**
         */
        public Component getComponentAfter(Container focusCycleRoot, Component c) {
            for (int i = getIndex(c) + 1; i > 0 && i < compList.length; i++) {
                c = compList[i];
                if (accept(c)) {
                    return c;
                }
            }
            return super.getComponentAfter(focusCycleRoot, c);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cascadeDeleteCheckBox;
    private javax.swing.JCheckBox cascadeDeleteCheckBox2;
    private javax.swing.JCheckBox createCmrFieldCheckBox;
    private javax.swing.JCheckBox createCmrFieldCheckBox2;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JComboBox ejbComboBox;
    private javax.swing.JComboBox ejbComboBox2;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JTextField fieldNameTextField;
    private javax.swing.JTextField fieldNameTextField2;
    private javax.swing.JComboBox fieldTypeComboBox;
    private javax.swing.JComboBox fieldTypeComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.ButtonGroup multiplicityButtonGroup;
    private javax.swing.ButtonGroup multiplicityButtonGroup2;
    private javax.swing.JRadioButton multiplicityManyRadioButton;
    private javax.swing.JRadioButton multiplicityManyRadioButton2;
    private javax.swing.JRadioButton multiplicityOneRadioButton;
    private javax.swing.JRadioButton multiplicityOneRadioButton2;
    private javax.swing.JTextField relationshipNameTextField;
    private javax.swing.JTextField roleNameTextField;
    private javax.swing.JTextField roleNameTextField2;
    // End of variables declaration//GEN-END:variables

    public JCheckBox getCascadeDeleteCheckBox2() {
        return cascadeDeleteCheckBox2;
    }

    public JCheckBox getCascadeDeleteCheckBox() {
        return cascadeDeleteCheckBox;
    }

    public JCheckBox getCreateCmrFieldCheckBox2() {
        return createCmrFieldCheckBox2;
    }

    public JCheckBox getCreateCmrFieldCheckBox() {
        return createCmrFieldCheckBox;
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public JComboBox getEjbComboBox2() {
        return ejbComboBox2;
    }

    public JComboBox getEjbComboBox() {
        return ejbComboBox;
    }

    public JTextField getFieldNameTextField2() {
        return fieldNameTextField2;
    }

    public JTextField getFieldNameTextField() {
        return fieldNameTextField;
    }

    public JComboBox getFieldTypeComboBox2() {
        return fieldTypeComboBox2;
    }

    public JComboBox getFieldTypeComboBox() {
        return fieldTypeComboBox;
    }

    public ButtonGroup getMultiplicityButtonGroup2() {
        return multiplicityButtonGroup2;
    }

    public ButtonGroup getMultiplicityButtonGroup() {
        return multiplicityButtonGroup;
    }

    public JRadioButton getMultiplicityManyRadioButton2() {
        return multiplicityManyRadioButton2;
    }

    public JRadioButton getMultiplicityManyRadioButton() {
        return multiplicityManyRadioButton;
    }

    public JRadioButton getMultiplicityOneRadioButton2() {
        return multiplicityOneRadioButton2;
    }

    public JRadioButton getMultiplicityOneRadioButton() {
        return multiplicityOneRadioButton;
    }

    public JTextField getRelationshipNameTextField() {
        return relationshipNameTextField;
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }

    public JTextField getRoleNameTextField() {
        return roleNameTextField;
    }

    public JTextField getRoleNameTextField2() {
        return roleNameTextField2;
    }
}
