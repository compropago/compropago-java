/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compropago.sdk.models;

/**
 *
 * @author Arthur
 */
public class Instructions {
    public String description;
    public String step_1;
    public String step_2;
    public String step_3;
    public String note_extra_comition;
    public String note_expiration_date;
    public String note_confirmation;
    public InstructionDetails details;
    
    public Instructions(){
        this.details = new InstructionDetails();
    }
}
