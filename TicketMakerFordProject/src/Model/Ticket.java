/**************************************************************
* Name        : Ticket
* Author      : Paul Ford
* Created     : 5/7/2020
* Course      : CIS 152 Data Structures
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : Ticket that holds information for and IT help
                desk.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/
package Model;

import java.util.Comparator;
import java.util.Date;

public class Ticket implements Comparator<Ticket> {
    public String description;
    private String locationCode;
    private int regNumber;
    private Date time;
    private int priority;
    // constructors

    public Ticket(Date timePlaced, int registerNumber, String location, String description, int prio) {
        this.priority = prio;
        this.time = timePlaced;
        this.regNumber = registerNumber;
        this.locationCode = location;
        this.description = description;
    }

    public Ticket() {
    }

    // getter,setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Ticket [description=" + description + ", locationCode=" + locationCode + ", priority=" + priority
                + ", regNumber=" + regNumber + ", time=" + time + "]\n";
    }

    @Override
    public int compare(Ticket a, Ticket b) {
        return a.priority - b.priority;
    }

}