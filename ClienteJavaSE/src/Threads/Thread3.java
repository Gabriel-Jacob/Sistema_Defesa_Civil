package Threads;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Thread3 extends Thread {
   private final String endpointUrlGerar = "htpp://localhost:8080/relatorios/gerar";
   private final String endpointUrlRelatorio = "htpp://localhost:8080/relatorios";

   @Override
   public void run() {
       List<String> response = new ArrayList<>();
       while(true){
           try {
               URL url = new URL(endpointUrlGerar);
               HttpURLConnection connection = (HttpURLConnection) url.openConnection();
               connection.setRequestMethod("GET");
               connection.disconnect();
               Thread.sleep(3*1000);


               URL urlRelatorio = new URL(endpointUrlRelatorio);
               HttpURLConnection connectionRelatorio = (HttpURLConnection) urlRelatorio.openConnection();
               connectionRelatorio.setRequestMethod("GET");
               connectionRelatorio.disconnect();


           } catch (IOException e) {
               System.err.println("Erro na thread " + Thread.currentThread().getName() + ": " + e.getMessage());
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           try {
               Thread.sleep(3*1000); // 3s
           } catch (InterruptedException e) {
               e.printStackTrace();
           }


           startUI(response);
       }
   }


   private static void startUI(List<String> response){
       JTextArea area = new JTextArea();
       JFrame fr = new JFrame(); // janela
       // habilita a barra de scroll
       // para a caixa de texto
       JScrollPane sp = new JScrollPane(area);
       // posiciona no centro da janela
       fr.getContentPane().add(sp, BorderLayout.CENTER);
       fr.setSize(300, 600); // tamanho da janela
       fr.setLocationRelativeTo(null);
       fr.setVisible(true);


       for (String r : response) {
           area.setText(r);
       }
   }
}