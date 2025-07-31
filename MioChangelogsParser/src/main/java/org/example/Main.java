package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void MessageBox(String time,String rq) {
        JOptionPane.showMessageDialog(null, "Mio version " + rq + " released - " + time, "Update", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            String requestVersion = "2.2";

            Document url = Jsoup.connect("https://mioclient.me/changelogs").get();

            Elements versionInfo = url.select("h1");
            String version = versionInfo.text();

            if (version.contains(requestVersion)) {
                String timeStamp = new SimpleDateFormat("[yyyy:MM:dd:HH:mm:ss]").format(Calendar.getInstance().getTime());

                System.out.println("New update!");
                MessageBox(timeStamp,requestVersion);

                break;
            }
        }
    }
}
