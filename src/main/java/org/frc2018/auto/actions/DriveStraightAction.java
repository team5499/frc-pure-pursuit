package org.frc2018.auto.actions;

import org.frc2018.auto.routines.Routine;
import org.frc2018.auto.routines.Routine.RoutineTag;
import org.frc2018.subsystems.Drivetrain;

public class DriveStraightAction extends Action {

    private double m_target_inches;

    public DriveStraightAction(double timeout, double inches) {
        super(timeout);
        m_target_inches = inches;
    }

    @Override
    public void start() {
        super.start();
        Drivetrain.getInstance().setPosition(m_target_inches);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void reset() {
        super.reset();
    }

    @Override
    protected boolean timedOut() {
        return super.timedOut();
    }

    @Override
    public RoutineTag next() {
        if(timedOut()) return Routine.CURRENT_ROUTINE;
        if(Math.abs(Drivetrain.getInstance().getPositionError()) < 2.0) {
            return Routine.CURRENT_ROUTINE;
        }
        return Routine.NOT_FINISHED;
    }

    @Override
    public void finish() {
        super.finish();
    }

}