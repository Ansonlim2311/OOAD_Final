package model;
//create composite 
import java.util.ArrayList;
import java.util.List;

import interfaces.FeeComponent;

public class FeeGroup implements FeeComponent {
    private final List<FeeComponent> components = new ArrayList<>();

    public void add(FeeComponent component) {
        components.add(component);
    }

    @Override
    public double getFee() {
        return components.stream().mapToDouble(FeeComponent::getFee).sum();
    }

    @Override
    public String getDescription() {
        return "Total of all selected services";
    }

    public List<FeeComponent> getComponents() {
        return components;
    }
}