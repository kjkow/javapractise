package chapter5;

import javafx.beans.property.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamil on 2017-09-26.
 */
public class ProperReporterConfiguration {

    private String className;
    private List<Property> properties = new ArrayList<Property>();

    public void addProperty(Property property){
        properties.add(property);
    }
}
