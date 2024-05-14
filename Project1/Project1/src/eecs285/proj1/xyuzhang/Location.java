package eecs285.proj1.xyuzhang;

public class Location {
  private final double lat;
  private final double lon;

  public Location(double lat, double lon) {
    this.lat = lat;
    this.lon = lon;
  }

  public double getLatitude() {
    return lat;
  }

  public double getLongitude() {
    return lon;
  }

  @Override
  public String toString(){
    return "[" + lat + ", " + lon + "]";
  }

  /** return true if the location's latitude and longitude is within the lower and upper bound */
  public boolean isWithin(Location lowerBound, Location upperBound) {
    return lat >= lowerBound.getLatitude() && lat <= upperBound.getLatitude() &&
        lon >= lowerBound.getLongitude() && lon <= upperBound.getLongitude();
  }
}
