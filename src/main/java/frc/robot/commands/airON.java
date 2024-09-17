package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class airON extends CommandBase{
    private final CannonSS m_clawss;

    public airON(CannonSS subsytem){
        m_clawss = subsytem;
        addRequirements(m_clawss);
    }

    @Override
    public void initialize(){
        m_clawss.airON();
    }

    @Override
    public void end(boolean interrupted){
    }
}
