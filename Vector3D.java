public class Vector3D {
    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("(%1$.2f, %2$.2f, %3$.2f)", x, y, z);
    }

    public double getMagnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3D normalize() throws IllegalStateException{
        double magnitude = getMagnitude();
        if(magnitude == 0){
            throw new IllegalStateException("magnitude is zero");
        } else {
            return new Vector3D(x/magnitude, y/magnitude, z/magnitude);
        }
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.getX(), y + other.getY(), z + other.getZ());
    }

    public Vector3D multiply(double scalar) {
        return new Vector3D(x*scalar, y*scalar, z*scalar);
    }

    public double dotProduct(Vector3D other) {
        return x * other.getX() + y * other.getY() + z * other.getZ();
    }

    public double angleBetween(Vector3D other) throws IllegalStateException{
        double denominator = this.getMagnitude()*other.getMagnitude();
        if(denominator == 0){
            throw new IllegalStateException("Division by zero");
        }
        double costheta = (this.dotProduct(other))/denominator;
        double radian = Math.acos(costheta);
        return Math.toDegrees(radian);
    }

    public Vector3D crossProduct(Vector3D other) {
        return new Vector3D(this.y*other.getZ() - this.z*other.getY(), this.z*other.getX() - this.x*other.getZ(), this.x*other.getY()-this.y*other.getX());
    }

    public double getZ() {
        return z;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}
