package gpx2gpoly.ui.cmd;

import gpx2gpoly.Gpx2GPolygon;

import java.io.FileNotFoundException;

import uk.co.flamingpenguin.jewel.cli.ArgumentValidationException;
import uk.co.flamingpenguin.jewel.cli.Cli;
import uk.co.flamingpenguin.jewel.cli.CliFactory;

import com.oschrenk.gis.formats.gpx.GpxFactory;

/**
 * The Class CommandLine.
 */
public class CommandLine {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		Cli<StartupArguments> cli = null;
		StartupArguments parsedArguments;
		try {
			cli = CliFactory.createCli(StartupArguments.class);
			parsedArguments = cli.parseArguments(args);
		} catch (ArgumentValidationException e) {
			System.err.println(e);
			return;
		}
		Gpx2GPolygon conversion;
		try {
			conversion = new Gpx2GPolygon(GpxFactory.fromFile(
					parsedArguments.path()).getTrackpoints());
			System.out.println(conversion.process());

		} catch (IllegalArgumentException e) {
			System.err.println(e);
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}

	}

}
