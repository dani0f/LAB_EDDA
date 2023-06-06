import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.*;

//No modificar
class Video {
    private String videoID;
    private String videoTitle;
    private String channelID;
    private String channelTitle;
    private String publishedAt;
    private long viewCount;
    private int likeCount;
    private int commentCount;
    private float popularity;
    private Video next;
    Video(String videoID, String videoTitle, String channelID, String channelTitle, String publishedAt, long viewCount, int likeCount, int commentCount, float popularity){
        this.videoID = videoID;
        this.videoTitle = videoTitle;
        this.channelID = channelID;
        this.channelTitle = channelTitle;
        this.publishedAt = publishedAt;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.popularity = popularity;
        next = null;
    }
    public void reproduce(){
        System.out.printf("Channel: %s %s \nVideo: %s %s \n", channelID, channelTitle, videoID, videoTitle );
        System.out.printf("Date: %s views: %s likes: %s comments: %s popularity: %s\n",publishedAt, viewCount, likeCount, commentCount, popularity);
    }
    public String getVideoID(){return videoID;}
    public String getVideoTitle(){return videoTitle;}
    public String getChannelID(){return channelID;}
    public String getChannelTitle(){return channelTitle;}
    public String getPublishedAt(){return publishedAt;}
    public long getViewCount(){return viewCount;}
    public int getLikeCount(){return likeCount;}
    public int getCommentCount(){return commentCount;}
    public float getPopularity(){return popularity;}
    public Video getNext(){return next;}
    public void setVideoID(String videoID){this.videoID = videoID;}
    public void setVideoTitle(String videoTitle){this.videoTitle = videoTitle;}
    public void setChannelID(String channelID){this.channelID = channelID;}
    public void setChannelTitle(String channelTitle){this.channelTitle = channelTitle;}
    public void setPublishedAt(String publishedAt){this.publishedAt = publishedAt;}
    public void setViewCount(long viewCount){this.viewCount = viewCount;}
    public void setLikeCount(int likeCount){this.likeCount = likeCount;}
    public void setCommentCount(int commentCount){this.commentCount = commentCount;}
    public void setPopularity(float popularity){this.popularity = popularity;}
    public void setNext(Video next){this.next = next;}
}


public class HashMaker {

    public HashMap<String, ArrayList<Video>> map = new HashMap<>();

    HashMaker(String file){

        String string;

        try (BufferedReader br = new BufferedReader(new FileReader(file));){
            br.readLine();
            while((string = br.readLine()) != null) {
                boolean inQuotes = false;
                int start = 0;
                ArrayList<String> newLines = new ArrayList<>();
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == '\"') {
                        inQuotes = !inQuotes;
                    } else if (string.charAt(i) == ',' && !inQuotes) {
                        newLines.add(string.substring(start, i));
                        start = i + 1;
                    }
                }
                newLines.add(string.substring(start));
                Video newVideo = arrayToVideo(newLines);
                //key se define como la fecha en la que se publico el vídeo
                String key = newVideo.getPublishedAt().substring(0,10);
                System.out.println(key);
                //Aquí realice la agrupación del mapa utilizando la variable key.
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //No modificar
    public static long isNumericLong(String s){
        long d = 0;
        try {
            d = Long.parseLong(s);
        }
        catch (NumberFormatException ignored){}
        return d;
    }
    //No modificar
    public static int isNumericInt(String s){
        int i = 0;
        try {
            i = Integer.parseInt(s);
        }
        catch (NumberFormatException ignored){}
        return i;
    }
    //No modificar
    public static Video arrayToVideo(ArrayList<String> array){
        if(array.get(5).equals("")){
            array.set(5,"0");
        }
        if(array.get(6).equals("")){
            array.set(6,"0");
        }

        long viewCount = isNumericLong(array.get(5));
        int likeCount = isNumericInt(array.get(6));
        int commentCount = isNumericInt(array.get(7));

        float popularity = 0F;
        if( viewCount != 0) { popularity = Float.parseFloat(array.get(5)) / Float.parseFloat(array.get(6)); }
        Video v = new Video(array.get(0),
                array.get(1),
                array.get(2),
                array.get(3),
                array.get(4),
                viewCount,
                likeCount,
                commentCount,
                popularity);
        return v;
    }

    //Función para imprimir el mapa
    void traverseMap(){
        for (Map.Entry<String, ArrayList<Video>> e : map.entrySet())
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
    }

    //Función para imprimir las fechas faltantes en el mapa dado un rango de fecha.
    void printMissingValues(String initDate, String finalDate){
        LocalDate startDate = LocalDate.parse(initDate);
        LocalDate endDate = LocalDate.parse(finalDate);
        LocalDate currentDate = startDate;
        //while recorre desde initDate hasta endDate sumando de a 1 día a currentDate.
        while (currentDate.isBefore(endDate)){
            String date = currentDate.toString();
            currentDate = currentDate.plusDays(1);
        }

    }

    public static void main(String[] args){
        HashMaker hash = new HashMaker("YoutubeDTSV2.csv");
        System.out.println("Las fechas donde no se subieron vídeos entre 2017 y 2018 son:");
        hash.printMissingValues("2017-01-01", "2018-01-01");
    }


}
