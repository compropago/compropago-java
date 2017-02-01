package compropagosdk.factory.models;


public class Instructions {

    public String description;
    public String step_1;
    public String step_2;
    public String step_3;
    public String note_extra_comition;
    public String note_expiration_date;
    public String note_confirmation;
    public InstructionDetails details;

    public Instructions() {
        details = new InstructionDetails();
    }

}
