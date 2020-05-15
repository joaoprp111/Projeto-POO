public class GPS {
    private double x;
    private double y;

    public GPS(){
        this.x = this.y = 0.0;
    }

    public GPS(double x, double y){
        this.x = x;
        this.y = y;
    }

    public GPS(GPS gps){
        this.x = gps.getX();
        this.y = gps.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GPS gps = (GPS) o;
        return Double.compare(gps.getX(), x) == 0 &&
                Double.compare(gps.getY(), y) == 0;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("GPS{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }

    public GPS clone(){
        return new GPS(this);
    }
}
