public class Task {

    private int processingTime;
    private int earlyPenalty;
    private int latePenalty;

    public Task(int processingTime, int earlyPenalty, int latePenalty) {
        this.processingTime = processingTime;
        this.earlyPenalty = earlyPenalty;
        this.latePenalty = latePenalty;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public int getEarlyPenalty() {
        return earlyPenalty;
    }

    public void setEarlyPenalty(int earlyPenalty) {
        this.earlyPenalty = earlyPenalty;
    }

    public int getLatePenalty() {
        return latePenalty;
    }

    public void setLatePenalty(int latePenalty) {
        this.latePenalty = latePenalty;
    }
}
