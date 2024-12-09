import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds
{
    Clip clip;
    String audio = "bird.wav";

    public String getAudio()
    {
        return audio;
    }

    public void setAudio(String audio)
    {
        this.audio = audio;
    }

    public void play()
    {
        try
        {
            File file = new File(audio);
            //URL url = getClass().getClassLoader().getResource(audio);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);

            clip = AudioSystem.getClip();

            clip.open(audioIn);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stop()
    {
        clip.stop();
    }
}

