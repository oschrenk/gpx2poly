package gpx2poly;

import java.util.List;

import com.oschrenk.gis.formats.gpx.Trackpoint;

/**
 * The Class Gpx2Polygon.
 *
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class Gpx2Polygon {

	/** The track points. */
	private final List<Trackpoint> trackPoints;

	/**
	 * Instantiates a new gpx2polygon.
	 *
	 * @param trackPoints
	 *            the track points
	 */
	public Gpx2Polygon(final List<Trackpoint> trackPoints) {
		this.trackPoints = trackPoints;
	}

	/**
	 * Process.
	 *
	 * @return the string
	 */
	public String process() {
		StringBuffer sb = new StringBuffer();
		sb.append("var coordinates = [");

		int i = 1;
		int size = trackPoints.size();
		for (Trackpoint trackPoint : trackPoints) {
			sb.append("\t");
			sb.append(getGoogleMapsLatLng(trackPoint.getLatitude(),
					trackPoint.getLongitude()));
			if (i < size) {
				sb.append(",");
			}
			sb.append("\n");
			i++;
		}

		sb.append("];");
		return sb.toString();
	}

	/**
	 * Gets the google maps lat lng.
	 *
	 * @param lat
	 *            the lat
	 * @param lon
	 *            the lon
	 * @return the google maps lat lng
	 */
	private String getGoogleMapsLatLng(final double lat, final double lon) {
		return "new google.maps.LatLng(" + lat + ", " + lon + ")";
	}
}
