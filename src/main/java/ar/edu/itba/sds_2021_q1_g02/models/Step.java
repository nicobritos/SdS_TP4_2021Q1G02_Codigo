package ar.edu.itba.sds_2021_q1_g02.models;

import java.math.BigDecimal;
import java.util.Map;

public class Step {
    private final Map<Particle, Position> previousParticlesPosition;
    private final Map<Particle, Velocity> previousParticlesVelocity;
    private BigDecimal deltaTime;
    private BigDecimal absoluteTime;
    private final int step;
    private final IntegrationAlgorithm integrationAlgorithm;
    private double energyDifference;
    private boolean isLastStep = false;

    public Step(Map<Particle, Position> previousParticlesPosition, Map<Particle,
            Velocity> previousParticlesVelocity, BigDecimal deltaTime, BigDecimal absoluteTime, int step,
                IntegrationAlgorithm integrationAlgorithm) {
        this.previousParticlesPosition = previousParticlesPosition;
        this.previousParticlesVelocity = previousParticlesVelocity;

        this.deltaTime = deltaTime;
        this.absoluteTime = absoluteTime;
        this.step = step;
        this.integrationAlgorithm = integrationAlgorithm;
    }

    public BigDecimal getRelativeTime() {
        return this.deltaTime;
    }

    public BigDecimal getAbsoluteTime() {
        return this.absoluteTime;
    }

    public int getStep() {
        return this.step;
    }

    public IntegrationAlgorithm getIntegrationAlgorithm() {
        return this.integrationAlgorithm;
    }

    public Position getPreviousPosition(Particle particle) {
        return this.previousParticlesPosition.get(particle);
    }

    public boolean containsPreviousPosition(Particle particle) {
        return this.previousParticlesPosition.containsKey(particle);
    }

    public Velocity getPreviousVelocity(Particle particle) {
        return this.previousParticlesVelocity.get(particle);
    }

    public double getEnergyDifference() {
        return this.energyDifference;
    }

    public void setEnergyDifference(double energyDifference) {
        this.energyDifference = energyDifference;
    }

    public boolean containsPreviousVelocity(Particle particle) {
        return this.previousParticlesVelocity.containsKey(particle);
    }

    public Step copy() {
        return new Step(
                this.previousParticlesPosition,
                this.previousParticlesVelocity,
                this.deltaTime,
                this.absoluteTime,
                this.step,
                this.integrationAlgorithm
        );
    }

    public void setAbsoluteTime(BigDecimal absoluteTime) {
        this.absoluteTime = absoluteTime;
    }

    public void setRelativeTime(BigDecimal relativeTime) {
        this.deltaTime = relativeTime;
    }


    public boolean isLastStep() {
        return this.isLastStep;
    }

    public void setLastStep(boolean lastStep) {
        this.isLastStep = lastStep;
    }
}
