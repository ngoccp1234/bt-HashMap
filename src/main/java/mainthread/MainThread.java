package mainthread;

import entity.InfomationVideo;
import entity.TotalView;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MainThread {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/tomT.txt"));
        ArrayList<InfomationVideo> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] splited = line.split("\\s{2,}");
            if (splited.length == 4) {
                String day = splited[0];
                String id = splited[1];
                String title = splited[2];
                int view = Integer.parseInt(splited[3]);

                InfomationVideo infomationVideo = new InfomationVideo(day, id, title, view);
                list.add(infomationVideo);
            }
        }
        HashMap<String, TotalView> totalViewHashMap = new HashMap<>();
        for (InfomationVideo infomationvd : list) {
            int totalView = 0;
            if (totalViewHashMap.containsKey(infomationvd.getId())) {
                TotalView totalView1 = totalViewHashMap.get(infomationvd.getId());
                totalView = totalView1.getView();
            }
            totalView = totalView + infomationvd.getView();
            TotalView totalView1 = new TotalView(infomationvd.getId(), infomationvd.getTitle(), totalView);
            totalViewHashMap.put(infomationvd.getId(), totalView1);
        }
        for (String id : totalViewHashMap.keySet()) {
            TotalView totalView = totalViewHashMap.get(id);
            System.out.println("Id video: " + totalView.getId());
            System.out.println("Title video: " + totalView.getTitle());
            System.out.println("Total view video: " + totalView.getView());
            System.out.println("------------------------------- \n");
        }
        br.close();
    }
}
