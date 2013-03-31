package dominoes.gui.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;

/**
 * MusicPlayer
 * 
 * @author Hisham Khalifa
 */
public class MusicPlayer {

    
    // streetshark.mp3 is licensed under Creative Commons for Non-Commercial Use.
    // Artist Attribution: spacefish Source URI: http://www.newgrounds.com/audio/listen/528903
    // finalboss.mp3 is licensed under Creative Commons for Non-Commercial Use.
    // Artist Attribution: cmprerry1984 Source URI: http://www.newgrounds.com/audio/listen/528900
    
    final private static String soundOne = "/sounds/streetshark.mp3";
    final private static String soundTwo = "/sounds/finalboss.mp3";
    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;

    public MusicPlayer() {
        initialize();
        playMusic();
    }

    private void initialize() {
        mediaPlayer1 = createMediaPlayer(soundOne);
        mediaPlayer1.setCycleCount(500);

        mediaPlayer2 = createMediaPlayer(soundTwo);
        mediaPlayer2.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer2.play();
            }
        });
    }

    private MediaPlayer createMediaPlayer(String location) {
        URL url = getClass().getResource(location);
        Media media = new Media(url.toString());
        return new MediaPlayer(media);
    }
   
    public void playMusic() {
        mediaPlayer1.play();
    }
    
    public void skipToSecondSong() {
        if (mediaPlayer1.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer1.stop();
        }

        mediaPlayer2.seek(Duration.ZERO);
        mediaPlayer2.play();
    }
}
