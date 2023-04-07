package mypack;
/*Create an interface called ""Playable"" with a method called ""play"". 
Create two classes called ""Song"" and ""Video"" that implement the Playable interface and 
implement the ""play"" method. Create objects of both the Song and Video classes and call 
their respective ""play"" methods.*/

interface Playable {//interface 
    void play();//Abstract method
}

class Song implements Playable {//class song 
    String title;//data members 

    Song(String title) {//constructor of class
        this.title = title;
    }

    public void play() {//abstract method
        System.out.println("Playing song: " + this.title);
    }
}

class Video implements Playable {//class song 
    String title;//data members 

    Video(String title) {//constructor of class
        this.title = title;
    }

    public void play() {//abstract method
        System.out.println("Playing video: " + this.title);
    }
}

public class UsePlayable {
    public static void main(String[] args) {
        Song song = new Song("Shape of You");//creating obj
        Video video = new Video("Despacito");

        song.play();//calling method
        video.play();
    }
}
