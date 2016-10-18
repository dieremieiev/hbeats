package name.dieremieiev.projects.hbeats.model;

public class BeatLog {
    private Long time;
    private Beat beat;

    public BeatLog() {
    }

    public BeatLog(Long time, Beat beat) {
        this.time = time;
        this.beat = beat;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Beat getBeat() {
        return beat;
    }

    public void setBeat(Beat beat) {
        this.beat = beat;
    }
}
