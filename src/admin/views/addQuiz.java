/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package admin.views;

import admin.Interface.v2.adminInterface;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author wb2c0
 */
public class addQuiz extends javax.swing.JDialog {

    /**
     * Creates new form addQuiz
     */
    String type = "Multiple Choice";
    adminInterface listener;
    Object[] choices = new Object[4];
    DefaultListModel lmodel;
    int index = 0;

    public addQuiz(java.awt.Frame parent, boolean modal, adminInterface listener) {
        super(parent, modal);
        initComponents();

        this.listener = listener;
        lmodel = new DefaultListModel();

        jList1.setModel(lmodel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        question = new javax.swing.JTextField();
        answer = new javax.swing.JTextField();
        qType = new javax.swing.JComboBox<>();
        time = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        choice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));

        jLabel2.setFont(new java.awt.Font("Liberation Mono", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add Quiz");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(25, 25, 25))
        );

        question.setText("Add a question");
        question.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                questionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                questionFocusLost(evt);
            }
        });

        answer.setText("Answer");
        answer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                answerFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                answerFocusLost(evt);
            }
        });

        qType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Multiple Choice", "Enumeration" }));
        qType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qTypeMouseClicked(evt);
            }
        });
        qType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qTypeActionPerformed(evt);
            }
        });

        time.setText("Time");
        time.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                timeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                timeFocusLost(evt);
            }
        });

        choice.setText("Add choices");
        choice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                choiceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                choiceFocusLost(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(choice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(choice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(0, 51, 204));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Quiz Type");

        jLabel3.setText("Quiz Time");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(answer)
                                .addComponent(question)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(qType, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabel1)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qType, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(time))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void questionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_questionFocusGained
        // TODO add your handling code here:
        question.setText(null);
    }//GEN-LAST:event_questionFocusGained

    private void questionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_questionFocusLost
        // TODO add your handling code here:

        if (question.getText().isEmpty()) {
            question.setText("Add a question");
        }
    }//GEN-LAST:event_questionFocusLost

    private void answerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerFocusGained
        // TODO add your handling code here:
        answer.setText(null);
    }//GEN-LAST:event_answerFocusGained

    private void answerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_answerFocusLost
        // TODO add your handling code here:
        if (answer.getText().isEmpty()) {
            answer.setText("Answer");
        }
    }//GEN-LAST:event_answerFocusLost

    private void timeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timeFocusGained
        // TODO add your handling code here:
        time.setText(null);
    }//GEN-LAST:event_timeFocusGained

    private void timeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timeFocusLost
        // TODO add your handling code here:
        if (time.getText().isEmpty()) {
            time.setText("Time");
        }
    }//GEN-LAST:event_timeFocusLost

    private void choiceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_choiceFocusGained
        // TODO add your handling code here:
        choice.setText(null);
    }//GEN-LAST:event_choiceFocusGained

    private void choiceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_choiceFocusLost
        // TODO add your handling code here:
        if (choice.getText().isEmpty()) {
            choice.setText("Add choices");
        }
    }//GEN-LAST:event_choiceFocusLost

    private void qTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qTypeMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_qTypeMouseClicked

    private void qTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qTypeActionPerformed
        // TODO add your handling code here:
        type = String.valueOf(qType.getSelectedItem());

        System.out.println(type);

        if (type.equalsIgnoreCase("Enumeration")) {
            jPanel2.setVisible(false);
        } else {
            jPanel2.setVisible(true);
        }
    }//GEN-LAST:event_qTypeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            
            if (type.equalsIgnoreCase("Enumeration")) {
                this.listener.addEnumeration(question.getText(), answer.getText(), Integer.parseInt(time.getText()), type);
            } else if (type.equalsIgnoreCase("Multiple Choice")) {
                this.listener.addMultipleChoice(question.getText(), answer.getText(), Integer.parseInt(time.getText()), type, choices);
            }
              dispose();
        } catch (Exception e) {
         JOptionPane.showMessageDialog(this, "Please enter a valid time", "Missing Time", JOptionPane.INFORMATION_MESSAGE);
        }
      
        
        lmodel.removeAllElements();
        question.setText(null);
        answer.setText(null);
        choice.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int itemLength = lmodel.getSize();

        if (itemLength < 4) {
            // Add the item to the list model
            lmodel.addElement(choice.getText());

            int index = 0;
            while (index < choices.length && choices[index] != null) {
                index++;
            }

            if (index < choices.length) {
                choices[index] = choice.getText();
            }
        } else {
             JOptionPane.showMessageDialog(this, "Choices already full", "Choices Full", JOptionPane.INFORMATION_MESSAGE);

        }


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answer;
    private javax.swing.JTextField choice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> qType;
    private javax.swing.JTextField question;
    private javax.swing.JTextField time;
    // End of variables declaration//GEN-END:variables
}
