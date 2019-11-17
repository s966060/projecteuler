package org.fde.projecteuler.problem_679.fail_fast.state_machine;

public class Machines {
    private final MachineFree free;
    private final MachineReef reef;
    private final MachineArea area;
    private final MachineFare fare;

    public Machines() {
        this.free = new MachineFree();
        this.reef = new MachineReef();
        this.area = new MachineArea();
        this.fare = new MachineFare();
    }

    public void push(char ch) {
        this.free.push(ch);
        this.reef.push(ch);
        this.area.push(ch);
        this.fare.push(ch);
    }

    public void pop() {
        this.free.pop();
        this.reef.pop();
        this.area.pop();
        this.fare.pop();
    }

    public boolean hasAll() {
        boolean hasAll =   this.free.getCurrentCursor().hasOne()
                        && this.reef.getCurrentCursor().hasOne()
                        && this.area.getCurrentCursor().hasOne()
                        && this.fare.getCurrentCursor().hasOne();

        return hasAll;
    }

    public boolean isValid() {
        boolean isValid =  this.free.getCurrentCursor().isValid()
                        && this.reef.getCurrentCursor().isValid()
                        && this.area.getCurrentCursor().isValid()
                        && this.fare.getCurrentCursor().isValid();

        return isValid;
    }
}
