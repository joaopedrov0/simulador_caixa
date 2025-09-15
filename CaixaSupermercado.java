public class CaixaSupermercado {
    private double lockedUntil = 0;

    public boolean isLocked(double tempo){
        return (tempo < lockedUntil);
    }

    public void setLockedUntil(double t){ this.lockedUntil = t; }
    public double getLockedUntil(){ return this.lockedUntil; }
}
