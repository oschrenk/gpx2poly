package gpx2poly.ui.cmd;

import java.io.File;

import uk.co.flamingpenguin.jewel.cli.CommandLineInterface;
import uk.co.flamingpenguin.jewel.cli.Unparsed;

/**
 * Defines the arguments for this application
 *
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 *
 */
@CommandLineInterface(application = "gpx2poly")
public interface StartupArguments {

	/**
	 * @return the path to the input gpx file
	 */
	@Unparsed
	File path();

}
