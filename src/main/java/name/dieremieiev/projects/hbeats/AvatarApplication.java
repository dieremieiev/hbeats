package name.dieremieiev.projects.hbeats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import name.dieremieiev.projects.hbeats.model.Avatar;
import name.dieremieiev.projects.hbeats.model.Beat;
import name.dieremieiev.projects.hbeats.model.BeatLog;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@ConfigurationProperties("configuration")
@RestController()
public class AvatarApplication {
    private Avatar avatar;
    private Map<String, Beat> beatMap;
    private static Logger LOG = Logger.getLogger(AvatarApplication.class);

    @RequestMapping(value = "/avatar", produces = "application/json; charset=UTF-8")
    public Avatar getAvatar() {
        return avatar;
    }

    @RequestMapping(value = "/init")
    public void initBeatMap() {
        List<Beat> beats = avatar.getBeats();
        if (beats != null) {
            beatMap = beats
                    .stream()
                    .collect(Collectors.toMap(
                            Beat::getName, x -> x));
        }
    }

    @RequestMapping(value = "/log")
    public void log(String name, Long interval) throws JsonProcessingException {
        Beat beat = beatMap.get(name);
        if (beat != null) {
            LOG.info(new ObjectMapper().writeValueAsString(new BeatLog(interval, beat)));
        }
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public static void main(String[] args) {
        SpringApplication.run(AvatarApplication.class, args);
    }
}
