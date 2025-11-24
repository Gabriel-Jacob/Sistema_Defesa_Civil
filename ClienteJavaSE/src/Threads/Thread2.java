package Threads;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Thread2 extends Thread {
    private final String endpointUrl = "http://localhost:8080/ocorrencias";
    private JTextArea area;
    
    public Thread2() {
        JFrame fr = new JFrame("Ocorrências");
        area = new JTextArea();
        JScrollPane sp = new JScrollPane(area);
        fr.getContentPane().add(sp, BorderLayout.CENTER);
        fr.setSize(300, 600);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                URL url = new URL(endpointUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder content = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine).append("\n");
                }
                in.close();
                connection.disconnect();

                area.setText(content.toString());

            } catch (IOException e) {
                System.err.println("Erro na thread " + Thread.currentThread().getName() + ": " + e.getMessage());
            }

            try {
                Thread.sleep(3000); // 3s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
