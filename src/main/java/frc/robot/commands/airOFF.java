package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class airOFF extends CommandBase{
    private final CannonSS m_clawss;

    public airOFF(CannonSS subsytem){
        m_clawss = subsytem;
        addRequirements(m_clawss);
    }

    @Override
    public void initialize(){
        m_clawss.airOFF();
    }

    @Override
    public void end(boolean interrupted){
    }
}
