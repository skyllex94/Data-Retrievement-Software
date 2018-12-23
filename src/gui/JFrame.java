package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class JFrame extends javax.swing.JFrame {
    
    Map<String,Set<String>> allwords = new TreeMap<>();
    TreeMap<String, Integer> freq_map = new TreeMap<>();
    TreeMap<String, ArrayList<String>> frequency_map = new TreeMap <>();
    Map<String, TreeMap<String, ArrayList<Integer>>> chapter_map = new TreeMap<>();
    
    Map[] all_maps;
    public JFrame() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search Engine");
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(440, 340, 0, 0));
        setFocusCycleRoot(false);
        setMaximumSize(new java.awt.Dimension(240, 750));
        setMinimumSize(new java.awt.Dimension(465, 340));
        setPreferredSize(new java.awt.Dimension(465, 340));
        setResizable(false);
        setSize(new java.awt.Dimension(240, 750));

        jButton1.setText("Boolean Search");
        jButton1.setEnabled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton3.setText("Load Quijote");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("STATUS:");

        jButton4.setText("Load CACM");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Set begin = this.boolean_search(jTextField2.getText(), all_maps[0]);
        String results = "";
        if (!begin.isEmpty()) {
            Iterator it = begin.iterator();
            while (it.hasNext()) {
                results = results + (String) it.next() + "\n";
            } jTextArea1.setText(results);       
        }
        else jTextArea1.setText("No results found");                                        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
       
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       // jLabel1.setText ("STATUS: Loading...");
        if (jLabel1.getText() == "STATUS: CACM loaded!"){
            all_maps[0].clear();
            all_maps[1].clear();
            all_maps[2].clear();
           
        }
        try {
            all_maps = QUIJOTE();
        } catch (IOException ex) {
            Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        jButton1.setEnabled(true);
        jButton4.setEnabled(true);
        jButton3.setEnabled(false);
        jButton3.setText("<html><font color=black>Load Quijote</font></html>");
        jLabel1.setText ("STATUS: Quijote loaded!");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        if (jLabel1.getText() == "STATUS: Quijote loaded!"){
            all_maps[0].clear();
            all_maps[1].clear();
            all_maps[2].clear();
        }
        try {
            all_maps = CACM();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jLabel1.setText ("STATUS: CACM loaded!");
        jButton1.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(false);
        jButton4.setText("<html><font color=black>Load CACM</font></html>");
        //if ("STATUS: CACM loaded!".equals(jLabel1.getText())){}
    }//GEN-LAST:event_jButton4ActionPerformed
    
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
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
            
        });
    }
    
        public static String word_modif (String coderemovall) {
        coderemovall = coderemovall.replaceAll("\\<.*?>","");
        coderemovall = coderemovall.replaceAll("[^a-zA-Z]", ""); //coderemovall = coderemovall.replaceAll("[,.()!?:;¡-]", "");
        coderemovall = coderemovall.replaceAll("\\d","");
        coderemovall = coderemovall.replaceAll("[0-9]",""); //removing all of the numbers
        coderemovall = coderemovall.replaceAll("\\b[\\w']{1,3}\\b", "");
        coderemovall = coderemovall.replaceAll("\\s{3,}", ""); // removing all of the word less then 4 symbols
        coderemovall = Normalizer.normalize(coderemovall, Normalizer.Form.NFD);
        coderemovall = coderemovall.replaceAll("[\\p{InCombiningDiacriticalMarks}]", ""); // removing accents letters & replacing with normal ones
        stemming_process stemmer = new stemming_process();
        coderemovall = stemmer.stemm(coderemovall);
        return (coderemovall);
       }
    
        public Map[] QUIJOTE () throws FileNotFoundException, IOException  {
      
        File folder1 = new File("src\\quijote\\");
        File[] txts = folder1.listFiles();
        FileReader fr = new FileReader ("src\\gui\\stopwords.txt");
        BufferedReader br = new BufferedReader(fr);
       
        File[] txtarray = txts;  
        int size = txts.length; // making an integer out of the file's number in order to use it for the if statment for the stopwords
        String sCurrentLine;
        ArrayList <String> stopwords = new ArrayList<String>();
        //ArrayList<String> wordsList = new ArrayList<String>();

        while ((sCurrentLine = br.readLine()) != null){
            stopwords.add(sCurrentLine);
        }
        
       for (int j = 0; j < size; j++)
        {
        FileInputStream fis = new FileInputStream(txtarray[j].toString());
            //reading file line by line using Scanner in Java
           String chap_name = txtarray[j].toString(); 
           int position = 0; 
            try (Scanner scanner = new Scanner(fis)) {
                //System.out.println("Reading file line by line in Java using Scanner");
               
                while(scanner.hasNext()){
                    String coderemovall = scanner.next(); 
                    position++;
                     if(stopwords.contains(coderemovall)){ // entering into all of the characters of Quijote & removing the stopwords from them!
                        coderemovall = "";
                            }
                    coderemovall = word_modif(coderemovall);
                     
                if (coderemovall.isEmpty()) {
                continue;
                        }
                
                String each_word = coderemovall;
                
                if (freq_map.get(each_word) == null){
                    freq_map.put(each_word, 1);
                } 
                else {
                    int value = freq_map.get(each_word);
                    value++;
                    freq_map.put(each_word, value);
                }
                
                ArrayList <String> check_chap = new ArrayList<>() ;
                if (frequency_map.get(each_word) == null){
                    frequency_map.put(each_word, check_chap);
                    
                } 
                check_chap = frequency_map.get(each_word);
                check_chap.add(chap_name);
                
                frequency_map.put(each_word, check_chap);

                ArrayList <Integer> check_pos = new ArrayList<>() ;
                TreeMap<String, ArrayList<Integer>> position_map = new TreeMap <>();
                
                if (chapter_map.get(chap_name) == null){
                    chapter_map.put(chap_name, position_map);
                } 
                position_map = chapter_map.get(chap_name);                 
                 
                if (position_map.get(each_word) == null){
                    position_map.put(each_word, check_pos);
                } 
                
                check_pos = position_map.get(each_word);                
                check_pos.add(position);
                
                Set<String> set = new TreeSet<>();
                if(allwords.containsKey(each_word)) 
                set = allwords.get(each_word);
                set.add(txtarray[j].getName());
                allwords.put(each_word,set);

                chapter_map.put(chap_name, position_map);
                }
            }
        }
        //System.out.println(chapter_map);
        Map[] maparray = {allwords,freq_map,chapter_map};
        return (maparray);
        // System.out.println(freq_map);
        //WRITING(chapter_map);
    }   
        
        public Map[] CACM () throws FileNotFoundException, IOException {
      
       File folder2 = new File("src\\cacm\\");
       File[] htmls = folder2.listFiles(); // reading all of the htmls from CACM
       FileReader fr = new FileReader ("src\\gui\\stopwords_en.txt");
       BufferedReader br = new BufferedReader(fr);
       
       File[] htmlarray = htmls; 
       int htmlsize = htmlarray.length;
       
        String sCurrentLine;
        ArrayList <String> stopwords = new ArrayList<String>();
        //ArrayList<String> wordsList = new ArrayList<String>();

        while ((sCurrentLine = br.readLine()) != null){
            stopwords.add(sCurrentLine);
        }
       
       for (int j = 0; j < htmlsize; j++)
        {
        FileInputStream fis = new FileInputStream(htmlarray[j].toString());
            try (Scanner scanner = new Scanner(fis)) {
               String chap_name = htmlarray[j].toString(); 
               int position = 0; 
                while(scanner.hasNext()){
                    position++;
                    String coderemoval = scanner.next();
                    coderemoval = word_modif(coderemoval);
                    if(stopwords.contains(coderemoval)){ // entering into all of the characters of Quijote & removing the stopwords from them!
                         coderemoval = "";
                            }
                    
                     if (coderemoval.isEmpty()) {
                continue;
                        }
                    
                    String each_word = coderemoval;
                     
                    if (freq_map.get(each_word) == null){
                    freq_map.put(each_word, 1);
                } 
                else {
                    int value = freq_map.get(each_word);
                    value++;
                    freq_map.put(each_word, value);
                }
                     
                    ArrayList <String> check_chap = new ArrayList<>() ;
                if (frequency_map.get(each_word) == null){
                    frequency_map.put(each_word, check_chap);
                    
                } 
                check_chap = frequency_map.get(each_word);
                check_chap.add(chap_name);
                
                frequency_map.put(each_word, check_chap);

                ArrayList <Integer> check_pos = new ArrayList<>() ;
                TreeMap<String, ArrayList<Integer>> position_map = new TreeMap <>();
                
                if (chapter_map.get(chap_name) == null){
                    chapter_map.put(chap_name, position_map);
                } 
                position_map = chapter_map.get(chap_name);                 
                 
                if (position_map.get(each_word) == null){
                    position_map.put(each_word, check_pos);
                } 
                
                check_pos = position_map.get(each_word);                
                check_pos.add(position);
                
                Set<String> set = new TreeSet<>();
                if(allwords.containsKey(each_word)) 
                set = allwords.get(each_word);
                set.add(htmlarray[j].getName());
                allwords.put(each_word,set);

                chapter_map.put(chap_name, position_map); 
                }
            } 
        } 
       //System.out.println(chapter_map);
       Map[] maparray = {allwords,freq_map,chapter_map};
       return (maparray);
    }
        
        public void WRITING (TreeMap<String, TreeMap<String, ArrayList<Integer>>> write_map){
           /*  
        try{
            String index = "C:\\Users\\iv3rson\\Desktop\\Sistema de Recuperación de Información\\fileone.txt";
            FileWriter fstream = new FileWriter(index);
            BufferedWriter out = new BufferedWriter(fstream);
       
            for(Map.Entry<String,TreeMap<String,ArrayList<Integer>>> m : chapter_map.entrySet()){
                System.out.println("Chapter = " + m.getKey() + ", Word & Positions = " + m.getValue());
                out.write(m.getKey() + "\t" + m.getValue());
                out.flush();
            }
            out.close();
        } catch (Exception e) {}
            */
    }
        
        public static Set boolean_search(String text, Map boo_search) {
        String split = " ";  
        String[] query = text.split(split);
        Set chapters = new TreeSet();
        for (String word:query){
            word = word_modif(word);
            
            if (boo_search.containsKey(word)) {        
                Set chap_words = (Set) (boo_search.get(word));
                if (chapters.isEmpty())
                    chapters=chap_words;
                else
                    chapters.retainAll(chap_words);
            }
            else {
                chapters.clear();
                break;
            }
        }
        return chapters;
    }
        
        public static double tf(String word, Map[] maps){
        int begin=0;
        Set id = (Set) (maps[0].get(word));
        Iterator it = id.iterator();
        while (it.hasNext()) {
            String chapters = (String) it.next();
            Map result = (Map) (maps[1].get(chapters));
            Set positions = (Set) (result.get(word));
            begin = begin + positions.size();
        }       
        double tf = 1 + (Math.log(begin)/(double) Math.log(2));
        return tf;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
