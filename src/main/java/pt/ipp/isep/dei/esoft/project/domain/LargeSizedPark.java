package pt.ipp.isep.dei.esoft.project.domain;
import java.util.Locale;

/**
 * This class extends the GreenSpace class and represents a large-sized park.
 */
public  class LargeSizedPark extends GreenSpace {

    /**
     * Constructs a new LargeSizedPark with the given name, area, and email.
     *
     * @param name  the name of the park
     * @param area  the area of the park
     * @param email the email address of the park
     */
    public LargeSizedPark(String name, double area, String email) {
        super(name, area, GreenSpaceType.LARGE_SIZED_PARK, email);
    }

    /**
     * This method is overridden from the GreenSpace class to display details about a large-sized park.
     *
     * @return a string containing details about the large-sized park
     */
    public String displayDetails() {
        return String.format(Locale.ENGLISH, "%s: %s, Area: %.1f sqm", this.getType(), this.getName(), this.getArea());
    }
}