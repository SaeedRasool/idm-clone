
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saeed
 */
public class Download extends SwingWorker<Void, Void> {

    URL url;
    InputStream inputStream;
    OutputStream output;
    long size;
    String Range;
    String outF;
    HttpURLConnection urlConnection;
    int start;
    int end;
    ProgressMonitor progg;
    static int conn = 32;
    ExecutorService pool = null;
    boolean support;

    public Download(String u, String out, ProgressMonitor p) {
        start = 0;
        outF = out;
        progg = p;
        try {
            url = new URL(u);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void downloadParts() throws IOException {
        long par =  size / conn;
        long[] s = new long[conn + 1];
        pool = Executors.newFixedThreadPool(conn);
        s[0] = 0;
        long startDate = 0;
        downloader d = null;
        for (int i = 0; i < conn; i++) {
            s[i + 1] = s[i] + par;
            Range = s[i] + "-" + s[i + 1];
            System.out.println("Range : " + Range);
            d = new downloader(Range, url, s[i], s[i + 1], outF);
            d.addPropertyChangeListener(this.progg);
            startDate = System.nanoTime();
            pool.execute(d);
        }
        TableRenderer t = new TableRenderer(d.name, "Yes", (size / 1024) / 1024 + " MB", d.getProgress() + "%", new Date(System.nanoTime() - startDate), 1, new Date(startDate).toString(), d.conType, new Date(startDate), d.fileName, url.toString());
        pool.shutdown();
        while (!pool.isTerminated()) {
        }
        JOptionPane.showMessageDialog(null, "File has been downloaded successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    private void downloadComp() throws IOException {
        Range = start + "-" + size;
        pool = Executors.newFixedThreadPool(1);
        downloader d = new downloader(Range, url, start, (int) size, outF);
        Date startDate = new Date();
        TableRenderer t = new TableRenderer(d.name, "Yes", (size / 1024) / 1024 + " MB", d.getProgress() + "%", new Date(new Date().getTime() - startDate.getTime()), 1, "Jan", d.conType, startDate, d.fileName, url.toString());
        pool.execute(d);
        pool.shutdown();
        while (!pool.isTerminated()) {
        }
        JOptionPane.showMessageDialog(null, "File has been downloaded successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    protected Void doInBackground() throws Exception {
        urlConnection = (HttpURLConnection) url.openConnection();
        support = urlConnection.getHeaderField("Accept-Ranges").equals("bytes");
        System.out.println("Partial content retrieval support = " + (support ? "Yes" : "No"));
        size = urlConnection.getContentLengthLong();
        end = (int) size;
        System.out.println("Size : " + (size / 1024) / 1024 + " MB");
        inputStream = urlConnection.getInputStream();
        progg.buttonDownload.setEnabled(false);
        progg.buttonCancel.setVisible(true);
        progg.buttonPause.setVisible(true);
        if (support) {
            downloadParts();
        } else {
            downloadComp();
        }
        return null;
    }

    static class downloader extends SwingWorker<Void, Void> implements Runnable {

        String ran;
        URL u;
        HttpURLConnection urlConnection;
        String fileName;
        String name;
        BufferedInputStream in = null;
        RandomAccessFile raf = null;
        long startB;
        long endB;
        public static double prog = 0.0;
        public static double trans = 0;
        String conType;

        public downloader(String r, URL ur, long start, long end, String ou) throws IOException {
            this.ran = r;
            this.u = ur;
            urlConnection = (HttpURLConnection) u.openConnection();
            urlConnection.setRequestProperty("Range", "bytes=" + ran);
            urlConnection.connect();

            while ((urlConnection.getResponseCode() / 100) != 2) {
                urlConnection.disconnect();
                urlConnection = null;
                System.out.println("Disconnect");
                urlConnection = (HttpURLConnection) u.openConnection();
                urlConnection.addRequestProperty("Range", "bytes=" + ran);
                urlConnection.connect();
            }
            System.out.println(urlConnection.getContent());
            String fileURL = urlConnection.getURL().getFile();
            System.out.println("File Url is "+ fileURL);
            conType = urlConnection.getContentType();
            System.out.println("Type = " + conType);
            if (fileURL != null) {
                //String temp = urlConnection.getHeaderField("Content-Disposition");
                //if (temp != null && temp.indexOf("=") != -1) {
                //    fileName = temp.split("=")[1];
                Map map = urlConnection.getHeaderFields();
                System.out.println(map.get("Content-Disposition"));
                if (map.get("Content-Disposition") != null) {
                    String raw = map.get("Content-Disposition").toString();
                    // raw = "attachment; filename=abc.jpg"
                    if (raw != null && raw.contains("=")) {
                        fileName = raw.substring(raw.lastIndexOf("=")+1); // getting value after '='
                        fileName = ou + fileName.replaceAll("\"", "").replaceAll("]", "");
                    }
                } else {
                    int index = fileURL.indexOf("title=");
                    if (index > 0) {
                        name = fileURL.substring(index + 6).replaceAll("%", "").replaceAll("=", "").replaceAll(":", "").replaceAll("\\*", "").replaceAll("\\?", "").replaceAll("\"", "").replaceAll("|", "").replaceAll("<", "").replaceAll(">", "");
//                        if(name.length()-name.substring('.').length()>200){
//                            name = name.substring(name.lastIndexOf(".")-200, name.length());
//                        }
//                        if(name.length()-name.lastIndexOf(".")>8){
//                            name = name.substring(0, name.lastIndexOf('.')+8);
//                        }
                        fileName = ou + "\\" + name;
                    } else if (fileURL != null) {
                        if (fileURL.lastIndexOf('/') > 0) {
                            name = fileURL.substring(fileURL.lastIndexOf('/') + 1).replaceAll("%", "").replaceAll("=", "").replaceAll(":", "").replaceAll("\\*", "").replaceAll("\\?", "").replaceAll("\"", "").replaceAll("|", "").replaceAll("<", "").replaceAll(">", "");
//                            if(name.length()-name.substring('.').length()>200){
//                                name = name.substring(name.lastIndexOf(".")-200, name.length());
//                            }
//                            if(name.length()-name.lastIndexOf(".")>8){
//                                name = name.substring(0, name.lastIndexOf('.')+8);
//                            }
                            fileName = ou + "\\" + name;
                        }} else {
                            name = "hahaha";
                            fileName = ou + "\\" + name;
                        }
                    }
                }
            System.out.println("File Name : " + fileName);
            startB = start;
            endB = end;
        }

        @Override
        protected Void doInBackground() throws Exception {
            try {
                in = new BufferedInputStream(urlConnection.getInputStream());
                long t = endB;
                long s = startB;
                double tee = 0.0;
                double teeemp = 0.0;
                while (t > startB) {
                    raf = new RandomAccessFile(fileName, "rw");
                    raf.seek(s);
                    
                    byte data[] = new byte[4096];
                    int numRead;
                    while (((numRead = in.read(data, 0, 4096)) != -1)) {
                        long d = System.nanoTime();
                        raf.write(data, 0, numRead);
                        s += numRead;
                        trans = trans - teeemp;
                        teeemp = teeemp + (double)((double) numRead / ((double)(System.nanoTime() - d)* 1000000)) ;
                        trans = trans + teeemp;
                        System.out.println(trans + " KB/Sec ");
//                        trans = trans - teeemp;
//                        teeemp = (double) (numRead * (double) (1000000000 / (System.nanoTime() - d)));
//                        trans = trans + teeemp;
//                        System.out.println(trans + " KB/sec ");

                    }
                    long temp = endB - startB;
                    System.out.println("Chunk Size is " + temp);
                    prog = prog - tee;
                    tee = tee + (double) (((double) ((double)4096 / temp)  * 100) / conn);
                    System.out.println("Per thread percentage added is " + tee);
                    prog = prog + tee;
                    System.out.println(Math.ceil(prog) + " percent");
                    if(getProgress()<(int) Math.ceil(prog)){
                    setProgress((int) Math.ceil(prog));}
                    t -= 4096;
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error downloading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());
                setProgress(0);
                cancel(true);
            }
            return null;
        }

        @Override
        protected void done() {
            if (raf != null) {
                try {
                    urlConnection.disconnect();
                    raf.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
