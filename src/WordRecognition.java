import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amal & reem
 **/
public class WordRecognition extends javax.swing.JFrame {

    /**
     * Creates new form WordRecognition
     */
    
    String word = "";
    public WordRecognition() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 58, 336, 58));

        jButton1.setText("Word Parts");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 134, -1, -1));

        jButton2.setText("Part of Speech");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 134, -1, -1));

        jButton3.setText("Word Stem");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 134, -1, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 197, 336, 187));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/123.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/123.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(100, 100));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 16, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            if (! jTextField1.getText().equals(word)) {
                word = jTextField1.getText();
                WordReco wr = new WordReco(word);
            }
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document =(Document) builder.parse(new File("output.xml"));
            Element rootElement = document.getDocumentElement();
            
            wordParts("chunk", rootElement);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WordRecognition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(WordRecognition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WordRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:        
        try {
            // TODO add your handling code here:
            if (! jTextField1.getText().equals(word)) {
                word = jTextField1.getText();
                WordReco wr = new WordReco(word);
            }
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document =(Document) builder.parse(new File("output.xml"));
            Element rootElement = document.getDocumentElement();
            
            partOfSpeech("svm_prediction", rootElement);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WordRecognition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(WordRecognition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WordRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if (! jTextField1.getText().equals(word)) {
                word = jTextField1.getText();
                WordReco wr = new WordReco(word);
            }
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document =(Document) builder.parse(new File("output.xml"));
            Element rootElement = document.getDocumentElement();
            
            wordStem("analysis", rootElement);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(WordRecognition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(WordRecognition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WordRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    
    protected void wordParts(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        String text = "";
        for (int i = 0; i < list.getLength(); i++) {
            NodeList subList = list.item(i).getChildNodes();
            
            for (int k = 0; k < subList.getLength(); k++) {
                if (subList != null && subList.getLength() > 0 && subList.item(k).getNodeName().equals("tok")) {
                    //add to the label
                    text = text + subList.item(k).getAttributes().getNamedItem("form0").getNodeValue() + "\n";
                }           
            }
        }
        
        jTextArea1.setText(text);
    }
    
    protected void partOfSpeech(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        String text = "";
        for (int i = 0; i < list.getLength(); i++) {
            NodeList subList = list.item(i).getChildNodes();
            
            for (int k = 0; k < subList.getLength(); k++) {
                if (subList != null && subList.getLength() > 0 && subList.item(k).getNodeName().equals("morph_feature_set")) {
                    //add to the label
                    text = text + subList.item(k).getAttributes().getNamedItem("diac").getNodeValue() + " : ";
                    text = text + subList.item(k).getAttributes().getNamedItem("pos").getNodeValue() + "\n";
                }
            }
        }
        jTextArea1.setText(text);
  
    }
    
    protected void wordStem(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        String text ="";
        for (int i = 0; i < list.getLength(); i++) {
            NodeList subList = list.item(i).getChildNodes();
            
            for (int k = 0; k < subList.getLength(); k++) {
                if (subList != null && subList.getLength() > 0 && subList.item(k).getNodeName().equals("morph_feature_set")) {
                    //add to the label
		    text = text + subList.item(k).getAttributes().getNamedItem("diac").getNodeValue()+" : ";
                    text = text + subList.item(k).getAttributes().getNamedItem("stem").getNodeValue()+"\n";

                }           
            }
        }
	jTextArea1.setText(text);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WordRecognition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WordRecognition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WordRecognition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WordRecognition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WordRecognition().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
