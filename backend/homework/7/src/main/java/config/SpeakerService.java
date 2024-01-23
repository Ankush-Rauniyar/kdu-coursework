package config;

import entities.Speaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpeakerService {
    /**
     *
     * @return Speaker
     */
    @Bean(value = "bose")
    Speaker speaker1(){
        Speaker speaker = new Speaker();
        speaker.setBrand("Bose");
        speaker.setPrice(500);
        return speaker;
    }

    /**
     *
     * @return Speaker
     */
    @Bean(value = "sony")
    Speaker speaker2(){
        Speaker speaker = new Speaker();
        speaker.setBrand("Sony");
        speaker.setPrice(700);
        return speaker;
    }
}
