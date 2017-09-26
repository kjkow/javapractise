package chapter5;

import javafx.beans.property.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamil on 2017-09-26.
 * Look how these useless comments destroy your view of these two variables, check class ProperReporterConfiguration and find out which is better
 */
public class ReporterConfiguration {
    /**
     * Report listener class name
     */
    private String className;

    /**
     * Report listener properties
     */
    private List<Property> properties = new ArrayList<Property>();

    public void addProperty(Property property){
        properties.add(property);
    }
}
