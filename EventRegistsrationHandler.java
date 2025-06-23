//create this class is to accept all needed data, perform fee calculation, show breakdown panel
import javax.swing.*;

//pass Event instead of EventManager as i only needs one event that selected by user
//else, it breaks the single responsibility principle
public class EventRegistsrationHandler {
    private final Event event; //put final make sure variable cannot be changed once assigned
    private final int pax;
    private final boolean transportSelected; //pass transportSelected instead of transportOption, as i want to know either true or false
    private final boolean cateringSelected;

    public EventRegistsrationHandler(Event event, int pax, boolean transportSelected, boolean cateringSelected){
        this.event = event; //use this to save a value inside event, but not from the bracket ( event in bracket != this.event)
        this.pax = pax;
        this.transportSelected = transportSelected;
        this.cateringSelected = cateringSelected;
    }

    



}

